package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CustomerDto;
import com.app.service.CustomerService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping
	public ResponseEntity<String> addCustomer(@RequestBody CustomerDto customerDto) {
		try
		{
			String response=customerService.addCustomerDetails(customerDto);
			return ResponseEntity.status(HttpStatus.OK).body(response);	
		}
		catch(RuntimeException e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getStackTrace().toString());
		}
		
	    
	}
	
	
}
