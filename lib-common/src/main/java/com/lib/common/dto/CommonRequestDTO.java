package com.lib.common.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonRequestDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long count = 0L;
	private Long offSet = 0L;
	private Long numReg = 0L;
	private Long totReg;
	private Long codError;
	private String descError;
	private String orderBy = "";
}
