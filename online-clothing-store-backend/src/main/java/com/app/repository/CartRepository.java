package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{
	
	//@Query("select * from shopping_cart where customer_id=?1")
	//List<Cart> findByCustomerId(Integer customerId);
	
}
