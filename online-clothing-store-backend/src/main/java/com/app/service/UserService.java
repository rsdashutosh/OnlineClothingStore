package com.app.service;

import java.util.List;

import com.app.dtos.LoginResponseDTO;
import com.app.dtos.UserDTO;
import com.app.dtos.UserLoginDTO;
import com.app.dtos.UserResponseDTO;

public interface UserService {

	public String addUser(UserDTO userDTO);
	public UserDTO getUser(Integer userId);
	public List<UserResponseDTO> getAllUsers();
	public String updateUserDetails(Integer userId, UserDTO userDTO);
	public String deleteUser(Integer userId);
	public LoginResponseDTO userLogin(String email,String password);
	
}
