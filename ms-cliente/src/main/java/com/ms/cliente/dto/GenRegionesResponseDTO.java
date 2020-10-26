package com.ms.cliente.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

/**
 * @author BS2
 */
@Getter
@Setter
public class GenRegionesResponseDTO implements java.io.Serializable {

	private static final long serialVersionUID = 86635137209669454L;

	private Integer regiCod;

	private String regiNumRoma;

	private String regiDesc;

	@Transient
	private List<GenComunasResponseDTO> genComunas = new ArrayList<>(0);
	
	public GenRegionesResponseDTO(Integer regiCod, String regiNumRoma, String regiDesc) {
		super();
		this.regiCod = regiCod;
		this.regiNumRoma = regiNumRoma;
		this.regiDesc = regiDesc;
	}

}
