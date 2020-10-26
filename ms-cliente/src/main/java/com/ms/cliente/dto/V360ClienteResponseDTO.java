package com.ms.cliente.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class V360ClienteResponseDTO {

	private String persTipoId;
	private String persId;
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

	public V360ClienteResponseDTO(String persTipoId, String persId, String persDigVer, String persApePat,
			String persApeMat, String persNombres, String persRazonSocial, String persNomFantasia, String persNivelEduc,
			Date persFecNac, Date persFecDefun, String persEdadDefun, String persEstCivil, String persNaci,
			String persSexo, String persTipo, String persGiro, String persUserMod, Date persFecMod) {
		super();
		this.persTipoId = persTipoId;
		this.persId = persId;
		this.persDigVer = persDigVer;
		this.persApePat = persApePat;
		this.persApeMat = persApeMat;
		this.persNombres = persNombres;
		this.persRazonSocial = persRazonSocial;
		this.persNomFantasia = persNomFantasia;
		this.persNivelEduc = persNivelEduc;
		this.persFecNac = persFecNac;
		this.persFecDefun = persFecDefun;
		this.persEdadDefun = persEdadDefun;
		this.persEstCivil = persEstCivil;
		this.persNaci = persNaci;
		this.persSexo = persSexo;
		this.persTipo = persTipo;
		this.persGiro = persGiro;
		this.persUserMod = persUserMod;
		this.persFecMod = persFecMod;
	}

	public V360ClienteResponseDTO() {
		super();
	}

}
