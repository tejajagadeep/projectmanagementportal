package com.cts.projectmanagementportalbackend.security.jwt.resource;


public class AuthenticationException extends RuntimeException {
	public AuthenticationException(String message, Throwable cause) {
		super(message, cause);
	}
}
