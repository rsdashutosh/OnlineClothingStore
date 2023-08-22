package com.app.dtos;

import com.app.enums.PaymentMethod;
import com.app.enums.PaymentStatus;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class PaymentDTO {
	@NotNull
	private Integer orderId;
	@NotNull
	@Positive
	private Double amount;
	@NotNull
	private PaymentMethod paymentMethod;
	@NotNull
	private PaymentStatus paymentStatus;

}