package com.pdr.common.cobranza.entity;

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
@Table(name = "COB_CATALOGO_PGRE", schema = "COBPAR")
public class CobCatalogoPgreModel implements java.io.Serializable {

	private static final long serialVersionUID = 7586500025348608150L;
	private BigDecimal catpSec;
	private CobProcAsigCartModel cobProcAsigCart;
	private String unegCod;
	private String catpEstaCod;
	private String faseCod;
	private String cartTipoCod;
	private String cateCod;
	private Date catpDiaAsignacUpd;
	private String persTipoIdCobr;
	private String persIdCobr;
	private BigDecimal catpDeudaTotMnto;
	private Long catpDeudaTotCuo;
	private BigDecimal catpAsigPeriodMnto;
	private Long catpAsigPeriodCuo;
	private BigDecimal catpDeudaVencMnto;
	private Long catpDeudaVencCuo;
	private BigDecimal catpRecuperadoMnto;
	private Long catpRecuperadoCuo;
	private String catpUserMod;
	private Date catpFecMod;
	private BigDecimal vtopCodCont;
	private BigDecimal pgreSec;
	private Date catpVencCuot;
	private String catpSubCalificCart;
	private String catpEtapaCod;
	private String catpMoraCod;
	private String catpIndCastigoPorCr;
	private BigDecimal catpFagPorcPag;
	private BigDecimal catpFagPorcPag5;
	private String catpIndPac;
	private String catpBcoPac;
	private BigDecimal catpRecuRenegMnto;
	private Long catpRecuRenegCuo;
	private Date catpFechVencMaxCuot;
	private String catpMoneCod;
	private String tipoDocto;
	private BigDecimal numDocto;
	private Set<CbzCobCatalogoPgreDetalleModel> cbzCobCatalogoPgreDetalles = new HashSet<>(0);
	//private Set<CbzUserCatalogoPgreModel> cbzUserCatalogoPgres = new HashSet<>(0);

	public CobCatalogoPgreModel() {
	}

	public CobCatalogoPgreModel(BigDecimal catpSec, CobProcAsigCartModel cobProcAsigCart, String unegCod, String catpEstaCod,
			String faseCod, String cartTipoCod, String cateCod) {
		this.catpSec = catpSec;
		this.cobProcAsigCart = cobProcAsigCart;
		this.unegCod = unegCod;
		this.catpEstaCod = catpEstaCod;
		this.faseCod = faseCod;
		this.cartTipoCod = cartTipoCod;
		this.cateCod = cateCod;
	}

	public CobCatalogoPgreModel(BigDecimal catpSec, CobProcAsigCartModel cobProcAsigCart, String unegCod, String catpEstaCod,
			String faseCod, String cartTipoCod, String cateCod, Date catpDiaAsignacUpd, String persTipoIdCobr,
			String persIdCobr, BigDecimal catpDeudaTotMnto, Long catpDeudaTotCuo, BigDecimal catpAsigPeriodMnto,
			Long catpAsigPeriodCuo, BigDecimal catpDeudaVencMnto, Long catpDeudaVencCuo, BigDecimal catpRecuperadoMnto,
			Long catpRecuperadoCuo, String catpUserMod, Date catpFecMod, BigDecimal vtopCodCont, BigDecimal pgreSec,
			Date catpVencCuot, String catpSubCalificCart, String catpEtapaCod, String catpMoraCod,
			String catpIndCastigoPorCr, BigDecimal catpFagPorcPag, BigDecimal catpFagPorcPag5, String catpIndPac,
			String catpBcoPac, BigDecimal catpRecuRenegMnto, Long catpRecuRenegCuo, Date catpFechVencMaxCuot,
			String catpMoneCod, String tipoDocto, BigDecimal numDocto) {
		this.catpSec = catpSec;
		this.cobProcAsigCart = cobProcAsigCart;
		this.unegCod = unegCod;
		this.catpEstaCod = catpEstaCod;
		this.faseCod = faseCod;
		this.cartTipoCod = cartTipoCod;
		this.cateCod = cateCod;
		this.catpDiaAsignacUpd = catpDiaAsignacUpd;
		this.persTipoIdCobr = persTipoIdCobr;
		this.persIdCobr = persIdCobr;
		this.catpDeudaTotMnto = catpDeudaTotMnto;
		this.catpDeudaTotCuo = catpDeudaTotCuo;
		this.catpAsigPeriodMnto = catpAsigPeriodMnto;
		this.catpAsigPeriodCuo = catpAsigPeriodCuo;
		this.catpDeudaVencMnto = catpDeudaVencMnto;
		this.catpDeudaVencCuo = catpDeudaVencCuo;
		this.catpRecuperadoMnto = catpRecuperadoMnto;
		this.catpRecuperadoCuo = catpRecuperadoCuo;
		this.catpUserMod = catpUserMod;
		this.catpFecMod = catpFecMod;
		this.vtopCodCont = vtopCodCont;
		this.pgreSec = pgreSec;
		this.catpVencCuot = catpVencCuot;
		this.catpSubCalificCart = catpSubCalificCart;
		this.catpEtapaCod = catpEtapaCod;
		this.catpMoraCod = catpMoraCod;
		this.catpIndCastigoPorCr = catpIndCastigoPorCr;
		this.catpFagPorcPag = catpFagPorcPag;
		this.catpFagPorcPag5 = catpFagPorcPag5;
		this.catpIndPac = catpIndPac;
		this.catpBcoPac = catpBcoPac;
		this.catpRecuRenegMnto = catpRecuRenegMnto;
		this.catpRecuRenegCuo = catpRecuRenegCuo;
		this.catpFechVencMaxCuot = catpFechVencMaxCuot;
		this.catpMoneCod = catpMoneCod;
		this.tipoDocto = tipoDocto;
		this.numDocto = numDocto;
	}

