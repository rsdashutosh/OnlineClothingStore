package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Integer>{

	List<CartItem> findBycustomerId(Integer customerId);
	
}
