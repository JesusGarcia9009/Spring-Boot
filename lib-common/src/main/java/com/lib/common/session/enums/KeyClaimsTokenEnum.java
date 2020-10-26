package com.lib.common.session.enums;

public enum KeyClaimsTokenEnum {
	
	ID_USUARIO("idUsuario"),
	FULL_NAME("fullName"),
	EMAIL("email"),
	USERNAME("username"),
	PICTURE("picture"),
	AUTHORITIES("authorities"),
	ROLES("roles"),
	RUT("rut"),
	USERINPUT("userinput"),
	TOKEN("token"),
	PERFILES("perfiles"),
	APLICACIONES("aplicaciones");
	
	private String descripcion;
	
	KeyClaimsTokenEnum(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
