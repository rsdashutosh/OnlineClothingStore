package com.app.service;

import org.springframework.web.bind.annotation.PathVariable;

import com.app.dtos.CartDTO;

public interface CartService {
	
	public String addCart(CartDTO wishlistDTO);
	
	public String addItemToCart(Integer userId, Integer productId);
	public String removeItemFromCart(Integer userId, Integer productId);
	
    public CartDTO getCart(Integer wishlistId);
    public String updateCart(Integer wishlistId, CartDTO wishlistDTO);
    public String removeCart(Integer wishlistId);
}
