package com.pdr.common.cobranza.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author BS2
 */
@Embeddable
public class GenValConvMondIdModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String moneCod;
	private Date comoFech;

	public GenValConvMondIdModel() {
	}

	public GenValConvMondIdModel(String moneCod, Date comoFech) {
		this.moneCod = moneCod;
		this.comoFech = comoFech;
	}

	@Column(name = "MONE_COD", nullable = false, length = 10)
	public String getMoneCod() {
		return this.moneCod;
	}

	public void setMoneCod(String moneCod) {
		this.moneCod = moneCod;
	}

	@Column(name = "COMO_FECH", nullable = false, length = 7)
	public Date getComoFech() {
		return this.comoFech;
	}

	public void setComoFech(Date comoFech) {
		this.comoFech = comoFech;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof GenValConvMondIdModel))
			return false;
		GenValConvMondIdModel castOther = (GenValConvMondIdModel) other;

		return ((this.getMoneCod() == castOther.getMoneCod()) || (this.getMoneCod() != null
				&& castOther.getMoneCod() != null && this.getMoneCod().equals(castOther.getMoneCod())))
				&& ((this.getComoFech() == castOther.getComoFech()) || (this.getComoFech() != null
						&& castOther.getComoFech() != null && this.getComoFech().equals(castOther.getComoFech())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getMoneCod() == null ? 0 : this.getMoneCod().hashCode());
		result = 37 * result + (getComoFech() == null ? 0 : this.getComoFech().hashCode());
		return result;
	}

}
