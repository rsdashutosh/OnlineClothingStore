package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.CartItemDto;
import com.app.service.CartItemService;



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
	@GetMapping("/{cartItemId}")
	public ResponseEntity<?> getCartItem(@PathVariable Integer cartItemId)
	{
		return ResponseEntity.status(HttpStatus.FOUND).body(cartItemService.getCartItem(cartItemId));
	}
	
	// READ all cart items of a customer 
	@GetMapping
	public ResponseEntity<?> getAllCartItemsOfACustomer(@PathVariable Integer customerId)
	{
		return ResponseEntity.status(HttpStatus.FOUND).body(cartItemService.getCartItemsOfACustomer(customerId));
	}
	
	
	// UPDATE 
	@PutMapping
	public ResponseEntity<?> updateCartItem(@PathVariable Integer cartItemId,@RequestBody CartItemDto cartItemDto)
	{
		return ResponseEntity.status(HttpStatus.OK).body(cartItemService.updateCartItem(cartItemId, cartItemDto));
	}
	
	// DELETE
	@DeleteMapping
	public ResponseEntity<?> deleteCartItem(@PathVariable Integer cartItemId)
	{
		return ResponseEntity.status(HttpStatus.OK).body(cartItemService.deleteCartItem(cartItemId));
	}
	
}
