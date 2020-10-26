package com.pdr.common.cobranza.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author BS2
 */
@Embeddable
public class CobPeriodoFaseIdModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1807234863516890339L;
	private String emprCod;
	private String prdoTipo;
	private int prdoCod;

	public CobPeriodoFaseIdModel() {
	}

	public CobPeriodoFaseIdModel(String emprCod, String prdoTipo, int prdoCod) {
		this.emprCod = emprCod;
		this.prdoTipo = prdoTipo;
		this.prdoCod = prdoCod;
	}

	@Column(name = "EMPR_COD", nullable = false, length = 10)
	public String getEmprCod() {
		return this.emprCod;
	}

	public void setEmprCod(String emprCod) {
		this.emprCod = emprCod;
	}

	@Column(name = "PRDO_TIPO", nullable = false, length = 10)
	public String getPrdoTipo() {
		return this.prdoTipo;
	}

	public void setPrdoTipo(String prdoTipo) {
		this.prdoTipo = prdoTipo;
	}

	@Column(name = "PRDO_COD", nullable = false, precision = 6, scale = 0)
	public int getPrdoCod() {
		return this.prdoCod;
	}

	public void setPrdoCod(int prdoCod) {
		this.prdoCod = prdoCod;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CobPeriodoFaseIdModel))
			return false;
		CobPeriodoFaseIdModel castOther = (CobPeriodoFaseIdModel) other;

		return ((this.getEmprCod() == castOther.getEmprCod()) || (this.getEmprCod() != null
				&& castOther.getEmprCod() != null && this.getEmprCod().equals(castOther.getEmprCod())))
				&& ((this.getPrdoTipo() == castOther.getPrdoTipo()) || (this.getPrdoTipo() != null
						&& castOther.getPrdoTipo() != null && this.getPrdoTipo().equals(castOther.getPrdoTipo())))
				&& (this.getPrdoCod() == castOther.getPrdoCod());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getEmprCod() == null ? 0 : this.getEmprCod().hashCode());
		result = 37 * result + (getPrdoTipo() == null ? 0 : this.getPrdoTipo().hashCode());
		result = 37 * result + this.getPrdoCod();
		return result;
	}

}
