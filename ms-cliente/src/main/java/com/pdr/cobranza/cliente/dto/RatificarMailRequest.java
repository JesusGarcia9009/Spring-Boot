package com.pdr.cobranza.cliente.dto;

import java.math.BigDecimal;

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
public class RatificarMailRequest {
	
	@JsonProperty
	@NotBlank(message = "Es obligatorio")
	private String usuario;
	
	@JsonProperty
	private String mail;
	
	@JsonProperty
	@NotBlank(message = "Es obligatorio (KEY)")
	private String persTipoId;
	
	@JsonProperty
	@NotBlank(message = "Es obligatorio (KEY)")
	private String persId;
	
	@JsonProperty
	@NotBlank(message = "Es obligatorio (KEY)")
	private String tipoDocto;
	
	@JsonProperty
	@NotNull(message = "Es obligatorio (KEY)")
	private BigDecimal numDocto;

}
