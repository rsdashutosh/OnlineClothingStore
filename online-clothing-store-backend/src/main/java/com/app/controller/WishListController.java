package com.app.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.WishlistDTO;
import com.app.service.WishListService;

@RestController
@RequestMapping("/wishlist")
@CrossOrigin(origins = "http://localhost:3000")
public class WishListController {
	
	 @Autowired
	    WishListService wishlistService;

	    @PostMapping("/")
	    public ResponseEntity<?> addToWishlist(@Valid @RequestBody WishlistDTO wishlistDto) {
	        return ResponseEntity.status(HttpStatus.OK).body(wishlistService.addToWishlist(wishlistDto));
	    }

	    @GetMapping("/{wishlistId}")
	    public ResponseEntity<WishlistDTO> getWishlistById(@PathVariable Long wishlistId) {
	        return new ResponseEntity<WishlistDTO>(wishlistService.getWishlist(wishlistId), HttpStatus.OK);
	    }

	    @PutMapping("/{wishlistId}")
	    public ResponseEntity<?> updateWishlistItem(@Valid @PathVariable Long wishlistId, @RequestBody WishlistDTO wishlistDto) {
	        return ResponseEntity.status(HttpStatus.OK).body(wishlistService.updateWishlistItem(wishlistId, wishlistDto));
	    }

	    @DeleteMapping("/{wishlistId}")
	    public ResponseEntity<?> removeFromWishlist(@PathVariable Long wishlistId) {
	        return ResponseEntity.status(HttpStatus.OK).body(wishlistService.removeFromWishlist(wishlistId));
	    }
	}
	


