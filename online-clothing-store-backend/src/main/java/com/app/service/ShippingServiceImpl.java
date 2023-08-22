package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.ShippingDTO;
import com.app.pojos.Shipping;
import com.app.repository.ShippingRepository;

@Service
@Transactional
public class ShippingServiceImpl implements ShippingService
{

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ShippingRepository shippingRepo;
	
	//Post
	@Override
	public String addShipping(ShippingDTO shippingDTO)
	{
		Shipping shipping=mapper.map(shippingDTO, Shipping.class);
		Shipping persistentShipping=shippingRepo.save(shipping);
		return "shipping with id : "+persistentShipping.getShippingId()+" added successfully";
	}
	
	@Override
	public ShippingDTO getShipping(Integer shippingId)
	{
		Shipping shipping=shippingRepo.findById(shippingId).get();
		ShippingDTO shippingDto=mapper.map(shipping, ShippingDTO.class);
		return shippingDto;
		
	}
	public List<ShippingDTO> getAllShippings()
	{
		List<Shipping> shipping=shippingRepo.findAll();
		return shipping.stream().map(Shipping->mapper.map(Shipping, ShippingDTO.class)).collect(Collectors.toList());
		
	}

	public String deleteShipping(Integer shippingId)
	{
		shippingRepo.deleteById(shippingId);
		return "Shipping deleted Successfully";
	}
	
	public String editShipping(Integer shippingId,ShippingDTO shippingDTO) 
	{
		Shipping persistentShipping=shippingRepo.findById(shippingId).get();
		mapper.map(shippingDTO,persistentShipping);
		return "shipping with id : "+persistentShipping.getShippingId()+"updated";
	}
	
	public ShippingServiceImpl() {
		// TODO Auto-generated constructor stub
	}

}
