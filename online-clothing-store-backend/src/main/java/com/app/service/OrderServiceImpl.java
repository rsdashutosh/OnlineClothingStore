package com.app.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.OrderDTO;
import com.app.pojos.Order;
import com.app.repository.OrderRepository;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	 @Autowired
	    private ModelMapper mapper;

	    @Autowired
	    private OrderRepository orderRepo;

	    // POST
	    @Override
	    public String placeOrder(OrderDTO orderDto) {
	        Order order = mapper.map(orderDto, Order.class);
	        Order persistedOrder = orderRepo.save(order);
	        return "Order placed with ID: " + persistedOrder.getOrderId();
	    }

	    // GET order by ID
	    @Override
	    public OrderDTO getOrder(Long orderId) {
	        Order order = orderRepo.findById(orderId).get();
	        OrderDTO orderDto=mapper.map(order, OrderDTO.class);
	        return orderDto;
	       
	    }

	    // PUT
	    @Override
	    public String updateOrderDetails(Long orderId, OrderDTO orderDto) {
	        Order persistentOrder = orderRepo.findById(orderId).get();
	        mapper.map(orderDto, persistentOrder);
	        return "Order updated with ID: \" + orderId";
	        		      
	    }

	    // DELETE
	    @Override
	    public String cancelOrder(Long orderId) {
	        orderRepo.deleteById(orderId);
	        return "Order cancelled with ID: " + orderId;
	    }
	
	

}
