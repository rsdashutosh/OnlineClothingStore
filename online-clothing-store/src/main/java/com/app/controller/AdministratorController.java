package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.AdministratorDto;
import com.app.service.AdministratorService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/administrator")
public class AdministratorController {
	
	@Autowired 
	private AdministratorService adminService;
	
	// POST
	@PostMapping
	public ResponseEntity<?> addAdministrator(@RequestBody AdministratorDto administratorDto)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(adminService.addAdministrator(administratorDto));
	}
	
	// GET details of an administrator
	@GetMapping
	public ResponseEntity<?> getAdministrator(@PathVariable Integer administratorId)
	{
		return ResponseEntity.status(HttpStatus.FOUND).body(adminService.getAdministratorDetails(administratorId));
	}
	
	// GET details of all administrators 
	@GetMapping
	public ResponseEntity<?> getAllAdministrators()
	{
		return ResponseEntity.status(HttpStatus.FOUND).body(adminService.getAllAdministrators());
	}
	
	// UPDATE details of an administrator
	public ResponseEntity<?> updateAdministrator(@PathVariable Integer administratorId,@RequestBody AdministratorDto administratorDto)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(adminService.updateAdministratorDetails(administratorId, administratorDto));
	}
	
	// DELETE details of an administrator
	public ResponseEntity<?> deleteAdministrator(@PathVariable Integer administratorId)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(adminService.deleteAdministrator(administratorId));
	}
	

}
