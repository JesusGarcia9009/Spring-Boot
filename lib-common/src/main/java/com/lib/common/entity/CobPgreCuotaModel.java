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
 * @author BS2
 */
@Entity
@Table(name = "COB_PGRE_CUOTA", schema = "COBPAR")
public class CobPgreCuotaModel implements java.io.Serializable {

	private static final long serialVersionUID = 7586500025348608150L;
	private CobPgreCuotaModelId id;
	private CobPagareModel cobPagare;
	private BigDecimal cuotMnto;
	private BigDecimal cuotMntoCubi;
	private BigDecimal cuotMntoAmorK;
	private BigDecimal cuotMntoAmorIk;
	private Date cuotFechVcto;
	private String cuotEstaCod;
	private String emprCod;
	private String ccarCod;
	private String cuotUserMod;
	private Date cuotFecMod;
	private BigDecimal trspSec;
	private BigDecimal avenSec;
	private BigDecimal prpcSec;
	private Long cuotMntoAmorKPeso;
	private Long cuotMntoAmorIkPeso;
	private BigDecimal cuotMntoAmorKCub;
	private BigDecimal cuotMntoAmorIkCub;
	private Date cuotFechPago;

	public CobPgreCuotaModel() {
	}

	public CobPgreCuotaModel(CobPgreCuotaModelId id, CobPagareModel cobPagare, BigDecimal cuotMnto, BigDecimal cuotMntoCubi,
			BigDecimal cuotMntoAmorK, BigDecimal cuotMntoAmorIk, Date cuotFechVcto, String cuotEstaCod, String emprCod,
			String ccarCod, String cuotUserMod, Date cuotFecMod, BigDecimal cuotMntoAmorKCub,
			BigDecimal cuotMntoAmorIkCub) {
		this.id = id;
		this.cobPagare = cobPagare;
		this.cuotMnto = cuotMnto;
		this.cuotMntoCubi = cuotMntoCubi;
		this.cuotMntoAmorK = cuotMntoAmorK;
		this.cuotMntoAmorIk = cuotMntoAmorIk;
		this.cuotFechVcto = cuotFechVcto;
		this.cuotEstaCod = cuotEstaCod;
		this.emprCod = emprCod;
		this.ccarCod = ccarCod;
		this.cuotUserMod = cuotUserMod;
		this.cuotFecMod = cuotFecMod;
		this.cuotMntoAmorKCub = cuotMntoAmorKCub;
		this.cuotMntoAmorIkCub = cuotMntoAmorIkCub;
	}

