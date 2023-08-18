package com.app.service;

import com.app.dtos.AddressDto;

public interface AddressService {
	public String addAddress(AddressDto addressDto);
	public AddressDto getAddressById(Integer customerId);
	public String updateAddress(Integer customerId,AddressDto addressDto);
	public String deleteAddress(Integer customerId);
}
