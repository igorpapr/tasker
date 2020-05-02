package com.mycoursework.tasker.configs;

public final class Constants {

    public static final String AUTH_URLS = "/api/auth/**";
    public static final String USERS_URLS = "/api/users**";

    public static final String SECRET = "SecretKeyToGenerateMyJWTokensPLEASEWORKPLEASEWORKPLEASEWORK321321321321321321321321321321";

    public static final long EXPIRATION_TIME = 300_000_000; //30 000 seconds

    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";


}
