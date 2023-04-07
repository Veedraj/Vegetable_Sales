package com.vegetable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vegetable.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
