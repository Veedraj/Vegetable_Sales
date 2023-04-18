package com.vegetable.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CustomerLoginDTO {

	@NotBlank(message = "Customer email cannot be blank")
	@Email(message = "Customer email should be in valid format")
	private String customerEmail;

	@NotBlank(message = "Customer password cannot be blank")
	private String customerPassword;

	public CustomerLoginDTO() {
		super();
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public CustomerLoginDTO(
			@NotBlank(message = "Customer email cannot be blank") @Pattern(regexp = "/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$/", message = "Customer email should be in valid format") String customerEmail,
			@NotBlank(message = "Customer password cannot be blank") String customerPassword) {
		super();
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
	}

	@Override
	public String toString() {
		return "CustomerLoginDTO [customerEmail=" + customerEmail + ", customerPassword=" + customerPassword + "]";
	}
}
