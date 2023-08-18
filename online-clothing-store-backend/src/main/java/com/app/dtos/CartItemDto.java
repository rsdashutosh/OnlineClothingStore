package com.app.dtos;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

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
public class CartItemDto {
	
	 @NotNull(message = "productId is mandatory")
    private Integer productId;

    @NotNull(message = "quantity is mandatory")
    @Positive(message = "quantity must be greater than 0")
    private Integer quantity;

    @NotNull(message = "dateAdded is mandatory")
    private LocalDate dateAdded;

    @NotNull(message = "customerId is mandatory")
    private Integer customerId;
}
