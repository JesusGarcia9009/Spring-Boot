package com.pdr.common.cobranza.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author BS2
 */
@Embeddable
public class CobPgreCuotaModelId implements java.io.Serializable {

	private static final long serialVersionUID = 7586500025348608150L;
	private BigDecimal pgreSec;
	private short cuotNum;

	public CobPgreCuotaModelId() {
	}

	public CobPgreCuotaModelId(BigDecimal pgreSec, short cuotNum) {
		this.pgreSec = pgreSec;
		this.cuotNum = cuotNum;
	}

	@Column(name = "PGRE_SEC", nullable = false, precision = 23, scale = 0)
	public BigDecimal getPgreSec() {
		return this.pgreSec;
	}

	public void setPgreSec(BigDecimal pgreSec) {
		this.pgreSec = pgreSec;
	}

	@Column(name = "CUOT_NUM", nullable = false, precision = 4, scale = 0)
	public short getCuotNum() {
		return this.cuotNum;
	}

	public void setCuotNum(short cuotNum) {
		this.cuotNum = cuotNum;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CobPgreCuotaModelId))
			return false;
		CobPgreCuotaModelId castOther = (CobPgreCuotaModelId) other;

		return ((this.getPgreSec() == castOther.getPgreSec()) || (this.getPgreSec() != null
				&& castOther.getPgreSec() != null && this.getPgreSec().equals(castOther.getPgreSec())))
				&& (this.getCuotNum() == castOther.getCuotNum());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getPgreSec() == null ? 0 : this.getPgreSec().hashCode());
		result = 37 * result + this.getCuotNum();
		return result;
	}

}
