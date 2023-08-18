package com.app.dtos;

import java.sql.Date;

import com.app.pojos.Category;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
public class OfferDto {

	private String offerName;
	private String offerDescription;
	private double discountAmount;
	private String promoCode;
	private Date startDate;
	private Date endDate;
	private Category category;
	private double minimumPurchaseAmount;

}
