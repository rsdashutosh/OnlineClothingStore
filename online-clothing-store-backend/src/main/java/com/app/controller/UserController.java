package com.app.controller;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.dtos.UserDTO;
import com.app.dtos.UserLoginDTO;
import com.app.dtos.UserResponseDTO;
import com.app.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping
	public ResponseEntity<?> addUser(@Valid @RequestBody UserDTO userDTO) {

		return ResponseEntity.status(HttpStatus.OK).body(userService.addUser(userDTO));
	}
	
	@GetMapping
	public ResponseEntity<?> getAllUsers() {
		return new ResponseEntity<List<UserResponseDTO>>(userService.getAllUsers(), HttpStatus.OK);
	}

	@GetMapping(value="/user_id/{userId}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable Integer userId) {
		return new ResponseEntity<UserDTO>(userService.getUser(userId), HttpStatus.OK);
	}
	
	// authorizing the user details by username/email
	@PostMapping(value="/login")
	public ResponseEntity<String> getUserByEmail(@Valid @RequestBody UserLoginDTO userLoginDTO) {
		return new ResponseEntity<String>(userService.userLogin(userLoginDTO.getEmail(),userLoginDTO.getPassword()), HttpStatus.OK);
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
