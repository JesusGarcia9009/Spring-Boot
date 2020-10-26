package com.lib.common.dto;

import java.math.BigDecimal;

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
public class PrevisualizarResponseDTO {

    private String nombreEjecutivo;
    private BigDecimal pmtSaldoUf;
    private Long nContratos;
	private String criteriosAsignacion;
}