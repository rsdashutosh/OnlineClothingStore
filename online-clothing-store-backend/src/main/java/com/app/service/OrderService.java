package com.app.service;

import java.util.List;

import com.app.dtos.OrderDTO;
import com.app.dtos.OrderResponseDTO;

public interface OrderService {
	
	public String placeOrder(OrderDTO orderDto);
	public List<OrderResponseDTO> getAllOrders();
    public OrderDTO getOrder(Integer orderId);
    public String updateOrderDetails(Integer orderId, OrderDTO orderDto);
    public String cancelOrder(Integer orderId);

}
