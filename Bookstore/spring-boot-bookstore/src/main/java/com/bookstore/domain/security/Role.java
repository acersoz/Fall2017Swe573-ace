package com.bookstore.domain.security;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role implements Serializable{
	
	private static final long serialVersionUID = 890245234L;
	
	@Id
	private int roleId;
	
	private String name;
	
	private Set<UserRole> userRoles = new HashSet<>();
	
	public Role(){}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	
	
}


/*package com.bookstore.domain.security;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;

import javassist.SerialVersionUID;

@Entity
public class Role implements Serializable {
	
	private static final long SerialVersionUID = 890245234L;
	
	@Id
	private int roleId;
	
	public int getRoleId() {
		return roleId;
	}

	private String name;
	
	private Set<UserRole> userRoles = new HashSet<>();
	
	public Role(){}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	

}*/
