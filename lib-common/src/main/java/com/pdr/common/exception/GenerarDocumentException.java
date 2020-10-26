package com.pdr.common.exception;

/**
 * Excepcion para manejar que no se halla podido descargar e documento asociado
 * @author BS2
 *
 */
public class GenerarDocumentException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mensaje;

	public static GenerarDocumentException createWith(String mensaje) {
		return new GenerarDocumentException(mensaje);
	}

	private GenerarDocumentException(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String getMessage() {
		return mensaje;
	}
}
