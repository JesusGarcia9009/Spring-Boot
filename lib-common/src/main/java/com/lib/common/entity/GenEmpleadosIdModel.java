package com.lib.common.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

/**
 * @author BS2
 */
@Data
@Embeddable
public class GenEmpleadosIdModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "PERS_TIPO_ID", nullable = false, length = 4)
	private String persTipoId;
	
	@Column(name = "PERS_ID", nullable = false, length = 10)
	private String persId;

}
