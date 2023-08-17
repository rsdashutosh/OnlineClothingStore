package com.app.service;

import com.app.dtos.CustomerDto;

public interface CustomerService {

	public String addCustomer(CustomerDto customerDto);
	public CustomerDto getCustomer(Integer customerId);
	
}
