package com.session.exception;

public class ValidacionException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;

    public static ValidacionException createWith(String username) {
        return new ValidacionException(username);
    }

    private ValidacionException(String username) {
        this.username = username;
    }

    @Override
    public String getMessage() {
        return "Usuario '" + username + "' no encontrado";
    }
}
