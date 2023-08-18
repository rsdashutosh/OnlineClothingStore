package com.app.service;

import com.app.dtos.OrderDto;

public interface OrderService {
	
	public String placeOrder(OrderDto orderDto);
    public OrderDto getOrder(Long orderId);
    public String updateOrderDetails(Long orderId, OrderDto orderDto);
    public String cancelOrder(Long orderId);

}
