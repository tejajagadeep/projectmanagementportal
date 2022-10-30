package com.cts.projectmanagementportalbackend.exception;

public class UsernameAlreadyExists extends Exception{
	
	/**
	 * UsernameAlreadyExists Exception
	 */
	private static final long serialVersionUID = 1L;

	public UsernameAlreadyExists(String msg) {

		super(msg);
	}
}
