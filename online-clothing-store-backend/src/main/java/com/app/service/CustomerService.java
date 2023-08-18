package com.app.service;

import java.util.List;

import com.app.dtos.CustomerDto;

public interface CustomerService {

	public String addCustomer(CustomerDto customerDto);
	public CustomerDto getCustomer(Integer customerId);
	public List<CustomerDto> getAllCustomers();
	public String updateCustomerDetails(Integer customerId, CustomerDto customerDto);
	public String deleteCustomer(Integer customerId);
	
}
