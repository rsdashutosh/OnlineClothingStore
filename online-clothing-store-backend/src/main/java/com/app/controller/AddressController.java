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

import com.app.dtos.AddressDto;
import com.app.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	@Autowired
	AddressService addressService;
	
	@PostMapping("/")
	public ResponseEntity<?> addAddress(@RequestBody AddressDto addressDto){
		return ResponseEntity.status(HttpStatus.OK).body(addressService.addAddress(addressDto));
	}
	
	/*
	 * @GetMapping("/{customerId}") public ResponseEntity<?>
	 * getAddress(@PathVariable Integer customerId){ return
	 * ResponseEntity.status(HttpStatus.FOUND).body(addressService.getAddressById(
	 * customerId)); }
	 */
	
	@PutMapping("/{addressId}")
	public ResponseEntity<?> updateAddress(@PathVariable Integer addressId,@RequestBody AddressDto addressDto){
		return ResponseEntity.status(HttpStatus.OK).body(addressService.updateAddress(addressId,addressDto));
	}
	
	@DeleteMapping("/{addressId}")
	public ResponseEntity<?> deleteAddress(@PathVariable Integer addressId){
		return ResponseEntity.status(HttpStatus.OK).body(addressService.deleteAddress(addressId));
	}
}
