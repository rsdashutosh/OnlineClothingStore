package com.app.controller;

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

import com.app.dtos.CustomerDto;
import com.app.service.CustomerService;

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping("/")
	public ResponseEntity<?> addCustomer(@RequestBody CustomerDto customerDto) {

		return ResponseEntity.status(HttpStatus.OK).body(customerService.addCustomer(customerDto));
	}

	@GetMapping("/customer_id/{customerId}")
	public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Integer customerId) {
		return new ResponseEntity<CustomerDto>(customerService.getCustomer(customerId), HttpStatus.OK);
	}
	
	// fetching customer details by username/email
	@GetMapping("/email/{email}")
	public ResponseEntity<CustomerDto> getCustomerByEmail(@PathVariable String email) {
		return new ResponseEntity<CustomerDto>(customerService.getCustomerByEmail(email), HttpStatus.FOUND);
	}
	
	@PutMapping("/{customerId}")
	public ResponseEntity<?> updateCustomerDetails(@PathVariable Integer customerId,@RequestBody CustomerDto customerDto){
		return ResponseEntity.status(HttpStatus.OK).body(customerService.updateCustomerDetails(customerId,customerDto));
	}
	
	@DeleteMapping("/{customerId}")
	public ResponseEntity<?> deleteCustomer(@PathVariable Integer customerId){
		return ResponseEntity.status(HttpStatus.OK).body(customerService.deleteCustomer(customerId));
	}
}
