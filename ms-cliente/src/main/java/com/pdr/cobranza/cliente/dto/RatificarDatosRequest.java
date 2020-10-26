package com.pdr.cobranza.cliente.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
public class RatificarDatosRequest {
	
	@JsonProperty
	@NotBlank(message = "Es obligatorio")
	private String usuario;
	
	@JsonProperty
	@NotNull(message = "Es obligatorio")
	private Integer idDatoRatificacion;
	
	

}
