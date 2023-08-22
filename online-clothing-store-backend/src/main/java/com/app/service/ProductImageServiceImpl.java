package com.app.service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.dtos.ProductImageDTO;
import com.app.pojos.ProductImage;
import com.app.repository.ProductImageRepository;

@Service
@Transactional
public class ProductImageServiceImpl implements ProductImageService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private ProductImageRepository productImageRepo;

	// POST
	@Override
	public String addProductImage(ProductImageDTO productImageDto) {
		ProductImage productImage = mapper.map(productImageDto, ProductImage.class);
		ProductImage persistantProductImage = productImageRepo.save(productImage);
		return persistantProductImage.getName();
	}

	// GET productImage by Id
	@Override
	public ProductImageDTO getProductImage(Integer productImageId) {
		ProductImage productImage = productImageRepo.findById(productImageId).get();
		ProductImageDTO productImageDto = mapper.map(productImage, ProductImageDTO.class);
		return productImageDto;
	}

	// Update all productImages
	@Override
	public List<ProductImageDTO> getAllProductImages() {
		List<ProductImage> productImageList = productImageRepo.findAll();
		return productImageList.stream().map(productImage -> mapper.map(productImage, ProductImageDTO.class)).collect(Collectors.toList());
	}

	//PUT
	@Override
	public String updateProductImageDetails(Integer productImageId, ProductImageDTO productImageDto) {
		ProductImage persistentProductImage = productImageRepo.findById(productImageId).get();
		mapper.map(productImageDto, persistentProductImage);
		return persistentProductImage.getName()+"Updated";
	}
	

	//Delete
	@Override
	public String deleteProductImage(Integer productImageId) {
		productImageRepo.deleteById(productImageId);
		return "ProductImage deleted Successfully";
	}

}
