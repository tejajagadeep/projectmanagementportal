package com.cts.projectmanagementportalbackend.model;



public class HelloWorld {
	private String message;
	private int id;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public HelloWorld(String message, int id) {
		super();
		this.message = message;
		this.id = id;
	}
	
}
