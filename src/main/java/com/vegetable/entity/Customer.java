package com.vegetable.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	@NotEmpty(message = "Customer name should not be Empty")
	@Pattern(regexp = "^[a-zA-z]+$", message = "Customer name should contain only letters")
	private String customerName;
	@NotBlank(message = "Customer email cannot be blank")
	@Pattern(regexp = "/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$/", message = "Customer email should be in valid format")
	private String customerEmail;
	@NotBlank(message = "Customer phone cannot be blank")
	@Pattern(regexp = "^[7-9]{1}[0-9]{9}$", message = "Number should contain only 10 digits ")
	private String customerPhone;
	@NotBlank(message = "Customer password cannot be blank")
	private String customerPassword;
	@NotBlank(message = "Customer address should not be blank")
	@Size(min = 5, max = 50)
	private String customerAddress;
	@NotNull(message = "Pincode cannot be null")
	@Pattern(regexp = "^[1-9]{1}[0-9]{2}\\s{0, 1}[0-9]{3}$", message = "Pincode must be of 6 digits and should not start with 0")
	private Integer customerPincode;
	@NotBlank(message = "Customer city cannot be null")
	private String customerCity;

	public Customer() {
		super();
	}

	public Customer(Long customerId,
			@NotEmpty(message = "Customer name should not be Empty") @Pattern(regexp = "^[a-zA-z]+$", message = "Customer name should contain only letters") String customerName,
			@NotBlank(message = "Customer email cannot be blank") @Pattern(regexp = "/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$/", message = "Customer email should be in valid format") String customerEmail,
			@NotBlank(message = "Customer phone cannot be blank") @Pattern(regexp = "^[7-9]{1}[0-9]{9}$", message = "Number should contain only 10 digits ") String customerPhone,
			@NotBlank(message = "Customer password cannot be blank") String customerPassword,
			@NotBlank(message = "Customer address should not be blank") @Size(min = 5, max = 50) String customerAddress,
			@NotNull(message = "Pincode cannot be null") @Pattern(regexp = "^[1-9]{1}[0-9]{2}\\s{0, 1}[0-9]{3}$", message = "Pincode must be of 6 digits and should not start with 0") Integer customerPincode,
			@NotBlank(message = "Customer city cannot be null") String customerCity) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
		this.customerPassword = customerPassword;
		this.customerAddress = customerAddress;
		this.customerPincode = customerPincode;
		this.customerCity = customerCity;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
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

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public Integer getCustomerPincode() {
		return customerPincode;
	}

	public void setCustomerPincode(Integer customerPincode) {
		this.customerPincode = customerPincode;
	}

	public String getCustomerCity() {
		return customerCity;
	}

	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

}