package com.lib.common.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * BS2
 */
@Entity
@Table(name = "CBZ_CANALES_USERPROFILE", schema = "CBZPAR")
public class CbzCanalesUserprofileModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idCanalProfile;
	private CbzCanalesModel cbzCanales;
	private BigDecimal idProfile;

	public CbzCanalesUserprofileModel() {
	}

	public CbzCanalesUserprofileModel(int idCanalProfile, CbzCanalesModel cbzCanales, BigDecimal idProfile) {
		this.idCanalProfile = idCanalProfile;
		this.cbzCanales = cbzCanales;
		this.idProfile = idProfile;
	}

	@Id

	@Column(name = "ID_CANAL_PROFILE", unique = true, nullable = false, precision = 8, scale = 0)
	public int getIdCanalProfile() {
		return this.idCanalProfile;
	}

	public void setIdCanalProfile(int idCanalProfile) {
		this.idCanalProfile = idCanalProfile;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CANAL", nullable = false)
	public CbzCanalesModel getCbzCanales() {
		return this.cbzCanales;
	}

	public void setCbzCanales(CbzCanalesModel cbzCanales) {
		this.cbzCanales = cbzCanales;
	}

	@Column(name = "ID_PROFILE", nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdProfile() {
		return this.idProfile;
	}

	public void setIdProfile(BigDecimal idProfile) {
		this.idProfile = idProfile;
	}

}
