package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.ProductImage;
import com.app.pojos.Product;


	public interface ProductImageRepository extends JpaRepository<ProductImage, Integer>{
		List<ProductImage> findByProduct(Product product);
	
}
