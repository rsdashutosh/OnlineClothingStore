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

import com.app.dtos.ProductDTO;
import com.app.service.ProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/")
	public  ResponseEntity<?> addProducts(@Valid @RequestBody ProductDTO productDto) {
		return ResponseEntity.status(HttpStatus.OK).body(productService.addProduct(productDto));
	}
	
	@GetMapping("/{ProductId}")
	public ResponseEntity<?> getProductById(@PathVariable Integer productId){
		return new ResponseEntity<ProductDTO>(productService.getProduct(productId), HttpStatus.FOUND);
	}
	
	@PutMapping("/{ProductId}")
	public ResponseEntity<?> updateProductDetails(@Valid @PathVariable Integer productId, @RequestBody ProductDTO productDto){
		return ResponseEntity.status(HttpStatus.OK).body(productService.updateProductDetails(productId, productDto));
	}
	
	@DeleteMapping("/ProductId")
	public ResponseEntity<?> deleteProduct(@PathVariable Integer productId){
		return ResponseEntity.status(HttpStatus.OK).body(productService.deleteProduct(productId));
	}

}
