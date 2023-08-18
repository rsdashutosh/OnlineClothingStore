package com.app.service;

import javax.transaction.Transactional;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.WishListDto;
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
	    public String addToWishlist(WishListDto wishlistDto) {
	        WishList wishlistItem = mapper.map(wishlistDto, WishList.class);
	        WishList persistedItem = wishlistRepo.save(wishlistItem);
	        return "Added to wishlist with ID: " + persistedItem.getId();
	    }

	    @Override
	    public WishListDto getWishlist(Long wishlistId) {
	        Optional<WishList> wishlistItem = wishlistRepo.findById(wishlistId);
	        WishListDto wishlistDto = mapper.map(wishlistItem.get(), WishListDto.class);
	        return wishlistDto;
	    }

	    @Override
	    public String updateWishlistItem(Long wishlistId, WishListDto wishlistDto) {
	        Optional<WishList> wishlistItem = wishlistRepo.findById(wishlistId);
	        WishList persistentWishList=wishlistItem.get();
	        mapper.map(wishlistDto, persistentWishList);
	        return "Wishlist item updated with ID: " + wishlistId;
	        
	    }

	    @Override
	    public String removeFromWishlist(Long wishlistId) {
	        wishlistRepo.deleteById(wishlistId);
	        return "Wishlist item removed with ID: " + wishlistId;
	    }
	}


