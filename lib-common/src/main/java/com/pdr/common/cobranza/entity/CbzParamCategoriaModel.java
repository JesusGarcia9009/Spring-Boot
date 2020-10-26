package com.pdr.common.cobranza.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Generated by BS2
 */
@Entity
@Table(name = "CBZ_PARAM_CATEGORIA", schema = "CBZPAR")
public class CbzParamCategoriaModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal idParamCategoria;
	private String parcatDescripcion;
	private BigDecimal parcatSepultado;
	private long parcatCuotVenciDesde;
	private long parcatCuotVenciHasta;

	public CbzParamCategoriaModel() {
	}

	@Id
	@Column(name = "ID_PARAM_CATEGORIA", unique = true, nullable = false, precision = 23, scale = 0)
	public BigDecimal getIdParamCategoria() {
		return this.idParamCategoria;
	}

	public void setIdParamCategoria(BigDecimal idParamCategoria) {
		this.idParamCategoria = idParamCategoria;
	}

	@Column(name = "PARCAT_DESCRIPCION", nullable = false, length = 100)
	public String getParcatDescripcion() {
		return this.parcatDescripcion;
	}

	public void setParcatDescripcion(String parcatDescripcion) {
		this.parcatDescripcion = parcatDescripcion;
	}

	@Column(name = "PARCAT_SEPULTADO", nullable = false, precision = 22, scale = 0)
	public BigDecimal getParcatSepultado() {
		return this.parcatSepultado;
	}

	public void setParcatSepultado(BigDecimal parcatSepultado) {
		this.parcatSepultado = parcatSepultado;
	}

	@Column(name = "PARCAT_CUOT_VENCI_DESDE", nullable = false, precision = 16, scale = 0)
	public long getParcatCuotVenciDesde() {
		return this.parcatCuotVenciDesde;
	}

	public void setParcatCuotVenciDesde(long parcatCuotVenciDesde) {
		this.parcatCuotVenciDesde = parcatCuotVenciDesde;
	}

	@Column(name = "PARCAT_CUOT_VENCI_HASTA", nullable = false, precision = 16, scale = 0)
	public long getParcatCuotVenciHasta() {
		return this.parcatCuotVenciHasta;
	}

	public void setParcatCuotVenciHasta(long parcatCuotVenciHasta) {
		this.parcatCuotVenciHasta = parcatCuotVenciHasta;
	}

}
