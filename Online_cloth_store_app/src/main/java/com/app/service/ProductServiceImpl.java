package com.app.service;

import javax.transaction.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ProductDto;
import com.app.entities.Product;
import com.app.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private ProductRepository productRepo;

	// POST
	@Override
	public String addProduct(ProductDto productDto) {
		Product product = mapper.map(productDto, Product.class);
		Product persistantProduct = productRepo.save(product);
		return persistantProduct.getName();
	}

	// GET product by Id
	@Override
	public ProductDto getProduct(Integer productId) {
		Optional<Product> product = productRepo.findById(productId);
		ProductDto productDto = mapper.map(product.get(), ProductDto.class);
		return productDto;
	}

	// Upadte all products
	@Override
	public List<ProductDto> getAllProducts() {
		List<Product> productList = productRepo.findAll();
		return productList.stream().map(product -> mapper.map(product, ProductDto.class)).collect(Collectors.toList());
	}

	//PUT
	@Override
	public String updateProductDetails(Integer productId, ProductDto productDto) {
		Optional<Product> product = productRepo.findById(productId);
		Product persistentProduct = product.get();
		mapper.map(productDto, persistentProduct);
		return persistentProduct.getName()+"Updated";
	}
	

	//Delete
	@Override
	public String deleteProduct(Integer productId) {
		productRepo.deleteById(productId);
		return "Product deleted Successfully";
	}

}
