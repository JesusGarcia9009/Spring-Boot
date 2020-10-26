package com.pdr.common.cobranza.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author BS2
 */
@Embeddable
public class CobFasesModelId implements java.io.Serializable {

	private static final long serialVersionUID = 7586500025348608150L;
	private String faseCod;
	private String emprCod;

	public CobFasesModelId() {
	}

	public CobFasesModelId(String faseCod, String emprCod) {
		this.faseCod = faseCod;
		this.emprCod = emprCod;
	}

	@Column(name = "FASE_COD", nullable = false, length = 20)
	public String getFaseCod() {
		return this.faseCod;
	}

	public void setFaseCod(String faseCod) {
		this.faseCod = faseCod;
	}

	@Column(name = "EMPR_COD", nullable = false, length = 10)
	public String getEmprCod() {
		return this.emprCod;
	}

	public void setEmprCod(String emprCod) {
		this.emprCod = emprCod;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CobFasesModelId))
			return false;
		CobFasesModelId castOther = (CobFasesModelId) other;

		return ((this.getFaseCod() == castOther.getFaseCod()) || (this.getFaseCod() != null
				&& castOther.getFaseCod() != null && this.getFaseCod().equals(castOther.getFaseCod())))
				&& ((this.getEmprCod() == castOther.getEmprCod()) || (this.getEmprCod() != null
						&& castOther.getEmprCod() != null && this.getEmprCod().equals(castOther.getEmprCod())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getFaseCod() == null ? 0 : this.getFaseCod().hashCode());
		result = 37 * result + (getEmprCod() == null ? 0 : this.getEmprCod().hashCode());
		return result;
	}

}
