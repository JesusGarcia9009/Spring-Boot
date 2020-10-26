package com.pdr.common.cobranza.entity;

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
@Table(name = "VTA_OPER_UBIC", schema = "VTAPAR")
public class VtaOperUbicModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VtaOperUbicIdModel id;
	private VtaOperModel vtaOper;
	private VtaUbicacionModel vtaUbicacion;
	private String opubEstaCod;
	private String opubUserMod;
	private Date opubFecMod;

	public VtaOperUbicModel() {
	}

	public VtaOperUbicModel(VtaOperUbicIdModel id, VtaOperModel vtaOper, VtaUbicacionModel vtaUbicacion, String opubEstaCod,
			String opubUserMod, Date opubFecMod) {
		this.id = id;
		this.vtaOper = vtaOper;
		this.vtaUbicacion = vtaUbicacion;
		this.opubEstaCod = opubEstaCod;
		this.opubUserMod = opubUserMod;
		this.opubFecMod = opubFecMod;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "vtopCod", column = @Column(name = "VTOP_COD", nullable = false, precision = 23, scale = 0)),
			@AttributeOverride(name = "ubicSec", column = @Column(name = "UBIC_SEC", nullable = false, precision = 23, scale = 0)) })
	public VtaOperUbicIdModel getId() {
		return this.id;
	}

	public void setId(VtaOperUbicIdModel id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VTOP_COD", nullable = false, insertable = false, updatable = false)
	public VtaOperModel getVtaOper() {
		return this.vtaOper;
	}

	public void setVtaOper(VtaOperModel vtaOper) {
		this.vtaOper = vtaOper;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UBIC_SEC", nullable = false, insertable = false, updatable = false)
	public VtaUbicacionModel getVtaUbicacion() {
		return this.vtaUbicacion;
	}

	public void setVtaUbicacion(VtaUbicacionModel vtaUbicacion) {
		this.vtaUbicacion = vtaUbicacion;
	}

	@Column(name = "OPUB_ESTA_COD", nullable = false, length = 20)
	public String getOpubEstaCod() {
		return this.opubEstaCod;
	}

	public void setOpubEstaCod(String opubEstaCod) {
		this.opubEstaCod = opubEstaCod;
	}

	@Column(name = "OPUB_USER_MOD", nullable = false, length = 30)
	public String getOpubUserMod() {
		return this.opubUserMod;
	}

	public void setOpubUserMod(String opubUserMod) {
		this.opubUserMod = opubUserMod;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "OPUB_FEC_MOD", nullable = false, length = 7)
	public Date getOpubFecMod() {
		return this.opubFecMod;
	}

	public void setOpubFecMod(Date opubFecMod) {
		this.opubFecMod = opubFecMod;
	}

}
