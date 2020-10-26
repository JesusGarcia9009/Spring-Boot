package com.ms.cliente.dto;

import java.util.Date;

import com.pdr.common.cobranza.entity.GenPersonasIdModel;

import lombok.Getter;
import lombok.Setter;

/**
 * @author BS2
 */
@Getter
@Setter
public class GenPersonasDTO {

	

	private GenPersonasIdModel id;
	private String persDigVer;
	private String persApePat;
	private String persApeMat;
	private String persNombres;
	private String persRazonSocial;
	private String persNomFantasia;
	private String persNivelEduc;
	private Date persFecNac;
	private Date persFecDefun;
	private String persEdadDefun;
	private String persEstCivil;
	private String persNaci;
	private String persSexo;
	private String persTipo;
	private String persGiro;
	private String persUserMod;
	private Date persFecMod;
}
