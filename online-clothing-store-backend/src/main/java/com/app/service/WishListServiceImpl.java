package com.app.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.dtos.WishlistDTO;
import com.app.pojos.Product;
import com.app.pojos.User;
import com.app.pojos.Wishlist;
import com.app.repository.ProductRepository;
import com.app.repository.UserRepository;
import com.app.repository.WishlistRepository;

@Service
@Transactional
public class WishListServiceImpl implements WishListService {
	 @Autowired
	    private ModelMapper mapper;

	    @Autowired
	    private WishlistRepository wishlistRepo;
	    
	    @Autowired
	    private UserRepository userRepo;
	    
	    @Autowired
	    private ProductRepository productRepo;

	    @Override
	    public String addWishlist(WishlistDTO wishlistDTO) {
	    	// Adding the wishlist to our database
	    	Wishlist wishlist = mapper.map(wishlistDTO, Wishlist.class);
	        Wishlist persistedWishlist = wishlistRepo.save(wishlist);
	        
	        // Associating the wishlist with the given user
	    	User user=userRepo.findById(wishlistDTO.getUserId()).get();
	    	user.addWishlist(persistedWishlist);
	    	
	    	// Adding the product in the wishlist
	    	//Product product=productRepo.findById(productId).get();
	    	//product.addWishlist(persistedWishlist);
	    	
	        return "Added to wishlist with ID: " + persistedWishlist.getId();
	    }

	    @Override
	    public WishlistDTO getWishlist(Integer wishlistId) {
	        Wishlist wishlistItem = wishlistRepo.findById(wishlistId).get();
	        WishlistDTO wishlistDto = mapper.map(wishlistItem, WishlistDTO.class);
	        return wishlistDto;
	    }

	    @Override
	    public String updateWishlist(Integer wishlistId, WishlistDTO wishlistDTO) {
			/*
			 * Wishlist persistentWishList = wishlistRepo.findById(wishlistId).get();
			 * //mapper.map(wishlistDTO, persistentWishList);
			 * 
			 * // updating the user //removing old links
			 * persistentWishList.getUser().setWishlist(null);
			 * persistentWishList.setUser(null); // adding new links User
			 * user=userRepo.findById(wishlistDTO.getUserId()).get();
			 * user.addWishlist(persistentWishList); persistentWishList.setUser(user);
			 * 
			 * // updating the product Product
			 * newProduct=productRepo.findById(wishlistDTO.getProductId()).get();
			 * 
			 * // removing old links Set<Product> products=persistentWishList.getProducts();
			 * List<Product> oldProduct=products.stream().filter(product->product.getId()==
			 * persistentWishList.getId()).collect(Collectors.toList());
			 * oldProduct.forEach(product->product.removeWishlist(persistentWishList));
			 * products.removeIf(product->product.getId()==wishlistDTO.getProductId()); //
			 * adding new links
			 * 
			 * //products.
			 */	        
	        return "Wishlist with ID: " + wishlistId + "updated successfully!";
	        
	    }

	    // adding item to the wishlist
	    @Override
		public String addItemToWishlist(Integer userId, Integer productId) {
	    	// Getting the user from user id
	    	User user=userRepo.findById(userId).get();
	    	// getting the product info from product id
	    	Product product=productRepo.findById(productId).get();
	    	
	    	// adding the product to user's wishlist
	    	user.getWishlist().addProduct(product);
	    	
	    	product.getWishlists().add(user.getWishlist());
			return "added product with id:"+productId+" in user's+"+userId+" wishlist" ;
		}
	    
	    // removing item from wishlist
	    @Override
	    public String removeItemFromWishlist(Integer userId, Integer productId) {
	    	// Getting the user from user id
	    	User user=userRepo.findById(userId).get();
	    	// getting the product info from product id
	    	Product product=productRepo.findById(productId).get();
	    	
	    	// removing the product to user's wishlist
	    	user.getWishlist().removeProduct(product);
	    	product.getWishlists().remove(user.getWishlist());
	    	
	    	return "removed item with id:"+productId;
	    }

		@Override
		public String removeWishlist(Integer wishlistId) {
			// removing wishlist and user links
			Wishlist wishlist=wishlistRepo.findById(wishlistId).get();
			User user=wishlist.getUser();
			user.removeWishlist(wishlist);
			wishlist.setUser(null);
			
			// removing products and wishlist links
			Set<Product> products=wishlistRepo.findById(wishlistId).get().getProducts();
			for (Product product : products) {
				product.getWishlists().remove(wishlist);
			}
			
			wishlistRepo.deleteById(wishlistId);
			return "wishlist with id:"+wishlistId+" deleted!";
		}

		

	    
	}


