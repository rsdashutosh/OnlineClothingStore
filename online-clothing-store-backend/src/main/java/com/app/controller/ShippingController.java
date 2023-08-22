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

import com.app.dtos.ShippingDTO;
import com.app.service.ShippingService;

@RestController
@RequestMapping("/shipping")
@CrossOrigin(origins = "http://localhost:3000")
public class ShippingController {

	@Autowired
	ShippingService shippingService;
	
	@PostMapping("/")
	public ResponseEntity<?> addShipping(@Valid @PathVariable ShippingDTO shippingDTO)
	{
		return ResponseEntity.status(HttpStatus.OK).body(shippingService.addShipping(shippingDTO));
	}
	
	@GetMapping("/{shippingId}")	
	public ResponseEntity<?> getShipping(@PathVariable Integer shippingId)
	{
		return new ResponseEntity<ShippingDTO> (shippingService.getShipping(shippingId),HttpStatus.FOUND);
		
	}
	
	@PutMapping("/{shippingId}")
    public ResponseEntity<?> editShipping(@Valid @PathVariable Integer shippingId,@RequestBody ShippingDTO shippingDTO)
    {
    	return ResponseEntity.status(HttpStatus.OK).body(shippingService.editShipping(shippingId, shippingDTO));
    }
	
	@DeleteMapping("/{shippingId}")
	public ResponseEntity<?> deleteShipping(@PathVariable Integer shippingId)
	{
		return ResponseEntity.status(HttpStatus.OK).body(shippingService.deleteShipping(shippingId));
	}
    
	
	
}
