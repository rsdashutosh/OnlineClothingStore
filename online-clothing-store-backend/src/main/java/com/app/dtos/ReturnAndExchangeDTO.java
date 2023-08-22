package com.app.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.app.enums.ReturnStatus;
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
public class ReturnAndExchangeDTO {

	@NotNull
	private Integer orderId;
	@NotNull
	private Integer productId;
	@NotBlank
	@Size(min = 10)
	private String reasonForReturn;
	@NotNull
	private ReturnStatus returnStatus;

}
