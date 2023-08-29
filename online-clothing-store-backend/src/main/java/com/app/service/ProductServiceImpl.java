package com.app.service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.app.dtos.ProductDTO;
import com.app.dtos.ProductResponseDTO;
import com.app.pojos.Product;
import com.app.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	private ModelMapper mapper;

	@Autowired
	private ProductRepository productRepo;
	
	// ENDPOINTS

	// POST
	@Override
	public String addProduct(ProductDTO productDto) throws IOException {
		Product product = mapper.map(productDto, Product.class);
		Product persistantProduct = productRepo.save(product);
		return persistantProduct.getName();
	}

	// GET product by Id
	@Override
	public ProductResponseDTO getProduct(Integer productId) {
		Product product = productRepo.findById(productId).get();
		ProductResponseDTO productResponseDTO = mapper.map(product, ProductResponseDTO.class);
		//productDto.setImage(product.getImage());
		return productResponseDTO;
	}

	// Get All products
	@Override
	public List<ProductResponseDTO> getAllProducts() {
		List<Product> productList = productRepo.findAll();
		return productList.stream().map(product -> mapper.map(product, ProductResponseDTO.class)).collect(Collectors.toList());
	}

	//PUT
	@Override
	public String updateProductDetails(Integer productId, ProductDTO productDto) {
		Product persistentProduct = productRepo.findById(productId).get();
		mapper.map(productDto, persistentProduct);
		return persistentProduct.getName()+"Updated";
	}
	

	//Delete
	@Override
	public String deleteProduct(Integer productId) {
		productRepo.deleteById(productId);
		return "Product deleted Successfully";
	}

	@Override
	public List<ProductResponseDTO> getProductsByCategory(String category) {
		List<Product> productList = productRepo.findByCategory(category);
		return productList.stream().map(product -> mapper.map(product, ProductResponseDTO.class)).collect(Collectors.toList());
	}

}
