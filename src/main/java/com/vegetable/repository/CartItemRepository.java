package com.vegetable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vegetable.entity.Cart;
import com.vegetable.entity.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

	void deleteAllByCart(Cart cart);

}
