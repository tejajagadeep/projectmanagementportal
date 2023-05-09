package com.cts.projectmanagementportalbackend.exception;

public class InvalidUserIdOrPasswordException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidUserIdOrPasswordException(String msg){
		super(msg);
	}
	
}

