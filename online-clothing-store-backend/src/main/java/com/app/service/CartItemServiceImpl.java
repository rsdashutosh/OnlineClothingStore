package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.AdministratorDto;
import com.app.dtos.CartItemDto;
import com.app.pojos.CartItem;
import com.app.repository.CartItemRepository;

@Service
@Transactional
public class CartItemServiceImpl implements CartItemService{

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private CartItemRepository cartItemRepo;
	
	@Override
	public String addCartItem(CartItemDto cartItemDto) {
		CartItem cartItem=mapper.map(cartItemDto,CartItem.class);
		CartItem persistantCartItem=cartItemRepo.save(cartItem);
		return "Cart item with id : "+persistantCartItem.getCartItemId()+"added successfully!";
	}

	@Override
	public CartItemDto getCartItem(Integer cartItemId) {
		Optional<CartItem> cartItem=cartItemRepo.findById(cartItemId);
		CartItemDto cartItemDto=mapper.map(cartItem.get(), CartItemDto.class);
		return cartItemDto;
	}

	// to do
	@Override
	public List<CartItemDto> getCartItemsOfACustomer(Integer customerId) {
		List<CartItem> cartItems=cartItemRepo.findByCustomerId(customerId);
		return cartItems.stream().map(cartItem->mapper.map(cartItem, CartItemDto.class)).collect(Collectors.toList());
	}

	@Override
	public String updateCartItem(Integer cartItemId,CartItemDto cartItemDto) {
		Optional<CartItem> cartItem=cartItemRepo.findById(cartItemId);
		CartItem persistantCartitem=cartItem.get();
		mapper.map(cartItemDto, persistantCartitem);
		return "Cart item with"+persistantCartitem.getCartItemId()+" updated!";
	}

	@Override
	public String deleteCartItem(Integer cartItemId) {
		cartItemRepo.deleteById(cartItemId);
		return "Cart item with id "+cartItemId+" deleted successfully!";
	}

}