	@Id

	@Column(name = "CATP_SEC", unique = true, nullable = false, precision = 23, scale = 0)
	public BigDecimal getCatpSec() {
		return this.catpSec;
	}

	public void setCatpSec(BigDecimal catpSec) {
		this.catpSec = catpSec;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "EMPR_COD", referencedColumnName = "EMPR_COD", nullable = false),
			@JoinColumn(name = "CATP_PROD_COD", referencedColumnName = "PACR_PROD_COD", nullable = false),
			@JoinColumn(name = "CATP_PERIODO", referencedColumnName = "PACR_PRDO_COD", nullable = false),
			@JoinColumn(name = "CATP_DIA_ASIGNAC_INS", referencedColumnName = "PACR_DIA_ASIG", nullable = false) })
	public CobProcAsigCartModel getCobProcAsigCart() {
		return this.cobProcAsigCart;
	}

	public void setCobProcAsigCart(CobProcAsigCartModel cobProcAsigCart) {
		this.cobProcAsigCart = cobProcAsigCart;
	}

	@Column(name = "UNEG_COD", nullable = false, length = 10)
	public String getUnegCod() {
		return this.unegCod;
	}

	public void setUnegCod(String unegCod) {
		this.unegCod = unegCod;
	}

	@Column(name = "CATP_ESTA_COD", nullable = false, length = 10)
	public String getCatpEstaCod() {
		return this.catpEstaCod;
	}

	public void setCatpEstaCod(String catpEstaCod) {
		this.catpEstaCod = catpEstaCod;
	}

	@Column(name = "FASE_COD", nullable = false, length = 20)
	public String getFaseCod() {
		return this.faseCod;
	}

	public void setFaseCod(String faseCod) {
		this.faseCod = faseCod;
	}

	@Column(name = "CART_TIPO_COD", nullable = false, length = 10)
	public String getCartTipoCod() {
		return this.cartTipoCod;
	}

	public void setCartTipoCod(String cartTipoCod) {
		this.cartTipoCod = cartTipoCod;
	}

	@Column(name = "CATE_COD", nullable = false, length = 10)
	public String getCateCod() {
		return this.cateCod;
	}

	public void setCateCod(String cateCod) {
		this.cateCod = cateCod;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CATP_DIA_ASIGNAC_UPD", length = 7)
	public Date getCatpDiaAsignacUpd() {
		return this.catpDiaAsignacUpd;
	}

	public void setCatpDiaAsignacUpd(Date catpDiaAsignacUpd) {
		this.catpDiaAsignacUpd = catpDiaAsignacUpd;
	}

	@Column(name = "PERS_TIPO_ID_COBR", length = 4)
	public String getPersTipoIdCobr() {
		return this.persTipoIdCobr;
	}

	public void setPersTipoIdCobr(String persTipoIdCobr) {
		this.persTipoIdCobr = persTipoIdCobr;
	}

	@Column(name = "PERS_ID_COBR", length = 10)
	public String getPersIdCobr() {
		return this.persIdCobr;
	}

	public void setPersIdCobr(String persIdCobr) {
		this.persIdCobr = persIdCobr;
	}

	@Column(name = "CATP_DEUDA_TOT_MNTO", precision = 23)
	public BigDecimal getCatpDeudaTotMnto() {
		return this.catpDeudaTotMnto;
	}

	public void setCatpDeudaTotMnto(BigDecimal catpDeudaTotMnto) {
		this.catpDeudaTotMnto = catpDeudaTotMnto;
	}

	@Column(name = "CATP_DEUDA_TOT_CUO", precision = 10, scale = 0)
	public Long getCatpDeudaTotCuo() {
		return this.catpDeudaTotCuo;
	}

	public void setCatpDeudaTotCuo(Long catpDeudaTotCuo) {
		this.catpDeudaTotCuo = catpDeudaTotCuo;
	}

	@Column(name = "CATP_ASIG_PERIOD_MNTO", precision = 23)
	public BigDecimal getCatpAsigPeriodMnto() {
		return this.catpAsigPeriodMnto;
	}

	public void setCatpAsigPeriodMnto(BigDecimal catpAsigPeriodMnto) {
		this.catpAsigPeriodMnto = catpAsigPeriodMnto;
	}

	@Column(name = "CATP_ASIG_PERIOD_CUO", precision = 10, scale = 0)
	public Long getCatpAsigPeriodCuo() {
		return this.catpAsigPeriodCuo;
	}

	public void setCatpAsigPeriodCuo(Long catpAsigPeriodCuo) {
		this.catpAsigPeriodCuo = catpAsigPeriodCuo;
	}

	@Column(name = "CATP_DEUDA_VENC_MNTO", precision = 23)
	public BigDecimal getCatpDeudaVencMnto() {
		return this.catpDeudaVencMnto;
	}

	public void setCatpDeudaVencMnto(BigDecimal catpDeudaVencMnto) {
		this.catpDeudaVencMnto = catpDeudaVencMnto;
	}

	@Column(name = "CATP_DEUDA_VENC_CUO", precision = 10, scale = 0)
	public Long getCatpDeudaVencCuo() {
		return this.catpDeudaVencCuo;
	}

	public void setCatpDeudaVencCuo(Long catpDeudaVencCuo) {
		this.catpDeudaVencCuo = catpDeudaVencCuo;
	}

	@Column(name = "CATP_RECUPERADO_MNTO", precision = 23)
	public BigDecimal getCatpRecuperadoMnto() {
		return this.catpRecuperadoMnto;
	}

	public void setCatpRecuperadoMnto(BigDecimal catpRecuperadoMnto) {
		this.catpRecuperadoMnto = catpRecuperadoMnto;
	}

	@Column(name = "CATP_RECUPERADO_CUO", precision = 10, scale = 0)
	public Long getCatpRecuperadoCuo() {
		return this.catpRecuperadoCuo;
	}

	public void setCatpRecuperadoCuo(Long catpRecuperadoCuo) {
		this.catpRecuperadoCuo = catpRecuperadoCuo;
	}

	@Column(name = "CATP_USER_MOD", length = 20)
	public String getCatpUserMod() {
		return this.catpUserMod;
	}

	public void setCatpUserMod(String catpUserMod) {
		this.catpUserMod = catpUserMod;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CATP_FEC_MOD", length = 7)
	public Date getCatpFecMod() {
		return this.catpFecMod;
	}

	public void setCatpFecMod(Date catpFecMod) {
		this.catpFecMod = catpFecMod;
	}

	@Column(name = "VTOP_COD_CONT", precision = 23, scale = 0)
	public BigDecimal getVtopCodCont() {
		return this.vtopCodCont;
	}

	public void setVtopCodCont(BigDecimal vtopCodCont) {
		this.vtopCodCont = vtopCodCont;
	}

	@Column(name = "PGRE_SEC", precision = 23, scale = 0)
	public BigDecimal getPgreSec() {
		return this.pgreSec;
	}

	public void setPgreSec(BigDecimal pgreSec) {
		this.pgreSec = pgreSec;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CATP_VENC_CUOT", length = 7)
	public Date getCatpVencCuot() {
		return this.catpVencCuot;
	}

	public void setCatpVencCuot(Date catpVencCuot) {
		this.catpVencCuot = catpVencCuot;
	}

	@Column(name = "CATP_SUB_CALIFIC_CART", length = 10)
	public String getCatpSubCalificCart() {
		return this.catpSubCalificCart;
	}

	public void setCatpSubCalificCart(String catpSubCalificCart) {
		this.catpSubCalificCart = catpSubCalificCart;
	}

	@Column(name = "CATP_ETAPA_COD", length = 10)
	public String getCatpEtapaCod() {
		return this.catpEtapaCod;
	}

	public void setCatpEtapaCod(String catpEtapaCod) {
		this.catpEtapaCod = catpEtapaCod;
	}

	@Column(name = "CATP_MORA_COD", length = 10)
	public String getCatpMoraCod() {
		return this.catpMoraCod;
	}

	public void setCatpMoraCod(String catpMoraCod) {
		this.catpMoraCod = catpMoraCod;
	}

	@Column(name = "CATP_IND_CASTIGO_POR_CR", length = 2)
	public String getCatpIndCastigoPorCr() {
		return this.catpIndCastigoPorCr;
	}

	public void setCatpIndCastigoPorCr(String catpIndCastigoPorCr) {
		this.catpIndCastigoPorCr = catpIndCastigoPorCr;
	}

	@Column(name = "CATP_FAG_PORC_PAG", precision = 10)
	public BigDecimal getCatpFagPorcPag() {
		return this.catpFagPorcPag;
	}

	public void setCatpFagPorcPag(BigDecimal catpFagPorcPag) {
		this.catpFagPorcPag = catpFagPorcPag;
	}

	@Column(name = "CATP_FAG_PORC_PAG5", precision = 10)
	public BigDecimal getCatpFagPorcPag5() {
		return this.catpFagPorcPag5;
	}

	public void setCatpFagPorcPag5(BigDecimal catpFagPorcPag5) {
		this.catpFagPorcPag5 = catpFagPorcPag5;
	}

	@Column(name = "CATP_IND_PAC", length = 1)
	public String getCatpIndPac() {
		return this.catpIndPac;
	}

	public void setCatpIndPac(String catpIndPac) {
		this.catpIndPac = catpIndPac;
	}

	@Column(name = "CATP_BCO_PAC", length = 3)
	public String getCatpBcoPac() {
		return this.catpBcoPac;
	}

	public void setCatpBcoPac(String catpBcoPac) {
		this.catpBcoPac = catpBcoPac;
	}

	@Column(name = "CATP_RECU_RENEG_MNTO", precision = 23)
	public BigDecimal getCatpRecuRenegMnto() {
		return this.catpRecuRenegMnto;
	}

	public void setCatpRecuRenegMnto(BigDecimal catpRecuRenegMnto) {
		this.catpRecuRenegMnto = catpRecuRenegMnto;
	}

	@Column(name = "CATP_RECU_RENEG_CUO", precision = 10, scale = 0)
	public Long getCatpRecuRenegCuo() {
		return this.catpRecuRenegCuo;
	}

	public void setCatpRecuRenegCuo(Long catpRecuRenegCuo) {
		this.catpRecuRenegCuo = catpRecuRenegCuo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CATP_FECH_VENC_MAX_CUOT", length = 7)
	public Date getCatpFechVencMaxCuot() {
		return this.catpFechVencMaxCuot;
	}

	public void setCatpFechVencMaxCuot(Date catpFechVencMaxCuot) {
		this.catpFechVencMaxCuot = catpFechVencMaxCuot;
	}

	@Column(name = "CATP_MONE_COD", length = 10)
	public String getCatpMoneCod() {
		return this.catpMoneCod;
	}

	public void setCatpMoneCod(String catpMoneCod) {
		this.catpMoneCod = catpMoneCod;
	}

	@Column(name = "TIPO_DOCTO", length = 20)
	public String getTipoDocto() {
		return this.tipoDocto;
	}

	public void setTipoDocto(String tipoDocto) {
		this.tipoDocto = tipoDocto;
	}

	@Column(name = "NUM_DOCTO", precision = 23, scale = 0)
	public BigDecimal getNumDocto() {
		return this.numDocto;
	}

	public void setNumDocto(BigDecimal numDocto) {
		this.numDocto = numDocto;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cobCatalogoPgre")
	public Set<CbzCobCatalogoPgreDetalleModel> getCbzCobCatalogoPgreDetalles() {
		return this.cbzCobCatalogoPgreDetalles;
	}

	public void setCbzCobCatalogoPgreDetalles(Set<CbzCobCatalogoPgreDetalleModel> cbzCobCatalogoPgreDetalles) {
		this.cbzCobCatalogoPgreDetalles = cbzCobCatalogoPgreDetalles;
	}

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cobCatalogoPgre")
//	public Set<CbzUserCatalogoPgreModel> getCbzUserCatalogoPgres() {
//		return this.cbzUserCatalogoPgres;
//	}
//
//	public void setCbzUserCatalogoPgres(Set<CbzUserCatalogoPgreModel> cbzUserCatalogoPgres) {
//		this.cbzUserCatalogoPgres = cbzUserCatalogoPgres;
//	}

	


}
