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
import com.app.pojos.User;
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
public class LoginResponseDTO {

    private String message;

    private Integer userId;
	
	
}
