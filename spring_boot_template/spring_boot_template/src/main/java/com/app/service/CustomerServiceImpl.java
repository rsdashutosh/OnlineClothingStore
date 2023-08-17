package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.CustomerDto;
import com.app.entities.Customer;
import com.app.repository.CustomerRepository;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private CustomerRepository customerRepo;
	
	// method to add customer details into database  --- POST 
	@Override
	public String addCustomerDetails(CustomerDto customerDto) {
		// map Dto object to Customer Entity
		Customer customer=mapper.map(customerDto, Customer.class);
		Customer persistantCustomer=customerRepo.save(customer);
		
		return persistantCustomer.getFirstName()+" "+persistantCustomer.getLastName();
	}

}
