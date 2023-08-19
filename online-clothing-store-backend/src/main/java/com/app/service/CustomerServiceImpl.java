package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.CustomerDto;
import com.app.pojos.Customer;
import com.app.repository.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private CustomerRepository customerRepo;

	// POST
	@Override
	public String addCustomer(CustomerDto customerDto) {
		Customer customer = mapper.map(customerDto, Customer.class);
		Customer persistantCustomer = customerRepo.save(customer);
		return persistantCustomer.getFirstName()+" "+persistantCustomer.getLastName();
	}

	// GET customer by ID
	@Override
	public CustomerDto getCustomer(Integer customerId) {
		Optional<Customer> customer = customerRepo.findById(customerId);
		CustomerDto customerDto = mapper.map(customer.get(), CustomerDto.class);
		return customerDto;
	}
	
	// GET customer by email
	@Override
	public CustomerDto getCustomerByEmail(String email) {
		Optional<Customer> customer = customerRepo.findByEmail(email);
		CustomerDto customerDto = mapper.map(customer.get(), CustomerDto.class);
		return customerDto;
	}
	
	// GET all customers
	@Override
	public List<CustomerDto> getAllCustomers() {
		List<Customer> customers = customerRepo.findAll();
		return customers.stream().map(customer->mapper.map(customer, CustomerDto.class)).collect(Collectors.toList());
	}

	// PUT
	@Override
	public String updateCustomerDetails(Integer customerId,CustomerDto customerDto) {
		Optional<Customer> customer=customerRepo.findById(customerId);
		Customer persistantCustomer=customer.get();
		mapper.map(customerDto, persistantCustomer);
		return persistantCustomer.getFirstName()+" "+persistantCustomer.getLastName()+"updated!";
	}

	// DELETE
	@Override
	public String deleteCustomer(Integer customerId) {
		customerRepo.deleteById(customerId);
		return "Deleted successfully";
	}

	
	
	
	
	
	
	
	
	/*
	 * public Customer dtoToCustomer(CustomerDto customerDto) { Customer customer =
	 * new Customer(); customer.setFirstName(customerDto.getFirstName()); return
	 * customer; }
	 * 
	 * public CustomerDto customerToDto(Customer customer) { CustomerDto customerDto
	 * = new CustomerDto(); customerDto.setFirstName(customer.getFirstName());
	 * return customerDto; }
	 */

}
