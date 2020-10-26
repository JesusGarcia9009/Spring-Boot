package com.pdr.common.cobranza.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author BS2
 */
@Embeddable
public class VtaOperUbicIdModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal vtopCod;
	private BigDecimal ubicSec;

	public VtaOperUbicIdModel() {
	}

	public VtaOperUbicIdModel(BigDecimal vtopCod, BigDecimal ubicSec) {
		this.vtopCod = vtopCod;
		this.ubicSec = ubicSec;
	}

	@Column(name = "VTOP_COD", nullable = false, precision = 23, scale = 0)
	public BigDecimal getVtopCod() {
		return this.vtopCod;
	}

	public void setVtopCod(BigDecimal vtopCod) {
		this.vtopCod = vtopCod;
	}

	@Column(name = "UBIC_SEC", nullable = false, precision = 23, scale = 0)
	public BigDecimal getUbicSec() {
		return this.ubicSec;
	}

	public void setUbicSec(BigDecimal ubicSec) {
		this.ubicSec = ubicSec;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VtaOperUbicIdModel))
			return false;
		VtaOperUbicIdModel castOther = (VtaOperUbicIdModel) other;

		return ((this.getVtopCod() == castOther.getVtopCod()) || (this.getVtopCod() != null
				&& castOther.getVtopCod() != null && this.getVtopCod().equals(castOther.getVtopCod())))
				&& ((this.getUbicSec() == castOther.getUbicSec()) || (this.getUbicSec() != null
						&& castOther.getUbicSec() != null && this.getUbicSec().equals(castOther.getUbicSec())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getVtopCod() == null ? 0 : this.getVtopCod().hashCode());
		result = 37 * result + (getUbicSec() == null ? 0 : this.getUbicSec().hashCode());
		return result;
	}

}
