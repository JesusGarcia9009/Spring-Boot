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
@Table(name = "CBZ_ABMINIM_PARAM", schema = "CBZPAR")
public class CbzAbminimParamModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3133532702559926043L;
	private Long idCapAbminim;
	private CbzPeriodoConfModel cbzPeriodoConf;
	private CbzPropiedadesModel cbzPropiedades;
	private String capNombreFase;
	private BigDecimal capCrenegDesde;
	private BigDecimal capCrenegHasta;
	private BigDecimal capAbonoPacpat;
	private BigDecimal capAbonoCrut;
	private Integer capValorminimPacpat;
	private Boolean capActivo;
	private String capCodFase;

	public CbzAbminimParamModel() {
	}

	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE_ABMINIM_PARAM")
	@SequenceGenerator(name = "ID_SEQUENCE_ABMINIM_PARAM", allocationSize = 1, sequenceName = "SEQ_ABMINIM_PARAM", schema = "CBZPAR")
	@Column(name = "ID_CAP_ABMINIM", unique = true, nullable = false, precision = 8, scale = 0)
	public Long getIdCapAbminim() {
		return this.idCapAbminim;
	}

	public void setIdCapAbminim(Long idCapAbminim) {
		this.idCapAbminim = idCapAbminim;
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

	@Column(name = "CAP_NOMBRE_FASE", length = 50)
	public String getCapNombreFase() {
		return this.capNombreFase;
	}

	public void setCapNombreFase(String capNombreFase) {
		this.capNombreFase = capNombreFase;
	}

	@Column(name = "CAP_CRENEG_DESDE", precision = 3, scale = 0)
	public BigDecimal getCapCrenegDesde() {
		return this.capCrenegDesde;
	}

	public void setCapCrenegDesde(BigDecimal capCrenegDesde) {
		this.capCrenegDesde = capCrenegDesde;
	}

	@Column(name = "CAP_CRENEG_HASTA", precision = 3, scale = 0)
	public BigDecimal getCapCrenegHasta() {
		return this.capCrenegHasta;
	}

	public void setCapCrenegHasta(BigDecimal capCrenegHasta) {
		this.capCrenegHasta = capCrenegHasta;
	}

	@Column(name = "CAP_ABONO_PACPAT", precision = 3, scale = 0)
	public BigDecimal getCapAbonoPacpat() {
		return this.capAbonoPacpat;
	}

	public void setCapAbonoPacpat(BigDecimal capAbonoPacpat) {
		this.capAbonoPacpat = capAbonoPacpat;
	}

	@Column(name = "CAP_ABONO_CRUT", precision = 3, scale = 0)
	public BigDecimal getCapAbonoCrut() {
		return this.capAbonoCrut;
	}

	public void setCapAbonoCrut(BigDecimal capAbonoCrut) {
		this.capAbonoCrut = capAbonoCrut;
	}

	@Column(name = "CAP_VALORMINIM_PACPAT", precision = 8, scale = 0)
	public Integer getCapValorminimPacpat() {
		return this.capValorminimPacpat;
	}

	public void setCapValorminimPacpat(Integer capValorminimPacpat) {
		this.capValorminimPacpat = capValorminimPacpat;
	}

	@Column(name = "CAP_ACTIVO", precision = 22, scale = 0)
	public Boolean getCapActivo() {
		return this.capActivo;
	}

	public void setCapActivo(Boolean capActivo) {
		this.capActivo = capActivo;
	}
	
	@Column(name = "CAP_COD_FASE", nullable = false, length = 50)
	public String getCapCodFase() {
		return this.capCodFase;
	}

	public void setCapCodFase(String capCodFase) {
		this.capCodFase = capCodFase;
	}

}
