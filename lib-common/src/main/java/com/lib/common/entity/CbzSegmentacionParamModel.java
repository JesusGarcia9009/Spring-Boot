package com.lib.common.entity;

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
@Table(name = "CBZ_SEGMENTACION_PARAM", schema = "CBZPAR")
public class CbzSegmentacionParamModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8416058252310175755L;
	private int idCspSegmentacion;
	private CbzPeriodoConfModel cbzPeriodoConf;
	private CbzPropiedadesModel cbzPropiedadesByIdCpPropSegmenCat;
	private CbzPropiedadesModel cbzPropiedadesByIdCpPropCartera;
	private BigDecimal cspPpagoDesde;
	private BigDecimal cspPpagoHasta;
	private BigDecimal cspCrenegDesde;
	private BigDecimal cspCrenegHasta;
	private BigDecimal cspTrimestreDesde;
	private BigDecimal cspTrimestreHasta;
	private Boolean cspSegmentacionActivo;

	public CbzSegmentacionParamModel() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE_SEGMENTACION_PARAM")
	@SequenceGenerator(name = "ID_SEQUENCE_SEGMENTACION_PARAM", allocationSize = 1, sequenceName = "SEQ_SEGMENTACION_PARAM", schema = "CBZPAR")
	@Column(name = "ID_CSP_SEGMENTACION", unique = true, nullable = false, precision = 8, scale = 0)
	public int getIdCspSegmentacion() {
		return this.idCspSegmentacion;
	}

	public void setIdCspSegmentacion(int idCspSegmentacion) {
		this.idCspSegmentacion = idCspSegmentacion;
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
	@JoinColumn(name = "ID_CP_PROP_SEGMEN_CAT")
	public CbzPropiedadesModel getCbzPropiedadesByIdCpPropSegmenCat() {
		return this.cbzPropiedadesByIdCpPropSegmenCat;
	}

	public void setCbzPropiedadesByIdCpPropSegmenCat(CbzPropiedadesModel cbzPropiedadesByIdCpPropSegmenCat) {
		this.cbzPropiedadesByIdCpPropSegmenCat = cbzPropiedadesByIdCpPropSegmenCat;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CP_PROP_CARTERA")
	public CbzPropiedadesModel getCbzPropiedadesByIdCpPropCartera() {
		return this.cbzPropiedadesByIdCpPropCartera;
	}

	public void setCbzPropiedadesByIdCpPropCartera(CbzPropiedadesModel cbzPropiedadesByIdCpPropCartera) {
		this.cbzPropiedadesByIdCpPropCartera = cbzPropiedadesByIdCpPropCartera;
	}

	@Column(name = "CSP_PPAGO_DESDE", precision = 10, scale = 3)
	public BigDecimal getCspPpagoDesde() {
		return this.cspPpagoDesde;
	}

	public void setCspPpagoDesde(BigDecimal cspPpagoDesde) {
		this.cspPpagoDesde = cspPpagoDesde;
	}

	@Column(name = "CSP_PPAGO_HASTA", precision = 10, scale = 3)
	public BigDecimal getCspPpagoHasta() {
		return this.cspPpagoHasta;
	}

	public void setCspPpagoHasta(BigDecimal cspPpagoHasta) {
		this.cspPpagoHasta = cspPpagoHasta;
	}

	@Column(name = "CSP_CRENEG_DESDE", precision = 10, scale = 0)
	public BigDecimal getCspCrenegDesde() {
		return this.cspCrenegDesde;
	}

	public void setCspCrenegDesde(BigDecimal cspCrenegDesde) {
		this.cspCrenegDesde = cspCrenegDesde;
	}

	@Column(name = "CSP_CRENEG_HASTA", precision = 10, scale = 0)
	public BigDecimal getCspCrenegHasta() {
		return this.cspCrenegHasta;
	}

	public void setCspCrenegHasta(BigDecimal cspCrenegHasta) {
		this.cspCrenegHasta = cspCrenegHasta;
	}

	@Column(name = "CSP_TRIMESTRE_DESDE", precision = 10, scale = 0)
	public BigDecimal getCspTrimestreDesde() {
		return this.cspTrimestreDesde;
	}

	public void setCspTrimestreDesde(BigDecimal cspTrimestreDesde) {
		this.cspTrimestreDesde = cspTrimestreDesde;
	}

	@Column(name = "CSP_TRIMESTRE_HASTA", precision = 10, scale = 0)
	public BigDecimal getCspTrimestreHasta() {
		return this.cspTrimestreHasta;
	}

	public void setCspTrimestreHasta(BigDecimal cspTrimestreHasta) {
		this.cspTrimestreHasta = cspTrimestreHasta;
	}

	@Column(name = "CSP_SEGMENTACION_ACTIVO", precision = 1, scale = 0)
	public Boolean getCspSegmentacionActivo() {
		return this.cspSegmentacionActivo;
	}

	public void setCspSegmentacionActivo(Boolean cspSegmentacionActivo) {
		this.cspSegmentacionActivo = cspSegmentacionActivo;
	}

}
