package com.app.service;

import java.util.List;

import com.app.dtos.AddressDto;

public interface AddressService {
	public String addAddress(AddressDto addressDto);
	public List<AddressDto> getAddressById(Integer customerId);
	public String updateAddress(Integer addressId,AddressDto addressDto);
	public String deleteAddress(Integer addressId);
}
