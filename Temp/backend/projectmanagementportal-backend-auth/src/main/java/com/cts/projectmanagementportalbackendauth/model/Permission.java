package com.cts.projectmanagementportalbackendauth.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Table(name="permission")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Permission implements  Serializable{
	
	
	private static final long serialVersionUID = 8087275050725156377L;


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="permission_id")
	private int permissionId;
	
	@Column(name="permission_name")
	private String permissionName;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "permissions", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Set<Role> roles;

}
