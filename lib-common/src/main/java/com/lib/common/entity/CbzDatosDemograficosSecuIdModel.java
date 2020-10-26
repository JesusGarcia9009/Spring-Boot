package com.lib.common.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * BS2
 */
@Embeddable
public class CbzDatosDemograficosSecuIdModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal idDatosSecundarios;
	private BigDecimal vtopCodCont;
	private String dsecDireccion;
	private String dsecCelular;
	private String dsecEmailSec;
	private String dsecEmailTerc;

	public CbzDatosDemograficosSecuIdModel() {
	}

	public CbzDatosDemograficosSecuIdModel(BigDecimal vtopCodCont) {
		this.vtopCodCont = vtopCodCont;
	}

	public CbzDatosDemograficosSecuIdModel(BigDecimal idDatosSecundarios, BigDecimal vtopCodCont, String dsecDireccion,
			String dsecCelular, String dsecEmailSec, String dsecEmailTerc) {
		this.idDatosSecundarios = idDatosSecundarios;
		this.vtopCodCont = vtopCodCont;
		this.dsecDireccion = dsecDireccion;
		this.dsecCelular = dsecCelular;
		this.dsecEmailSec = dsecEmailSec;
		this.dsecEmailTerc = dsecEmailTerc;
	}

	@Column(name = "ID_DATOS_SECUNDARIOS", precision = 22)
	public BigDecimal getIdDatosSecundarios() {
		return this.idDatosSecundarios;
	}

	public void setIdDatosSecundarios(BigDecimal idDatosSecundarios) {
		this.idDatosSecundarios = idDatosSecundarios;
	}

	@Column(name = "VTOP_COD_CONT", nullable = false, precision = 23, scale = 0)
	public BigDecimal getVtopCodCont() {
		return this.vtopCodCont;
	}

	public void setVtopCodCont(BigDecimal vtopCodCont) {
		this.vtopCodCont = vtopCodCont;
	}

	@Column(name = "DSEC_DIRECCION", length = 500)
	public String getDsecDireccion() {
		return this.dsecDireccion;
	}

	public void setDsecDireccion(String dsecDireccion) {
		this.dsecDireccion = dsecDireccion;
	}

	@Column(name = "DSEC_CELULAR", length = 15)
	public String getDsecCelular() {
		return this.dsecCelular;
	}

	public void setDsecCelular(String dsecCelular) {
		this.dsecCelular = dsecCelular;
	}

	@Column(name = "DSEC_EMAIL_SEC", length = 200)
	public String getDsecEmailSec() {
		return this.dsecEmailSec;
	}

	public void setDsecEmailSec(String dsecEmailSec) {
		this.dsecEmailSec = dsecEmailSec;
	}

	@Column(name = "DSEC_EMAIL_TERC", length = 100)
	public String getDsecEmailTerc() {
		return this.dsecEmailTerc;
	}

	public void setDsecEmailTerc(String dsecEmailTerc) {
		this.dsecEmailTerc = dsecEmailTerc;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CbzDatosDemograficosSecuIdModel))
			return false;
		CbzDatosDemograficosSecuIdModel castOther = (CbzDatosDemograficosSecuIdModel) other;

		return ((this.getIdDatosSecundarios() == castOther.getIdDatosSecundarios())
				|| (this.getIdDatosSecundarios() != null && castOther.getIdDatosSecundarios() != null
						&& this.getIdDatosSecundarios().equals(castOther.getIdDatosSecundarios())))
				&& ((this.getVtopCodCont() == castOther.getVtopCodCont())
						|| (this.getVtopCodCont() != null && castOther.getVtopCodCont() != null
								&& this.getVtopCodCont().equals(castOther.getVtopCodCont())))
				&& ((this.getDsecDireccion() == castOther.getDsecDireccion())
						|| (this.getDsecDireccion() != null && castOther.getDsecDireccion() != null
								&& this.getDsecDireccion().equals(castOther.getDsecDireccion())))
				&& ((this.getDsecCelular() == castOther.getDsecCelular())
						|| (this.getDsecCelular() != null && castOther.getDsecCelular() != null
								&& this.getDsecCelular().equals(castOther.getDsecCelular())))
				&& ((this.getDsecEmailSec() == castOther.getDsecEmailSec())
						|| (this.getDsecEmailSec() != null && castOther.getDsecEmailSec() != null
								&& this.getDsecEmailSec().equals(castOther.getDsecEmailSec())))
				&& ((this.getDsecEmailTerc() == castOther.getDsecEmailTerc())
						|| (this.getDsecEmailTerc() != null && castOther.getDsecEmailTerc() != null
								&& this.getDsecEmailTerc().equals(castOther.getDsecEmailTerc())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getIdDatosSecundarios() == null ? 0 : this.getIdDatosSecundarios().hashCode());
		result = 37 * result + (getVtopCodCont() == null ? 0 : this.getVtopCodCont().hashCode());
		result = 37 * result + (getDsecDireccion() == null ? 0 : this.getDsecDireccion().hashCode());
		result = 37 * result + (getDsecCelular() == null ? 0 : this.getDsecCelular().hashCode());
		result = 37 * result + (getDsecEmailSec() == null ? 0 : this.getDsecEmailSec().hashCode());
		result = 37 * result + (getDsecEmailTerc() == null ? 0 : this.getDsecEmailTerc().hashCode());
		return result;
	}

}
