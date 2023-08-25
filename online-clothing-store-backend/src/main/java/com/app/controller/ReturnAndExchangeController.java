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

import com.app.dtos.ReturnAndExchangeDTO;
import com.app.service.ReturnService;

@RestController
@RequestMapping("/return")
@CrossOrigin(origins = "http://localhost:3000")
public class ReturnAndExchangeController {
	@Autowired
	ReturnService returnAndExchangeService;

	// Post end-point for adding a new returnAndExchange
	@PostMapping("/")
	public ResponseEntity<?> addReturnAndExchange(@Valid @RequestBody ReturnAndExchangeDTO returnAndExchangeDTO) {
		return ResponseEntity.status(HttpStatus.OK).body(returnAndExchangeService.addReturnAndExchange(returnAndExchangeDTO));
	}

	@GetMapping("/{returnAndExchangeId}")
	public ResponseEntity<ReturnAndExchangeDTO> getReturnAndExchangeById(@PathVariable Integer returnAndExchangeId) {
		return new ResponseEntity<ReturnAndExchangeDTO>(returnAndExchangeService.getReturnAndExchange(returnAndExchangeId), HttpStatus.OK);
	}
	
	@PutMapping("/{returnAndExchangeId}")
	public ResponseEntity<?> updateReturnAndExchangeDetails(@Valid @PathVariable Integer returnAndExchangeId,@RequestBody ReturnAndExchangeDTO returnAndExchangeDto){
		return ResponseEntity.status(HttpStatus.OK).body(returnAndExchangeService.updateReturnAndExchangeDetails(returnAndExchangeId,returnAndExchangeDto));
	}
	
	@DeleteMapping("/{returnAndExchangeId}")
	public ResponseEntity<?> deleteReturnAndExchange(@PathVariable Integer returnAndExchangeId){
		return ResponseEntity.status(HttpStatus.OK).body(returnAndExchangeService.deleteReturnAndExchange(returnAndExchangeId));
	}
}
