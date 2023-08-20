package com.app.service;

import java.util.List;
import com.app.dtos.ProductImageDTO;

public interface ProductImageService {
	
	public String addProductImage(ProductImageDTO productImageDto);
	public ProductImageDTO getProductImage(Integer productImageId);
	public List<ProductImageDTO> getAllProductImages();
	public String updateProductImageDetails(Integer productImageId, ProductImageDTO productImageDto);
	public String deleteProductImage(Integer productImageId);
}
