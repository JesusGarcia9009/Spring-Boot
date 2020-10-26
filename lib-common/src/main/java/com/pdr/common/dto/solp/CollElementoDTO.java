package com.pdr.common.dto.solp;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author BS2
 */
public class CollElementoDTO {
	
	@JsonProperty
	@JsonAlias("NAME")
	private String nombre;
	
	@JsonProperty
	@JsonAlias("DESCRIPTION")
	private String descripcion;
	
	@JsonProperty
	@JsonAlias("URL")
	private String url;
	
	@JsonProperty
	@JsonAlias("VALID")
	private Character valid;

	public CollElementoDTO() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Character getValid() {
		return valid;
	}

	public void setValid(Character valid) {
		this.valid = valid;
	}

	
	
}
