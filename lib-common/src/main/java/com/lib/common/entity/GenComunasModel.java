package com.lib.common.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author BS2
 */
@Entity
@Table(name = "GEN_COMUNAS", schema = "GENPAR")
public class GenComunasModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String comuCod;
	private GenRegionesModel genRegiones;
	private String ciudCod;
	private String comuDesc;
	private Set<GenDireccionesModel> genDireccioneses = new HashSet<GenDireccionesModel>(0);
	private Set<GenUnidNegociosModel> genUnidNegocioses = new HashSet<GenUnidNegociosModel>(0);

	public GenComunasModel() {
	}

	public GenComunasModel(String comuCod, GenRegionesModel genRegiones) {
		this.comuCod = comuCod;
		this.genRegiones = genRegiones;
	}

	public GenComunasModel(String comuCod, GenRegionesModel genRegiones, String ciudCod, String comuDesc,
			Set<GenDireccionesModel> genDireccioneses, Set<GenUnidNegociosModel> genUnidNegocioses) {
		this.comuCod = comuCod;
		this.genRegiones = genRegiones;
		this.ciudCod = ciudCod;
		this.comuDesc = comuDesc;
		this.genDireccioneses = genDireccioneses;
		this.genUnidNegocioses = genUnidNegocioses;
	}

	@Id

	@Column(name = "COMU_COD", unique = true, nullable = false, length = 20)
	public String getComuCod() {
		return this.comuCod;
	}

	public void setComuCod(String comuCod) {
		this.comuCod = comuCod;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REGI_COD", nullable = false)
	public GenRegionesModel getGenRegiones() {
		return this.genRegiones;
	}

	public void setGenRegiones(GenRegionesModel genRegiones) {
		this.genRegiones = genRegiones;
	}

	@Column(name = "CIUD_COD", length = 30)
	public String getCiudCod() {
		return this.ciudCod;
	}

	public void setCiudCod(String ciudCod) {
		this.ciudCod = ciudCod;
	}

	@Column(name = "COMU_DESC", length = 30)
	public String getComuDesc() {
		return this.comuDesc;
	}

	public void setComuDesc(String comuDesc) {
		this.comuDesc = comuDesc;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "genComunas")
	public Set<GenDireccionesModel> getGenDireccioneses() {
		return this.genDireccioneses;
	}

	public void setGenDireccioneses(Set<GenDireccionesModel> genDireccioneses) {
		this.genDireccioneses = genDireccioneses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "genComunas")
	public Set<GenUnidNegociosModel> getGenUnidNegocioses() {
		return this.genUnidNegocioses;
	}

	public void setGenUnidNegocioses(Set<GenUnidNegociosModel> genUnidNegocioses) {
		this.genUnidNegocioses = genUnidNegocioses;
	}

}
