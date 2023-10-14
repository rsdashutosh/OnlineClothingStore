package com.app.service;

import java.util.List;

import javax.validation.Valid;

import com.app.dtos.OrderDTO;
import com.app.dtos.OrderFromCartDTO;
import com.app.dtos.OrderItemDTO;
import com.app.dtos.OrderResponseDTO;

public interface OrderService {
	
	public String placeOrder(OrderDTO orderDto);
	public List<OrderResponseDTO> getAllOrders();
    public OrderDTO getOrder(Integer orderId);
    public String updateOrderDetails(Integer orderId, OrderDTO orderDto);
    public String cancelOrder(Integer orderId);
	String placeOrderFromCart(OrderFromCartDTO orderFromCartDTO);
	public List<OrderItemDTO> getAllOrdersOfAUser(@Valid Integer userId);

}
