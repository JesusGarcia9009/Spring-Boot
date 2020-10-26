package com.lib.common.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author BS2
 */
@Entity
@Table(name = "CBZ_SISTEMAS_PROP", schema = "CBZPAR")
public class CbzSistemasPropModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3545313547552599072L;
	private int idCspSistema;
	private String cspSistemasDesc;
	private BigDecimal cspActivo;
	

	public CbzSistemasPropModel() {
	}

	@Id
	@Column(name = "ID_CSP_SISTEMA", unique = true, nullable = false, precision = 8, scale = 0)
	public int getIdCspSistema() {
		return this.idCspSistema;
	}

	public void setIdCspSistema(int idCspSistema) {
		this.idCspSistema = idCspSistema;
	}

	@Column(name = "CSP_SISTEMAS_DESC", length = 50)
	public String getCspSistemasDesc() {
		return this.cspSistemasDesc;
	}

	public void setCspSistemasDesc(String cspSistemasDesc) {
		this.cspSistemasDesc = cspSistemasDesc;
	}

	@Column(name = "CSP_ACTIVO", precision = 22, scale = 0)
	public BigDecimal getCspActivo() {
		return this.cspActivo;
	}

	public void setCspActivo(BigDecimal cspActivo) {
		this.cspActivo = cspActivo;
	}

}
