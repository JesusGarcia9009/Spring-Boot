package com.pdr.common.cobranza.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * BS2
 */
@Entity
@Table(name = "CBZ_SIMULACION", schema = "CBZPAR")
public class CbzSimulacionModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal idSimulacion;
	private VtaContratosModel vtaContratos;
	private VtaOperModel vtaOper;
	private CbzEstadoSimulacionModel cbzEstadoSimulacion;
	private CbzTipoSimulacionContratoModel cbzTipoSimulacionContrato;
	private Date simulacionFechaCreacion;
	private Date simulacionFechaModificacion;
	private Integer simulacionNumeroCuota;
	private BigDecimal simulacionMontoCuota;
	private BigDecimal simulacionTasaInteres;
	private BigDecimal simulacionSaldoRenegociacion;
	private Date simulacionFechaVencimiento;
	private String username;
	private String simulacionCodMoneda;
	private BigDecimal simulacionTotalAdeudado;
	private Date simulacionFechaCorte;
	private Boolean flagEliminado;
	private BigDecimal simulacionAbonoUf;
	private BigDecimal simulacionAbonoPeso;
	private BigDecimal simulacionInteresCredito;
	private Date simulacionFechaExpiracion;
	private Set<CbzSimulacionDocumentosModel> cbzSimulacionDocumentoses = new HashSet<>(0);
	private Set<CbzSimulacionPagaresModel> cbzSimulacionPagareses = new HashSet<>(0);

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence_simulacion")
	@SequenceGenerator(name = "id_sequence_simulacion", allocationSize = 1, sequenceName = "seq_simulacion", schema = "CBZPAR")
	@Column(name = "ID_SIMULACION", unique = true, nullable = false, precision = 8, scale = 0)
	public BigDecimal getIdSimulacion() {
		return this.idSimulacion;
	}

	public void setIdSimulacion(BigDecimal idSimulacion) {
		this.idSimulacion = idSimulacion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VTOP_COD_CONT", nullable = false)
	public VtaContratosModel getVtaContratos() {
		return this.vtaContratos;
	}

	public void setVtaContratos(VtaContratosModel vtaContratos) {
		this.vtaContratos = vtaContratos;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VTOP_COD", nullable = false)
	public VtaOperModel getVtaOper() {
		return this.vtaOper;
	}

	public void setVtaOper(VtaOperModel vtaOper) {
		this.vtaOper = vtaOper;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ESTADO_SIMULACION", nullable = false)
	public CbzEstadoSimulacionModel getCbzEstadoSimulacion() {
		return this.cbzEstadoSimulacion;
	}

	public void setCbzEstadoSimulacion(CbzEstadoSimulacionModel cbzEstadoSimulacion) {
		this.cbzEstadoSimulacion = cbzEstadoSimulacion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TIPO_CONTRATO", nullable = false)
	public CbzTipoSimulacionContratoModel getCbzTipoSimulacionContrato() {
		return this.cbzTipoSimulacionContrato;
	}

	public void setCbzTipoSimulacionContrato(CbzTipoSimulacionContratoModel cbzTipoSimulacionContrato) {
		this.cbzTipoSimulacionContrato = cbzTipoSimulacionContrato;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "SIMULACION_FECHA_CREACION", length = 7)
	public Date getSimulacionFechaCreacion() {
		return this.simulacionFechaCreacion;
	}

	public void setSimulacionFechaCreacion(Date simulacionFechaCreacion) {
		this.simulacionFechaCreacion = simulacionFechaCreacion;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "SIMULACION_FECHA_MODIFICACION", length = 7)
	public Date getSimulacionFechaModificacion() {
		return this.simulacionFechaModificacion;
	}

	public void setSimulacionFechaModificacion(Date simulacionFechaModificacion) {
		this.simulacionFechaModificacion = simulacionFechaModificacion;
	}

	@Column(name = "SIMULACION_NUMERO_CUOTA", precision = 8, scale = 0)
	public Integer getSimulacionNumeroCuota() {
		return this.simulacionNumeroCuota;
	}

	public void setSimulacionNumeroCuota(Integer simulacionNumeroCuota) {
		this.simulacionNumeroCuota = simulacionNumeroCuota;
	}

	@Column(name = "SIMULACION_MONTO_CUOTA", precision = 23)
	public BigDecimal getSimulacionMontoCuota() {
		return this.simulacionMontoCuota;
	}

	public void setSimulacionMontoCuota(BigDecimal simulacionMontoCuota) {
		this.simulacionMontoCuota = simulacionMontoCuota;
	}

	@Column(name = "SIMULACION_TASA_INTERES", precision = 8)
	public BigDecimal getSimulacionTasaInteres() {
		return this.simulacionTasaInteres;
	}

	public void setSimulacionTasaInteres(BigDecimal simulacionTasaInteres) {
		this.simulacionTasaInteres = simulacionTasaInteres;
	}

	@Column(name = "SIMULACION_SALDO_RENEGOCIACION", precision = 23)
	public BigDecimal getSimulacionSaldoRenegociacion() {
		return this.simulacionSaldoRenegociacion;
	}

	public void setSimulacionSaldoRenegociacion(BigDecimal simulacionSaldoRenegociacion) {
		this.simulacionSaldoRenegociacion = simulacionSaldoRenegociacion;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "SIMULACION_FECHA_VENCIMIENTO", length = 7)
	public Date getSimulacionFechaVencimiento() {
		return this.simulacionFechaVencimiento;
	}

	public void setSimulacionFechaVencimiento(Date simulacionFechaVencimiento) {
		this.simulacionFechaVencimiento = simulacionFechaVencimiento;
	}

	@Column(name = "USERNAME", nullable = false, length = 100)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "SIMULACION_COD_MONEDA", length = 10)
	public String getSimulacionCodMoneda() {
		return this.simulacionCodMoneda;
	}

	public void setSimulacionCodMoneda(String simulacionCodMoneda) {
		this.simulacionCodMoneda = simulacionCodMoneda;
	}

	@Column(name = "SIMULACION_TOTAL_ADEUDADO", precision = 23)
	public BigDecimal getSimulacionTotalAdeudado() {
		return this.simulacionTotalAdeudado;
	}

	public void setSimulacionTotalAdeudado(BigDecimal simulacionTotalAdeudado) {
		this.simulacionTotalAdeudado = simulacionTotalAdeudado;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "SIMULACION_FECHA_CORTE", length = 7)
	public Date getSimulacionFechaCorte() {
		return this.simulacionFechaCorte;
	}

	public void setSimulacionFechaCorte(Date simulacionFechaCorte) {
		this.simulacionFechaCorte = simulacionFechaCorte;
	}

	@Column(name = "FLAG_ELIMINADO", precision = 1, scale = 0)
	public Boolean getFlagEliminado() {
		return this.flagEliminado;
	}

	public void setFlagEliminado(Boolean flagEliminado) {
		this.flagEliminado = flagEliminado;
	}

	@Column(name = "SIMULACION_ABONO_UF", precision = 23)
	public BigDecimal getSimulacionAbonoUf() {
		return this.simulacionAbonoUf;
	}

	public void setSimulacionAbonoUf(BigDecimal simulacionAbonoUf) {
		this.simulacionAbonoUf = simulacionAbonoUf;
	}

	@Column(name = "SIMULACION_ABONO_PESO", precision = 23)
	public BigDecimal getSimulacionAbonoPeso() {
		return this.simulacionAbonoPeso;
	}

	public void setSimulacionAbonoPeso(BigDecimal simulacionAbonoPeso) {
		this.simulacionAbonoPeso = simulacionAbonoPeso;
	}

	@Column(name = "SIMULACION_INTERES_CREDITO", precision = 23)
	public BigDecimal getSimulacionInteresCredito() {
		return this.simulacionInteresCredito;
	}

	public void setSimulacionInteresCredito(BigDecimal simulacionInteresCredito) {
		this.simulacionInteresCredito = simulacionInteresCredito;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "SIMULACION_FECHA_EXPIRACION", length = 7)
	public Date getSimulacionFechaExpiracion() {
		return this.simulacionFechaExpiracion;
	}

	public void setSimulacionFechaExpiracion(Date simulacionFechaExpiracion) {
		this.simulacionFechaExpiracion = simulacionFechaExpiracion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cbzSimulacion")
	public Set<CbzSimulacionDocumentosModel> getCbzSimulacionDocumentoses() {
		return this.cbzSimulacionDocumentoses;
	}

	public void setCbzSimulacionDocumentoses(Set<CbzSimulacionDocumentosModel> cbzSimulacionDocumentoses) {
		this.cbzSimulacionDocumentoses = cbzSimulacionDocumentoses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cbzSimulacion")
	public Set<CbzSimulacionPagaresModel> getCbzSimulacionPagareses() {
		return this.cbzSimulacionPagareses;
	}

	public void setCbzSimulacionPagareses(Set<CbzSimulacionPagaresModel> cbzSimulacionPagareses) {
		this.cbzSimulacionPagareses = cbzSimulacionPagareses;
	}

}
