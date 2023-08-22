package com.app.service;

import java.util.List;

import com.app.dtos.ProductDTO;



public interface ProductService {
	
	public String addProduct(ProductDTO productDto);
	public ProductDTO getProduct(Integer productId);
	public List<ProductDTO> getAllProducts();
	public String updateProductDetails(Integer productId, ProductDTO productDto);
	public String deleteProduct(Integer productId);
}
