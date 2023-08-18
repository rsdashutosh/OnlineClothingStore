package com.app.dtos;


import javax.validation.constraints.NotNull;

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
public class WishListDto {
	
    @NotNull(message = "customerId is mandatory")
    private Long customerId;

    @NotNull(message = "productId is mandatory")
    private Long productId;
	
}
	