	public CobPgreCuotaModel(CobPgreCuotaModelId id, CobPagareModel cobPagare, BigDecimal cuotMnto, BigDecimal cuotMntoCubi,
			BigDecimal cuotMntoAmorK, BigDecimal cuotMntoAmorIk, Date cuotFechVcto, String cuotEstaCod, String emprCod,
			String ccarCod, String cuotUserMod, Date cuotFecMod, BigDecimal trspSec, BigDecimal avenSec,
			BigDecimal prpcSec, Long cuotMntoAmorKPeso, Long cuotMntoAmorIkPeso, BigDecimal cuotMntoAmorKCub,
			BigDecimal cuotMntoAmorIkCub, Date cuotFechPago) {
		this.id = id;
		this.cobPagare = cobPagare;
		this.cuotMnto = cuotMnto;
		this.cuotMntoCubi = cuotMntoCubi;
		this.cuotMntoAmorK = cuotMntoAmorK;
		this.cuotMntoAmorIk = cuotMntoAmorIk;
		this.cuotFechVcto = cuotFechVcto;
		this.cuotEstaCod = cuotEstaCod;
		this.emprCod = emprCod;
		this.ccarCod = ccarCod;
		this.cuotUserMod = cuotUserMod;
		this.cuotFecMod = cuotFecMod;
		this.trspSec = trspSec;
		this.avenSec = avenSec;
		this.prpcSec = prpcSec;
		this.cuotMntoAmorKPeso = cuotMntoAmorKPeso;
		this.cuotMntoAmorIkPeso = cuotMntoAmorIkPeso;
		this.cuotMntoAmorKCub = cuotMntoAmorKCub;
		this.cuotMntoAmorIkCub = cuotMntoAmorIkCub;
		this.cuotFechPago = cuotFechPago;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "pgreSec", column = @Column(name = "PGRE_SEC", nullable = false, precision = 23, scale = 0)),
			@AttributeOverride(name = "cuotNum", column = @Column(name = "CUOT_NUM", nullable = false, precision = 4, scale = 0)) })
	public CobPgreCuotaModelId getId() {
		return this.id;
	}

	public void setId(CobPgreCuotaModelId id) {
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

	@Column(name = "CUOT_MNTO", nullable = false, precision = 14)
	public BigDecimal getCuotMnto() {
		return this.cuotMnto;
	}

	public void setCuotMnto(BigDecimal cuotMnto) {
		this.cuotMnto = cuotMnto;
	}

	@Column(name = "CUOT_MNTO_CUBI", nullable = false, precision = 14)
	public BigDecimal getCuotMntoCubi() {
		return this.cuotMntoCubi;
	}

	public void setCuotMntoCubi(BigDecimal cuotMntoCubi) {
		this.cuotMntoCubi = cuotMntoCubi;
	}

	@Column(name = "CUOT_MNTO_AMOR_K", nullable = false, precision = 14)
	public BigDecimal getCuotMntoAmorK() {
		return this.cuotMntoAmorK;
	}

	public void setCuotMntoAmorK(BigDecimal cuotMntoAmorK) {
		this.cuotMntoAmorK = cuotMntoAmorK;
	}

	@Column(name = "CUOT_MNTO_AMOR_IK", nullable = false, precision = 14)
	public BigDecimal getCuotMntoAmorIk() {
		return this.cuotMntoAmorIk;
	}

	public void setCuotMntoAmorIk(BigDecimal cuotMntoAmorIk) {
		this.cuotMntoAmorIk = cuotMntoAmorIk;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CUOT_FECH_VCTO", nullable = false, length = 7)
	public Date getCuotFechVcto() {
		return this.cuotFechVcto;
	}

	public void setCuotFechVcto(Date cuotFechVcto) {
		this.cuotFechVcto = cuotFechVcto;
	}

	@Column(name = "CUOT_ESTA_COD", nullable = false, length = 20)
	public String getCuotEstaCod() {
		return this.cuotEstaCod;
	}

	public void setCuotEstaCod(String cuotEstaCod) {
		this.cuotEstaCod = cuotEstaCod;
	}

	@Column(name = "EMPR_COD", nullable = false, length = 10)
	public String getEmprCod() {
		return this.emprCod;
	}

	public void setEmprCod(String emprCod) {
		this.emprCod = emprCod;
	}

	@Column(name = "CCAR_COD", nullable = false, length = 10)
	public String getCcarCod() {
		return this.ccarCod;
	}

	public void setCcarCod(String ccarCod) {
		this.ccarCod = ccarCod;
	}

	@Column(name = "CUOT_USER_MOD", nullable = false, length = 20)
	public String getCuotUserMod() {
		return this.cuotUserMod;
	}

	public void setCuotUserMod(String cuotUserMod) {
		this.cuotUserMod = cuotUserMod;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CUOT_FEC_MOD", nullable = false, length = 7)
	public Date getCuotFecMod() {
		return this.cuotFecMod;
	}

	public void setCuotFecMod(Date cuotFecMod) {
		this.cuotFecMod = cuotFecMod;
	}

	@Column(name = "TRSP_SEC", precision = 23, scale = 0)
	public BigDecimal getTrspSec() {
		return this.trspSec;
	}

	public void setTrspSec(BigDecimal trspSec) {
		this.trspSec = trspSec;
	}

	@Column(name = "AVEN_SEC", precision = 23, scale = 0)
	public BigDecimal getAvenSec() {
		return this.avenSec;
	}

	public void setAvenSec(BigDecimal avenSec) {
		this.avenSec = avenSec;
	}

	@Column(name = "PRPC_SEC", precision = 23, scale = 0)
	public BigDecimal getPrpcSec() {
		return this.prpcSec;
	}

	public void setPrpcSec(BigDecimal prpcSec) {
		this.prpcSec = prpcSec;
	}

	@Column(name = "CUOT_MNTO_AMOR_K_PESO", precision = 14, scale = 0)
	public Long getCuotMntoAmorKPeso() {
		return this.cuotMntoAmorKPeso;
	}

	public void setCuotMntoAmorKPeso(Long cuotMntoAmorKPeso) {
		this.cuotMntoAmorKPeso = cuotMntoAmorKPeso;
	}

	@Column(name = "CUOT_MNTO_AMOR_IK_PESO", precision = 14, scale = 0)
	public Long getCuotMntoAmorIkPeso() {
		return this.cuotMntoAmorIkPeso;
	}

	public void setCuotMntoAmorIkPeso(Long cuotMntoAmorIkPeso) {
		this.cuotMntoAmorIkPeso = cuotMntoAmorIkPeso;
	}

	@Column(name = "CUOT_MNTO_AMOR_K_CUB", nullable = false, precision = 14)
	public BigDecimal getCuotMntoAmorKCub() {
		return this.cuotMntoAmorKCub;
	}

	public void setCuotMntoAmorKCub(BigDecimal cuotMntoAmorKCub) {
		this.cuotMntoAmorKCub = cuotMntoAmorKCub;
	}

	@Column(name = "CUOT_MNTO_AMOR_IK_CUB", nullable = false, precision = 14)
	public BigDecimal getCuotMntoAmorIkCub() {
		return this.cuotMntoAmorIkCub;
	}

	public void setCuotMntoAmorIkCub(BigDecimal cuotMntoAmorIkCub) {
		this.cuotMntoAmorIkCub = cuotMntoAmorIkCub;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CUOT_FECH_PAGO", length = 7)
	public Date getCuotFechPago() {
		return this.cuotFechPago;
	}

	public void setCuotFechPago(Date cuotFechPago) {
		this.cuotFechPago = cuotFechPago;
	}

}
