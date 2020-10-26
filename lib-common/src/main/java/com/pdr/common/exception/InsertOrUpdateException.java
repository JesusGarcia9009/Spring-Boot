package com.pdr.common.exception;

public class InsertOrUpdateException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String metodo;

    public static InsertOrUpdateException createWith(String metodo) {
        return new InsertOrUpdateException(metodo);
    }

    private InsertOrUpdateException(String metodo) {
        this.metodo = metodo;
    }

    @Override
    public String getMessage() {
        return "Se ha producido un error al actualizar o crear";
    }
}
