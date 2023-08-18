package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.pojos.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

	//Optional<List<Address>> findByCustomerId(Integer customerId);

}
