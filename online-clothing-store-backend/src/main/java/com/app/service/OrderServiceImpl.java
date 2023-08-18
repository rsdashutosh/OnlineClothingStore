package com.app.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.OrderDto;
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
	    public String placeOrder(OrderDto orderDto) {
	        Order order = mapper.map(orderDto, Order.class);
	        Order persistedOrder = orderRepo.save(order);
	        return "Order placed with ID: " + persistedOrder.getOrderId();
	    }

	    // GET order by ID
	    @Override
	    public OrderDto getOrder(Long orderId) {
	        Optional<Order> order = orderRepo.findById(orderId);
	        OrderDto orderDto=mapper.map(order.get(), OrderDto.class);
	        return orderDto;
	       
	    }

	    // PUT
	    @Override
	    public String updateOrderDetails(Long orderId, OrderDto orderDto) {
	        Optional<Order> order = orderRepo.findById(orderId);
	        Order persistentOrder=order.get();
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
