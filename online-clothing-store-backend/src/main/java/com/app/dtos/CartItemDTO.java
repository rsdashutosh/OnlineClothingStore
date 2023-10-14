package com.app.dtos;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.app.pojos.Product;
import com.app.pojos.User;
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
public class CartItemDTO {
	  
	//@JsonProperty(access = Access.WRITE_ONLY)
    @NotNull(message = "customerId is mandatory")
    private Integer userId;
    
	// Optional as Cart may or may contain products
	//private List<Integer> products ;
}
