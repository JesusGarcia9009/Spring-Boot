package com.lib.common.entity;

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

/**
 * @author BS2
 */
@Entity
//@NamedNativeQuery(
//        name = "prm_get_lst_360_ubiper", 
//        callable = true, 
//        query = "{? = call prisma.pack_vista_360.prm_get_lst_360_ubiper(?,?)}",
//        resultClass = GenPersonasModel.class)
@Table(name = "GEN_PERSONAS", schema = "GENPAR")
public class GenPersonasModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GenPersonasIdModel id;
	private String persDigVer;
	private String persApePat;
	private String persApeMat;
	private String persNombres;
	private String persRazonSocial;
	private String persNomFantasia;
	private String persNivelEduc;
	private Date persFecNac;
	private Date persFecDefun;
	private String persEdadDefun;
	private String persEstCivil;
	private String persNaci;
	private String persSexo;
	private String persTipo;
	private String persGiro;
	private String persUserMod;
	private Date persFecMod;
	private Set<GenDireccionesModel> genDireccioneses = new HashSet<GenDireccionesModel>(0);
//	private GenEmpleadosModel genEmpleados;
	private Set<CobContMantencionModel> cobContMantencions = new HashSet<CobContMantencionModel>(0);
	private Set<CobPagareModel> cobPagares = new HashSet<CobPagareModel>(0);
	private Set<GenMailModel> genMails = new HashSet<GenMailModel>(0);
	private Set<GenTelefonosModel> genTelefonoses = new HashSet<GenTelefonosModel>(0);
	private Set<VtaOperModel> vtaOpersForVtaOperPers1Fk = new HashSet<VtaOperModel>(0);
	private Set<VtaContratosModel> vtaContratoses = new HashSet<VtaContratosModel>(0);
	private Set<VtaOperModel> vtaOpersForVtaOperPersLegalFk = new HashSet<VtaOperModel>(0);

	public GenPersonasModel() {
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "persTipoId", column = @Column(name = "PERS_TIPO_ID", nullable = false, length = 4)),
			@AttributeOverride(name = "persId", column = @Column(name = "PERS_ID", nullable = false, length = 10)) })
	public GenPersonasIdModel getId() {
		return this.id;
	}

	public void setId(GenPersonasIdModel id) {
		this.id = id;
	}

	@Column(name = "PERS_DIG_VER", length = 1)
	public String getPersDigVer() {
		return this.persDigVer;
	}

	public void setPersDigVer(String persDigVer) {
		this.persDigVer = persDigVer;
	}

	@Column(name = "PERS_APE_PAT", length = 30)
	public String getPersApePat() {
		return this.persApePat;
	}

	public void setPersApePat(String persApePat) {
		this.persApePat = persApePat;
	}

	@Column(name = "PERS_APE_MAT", length = 30)
	public String getPersApeMat() {
		return this.persApeMat;
	}

	public void setPersApeMat(String persApeMat) {
		this.persApeMat = persApeMat;
	}

	@Column(name = "PERS_NOMBRES", length = 40)
	public String getPersNombres() {
		return this.persNombres;
	}

	public void setPersNombres(String persNombres) {
		this.persNombres = persNombres;
	}

	@Column(name = "PERS_RAZON_SOCIAL", length = 80)
	public String getPersRazonSocial() {
		return this.persRazonSocial;
	}

	public void setPersRazonSocial(String persRazonSocial) {
		this.persRazonSocial = persRazonSocial;
	}

	@Column(name = "PERS_NOM_FANTASIA", length = 80)
	public String getPersNomFantasia() {
		return this.persNomFantasia;
	}

	public void setPersNomFantasia(String persNomFantasia) {
		this.persNomFantasia = persNomFantasia;
	}

	@Column(name = "PERS_NIVEL_EDUC", length = 10)
	public String getPersNivelEduc() {
		return this.persNivelEduc;
	}

	public void setPersNivelEduc(String persNivelEduc) {
		this.persNivelEduc = persNivelEduc;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "PERS_FEC_NAC", length = 7)
	public Date getPersFecNac() {
		return this.persFecNac;
	}

	public void setPersFecNac(Date persFecNac) {
		this.persFecNac = persFecNac;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "PERS_FEC_DEFUN", length = 7)
	public Date getPersFecDefun() {
		return this.persFecDefun;
	}

	public void setPersFecDefun(Date persFecDefun) {
		this.persFecDefun = persFecDefun;
	}

	@Column(name = "PERS_EDAD_DEFUN", length = 10)
	public String getPersEdadDefun() {
		return this.persEdadDefun;
	}

	public void setPersEdadDefun(String persEdadDefun) {
		this.persEdadDefun = persEdadDefun;
	}

	@Column(name = "PERS_EST_CIVIL", length = 10)
	public String getPersEstCivil() {
		return this.persEstCivil;
	}

	public void setPersEstCivil(String persEstCivil) {
		this.persEstCivil = persEstCivil;
	}

	@Column(name = "PERS_NACI", length = 20)
	public String getPersNaci() {
		return this.persNaci;
	}

	public void setPersNaci(String persNaci) {
		this.persNaci = persNaci;
	}

	@Column(name = "PERS_SEXO", length = 1)
	public String getPersSexo() {
		return this.persSexo;
	}

	public void setPersSexo(String persSexo) {
		this.persSexo = persSexo;
	}

	@Column(name = "PERS_TIPO", nullable = false, length = 3)
	public String getPersTipo() {
		return this.persTipo;
	}

	public void setPersTipo(String persTipo) {
		this.persTipo = persTipo;
	}

	@Column(name = "PERS_GIRO", length = 100)
	public String getPersGiro() {
		return this.persGiro;
	}

	public void setPersGiro(String persGiro) {
		this.persGiro = persGiro;
	}

	@Column(name = "PERS_USER_MOD", length = 30)
	public String getPersUserMod() {
		return this.persUserMod;
	}

	public void setPersUserMod(String persUserMod) {
		this.persUserMod = persUserMod;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "PERS_FEC_MOD", length = 7)
	public Date getPersFecMod() {
		return this.persFecMod;
	}

	public void setPersFecMod(Date persFecMod) {
		this.persFecMod = persFecMod;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "genPersonas")
	public Set<GenDireccionesModel> getGenDireccioneses() {
		return this.genDireccioneses;
	}

	public void setGenDireccioneses(Set<GenDireccionesModel> genDireccioneses) {
		this.genDireccioneses = genDireccioneses;
	}
