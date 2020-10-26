/**
 * 
 */
package com.lib.common.dto.solp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author BS2
 */
public class ElementoDTO {
	
	@JsonProperty
	@JsonAlias("ICONO")
	private String icono;
	
	
	@JsonProperty
	@JsonAlias("ID_SUB_MENU_APPLICATION")
	private BigDecimal idSubMenuAplicacion;
	
	
	@JsonProperty
	@JsonAlias("DATATARGET")
	private String dataTarget;
	
	
	@JsonProperty
	@JsonAlias("NAME")
	private String nombre;
	
	
	@JsonProperty
	@JsonAlias("URL")
	private String url;
	
	
	@JsonProperty
	@JsonAlias("VALID")
	private Character valid;
	
	@JsonProperty
	@JsonAlias("COLLAPSEDCOMPONENT")
	private List<CollComponenteDTO> collapsedComponent = new ArrayList<>();
	
	public ElementoDTO() {
		super();
	}

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public BigDecimal getIdSubMenuAplicacion() {
		return idSubMenuAplicacion;
	}

	public void setIdSubMenuAplicacion(BigDecimal idSubMenuAplicacion) {
		this.idSubMenuAplicacion = idSubMenuAplicacion;
	}

	public String getDataTarget() {
		return dataTarget;
	}

	public void setDataTarget(String dataTarget) {
		this.dataTarget = dataTarget;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<CollComponenteDTO> getCollapsedComponent() {
		return collapsedComponent;
	}

	public void setCollapsedComponent(List<CollComponenteDTO> collapsedComponent) {
		this.collapsedComponent = collapsedComponent;
	}

	public Character getValid() {
		return valid;
	}

	public void setValid(Character valid) {
		this.valid = valid;
	}


	

}
