package com.pdr.common.cobranza.entity;

import java.math.BigDecimal;

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
 * BS2
 */
@Entity
@Table(name = "CBZ_SIMULACION_PAGARES", schema = "CBZPAR")
public class CbzSimulacionPagaresModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal idSimuPagare;
	private CobPagareModel cobPagare;
	private CbzSimulacionModel cbzSimulacion;

	public CbzSimulacionPagaresModel() {
	}

	public CbzSimulacionPagaresModel(BigDecimal idSimuPagare, CobPagareModel cobPagare, CbzSimulacionModel cbzSimulacion) {
		this.idSimuPagare = idSimuPagare;
		this.cobPagare = cobPagare;
		this.cbzSimulacion = cbzSimulacion;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_sequence_pagares")
	@SequenceGenerator(name = "id_sequence_pagares",  allocationSize = 1, sequenceName = "seq_simulacion_pagares", schema = "CBZPAR")
	@Column(name = "ID_SIMU_PAGARE", unique = true, nullable = false, precision = 38, scale = 0)
	public BigDecimal getIdSimuPagare() {
		return this.idSimuPagare;
	}

	public void setIdSimuPagare(BigDecimal idSimuPagare) {
		this.idSimuPagare = idSimuPagare;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PGRE_SEC", nullable = false)
	public CobPagareModel getCobPagare() {
		return this.cobPagare;
	}

	public void setCobPagare(CobPagareModel cobPagare) {
		this.cobPagare = cobPagare;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SIMULACION", nullable = false)
	public CbzSimulacionModel getCbzSimulacion() {
		return this.cbzSimulacion;
	}

	public void setCbzSimulacion(CbzSimulacionModel cbzSimulacion) {
		this.cbzSimulacion = cbzSimulacion;
	}

}
