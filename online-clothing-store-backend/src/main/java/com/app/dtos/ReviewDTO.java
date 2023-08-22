package com.app.dtos;

import java.sql.Blob;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO 
{
	@NotBlank(message = "review text is mandatory")
	private String text;
	private Blob image;
	@NotNull(message = "review rating is mandatory")
	@Size(min = 1,max = 10)
	private Integer rating;
	@NotNull(message = "customer Id is mandatory")
	private Integer customerId;
		
	

}
