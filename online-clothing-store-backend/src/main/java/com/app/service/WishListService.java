package com.app.service;

import com.app.dtos.WishListDTO;

public interface WishListService {
	
	public String addToWishlist(WishListDTO wishlistDto);
    public WishListDTO getWishlist(Long wishlistId);
    public String updateWishlistItem(Long wishlistId, WishListDTO wishlistDto);
    public String removeFromWishlist(Long wishlistId);
}
