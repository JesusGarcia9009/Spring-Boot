package com.pdr.common.exception;

/**
 * Excepcion para manejar la dependencias de un objeto
 * @author BS2
 *
 */
public class DependencyException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String dependecy;

    public static DependencyException createWith(String dependecy) {
        return new DependencyException(dependecy);
    }

    private DependencyException(String dependecy) {
        this.dependecy = dependecy;
    }

    @Override
    public String getMessage() {
        return "Dependency '" + dependecy + "' no encontrado";
    }
}
