package com.app.dtos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.springframework.web.multipart.MultipartFile;

import com.app.enums.Gender;
import com.app.enums.Material;
import com.app.enums.Occasion;
import com.app.enums.CategoryType;
import com.app.enums.ColorOptions;
import com.app.enums.SizeOptions;
import com.app.enums.Style;
import com.app.pojos.Cart;
import com.app.pojos.Offer;
import com.app.pojos.Order;
import com.app.pojos.ProductImage;
import com.app.pojos.Review;
import com.app.pojos.Wishlist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ProductResponseDTO {

	private Integer id;
	private String name;
	private String description;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	private Integer stock;
	private Double discount;
	private Double price;
	
	@Enumerated(EnumType.STRING)
	private ColorOptions color;
	
	@Enumerated(EnumType.STRING)
	private SizeOptions size;
	
	@Enumerated(EnumType.STRING)
	private CategoryType category;
	
	@Enumerated(EnumType.STRING)
	private Material material;
	
	@Enumerated(EnumType.STRING)
	private Style style;
	
	@Enumerated(EnumType.STRING)
	private Occasion occasion;
	
}
