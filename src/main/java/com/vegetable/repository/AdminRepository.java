package com.vegetable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vegetable.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{

}
