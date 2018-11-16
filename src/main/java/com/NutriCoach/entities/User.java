package com.NutriCoach.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="fisrtname",nullable=false,length=40)
	private String firstName;
	@Column(name="lastname",nullable=false,length=40)
	private String lastName;
	@Column(name="email",nullable=false,length=40)
	private String email;
	@Column(name="password",nullable=false,length=40)
	private String password;
	@Column(name="permissionlevel",nullable=false)
	private Integer permissionLevel;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPermissionLevel() {
		return permissionLevel;
	}

	public void setPermissionLevel(Integer permissionLevel) {
		this.permissionLevel = permissionLevel;
	}

}
