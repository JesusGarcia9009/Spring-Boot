package com.lib.common.dto.solp;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author BS2
 */
public class AplicacionSolpDTO {

	@JsonProperty
	@JsonAlias("ID_APPLICATION")
	private String idAplicacion;
	
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
	@JsonAlias("PACKAGE_NAME")
	private String packageName;
	
	@JsonProperty
	@JsonAlias("VALID")
	private Character valid;
	
	@JsonProperty
	@JsonAlias("ID_APPLICATION_IMAGE")
	private String idAplicacionImagen;
	
	@JsonProperty
	@JsonAlias("APPLICATION_TYPE")
	private String aplicacionTipo;
	
	@JsonProperty
	@JsonAlias("ID_PROFILE_APPLICATION")
	private String idPerfilAplicacion;
	
	@JsonProperty
	@JsonAlias("LANDING_PAGE")
	private Character isLanding;
	
	@JsonProperty
	@JsonAlias("IMAGEN")
	private String icon;
	
	@JsonProperty
	@JsonAlias("COLOR")
	private String color;
	
	@JsonProperty
	@JsonAlias("NAVITEMS")
	private HashMap<String, ElementoDTO> elementos = new HashMap<String, ElementoDTO>();
	
	public AplicacionSolpDTO() {
		super();
	}

	public String getIdAplicacion() {
		return idAplicacion;
	}

	public void setIdAplicacion(String idAplicacion) {
		this.idAplicacion = idAplicacion;
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

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public Character getValid() {
		return valid;
	}

	public void setValid(Character valid) {
		this.valid = valid;
	}

	public String getIdAplicacionImagen() {
		return idAplicacionImagen;
	}

	public void setIdAplicacionImagen(String idAplicacionImagen) {
		this.idAplicacionImagen = idAplicacionImagen;
	}

	public String getAplicacionTipo() {
		return aplicacionTipo;
	}

	public void setAplicacionTipo(String aplicacionTipo) {
		this.aplicacionTipo = aplicacionTipo;
	}

	public String getIdPerfilAplicacion() {
		return idPerfilAplicacion;
	}

	public void setIdPerfilAplicacion(String idPerfilAplicacion) {
		this.idPerfilAplicacion = idPerfilAplicacion;
	}

	public HashMap<String, ElementoDTO> getElementos() {
		return elementos;
	}

	public void setElementos(HashMap<String, ElementoDTO> elementos) {
		this.elementos = elementos;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Character getIsLanding() {
		return isLanding;
	}

	public void setIsLanding(Character isLanding) {
		this.isLanding = isLanding;
	}
	
	

	
	
}
