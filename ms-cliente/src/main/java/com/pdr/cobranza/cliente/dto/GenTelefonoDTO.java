/**
 * 
 */
package com.pdr.cobranza.cliente.dto;

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
public class GenTelefonoDTO {


	@JsonProperty
	private String fonoTipo;
	@JsonProperty
	private String fonoNumero;
	
	@JsonProperty
	private BigDecimal numDocto;
	
	@JsonProperty
	private String fonoUserMod;
	
	// id de persona
	@JsonProperty
	private String persId;
	
	@JsonProperty
	private String persTipoId;
	
	

}
