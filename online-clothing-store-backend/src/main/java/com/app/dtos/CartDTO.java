package com.app.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
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
public class CartDTO {
	  
	@JsonProperty(access = Access.WRITE_ONLY)
    @NotNull(message = "customerId is mandatory")
    private Integer customerId;
    
	@NotNull(message = "productId is mandatory")
	private Integer productId;
    
    @NotNull(message = "quantity is mandatory")
    @Positive(message = "quantity must be greater than 0")
    private Integer quantity;
}
