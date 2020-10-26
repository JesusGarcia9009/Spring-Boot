/**
 * 
 */
package com.ms.cliente.dto;

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
public class GenDireccionesResponse {

	private BigDecimal direSec;

	private String direTipo;

	private String direCalle;

	private String direNumero;

	private String direRestoDire;

	private String direCodPostal;

	private String direNac;

	private String direPais;

	private String direEstaCod;

	private String direIndVerif;

	private Date direFecVerif;

	private BigDecimal soscSec;

	private BigDecimal contNumOpe;

	private BigDecimal reinSec;

	private String direUserMod;

	private Date direFecMod;

	private String tipoDocto;

	private BigDecimal numDocto;

	private String direIndEnvCorr;

	// nombre de la comuna
	private String comuDesc;
	
	public GenDireccionesResponse() {
		
	}

	public GenDireccionesResponse(String direCalle, String direNumero, String direRestoDire, String comuDesc,
			Date direFecMod, String direUserMod) {
		super();
		this.direCalle = direCalle;
		this.direNumero = direNumero;
		this.direRestoDire = direRestoDire;
		this.direUserMod = direUserMod;
		this.direFecMod = direFecMod;
		this.comuDesc = comuDesc;
	}

	public GenDireccionesResponse(BigDecimal direSec, String direTipo, String direCalle, String direNumero,
			String direRestoDire, String direCodPostal, String direNac, String direPais, String direEstaCod,
			String direIndVerif, Date direFecVerif, BigDecimal soscSec, BigDecimal contNumOpe, BigDecimal reinSec,
			String direUserMod, Date direFecMod, String tipoDocto, BigDecimal numDocto, String direIndEnvCorr,
			String comuDesc) {
		super();
		this.direSec = direSec;
		this.direTipo = direTipo;
		this.direCalle = direCalle;
		this.direNumero = direNumero;
		this.direRestoDire = direRestoDire;
		this.direCodPostal = direCodPostal;
		this.direNac = direNac;
		this.direPais = direPais;
		this.direEstaCod = direEstaCod;
		this.direIndVerif = direIndVerif;
		this.direFecVerif = direFecVerif;
		this.soscSec = soscSec;
		this.contNumOpe = contNumOpe;
		this.reinSec = reinSec;
		this.direUserMod = direUserMod;
		this.direFecMod = direFecMod;
		this.tipoDocto = tipoDocto;
		this.numDocto = numDocto;
		this.direIndEnvCorr = direIndEnvCorr;
		this.comuDesc = comuDesc;
	}
	
	
}
