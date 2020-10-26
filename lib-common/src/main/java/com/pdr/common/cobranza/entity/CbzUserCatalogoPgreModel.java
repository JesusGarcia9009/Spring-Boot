package com.pdr.common.cobranza.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * generated by BS2
 */
@Entity
@Table(name = "CBZ_USER_CATALOGO_PGRE", schema = "CBZPAR")
public class CbzUserCatalogoPgreModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idUserCatalogoPgre;
	private BigDecimal catpSec;
	private Date fechaAsignacion;
	private BigDecimal idUsers;

	public CbzUserCatalogoPgreModel() {
	}

	public CbzUserCatalogoPgreModel(int idUserCatalogoPgre, BigDecimal catpSec, Date fechaAsignacion) {
		this.idUserCatalogoPgre = idUserCatalogoPgre;
		this.catpSec = catpSec;
		this.fechaAsignacion = fechaAsignacion;
	}

	public CbzUserCatalogoPgreModel(int idUserCatalogoPgre, BigDecimal catpSec, Date fechaAsignacion, BigDecimal idUsers) {
		this.idUserCatalogoPgre = idUserCatalogoPgre;
		this.catpSec = catpSec;
		this.fechaAsignacion = fechaAsignacion;
		this.idUsers = idUsers;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence_idUserCatalogoPgre")
	@SequenceGenerator(name = "id_sequence_idUserCatalogoPgre", allocationSize = 1, sequenceName = "SEQ_USER_CATALAGO_PGRE", schema = "CBZPAR")
	@Column(name = "ID_USER_CATALOGO_PGRE", unique = true, nullable = false, precision = 8, scale = 0)
	public Integer getIdUserCatalogoPgre() {
		return this.idUserCatalogoPgre;
	}

	public void setIdUserCatalogoPgre(Integer idUserCatalogoPgre) {
		this.idUserCatalogoPgre = idUserCatalogoPgre;
	}

	@Column(name = "CATP_SEC", nullable = false, precision = 23, scale = 0)
	public BigDecimal getCatpSec() {
		return this.catpSec;
	}

	public void setCatpSec(BigDecimal catpSec) {
		this.catpSec = catpSec;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_ASIGNACION", nullable = false, length = 7)
	public Date getFechaAsignacion() {
		return this.fechaAsignacion;
	}

	public void setFechaAsignacion(Date fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

	@Column(name = "ID_USERS", precision = 22, scale = 0)
	public BigDecimal getIdUsers() {
		return this.idUsers;
	}

	public void setIdUsers(BigDecimal idUsers) {
		this.idUsers = idUsers;
	}

}
