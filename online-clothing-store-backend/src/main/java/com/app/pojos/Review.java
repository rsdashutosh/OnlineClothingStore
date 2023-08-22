package com.app.pojos;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reviewId;
	private String text;
	private Blob image;
	private Integer rating;
	
	@ManyToOne
	@JoinColumn(name="fk_user_id")
	//@JsonProperty(access = Access.WRITE_ONLY)
	private User user;
	
	@ManyToOne
	@JoinColumn(name="fk_product_id")
	//@JsonProperty(access = Access.WRITE_ONLY)
	private Product product;
	

}
