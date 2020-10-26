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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * @author BS2
 */
@Entity
@Table(name = "GEN_EMPLEADOS", schema = "GENPAR")
public class GenEmpleadosModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GenEmpleadosIdModel id;
	private int version;
	
//	@Transient
//	private GenPersonasModel genPersonas;
	private Date emplFechIng;
	private String emplUserMod;
	private Date emplFecMod;
	private String emplEstaCod;
	private Date emplFechEgre;
	private Date emplFechCont;
	private String emplEstaCont;
	private Set<GenOrgGrpVtaModelModel> genOrgGrpVtas = new HashSet<GenOrgGrpVtaModelModel>(0);
	private Set<VtaOperModel> vtaOpers = new HashSet<VtaOperModel>(0);

	public GenEmpleadosModel() {
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "persTipoId", column = @Column(name = "PERS_TIPO_ID", nullable = false, length = 4)),
			@AttributeOverride(name = "persId", column = @Column(name = "PERS_ID", nullable = false, length = 10)) })
	public GenEmpleadosIdModel getId() {
		return this.id;
	}

	public void setId(GenEmpleadosIdModel id) {
		this.id = id;
	}

	@Version
	@Column(name = "VERSION", nullable = false, precision = 5, scale = 0)
	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

//	@OneToOne(fetch = FetchType.LAZY)
//	@PrimaryKeyJoinColumn
//	public GenPersonasModel getGenPersonas() {
//		return this.genPersonas;
//	}
//
//	public void setGenPersonas(GenPersonasModel genPersonas) {
//		this.genPersonas = genPersonas;
//	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EMPL_FECH_ING", length = 7)
	public Date getEmplFechIng() {
		return this.emplFechIng;
	}

	public void setEmplFechIng(Date emplFechIng) {
		this.emplFechIng = emplFechIng;
	}

	@Column(name = "EMPL_USER_MOD", nullable = false, length = 30)
	public String getEmplUserMod() {
		return this.emplUserMod;
	}

	public void setEmplUserMod(String emplUserMod) {
		this.emplUserMod = emplUserMod;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EMPL_FEC_MOD", nullable = false, length = 7)
	public Date getEmplFecMod() {
		return this.emplFecMod;
	}

	public void setEmplFecMod(Date emplFecMod) {
		this.emplFecMod = emplFecMod;
	}

	@Column(name = "EMPL_ESTA_COD", nullable = false, length = 10)
	public String getEmplEstaCod() {
		return this.emplEstaCod;
	}

	public void setEmplEstaCod(String emplEstaCod) {
		this.emplEstaCod = emplEstaCod;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EMPL_FECH_EGRE", length = 7)
	public Date getEmplFechEgre() {
		return this.emplFechEgre;
	}

	public void setEmplFechEgre(Date emplFechEgre) {
		this.emplFechEgre = emplFechEgre;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EMPL_FECH_CONT", length = 7)
	public Date getEmplFechCont() {
		return this.emplFechCont;
	}

	public void setEmplFechCont(Date emplFechCont) {
		this.emplFechCont = emplFechCont;
	}

	@Column(name = "EMPL_ESTA_CONT", length = 50)
	public String getEmplEstaCont() {
		return this.emplEstaCont;
	}

	public void setEmplEstaCont(String emplEstaCont) {
		this.emplEstaCont = emplEstaCont;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "genEmpleados")
	public Set<GenOrgGrpVtaModelModel> getGenOrgGrpVtas() {
		return this.genOrgGrpVtas;
	}

	public void setGenOrgGrpVtas(Set<GenOrgGrpVtaModelModel> genOrgGrpVtas) {
		this.genOrgGrpVtas = genOrgGrpVtas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "genEmpleados")
	public Set<VtaOperModel> getVtaOpers() {
		return this.vtaOpers;
	}

	public void setVtaOpers(Set<VtaOperModel> vtaOpers) {
		this.vtaOpers = vtaOpers;
	}

}
