package com.lib.common.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * BS2
 */
@Entity
@Table(name = "CBZ_TIPO_SIMULACION_CONTRATO", schema = "CBZPAR")
public class CbzTipoSimulacionContratoModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idSimuTipoContrato;
	private String tipoSimuDescripcion;
	private Boolean tipoSimuActivo;
	private Set<CbzSimulacionModel> cbzSimulacions = new HashSet<CbzSimulacionModel>(0);

	public CbzTipoSimulacionContratoModel() {
	}

	public CbzTipoSimulacionContratoModel(int idSimuTipoContrato) {
		this.idSimuTipoContrato = idSimuTipoContrato;
	}

	public CbzTipoSimulacionContratoModel(int idSimuTipoContrato, String tipoSimuDescripcion, Boolean tipoSimuActivo,
			Set<CbzSimulacionModel> cbzSimulacions) {
		this.idSimuTipoContrato = idSimuTipoContrato;
		this.tipoSimuDescripcion = tipoSimuDescripcion;
		this.tipoSimuActivo = tipoSimuActivo;
		this.cbzSimulacions = cbzSimulacions;
	}

	@Id

	@Column(name = "ID_SIMU_TIPO_CONTRATO", unique = true, nullable = false, precision = 8, scale = 0)
	public int getIdSimuTipoContrato() {
		return this.idSimuTipoContrato;
	}

	public void setIdSimuTipoContrato(int idSimuTipoContrato) {
		this.idSimuTipoContrato = idSimuTipoContrato;
	}

	@Column(name = "TIPO_SIMU_DESCRIPCION", length = 100)
	public String getTipoSimuDescripcion() {
		return this.tipoSimuDescripcion;
	}

	public void setTipoSimuDescripcion(String tipoSimuDescripcion) {
		this.tipoSimuDescripcion = tipoSimuDescripcion;
	}

	@Column(name = "TIPO_SIMU_ACTIVO", precision = 1, scale = 0)
	public Boolean getTipoSimuActivo() {
		return this.tipoSimuActivo;
	}

	public void setTipoSimuActivo(Boolean tipoSimuActivo) {
		this.tipoSimuActivo = tipoSimuActivo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cbzTipoSimulacionContrato")
	public Set<CbzSimulacionModel> getCbzSimulacions() {
		return this.cbzSimulacions;
	}

	public void setCbzSimulacions(Set<CbzSimulacionModel> cbzSimulacions) {
		this.cbzSimulacions = cbzSimulacions;
	}

}
