package com.pdr.common.cobranza.entity;

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
@Table(name = "COB_RENEG_PGRE_CUOTAS", schema = "COBPAR")
public class CobRenegPgreCuotasModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3585250104924787972L;
	private CobRenegPgreCuotasIdModel id;
	private CobPagareModel cobPagare;
	private VtaContratosModel vtaContratos;
	private VtaOperModel vtaOper;
	private int reneCuotIni;
	private Integer reneCuotFin;
	private Date reneCuotFechIni;
	private Date reneCuotFechFin;
	private short reneCuotCant;
	private BigDecimal renePmtVenc;
	private BigDecimal renePmtVencMoneOper;
	private BigDecimal renePmtXVenc;
	private BigDecimal reneIntXMora;
	private BigDecimal reneGtosCobr;
	private BigDecimal reneValUf;
	private BigDecimal renePmtXVencMoneOper;
	private String campCod;
	private BigDecimal reneIntXMoraMoneOper;
	private BigDecimal reneGtosCobrMoneOper;
	private Long renePgreKapiPeso;
	private BigDecimal renePgreKapi;
	private Long renePgreIkapiPeso;
	private BigDecimal renePgreIkapi;

	public CobRenegPgreCuotasModel() {
	}

	public CobRenegPgreCuotasModel(CobRenegPgreCuotasIdModel id, CobPagareModel cobPagare, VtaContratosModel vtaContratos, VtaOperModel vtaOper,
			int reneCuotIni, Date reneCuotFechIni, Date reneCuotFechFin, short reneCuotCant, BigDecimal reneIntXMora,
			BigDecimal renePmtXVencMoneOper) {
		this.id = id;
		this.cobPagare = cobPagare;
		this.vtaContratos = vtaContratos;
		this.vtaOper = vtaOper;
		this.reneCuotIni = reneCuotIni;
		this.reneCuotFechIni = reneCuotFechIni;
		this.reneCuotFechFin = reneCuotFechFin;
		this.reneCuotCant = reneCuotCant;
		this.reneIntXMora = reneIntXMora;
		this.renePmtXVencMoneOper = renePmtXVencMoneOper;
	}

	public CobRenegPgreCuotasModel(CobRenegPgreCuotasIdModel id, CobPagareModel cobPagare, VtaContratosModel vtaContratos, VtaOperModel vtaOper,
			int reneCuotIni, Integer reneCuotFin, Date reneCuotFechIni, Date reneCuotFechFin, short reneCuotCant,
			BigDecimal renePmtVenc, BigDecimal renePmtVencMoneOper, BigDecimal renePmtXVenc, BigDecimal reneIntXMora,
			BigDecimal reneGtosCobr, BigDecimal reneValUf, BigDecimal renePmtXVencMoneOper, String campCod,
			BigDecimal reneIntXMoraMoneOper, BigDecimal reneGtosCobrMoneOper, Long renePgreKapiPeso,
			BigDecimal renePgreKapi, Long renePgreIkapiPeso, BigDecimal renePgreIkapi) {
		this.id = id;
		this.cobPagare = cobPagare;
		this.vtaContratos = vtaContratos;
		this.vtaOper = vtaOper;
		this.reneCuotIni = reneCuotIni;
		this.reneCuotFin = reneCuotFin;
		this.reneCuotFechIni = reneCuotFechIni;
		this.reneCuotFechFin = reneCuotFechFin;
		this.reneCuotCant = reneCuotCant;
		this.renePmtVenc = renePmtVenc;
		this.renePmtVencMoneOper = renePmtVencMoneOper;
		this.renePmtXVenc = renePmtXVenc;
		this.reneIntXMora = reneIntXMora;
		this.reneGtosCobr = reneGtosCobr;
		this.reneValUf = reneValUf;
		this.renePmtXVencMoneOper = renePmtXVencMoneOper;
		this.campCod = campCod;
		this.reneIntXMoraMoneOper = reneIntXMoraMoneOper;
		this.reneGtosCobrMoneOper = reneGtosCobrMoneOper;
		this.renePgreKapiPeso = renePgreKapiPeso;
		this.renePgreKapi = renePgreKapi;
		this.renePgreIkapiPeso = renePgreIkapiPeso;
		this.renePgreIkapi = renePgreIkapi;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "vtopCod", column = @Column(name = "VTOP_COD", nullable = false, precision = 23, scale = 0)),
			@AttributeOverride(name = "vtopCodCont", column = @Column(name = "VTOP_COD_CONT", nullable = false, precision = 23, scale = 0)),
			@AttributeOverride(name = "pgreSec", column = @Column(name = "PGRE_SEC", nullable = false, precision = 23, scale = 0)) })
	public CobRenegPgreCuotasIdModel getId() {
		return this.id;
	}

	public void setId(CobRenegPgreCuotasIdModel id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PGRE_SEC", nullable = false, insertable = false, updatable = false)
	public CobPagareModel getCobPagare() {
		return this.cobPagare;
	}

	public void setCobPagare(CobPagareModel cobPagare) {
		this.cobPagare = cobPagare;
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

	@Column(name = "RENE_CUOT_INI", nullable = false, precision = 5, scale = 0)
	public int getReneCuotIni() {
		return this.reneCuotIni;
	}

	public void setReneCuotIni(int reneCuotIni) {
		this.reneCuotIni = reneCuotIni;
	}

	@Column(name = "RENE_CUOT_FIN", precision = 5, scale = 0)
	public Integer getReneCuotFin() {
		return this.reneCuotFin;
	}

	public void setReneCuotFin(Integer reneCuotFin) {
		this.reneCuotFin = reneCuotFin;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "RENE_CUOT_FECH_INI", nullable = false, length = 7)
	public Date getReneCuotFechIni() {
		return this.reneCuotFechIni;
	}

	public void setReneCuotFechIni(Date reneCuotFechIni) {
		this.reneCuotFechIni = reneCuotFechIni;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "RENE_CUOT_FECH_FIN", nullable = false, length = 7)
	public Date getReneCuotFechFin() {
		return this.reneCuotFechFin;
	}

	public void setReneCuotFechFin(Date reneCuotFechFin) {
		this.reneCuotFechFin = reneCuotFechFin;
	}

	@Column(name = "RENE_CUOT_CANT", nullable = false, precision = 3, scale = 0)
	public short getReneCuotCant() {
		return this.reneCuotCant;
	}

	public void setReneCuotCant(short reneCuotCant) {
		this.reneCuotCant = reneCuotCant;
	}

	@Column(name = "RENE_PMT_VENC", precision = 14)
	public BigDecimal getRenePmtVenc() {
		return this.renePmtVenc;
	}

	public void setRenePmtVenc(BigDecimal renePmtVenc) {
		this.renePmtVenc = renePmtVenc;
	}

	@Column(name = "RENE_PMT_VENC_MONE_OPER", precision = 14)
	public BigDecimal getRenePmtVencMoneOper() {
		return this.renePmtVencMoneOper;
	}

	public void setRenePmtVencMoneOper(BigDecimal renePmtVencMoneOper) {
		this.renePmtVencMoneOper = renePmtVencMoneOper;
	}

	@Column(name = "RENE_PMT_X_VENC", precision = 14)
	public BigDecimal getRenePmtXVenc() {
		return this.renePmtXVenc;
	}

	public void setRenePmtXVenc(BigDecimal renePmtXVenc) {
		this.renePmtXVenc = renePmtXVenc;
	}

	@Column(name = "RENE_INT_X_MORA", nullable = false, precision = 14)
	public BigDecimal getReneIntXMora() {
		return this.reneIntXMora;
	}

	public void setReneIntXMora(BigDecimal reneIntXMora) {
		this.reneIntXMora = reneIntXMora;
	}

	@Column(name = "RENE_GTOS_COBR", precision = 14)
	public BigDecimal getReneGtosCobr() {
		return this.reneGtosCobr;
	}

	public void setReneGtosCobr(BigDecimal reneGtosCobr) {
		this.reneGtosCobr = reneGtosCobr;
	}

	@Column(name = "RENE_VAL_UF", precision = 14)
	public BigDecimal getReneValUf() {
		return this.reneValUf;
	}

	public void setReneValUf(BigDecimal reneValUf) {
		this.reneValUf = reneValUf;
	}

	@Column(name = "RENE_PMT_X_VENC_MONE_OPER", nullable = false, precision = 14)
	public BigDecimal getRenePmtXVencMoneOper() {
		return this.renePmtXVencMoneOper;
	}

	public void setRenePmtXVencMoneOper(BigDecimal renePmtXVencMoneOper) {
		this.renePmtXVencMoneOper = renePmtXVencMoneOper;
	}

	@Column(name = "CAMP_COD", length = 20)
	public String getCampCod() {
		return this.campCod;
	}

	public void setCampCod(String campCod) {
		this.campCod = campCod;
	}

	@Column(name = "RENE_INT_X_MORA_MONE_OPER", precision = 14)
	public BigDecimal getReneIntXMoraMoneOper() {
		return this.reneIntXMoraMoneOper;
	}

	public void setReneIntXMoraMoneOper(BigDecimal reneIntXMoraMoneOper) {
		this.reneIntXMoraMoneOper = reneIntXMoraMoneOper;
	}

	@Column(name = "RENE_GTOS_COBR_MONE_OPER", precision = 14)
	public BigDecimal getReneGtosCobrMoneOper() {
		return this.reneGtosCobrMoneOper;
	}

	public void setReneGtosCobrMoneOper(BigDecimal reneGtosCobrMoneOper) {
		this.reneGtosCobrMoneOper = reneGtosCobrMoneOper;
	}

	@Column(name = "RENE_PGRE_KAPI_PESO", precision = 14, scale = 0)
	public Long getRenePgreKapiPeso() {
		return this.renePgreKapiPeso;
	}

	public void setRenePgreKapiPeso(Long renePgreKapiPeso) {
		this.renePgreKapiPeso = renePgreKapiPeso;
	}

	@Column(name = "RENE_PGRE_KAPI", precision = 14)
	public BigDecimal getRenePgreKapi() {
		return this.renePgreKapi;
	}

	public void setRenePgreKapi(BigDecimal renePgreKapi) {
		this.renePgreKapi = renePgreKapi;
	}

	@Column(name = "RENE_PGRE_IKAPI_PESO", precision = 14, scale = 0)
	public Long getRenePgreIkapiPeso() {
		return this.renePgreIkapiPeso;
	}

	public void setRenePgreIkapiPeso(Long renePgreIkapiPeso) {
		this.renePgreIkapiPeso = renePgreIkapiPeso;
	}

	@Column(name = "RENE_PGRE_IKAPI", precision = 14)
	public BigDecimal getRenePgreIkapi() {
		return this.renePgreIkapi;
	}

	public void setRenePgreIkapi(BigDecimal renePgreIkapi) {
		this.renePgreIkapi = renePgreIkapi;
	}

}
