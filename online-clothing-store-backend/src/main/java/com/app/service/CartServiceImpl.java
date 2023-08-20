package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.CartDTO;
import com.app.pojos.Cart;
import com.app.repository.CartRepository;

@Service
@Transactional
public class CartServiceImpl implements CartService{

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private CartRepository cartRepo;
	
	@Override
	public String addCart(CartDTO cartDto) {
		Cart cart=mapper.map(cartDto,Cart.class);
		Cart persistantCart=cartRepo.save(cart);
		return "Cart item with id : "+persistantCart.getCartId()+"added successfully!";
	}

	@Override
	public CartDTO getCart(Integer cartId) {
		Cart cart=cartRepo.findById(cartId).get();
		CartDTO cartDto=mapper.map(cart, CartDTO.class);
		return cartDto;
	}


	@Override
	public String updateCart(Integer cartId,CartDTO cartDto) {
		Cart persistantCart=cartRepo.findById(cartId).get();
		mapper.map(cartDto, persistantCart);
		return "Cart with"+persistantCart.getCartId()+" updated!";
	}

	@Override
	public String deleteCart(Integer cartId) {
		cartRepo.deleteById(cartId);
		return "Cart item with id "+cartId+" deleted successfully!";
	}

}
