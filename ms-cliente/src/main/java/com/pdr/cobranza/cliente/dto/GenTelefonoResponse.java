/**
 * 
 */
package com.pdr.cobranza.cliente.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.pdr.common.cobranza.entity.GenPersonasIdModel;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author BS2
 */
@Getter
@Setter
@ToString
public class GenTelefonoResponse {

	private BigDecimal fonoSec;
	
	private String fonoTipo;
	
	private String fonoNumero;
	
	private String fonoArea;
	
	private BigDecimal soscSec;
	
	private String tipoDocto;
	
	private BigDecimal numDocto;
	
	private String fonoIndCelu;
	
	private String fonoUserMod;
	
	private Date fonoFecMod;
	
	private String fonoNumeroResp;
	
	private GenPersonasIdModel idPersona;
}
