package com.pdr.common.cobranza.entity;

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author BS2
 */
@Entity
@Table(name = "COB_FASES", schema = "COBPAR")
public class CobFasesModel implements java.io.Serializable {

	private static final long serialVersionUID = 7586500025348608150L;
	private CobFasesModelId id;
	private String faseTipo;
	private String faseDesc;
	private Date faseFecModif;
	private String faseEstaCod;
	private String prodCod;
	private long faseDiasIni;
	private long faseDiasFin;

	public CobFasesModel() {
	}

	public CobFasesModel(CobFasesModelId id, String faseTipo, String faseDesc, Date faseFecModif, String faseEstaCod,
			String prodCod, long faseDiasIni, long faseDiasFin) {
		this.id = id;
		this.faseTipo = faseTipo;
		this.faseDesc = faseDesc;
		this.faseFecModif = faseFecModif;
		this.faseEstaCod = faseEstaCod;
		this.prodCod = prodCod;
		this.faseDiasIni = faseDiasIni;
		this.faseDiasFin = faseDiasFin;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "faseCod", column = @Column(name = "FASE_COD", nullable = false, length = 20)),
			@AttributeOverride(name = "emprCod", column = @Column(name = "EMPR_COD", nullable = false, length = 10)) })
	public CobFasesModelId getId() {
		return this.id;
	}

	public void setId(CobFasesModelId id) {
		this.id = id;
	}

	@Column(name = "FASE_TIPO", nullable = false, length = 20)
	public String getFaseTipo() {
		return this.faseTipo;
	}

	public void setFaseTipo(String faseTipo) {
		this.faseTipo = faseTipo;
	}

	@Column(name = "FASE_DESC", nullable = false, length = 200)
	public String getFaseDesc() {
		return this.faseDesc;
	}

	public void setFaseDesc(String faseDesc) {
		this.faseDesc = faseDesc;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FASE_FEC_MODIF", nullable = false, length = 7)
	public Date getFaseFecModif() {
		return this.faseFecModif;
	}

	public void setFaseFecModif(Date faseFecModif) {
		this.faseFecModif = faseFecModif;
	}

	@Column(name = "FASE_ESTA_COD", nullable = false, length = 10)
	public String getFaseEstaCod() {
		return this.faseEstaCod;
	}

	public void setFaseEstaCod(String faseEstaCod) {
		this.faseEstaCod = faseEstaCod;
	}

	@Column(name = "PROD_COD", nullable = false, length = 10)
	public String getProdCod() {
		return this.prodCod;
	}

	public void setProdCod(String prodCod) {
		this.prodCod = prodCod;
	}

	@Column(name = "FASE_DIAS_INI", nullable = false, precision = 10, scale = 0)
	public long getFaseDiasIni() {
		return this.faseDiasIni;
	}

	public void setFaseDiasIni(long faseDiasIni) {
		this.faseDiasIni = faseDiasIni;
	}

	@Column(name = "FASE_DIAS_FIN", nullable = false, precision = 10, scale = 0)
	public long getFaseDiasFin() {
		return this.faseDiasFin;
	}

	public void setFaseDiasFin(long faseDiasFin) {
		this.faseDiasFin = faseDiasFin;
	}

}
