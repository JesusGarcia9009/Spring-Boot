package com.pdr.common.cobranza.entity;

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

/**
 * @author BS2
 */
@Entity
@Table(name = "GEN_UNID_NEGOCIOS", schema = "GENPAR")
public class GenUnidNegociosModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String unegCod;
	private GenComunasModel genComunas;
	private String unegDesc;
	private String unegEstado;
	private String unegUserMod;
	private Date unegFecMod;
	private String unegCodNum;
	private String unegDescLarga;
	private Set<VtaOperModel> vtaOpers = new HashSet<VtaOperModel>(0);
	private Set<VtaPeriodoModel> vtaPeriodos = new HashSet<VtaPeriodoModel>(0);

	public GenUnidNegociosModel() {
	}

	public GenUnidNegociosModel(String unegCod, String unegDesc, String unegEstado, String unegUserMod, Date unegFecMod) {
		this.unegCod = unegCod;
		this.unegDesc = unegDesc;
		this.unegEstado = unegEstado;
		this.unegUserMod = unegUserMod;
		this.unegFecMod = unegFecMod;
	}

	public GenUnidNegociosModel(String unegCod, GenComunasModel genComunas, String unegDesc, String unegEstado,
			String unegUserMod, Date unegFecMod, String unegCodNum, String unegDescLarga, Set<VtaOperModel> vtaOpers,
			Set<VtaPeriodoModel> vtaPeriodos) {
		this.unegCod = unegCod;
		this.genComunas = genComunas;
		this.unegDesc = unegDesc;
		this.unegEstado = unegEstado;
		this.unegUserMod = unegUserMod;
		this.unegFecMod = unegFecMod;
		this.unegCodNum = unegCodNum;
		this.unegDescLarga = unegDescLarga;
		this.vtaOpers = vtaOpers;
		this.vtaPeriodos = vtaPeriodos;
	}

	@Id

	@Column(name = "UNEG_COD", unique = true, nullable = false, length = 10)
	public String getUnegCod() {
		return this.unegCod;
	}

	public void setUnegCod(String unegCod) {
		this.unegCod = unegCod;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UNEG_COMU_COD")
	public GenComunasModel getGenComunas() {
		return this.genComunas;
	}

	public void setGenComunas(GenComunasModel genComunas) {
		this.genComunas = genComunas;
	}

	@Column(name = "UNEG_DESC", nullable = false, length = 40)
	public String getUnegDesc() {
		return this.unegDesc;
	}

	public void setUnegDesc(String unegDesc) {
		this.unegDesc = unegDesc;
	}

	@Column(name = "UNEG_ESTADO", nullable = false, length = 1)
	public String getUnegEstado() {
		return this.unegEstado;
	}

	public void setUnegEstado(String unegEstado) {
		this.unegEstado = unegEstado;
	}

	@Column(name = "UNEG_USER_MOD", nullable = false, length = 30)
	public String getUnegUserMod() {
		return this.unegUserMod;
	}

	public void setUnegUserMod(String unegUserMod) {
		this.unegUserMod = unegUserMod;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UNEG_FEC_MOD", nullable = false, length = 7)
	public Date getUnegFecMod() {
		return this.unegFecMod;
	}

	public void setUnegFecMod(Date unegFecMod) {
		this.unegFecMod = unegFecMod;
	}

	@Column(name = "UNEG_COD_NUM", length = 3)
	public String getUnegCodNum() {
		return this.unegCodNum;
	}

	public void setUnegCodNum(String unegCodNum) {
		this.unegCodNum = unegCodNum;
	}

	@Column(name = "UNEG_DESC_LARGA", length = 150)
	public String getUnegDescLarga() {
		return this.unegDescLarga;
	}

	public void setUnegDescLarga(String unegDescLarga) {
		this.unegDescLarga = unegDescLarga;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "genUnidNegocios")
	public Set<VtaOperModel> getVtaOpers() {
		return this.vtaOpers;
	}

	public void setVtaOpers(Set<VtaOperModel> vtaOpers) {
		this.vtaOpers = vtaOpers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "genUnidNegocios")
	public Set<VtaPeriodoModel> getVtaPeriodos() {
		return this.vtaPeriodos;
	}

	public void setVtaPeriodos(Set<VtaPeriodoModel> vtaPeriodos) {
		this.vtaPeriodos = vtaPeriodos;
	}

}
