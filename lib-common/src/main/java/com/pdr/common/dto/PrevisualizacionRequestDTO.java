package com.pdr.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author BS2
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrevisualizacionRequestDTO {

	@JsonProperty
	private Integer cuNumRenegDesde;
	
	@JsonProperty
	private Integer cuNumRenegHasta;
	
	@JsonProperty
	private Integer cuotasDesde;
	
	@JsonProperty
	private Integer cuotasHasta;
	
	@JsonProperty
	private String prdoCod;
	
	@JsonProperty
	private String cuCodFase;
	
}
