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

import com.app.dtos.UserDTO;
import com.app.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/")
	public ResponseEntity<?> addUser(@Valid @RequestBody UserDTO userDTO) {

		return ResponseEntity.status(HttpStatus.OK).body(userService.addUser(userDTO));
	}

	@GetMapping("/user_id/{userId}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable Integer userId) {
		return new ResponseEntity<UserDTO>(userService.getUser(userId), HttpStatus.OK);
	}
	
	// fetching user details by username/email
	@GetMapping("/email/{email}")
	public ResponseEntity<UserDTO> getUserByEmail(@PathVariable String email) {
		return new ResponseEntity<UserDTO>(userService.getUserByEmail(email), HttpStatus.FOUND);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<?> updateUserDetails(@Valid @PathVariable Integer userId,@RequestBody UserDTO userDTO){
		return ResponseEntity.status(HttpStatus.OK).body(userService.updateUserDetails(userId,userDTO));
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer userId){
		return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUser(userId));
	}
}
