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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author BS2
 */
@Entity
@Table(name = "COB_PROC_ASIG_CART", schema = "COBPAR")
public class CobProcAsigCartModel implements java.io.Serializable {

	private static final long serialVersionUID = 7586500025348608150L;
	private CobProcAsigCartModelId id;
	private String pacrTipoProc;
	private Date pacrDiaCaja;
	private String pacrEstaCod;
	private String pacrUserMod;
	private Date pacrFecMod;
	private Date pacrFecIng;
	private Set<CobCatalogoPgreModel> cobCatalogoPgres = new HashSet<>(0);

	public CobProcAsigCartModel() {
	}

	public CobProcAsigCartModel(CobProcAsigCartModelId id, String pacrTipoProc, Date pacrDiaCaja, String pacrEstaCod,
			String pacrUserMod, Date pacrFecMod) {
		this.id = id;
		this.pacrTipoProc = pacrTipoProc;
		this.pacrDiaCaja = pacrDiaCaja;
		this.pacrEstaCod = pacrEstaCod;
		this.pacrUserMod = pacrUserMod;
		this.pacrFecMod = pacrFecMod;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "emprCod", column = @Column(name = "EMPR_COD", nullable = false, length = 10)),
			@AttributeOverride(name = "pacrProdCod", column = @Column(name = "PACR_PROD_COD", nullable = false, length = 20)),
			@AttributeOverride(name = "pacrPrdoCod", column = @Column(name = "PACR_PRDO_COD", nullable = false, precision = 6, scale = 0)),
			@AttributeOverride(name = "pacrDiaAsig", column = @Column(name = "PACR_DIA_ASIG", nullable = false, length = 7)) })
	public CobProcAsigCartModelId getId() {
		return this.id;
	}

	public void setId(CobProcAsigCartModelId id) {
		this.id = id;
	}

	@Column(name = "PACR_TIPO_PROC", nullable = false, length = 10)
	public String getPacrTipoProc() {
		return this.pacrTipoProc;
	}

	public void setPacrTipoProc(String pacrTipoProc) {
		this.pacrTipoProc = pacrTipoProc;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "PACR_DIA_CAJA", nullable = false, length = 7)
	public Date getPacrDiaCaja() {
		return this.pacrDiaCaja;
	}

	public void setPacrDiaCaja(Date pacrDiaCaja) {
		this.pacrDiaCaja = pacrDiaCaja;
	}

	@Column(name = "PACR_ESTA_COD", nullable = false, length = 20)
	public String getPacrEstaCod() {
		return this.pacrEstaCod;
	}

	public void setPacrEstaCod(String pacrEstaCod) {
		this.pacrEstaCod = pacrEstaCod;
	}

	@Column(name = "PACR_USER_MOD", nullable = false, length = 30)
	public String getPacrUserMod() {
		return this.pacrUserMod;
	}

	public void setPacrUserMod(String pacrUserMod) {
		this.pacrUserMod = pacrUserMod;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "PACR_FEC_MOD", nullable = false, length = 7)
	public Date getPacrFecMod() {
		return this.pacrFecMod;
	}

	public void setPacrFecMod(Date pacrFecMod) {
		this.pacrFecMod = pacrFecMod;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "PACR_FEC_ING", length = 7)
	public Date getPacrFecIng() {
		return this.pacrFecIng;
	}

	public void setPacrFecIng(Date pacrFecIng) {
		this.pacrFecIng = pacrFecIng;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cobProcAsigCart")
	public Set<CobCatalogoPgreModel> getCobCatalogoPgres() {
		return this.cobCatalogoPgres;
	}

	public void setCobCatalogoPgres(Set<CobCatalogoPgreModel> cobCatalogoPgres) {
		this.cobCatalogoPgres = cobCatalogoPgres;
	}

}
