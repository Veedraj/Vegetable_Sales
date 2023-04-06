package com.vegetable.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Customer {
	@Id
	@GeneratedValue
	private Long customerId;
	@NotEmpty(message = "Customer name should not be Empty")
	@Pattern(regexp = "^[a-zA-z]+$", message = "Customer name should contain only letters")
	private String customerName;
	@Email(message = "Customer email should be in valid format")
	private String customerEmail;
	@Pattern(regexp = "^[0-9]{10}$", message = "Number should contain only 10 digits ")
	private String customerPhone;
	@NotBlank(message = "Customer address should not be blank")
	private String customerAddress;
	@NotNull(message = "Pincode cannot be null")
	private Integer customerPincode;
	@NotBlank(message = "Customer city cannot be null")
	private String customerCity;

	public Customer() {
		super();
	}

	public Customer(Long customerId, String customerName, String customerEmail, String customerPhone,
			String customerAddress, Integer customerPincode, String customerCity) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
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