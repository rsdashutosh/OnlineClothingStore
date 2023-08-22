package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
	
	public List<Address> findAllByUserUserId(Integer userId);

}
