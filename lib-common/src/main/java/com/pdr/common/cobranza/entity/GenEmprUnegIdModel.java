package com.pdr.common.cobranza.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author BS2
 */
@Embeddable
public class GenEmprUnegIdModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7959762163282815917L;
	private String emprCod;
	private String unegCod;

	public GenEmprUnegIdModel() {
	}

	public GenEmprUnegIdModel(String emprCod, String unegCod) {
		this.emprCod = emprCod;
		this.unegCod = unegCod;
	}

	@Column(name = "EMPR_COD", nullable = false, length = 10)
	public String getEmprCod() {
		return this.emprCod;
	}

	public void setEmprCod(String emprCod) {
		this.emprCod = emprCod;
	}

	@Column(name = "UNEG_COD", nullable = false, length = 10)
	public String getUnegCod() {
		return this.unegCod;
	}

	public void setUnegCod(String unegCod) {
		this.unegCod = unegCod;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof GenEmprUnegIdModel))
			return false;
		GenEmprUnegIdModel castOther = (GenEmprUnegIdModel) other;

		return ((this.getEmprCod() == castOther.getEmprCod()) || (this.getEmprCod() != null
				&& castOther.getEmprCod() != null && this.getEmprCod().equals(castOther.getEmprCod())))
				&& ((this.getUnegCod() == castOther.getUnegCod()) || (this.getUnegCod() != null
						&& castOther.getUnegCod() != null && this.getUnegCod().equals(castOther.getUnegCod())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getEmprCod() == null ? 0 : this.getEmprCod().hashCode());
		result = 37 * result + (getUnegCod() == null ? 0 : this.getUnegCod().hashCode());
		return result;
	}

}
