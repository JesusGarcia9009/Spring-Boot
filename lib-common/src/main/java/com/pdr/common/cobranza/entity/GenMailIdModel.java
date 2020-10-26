package com.pdr.common.cobranza.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author BS2
 */
@Embeddable
public class GenMailIdModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String persTipoId;
	private String persId;
	private String tipoDocto;
	private BigDecimal numDocto;

	public GenMailIdModel() {
	}

	public GenMailIdModel(String persTipoId, String persId, String tipoDocto, BigDecimal numDocto) {
		this.persTipoId = persTipoId;
		this.persId = persId;
		this.tipoDocto = tipoDocto;
		this.numDocto = numDocto;
	}

	@Column(name = "PERS_TIPO_ID", nullable = false, length = 4)
	public String getPersTipoId() {
		return this.persTipoId;
	}

	public void setPersTipoId(String persTipoId) {
		this.persTipoId = persTipoId;
	}

	@Column(name = "PERS_ID", nullable = false, length = 10)
	public String getPersId() {
		return this.persId;
	}

	public void setPersId(String persId) {
		this.persId = persId;
	}

	@Column(name = "TIPO_DOCTO", nullable = false, length = 20)
	public String getTipoDocto() {
		return this.tipoDocto;
	}

	public void setTipoDocto(String tipoDocto) {
		this.tipoDocto = tipoDocto;
	}

	@Column(name = "NUM_DOCTO", nullable = false, precision = 23, scale = 0)
	public BigDecimal getNumDocto() {
		return this.numDocto;
	}

	public void setNumDocto(BigDecimal numDocto) {
		this.numDocto = numDocto;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof GenMailIdModel))
			return false;
		GenMailIdModel castOther = (GenMailIdModel) other;

		return ((this.getPersTipoId() == castOther.getPersTipoId()) || (this.getPersTipoId() != null
				&& castOther.getPersTipoId() != null && this.getPersTipoId().equals(castOther.getPersTipoId())))
				&& ((this.getPersId() == castOther.getPersId()) || (this.getPersId() != null
						&& castOther.getPersId() != null && this.getPersId().equals(castOther.getPersId())))
				&& ((this.getTipoDocto() == castOther.getTipoDocto()) || (this.getTipoDocto() != null
						&& castOther.getTipoDocto() != null && this.getTipoDocto().equals(castOther.getTipoDocto())))
				&& ((this.getNumDocto() == castOther.getNumDocto()) || (this.getNumDocto() != null
						&& castOther.getNumDocto() != null && this.getNumDocto().equals(castOther.getNumDocto())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getPersTipoId() == null ? 0 : this.getPersTipoId().hashCode());
		result = 37 * result + (getPersId() == null ? 0 : this.getPersId().hashCode());
		result = 37 * result + (getTipoDocto() == null ? 0 : this.getTipoDocto().hashCode());
		result = 37 * result + (getNumDocto() == null ? 0 : this.getNumDocto().hashCode());
		return result;
	}

}
