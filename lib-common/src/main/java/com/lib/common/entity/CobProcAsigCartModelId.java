package com.lib.common.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author BS2
 */
@Embeddable
public class CobProcAsigCartModelId implements java.io.Serializable {

	private static final long serialVersionUID = 7586500025348608150L;
	private String emprCod;
	private String pacrProdCod;
	private int pacrPrdoCod;
	private Date pacrDiaAsig;

	public CobProcAsigCartModelId() {
	}

	public CobProcAsigCartModelId(String emprCod, String pacrProdCod, int pacrPrdoCod, Date pacrDiaAsig) {
		this.emprCod = emprCod;
		this.pacrProdCod = pacrProdCod;
		this.pacrPrdoCod = pacrPrdoCod;
		this.pacrDiaAsig = pacrDiaAsig;
	}

	@Column(name = "EMPR_COD", nullable = false, length = 10)
	public String getEmprCod() {
		return this.emprCod;
	}

	public void setEmprCod(String emprCod) {
		this.emprCod = emprCod;
	}

	@Column(name = "PACR_PROD_COD", nullable = false, length = 20)
	public String getPacrProdCod() {
		return this.pacrProdCod;
	}

	public void setPacrProdCod(String pacrProdCod) {
		this.pacrProdCod = pacrProdCod;
	}

	@Column(name = "PACR_PRDO_COD", nullable = false, precision = 6, scale = 0)
	public int getPacrPrdoCod() {
		return this.pacrPrdoCod;
	}

	public void setPacrPrdoCod(int pacrPrdoCod) {
		this.pacrPrdoCod = pacrPrdoCod;
	}

	@Column(name = "PACR_DIA_ASIG", nullable = false, length = 7)
	public Date getPacrDiaAsig() {
		return this.pacrDiaAsig;
	}

	public void setPacrDiaAsig(Date pacrDiaAsig) {
		this.pacrDiaAsig = pacrDiaAsig;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CobProcAsigCartModelId))
			return false;
		CobProcAsigCartModelId castOther = (CobProcAsigCartModelId) other;

		return ((this.getEmprCod() == castOther.getEmprCod()) || (this.getEmprCod() != null
				&& castOther.getEmprCod() != null && this.getEmprCod().equals(castOther.getEmprCod())))
				&& ((this.getPacrProdCod() == castOther.getPacrProdCod())
						|| (this.getPacrProdCod() != null && castOther.getPacrProdCod() != null
								&& this.getPacrProdCod().equals(castOther.getPacrProdCod())))
				&& (this.getPacrPrdoCod() == castOther.getPacrPrdoCod())
				&& ((this.getPacrDiaAsig() == castOther.getPacrDiaAsig())
						|| (this.getPacrDiaAsig() != null && castOther.getPacrDiaAsig() != null
								&& this.getPacrDiaAsig().equals(castOther.getPacrDiaAsig())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getEmprCod() == null ? 0 : this.getEmprCod().hashCode());
		result = 37 * result + (getPacrProdCod() == null ? 0 : this.getPacrProdCod().hashCode());
		result = 37 * result + this.getPacrPrdoCod();
		result = 37 * result + (getPacrDiaAsig() == null ? 0 : this.getPacrDiaAsig().hashCode());
		return result;
	}

}
