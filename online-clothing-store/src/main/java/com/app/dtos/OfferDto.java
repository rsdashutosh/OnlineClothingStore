package com.app.dtos;

import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.app.pojos.Category;
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

    @NotBlank(message = "Offer name is required")
    private String offerName;

    @NotBlank(message = "Offer description is required")
    private String offerDescription;

    @Positive(message = "Discount amount must be positive")
    private double discountAmount;

    @NotBlank(message = "Promo code is required")
    private String promoCode;

    @NotNull(message = "Start date is required")
    private Date startDate;

    @NotNull(message = "End date is required")
    private Date endDate;

    @NotNull(message = "Category is required")
    private Category category;

    @Positive(message = "Minimum purchase amount must be positive")
    private double minimumPurchaseAmount;

}
