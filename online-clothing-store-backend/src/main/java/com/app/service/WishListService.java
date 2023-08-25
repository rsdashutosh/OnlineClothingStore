package com.app.service;
import com.app.dtos.WishlistDTO;

public interface WishListService {
	
	public String addWishlist(WishlistDTO wishlistDTO);
	public String addItemToWishlist(Integer userId, Integer productId);
	public String removeItemFromWishlist(Integer userId, Integer productId);
    public WishlistDTO getWishlist(Integer wishlistId);
    public String updateWishlist(Integer wishlistId, WishlistDTO wishlistDTO);
    public String removeWishlist(Integer wishlistId);
}
