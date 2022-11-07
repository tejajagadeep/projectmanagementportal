package com.cts.projectmanagementportalbackendauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.projectmanagementportalbackendauth.model.AppClient;

public interface ClientRepository extends JpaRepository<AppClient, Integer>{
	
	AppClient findByClientId(String clientId);

}
