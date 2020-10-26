package com.ms.cliente.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author BS2
 */
@Getter
@Setter
public class GenComunasResponseDTO implements java.io.Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1491648761919663775L;
	private String comuCod;
	private String ciudCod;
	private String comuDesc;
	private Integer regiCod;
	
	public GenComunasResponseDTO() {}
	
	public GenComunasResponseDTO(String comuCod, String ciudCod, String comuDesc, Integer regiCod) {
		super();
		this.comuCod = comuCod;
		this.ciudCod = ciudCod;
		this.comuDesc = comuDesc;
		this.regiCod = regiCod;
	}
	
	
}
