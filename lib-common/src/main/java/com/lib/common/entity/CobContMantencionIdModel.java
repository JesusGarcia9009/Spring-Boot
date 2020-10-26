package com.lib.common.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author BS2
 */
@Embeddable
public class CobContMantencionIdModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal vtopCodCont;
	private String emprCodAdm;
	private String unegCod;
	private BigDecimal vtopCod;

	public CobContMantencionIdModel() {
	}

	public CobContMantencionIdModel(BigDecimal vtopCodCont, String emprCodAdm, String unegCod, BigDecimal vtopCod) {
		this.vtopCodCont = vtopCodCont;
		this.emprCodAdm = emprCodAdm;
		this.unegCod = unegCod;
		this.vtopCod = vtopCod;
	}

	@Column(name = "VTOP_COD_CONT", unique = true, nullable = false, precision = 23, scale = 0)
	public BigDecimal getVtopCodCont() {
		return this.vtopCodCont;
	}

	public void setVtopCodCont(BigDecimal vtopCodCont) {
		this.vtopCodCont = vtopCodCont;
	}

	@Column(name = "EMPR_COD_ADM", nullable = false, length = 10)
	public String getEmprCodAdm() {
		return this.emprCodAdm;
	}

	public void setEmprCodAdm(String emprCodAdm) {
		this.emprCodAdm = emprCodAdm;
	}

	@Column(name = "UNEG_COD", nullable = false, length = 10)
	public String getUnegCod() {
		return this.unegCod;
	}

	public void setUnegCod(String unegCod) {
		this.unegCod = unegCod;
	}

	@Column(name = "VTOP_COD", nullable = false, precision = 23, scale = 0)
	public BigDecimal getVtopCod() {
		return this.vtopCod;
	}

	public void setVtopCod(BigDecimal vtopCod) {
		this.vtopCod = vtopCod;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CobContMantencionIdModel))
			return false;
		CobContMantencionIdModel castOther = (CobContMantencionIdModel) other;

		return ((this.getVtopCodCont() == castOther.getVtopCodCont()) || (this.getVtopCodCont() != null
				&& castOther.getVtopCodCont() != null && this.getVtopCodCont().equals(castOther.getVtopCodCont())))
				&& ((this.getEmprCodAdm() == castOther.getEmprCodAdm()) || (this.getEmprCodAdm() != null
						&& castOther.getEmprCodAdm() != null && this.getEmprCodAdm().equals(castOther.getEmprCodAdm())))
				&& ((this.getUnegCod() == castOther.getUnegCod()) || (this.getUnegCod() != null
						&& castOther.getUnegCod() != null && this.getUnegCod().equals(castOther.getUnegCod())))
				&& ((this.getVtopCod() == castOther.getVtopCod()) || (this.getVtopCod() != null
						&& castOther.getVtopCod() != null && this.getVtopCod().equals(castOther.getVtopCod())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getVtopCodCont() == null ? 0 : this.getVtopCodCont().hashCode());
		result = 37 * result + (getEmprCodAdm() == null ? 0 : this.getEmprCodAdm().hashCode());
		result = 37 * result + (getUnegCod() == null ? 0 : this.getUnegCod().hashCode());
		result = 37 * result + (getVtopCod() == null ? 0 : this.getVtopCod().hashCode());
		return result;
	}

}
