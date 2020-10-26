package com.pdr.common.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PersonaDTO {
	
	private String persTipoId;
	private String persId;
	private String estaDom = "";
	
	private String serieCod = "";
	private Long doctoFolio = 0L;
	private String tipoQuery = "";
	private Long numOper = 0L;
	CommonRequestDTO commonRequest;

}
