package com.app.service;

import com.app.dtos.WishlistDTO;

public interface WishListService {
	
	public String addToWishlist(WishlistDTO wishlistDto);
    public WishlistDTO getWishlist(Long wishlistId);
    public String updateWishlistItem(Long wishlistId, WishlistDTO wishlistDto);
    public String removeFromWishlist(Long wishlistId);
}
