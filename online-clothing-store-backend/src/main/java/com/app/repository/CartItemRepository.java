package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Integer>{
	
	//@Query("select * from shopping_cart where customer_id=?1")
	List<CartItem> findByCustomerId(Integer customerId);
	
}
