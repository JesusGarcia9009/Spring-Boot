/**
 * 
 */
package com.pdr.common.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author BS2
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PeriodoVigenteDTO {
	
	private Date fechaDesde;
	
	private Date fechaHasta;
	
	private BigDecimal codPeriodo;
	
}
