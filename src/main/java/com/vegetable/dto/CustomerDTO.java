package com.vegetable.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CustomerDTO {

	@NotEmpty(message = "Customer name should not be Empty")
	@Pattern(regexp = "^[a-zA-Z ]+$", message = "Customer name should contain only letters")
	private String customerName;
	@NotBlank(message = "Customer email cannot be blank")
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Customer email should be in valid format")
	private String customerEmail;
	@NotBlank(message = "Customer phone cannot be blank")
	@Pattern(regexp = "^[7-9]{1}[0-9]{9}$", message = "Number should contain only 10 digits ")
	private String customerPhone;
	@NotBlank(message = "Customer password cannot be blank")
	@Size(min = 8)
	private String customerPassword;

	public CustomerDTO() {
		super();
	}

	public CustomerDTO(
			@NotEmpty(message = "Customer name should not be Empty") @Pattern(regexp = "^[a-zA-z]+$", message = "Customer name should contain only letters") String customerName,
			@NotBlank(message = "Customer email cannot be blank") @Pattern(regexp = "/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$/", message = "Customer email should be in valid format") String customerEmail,
			@NotBlank(message = "Customer phone cannot be blank") @Pattern(regexp = "^[7-9]{1}[0-9]{9}$", message = "Number should contain only 10 digits ") String customerPhone,
			@NotBlank(message = "Customer password cannot be blank") @Size(min = 8) String customerPassword) {
		super();
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
		this.customerPassword = customerPassword;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	@Override
	public String toString() {
		return "CustomerDTO [customerName=" + customerName + ", customerEmail=" + customerEmail + ", customerPhone="
				+ customerPhone + ", customerPassword=" + customerPassword + "]";
	}

}
