package com.pdr.common.cobranza.entity;

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

/**
 * @author BS2
 */
@Entity
@Table(name = "GEN_EMPRESAS", schema = "GENPAR")
public class GenEmpresasModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String emprCod;
	private String emprRut;
	private String emprDig;
	private String emprRazonSocial;
	private String emprNomFantasia;
	private String emprNomContacto;
	private String emprEstado;
	private String emprUserMod;
	private Date emprFecMod;
	private String emprGiro;
	private String persTipoIdResp;
	private String persIdResp;
	private String emprGerComDesc;
	private String emprTipo;
	private Set<VtaOperModel> vtaOpers = new HashSet<VtaOperModel>(0);
	private Set<VtaPeriodoModel> vtaPeriodos = new HashSet<VtaPeriodoModel>(0);

	public GenEmpresasModel() {
	}

	public GenEmpresasModel(String emprCod, String emprRut, String emprDig, String emprRazonSocial, String emprEstado,
			String emprTipo) {
		this.emprCod = emprCod;
		this.emprRut = emprRut;
		this.emprDig = emprDig;
		this.emprRazonSocial = emprRazonSocial;
		this.emprEstado = emprEstado;
		this.emprTipo = emprTipo;
	}

	public GenEmpresasModel(String emprCod, String emprRut, String emprDig, String emprRazonSocial, String emprNomFantasia,
			String emprNomContacto, String emprEstado, String emprUserMod, Date emprFecMod, String emprGiro,
			String persTipoIdResp, String persIdResp, String emprGerComDesc, String emprTipo, Set<VtaOperModel> vtaOpers,
			Set<VtaPeriodoModel> vtaPeriodos) {
		this.emprCod = emprCod;
		this.emprRut = emprRut;
		this.emprDig = emprDig;
		this.emprRazonSocial = emprRazonSocial;
		this.emprNomFantasia = emprNomFantasia;
		this.emprNomContacto = emprNomContacto;
		this.emprEstado = emprEstado;
		this.emprUserMod = emprUserMod;
		this.emprFecMod = emprFecMod;
		this.emprGiro = emprGiro;
		this.persTipoIdResp = persTipoIdResp;
		this.persIdResp = persIdResp;
		this.emprGerComDesc = emprGerComDesc;
		this.emprTipo = emprTipo;
		this.vtaOpers = vtaOpers;
		this.vtaPeriodos = vtaPeriodos;
	}

	@Id

	@Column(name = "EMPR_COD", unique = true, nullable = false, length = 10)
	public String getEmprCod() {
		return this.emprCod;
	}

	public void setEmprCod(String emprCod) {
		this.emprCod = emprCod;
	}

	@Column(name = "EMPR_RUT", nullable = false, length = 10)
	public String getEmprRut() {
		return this.emprRut;
	}

	public void setEmprRut(String emprRut) {
		this.emprRut = emprRut;
	}

	@Column(name = "EMPR_DIG", nullable = false, length = 1)
	public String getEmprDig() {
		return this.emprDig;
	}

	public void setEmprDig(String emprDig) {
		this.emprDig = emprDig;
	}

	@Column(name = "EMPR_RAZON_SOCIAL", nullable = false, length = 80)
	public String getEmprRazonSocial() {
		return this.emprRazonSocial;
	}

	public void setEmprRazonSocial(String emprRazonSocial) {
		this.emprRazonSocial = emprRazonSocial;
	}

	@Column(name = "EMPR_NOM_FANTASIA", length = 80)
	public String getEmprNomFantasia() {
		return this.emprNomFantasia;
	}

	public void setEmprNomFantasia(String emprNomFantasia) {
		this.emprNomFantasia = emprNomFantasia;
	}

	@Column(name = "EMPR_NOM_CONTACTO", length = 80)
	public String getEmprNomContacto() {
		return this.emprNomContacto;
	}

	public void setEmprNomContacto(String emprNomContacto) {
		this.emprNomContacto = emprNomContacto;
	}

	@Column(name = "EMPR_ESTADO", nullable = false, length = 5)
	public String getEmprEstado() {
		return this.emprEstado;
	}

	public void setEmprEstado(String emprEstado) {
		this.emprEstado = emprEstado;
	}

	@Column(name = "EMPR_USER_MOD", length = 30)
	public String getEmprUserMod() {
		return this.emprUserMod;
	}

	public void setEmprUserMod(String emprUserMod) {
		this.emprUserMod = emprUserMod;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EMPR_FEC_MOD", length = 7)
	public Date getEmprFecMod() {
		return this.emprFecMod;
	}

	public void setEmprFecMod(Date emprFecMod) {
		this.emprFecMod = emprFecMod;
	}

	@Column(name = "EMPR_GIRO", length = 100)
	public String getEmprGiro() {
		return this.emprGiro;
	}

	public void setEmprGiro(String emprGiro) {
		this.emprGiro = emprGiro;
	}

	@Column(name = "PERS_TIPO_ID_RESP", length = 4)
	public String getPersTipoIdResp() {
		return this.persTipoIdResp;
	}

	public void setPersTipoIdResp(String persTipoIdResp) {
		this.persTipoIdResp = persTipoIdResp;
	}

	@Column(name = "PERS_ID_RESP", length = 10)
	public String getPersIdResp() {
		return this.persIdResp;
	}

	public void setPersIdResp(String persIdResp) {
		this.persIdResp = persIdResp;
	}

	@Column(name = "EMPR_GER_COM_DESC", length = 200)
	public String getEmprGerComDesc() {
		return this.emprGerComDesc;
	}

	public void setEmprGerComDesc(String emprGerComDesc) {
		this.emprGerComDesc = emprGerComDesc;
	}

	@Column(name = "EMPR_TIPO", nullable = false, length = 20)
	public String getEmprTipo() {
		return this.emprTipo;
	}

	public void setEmprTipo(String emprTipo) {
		this.emprTipo = emprTipo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "genEmpresas")
	public Set<VtaOperModel> getVtaOpers() {
		return this.vtaOpers;
	}

	public void setVtaOpers(Set<VtaOperModel> vtaOpers) {
		this.vtaOpers = vtaOpers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "genEmpresas")
	public Set<VtaPeriodoModel> getVtaPeriodos() {
		return this.vtaPeriodos;
	}

	public void setVtaPeriodos(Set<VtaPeriodoModel> vtaPeriodos) {
		this.vtaPeriodos = vtaPeriodos;
	}

}
