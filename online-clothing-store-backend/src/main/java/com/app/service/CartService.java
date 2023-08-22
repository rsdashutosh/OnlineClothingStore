package com.app.service;

import com.app.dtos.CartDTO;

public interface CartService {
	public String addCart(CartDTO cartDto);
	public CartDTO getCart(Integer cartId);
	//public List<CartDto> getCartOfACustomer(Integer customerId);
	public String updateCart(Integer cartId,CartDTO cartDto);
	public String deleteCart(Integer cartId);
}
