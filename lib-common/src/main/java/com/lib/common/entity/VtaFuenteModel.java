package com.lib.common.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * @author BS2
 */
@Entity
@Table(name = "VTA_FUENTE", schema = "VTAPAR")
public class VtaFuenteModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fnteCod;
	private int version;
	private String fnteCate;
	private String fnteGrpo;
	private String fnteDesc;
	private String fnteEstaCod;
	private String fnteUserMod;
	private Date fnteFecMod;
	private Set<VtaOperModel> vtaOpers = new HashSet<VtaOperModel>(0);

	public VtaFuenteModel() {
	}

	public VtaFuenteModel(String fnteCod, String fnteCate, String fnteGrpo, String fnteDesc, String fnteEstaCod,
			String fnteUserMod, Date fnteFecMod) {
		this.fnteCod = fnteCod;
		this.fnteCate = fnteCate;
		this.fnteGrpo = fnteGrpo;
		this.fnteDesc = fnteDesc;
		this.fnteEstaCod = fnteEstaCod;
		this.fnteUserMod = fnteUserMod;
		this.fnteFecMod = fnteFecMod;
	}

	public VtaFuenteModel(String fnteCod, String fnteCate, String fnteGrpo, String fnteDesc, String fnteEstaCod,
			String fnteUserMod, Date fnteFecMod, Set<VtaOperModel> vtaOpers) {
		this.fnteCod = fnteCod;
		this.fnteCate = fnteCate;
		this.fnteGrpo = fnteGrpo;
		this.fnteDesc = fnteDesc;
		this.fnteEstaCod = fnteEstaCod;
		this.fnteUserMod = fnteUserMod;
		this.fnteFecMod = fnteFecMod;
		this.vtaOpers = vtaOpers;
	}

	@Id

	@Column(name = "FNTE_COD", unique = true, nullable = false, length = 10)
	public String getFnteCod() {
		return this.fnteCod;
	}

	public void setFnteCod(String fnteCod) {
		this.fnteCod = fnteCod;
	}

	@Version
	@Column(name = "VERSION", nullable = false, precision = 5, scale = 0)
	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Column(name = "FNTE_CATE", nullable = false, length = 20)
	public String getFnteCate() {
		return this.fnteCate;
	}

	public void setFnteCate(String fnteCate) {
		this.fnteCate = fnteCate;
	}

	@Column(name = "FNTE_GRPO", nullable = false, length = 20)
	public String getFnteGrpo() {
		return this.fnteGrpo;
	}

	public void setFnteGrpo(String fnteGrpo) {
		this.fnteGrpo = fnteGrpo;
	}

	@Column(name = "FNTE_DESC", nullable = false, length = 40)
	public String getFnteDesc() {
		return this.fnteDesc;
	}

	public void setFnteDesc(String fnteDesc) {
		this.fnteDesc = fnteDesc;
	}

	@Column(name = "FNTE_ESTA_COD", nullable = false, length = 20)
	public String getFnteEstaCod() {
		return this.fnteEstaCod;
	}

	public void setFnteEstaCod(String fnteEstaCod) {
		this.fnteEstaCod = fnteEstaCod;
	}

	@Column(name = "FNTE_USER_MOD", nullable = false, length = 30)
	public String getFnteUserMod() {
		return this.fnteUserMod;
	}

	public void setFnteUserMod(String fnteUserMod) {
		this.fnteUserMod = fnteUserMod;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FNTE_FEC_MOD", nullable = false, length = 7)
	public Date getFnteFecMod() {
		return this.fnteFecMod;
	}

	public void setFnteFecMod(Date fnteFecMod) {
		this.fnteFecMod = fnteFecMod;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vtaFuente")
	public Set<VtaOperModel> getVtaOpers() {
		return this.vtaOpers;
	}

	public void setVtaOpers(Set<VtaOperModel> vtaOpers) {
		this.vtaOpers = vtaOpers;
	}

}
