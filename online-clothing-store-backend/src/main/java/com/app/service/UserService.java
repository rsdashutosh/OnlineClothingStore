package com.app.service;

import java.util.List;
import com.app.dtos.UserDTO;

public interface UserService {

	public String addUser(UserDTO userDTO);
	public UserDTO getUser(Integer userId);
	public List<UserDTO> getAllUsers();
	public String updateUserDetails(Integer userId, UserDTO userDTO);
	public String deleteUser(Integer userId);
	public UserDTO getUserByEmail(String email);
	
}
