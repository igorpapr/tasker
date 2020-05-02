package com.mycoursework.tasker.configs.security.facade;

import org.springframework.security.core.Authentication;

public interface IAuthenticationFacade {

	Authentication getAuthentication();

	String getUserId();

}
