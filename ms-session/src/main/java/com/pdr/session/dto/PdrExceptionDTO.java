package com.pdr.session.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PdrExceptionDTO {

	private String code;
	private String message;
	private String cause;
}
