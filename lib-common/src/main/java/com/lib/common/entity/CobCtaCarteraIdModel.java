package com.lib.common.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * BS2
 */
@Embeddable
public class CobCtaCarteraIdModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1549104142967376598L;
	private String emprCod;
	private String ccarCod;

	public CobCtaCarteraIdModel() {
	}

	public CobCtaCarteraIdModel(String emprCod, String ccarCod) {
		this.emprCod = emprCod;
		this.ccarCod = ccarCod;
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CobCtaCarteraIdModel))
			return false;
		CobCtaCarteraIdModel castOther = (CobCtaCarteraIdModel) other;

		return ((this.getEmprCod() == castOther.getEmprCod()) || (this.getEmprCod() != null
				&& castOther.getEmprCod() != null && this.getEmprCod().equals(castOther.getEmprCod())))
				&& ((this.getCcarCod() == castOther.getCcarCod()) || (this.getCcarCod() != null
						&& castOther.getCcarCod() != null && this.getCcarCod().equals(castOther.getCcarCod())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getEmprCod() == null ? 0 : this.getEmprCod().hashCode());
		result = 37 * result + (getCcarCod() == null ? 0 : this.getCcarCod().hashCode());
		return result;
	}

}
