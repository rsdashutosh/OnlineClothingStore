package com.app.service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.dtos.ReturnAndExchangeDTO;
import com.app.pojos.Order;
import com.app.pojos.ReturnAndExchange;
import com.app.pojos.User;
import com.app.repository.OrderRepository;
import com.app.repository.ReturnRepository;
import com.app.repository.UserRepository;

@Service
@Transactional
public class ReturnServiceImpl implements ReturnService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private ReturnRepository returnAndExchangeRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private OrderRepository orderRepo;

	// Method to store the returnAndExchange details in the DB and link it to a order and a user
	@Override
	public String addReturnAndExchange(ReturnAndExchangeDTO returnAndExchangeDTO) {
		// mapping the returnAndExchange dto to object to returnAndExchange entity
		ReturnAndExchange returnAndExchange = mapper.map(returnAndExchangeDTO, ReturnAndExchange.class);
		
		// persisting the received data in the DB
		ReturnAndExchange persistantReturnAndExchange = returnAndExchangeRepo.save(returnAndExchange);
		
		// fetching the user by user id
		User user=userRepo.findById(returnAndExchangeDTO.getUserId()).get();
		// fetching the order by order id
		Order order=orderRepo.findById(returnAndExchangeDTO.getOrderId()).get();
		
		// associate the returnAndExchange with a user
		persistantReturnAndExchange.setUser(user);
		user.addReturnAndExchange(persistantReturnAndExchange);
		
		// associate the returnAndExchange with an order
		persistantReturnAndExchange.setOrder(order);
		order.setReturnAndExchange(persistantReturnAndExchange);

		return "returnAndExchange with returnAndExchange id: "+persistantReturnAndExchange.getId()+"received!";
	}

	// Fetching the details of a returnAndExchange by returnAndExchange id
	@Override
	public ReturnAndExchangeDTO getReturnAndExchange(Integer returnAndExchangeId) {
		ReturnAndExchange returnAndExchange = returnAndExchangeRepo.findById(returnAndExchangeId).get();
		ReturnAndExchangeDTO returnAndExchangeDTO = mapper.map(returnAndExchange, ReturnAndExchangeDTO.class);
		return returnAndExchangeDTO;
	}

	// Get all returnAndExchanges 
	@Override
	public List<ReturnAndExchangeDTO> getAllReturnAndExchanges() {
		List<ReturnAndExchange> returnAndExchangeList = returnAndExchangeRepo.findAll();
		return returnAndExchangeList.stream().map(returnAndExchange -> mapper.map(returnAndExchange, ReturnAndExchangeDTO.class)).collect(Collectors.toList());
	}

	//PUT
	@Override
	public String updateReturnAndExchangeDetails(Integer returnAndExchangeId, ReturnAndExchangeDTO returnAndExchangeDto) {
		ReturnAndExchange persistentReturnAndExchange = returnAndExchangeRepo.findById(returnAndExchangeId).get();
		mapper.map(returnAndExchangeDto, persistentReturnAndExchange);
		return "ReturnAndExchange : "+persistentReturnAndExchange.getId()+"Updated";
	}
	

	//Delete
	@Override
	public String deleteReturnAndExchange(Integer returnAndExchangeId) {
		ReturnAndExchange returnAndExchange=returnAndExchangeRepo.findById(returnAndExchangeId).get();
		
		// fetching the user by user id
		User user=userRepo.findById(returnAndExchange.getUser().getId()).get();
		// fetching the order by order id
		Order order=orderRepo.findById(returnAndExchange.getOrder().getId()).get();
		
		// removing all links of returnAndExchange with user and order
		user.removeReturnAndExchange(returnAndExchange);
		order.setReturnAndExchange(null);
		returnAndExchange.setUser(null);
		returnAndExchange.setOrder(null);
		
		returnAndExchangeRepo.deleteById(returnAndExchangeId);
		return "ReturnAndExchange deleted Successfully";
	}

}
