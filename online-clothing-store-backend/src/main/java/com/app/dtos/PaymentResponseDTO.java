package com.app.dtos;

import com.app.enums.PaymentMethod;
import com.app.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDate;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaymentResponseDTO {
	
	private Integer id;
	
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
	
	@NotNull
	private Integer orderId;
	
	@NotNull
	private Integer userId;
	
	

}