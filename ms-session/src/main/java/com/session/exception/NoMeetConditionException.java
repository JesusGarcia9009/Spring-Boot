package com.session.exception;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

/**
 * Clase de excepcion que bindea resultado en lista de errores
 * @see BindingErrorsUtil
 * 
 * @author nalva
 *
 */
public class NoMeetConditionException  extends MethodArgumentNotValidException{

	public NoMeetConditionException(BindingResult bindingResult) {
			super(null, bindingResult);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
