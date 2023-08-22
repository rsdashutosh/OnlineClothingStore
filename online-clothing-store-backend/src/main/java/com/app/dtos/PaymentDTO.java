package com.app.dtos;

import com.app.enums.PaymentMethod;
import com.app.enums.PaymentStatus;
import com.app.pojos.Order;
import com.app.pojos.User;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class PaymentDTO {
	@NotNull
	private Integer orderId;
	
	private Integer userId;
	
	@NotNull
	@Positive
	private Double amount;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private PaymentMethod paymentMethod;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;
	
	private LocalDate paymentTimestamp;
	
	

}