package com.app.controller;

import java.util.List;

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
import com.app.dtos.PaymentResponseDTO;
import com.app.service.PaymentService;

@RestController
@RequestMapping("/payments")
@CrossOrigin(origins = "http://localhost:3000")
public class PaymentController {
	@Autowired
	PaymentService paymentService;

	// Post end-point for adding a new payment
	@PostMapping("/")
	public ResponseEntity<?> addPayment(@Valid @RequestBody PaymentDTO paymentDTO) {
		return ResponseEntity.status(HttpStatus.OK).body(paymentService.addPayment(paymentDTO));
	}
	
	@GetMapping
	public ResponseEntity<?> getAllPayments() {
		return new ResponseEntity<List<PaymentResponseDTO>>(paymentService.getAllPayments(), HttpStatus.OK);
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
