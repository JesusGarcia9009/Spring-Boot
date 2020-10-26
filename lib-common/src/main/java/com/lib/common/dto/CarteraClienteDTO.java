/**
 * 
 */
package com.lib.common.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author BS2
 */
@Getter
@Setter
@ToString
public class CarteraClienteDTO {
	
	private String ejecutivo;
	private String comuna;
	private String estado;
	private String contrato;
	private String parque;
	private String grupo;
	private String rutCliente;
	private String nombreCliente;
	private String ultimaGestion;
	private String proximaGestion;
	private BigDecimal saldo;
	private Integer dias;
	private Integer numeroGestiones;
	private String nombreMotorista;
	private BigDecimal vtopCodCont;
	private BigDecimal codPeriodo;
	private BigDecimal idMotorista;
	private Date fechaAsignacion;
	private BigDecimal catpSec;
	private Integer total;

}
