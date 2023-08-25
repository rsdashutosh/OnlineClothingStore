package com.app.service;

import javax.transaction.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.ProductImageDTO;
import com.app.pojos.Product;
import com.app.pojos.ProductImage;
import com.app.repository.ProductImageRepository;
import com.app.repository.ProductRepository;

@Service
@Transactional
public class ProductImageServiceImpl implements ProductImageService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private ProductImageRepository productImageRepo;
	
	@Autowired
	private ProductRepository productRepo;

	// POST
	@Override
	public String addProductImage(ProductImageDTO productImageDTO) throws IOException {
		// fetching the product
		Product product=productRepo.findById(productImageDTO.getProductId()).get();
		
		// Mapping the DTO to object of ProductImage class 
		ProductImage productImage=mapper.map(productImageDTO, ProductImage.class);	
		ProductImage persistentProductImage=productImageRepo.save(productImage);
		
		// linking 
		persistentProductImage.setImage(productImageDTO.getImage().getBytes());
		persistentProductImage.setProduct(product);
		product.addProductImage(persistentProductImage);
		
		return persistentProductImage.getName()+" image added!";
	}

	// Get productImage by Id
	@Override
	public byte[] getProductImage(Integer productId,Integer ImageId) {
		ProductImage productImage = productImageRepo.findById(ImageId).get();
		//ProductImageDTO productImageDto = mapper.map(productImage, ProductImageDTO.class);
		return productImage.getImage();
	}

	// Get all productImages
	@Override
	public List<byte[]> getAllProductImages(Integer productId) {
		//finding the product by product id
		Product product=productRepo.findById(productId).get();
		
		// fetching all the images of a product
		List<ProductImage> productImages=productImageRepo.findByProduct(product);
		
		//returning all the images of a product in a List<byte[]>
		List<byte[]> imageList=new ArrayList<>();
		
		for (ProductImage productImage : productImages) {
			imageList.add(productImage.getImage());
		}
		
		return imageList;
		
	}

	// Update product image
	@Override
	public String updateProductImageDetails(Integer productImageId, ProductImageDTO productImageDTO) throws IOException {
		ProductImage persistentProductImage = productImageRepo.findById(productImageId).get();
		mapper.map(productImageDTO, persistentProductImage);
		//persistentProductImage.setImage(productImageDTO.getImage().getBytes());
		return persistentProductImage.getName()+" Updated!";
	}
	

	//Delete a product image
	@Override
	public String deleteProductImage(Integer productImageId) {
		// fetching the image
		ProductImage productImage=productImageRepo.findById(productImageId).get();
		// fetching the product
		Product product=productRepo.findById(productImage.getProduct().getId()).get();
		product.getProductImages().remove(productImage);
		productImage.setProduct(null);
		
		productImageRepo.deleteById(productImageId);
		return "ProductImage : "+productImageId+" deleted Successfully!";
	}

}
