package com.vegetable.dbinit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vegetable.entity.Admin;
import com.vegetable.repository.AdminRepository;

@Component
public class DbInit {
	@Autowired
	private AdminRepository adminRepository;

	@PostConstruct
	private void postConstruct() {
		Admin admin = new Admin("admin", "admin");
		adminRepository.save(admin);
	}
}