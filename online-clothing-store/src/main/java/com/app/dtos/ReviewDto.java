package com.app.dtos;

import java.sql.Blob;

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
public class ReviewDto 
{

		private Integer reviewId;
		private String text;
		private Blob image;
		private Integer rating;
		private Integer customerId;
		
	

}
