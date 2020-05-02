package com.mycoursework.tasker.configs.security.facade;

import com.mycoursework.tasker.configs.security.UserDetailsImpl;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade implements IAuthenticationFacade{

	@Override
	public Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	@Override
	public String getUserId() {
		Authentication auth = getAuthentication();
		if (auth instanceof UsernamePasswordAuthenticationToken) {
			UserDetailsImpl userDetails = (UserDetailsImpl) auth.getPrincipal();
			return userDetails.getId();
		}
		return null;
	}
}
