package com.ms.cliente.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class V360ClienteDesactulizadoRequestDTO {
	
	@JsonProperty
	@NotBlank(message = "Es obligatorio")
	private String persId;
}
