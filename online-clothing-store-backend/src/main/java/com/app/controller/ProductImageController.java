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

import com.app.dtos.ProductImageDTO;
import com.app.service.ProductImageService;

@RestController
@RequestMapping("/productImages")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductImageController {
	
	@Autowired
	ProductImageService productImageService;
	
	@PostMapping("/")
	public  ResponseEntity<?> addProductImages(@Valid @RequestBody ProductImageDTO productImageDto) {
		return ResponseEntity.status(HttpStatus.OK).body(productImageService.addProductImage(productImageDto));
	}
	
	@GetMapping("/{ProductImageId}")
	public ResponseEntity<?> getProductImageById(@PathVariable Integer productImageId){
		return new ResponseEntity<ProductImageDTO>(productImageService.getProductImage(productImageId), HttpStatus.FOUND);
	}
	
	@PutMapping("/{ProductImageId}")
	public ResponseEntity<?> updateProductImageDetails(@Valid @PathVariable Integer productImageId, @RequestBody ProductImageDTO productImageDto){
		return ResponseEntity.status(HttpStatus.OK).body(productImageService.updateProductImageDetails(productImageId, productImageDto));
	}
	
	@DeleteMapping("/ProductImageId")
	public ResponseEntity<?> deleteProductImage(@PathVariable Integer productImageId){
		return ResponseEntity.status(HttpStatus.OK).body(productImageService.deleteProductImage(productImageId));
	}

}
