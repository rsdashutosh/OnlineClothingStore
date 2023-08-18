package com.app.service;

import java.util.List;

import com.app.dtos.CartItemDto;

public interface CartItemService {
	public String addCartItem(CartItemDto cartItemDto);
	public CartItemDto getCartItem(Integer cartItemId);
	public List<CartItemDto> getCartItemsOfACustomer(Integer customerId);
	public String updateCartItem(Integer cartItemId,CartItemDto cartItemDto);
	public String deleteCartItem(Integer cartItemId);
}
