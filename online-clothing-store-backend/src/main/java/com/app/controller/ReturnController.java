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
@RequestMapping("/Return")
@CrossOrigin(origins = "http://localhost:3000")
public class ReturnController {
	
	@Autowired
	ReturnService returnService;

	@PostMapping("/")
	public ResponseEntity<?> addReturn(@Valid @RequestBody ReturnAndExchangeDTO returnAndExchangeDto) {

		return ResponseEntity.status(HttpStatus.OK).body(returnService.addReturn(returnAndExchangeDto));
	}

	@GetMapping("/{returnId}")
	public ResponseEntity<ReturnAndExchangeDTO> getReturnById(@PathVariable Integer returnId) {
		return new ResponseEntity<ReturnAndExchangeDTO>(returnService.getReturn(returnId), HttpStatus.OK);
	}
	
	@PutMapping("/{returnId}")
	public ResponseEntity<?> updateReturnDetails(@Valid @PathVariable Integer returnId,@RequestBody ReturnAndExchangeDTO returnAndExchangeDto){
		return ResponseEntity.status(HttpStatus.OK).body(returnService.updateReturnDetails(returnId,returnAndExchangeDto));
	}
	
	@DeleteMapping("/{returnId}")
	public ResponseEntity<?> deleteReturn(@PathVariable Integer returnId){
		return ResponseEntity.status(HttpStatus.OK).body(returnService.deleteReturn(returnId));
	}
}
