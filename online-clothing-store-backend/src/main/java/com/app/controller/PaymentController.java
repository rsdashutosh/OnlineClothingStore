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

import com.app.dtos.PaymentDTO;
import com.app.service.PaymentService;

@RestController
@RequestMapping("/Payment")
@CrossOrigin(origins = "http://localhost:3000")
public class PaymentController {
	@Autowired
	PaymentService paymentService;

	@PostMapping("/")
	public ResponseEntity<?> addPayment(@Valid @RequestBody PaymentDTO paymentDto) {

		return ResponseEntity.status(HttpStatus.OK).body(paymentService.addPayment(paymentDto));
	}

	@GetMapping("/{paymentId}")
	public ResponseEntity<PaymentDTO> getPaymentById(@PathVariable Integer paymentId) {
		return new ResponseEntity<PaymentDTO>(paymentService.getPayment(paymentId), HttpStatus.OK);
	}
	
	@PutMapping("/{paymentId}")
	public ResponseEntity<?> updatePaymentDetails(@Valid @PathVariable Integer paymentId,@RequestBody PaymentDTO paymentDto){
		return ResponseEntity.status(HttpStatus.OK).body(paymentService.updatePaymentDetails(paymentId,paymentDto));
	}
	
	@DeleteMapping("/{paymentId}")
	public ResponseEntity<?> deletePayment(@PathVariable Integer paymentId){
		return ResponseEntity.status(HttpStatus.OK).body(paymentService.deletePayment(paymentId));
	}
}
