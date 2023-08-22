package com.app.service;

import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.dtos.WishlistDTO;
import com.app.pojos.Wishlist;
import com.app.repository.WishlistRepository;

@Service
@Transactional
public class WishListServiceImpl implements WishListService {
	 @Autowired
	    private ModelMapper mapper;

	    @Autowired
	    private WishlistRepository wishlistRepo;

	    @Override
	    public String addToWishlist(WishlistDTO wishlistDTO) {
	        Wishlist wishlistItem = mapper.map(wishlistDTO, Wishlist.class);
	        Wishlist persistedItem = wishlistRepo.save(wishlistItem);
	        return "Added to wishlist with ID: " + persistedItem.getWishlistId();
	    }

	    @Override
	    public WishlistDTO getWishlist(Long wishlistId) {
	        Wishlist wishlistItem = wishlistRepo.findById(wishlistId).get();
	        WishlistDTO wishlistDto = mapper.map(wishlistItem, WishlistDTO.class);
	        return wishlistDto;
	    }

	    @Override
	    public String updateWishlistItem(Long wishlistId, WishlistDTO wishlistDto) {
	        Wishlist persistentWishList = wishlistRepo.findById(wishlistId).get();
	        mapper.map(wishlistDto, persistentWishList);
	        return "Wishlist item updated with ID: " + wishlistId;
	        
	    }

	    @Override
	    public String removeFromWishlist(Long wishlistId) {
	        wishlistRepo.deleteById(wishlistId);
	        return "Wishlist item removed with ID: " + wishlistId;
	    }
	}


