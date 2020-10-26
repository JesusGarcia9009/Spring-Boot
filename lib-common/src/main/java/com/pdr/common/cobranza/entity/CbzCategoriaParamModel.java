package com.pdr.common.cobranza.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author BS2
 */
@Entity
@Table(name = "CBZ_CATEGORIA_PARAM", schema = "CBZPAR")
public class CbzCategoriaParamModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8397888689210330963L;
	private int idCcpCategoria;
	private CbzPeriodoConfModel cbzPeriodoConf;
	private CbzPropiedadesModel cbzPropiedades;
	private CbzPropiedadesModel cbzPropiedadesByIdCpPropCategoria;
	private Short ccpCvencDesde;
	private Integer ccpCvencHasta;
	private BigDecimal ccpTieneSepultados;
	private BigDecimal ccpActivo;

	public CbzCategoriaParamModel() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE_CATEGORIA_PARAM")
	@SequenceGenerator(name = "ID_SEQUENCE_CATEGORIA_PARAM", allocationSize = 1, sequenceName = "SEQ_CATEGORIA_PARAM", schema = "CBZPAR")
	@Column(name = "ID_CCP_CATEGORIA", unique = true, nullable = false, precision = 8, scale = 0)
	public int getIdCcpCategoria() {
		return this.idCcpCategoria;
	}

	public void setIdCcpCategoria(int idCcpCategoria) {
		this.idCcpCategoria = idCcpCategoria;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CPC_PERIODO", nullable = false)
	public CbzPeriodoConfModel getCbzPeriodoConf() {
		return this.cbzPeriodoConf;
	}

	public void setCbzPeriodoConf(CbzPeriodoConfModel cbzPeriodoConf) {
		this.cbzPeriodoConf = cbzPeriodoConf;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CP_PROP_CARTERA")
	public CbzPropiedadesModel getCbzPropiedades() {
		return this.cbzPropiedades;
	}

	public void setCbzPropiedades(CbzPropiedadesModel cbzPropiedades) {
		this.cbzPropiedades = cbzPropiedades;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CP_PROP_CATEGORIA")
	public CbzPropiedadesModel getCbzPropiedadesByIdCpPropCategoria() {
		return this.cbzPropiedadesByIdCpPropCategoria;
	}

	public void setCbzPropiedadesByIdCpPropCategoria(CbzPropiedadesModel cbzPropiedadesByIdCpPropCategoria) {
		this.cbzPropiedadesByIdCpPropCategoria = cbzPropiedadesByIdCpPropCategoria;
	}

	@Column(name = "CCP_CVENC_DESDE", precision = 3, scale = 0)
	public Short getCcpCvencDesde() {
		return this.ccpCvencDesde;
	}

	public void setCcpCvencDesde(Short ccpCvencDesde) {
		this.ccpCvencDesde = ccpCvencDesde;
	}

	@Column(name = "CCP_CVENC_HASTA", precision = 8, scale = 0)
	public Integer getCcpCvencHasta() {
		return this.ccpCvencHasta;
	}

	public void setCcpCvencHasta(Integer ccpCvencHasta) {
		this.ccpCvencHasta = ccpCvencHasta;
	}

	@Column(name = "CCP_TIENE_SEPULTADOS", precision = 22, scale = 0)
	public BigDecimal getCcpTieneSepultados() {
		return this.ccpTieneSepultados;
	}

	public void setCcpTieneSepultados(BigDecimal ccpTieneSepultados) {
		this.ccpTieneSepultados = ccpTieneSepultados;
	}

	@Column(name = "CCP_ACTIVO", precision = 22, scale = 0)
	public BigDecimal getCcpActivo() {
		return this.ccpActivo;
	}

	public void setCcpActivo(BigDecimal ccpActivo) {
		this.ccpActivo = ccpActivo;
	}

}
