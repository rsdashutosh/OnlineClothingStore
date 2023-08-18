package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.AddressDto;
import com.app.pojos.Address;
import com.app.repository.AddressRepository;
import com.app.repository.CustomerRepository;


@Service
@Transactional
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
	public List<AddressDto> getAddressById(Integer customerId) {
		Optional<List<Address>> addressList=addressRepo.findByCustomerId(customerId);
		//AddressDto addressDto=mapper.map(address.get(), AddressDto.class);
		return addressList.get().stream().map(address->mapper.map(address, AddressDto.class)).collect(Collectors.toList());
	}

	//PUT
	@Override
	public String updateAddress(Integer addressId, AddressDto addressDto) {
		Optional<Address> address=addressRepo.findById(addressId);
		Address persistantAddress=address.get();
		mapper.map(addressDto, persistantAddress);
		return "Address with id:"+persistantAddress.getAddressId()+"updated successfully!!!";
	}

	//Put
	@Override
	public String deleteAddress(Integer addressId) {
		addressRepo.deleteById(addressId);
		return "Address with address id :"+addressId+" deleted successfully!!!";
	}

}
