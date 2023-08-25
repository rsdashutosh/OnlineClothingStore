package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.OrderDTO;
import com.app.pojos.Order;
import com.app.pojos.User;
import com.app.repository.OrderRepository;
import com.app.repository.UserRepository;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	 @Autowired
	    private ModelMapper mapper;

	    @Autowired
	    private OrderRepository orderRepo;

	    @Autowired
	    private UserRepository userRepo;
	    
	    // POST
	    @Override
	    public String placeOrder(OrderDTO orderDTO) {
	    	// fetching the user details using user's id
	    	User user=userRepo.findById(orderDTO.getUserId()).get();
	    	
	    	// mapping the order DTO into object of order entity class
	        Order order = mapper.map(orderDTO, Order.class);	        
	        
	        // adding the links to both the sides 
	        order.setUser(user);
	        user.addOrder(order);
	        
	        // persisting the received data into the database
	        Order persistedOrder = orderRepo.save(order);
	        return "Order placed with ID: " + persistedOrder.getId();
	    }

	    // GET order by ID
	    @Override
	    public OrderDTO getOrder(Integer orderId) {
	        Order order = orderRepo.findById(orderId).get();
	        OrderDTO orderDto=mapper.map(order, OrderDTO.class);
	        return orderDto;
	       
	    }

	    // PUT
	    @Override
	    public String updateOrderDetails(Integer orderId, OrderDTO orderDto) {
	        Order persistentOrder = orderRepo.findById(orderId).get();
	        mapper.map(orderDto, persistentOrder);
	        return "Order updated with ID: \" + orderId";
	        		      
	    }

	    // DELETE
	    @Override
	    public String cancelOrder(Integer orderId) {
	        orderRepo.deleteById(orderId);
	        return "Order cancelled with ID: " + orderId;
	    }
	
	

}
