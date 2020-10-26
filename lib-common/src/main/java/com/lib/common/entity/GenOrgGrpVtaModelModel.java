package com.lib.common.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author BS2
 */
@Entity
@Table(name = "GEN_ORG_GRP_VTA", schema = "GENPAR")
public class GenOrgGrpVtaModelModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal grvtSec;
	private GenEmpleadosModel genEmpleados;
	private String grvtCod;
	private BigDecimal jvtaSec;
	private String grvtDesc;
	private Date grvtFecMod;
	private String grvtUserMod;
	private String grvtEstaCod;
	private Set<VtaOperModel> vtaOpers = new HashSet<VtaOperModel>(0);

	public GenOrgGrpVtaModelModel() {
	}

	public GenOrgGrpVtaModelModel(BigDecimal grvtSec, String grvtCod, BigDecimal jvtaSec, String grvtDesc, Date grvtFecMod,
			String grvtUserMod, String grvtEstaCod) {
		this.grvtSec = grvtSec;
		this.grvtCod = grvtCod;
		this.jvtaSec = jvtaSec;
		this.grvtDesc = grvtDesc;
		this.grvtFecMod = grvtFecMod;
		this.grvtUserMod = grvtUserMod;
		this.grvtEstaCod = grvtEstaCod;
	}

	public GenOrgGrpVtaModelModel(BigDecimal grvtSec, GenEmpleadosModel genEmpleados, String grvtCod, BigDecimal jvtaSec,
			String grvtDesc, Date grvtFecMod, String grvtUserMod, String grvtEstaCod, Set<VtaOperModel> vtaOpers) {
		this.grvtSec = grvtSec;
		this.genEmpleados = genEmpleados;
		this.grvtCod = grvtCod;
		this.jvtaSec = jvtaSec;
		this.grvtDesc = grvtDesc;
		this.grvtFecMod = grvtFecMod;
		this.grvtUserMod = grvtUserMod;
		this.grvtEstaCod = grvtEstaCod;
		this.vtaOpers = vtaOpers;
	}

	@Id

	@Column(name = "GRVT_SEC", unique = true, nullable = false, precision = 23, scale = 0)
	public BigDecimal getGrvtSec() {
		return this.grvtSec;
	}

	public void setGrvtSec(BigDecimal grvtSec) {
		this.grvtSec = grvtSec;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "GRVT_PERS_TIPO_ID", referencedColumnName = "PERS_TIPO_ID"),
			@JoinColumn(name = "GRVT_PERS_ID", referencedColumnName = "PERS_ID") })
	public GenEmpleadosModel getGenEmpleados() {
		return this.genEmpleados;
	}

	public void setGenEmpleados(GenEmpleadosModel genEmpleados) {
		this.genEmpleados = genEmpleados;
	}

	@Column(name = "GRVT_COD", nullable = false, length = 20)
	public String getGrvtCod() {
		return this.grvtCod;
	}

	public void setGrvtCod(String grvtCod) {
		this.grvtCod = grvtCod;
	}

	@Column(name = "JVTA_SEC", nullable = false, precision = 23, scale = 0)
	public BigDecimal getJvtaSec() {
		return this.jvtaSec;
	}

	public void setJvtaSec(BigDecimal jvtaSec) {
		this.jvtaSec = jvtaSec;
	}

	@Column(name = "GRVT_DESC", nullable = false, length = 200)
	public String getGrvtDesc() {
		return this.grvtDesc;
	}

	public void setGrvtDesc(String grvtDesc) {
		this.grvtDesc = grvtDesc;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "GRVT_FEC_MOD", nullable = false, length = 7)
	public Date getGrvtFecMod() {
		return this.grvtFecMod;
	}

	public void setGrvtFecMod(Date grvtFecMod) {
		this.grvtFecMod = grvtFecMod;
	}

	@Column(name = "GRVT_USER_MOD", nullable = false, length = 30)
	public String getGrvtUserMod() {
		return this.grvtUserMod;
	}

	public void setGrvtUserMod(String grvtUserMod) {
		this.grvtUserMod = grvtUserMod;
	}

	@Column(name = "GRVT_ESTA_COD", nullable = false, length = 20)
	public String getGrvtEstaCod() {
		return this.grvtEstaCod;
	}

	public void setGrvtEstaCod(String grvtEstaCod) {
		this.grvtEstaCod = grvtEstaCod;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "genOrgGrpVta")
	public Set<VtaOperModel> getVtaOpers() {
		return this.vtaOpers;
	}

	public void setVtaOpers(Set<VtaOperModel> vtaOpers) {
		this.vtaOpers = vtaOpers;
	}

}
