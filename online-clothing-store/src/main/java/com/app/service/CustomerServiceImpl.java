package com.app.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.CustomerDto;
import com.app.pojos.Customer;
import com.app.repository.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public String addCustomer(CustomerDto customerDto) {
		Customer customer = dtoToCustomer(customerDto);
		Customer persistantCustomer = customerRepo.save(customer);
		return persistantCustomer.getFirstName();
	}

	@Override
	public CustomerDto getCustomer(Integer customerId) {
		Optional<Customer> customer = customerRepo.findById(customerId);
		CustomerDto customerDto = customerToDto(customer.get());
		return customerDto;
	}

	public Customer dtoToCustomer(CustomerDto customerDto) {
		Customer customer = new Customer();
		customer.setFirstName(customerDto.getFirstName());
		return customer;
	}

	public CustomerDto customerToDto(Customer customer) {
		CustomerDto customerDto = new CustomerDto();
		customerDto.setFirstName(customer.getFirstName());
		return customerDto;
	}

}
