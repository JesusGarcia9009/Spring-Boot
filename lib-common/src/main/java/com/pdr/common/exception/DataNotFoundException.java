package com.pdr.common.exception;

/**
 * Excepcion para manejar el no contenido
 * @author BS2
 *
 */
public class DataNotFoundException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String detalle;

    public static DataNotFoundException createWith(String detalle) {
        return new DataNotFoundException(detalle);
    }

    private DataNotFoundException(String detalle) {
        this.detalle = detalle;
    }

    @Override
    public String getMessage() {
        return "servicio no tiene informacion[" + detalle + "]";
    }
}
