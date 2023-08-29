package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.UserDTO;
import com.app.dtos.UserLoginDTO;
import com.app.dtos.UserResponseDTO;
import com.app.exception.ResourceNotFoundException;
import com.app.pojos.User;
import com.app.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private UserRepository userRepo;

	// POST
	@Override
	public String addUser(UserDTO userDto) {
		User user = mapper.map(userDto, User.class);
		User persistantUser = userRepo.save(user);
		return persistantUser.getFirstName()+" "+persistantUser.getLastName();
	}

	// GET user by ID
	@Override
	public UserDTO getUser(Integer userId) {
		User user = userRepo.findById(userId).get();
		UserDTO userDto = mapper.map(user, UserDTO.class);
		return userDto;
	}
	
	// User Authentication
	@Override
	public String userLogin(String email,String password) {
		User user = userRepo.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("user not registered!"));
		if(user.getPassword().equals(password))
			return "login successful";
		else
			return "login failed";
	}
	
	// GET all users
	@Override
	public List<UserResponseDTO> getAllUsers() {
		List<User> users = userRepo.findAll();
		return users.stream().map(user->mapper.map(user, UserResponseDTO.class)).collect(Collectors.toList());
	}

	// PUT
	@Override
	public String updateUserDetails(Integer userId,UserDTO userDto) {
		User persistantUser=userRepo.findById(userId).get();
		mapper.map(userDto, persistantUser);
		return persistantUser.getFirstName()+" "+persistantUser.getLastName()+"updated!";
	}

	// DELETE
	@Override
	public String deleteUser(Integer userId) {
		userRepo.deleteById(userId);
		return "Deleted successfully";
	}

	
	
	
	
	
	
	
	
	/*
	 * public User dtoToUser(UserDto userDto) { User user =
	 * new User(); user.setFirstName(userDto.getFirstName()); return
	 * user; }
	 * 
	 * public UserDto userToDto(User user) { UserDto userDto
	 * = new UserDto(); userDto.setFirstName(user.getFirstName());
	 * return userDto; }
	 */

}
