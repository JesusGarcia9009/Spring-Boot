package com.lib.common.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author BS2
 */
@Entity
@Table(name = "CBZ_PROPIEDADES", schema = "CBZPAR")
public class CbzPropiedadesModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -456093265100163847L;
	private int idCpPropiedades;
	private CbzPropTipoModel cbzPropTipo;
	private String cpPropKey;
	private String cpPropValue;
	private Integer cpPropAgrupador;
	private BigDecimal cpActivo;
	private int idCspSistema;
	private Set<CbzAbminimParamModel> cbzAbminimParams = new HashSet<>(0);
	private Set<CbzSegmentacionParamModel> cbzSegmentacionParamsForIdCpPropSegmenCat = new HashSet<>(0);
	private Set<CbzCategoriaParamModel> cbzCategoriaParams = new HashSet<>(0);
	private Set<CbzPeriodoConfModel> cbzPeriodoConfs = new HashSet<>(0);
	private Set<CbzSegmentacionParamModel> cbzSegmentacionParamsForIdCpPropCartera = new HashSet<>(0);
	private Set<CbzObenchParamModel> cbzObenchParams = new HashSet<>(0);
	private Set<CbzCampanaParamModel> cbzCampanaParams = new HashSet<>(0);

	public CbzPropiedadesModel() {
	}

	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE_PROPIEDADES")
	@SequenceGenerator(name = "ID_SEQUENCE_PROPIEDADES", allocationSize = 1, sequenceName = "SEQ_PROPIEDADES", schema = "CBZPAR")
	@Column(name = "ID_CP_PROPIEDADES", unique = true, nullable = false, precision = 8, scale = 0)
	public int getIdCpPropiedades() {
		return this.idCpPropiedades;
	}

	public void setIdCpPropiedades(int idCpPropiedades) {
		this.idCpPropiedades = idCpPropiedades;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CPT_TIPO", nullable = false)
	public CbzPropTipoModel getCbzPropTipo() {
		return this.cbzPropTipo;
	}

	public void setCbzPropTipo(CbzPropTipoModel cbzPropTipo) {
		this.cbzPropTipo = cbzPropTipo;
	}

	@Column(name = "CP_PROP_KEY", length = 100)
	public String getCpPropKey() {
		return this.cpPropKey;
	}

	public void setCpPropKey(String cpPropKey) {
		this.cpPropKey = cpPropKey;
	}

	@Column(name = "CP_PROP_VALUE", length = 100)
	public String getCpPropValue() {
		return this.cpPropValue;
	}

	public void setCpPropValue(String cpPropValue) {
		this.cpPropValue = cpPropValue;
	}

	@Column(name = "CP_PROP_AGRUPADOR", precision = 8, scale = 0)
	public Integer getCpPropAgrupador() {
		return this.cpPropAgrupador;
	}

	public void setCpPropAgrupador(Integer cpPropAgrupador) {
		this.cpPropAgrupador = cpPropAgrupador;
	}

	@Column(name = "CP_ACTIVO", precision = 22, scale = 0)
	public BigDecimal getCpActivo() {
		return this.cpActivo;
	}

	public void setCpActivo(BigDecimal cpActivo) {
		this.cpActivo = cpActivo;
	}

	@Column(name = "ID_CSP_SISTEMA", nullable = false, precision = 8, scale = 0)
	public int getIdCspSistema() {
		return this.idCspSistema;
	}

	public void setIdCspSistema(int idCspSistema) {
		this.idCspSistema = idCspSistema;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cbzPropiedades")
	public Set<CbzAbminimParamModel> getCbzAbminimParams() {
		return this.cbzAbminimParams;
	}

	public void setCbzAbminimParams(Set<CbzAbminimParamModel> cbzAbminimParams) {
		this.cbzAbminimParams = cbzAbminimParams;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cbzPropiedadesByIdCpPropSegmenCat")
	public Set<CbzSegmentacionParamModel> getCbzSegmentacionParamsForIdCpPropSegmenCat() {
		return this.cbzSegmentacionParamsForIdCpPropSegmenCat;
	}

	public void setCbzSegmentacionParamsForIdCpPropSegmenCat(
			Set<CbzSegmentacionParamModel> cbzSegmentacionParamsForIdCpPropSegmenCat) {
		this.cbzSegmentacionParamsForIdCpPropSegmenCat = cbzSegmentacionParamsForIdCpPropSegmenCat;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cbzPropiedades")
	public Set<CbzCategoriaParamModel> getCbzCategoriaParams() {
		return this.cbzCategoriaParams;
	}

	public void setCbzCategoriaParams(Set<CbzCategoriaParamModel> cbzCategoriaParams) {
		this.cbzCategoriaParams = cbzCategoriaParams;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cbzPropiedades")
	public Set<CbzPeriodoConfModel> getCbzPeriodoConfs() {
		return this.cbzPeriodoConfs;
	}

	public void setCbzPeriodoConfs(Set<CbzPeriodoConfModel> cbzPeriodoConfs) {
		this.cbzPeriodoConfs = cbzPeriodoConfs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cbzPropiedadesByIdCpPropCartera")
	public Set<CbzSegmentacionParamModel> getCbzSegmentacionParamsForIdCpPropCartera() {
		return this.cbzSegmentacionParamsForIdCpPropCartera;
	}

	public void setCbzSegmentacionParamsForIdCpPropCartera(
			Set<CbzSegmentacionParamModel> cbzSegmentacionParamsForIdCpPropCartera) {
		this.cbzSegmentacionParamsForIdCpPropCartera = cbzSegmentacionParamsForIdCpPropCartera;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cbzPropiedades")
	public Set<CbzObenchParamModel> getCbzObenchParams() {
		return this.cbzObenchParams;
	}

	public void setCbzObenchParams(Set<CbzObenchParamModel> cbzObenchParams) {
		this.cbzObenchParams = cbzObenchParams;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cbzPropiedades")
	public Set<CbzCampanaParamModel> getCbzCampanaParams() {
		return this.cbzCampanaParams;
	}

	public void setCbzCampanaParams(Set<CbzCampanaParamModel> cbzCampanaParams) {
		this.cbzCampanaParams = cbzCampanaParams;
	}

}
