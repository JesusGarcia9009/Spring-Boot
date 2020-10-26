package com.pdr.common.cobranza.entity;
// Generated 14-05-2020 13:40:56 by Hibernate Tools 5.2.12.Final

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * @author BS2
 */
@Entity
@Table(name = "VTA_PERIODO", schema = "VTAPAR", uniqueConstraints = @UniqueConstraint(columnNames = { "EMPR_COD",
		"UNEG_COD", "PRDO_TIPO", "PRDO_COD" }))
public class VtaPeriodoModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal prdoSec;
	private GenUnidNegociosModel genUnidNegocios;
	private GenEmpresasModel genEmpresas;
	private String prdoTipo;
	private int prdoCod;
	private Date prdoFecIni;
	private Date prdoFecFin;
	private String prdoEstaCod;
	private String prdoUserMod;
	private Date prdoFecMod;
	private Set<VtaOperModel> vtaOpers = new HashSet<VtaOperModel>(0);

	public VtaPeriodoModel() {
	}

	public VtaPeriodoModel(BigDecimal prdoSec, GenUnidNegociosModel genUnidNegocios, GenEmpresasModel genEmpresas, String prdoTipo,
			int prdoCod, String prdoEstaCod, String prdoUserMod, Date prdoFecMod) {
		this.prdoSec = prdoSec;
		this.genUnidNegocios = genUnidNegocios;
		this.genEmpresas = genEmpresas;
		this.prdoTipo = prdoTipo;
		this.prdoCod = prdoCod;
		this.prdoEstaCod = prdoEstaCod;
		this.prdoUserMod = prdoUserMod;
		this.prdoFecMod = prdoFecMod;
	}

	public VtaPeriodoModel(BigDecimal prdoSec, GenUnidNegociosModel genUnidNegocios, GenEmpresasModel genEmpresas, String prdoTipo,
			int prdoCod, Date prdoFecIni, Date prdoFecFin, String prdoEstaCod, String prdoUserMod, Date prdoFecMod,
			Set<VtaOperModel> vtaOpers) {
		this.prdoSec = prdoSec;
		this.genUnidNegocios = genUnidNegocios;
		this.genEmpresas = genEmpresas;
		this.prdoTipo = prdoTipo;
		this.prdoCod = prdoCod;
		this.prdoFecIni = prdoFecIni;
		this.prdoFecFin = prdoFecFin;
		this.prdoEstaCod = prdoEstaCod;
		this.prdoUserMod = prdoUserMod;
		this.prdoFecMod = prdoFecMod;
		this.vtaOpers = vtaOpers;
	}

	@Id

	@Column(name = "PRDO_SEC", unique = true, nullable = false, precision = 23, scale = 0)
	public BigDecimal getPrdoSec() {
		return this.prdoSec;
	}

	public void setPrdoSec(BigDecimal prdoSec) {
		this.prdoSec = prdoSec;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UNEG_COD", nullable = false)
	public GenUnidNegociosModel getGenUnidNegocios() {
		return this.genUnidNegocios;
	}

	public void setGenUnidNegocios(GenUnidNegociosModel genUnidNegocios) {
		this.genUnidNegocios = genUnidNegocios;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMPR_COD", nullable = false)
	public GenEmpresasModel getGenEmpresas() {
		return this.genEmpresas;
	}

	public void setGenEmpresas(GenEmpresasModel genEmpresas) {
		this.genEmpresas = genEmpresas;
	}

	@Column(name = "PRDO_TIPO", nullable = false, length = 10)
	public String getPrdoTipo() {
		return this.prdoTipo;
	}

	public void setPrdoTipo(String prdoTipo) {
		this.prdoTipo = prdoTipo;
	}

	@Column(name = "PRDO_COD", nullable = false, precision = 6, scale = 0)
	public int getPrdoCod() {
		return this.prdoCod;
	}

	public void setPrdoCod(int prdoCod) {
		this.prdoCod = prdoCod;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "PRDO_FEC_INI", length = 7)
	public Date getPrdoFecIni() {
		return this.prdoFecIni;
	}

	public void setPrdoFecIni(Date prdoFecIni) {
		this.prdoFecIni = prdoFecIni;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "PRDO_FEC_FIN", length = 7)
	public Date getPrdoFecFin() {
		return this.prdoFecFin;
	}

	public void setPrdoFecFin(Date prdoFecFin) {
		this.prdoFecFin = prdoFecFin;
	}

	@Column(name = "PRDO_ESTA_COD", nullable = false, length = 20)
	public String getPrdoEstaCod() {
		return this.prdoEstaCod;
	}

	public void setPrdoEstaCod(String prdoEstaCod) {
		this.prdoEstaCod = prdoEstaCod;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vtaPeriodo")
	public Set<VtaOperModel> getVtaOpers() {
		return this.vtaOpers;
	}

	public void setVtaOpers(Set<VtaOperModel> vtaOpers) {
		this.vtaOpers = vtaOpers;
	}

}
