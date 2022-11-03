package com.cts.projectmanagementportalbackend.exception;

public class InvalidUserIdOrPasswordException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidUserIdOrPasswordException(String msg){
		super(msg);
	}
	
}

