/**
 * 
 */
package com.ms.cliente.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;

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
public class DemograficDataRequest {

	@JsonProperty
	@NotBlank(message = "Es obligatorio")
	private String persId;
	
	@JsonProperty
	private BigDecimal numDocto;
}
