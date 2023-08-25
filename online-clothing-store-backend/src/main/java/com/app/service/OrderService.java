package com.app.service;

import com.app.dtos.OrderDTO;

public interface OrderService {
	
	public String placeOrder(OrderDTO orderDto);
    public OrderDTO getOrder(Integer orderId);
    public String updateOrderDetails(Integer orderId, OrderDTO orderDto);
    public String cancelOrder(Integer orderId);

}
