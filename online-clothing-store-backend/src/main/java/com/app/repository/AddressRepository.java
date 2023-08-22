package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Address;
import com.app.pojos.User;

public interface AddressRepository extends JpaRepository<Address, Integer> {
	
	public List<Address> findAll();
	public List<Address> findAllByUserEmail(String email);
}
