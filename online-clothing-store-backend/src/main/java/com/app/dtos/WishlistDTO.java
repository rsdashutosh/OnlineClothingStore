package com.app.dtos;


import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;

import com.app.pojos.Product;

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
public class WishlistDTO {
	
    @NotNull(message = "customerId is mandatory")
    private Integer customerId;
    
    private Set<Product> products=new HashSet<>();
    
    
}
	


