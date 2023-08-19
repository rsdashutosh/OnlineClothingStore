package com.app.dtos;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.app.enums.Gender;
import com.app.enums.ColorOptions;
import com.app.enums.SizeOptions;

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

public class ProductDto {

	private String Name;
	private String description;
	private Float price;
	private int stock;
	
	@Enumerated(EnumType.STRING)
	private ColorOptions color;
	
	@Enumerated(EnumType.STRING)
	private SizeOptions size;
	
	@Enumerated(EnumType.STRING)
	private Gender category;
	//private byte[] image;
	private Float discount;
	private Float mrp;
}
