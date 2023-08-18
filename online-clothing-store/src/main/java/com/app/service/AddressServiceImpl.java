package com.app.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.dtos.AddressDto;
import com.app.pojos.Address;
import com.app.repository.AddressRepository;
import com.app.repository.CustomerRepository;

public class AddressServiceImpl implements AddressService {

	@Autowired
	private ModelMapper mapper;
	@Autowired
	private AddressRepository addressRepo;
	
	//Post
	@Override
	public String addAddress(AddressDto addressDto) {
		Address address=mapper.map(addressDto, Address.class);
		Address persistanceAddress=	addressRepo.save(address);
		return "New address added successfully!!!";
	}

	//GET address by Id 
	@Override
	public AddressDto getAddressById(Integer customerId) {
		Optional<Address> address=addressRepo.findById(customerId);
		AddressDto addressDto=mapper.map(address.get(), AddressDto.class);
		return addressDto;
	}

	//PUT
	@Override
	public String updateAddress(Integer customerId, AddressDto addressDto) {
		Optional<Address> address=addressRepo.findById(customerId);
		Address persistantAddress=address.get();
		mapper.map(addressDto, persistantAddress);
		return "Aaddress updated successfully!!!";
	}

	//Put
	@Override
	public String deleteAddress(Integer customerId) {
		addressRepo.deleteById(customerId);
		return "Aaddress deleted successfully!!!";
	}

}
