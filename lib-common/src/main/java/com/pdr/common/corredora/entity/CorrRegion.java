package com.pdr.common.corredora.entity;
// Generated 29-09-2020 15:26:18 by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * CorrRegion generated by hbm2java
 */
@Entity
@Table(name = "CORR_REGION", schema = "CDORA")
public class CorrRegion implements java.io.Serializable {

	private int idRegion;
	private String descRegion;
	private Set<CorrCiudad> corrCiudads = new HashSet<CorrCiudad>(0);

	public CorrRegion() {
	}

	public CorrRegion(int idRegion) {
		this.idRegion = idRegion;
	}

	public CorrRegion(int idRegion, String descRegion, Set<CorrCiudad> corrCiudads) {
		this.idRegion = idRegion;
		this.descRegion = descRegion;
		this.corrCiudads = corrCiudads;
	}

	@Id

	@Column(name = "ID_REGION", unique = true, nullable = false, precision = 5, scale = 0)
	public int getIdRegion() {
		return this.idRegion;
	}

	public void setIdRegion(int idRegion) {
		this.idRegion = idRegion;
	}

	@Column(name = "DESC_REGION", length = 60)
	public String getDescRegion() {
		return this.descRegion;
	}

	public void setDescRegion(String descRegion) {
		this.descRegion = descRegion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "corrRegion")
	public Set<CorrCiudad> getCorrCiudads() {
		return this.corrCiudads;
	}

	public void setCorrCiudads(Set<CorrCiudad> corrCiudads) {
		this.corrCiudads = corrCiudads;
	}

}
