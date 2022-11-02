package com.cts.projectmanagementportalbackend.exception;

public class ElementAlreadyExistException extends Exception{
	
	/**
	 * UsernameAlreadyExists Exception
	 */
	private static final long serialVersionUID = 1L;

	public ElementAlreadyExistException(String msg) {

		super(msg);
	}
}
