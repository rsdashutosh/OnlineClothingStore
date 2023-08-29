package com.app.dtos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MapKeyEnumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import com.app.enums.Gender;
import com.app.enums.Role;
import com.app.pojos.Address;
import com.app.pojos.Cart;
import com.app.pojos.Order;
import com.app.pojos.Payment;
import com.app.pojos.ReturnAndExchange;
import com.app.pojos.Review;
import com.app.pojos.Wishlist;
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
public class UserLoginDTO {

	@NotBlank
    @Email(message = "email is not a valid email address")
    private String email;
    
    //@Size(min = 8, message = "password must be at least 8 characters long")
    @NotNull(message = "password is mandatory")
    //@Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}", message = "password must contain at least one uppercase letter, one lowercase letter, and one number")
    @JsonProperty(access = Access.WRITE_ONLY)
    private String password;
	
	
}
