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
	
	
	// POST
	@PostMapping("/")
	public ResponseEntity<?> addCart(@Valid @RequestBody CartDTO cartDto)
	{
		return ResponseEntity.status(HttpStatus.OK).body(cartService.addCart(cartDto));
	}
	
	// 
	@GetMapping("/{cartId}")
	public ResponseEntity<?> getCart(@PathVariable Integer cartId)
	{
		return ResponseEntity.status(HttpStatus.FOUND).body(cartService.getCart(cartId));
	}
	
	// UPDATE 
	@PutMapping("/{cartId}")
	public ResponseEntity<?> updateCart(@Valid @PathVariable Integer cartId,@RequestBody CartDTO cartDto)
	{
		return ResponseEntity.status(HttpStatus.OK).body(cartService.updateCart(cartId, cartDto));
	}
	
	// DELETE
	@DeleteMapping("/{cartId}")
	public ResponseEntity<?> deleteCart(@PathVariable Integer cartId)
	{
		return ResponseEntity.status(HttpStatus.OK).body(cartService.deleteCart(cartId));
	}
	
}
