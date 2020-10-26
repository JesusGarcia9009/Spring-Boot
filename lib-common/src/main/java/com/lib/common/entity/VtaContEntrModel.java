package com.lib.common.entity;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * BS2
 */
@Entity
@Table(name = "VTA_CONT_ENTR", schema = "VTAPAR")
public class VtaContEntrModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VtaContEntrIdModel id;
	private VtaContratosModel vtaContratos;
	private VtaOperModel vtaOper;
	private BigDecimal opcnKapiReconocidoUf;
	private Long opcnKapiReconocidoPeso;
	private BigDecimal opcnKapiAdeudadoUf;
	private Long opcnKapiAdeudadoPeso;
	private BigDecimal opcnAjusteUf;
	private BigDecimal opcnAjustePeso;
	private BigDecimal opcnMoraUf;
	private Long opcnMoraPeso;
	private String opcnIndPerm;
	private String opcnEstaCod;
	private String opcnUserMod;
	private Date opcnFecMod;
	private String moneCodVta;

	public VtaContEntrModel() {
	}

	public VtaContEntrModel(VtaContEntrIdModel id, VtaContratosModel vtaContratos, VtaOperModel vtaOper, BigDecimal opcnKapiReconocidoUf,
			String opcnEstaCod, String opcnUserMod, Date opcnFecMod) {
		this.id = id;
		this.vtaContratos = vtaContratos;
		this.vtaOper = vtaOper;
		this.opcnKapiReconocidoUf = opcnKapiReconocidoUf;
		this.opcnEstaCod = opcnEstaCod;
		this.opcnUserMod = opcnUserMod;
		this.opcnFecMod = opcnFecMod;
	}

	public VtaContEntrModel(VtaContEntrIdModel id, VtaContratosModel vtaContratos, VtaOperModel vtaOper, BigDecimal opcnKapiReconocidoUf,
			Long opcnKapiReconocidoPeso, BigDecimal opcnKapiAdeudadoUf, Long opcnKapiAdeudadoPeso,
			BigDecimal opcnAjusteUf, BigDecimal opcnAjustePeso, BigDecimal opcnMoraUf, Long opcnMoraPeso,
			String opcnIndPerm, String opcnEstaCod, String opcnUserMod, Date opcnFecMod, String moneCodVta) {
		this.id = id;
		this.vtaContratos = vtaContratos;
		this.vtaOper = vtaOper;
		this.opcnKapiReconocidoUf = opcnKapiReconocidoUf;
		this.opcnKapiReconocidoPeso = opcnKapiReconocidoPeso;
		this.opcnKapiAdeudadoUf = opcnKapiAdeudadoUf;
		this.opcnKapiAdeudadoPeso = opcnKapiAdeudadoPeso;
		this.opcnAjusteUf = opcnAjusteUf;
		this.opcnAjustePeso = opcnAjustePeso;
		this.opcnMoraUf = opcnMoraUf;
		this.opcnMoraPeso = opcnMoraPeso;
		this.opcnIndPerm = opcnIndPerm;
		this.opcnEstaCod = opcnEstaCod;
		this.opcnUserMod = opcnUserMod;
		this.opcnFecMod = opcnFecMod;
		this.moneCodVta = moneCodVta;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "vtopCod", column = @Column(name = "VTOP_COD", nullable = false, precision = 23, scale = 0)),
			@AttributeOverride(name = "vtopCodCont", column = @Column(name = "VTOP_COD_CONT", nullable = false, precision = 23, scale = 0)) })
	public VtaContEntrIdModel getId() {
		return this.id;
	}

	public void setId(VtaContEntrIdModel id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VTOP_COD_CONT", nullable = false, insertable = false, updatable = false)
	public VtaContratosModel getVtaContratos() {
		return this.vtaContratos;
	}

	public void setVtaContratos(VtaContratosModel vtaContratos) {
		this.vtaContratos = vtaContratos;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VTOP_COD", nullable = false, insertable = false, updatable = false)
	public VtaOperModel getVtaOper() {
		return this.vtaOper;
	}

	public void setVtaOper(VtaOperModel vtaOper) {
		this.vtaOper = vtaOper;
	}

	@Column(name = "OPCN_KAPI_RECONOCIDO_UF", nullable = false, precision = 14)
	public BigDecimal getOpcnKapiReconocidoUf() {
		return this.opcnKapiReconocidoUf;
	}

	public void setOpcnKapiReconocidoUf(BigDecimal opcnKapiReconocidoUf) {
		this.opcnKapiReconocidoUf = opcnKapiReconocidoUf;
	}

	@Column(name = "OPCN_KAPI_RECONOCIDO_PESO", precision = 14, scale = 0)
	public Long getOpcnKapiReconocidoPeso() {
		return this.opcnKapiReconocidoPeso;
	}

	public void setOpcnKapiReconocidoPeso(Long opcnKapiReconocidoPeso) {
		this.opcnKapiReconocidoPeso = opcnKapiReconocidoPeso;
	}

	@Column(name = "OPCN_KAPI_ADEUDADO_UF", precision = 14)
	public BigDecimal getOpcnKapiAdeudadoUf() {
		return this.opcnKapiAdeudadoUf;
	}

	public void setOpcnKapiAdeudadoUf(BigDecimal opcnKapiAdeudadoUf) {
		this.opcnKapiAdeudadoUf = opcnKapiAdeudadoUf;
	}

	@Column(name = "OPCN_KAPI_ADEUDADO_PESO", precision = 14, scale = 0)
	public Long getOpcnKapiAdeudadoPeso() {
		return this.opcnKapiAdeudadoPeso;
	}

	public void setOpcnKapiAdeudadoPeso(Long opcnKapiAdeudadoPeso) {
		this.opcnKapiAdeudadoPeso = opcnKapiAdeudadoPeso;
	}

	@Column(name = "OPCN_AJUSTE_UF", precision = 14)
	public BigDecimal getOpcnAjusteUf() {
		return this.opcnAjusteUf;
	}

	public void setOpcnAjusteUf(BigDecimal opcnAjusteUf) {
		this.opcnAjusteUf = opcnAjusteUf;
	}

	@Column(name = "OPCN_AJUSTE_PESO", precision = 22, scale = 0)
	public BigDecimal getOpcnAjustePeso() {
		return this.opcnAjustePeso;
	}

	public void setOpcnAjustePeso(BigDecimal opcnAjustePeso) {
		this.opcnAjustePeso = opcnAjustePeso;
	}

	@Column(name = "OPCN_MORA_UF", precision = 14)
	public BigDecimal getOpcnMoraUf() {
		return this.opcnMoraUf;
	}

	public void setOpcnMoraUf(BigDecimal opcnMoraUf) {
		this.opcnMoraUf = opcnMoraUf;
	}

	@Column(name = "OPCN_MORA_PESO", precision = 14, scale = 0)
	public Long getOpcnMoraPeso() {
		return this.opcnMoraPeso;
	}

	public void setOpcnMoraPeso(Long opcnMoraPeso) {
		this.opcnMoraPeso = opcnMoraPeso;
	}

	@Column(name = "OPCN_IND_PERM", length = 2)
	public String getOpcnIndPerm() {
		return this.opcnIndPerm;
	}

	public void setOpcnIndPerm(String opcnIndPerm) {
		this.opcnIndPerm = opcnIndPerm;
	}

	@Column(name = "OPCN_ESTA_COD", nullable = false, length = 20)
	public String getOpcnEstaCod() {
		return this.opcnEstaCod;
	}

	public void setOpcnEstaCod(String opcnEstaCod) {
		this.opcnEstaCod = opcnEstaCod;
	}

	@Column(name = "OPCN_USER_MOD", nullable = false, length = 30)
	public String getOpcnUserMod() {
		return this.opcnUserMod;
	}

	public void setOpcnUserMod(String opcnUserMod) {
		this.opcnUserMod = opcnUserMod;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "OPCN_FEC_MOD", nullable = false, length = 7)
	public Date getOpcnFecMod() {
		return this.opcnFecMod;
	}

	public void setOpcnFecMod(Date opcnFecMod) {
		this.opcnFecMod = opcnFecMod;
	}

	@Column(name = "MONE_COD_VTA", length = 10)
	public String getMoneCodVta() {
		return this.moneCodVta;
	}

	public void setMoneCodVta(String moneCodVta) {
		this.moneCodVta = moneCodVta;
	}

}
