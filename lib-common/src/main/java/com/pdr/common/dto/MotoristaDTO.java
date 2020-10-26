package com.pdr.common.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author BS2
 */
@Getter
@Setter
public class MotoristaDTO {

	private String rutMotorista;
	private String nombreMotorista;
	
	public MotoristaDTO(String rutMotorista, String nombreMotorista) {
		super();
		this.rutMotorista = rutMotorista;
		this.nombreMotorista = nombreMotorista;
	}
	
	public MotoristaDTO() {
		super();
	}
	
}
