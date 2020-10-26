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
@Table(name = "CBZ_CAMPANA_PARAM", schema = "CBZPAR")
public class CbzCampanaParamModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1281374282075546292L;
	private long idCcpCampParam;
	private CbzPeriodoConfModel cbzPeriodoConf;
	private CbzPropiedadesModel cbzPropiedades;
	private BigDecimal ccpPpagoDesde;
	private BigDecimal ccpPpagoHasta;
	private BigDecimal ccpCrenegDesde;
	private BigDecimal ccpCrenegHasta;
	private BigDecimal ccpFactorCampana;
	private String ccpNombreCampana;
	private Boolean ccpActiva;
	private String unegCod;
	private String faseCod;
	private String ccpNombreFase;
	private String ccpNombreUneg;

	public CbzCampanaParamModel() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE_CAMPANA_PARAM")
	@SequenceGenerator(name = "ID_SEQUENCE_CAMPANA_PARAM", allocationSize = 1, sequenceName = "SEQ_CAMPANA_PARAM", schema = "CBZPAR")
	@Column(name = "ID_CCP_CAMP_PARAM", unique = true, nullable = false, precision = 16, scale = 0)
	public long getIdCcpCampParam() {
		return this.idCcpCampParam;
	}

	public void setIdCcpCampParam(long idCcpCampParam) {
		this.idCcpCampParam = idCcpCampParam;
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

	@Column(name = "CCP_PPAGO_DESDE", precision = 10, scale = 3)
	public BigDecimal getCcpPpagoDesde() {
		return this.ccpPpagoDesde;
	}

	public void setCcpPpagoDesde(BigDecimal ccpPpagoDesde) {
		this.ccpPpagoDesde = ccpPpagoDesde;
	}

	@Column(name = "CCP_PPAGO_HASTA", precision = 10, scale = 3)
	public BigDecimal getCcpPpagoHasta() {
		return this.ccpPpagoHasta;
	}

	public void setCcpPpagoHasta(BigDecimal ccpPpagoHasta) {
		this.ccpPpagoHasta = ccpPpagoHasta;
	}

	@Column(name = "CCP_CRENEG_DESDE", precision = 10, scale = 3)
	public BigDecimal getCcpCrenegDesde() {
		return this.ccpCrenegDesde;
	}

	public void setCcpCrenegDesde(BigDecimal ccpCrenegDesde) {
		this.ccpCrenegDesde = ccpCrenegDesde;
	}

	@Column(name = "CCP_CRENEG_HASTA", precision = 10, scale = 3)
	public BigDecimal getCcpCrenegHasta() {
		return this.ccpCrenegHasta;
	}

	public void setCcpCrenegHasta(BigDecimal ccpCrenegHasta) {
		this.ccpCrenegHasta = ccpCrenegHasta;
	}

	@Column(name = "CCP_FACTOR_CAMPANA", precision = 16, scale = 2)
	public BigDecimal getCcpFactorCampana() {
		return this.ccpFactorCampana;
	}

	public void setCcpFactorCampana(BigDecimal ccpFactorCampana) {
		this.ccpFactorCampana = ccpFactorCampana;
	}

	@Column(name = "CCP_NOMBRE_CAMPANA", length = 100)
	public String getCcpNombreCampana() {
		return this.ccpNombreCampana;
	}

	public void setCcpNombreCampana(String ccpNombreCampana) {
		this.ccpNombreCampana = ccpNombreCampana;
	}

	@Column(name = "CCP_ACTIVA", precision = 1, scale = 0)
	public Boolean getCcpActiva() {
		return this.ccpActiva;
	}

	public void setCcpActiva(Boolean ccpActiva) {
		this.ccpActiva = ccpActiva;
	}

	@Column(name = "UNEG_COD", nullable = false, length = 10)
	public String getUnegCod() {
		return this.unegCod;
	}

	public void setUnegCod(String unegCod) {
		this.unegCod = unegCod;
	}

	@Column(name = "FASE_COD", nullable = false, length = 20)
	public String getFaseCod() {
		return this.faseCod;
	}

	public void setFaseCod(String faseCod) {
		this.faseCod = faseCod;
	}

	@Column(name = "CCP_NOMBRE_FASE", nullable = false, length = 50)
	public String getCcpNombreFase() {
		return this.ccpNombreFase;
	}

	public void setCcpNombreFase(String ccpNombreFase) {
		this.ccpNombreFase = ccpNombreFase;
	}

	@Column(name = "CCP_NOMBRE_UNEG", nullable = false, length = 50)
	public String getCcpNombreUneg() {
		return this.ccpNombreUneg;
	}

	public void setCcpNombreUneg(String ccpNombreUneg) {
		this.ccpNombreUneg = ccpNombreUneg;
	}

}
