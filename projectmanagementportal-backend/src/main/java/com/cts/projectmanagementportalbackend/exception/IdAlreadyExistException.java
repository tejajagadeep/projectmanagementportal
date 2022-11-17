package com.cts.projectmanagementportalbackend.exception;

public class IdAlreadyExistException extends RuntimeException{
	
	/**
	 * UsernameAlreadyExists Exception
	 */
	private static final long serialVersionUID = 1L;

	public IdAlreadyExistException(String msg) {

		super(msg);
	}
}
