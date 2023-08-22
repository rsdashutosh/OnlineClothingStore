package com.app.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.app.pojos.Shipping;
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
public class AddressDTO {
	
	@NotBlank(message = "Line 1 is mandatory")
    private String line1;
	
	// line 2 is optional
    private String line2;

    @NotBlank(message = "Ttreet is mandatory")
    private String street;
    
    @NotBlank(message = "Town is mandatory")
    private String town;

    @NotBlank(message = "City is mandatory")
    private String city;

    @NotBlank(message = "Country is mandatory")
    private String country;

    @NotNull(message = "Pincode is mandatory")
    @Positive(message = "Pincode must be a positive integer")
    //@Size(min = 6,max = 6,message = "pincode should be of 6 digits")
    private Integer pinCode;

    @NotNull
    @JsonProperty(access = Access.WRITE_ONLY)
    private Integer userId;
	
}
