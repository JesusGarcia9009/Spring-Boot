package com.pdr.common.cobranza.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author BS2
 */
@Entity
@Table(name = "COB_PERIODO_FASE", schema = "COBPAR")
public class CobPeriodoFaseModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8082068411981589484L;
	private CobPeriodoFaseIdModel id;
	private GenEmpresasModel genEmpresas;
	private Date prdoFechIni;
	private Date prdoFechFin;
	private String prdoUserMod;
	private Date prdoFecMod;
	private Set<CbzPeriodoConfModel> cbzPeriodoConfs = new HashSet<>(0);


	public CobPeriodoFaseModel() {
	}

	public CobPeriodoFaseModel(CobPeriodoFaseIdModel id, GenEmpresasModel genEmpresas, Date prdoFechIni, Date prdoFechFin,
			String prdoUserMod, Date prdoFecMod) {
		this.id = id;
		this.genEmpresas = genEmpresas;
		this.prdoFechIni = prdoFechIni;
		this.prdoFechFin = prdoFechFin;
		this.prdoUserMod = prdoUserMod;
		this.prdoFecMod = prdoFecMod;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "emprCod", column = @Column(name = "EMPR_COD", nullable = false, length = 10)),
			@AttributeOverride(name = "prdoTipo", column = @Column(name = "PRDO_TIPO", nullable = false, length = 10)),
			@AttributeOverride(name = "prdoCod", column = @Column(name = "PRDO_COD", nullable = false, precision = 6, scale = 0)) })
	public CobPeriodoFaseIdModel getId() {
		return this.id;
	}

	public void setId(CobPeriodoFaseIdModel id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMPR_COD", nullable = false, insertable = false, updatable = false)
	public GenEmpresasModel getGenEmpresas() {
		return this.genEmpresas;
	}

	public void setGenEmpresas(GenEmpresasModel genEmpresas) {
		this.genEmpresas = genEmpresas;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "PRDO_FECH_INI", nullable = false, length = 7)
	public Date getPrdoFechIni() {
		return this.prdoFechIni;
	}

	public void setPrdoFechIni(Date prdoFechIni) {
		this.prdoFechIni = prdoFechIni;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "PRDO_FECH_FIN", nullable = false, length = 7)
	public Date getPrdoFechFin() {
		return this.prdoFechFin;
	}

	public void setPrdoFechFin(Date prdoFechFin) {
		this.prdoFechFin = prdoFechFin;
	}

	@Column(name = "PRDO_USER_MOD", nullable = false, length = 30)
	public String getPrdoUserMod() {
		return this.prdoUserMod;
	}

	public void setPrdoUserMod(String prdoUserMod) {
		this.prdoUserMod = prdoUserMod;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "PRDO_FEC_MOD", nullable = false, length = 7)
	public Date getPrdoFecMod() {
		return this.prdoFecMod;
	}

	public void setPrdoFecMod(Date prdoFecMod) {
		this.prdoFecMod = prdoFecMod;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cobPeriodoFase")
	public Set<CbzPeriodoConfModel> getCbzPeriodoConfs() {
		return cbzPeriodoConfs;
	}

	public void setCbzPeriodoConfs(Set<CbzPeriodoConfModel> cbzPeriodoConfs) {
		this.cbzPeriodoConfs = cbzPeriodoConfs;
	}

}
