package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.AddressDTO;
import com.app.pojos.Address;
import com.app.repository.AddressRepository;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

	@Autowired
	private ModelMapper mapper;
	@Autowired
	private AddressRepository addressRepo;
	
	//Post
	@Override
	public String addAddress(AddressDTO addressDto) {
		Address address=mapper.map(addressDto, Address.class);
		Address persistanceAddress=	addressRepo.save(address);
		return "New address with id : "+persistanceAddress.getId()+ " added successfully!!!";
	}

	
	  //GET all addresses by User Id
	@Override 
	public List<AddressDTO> getAllAddressesByUserEmail(String email)
	{ 
	    List<Address> addresses=addressRepo.findAllByUserEmail(email); 
	    return addresses.stream().map(address->mapper.map(address, AddressDTO.class)).collect(Collectors.toList()); 
	}
	 

	//PUT
	@Override
	public String updateAddress(Integer addressId, AddressDTO addressDto) {
		Address persistantAddress=addressRepo.findById(addressId).get();	// finding the Address by Id, and fetching it from the Optional container through .get()
		mapper.map(addressDto, persistantAddress);
		return "Address with id:"+persistantAddress.getId()+"updated successfully!!!";
	}

	//Put
	@Override
	public String deleteAddress(Integer addressId) {
		addressRepo.deleteById(addressId);
		return "Address with address id :"+addressId+" deleted successfully!!!";
	}

	

}
