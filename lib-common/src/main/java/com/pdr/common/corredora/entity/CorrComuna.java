package com.pdr.common.corredora.entity;
// Generated 29-09-2020 15:26:18 by Hibernate Tools 5.2.12.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * CorrComuna generated by hbm2java
 */
@Entity
@Table(name = "CORR_COMUNA", schema = "CDORA")
public class CorrComuna implements java.io.Serializable {

	private CorrComunaId id;
	private CorrCiudad corrCiudad;
	private String descComuna;

	public CorrComuna() {
	}

	public CorrComuna(CorrComunaId id, CorrCiudad corrCiudad) {
		this.id = id;
		this.corrCiudad = corrCiudad;
	}

	public CorrComuna(CorrComunaId id, CorrCiudad corrCiudad, String descComuna) {
		this.id = id;
		this.corrCiudad = corrCiudad;
		this.descComuna = descComuna;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "idComuna", column = @Column(name = "ID_COMUNA", nullable = false, precision = 5, scale = 0)),
			@AttributeOverride(name = "idCiudad", column = @Column(name = "ID_CIUDAD", nullable = false, precision = 5, scale = 0)) })
	public CorrComunaId getId() {
		return this.id;
	}

	public void setId(CorrComunaId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CIUDAD", nullable = false, insertable = false, updatable = false)
	public CorrCiudad getCorrCiudad() {
		return this.corrCiudad;
	}

	public void setCorrCiudad(CorrCiudad corrCiudad) {
		this.corrCiudad = corrCiudad;
	}

	@Column(name = "DESC_COMUNA", length = 50)
	public String getDescComuna() {
		return this.descComuna;
	}

	public void setDescComuna(String descComuna) {
		this.descComuna = descComuna;
	}

}
