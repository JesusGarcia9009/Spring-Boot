/**
 * 
 */
package com.ms.cliente.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author BS2
 */
@Getter
@Setter
@ToString
public class GenDireccionesDTO {

	@JsonProperty
	private String direTipo;
	
	@JsonProperty
	private String direCalle;
	
	@JsonProperty
	private String direNumero;
	
	@JsonProperty
	private String direRestoDire;
	
	@JsonProperty
	private String direUserMod;
	
	@JsonProperty
	private String tipoDocto;
	
	@JsonProperty
	private BigDecimal numDocto;
	
	//datos de la comuna
	@JsonProperty
	private String comuCod;
	
	//datos de la persona
	@JsonProperty
	private String persId;
	
}
