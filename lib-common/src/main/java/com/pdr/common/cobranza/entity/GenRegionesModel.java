package com.pdr.common.cobranza.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author BS2
 */
@Entity
@Table(name = "GEN_REGIONES", schema = "GENPAR")
public class GenRegionesModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 372577552106236208L;
	private Integer regiCod;
	private String regiNumRoma;
	private String regiDesc;
	private Set<GenComunasModel> genComunases = new HashSet<GenComunasModel>(0);

	public GenRegionesModel() {
	}

	public GenRegionesModel(Integer regiCod, String regiNumRoma, String regiDesc) {
		this.regiCod = regiCod;
		this.regiNumRoma = regiNumRoma;
		this.regiDesc = regiDesc;
	}

	public GenRegionesModel(Integer regiCod, String regiNumRoma, String regiDesc, Set<GenComunasModel> genComunases) {
		this.regiCod = regiCod;
		this.regiNumRoma = regiNumRoma;
		this.regiDesc = regiDesc;
		this.genComunases = genComunases;
	}

	@Id

	@Column(name = "REGI_COD", unique = true, nullable = false, precision = 2, scale = 0)
	public Integer getRegiCod() {
		return this.regiCod;
	}

	public void setRegiCod(Integer regiCod) {
		this.regiCod = regiCod;
	}

	@Column(name = "REGI_NUM_ROMA", nullable = false, length = 5)
	public String getRegiNumRoma() {
		return this.regiNumRoma;
	}

	public void setRegiNumRoma(String regiNumRoma) {
		this.regiNumRoma = regiNumRoma;
	}

	@Column(name = "REGI_DESC", nullable = false, length = 80)
	public String getRegiDesc() {
		return this.regiDesc;
	}

	public void setRegiDesc(String regiDesc) {
		this.regiDesc = regiDesc;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "genRegiones")
	public Set<GenComunasModel> getGenComunases() {
		return this.genComunases;
	}

	public void setGenComunases(Set<GenComunasModel> genComunases) {
		this.genComunases = genComunases;
	}

}
