package com.vegetable.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Login {

	@Email(regexp = "/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$/", message = "Please Enter Valid Email Address")
	private String userName;

	@Min(value = 8, message = "Please Enter 8 Characters Long Password")
	@Max(value = 8, message = "Please Enter 8 Characters Long Password")
	@NotBlank
	@NotNull
	private String userPassword;

	public Login() {
		super();
	}

	public Login(String userName, String userPassword) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
	}
}
