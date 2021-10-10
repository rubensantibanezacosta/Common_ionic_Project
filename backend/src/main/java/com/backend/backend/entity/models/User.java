package com.backend.backend.entity.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	String email;
	String name;
	String password;
	String access;
	
	




	public User() {
	}
	

	public User(String email, String name, String password, String access) {
		this.email = email;
		this.name = name;
		this.password = password;
		this.access = access;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccess() {
		return this.access;
	}

	public void setAccess(String access) {
		this.access = access;
	}

	public User email(String email) {
		setEmail(email);
		return this;
	}

	public User name(String name) {
		setName(name);
		return this;
	}

	public User password(String password) {
		setPassword(password);
		return this;
	}

	public User access(String access) {
		setAccess(access);
		return this;
	}

}
