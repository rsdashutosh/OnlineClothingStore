package com.app.service;

import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.dtos.WishListDTO;
import com.app.pojos.WishList;
import com.app.repository.WishListRepository;

@Service
@Transactional
public class WishListServiceImpl implements WishListService {
	 @Autowired
	    private ModelMapper mapper;

	    @Autowired
	    private WishListRepository wishlistRepo;

	    @Override
	    public String addToWishlist(WishListDTO wishlistDto) {
	        WishList wishlistItem = mapper.map(wishlistDto, WishList.class);
	        WishList persistedItem = wishlistRepo.save(wishlistItem);
	        return "Added to wishlist with ID: " + persistedItem.getWishListId();
	    }

	    @Override
	    public WishListDTO getWishlist(Long wishlistId) {
	        WishList wishlistItem = wishlistRepo.findById(wishlistId).get();
	        WishListDTO wishlistDto = mapper.map(wishlistItem, WishListDTO.class);
	        return wishlistDto;
	    }

	    @Override
	    public String updateWishlistItem(Long wishlistId, WishListDTO wishlistDto) {
	        WishList persistentWishList = wishlistRepo.findById(wishlistId).get();
	        mapper.map(wishlistDto, persistentWishList);
	        return "Wishlist item updated with ID: " + wishlistId;
	        
	    }

	    @Override
	    public String removeFromWishlist(Long wishlistId) {
	        wishlistRepo.deleteById(wishlistId);
	        return "Wishlist item removed with ID: " + wishlistId;
	    }
	}


