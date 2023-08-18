package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
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
	
	@GetMapping("/{customerId}")
	public ResponseEntity<AddressDto> getAddress(@PathVariable Integer customerId){
		return new ResponseEntity<AddressDto>(addressService.getAddressById(customerId),HttpStatus.FOUND);
	}
	
	@PutMapping("/{customerId}")
	public ResponseEntity<?> updateAddress(@PathVariable Integer customerId,@RequestBody AddressDto addressDto){
		return ResponseEntity.status(HttpStatus.OK).body(addressService.updateAddress(customerId,addressDto));
	}
	
	@DeleteMapping("/{customerId}")
	public ResponseEntity<?> deleteAddress(@PathVariable Integer customerId){
		return ResponseEntity.status(HttpStatus.OK).body(addressService.deleteAddress(customerId));
	}
}
