package com.app.service;

import java.io.IOException;
import java.util.List;

import com.app.dtos.ProductDTO;
import com.app.dtos.ProductResponseDTO;



public interface ProductService {
	
	public String addProduct(ProductDTO productDto) throws IOException;
	public ProductResponseDTO getProduct(Integer productId);
	public List<ProductResponseDTO> getAllProducts();
	public String updateProductDetails(Integer productId, ProductDTO productDto);
	public String deleteProduct(Integer productId);
	public List<ProductResponseDTO> getProductsByCategory(String category);
}