//
//	@OneToOne(fetch = FetchType.LAZY, mappedBy = "genPersonas")
//	public GenEmpleadosModel getGenEmpleados() {
//		return this.genEmpleados;
//	}
//
//	public void setGenEmpleados(GenEmpleadosModel genEmpleados) {
//		this.genEmpleados = genEmpleados;
//	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "genPersonas")
	public Set<CobContMantencionModel> getCobContMantencions() {
		return this.cobContMantencions;
	}

	public void setCobContMantencions(Set<CobContMantencionModel> cobContMantencions) {
		this.cobContMantencions = cobContMantencions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "genPersonas")
	public Set<CobPagareModel> getCobPagares() {
		return this.cobPagares;
	}

	public void setCobPagares(Set<CobPagareModel> cobPagares) {
		this.cobPagares = cobPagares;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "genPersonas")
	public Set<GenMailModel> getGenMails() {
		return this.genMails;
	}

	public void setGenMails(Set<GenMailModel> genMails) {
		this.genMails = genMails;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "genPersonas")
	public Set<GenTelefonosModel> getGenTelefonoses() {
		return this.genTelefonoses;
	}

	public void setGenTelefonoses(Set<GenTelefonosModel> genTelefonoses) {
		this.genTelefonoses = genTelefonoses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "genPersonasByVtaOperPers1Fk")
	public Set<VtaOperModel> getVtaOpersForVtaOperPers1Fk() {
		return this.vtaOpersForVtaOperPers1Fk;
	}

	public void setVtaOpersForVtaOperPers1Fk(Set<VtaOperModel> vtaOpersForVtaOperPers1Fk) {
		this.vtaOpersForVtaOperPers1Fk = vtaOpersForVtaOperPers1Fk;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "genPersonas")
	public Set<VtaContratosModel> getVtaContratoses() {
		return this.vtaContratoses;
	}

	public void setVtaContratoses(Set<VtaContratosModel> vtaContratoses) {
		this.vtaContratoses = vtaContratoses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "genPersonasByVtaOperPersLegalFk")
	public Set<VtaOperModel> getVtaOpersForVtaOperPersLegalFk() {
		return this.vtaOpersForVtaOperPersLegalFk;
	}

	public void setVtaOpersForVtaOperPersLegalFk(Set<VtaOperModel> vtaOpersForVtaOperPersLegalFk) {
		this.vtaOpersForVtaOperPersLegalFk = vtaOpersForVtaOperPersLegalFk;
	}

}
