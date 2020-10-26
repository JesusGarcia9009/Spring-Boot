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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * @author BS2
 */
@Entity
@Table(name = "COB_CONT_MANT_CUOTA", schema = "COBPAR", uniqueConstraints = @UniqueConstraint(columnNames = {
		"VTOP_COD_CONT", "CUOT_NUM" }))
public class CobContMantCuotaModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CobContMantCuotaIdModel id;
	private CobContMantencionModel cobContMantencion;
	private BigDecimal cuotMnto;
	private Date cuotFechVcto;
	private String cuotEstaCod;
	private String cuotUserMod;
	private Date cuotFecMod;
	private Integer ntsgPrdoCod;
	private Date cuotFechPago;
	private BigDecimal cuotMntoCubi;

	public CobContMantCuotaModel() {
	}

	public CobContMantCuotaModel(CobContMantCuotaIdModel id, CobContMantencionModel cobContMantencion, BigDecimal cuotMnto,
			Date cuotFechVcto, String cuotEstaCod, String cuotUserMod, Date cuotFecMod) {
		this.id = id;
		this.cobContMantencion = cobContMantencion;
		this.cuotMnto = cuotMnto;
		this.cuotFechVcto = cuotFechVcto;
		this.cuotEstaCod = cuotEstaCod;
		this.cuotUserMod = cuotUserMod;
		this.cuotFecMod = cuotFecMod;
	}

	public CobContMantCuotaModel(CobContMantCuotaIdModel id, CobContMantencionModel cobContMantencion, BigDecimal cuotMnto,
			Date cuotFechVcto, String cuotEstaCod, String cuotUserMod, Date cuotFecMod, Integer ntsgPrdoCod,
			Date cuotFechPago, BigDecimal cuotMntoCubi) {
		this.id = id;
		this.cobContMantencion = cobContMantencion;
		this.cuotMnto = cuotMnto;
		this.cuotFechVcto = cuotFechVcto;
		this.cuotEstaCod = cuotEstaCod;
		this.cuotUserMod = cuotUserMod;
		this.cuotFecMod = cuotFecMod;
		this.ntsgPrdoCod = ntsgPrdoCod;
		this.cuotFechPago = cuotFechPago;
		this.cuotMntoCubi = cuotMntoCubi;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "vtopCodCont", column = @Column(name = "VTOP_COD_CONT", nullable = false, precision = 23, scale = 0)),
			@AttributeOverride(name = "emprCodAdm", column = @Column(name = "EMPR_COD_ADM", nullable = false, length = 10)),
			@AttributeOverride(name = "unegCod", column = @Column(name = "UNEG_COD", nullable = false, length = 10)),
			@AttributeOverride(name = "vtopCod", column = @Column(name = "VTOP_COD", nullable = false, precision = 23, scale = 0)),
			@AttributeOverride(name = "cuotNum", column = @Column(name = "CUOT_NUM", nullable = false, precision = 4, scale = 0)) })
	public CobContMantCuotaIdModel getId() {
		return this.id;
	}

	public void setId(CobContMantCuotaIdModel id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "VTOP_COD_CONT", referencedColumnName = "VTOP_COD_CONT", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "EMPR_COD_ADM", referencedColumnName = "EMPR_COD_ADM", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "UNEG_COD", referencedColumnName = "UNEG_COD", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "VTOP_COD", referencedColumnName = "VTOP_COD", nullable = false, insertable = false, updatable = false) })
	public CobContMantencionModel getCobContMantencion() {
		return this.cobContMantencion;
	}

	public void setCobContMantencion(CobContMantencionModel cobContMantencion) {
		this.cobContMantencion = cobContMantencion;
	}

	@Column(name = "CUOT_MNTO", nullable = false, precision = 14)
	public BigDecimal getCuotMnto() {
		return this.cuotMnto;
	}

	public void setCuotMnto(BigDecimal cuotMnto) {
		this.cuotMnto = cuotMnto;
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

	@Column(name = "NTSG_PRDO_COD", precision = 6, scale = 0)
	public Integer getNtsgPrdoCod() {
		return this.ntsgPrdoCod;
	}

	public void setNtsgPrdoCod(Integer ntsgPrdoCod) {
		this.ntsgPrdoCod = ntsgPrdoCod;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CUOT_FECH_PAGO", length = 7)
	public Date getCuotFechPago() {
		return this.cuotFechPago;
	}

	public void setCuotFechPago(Date cuotFechPago) {
		this.cuotFechPago = cuotFechPago;
	}

	@Column(name = "CUOT_MNTO_CUBI", precision = 14)
	public BigDecimal getCuotMntoCubi() {
		return this.cuotMntoCubi;
	}

	public void setCuotMntoCubi(BigDecimal cuotMntoCubi) {
		this.cuotMntoCubi = cuotMntoCubi;
	}

}
