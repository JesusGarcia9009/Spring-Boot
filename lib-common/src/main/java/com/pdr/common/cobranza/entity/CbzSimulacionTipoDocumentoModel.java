package com.pdr.common.cobranza.entity;

import java.math.BigDecimal;
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
@Table(name = "CBZ_SIMULACION_TIPO_DOCUMENTO", schema = "CBZPAR")
public class CbzSimulacionTipoDocumentoModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal idSimuTipoDocumento;
	private String simDocMediatype;
	private Boolean simDocumentoActivo;
	private String simDocDescripcion;
	private String simTemplateVm;
	private Set<CbzSimulacionDocumentosModel> cbzSimulacionDocumentoses = new HashSet<CbzSimulacionDocumentosModel>(0);

	public CbzSimulacionTipoDocumentoModel() {
	}

	public CbzSimulacionTipoDocumentoModel(BigDecimal idSimuTipoDocumento) {
		this.idSimuTipoDocumento = idSimuTipoDocumento;
	}

	public CbzSimulacionTipoDocumentoModel(BigDecimal idSimuTipoDocumento, String simDocMediatype,
			Boolean simDocumentoActivo, String simDocDescripcion, String simTemplateVm,
			Set<CbzSimulacionDocumentosModel> cbzSimulacionDocumentoses) {
		this.idSimuTipoDocumento = idSimuTipoDocumento;
		this.simDocMediatype = simDocMediatype;
		this.simDocumentoActivo = simDocumentoActivo;
		this.simDocDescripcion = simDocDescripcion;
		this.simTemplateVm = simTemplateVm;
		this.cbzSimulacionDocumentoses = cbzSimulacionDocumentoses;
	}

	@Id
	@Column(name = "ID_SIMU_TIPO_DOCUMENTO", unique = true, nullable = false, precision = 38, scale = 0)
	public BigDecimal getIdSimuTipoDocumento() {
		return this.idSimuTipoDocumento;
	}

	public void setIdSimuTipoDocumento(BigDecimal idSimuTipoDocumento) {
		this.idSimuTipoDocumento = idSimuTipoDocumento;
	}

	@Column(name = "SIM_DOC_MEDIATYPE", length = 50)
	public String getSimDocMediatype() {
		return this.simDocMediatype;
	}

	public void setSimDocMediatype(String simDocMediatype) {
		this.simDocMediatype = simDocMediatype;
	}

	@Column(name = "SIM_DOCUMENTO_ACTIVO", precision = 1, scale = 0)
	public Boolean getSimDocumentoActivo() {
		return this.simDocumentoActivo;
	}

	public void setSimDocumentoActivo(Boolean simDocumentoActivo) {
		this.simDocumentoActivo = simDocumentoActivo;
	}

	@Column(name = "SIM_DOC_DESCRIPCION", length = 50)
	public String getSimDocDescripcion() {
		return this.simDocDescripcion;
	}

	public void setSimDocDescripcion(String simDocDescripcion) {
		this.simDocDescripcion = simDocDescripcion;
	}

	@Column(name = "SIM_TEMPLATE_VM", length = 100)
	public String getSimTemplateVm() {
		return this.simTemplateVm;
	}

	public void setSimTemplateVm(String simTemplateVm) {
		this.simTemplateVm = simTemplateVm;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cbzSimulacionTipoDocumento")
	public Set<CbzSimulacionDocumentosModel> getCbzSimulacionDocumentoses() {
		return this.cbzSimulacionDocumentoses;
	}

	public void setCbzSimulacionDocumentoses(Set<CbzSimulacionDocumentosModel> cbzSimulacionDocumentoses) {
		this.cbzSimulacionDocumentoses = cbzSimulacionDocumentoses;
	}

}
