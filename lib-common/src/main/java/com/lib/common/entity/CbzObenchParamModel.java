package com.lib.common.entity;

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
@Table(name = "CBZ_OBENCH_PARAM", schema = "CBZPAR")
public class CbzObenchParamModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private long idCopObenchParam;;
	private CbzPeriodoConfModel cbzPeriodoConf;
	private CbzPropiedadesModel cbzPropiedades;
	private CbzObenchCamposModel cbzObenchCampos;
	private Integer copOrdenPos;
	private Integer copObenchActivo;

	public CbzObenchParamModel() {
	}

	public CbzObenchParamModel(long idCopObenchParam, CbzPeriodoConfModel cbzPeriodoConf) {
		this.idCopObenchParam = idCopObenchParam;
		this.cbzPeriodoConf = cbzPeriodoConf;
	}

	public CbzObenchParamModel(long idCopObenchParam, CbzPeriodoConfModel cbzPeriodoConf, CbzPropiedadesModel cbzPropiedades,
			CbzObenchCamposModel cbzObenchCampos, Integer copOrdenPos, Integer copObenchActivo) {
		this.idCopObenchParam = idCopObenchParam;
		this.cbzPeriodoConf = cbzPeriodoConf;
		this.cbzPropiedades = cbzPropiedades;
		this.cbzObenchCampos = cbzObenchCampos;
		this.copOrdenPos = copOrdenPos;
		this.copObenchActivo = copObenchActivo;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE_OBENCH_PARAM")
	@SequenceGenerator(name = "ID_SEQUENCE_OBENCH_PARAM", allocationSize = 1, sequenceName = "SEQ_OBENCH_PARAM", schema = "CBZPAR")
	@Column(name = "ID_COP_OBENCH_PARAM", unique = true, nullable = false, precision = 16, scale = 0)
	public long getIdCopObenchParam() {
		return this.idCopObenchParam;
	}

	public void setIdCopObenchParam(long idCopObenchParam) {
		this.idCopObenchParam = idCopObenchParam;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_COP_PERIODO", nullable = false)
	public CbzPeriodoConfModel getCbzPeriodoConf() {
		return this.cbzPeriodoConf;
	}

	public void setCbzPeriodoConf(CbzPeriodoConfModel cbzPeriodoConf) {
		this.cbzPeriodoConf = cbzPeriodoConf;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CP_PROP_ORDER")
	public CbzPropiedadesModel getCbzPropiedades() {
		return this.cbzPropiedades;
	}

	public void setCbzPropiedades(CbzPropiedadesModel cbzPropiedades) {
		this.cbzPropiedades = cbzPropiedades;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_COC_CAMPOS")
	public CbzObenchCamposModel getCbzObenchCampos() {
		return this.cbzObenchCampos;
	}

	public void setCbzObenchCampos(CbzObenchCamposModel cbzObenchCampos) {
		this.cbzObenchCampos = cbzObenchCampos;
	}

	@Column(name = "COP_ORDEN_POS", precision = 2, scale = 0)
	public Integer getCopOrdenPos() {
		return this.copOrdenPos;
	}

	public void setCopOrdenPos(Integer copOrdenPos) {
		this.copOrdenPos = copOrdenPos;
	}

	@Column(name = "COP_OBENCH_ACTIVO", precision = 1, scale = 0)
	public Integer getCopObenchActivo() {
		return this.copObenchActivo;
	}

	public void setCopObenchActivo(Integer copObenchActivo) {
		this.copObenchActivo = copObenchActivo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CbzObenchParamModel [idCopObenchParam=");
		builder.append(idCopObenchParam);
		builder.append(", cbzPeriodoConf=");
		builder.append(cbzPeriodoConf);
		builder.append(", cbzPropiedades=");
		builder.append(cbzPropiedades);
		builder.append(", cbzObenchCampos=");
		builder.append(cbzObenchCampos);
		builder.append(", copOrdenPos=");
		builder.append(copOrdenPos);
		builder.append(", copObenchActivo=");
		builder.append(copObenchActivo);
		builder.append("]");
		return builder.toString();
	}
	
	

}
