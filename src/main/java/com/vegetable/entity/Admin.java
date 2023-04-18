package com.vegetable.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {
	@Id
	private Long adminId;
	private String adminName;
	private String adminPassword;

	public Admin() {
	}

	public Admin(String name, String password) {
		this.adminId = 1l;
		this.adminName = name;
		this.adminPassword = password;
	}
}
