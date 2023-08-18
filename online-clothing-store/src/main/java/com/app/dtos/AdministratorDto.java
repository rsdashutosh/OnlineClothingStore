package com.app.dtos;

import javax.validation.constraints.NotBlank;

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
public class AdministratorDto {
	@NotBlank(message = "username required")
	private String username;
	@JsonProperty(access = Access.WRITE_ONLY)
	
	@NotBlank(message = "username required")
	private String password;
}
