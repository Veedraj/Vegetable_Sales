package com.vegetable.config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vegetable.entity.Customer;
import com.vegetable.repository.CustomerRepository;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer customer = customerRepository.findByCustomerEmail(username);
		return new User(customer.getCustomerEmail(), customer.getCustomerPassword(), new ArrayList<>());
	}

}
