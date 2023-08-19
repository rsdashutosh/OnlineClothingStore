package com.app.pojos;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.app.enums.CategoryType;

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
@Entity
@Table(name = "offers")
public class Offer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer offerId;
	private String offerName;
	private String offerDescription;
	private Double discountAmount;
	private String promoCode;
	private Date startDate;
	private Date endDate;
	@Enumerated(EnumType.STRING)
	private CategoryType category;
	private double minimumPurchaseAmount;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

}
