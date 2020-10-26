package com.lib.common.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProcMotoristaDTO {
	
	private String serie;	
	private String folio;	
	private String nombre;	
	private String rut;	
	private BigDecimal idUser;
	private BigDecimal catpSec;
	private String cartera;
	private String resultado;
	private String motivo;
	private Date fecha;

}
