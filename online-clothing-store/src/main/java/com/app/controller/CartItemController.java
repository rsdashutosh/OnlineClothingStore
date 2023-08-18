package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.CartItemDto;
import com.app.service.CartItemService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/CartItem")
public class CartItemController {

	@Autowired
	CartItemService cartItemService;
	
	
	// POST
	@PostMapping
	public ResponseEntity<?> addCartItem(@RequestBody CartItemDto cartItemDto)
	{
		return ResponseEntity.status(HttpStatus.OK).body(cartItemService.addCartItem(cartItemDto));
	}
	
	// READ 1 cart items
	public ResponseEntity<?> getCartItem(@PathVariable Integer cartItemId)
	{
		return ResponseEntity.status(HttpStatus.FOUND).body(cartItemService.getCartItem(cartItemId));
	}
	
	// READ all cart items of a customer 
	public ResponseEntity<?> getAllCartItemsOfACustomer(@PathVariable Integer customerId)
	{
		return ResponseEntity.status(HttpStatus.FOUND).body(cartItemService.getCartItemsOfACustomer(customerId));
	}
	
	
	// UPDATE 
	public ResponseEntity<?> updateCartItem(@PathVariable Integer cartItemId,@RequestBody CartItemDto cartItemDto)
	{
		return ResponseEntity.status(HttpStatus.OK).body(cartItemService.updateCartItem(cartItemId, cartItemDto));
	}
	
	// DELETE
	public ResponseEntity<?> deleteCartItem(@PathVariable Integer cartItemId)
	{
		return ResponseEntity.status(HttpStatus.OK).body(cartItemService.deleteCartItem(cartItemId));
	}
	
}
