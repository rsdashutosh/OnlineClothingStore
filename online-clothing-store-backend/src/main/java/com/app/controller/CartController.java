package com.app.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.CartDTO;
import com.app.service.CartService;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {
	
	 @Autowired
	    CartService cartService;

	    @PostMapping("/")
	    public ResponseEntity<?> addToCart(@Valid @RequestBody CartDTO cartDto) {
	        return ResponseEntity.status(HttpStatus.OK).body(cartService.addCart(cartDto));
	    }

	    @GetMapping("/{cartId}")
	    public ResponseEntity<CartDTO> getCartById(@PathVariable Integer cartId) {
	        return new ResponseEntity<CartDTO>(cartService.getCart(cartId), HttpStatus.OK);
	    }

	    @PutMapping("/user_id/{userId}/add_product/{productId}")
	    public ResponseEntity<?> addCartItem(@Valid @PathVariable Integer userId,@PathVariable Integer productId) {
	        return ResponseEntity.status(HttpStatus.OK).body(cartService.addItemToCart(userId, productId));
	    }
	    
	    @PutMapping("/user_id/{userId}/remove_product/{productId}")
	    public ResponseEntity<?> removeCartItem(@Valid @PathVariable Integer userId,@PathVariable Integer productId) {
	        return ResponseEntity.status(HttpStatus.OK).body(cartService.removeItemFromCart(userId, productId));
	    }
	    
	    @DeleteMapping("/{cartId}")  
	    public ResponseEntity<?> removeFromCart(@PathVariable Integer cartId) {
	        return ResponseEntity.status(HttpStatus.OK).body(cartService.removeCart(cartId));
	    }
	}
	


