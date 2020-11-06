package com.session.exception;

/**
 * 
 * 
 * @author nalva
 *
 */
public class NotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String value;

	public static NotFoundException createWith(String dependecy) {
		return new NotFoundException(dependecy);
	}

	private NotFoundException(String dependecy) {
		this.value = dependecy;
	}

	@Override
	public String getMessage() {
		return "Elemento '" + value + "' no encontrado";
	}

}
