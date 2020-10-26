package com.lib.common.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author BS2
 */
@Embeddable
public class GenPersonasIdModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String persTipoId;
	private String persId;

	public GenPersonasIdModel() {
	}

	public GenPersonasIdModel(String persTipoId, String persId) {
		this.persTipoId = persTipoId;
		this.persId = persId;
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof GenPersonasIdModel))
			return false;
		GenPersonasIdModel castOther = (GenPersonasIdModel) other;

		return ((this.getPersTipoId() == castOther.getPersTipoId()) || (this.getPersTipoId() != null
				&& castOther.getPersTipoId() != null && this.getPersTipoId().equals(castOther.getPersTipoId())))
				&& ((this.getPersId() == castOther.getPersId()) || (this.getPersId() != null
						&& castOther.getPersId() != null && this.getPersId().equals(castOther.getPersId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getPersTipoId() == null ? 0 : this.getPersTipoId().hashCode());
		result = 37 * result + (getPersId() == null ? 0 : this.getPersId().hashCode());
		return result;
	}

}
