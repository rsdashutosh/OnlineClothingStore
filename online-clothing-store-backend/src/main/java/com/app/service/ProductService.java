package com.app.service;

import java.util.List;

import com.app.dtos.ProductDto;



public interface ProductService {
	
	public String addProduct(ProductDto productDto);
	public ProductDto getProduct(Integer productId);
	public List<ProductDto> getAllProducts();
	public String updateProductDetails(Integer productId, ProductDto productDto);
	public String deleteProduct(Integer productId);
}
