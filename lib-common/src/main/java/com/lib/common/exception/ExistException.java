package com.lib.common.exception;


/**
 * Excepcion para manejar Status 403
 * @author BS2
 *
 */
public class ExistException extends RuntimeException {
	
	
	private static final long serialVersionUID = 1L;
	private String dependecy;

    public static ExistException createWith(String dependecy) {
        return new ExistException(dependecy);
    }

    private ExistException(String dependecy) {
        this.dependecy = dependecy;
    }

    @Override
    public String getMessage() {
        return "El objeto '" + dependecy + "' ya fue creado anteriormente";
    }

}
