package com.cts.projectmanagementportalbackend.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@NotNull
	private String userName;
	
	@NotNull
	private String password;
	private String role;
//	private String roleDescription;
//	
//	@OneToMany(cascade=CascadeType.ALL)
//    @JoinColumn(name="role_Id")
//	private Set<User> users;
	
	
}