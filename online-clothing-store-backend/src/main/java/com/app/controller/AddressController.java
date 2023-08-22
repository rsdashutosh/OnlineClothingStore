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

import com.app.dtos.AddressDTO;
import com.app.service.AddressService;

@RestController
@RequestMapping("/address")
@CrossOrigin(origins = "http://localhost:3000")
public class AddressController {
	@Autowired
	AddressService addressService;
	

	//Endpoint adds a new Address
	@PostMapping("/")
	public ResponseEntity<?> addAddress(@Valid @RequestBody AddressDTO addressDTO)
	{
		return ResponseEntity.status(HttpStatus.OK).body(addressService.addAddress(addressDTO));
	}
	
	
    // Get all Addresses of a User
    @GetMapping("/user_id/{userId}") 
    public ResponseEntity<?> getAddress(@PathVariable Integer userId) 
    { 
    	return ResponseEntity.status(HttpStatus.FOUND).body(addressService.getAddressesOfUserByUserId(userId)); }
	 
	 
	
	// Endpoint to update the details of an Address
	@PutMapping("/{addressId}")
	public ResponseEntity<?> updateAddress(@PathVariable Integer addressId,@Valid @RequestBody AddressDTO addressDto){
		return ResponseEntity.status(HttpStatus.OK).body(addressService.updateAddress(addressId,addressDto));
	}
	
	// Endpoint to delete an Address
	@DeleteMapping("/{addressId}")
	public ResponseEntity<?> deleteAddress(@PathVariable Integer addressId){
		return ResponseEntity.status(HttpStatus.OK).body(addressService.deleteAddress(addressId));
	}
}
