package com.vegetable.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	@NotEmpty(message = "Customer name should not be Empty")
	@Pattern(regexp = "^[a-zA-z]+$", message = "Customer name should contain only letters")
	private String customerName;
	@NotBlank(message = "Customer email cannot be blank")
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Customer email should be in valid format")
	private String customerEmail;
	@NotBlank(message = "Customer phone cannot be blank")
	@Pattern(regexp = "^[7-9]{1}[0-9]{9}$", message = "Number should contain only 10 digits ")
	private String customerPhone;
	@NotBlank(message = "Customer password cannot be blank")
	private String customerPassword;
	@Size(min = 5, max = 60)
	private String customerAddress;
	@Pattern(regexp = "^[1-9]{1}[0-9]{2}[0-9]{3}$", message = "Pincode must be of 6 digits and should not start with 0")
	private String customerPincode;
	@Size(min = 2, max = 30)
	private String customerCity;

	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cart_id")
	private Cart cart;

	@JsonManagedReference
	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Order> orders = new ArrayList<>();

	public Customer() {
		super();
	}

	public Customer(Long customerId,
			@NotEmpty(message = "Customer name should not be Empty") @Pattern(regexp = "^[a-zA-z]+$", message = "Customer name should contain only letters") String customerName,
			@NotBlank(message = "Customer email cannot be blank") @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Customer email should be in valid format") String customerEmail,
			@NotBlank(message = "Customer phone cannot be blank") @Pattern(regexp = "^[7-9]{1}[0-9]{9}$", message = "Number should contain only 10 digits ") String customerPhone,
			@NotBlank(message = "Customer password cannot be blank") String customerPassword,
			@Size(min = 5, max = 60) String customerAddress,
			@Pattern(regexp = "^[1-9]{1}[0-9]{2}[0-9]{3}$", message = "Pincode must be of 6 digits and should not start with 0") String customerPincode,
			@Size(min = 2, max = 30) String customerCity, Cart cart, List<Order> orders) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
		this.customerPassword = customerPassword;
		this.customerAddress = customerAddress;
		this.customerPincode = customerPincode;
		this.customerCity = customerCity;
		this.cart = cart;
		this.orders = orders;
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

	public String getCustomerPincode() {
		return customerPincode;
	}

	public void setCustomerPincode(String customerPincode) {
		this.customerPincode = customerPincode;
	}

	public String getCustomerCity() {
		return customerCity;
	}

	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + ", customerPhone=" + customerPhone + ", customerPassword=" + customerPassword
				+ ", customerAddress=" + customerAddress + ", customerPincode=" + customerPincode + ", customerCity="
				+ customerCity + ", cart=" + cart + ", orders=" + orders + "]";
	}

}