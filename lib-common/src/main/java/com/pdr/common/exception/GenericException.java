package com.pdr.common.exception;


/**
 * Excepcion manejadoras de errores en service
 * @author NelsonAlvaradoVidal
 *
 */
public class GenericException extends RuntimeException {
	
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public GenericException() {
          super();
      }
      public GenericException(String s) {
          super(s);
      }
      public GenericException(String s, Throwable throwable) {
          super(s, throwable);
      }
      public GenericException(Throwable throwable) {
          super(throwable);
      }

}
