/**
 * 
 */
package com.lib.common.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.lib.common.dto.CarteraClienteDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author BS2
 */
@Getter
@Setter
@ToString
public class CarteraVigenteDTO {
	
	private Date fechaDesde;
	
	private Date fechaHasta;
	
	private BigDecimal codPeriodo;
	
	private String persIdCob;
	
	private Integer total;
	
	private List<CarteraClienteDTO> listado ;
	
	public CarteraVigenteDTO() {
		super();
	}

	public CarteraVigenteDTO(Date fechaDesde, Date fechaHasta, BigDecimal codPeriodo) {
		super();
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
		this.codPeriodo = codPeriodo;
	}

}
