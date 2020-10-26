package com.lib.common.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * BS2
 */
@Entity
@Table(name = "CBZ_COB_CATALOGO_PGRE_DETALLE", schema = "CBZPAR")
public class CbzCobCatalogoPgreDetalleModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal idCatPgreDetalle;
	private BigDecimal idUsuarioAsignado;
	private Long cdetCuotaOriginalCont;
	private Long cdetCuotaTotConReneg;
	private BigDecimal cdetSec;
	private Date cdetFechaContrato;
	private BigDecimal cdetSaldoPmt;
	private Date cdetFechaUltPgo;
	private Date cdetFechaPriVencMora;
	private Long cdetNumreneg;
	private Date cdetFechaUltreneg;
	private Boolean cdetSepultado;
	private String cdetCampanaVig;
	private BigDecimal cdetAbonoreneg;
	private BigDecimal cdetAbonorenegPac;
	private BigDecimal cdetValCutaprom;
	private BigDecimal cdetCuotasVenc;
	private BigDecimal cdetPmtVencidas;
	private BigDecimal cdetCuotPend;
	private BigDecimal cdetCuotoriginalcont;
	private BigDecimal cdetCuototIncluReneg;
	private Boolean cdetComprFallecido;
	private String nombreUsuario;
	private Date cdetFechaComprFallecido;
	private String cdetPeriodo;
	private String cdetNombreResponsable;
	private String cdetValorVencido;
	private String cdetUbicacion;
	private String cdetContEstaCod;
	private String cdetSerieCod;
	private BigDecimal cdetDoctoFolio;
	private String cdetProdCod;
	private BigDecimal cdetPmtVencUf;
	private BigDecimal cdetPmtSaldoUf;
	private BigDecimal cdetValorCuotaUf;
	private Long cdetCantSepultados;
	private String cdetIndContMandato;
	private Integer cdetFechaUltPgoDias;
	private Integer cdetFechaUltPgoMeses;
	private Integer cdetFechaUltPgoTrimestres;
	private Integer cdetTotalFono;
	private Integer cdetRenegCuotasPag;
	private String cdetCodMoneda;
	private Long idCcpCampParam;
	private BigDecimal cdetCampFactor;
	private BigDecimal cdetCampAbonoMinUf;
	private BigDecimal cdetCampAbonoMinPesos;
	private String cdetCampNombre;
	private Long idCapAbminim;
	private BigDecimal cdetAminPacpat;
	private BigDecimal cdetAminCrut;
	private BigDecimal cdetAminPacpatPesos;
	private BigDecimal cdetAminCrutPesos;
	private BigDecimal cdetAminPac;
	private BigDecimal cdetAminPacCtaRut;
	private Long idCcpCategoria;
	private String cdetCatNombCategoria;
	private Integer idCspSegmentacion;
	private String cdetSegNombClasificacion;
	private Long cdetCuoPagRen;
	private BigDecimal cdetValCuotpromUf;
	private String faseCod;
	private CobCatalogoPgreModel cobCatalogoPgre;

	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE_COB_CATALOGO_PGRE_DETALLE")
	@SequenceGenerator(name = "ID_SEQUENCE_COB_CATALOGO_PGRE_DETALLE", allocationSize = 1, sequenceName = "SEQ_COB_CATALOGO_PGRE_DETALLE", schema = "CBZPAR")
	@Column(name = "ID_CAT_PGRE_DETALLE", nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdCatPgreDetalle() {
		return this.idCatPgreDetalle;
	}

	public void setIdCatPgreDetalle(BigDecimal idCatPgreDetalle) {
		this.idCatPgreDetalle = idCatPgreDetalle;
	}

	@Column(name = "ID_USUARIO_ASIGNADO", precision = 22, scale = 0)
	public BigDecimal getIdUsuarioAsignado() {
		return this.idUsuarioAsignado;
	}

	public void setIdUsuarioAsignado(BigDecimal idUsuarioAsignado) {
		this.idUsuarioAsignado = idUsuarioAsignado;
	}

	@Column(name = "CDET_CUOTA_ORIGINAL_CONT", precision = 16, scale = 0)
	public Long getCdetCuotaOriginalCont() {
		return this.cdetCuotaOriginalCont;
	}

	public void setCdetCuotaOriginalCont(Long cdetCuotaOriginalCont) {
		this.cdetCuotaOriginalCont = cdetCuotaOriginalCont;
	}

	@Column(name = "CDET_CUOTA_TOT_CON_RENEG", precision = 16, scale = 0)
	public Long getCdetCuotaTotConReneg() {
		return this.cdetCuotaTotConReneg;
	}

	public void setCdetCuotaTotConReneg(Long cdetCuotaTotConReneg) {
		this.cdetCuotaTotConReneg = cdetCuotaTotConReneg;
	}

	@Column(name = "CDET_SEC", nullable = false, precision = 23, scale = 0)
	public BigDecimal getCdetSec() {
		return this.cdetSec;
	}

	public void setCdetSec(BigDecimal cdetSec) {
		this.cdetSec = cdetSec;
	}

	@Column(name = "CDET_FECHA_CONTRATO", length = 7)
	public Date getCdetFechaContrato() {
		return this.cdetFechaContrato;
	}

	public void setCdetFechaContrato(Date cdetFechaContrato) {
		this.cdetFechaContrato = cdetFechaContrato;
	}

	@Column(name = "CDET_SALDO_PMT", precision = 22)
	public BigDecimal getCdetSaldoPmt() {
		return this.cdetSaldoPmt;
	}

	public void setCdetSaldoPmt(BigDecimal cdetSaldoPmt) {
		this.cdetSaldoPmt = cdetSaldoPmt;
	}

	@Column(name = "CDET_FECHA_ULT_PGO", length = 7)
	public Date getCdetFechaUltPgo() {
		return this.cdetFechaUltPgo;
	}

	public void setCdetFechaUltPgo(Date cdetFechaUltPgo) {
		this.cdetFechaUltPgo = cdetFechaUltPgo;
	}

	@Column(name = "CDET_FECHA_PRI_VENC_MORA", length = 7)
	public Date getCdetFechaPriVencMora() {
		return this.cdetFechaPriVencMora;
	}

	public void setCdetFechaPriVencMora(Date cdetFechaPriVencMora) {
		this.cdetFechaPriVencMora = cdetFechaPriVencMora;
	}

	@Column(name = "CDET_NUMRENEG", precision = 16, scale = 0)
	public Long getCdetNumreneg() {
		return this.cdetNumreneg;
	}

	public void setCdetNumreneg(Long cdetNumreneg) {
		this.cdetNumreneg = cdetNumreneg;
	}

	@Column(name = "CDET_FECHA_ULTRENEG", length = 7)
	public Date getCdetFechaUltreneg() {
		return this.cdetFechaUltreneg;
	}

	public void setCdetFechaUltreneg(Date cdetFechaUltreneg) {
		this.cdetFechaUltreneg = cdetFechaUltreneg;
	}

	@Column(name = "CDET_SEPULTADO", precision = 1, scale = 0)
	public Boolean getCdetSepultado() {
		return this.cdetSepultado;
	}

	public void setCdetSepultado(Boolean cdetSepultado) {
		this.cdetSepultado = cdetSepultado;
	}

	@Column(name = "CDET_CAMPANA_VIG", length = 200)
	public String getCdetCampanaVig() {
		return this.cdetCampanaVig;
	}

	public void setCdetCampanaVig(String cdetCampanaVig) {
		this.cdetCampanaVig = cdetCampanaVig;
	}

	@Column(name = "CDET_ABONORENEG", precision = 22)
	public BigDecimal getCdetAbonoreneg() {
		return this.cdetAbonoreneg;
	}

	public void setCdetAbonoreneg(BigDecimal cdetAbonoreneg) {
		this.cdetAbonoreneg = cdetAbonoreneg;
	}

	@Column(name = "CDET_ABONORENEG_PAC", precision = 22)
	public BigDecimal getCdetAbonorenegPac() {
		return this.cdetAbonorenegPac;
	}

	public void setCdetAbonorenegPac(BigDecimal cdetAbonorenegPac) {
		this.cdetAbonorenegPac = cdetAbonorenegPac;
	}

	@Column(name = "CDET_VAL_CUTAPROM", precision = 22)
	public BigDecimal getCdetValCutaprom() {
		return this.cdetValCutaprom;
	}

	public void setCdetValCutaprom(BigDecimal cdetValCutaprom) {
		this.cdetValCutaprom = cdetValCutaprom;
	}

	@Column(name = "CDET_CUOTAS_VENC", precision = 22)
	public BigDecimal getCdetCuotasVenc() {
		return this.cdetCuotasVenc;
	}

	public void setCdetCuotasVenc(BigDecimal cdetCuotasVenc) {
		this.cdetCuotasVenc = cdetCuotasVenc;
	}

	@Column(name = "CDET_PMT_VENCIDAS", precision = 22)
	public BigDecimal getCdetPmtVencidas() {
		return this.cdetPmtVencidas;
	}

	public void setCdetPmtVencidas(BigDecimal cdetPmtVencidas) {
		this.cdetPmtVencidas = cdetPmtVencidas;
	}

	@Column(name = "CDET_CUOT_PEND", precision = 16)
	public BigDecimal getCdetCuotPend() {
		return this.cdetCuotPend;
	}

	public void setCdetCuotPend(BigDecimal cdetCuotPend) {
		this.cdetCuotPend = cdetCuotPend;
	}

	@Column(name = "CDET_CUOTORIGINALCONT", precision = 16)
	public BigDecimal getCdetCuotoriginalcont() {
		return this.cdetCuotoriginalcont;
	}

	public void setCdetCuotoriginalcont(BigDecimal cdetCuotoriginalcont) {
		this.cdetCuotoriginalcont = cdetCuotoriginalcont;
	}

	@Column(name = "CDET_CUOTOT_INCLU_RENEG", precision = 16)
	public BigDecimal getCdetCuototIncluReneg() {
		return this.cdetCuototIncluReneg;
	}

	public void setCdetCuototIncluReneg(BigDecimal cdetCuototIncluReneg) {
		this.cdetCuototIncluReneg = cdetCuototIncluReneg;
	}

	@Column(name = "CDET_COMPR_FALLECIDO", precision = 1, scale = 0)
	public Boolean getCdetComprFallecido() {
		return this.cdetComprFallecido;
	}

	public void setCdetComprFallecido(Boolean cdetComprFallecido) {
		this.cdetComprFallecido = cdetComprFallecido;
	}

	@Column(name = "NOMBRE_USUARIO", length = 250)
	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	@Column(name = "CDET_FECHA_COMPR_FALLECIDO", length = 7)
	public Date getCdetFechaComprFallecido() {
		return this.cdetFechaComprFallecido;
	}

	public void setCdetFechaComprFallecido(Date cdetFechaComprFallecido) {
		this.cdetFechaComprFallecido = cdetFechaComprFallecido;
	}

	@Column(name = "CDET_PERIODO", length = 50)
	public String getCdetPeriodo() {
		return this.cdetPeriodo;
	}

	public void setCdetPeriodo(String cdetPeriodo) {
		this.cdetPeriodo = cdetPeriodo;
	}

	@Column(name = "CDET_NOMBRE_RESPONSABLE", length = 100)
	public String getCdetNombreResponsable() {
		return this.cdetNombreResponsable;
	}

	public void setCdetNombreResponsable(String cdetNombreResponsable) {
		this.cdetNombreResponsable = cdetNombreResponsable;
	}

	@Column(name = "CDET_VALOR_VENCIDO", length = 100)
	public String getCdetValorVencido() {
		return this.cdetValorVencido;
	}

	public void setCdetValorVencido(String cdetValorVencido) {
		this.cdetValorVencido = cdetValorVencido;
	}

	@Column(name = "CDET_UBICACION", length = 100)
	public String getCdetUbicacion() {
		return this.cdetUbicacion;
	}

	public void setCdetUbicacion(String cdetUbicacion) {
		this.cdetUbicacion = cdetUbicacion;
	}

	@Column(name = "CDET_CONT_ESTA_COD", length = 100)
	public String getCdetContEstaCod() {
		return this.cdetContEstaCod;
	}

	public void setCdetContEstaCod(String cdetContEstaCod) {
		this.cdetContEstaCod = cdetContEstaCod;
	}

	@Column(name = "CDET_SERIE_COD", length = 10)
	public String getCdetSerieCod() {
		return this.cdetSerieCod;
	}

	public void setCdetSerieCod(String cdetSerieCod) {
		this.cdetSerieCod = cdetSerieCod;
	}

	@Column(name = "CDET_DOCTO_FOLIO", precision = 23, scale = 0)
	public BigDecimal getCdetDoctoFolio() {
		return this.cdetDoctoFolio;
	}

	public void setCdetDoctoFolio(BigDecimal cdetDoctoFolio) {
		this.cdetDoctoFolio = cdetDoctoFolio;
	}

	@Column(name = "CDET_PROD_COD", length = 20)
	public String getCdetProdCod() {
		return this.cdetProdCod;
	}

	public void setCdetProdCod(String cdetProdCod) {
		this.cdetProdCod = cdetProdCod;
	}

	@Column(name = "CDET_PMT_VENC_UF", precision = 16)
	public BigDecimal getCdetPmtVencUf() {
		return this.cdetPmtVencUf;
	}

	public void setCdetPmtVencUf(BigDecimal cdetPmtVencUf) {
		this.cdetPmtVencUf = cdetPmtVencUf;
	}

	@Column(name = "CDET_PMT_SALDO_UF", precision = 16)
	public BigDecimal getCdetPmtSaldoUf() {
		return this.cdetPmtSaldoUf;
	}

	public void setCdetPmtSaldoUf(BigDecimal cdetPmtSaldoUf) {
		this.cdetPmtSaldoUf = cdetPmtSaldoUf;
	}

	@Column(name = "CDET_VALOR_CUOTA_UF", precision = 16)
	public BigDecimal getCdetValorCuotaUf() {
		return this.cdetValorCuotaUf;
	}

	public void setCdetValorCuotaUf(BigDecimal cdetValorCuotaUf) {
		this.cdetValorCuotaUf = cdetValorCuotaUf;
	}

	@Column(name = "CDET_CANT_SEPULTADOS", precision = 16, scale = 0)
	public Long getCdetCantSepultados() {
		return this.cdetCantSepultados;
	}

	public void setCdetCantSepultados(Long cdetCantSepultados) {
		this.cdetCantSepultados = cdetCantSepultados;
	}

	@Column(name = "CDET_IND_CONT_MANDATO", length = 50)
	public String getCdetIndContMandato() {
		return this.cdetIndContMandato;
	}

	public void setCdetIndContMandato(String cdetIndContMandato) {
		this.cdetIndContMandato = cdetIndContMandato;
	}

	@Column(name = "CDET_FECHA_ULT_PGO_DIAS", precision = 8, scale = 0)
	public Integer getCdetFechaUltPgoDias() {
		return this.cdetFechaUltPgoDias;
	}

	public void setCdetFechaUltPgoDias(Integer cdetFechaUltPgoDias) {
		this.cdetFechaUltPgoDias = cdetFechaUltPgoDias;
	}

	@Column(name = "CDET_FECHA_ULT_PGO_MESES", precision = 8, scale = 0)
	public Integer getCdetFechaUltPgoMeses() {
		return this.cdetFechaUltPgoMeses;
	}

	public void setCdetFechaUltPgoMeses(Integer cdetFechaUltPgoMeses) {
		this.cdetFechaUltPgoMeses = cdetFechaUltPgoMeses;
	}

	@Column(name = "CDET_FECHA_ULT_PGO_TRIMESTRES", precision = 8, scale = 0)
	public Integer getCdetFechaUltPgoTrimestres() {
		return this.cdetFechaUltPgoTrimestres;
	}

	public void setCdetFechaUltPgoTrimestres(Integer cdetFechaUltPgoTrimestres) {
		this.cdetFechaUltPgoTrimestres = cdetFechaUltPgoTrimestres;
	}

	@Column(name = "CDET_TOTAL_FONO", precision = 8, scale = 0)
	public Integer getCdetTotalFono() {
		return this.cdetTotalFono;
	}

	public void setCdetTotalFono(Integer cdetTotalFono) {
		this.cdetTotalFono = cdetTotalFono;
	}

	@Column(name = "CDET_RENEG_CUOTAS_PAG", precision = 8, scale = 0)
	public Integer getCdetRenegCuotasPag() {
		return this.cdetRenegCuotasPag;
	}

	public void setCdetRenegCuotasPag(Integer cdetRenegCuotasPag) {
		this.cdetRenegCuotasPag = cdetRenegCuotasPag;
	}

	@Column(name = "CDET_COD_MONEDA", length = 10)
	public String getCdetCodMoneda() {
		return this.cdetCodMoneda;
	}

	public void setCdetCodMoneda(String cdetCodMoneda) {
		this.cdetCodMoneda = cdetCodMoneda;
	}

	@Column(name = "ID_CCP_CAMP_PARAM", precision = 16, scale = 0)
	public Long getIdCcpCampParam() {
		return this.idCcpCampParam;
	}

	public void setIdCcpCampParam(Long idCcpCampParam) {
		this.idCcpCampParam = idCcpCampParam;
	}

	@Column(name = "CDET_CAMP_FACTOR", precision = 16)
	public BigDecimal getCdetCampFactor() {
		return this.cdetCampFactor;
	}

	public void setCdetCampFactor(BigDecimal cdetCampFactor) {
		this.cdetCampFactor = cdetCampFactor;
	}

	@Column(name = "CDET_CAMP_ABONO_MIN_UF", precision = 16)
	public BigDecimal getCdetCampAbonoMinUf() {
		return this.cdetCampAbonoMinUf;
	}

	public void setCdetCampAbonoMinUf(BigDecimal cdetCampAbonoMinUf) {
		this.cdetCampAbonoMinUf = cdetCampAbonoMinUf;
	}

	@Column(name = "CDET_CAMP_ABONO_MIN_PESOS", precision = 16)
	public BigDecimal getCdetCampAbonoMinPesos() {
		return this.cdetCampAbonoMinPesos;
	}

	public void setCdetCampAbonoMinPesos(BigDecimal cdetCampAbonoMinPesos) {
		this.cdetCampAbonoMinPesos = cdetCampAbonoMinPesos;
	}

	@Column(name = "CDET_CAMP_NOMBRE", length = 200)
	public String getCdetCampNombre() {
		return this.cdetCampNombre;
	}

	public void setCdetCampNombre(String cdetCampNombre) {
		this.cdetCampNombre = cdetCampNombre;
	}

	@Column(name = "ID_CAP_ABMINIM", precision = 16, scale = 0)
	public Long getIdCapAbminim() {
		return this.idCapAbminim;
	}

	public void setIdCapAbminim(Long idCapAbminim) {
		this.idCapAbminim = idCapAbminim;
	}

	@Column(name = "CDET_AMIN_PACPAT", precision = 16)
	public BigDecimal getCdetAminPacpat() {
		return this.cdetAminPacpat;
	}

	public void setCdetAminPacpat(BigDecimal cdetAminPacpat) {
		this.cdetAminPacpat = cdetAminPacpat;
	}

	@Column(name = "CDET_AMIN_CRUT", precision = 16)
	public BigDecimal getCdetAminCrut() {
		return this.cdetAminCrut;
	}

	public void setCdetAminCrut(BigDecimal cdetAminCrut) {
		this.cdetAminCrut = cdetAminCrut;
	}

	@Column(name = "CDET_AMIN_PACPAT_PESOS", precision = 16)
	public BigDecimal getCdetAminPacpatPesos() {
		return this.cdetAminPacpatPesos;
	}

	public void setCdetAminPacpatPesos(BigDecimal cdetAminPacpatPesos) {
		this.cdetAminPacpatPesos = cdetAminPacpatPesos;
	}

	@Column(name = "CDET_AMIN_CRUT_PESOS", precision = 16)
	public BigDecimal getCdetAminCrutPesos() {
		return this.cdetAminCrutPesos;
	}

	public void setCdetAminCrutPesos(BigDecimal cdetAminCrutPesos) {
		this.cdetAminCrutPesos = cdetAminCrutPesos;
	}

	@Column(name = "CDET_AMIN_PAC", precision = 16)
	public BigDecimal getCdetAminPac() {
		return this.cdetAminPac;
	}

	public void setCdetAminPac(BigDecimal cdetAminPac) {
		this.cdetAminPac = cdetAminPac;
	}

	@Column(name = "CDET_AMIN_PAC_CTA_RUT", precision = 16)
	public BigDecimal getCdetAminPacCtaRut() {
		return this.cdetAminPacCtaRut;
	}

	public void setCdetAminPacCtaRut(BigDecimal cdetAminPacCtaRut) {
		this.cdetAminPacCtaRut = cdetAminPacCtaRut;
	}

	@Column(name = "ID_CCP_CATEGORIA", precision = 16, scale = 0)
	public Long getIdCcpCategoria() {
		return this.idCcpCategoria;
	}

	public void setIdCcpCategoria(Long idCcpCategoria) {
		this.idCcpCategoria = idCcpCategoria;
	}

	@Column(name = "CDET_CAT_NOMB_CATEGORIA", length = 200)
	public String getCdetCatNombCategoria() {
		return this.cdetCatNombCategoria;
	}

	public void setCdetCatNombCategoria(String cdetCatNombCategoria) {
		this.cdetCatNombCategoria = cdetCatNombCategoria;
	}

	@Column(name = "ID_CSP_SEGMENTACION", precision = 8, scale = 0)
	public Integer getIdCspSegmentacion() {
		return this.idCspSegmentacion;
	}

	public void setIdCspSegmentacion(Integer idCspSegmentacion) {
		this.idCspSegmentacion = idCspSegmentacion;
	}

	@Column(name = "CDET_SEG_NOMB_CLASIFICACION", length = 200)
	public String getCdetSegNombClasificacion() {
		return this.cdetSegNombClasificacion;
	}

	public void setCdetSegNombClasificacion(String cdetSegNombClasificacion) {
		this.cdetSegNombClasificacion = cdetSegNombClasificacion;
	}

	@Column(name = "CDET_CUO_PAG_REN", precision = 16, scale = 0)
	public Long getCdetCuoPagRen() {
		return this.cdetCuoPagRen;
	}

	public void setCdetCuoPagRen(Long cdetCuoPagRen) {
		this.cdetCuoPagRen = cdetCuoPagRen;
	}

	@Column(name = "CDET_VAL_CUOTPROM_UF", precision = 16)
	public BigDecimal getCdetValCuotpromUf() {
		return this.cdetValCuotpromUf;
	}

	public void setCdetValCuotpromUf(BigDecimal cdetValCuotpromUf) {
		this.cdetValCuotpromUf = cdetValCuotpromUf;
	}

	@Column(name = "FASE_COD", length = 20)
	public String getFaseCod() {
		return this.faseCod;
	}

	public void setFaseCod(String faseCod) {
		this.faseCod = faseCod;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDET_SEC", nullable = false, insertable = false, updatable = false)
	public CobCatalogoPgreModel getCobCatalogoPgre() {
		return this.cobCatalogoPgre;
	}

	public void setCobCatalogoPgre(CobCatalogoPgreModel cobCatalogoPgre) {
		this.cobCatalogoPgre = cobCatalogoPgre;
	}

}
