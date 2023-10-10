package com.app.dtos;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.app.enums.OrderStatus;
import com.app.pojos.ReturnAndExchange;
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
public class OrderFromCartDTO {
    
    @NotNull(message = "userId is mandatory")
    private Integer userId;
    
    private Integer[] productIds;
	

}