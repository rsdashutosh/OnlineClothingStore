package com.app.service;

import com.app.dtos.OrderDTO;

public interface OrderService {
	
	public String placeOrder(OrderDTO orderDto);
    public OrderDTO getOrder(Long orderId);
    public String updateOrderDetails(Long orderId, OrderDTO orderDto);
    public String cancelOrder(Long orderId);

}
