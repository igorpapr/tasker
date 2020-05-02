package com.mycoursework.tasker.configs.security;


import com.mycoursework.tasker.configs.Constants;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class JwtTokenProvider {

    @Autowired
    @Qualifier("userDetailsServiceImpl")
    private UserDetailsService userDetailsService;

    public String provideToken(String username) {
        UserDetailsImpl jwtUser = (UserDetailsImpl) userDetailsService.loadUserByUsername(username);
        Date now = new Date(System.currentTimeMillis());
        Date expiryDate = new Date(now.getTime() + Constants.EXPIRATION_TIME);
        String userId = jwtUser.getId();
        Map<String, Object> tokenBody = new HashMap<>();
        tokenBody.put("id", (userId));
        tokenBody.put("username", jwtUser.getUsername());
        tokenBody.put("email", jwtUser.getEmail());
        tokenBody.put("role", jwtUser.getRole().name());

        return Jwts.builder()
                .setSubject(userId)
                .setClaims(tokenBody)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, Constants.SECRET)
                .compact();
    }

    public Authentication getAuthentication(String token) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(getUsernameFromJwt(token));
        return new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(Constants.SECRET).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT Token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty");
        } catch (SignatureException ex) {
            log.error("Invalid JWT Signature");
        }
        return false;
    }

    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(Constants.HEADER_STRING);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(Constants.TOKEN_PREFIX)) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public Long getUserIdFromJwt(String token) {
        Claims claims = Jwts.parser().setSigningKey(Constants.SECRET).parseClaimsJws(token).getBody();
        String id = (String) claims.get("id");

        return Long.parseLong(id);
    }

    public String getUsernameFromJwt(String token) {
        Claims claims = Jwts.parser().setSigningKey(Constants.SECRET).parseClaimsJws(token).getBody();
        return (String) claims.get("username");
    }
}