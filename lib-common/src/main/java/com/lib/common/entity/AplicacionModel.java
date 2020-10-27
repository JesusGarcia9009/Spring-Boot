/**
 * 
 */
package com.lib.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase Entidad Usuario, contiene todos los datos de los usuarios del sistema
 * 
 * @author Demo
 * @version 1.0 Creacion
 * @since Java 11
 */
@Entity
@Table(name = "aplicacion")
public class AplicacionModel {
    
	@Id
    @GeneratedValue
    @Column(name = "id_aplicacion", nullable = false)
    public Long idAplicacion;
 
    @Column(name = "url", length = 200, nullable = false)
    public String url;
    
    @Column(name = "nombre", length = 50, nullable = false)
    public String nombre;
    
    @Column(name = "descripcion", length = 50, nullable = false)
    public String descripcion;
    
    @Column(name = "icono", length = 50, nullable = false)
    public String icono;
    
    @Column(name = "color", length = 50, nullable = false)
    public String color;

	public AplicacionModel(Long idAplicacion, String url, String nombre, String descripcion, String icono,
			String color) {
		super();
		this.idAplicacion = idAplicacion;
		this.url = url;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.icono = icono;
		this.color = color;
	}

	public AplicacionModel() {
		super();
	}

	public Long getIdAplicacion() {
		return idAplicacion;
	}

	public void setIdAplicacion(Long idAplicacion) {
		this.idAplicacion = idAplicacion;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "AplicacionModel [idAplicacion=" + idAplicacion + ", url=" + url + ", nombre=" + nombre
				+ ", descripcion=" + descripcion + ", icono=" + icono + ", color=" + color + "]";
	}
    
    
}
