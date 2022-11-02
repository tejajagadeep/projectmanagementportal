package com.cts.projectmanagementportalbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.projectmanagementportalbackend.model.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, String>{

}
