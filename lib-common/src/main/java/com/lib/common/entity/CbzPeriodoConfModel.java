package com.lib.common.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author BS2
 */
@Entity
@Table(name = "CBZ_PERIODO_CONF", schema = "CBZPAR")
public class CbzPeriodoConfModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 746889252850284443L;
	private int idCpcPeriodo;
	private CobPeriodoFaseModel cobPeriodoFase;
	private CbzPropiedadesModel cbzPropiedades;
	private String prdoSegmento;
	private Set<CbzSegmentacionParamModel> cbzSegmentacionParams = new HashSet<>(0);
	private Set<CbzObenchParamModel> cbzObenchParams = new HashSet<>(0);
	private Set<CbzCampanaParamModel> cbzCampanaParams = new HashSet<>(0);
	private Set<CbzCategoriaParamModel> cbzCategoriaParams = new HashSet<>(0);
	private Set<CbzAbminimParamModel> cbzAbminimParams = new HashSet<>(0);


	public CbzPeriodoConfModel() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE_PERIODO_CONF")
	@SequenceGenerator(name = "ID_SEQUENCE_PERIODO_CONF", allocationSize = 1, sequenceName = "SEQ_PERIODO_CONF", schema = "CBZPAR")
	@Column(name = "ID_CPC_PERIODO", unique = true, nullable = false, precision = 8, scale = 0)
	public int getIdCpcPeriodo() {
		return this.idCpcPeriodo;
	}

	public void setIdCpcPeriodo(int idCpcPeriodo) {
		this.idCpcPeriodo = idCpcPeriodo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "EMPR_COD", referencedColumnName = "EMPR_COD", nullable = false),
			@JoinColumn(name = "PRDO_TIPO", referencedColumnName = "PRDO_TIPO", nullable = false),
			@JoinColumn(name = "PRDO_COD", referencedColumnName = "PRDO_COD", nullable = false) })
	public CobPeriodoFaseModel getCobPeriodoFase() {
		return this.cobPeriodoFase;
	}

	public void setCobPeriodoFase(CobPeriodoFaseModel cobPeriodoFase) {
		this.cobPeriodoFase = cobPeriodoFase;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CP_PROP_CONFIG")
	public CbzPropiedadesModel getCbzPropiedades() {
		return this.cbzPropiedades;
	}

	public void setCbzPropiedades(CbzPropiedadesModel cbzPropiedades) {
		this.cbzPropiedades = cbzPropiedades;
	}
	
	@Column(name = "PRDO_SEGMENTO", nullable = false, length = 20)
	public String getPrdoSegmento() {
		return this.prdoSegmento;
	}

	public void setPrdoSegmento(String prdoSegmento) {
		this.prdoSegmento = prdoSegmento;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cbzPeriodoConf")
	public Set<CbzSegmentacionParamModel> getCbzSegmentacionParams() {
		return this.cbzSegmentacionParams;
	}

	public void setCbzSegmentacionParams(Set<CbzSegmentacionParamModel> cbzSegmentacionParams) {
		this.cbzSegmentacionParams = cbzSegmentacionParams;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cbzPeriodoConf")
	public Set<CbzObenchParamModel> getCbzObenchParams() {
		return this.cbzObenchParams;
	}

	public void setCbzObenchParams(Set<CbzObenchParamModel> cbzObenchParams) {
		this.cbzObenchParams = cbzObenchParams;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cbzPeriodoConf")
	public Set<CbzCampanaParamModel> getCbzCampanaParams() {
		return this.cbzCampanaParams;
	}

	public void setCbzCampanaParams(Set<CbzCampanaParamModel> cbzCampanaParams) {
		this.cbzCampanaParams = cbzCampanaParams;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cbzPeriodoConf")
	public Set<CbzCategoriaParamModel> getCbzCategoriaParams() {
		return this.cbzCategoriaParams;
	}

	public void setCbzCategoriaParams(Set<CbzCategoriaParamModel> cbzCategoriaParams) {
		this.cbzCategoriaParams = cbzCategoriaParams;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cbzPeriodoConf")
	public Set<CbzAbminimParamModel> getCbzAbminimParams() {
		return this.cbzAbminimParams;
	}

	public void setCbzAbminimParams(Set<CbzAbminimParamModel> cbzAbminimParams) {
		this.cbzAbminimParams = cbzAbminimParams;
	}

}
