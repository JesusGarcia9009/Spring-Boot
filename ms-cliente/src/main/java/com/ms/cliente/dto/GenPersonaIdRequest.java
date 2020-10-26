package com.ms.cliente.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author BS2
 */
@Setter
@Getter
@ToString
public class GenPersonaIdRequest {

	@JsonProperty
	@NotBlank(message = "Es obligatorio")
	private String persTipoId;

	@JsonProperty
	@NotBlank(message =  "Es obligatorio")
	private String persId;
}
