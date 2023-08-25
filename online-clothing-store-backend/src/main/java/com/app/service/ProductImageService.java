package com.app.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.dtos.ProductImageDTO;
import com.app.pojos.ProductImage;

public interface ProductImageService {
	
	public String addProductImage(ProductImageDTO productImageDTO) throws IOException;
	public byte[] getProductImage(Integer product,Integer ImageId);
	public List<byte[]> getAllProductImages(Integer productId);
	public String updateProductImageDetails(Integer productImageId, ProductImageDTO productImageDto) throws IOException;
	public String deleteProductImage(Integer productImageId);
	//public String uploadImage(Integer productImageId, MultipartFile image);
}
