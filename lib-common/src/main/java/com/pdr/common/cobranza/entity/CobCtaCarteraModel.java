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
 * BS2
 */
@Entity
@Table(name = "COB_CTA_CARTERA", schema = "COBPAR")
public class CobCtaCarteraModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4124715936756922693L;
	private CobCtaCarteraIdModel id;
	private GenEmpresasModel genEmpresas;
	private String ccarDesc;
	private String ccarGlos1;
	private String ccarGlos2;
	private String ccarCconCod;
	private String ccarClasCod;
	private String ccarLugaPago;
	private String ccarAviVenc;
	private String ccarCob;
	private String ccarCastCod;
	private String ccarBankId;
	private String ccarProp;
	private String ccarInstCod;
	private String ccarUserMod;
	private Date ccarFecMod;
	private String ccarIndDicom;
	private String ccarIndCarta;
	private Set<CobPagareModel> cobPagares = new HashSet<>(0);

	public CobCtaCarteraModel() {
	}

	

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "emprCod", column = @Column(name = "EMPR_COD", nullable = false, length = 10)),
			@AttributeOverride(name = "ccarCod", column = @Column(name = "CCAR_COD", nullable = false, length = 10)) })
	public CobCtaCarteraIdModel getId() {
		return this.id;
	}

	public void setId(CobCtaCarteraIdModel id) {
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

	@Column(name = "CCAR_DESC", nullable = false, length = 60)
	public String getCcarDesc() {
		return this.ccarDesc;
	}

	public void setCcarDesc(String ccarDesc) {
		this.ccarDesc = ccarDesc;
	}

	@Column(name = "CCAR_GLOS_1", nullable = false, length = 62)
	public String getCcarGlos1() {
		return this.ccarGlos1;
	}

	public void setCcarGlos1(String ccarGlos1) {
		this.ccarGlos1 = ccarGlos1;
	}

	@Column(name = "CCAR_GLOS_2", length = 62)
	public String getCcarGlos2() {
		return this.ccarGlos2;
	}

	public void setCcarGlos2(String ccarGlos2) {
		this.ccarGlos2 = ccarGlos2;
	}

	@Column(name = "CCAR_CCON_COD", length = 10)
	public String getCcarCconCod() {
		return this.ccarCconCod;
	}

	public void setCcarCconCod(String ccarCconCod) {
		this.ccarCconCod = ccarCconCod;
	}

	@Column(name = "CCAR_CLAS_COD", nullable = false, length = 20)
	public String getCcarClasCod() {
		return this.ccarClasCod;
	}

	public void setCcarClasCod(String ccarClasCod) {
		this.ccarClasCod = ccarClasCod;
	}

	@Column(name = "CCAR_LUGA_PAGO", nullable = false, length = 20)
	public String getCcarLugaPago() {
		return this.ccarLugaPago;
	}

	public void setCcarLugaPago(String ccarLugaPago) {
		this.ccarLugaPago = ccarLugaPago;
	}

	@Column(name = "CCAR_AVI_VENC", nullable = false, length = 2)
	public String getCcarAviVenc() {
		return this.ccarAviVenc;
	}

	public void setCcarAviVenc(String ccarAviVenc) {
		this.ccarAviVenc = ccarAviVenc;
	}

	@Column(name = "CCAR_COB", nullable = false, length = 2)
	public String getCcarCob() {
		return this.ccarCob;
	}

	public void setCcarCob(String ccarCob) {
		this.ccarCob = ccarCob;
	}

	@Column(name = "CCAR_CAST_COD", length = 10)
	public String getCcarCastCod() {
		return this.ccarCastCod;
	}

	public void setCcarCastCod(String ccarCastCod) {
		this.ccarCastCod = ccarCastCod;
	}

	@Column(name = "CCAR_BANK_ID", nullable = false, length = 20)
	public String getCcarBankId() {
		return this.ccarBankId;
	}

	public void setCcarBankId(String ccarBankId) {
		this.ccarBankId = ccarBankId;
	}

	@Column(name = "CCAR_PROP", nullable = false, length = 2)
	public String getCcarProp() {
		return this.ccarProp;
	}

	public void setCcarProp(String ccarProp) {
		this.ccarProp = ccarProp;
	}

	@Column(name = "CCAR_INST_COD", length = 20)
	public String getCcarInstCod() {
		return this.ccarInstCod;
	}

	public void setCcarInstCod(String ccarInstCod) {
		this.ccarInstCod = ccarInstCod;
	}

	@Column(name = "CCAR_USER_MOD", nullable = false, length = 20)
	public String getCcarUserMod() {
		return this.ccarUserMod;
	}

	public void setCcarUserMod(String ccarUserMod) {
		this.ccarUserMod = ccarUserMod;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CCAR_FEC_MOD", nullable = false, length = 7)
	public Date getCcarFecMod() {
		return this.ccarFecMod;
	}

	public void setCcarFecMod(Date ccarFecMod) {
		this.ccarFecMod = ccarFecMod;
	}

	@Column(name = "CCAR_IND_DICOM", length = 2)
	public String getCcarIndDicom() {
		return this.ccarIndDicom;
	}

	public void setCcarIndDicom(String ccarIndDicom) {
		this.ccarIndDicom = ccarIndDicom;
	}

	@Column(name = "CCAR_IND_CARTA", length = 2)
	public String getCcarIndCarta() {
		return this.ccarIndCarta;
	}

	public void setCcarIndCarta(String ccarIndCarta) {
		this.ccarIndCarta = ccarIndCarta;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cobCtaCartera")
	public Set<CobPagareModel> getCobPagares() {
		return this.cobPagares;
	}

	public void setCobPagares(Set<CobPagareModel> cobPagares) {
		this.cobPagares = cobPagares;
	}

}
