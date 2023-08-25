package com.app.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

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
public class OfferDTO {

    @NotBlank(message = "Offer name is required")
    private String offerName;

    @NotBlank(message = "Offer description is required")
    private String offerDescription;

    @Positive(message = "Discount amount must be positive")
    private Double discountAmount;

    @NotBlank(message = "Promo code is required")
    private String promoCode;

    @NotNull(message = "Start date is required")
    private LocalDate startDate;
  
    @NotNull(message = "End date is required")
    @Future		// Promotional code should expire on a date in the future
    private LocalDate endDate;

    @NotNull(message = "Category is required")
    @Enumerated(EnumType.STRING)
    private CategoryType category;

    @Positive(message = "Minimum purchase amount must be positive")
    private Double minimumPurchaseAmount;
    
    // On 
    //private Integer productId;

}
