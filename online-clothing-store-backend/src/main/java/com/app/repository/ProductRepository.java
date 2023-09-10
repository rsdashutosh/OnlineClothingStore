package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Product;


	public interface ProductRepository extends JpaRepository<Product, Integer>{
		
		@Query("SELECT p FROM Product as p WHERE p.category = ?1")
		public List<Product> findByCategory(String category);
		
		//@Query("SELECT p FROM Product as p WHERE p.gender=?1 p.category = ?2")
		//public List<Product> findByGenderAndCategory(String gender,String category);
	
}
