package com.cts.projectmanagementportalbackend.exception;

public class TeamSizeExcedsException extends Exception{

	private static final long serialVersionUID = 1L;

	public TeamSizeExcedsException(String msg){
		super(msg);
	}
}
