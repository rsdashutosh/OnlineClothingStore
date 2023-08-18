package com.app.service;

import com.app.dtos.WishListDto;

public interface WishListService {
	
	public String addToWishlist(WishListDto wishlistDto);
    public WishListDto getWishlist(Long wishlistId);
    public String updateWishlistItem(Long wishlistId, WishListDto wishlistDto);
    public String removeFromWishlist(Long wishlistId);
}
