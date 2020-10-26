package com.lib.common.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author BS2
 */
@Getter
@Setter
@NoArgsConstructor
public class AsignacionResponseDTO {

	private BigDecimal cantContratos;
	private BigDecimal cantUf;

	public AsignacionResponseDTO(BigDecimal cantContratos, BigDecimal cantUf) {
		super();
		this.cantContratos = cantContratos;
		this.cantUf = cantUf;
	}

}
