package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.ShippingDTO;
import com.app.pojos.Address;
import com.app.pojos.Order;
import com.app.pojos.Shipping;
import com.app.pojos.User;
import com.app.repository.AddressRepository;
import com.app.repository.OrderRepository;
import com.app.repository.ShippingRepository;
import com.app.repository.UserRepository;

@Service
@Transactional
public class ShippingServiceImpl implements ShippingService
{

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ShippingRepository shippingRepo;
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private AddressRepository addressRepo;
	
	//Post
	@Override
	public String addShipping(ShippingDTO shippingDTO)
	{
		// fetch details of user , order and address
		User user=userRepo.findById(shippingDTO.getUserId()).get();
		Order order=orderRepo.findById(shippingDTO.getOrderId()).get();
		Address address=addressRepo.findById(shippingDTO.getAddressId()).get();
		
		// map the DTO to object of shipping class and save it in the DB
		Shipping shipping=mapper.map(shippingDTO, Shipping.class);
		Shipping persistentShipping=shippingRepo.save(shipping);
		
		// linking the shipping object to all other related entities i.e User, Order & Address
		persistentShipping.setShippingRecipient(user);
		user.addShipping(persistentShipping);
		
		persistentShipping.setOrder(order);
		order.setShippingDetails(persistentShipping);
		
		persistentShipping.setShippingAddress(address);
		address.setShipping(persistentShipping);
		
		return "shipping with id : "+persistentShipping.getId()+" added successfully";
	}
	
	@Override
	public ShippingDTO getShipping(Integer shippingId)
	{
		Shipping shipping=shippingRepo.findById(shippingId).get();
		ShippingDTO shippingDTO=mapper.map(shipping, ShippingDTO.class);
		return shippingDTO;
		
	}
	public List<ShippingDTO> getAllShippings()
	{
		List<Shipping> shipping=shippingRepo.findAll();
		return shipping.stream().map(Shipping->mapper.map(Shipping, ShippingDTO.class)).collect(Collectors.toList());
		
	}
	
	public String editShipping(Integer shippingId,ShippingDTO shippingDTO) 
	{
		Shipping persistentShipping=shippingRepo.findById(shippingId).get();
		mapper.map(shippingDTO,persistentShipping);
		return "shipping with id : "+persistentShipping.getId()+"updated";
	}
	
	
	public String deleteShipping(Integer shippingId)
	{
		// fetch the shipping using the shipping id
		Shipping shipping=shippingRepo.findById(shippingId).get();
		// fetch details of user , order and address
		User user=userRepo.findById(shipping.getShippingRecipient().getId()).get();
		Order order=orderRepo.findById(shipping.getOrder().getId()).get();
		Address address=addressRepo.findById(shipping.getShippingAddress().getId()).get();
		
		user.removeShipping(shipping);
		shipping.setShippingRecipient(null);
		order.setShippingDetails(null);
		shipping.setOrder(null);
		address.setShipping(null);
		shipping.setShippingAddress(null);
		
		shippingRepo.deleteById(shippingId);
		return "Shipping deleted Successfully";
	}

}
