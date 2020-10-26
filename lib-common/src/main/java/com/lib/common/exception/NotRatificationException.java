package com.lib.common.exception;

public class NotRatificationException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String campo;

    public static NotRatificationException createWith(String campo) {
        return new NotRatificationException(campo);
    }

    private NotRatificationException(String campo) {
        this.campo = campo;
    }

    @Override
    public String getMessage() {
        return "Campo '" + campo + "' no ha sido ratificado";
    }
}
