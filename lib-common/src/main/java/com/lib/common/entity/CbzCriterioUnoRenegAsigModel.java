package com.lib.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author BS2
 */
@Entity
@Table(name = "CBZ_CRITERIO_UNO_RENEG_ASIG", schema = "CBZPAR")
public class CbzCriterioUnoRenegAsigModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long idCuraAsignacion;
	private CbzCriterioUnoModel cbzCriterioUno;
	private String curaRutEjecutivo;
	private String curaNombreEjecutivo;
	private Long curaPorcAsignacion;

	public CbzCriterioUnoRenegAsigModel() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE_CRITERIO_UNO_RENEG_ASIG")
	@SequenceGenerator(name = "ID_SEQUENCE_CRITERIO_UNO_RENEG_ASIG", allocationSize = 1, sequenceName = "SEQ_CBZ_CRITERIO_UNO_RENEG_ASIG", schema = "CBZPAR")
	@Column(name = "ID_CURA_ASIGNACION", unique = true, nullable = false, precision = 16, scale = 0)
	public long getIdCuraAsignacion() {
		return this.idCuraAsignacion;
	}

	public void setIdCuraAsignacion(long idCuraAsignacion) {
		this.idCuraAsignacion = idCuraAsignacion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CBZ_CRITERIO_UNO_ID_CU_CRITERIO_UNO", nullable = false)
	public CbzCriterioUnoModel getCbzCriterioUno() {
		return this.cbzCriterioUno;
	}

	public void setCbzCriterioUno(CbzCriterioUnoModel cbzCriterioUno) {
		this.cbzCriterioUno = cbzCriterioUno;
	}

	@Column(name = "CURA_RUT_EJECUTIVO", length = 50)
	public String getCuraRutEjecutivo() {
		return this.curaRutEjecutivo;
	}

	public void setCuraRutEjecutivo(String curaRutEjecutivo) {
		this.curaRutEjecutivo = curaRutEjecutivo;
	}

	@Column(name = "CURA_NOMBRE_EJECUTIVO", length = 200)
	public String getCuraNombreEjecutivo() {
		return this.curaNombreEjecutivo;
	}

	public void setCuraNombreEjecutivo(String curaNombreEjecutivo) {
		this.curaNombreEjecutivo = curaNombreEjecutivo;
	}

	@Column(name = "CURA_PORC_ASIGNACION", precision = 16, scale = 0)
	public Long getCuraPorcAsignacion() {
		return this.curaPorcAsignacion;
	}

	public void setCuraPorcAsignacion(Long curaPorcAsignacion) {
		this.curaPorcAsignacion = curaPorcAsignacion;
	}

}
