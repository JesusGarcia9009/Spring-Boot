package com.pdr.common.cobranza.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author BS2
 */
@Entity
@Table(name = "VTA_PGRE_OPER_CONT", schema = "VTAPAR")
public class VtaPgreOperContModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VtaPgreOperContIdModel id;
	private CobPagareModel cobPagare;
	private VtaContratosModel vtaContratos;
	private VtaOperModel vtaOper;

	public VtaPgreOperContModel() {
	}

	public VtaPgreOperContModel(VtaPgreOperContIdModel id, CobPagareModel cobPagare, VtaContratosModel vtaContratos, VtaOperModel vtaOper) {
		this.id = id;
		this.cobPagare = cobPagare;
		this.vtaContratos = vtaContratos;
		this.vtaOper = vtaOper;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "pgreSec", column = @Column(name = "PGRE_SEC", nullable = false, precision = 23, scale = 0)),
			@AttributeOverride(name = "vtopCod", column = @Column(name = "VTOP_COD", nullable = false, precision = 23, scale = 0)),
			@AttributeOverride(name = "vtopCodCont", column = @Column(name = "VTOP_COD_CONT", nullable = false, precision = 23, scale = 0)) })
	public VtaPgreOperContIdModel getId() {
		return this.id;
	}

	public void setId(VtaPgreOperContIdModel id) {
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

}
