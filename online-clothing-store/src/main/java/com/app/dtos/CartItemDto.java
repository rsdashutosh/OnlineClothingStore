package com.app.dtos;

import java.time.LocalDate;

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
	private Integer productId;
	private Integer Quantity;
	private LocalDate dateAdded;
	private Integer customerId;
}
