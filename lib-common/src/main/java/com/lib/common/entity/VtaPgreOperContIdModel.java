package com.lib.common.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author BS2
 */
@Embeddable
public class VtaPgreOperContIdModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal pgreSec;
	private BigDecimal vtopCod;
	private BigDecimal vtopCodCont;

	public VtaPgreOperContIdModel() {
	}

	public VtaPgreOperContIdModel(BigDecimal pgreSec, BigDecimal vtopCod, BigDecimal vtopCodCont) {
		this.pgreSec = pgreSec;
		this.vtopCod = vtopCod;
		this.vtopCodCont = vtopCodCont;
	}

	@Column(name = "PGRE_SEC", nullable = false, precision = 23, scale = 0)
	public BigDecimal getPgreSec() {
		return this.pgreSec;
	}

	public void setPgreSec(BigDecimal pgreSec) {
		this.pgreSec = pgreSec;
	}

	@Column(name = "VTOP_COD", nullable = false, precision = 23, scale = 0)
	public BigDecimal getVtopCod() {
		return this.vtopCod;
	}

	public void setVtopCod(BigDecimal vtopCod) {
		this.vtopCod = vtopCod;
	}

	@Column(name = "VTOP_COD_CONT", nullable = false, precision = 23, scale = 0)
	public BigDecimal getVtopCodCont() {
		return this.vtopCodCont;
	}

	public void setVtopCodCont(BigDecimal vtopCodCont) {
		this.vtopCodCont = vtopCodCont;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VtaPgreOperContIdModel))
			return false;
		VtaPgreOperContIdModel castOther = (VtaPgreOperContIdModel) other;

		return ((this.getPgreSec() == castOther.getPgreSec()) || (this.getPgreSec() != null
				&& castOther.getPgreSec() != null && this.getPgreSec().equals(castOther.getPgreSec())))
				&& ((this.getVtopCod() == castOther.getVtopCod()) || (this.getVtopCod() != null
						&& castOther.getVtopCod() != null && this.getVtopCod().equals(castOther.getVtopCod())))
				&& ((this.getVtopCodCont() == castOther.getVtopCodCont())
						|| (this.getVtopCodCont() != null && castOther.getVtopCodCont() != null
								&& this.getVtopCodCont().equals(castOther.getVtopCodCont())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getPgreSec() == null ? 0 : this.getPgreSec().hashCode());
		result = 37 * result + (getVtopCod() == null ? 0 : this.getVtopCod().hashCode());
		result = 37 * result + (getVtopCodCont() == null ? 0 : this.getVtopCodCont().hashCode());
		return result;
	}

}
