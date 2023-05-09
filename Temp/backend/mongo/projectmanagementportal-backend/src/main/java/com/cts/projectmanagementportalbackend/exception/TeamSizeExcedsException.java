package com.cts.projectmanagementportalbackend.exception;

public class TeamSizeExcedsException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public TeamSizeExcedsException(String msg){
		super(msg);
	}
}
