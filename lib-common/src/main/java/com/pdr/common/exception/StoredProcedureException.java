package com.pdr.common.exception;

public class StoredProcedureException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String SP;
	private String codigoError;
	private String textoError;

    public static StoredProcedureException createWith(String SP, String codigoError, String textoError) {
        return new StoredProcedureException( SP,  codigoError,  textoError);
    }

    private StoredProcedureException(String SP, String codigoError, String textoError) {
    	this.SP = SP;
    	this.codigoError = codigoError;
    	this.textoError = textoError;
    }

    @Override
    public String getMessage() {
        return "El procedimiento almacenado '" + SP + "' falló, " + "el codigo del Error es '" + codigoError + "' y su descripcion es '" + textoError + "'. " ;
    }
}
