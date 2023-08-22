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
public class OrderDTO {
	
	@NotNull(message = "orderDate is mandatory")
    private LocalDate orderDate;

    @NotNull(message = "userId is mandatory")
    private Integer userId;
    
    private String orderStatus;

    private Integer paymentId;

    @NotBlank(message = "shippingAddress is mandatory")
    @JsonProperty(access = Access.WRITE_ONLY)
    private String shippingAddress;
    
    private Integer returnAndExchangeId;
    
    private Double tax;
    private Double orderAmount;
    
    private List<Integer> products;
	

}
