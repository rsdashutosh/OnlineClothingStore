package com.app.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.dtos.CartDTO;
import com.app.pojos.Product;
import com.app.pojos.User;
import com.app.pojos.Cart;
import com.app.repository.ProductRepository;
import com.app.repository.UserRepository;
import com.app.repository.CartRepository;

@Service
@Transactional
public class CartServiceImpl implements CartService {
	 @Autowired
	    private ModelMapper mapper;

	    @Autowired
	    private CartRepository cartRepo;
	    
	    @Autowired
	    private UserRepository userRepo;
	    
	    @Autowired
	    private ProductRepository productRepo;

	    @Override
	    public String addCart(CartDTO cartDTO) {
	    	// Adding the cart to our database
	    	Cart cart = mapper.map(cartDTO, Cart.class);
	        Cart persistedCart = cartRepo.save(cart);
	        
	        // Associating the cart with the given user
	    	User user=userRepo.findById(cartDTO.getUserId()).get();
	    	user.addCart(persistedCart);
	    	
	    	// Adding the product in the cart
	    	//Product product=productRepo.findById(productId).get();
	    	//product.addCart(persistedCart);
	    	
	        return "Added to cart with ID: " + persistedCart.getId();
	    }

	    @Override
	    public CartDTO getCart(Integer cartId) {
	        Cart cartItem = cartRepo.findById(cartId).get();
	        CartDTO cartDto = mapper.map(cartItem, CartDTO.class);
	        return cartDto;
	    }

	    @Override
	    public String updateCart(Integer cartId, CartDTO cartDTO) {
			/*
			 * Cart persistentWishList = cartRepo.findById(cartId).get();
			 * //mapper.map(cartDTO, persistentWishList);
			 * 
			 * // updating the user //removing old links
			 * persistentWishList.getUser().setCart(null);
			 * persistentWishList.setUser(null); // adding new links User
			 * user=userRepo.findById(cartDTO.getUserId()).get();
			 * user.addCart(persistentWishList); persistentWishList.setUser(user);
			 * 
			 * // updating the product Product
			 * newProduct=productRepo.findById(cartDTO.getProductId()).get();
			 * 
			 * // removing old links Set<Product> products=persistentWishList.getProducts();
			 * List<Product> oldProduct=products.stream().filter(product->product.getId()==
			 * persistentWishList.getId()).collect(Collectors.toList());
			 * oldProduct.forEach(product->product.removeCart(persistentWishList));
			 * products.removeIf(product->product.getId()==cartDTO.getProductId()); //
			 * adding new links
			 * 
			 * //products.
			 */	        
	        return "Cart with ID: " + cartId + "updated successfully!";
	        
	    }

	    // adding item to the cart
	    @Override
		public String addItemToCart(Integer userId, Integer productId) {
	    	// Getting the user from user id
	    	User user=userRepo.findById(userId).get();
	    	// getting the product info from product id
	    	Product product=productRepo.findById(productId).get();
	    	
	    	// adding the product to user's cart
	    	user.getCart().addProduct(product);
	    	
	    	product.getCarts().add(user.getCart());
			return "added product with id:"+productId+" in user's+"+userId+" cart" ;
		}
	    
	    // removing item from cart
	    @Override
	    public String removeItemFromCart(Integer userId, Integer productId) {
	    	// Getting the user from user id
	    	User user=userRepo.findById(userId).get();
	    	// getting the product info from product id
	    	Product product=productRepo.findById(productId).get();
	    	
	    	// removing the product to user's cart
	    	user.getCart().removeProduct(product);
	    	product.getCarts().remove(user.getCart());
	    	
	    	return "removed item with id:"+productId;
	    }

		@Override
		public String removeCart(Integer cartId) {
			// removing cart and user links
			Cart cart=cartRepo.findById(cartId).get();
			User user=cart.getUser();
			user.removeCart(cart);
			cart.setUser(null);
			
			// removing products and cart links
			List<Product> products=cartRepo.findById(cartId).get().getProducts();
			for (Product product : products) {
				product.getCarts().remove(cart);
			}
			
			cartRepo.deleteById(cartId);
			return "cart with id:"+cartId+" deleted!";
		}

		

	    
	}


