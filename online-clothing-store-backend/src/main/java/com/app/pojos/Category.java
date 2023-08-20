package com.app.pojos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.app.enums.Gender;
import com.app.enums.CategoryType;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Integer categoryId;
	private String categoryName;
	private Gender categoryGender;
	private CategoryType categoryType;
	@ManyToMany
	private List<Product> products;
	
	
	

}
