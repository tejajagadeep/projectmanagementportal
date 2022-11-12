package com.cts.projectmanagementportalbackend.jwt;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.projectmanagementportalbackend.ProjectmanagementportalBackendApplication;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;

	Logger log = LoggerFactory.getLogger(ProjectmanagementportalBackendApplication.class);
	
	public JwtResponse(String jwttoken) {
		log.info("inside JwtResponse of JwtResponse");
		this.jwttoken = jwttoken;
	}

	public String getToken() {

		log.info("inside getToken of JwtResponse");
		return this.jwttoken;
	}
}