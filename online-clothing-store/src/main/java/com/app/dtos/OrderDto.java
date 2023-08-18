package com.app.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDto {
	private Long orderId;
    private Long customerId;
    private Date orderDate;
    private Double totalAmount;
    private String paymentMethod;
    private String paymentStatus;
    private String shippingAddress;
	

}
