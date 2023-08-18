package com.app.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

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
public class AddressDto {
	
	@NotBlank(message = "line1 is mandatory")
    private String line1;

    @NotBlank(message = "street is mandatory")
    private String street;
    
    @NotBlank(message = "town is mandatory")
    private String town;

    @NotBlank(message = "city is mandatory")
    private String city;

    @NotBlank(message = "country is mandatory")
    private String country;

    @NotNull(message = "pinCode is mandatory")
    @Positive(message = "pinCode must be a positive integer")
    @Size(min = 6,max = 6,message = "pincode should be of 6 digits")
    private Integer pinCode;

    
    private Integer customerId;
	
}
