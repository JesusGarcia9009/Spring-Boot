package com.lib.common.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

/**
 * @author BS2
 */
@Entity
@Table(name = "VTA_UBICACION", schema = "VTAPAR", uniqueConstraints = @UniqueConstraint(columnNames = { "EMPR_COD",
		"UNEG_COD", "SECT_COD", "UBIC_MOD_COD", "UBIC_SUB_MOD_COD", "UBIC_NIVEL" }))
public class VtaUbicacionModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal ubicSec;
	private int version;
	private String emprCod;
	private String unegCod;
	private String sectCod;
	private int ubicModCod;
	private int ubicSubModCod;
	private String sepuCod;
	private String ubicEstaCons;
	private String ubicIndInst;
	private String ubicUserMod;
	private Date ubicFecMod;
	private String ubicEstaCod;
	private short ubicNivel;
	private BigDecimal ubicSecContigua;
	private Set<VtaOperUbicModel> vtaOperUbics = new HashSet<VtaOperUbicModel>(0);

	public VtaUbicacionModel() {
	}

	public VtaUbicacionModel(BigDecimal ubicSec, String emprCod, String unegCod, String sectCod, int ubicModCod,
			int ubicSubModCod, String sepuCod, String ubicUserMod, Date ubicFecMod, String ubicEstaCod,
			short ubicNivel) {
		this.ubicSec = ubicSec;
		this.emprCod = emprCod;
		this.unegCod = unegCod;
		this.sectCod = sectCod;
		this.ubicModCod = ubicModCod;
		this.ubicSubModCod = ubicSubModCod;
		this.sepuCod = sepuCod;
		this.ubicUserMod = ubicUserMod;
		this.ubicFecMod = ubicFecMod;
		this.ubicEstaCod = ubicEstaCod;
		this.ubicNivel = ubicNivel;
	}

	public VtaUbicacionModel(BigDecimal ubicSec, String emprCod, String unegCod, String sectCod, int ubicModCod,
			int ubicSubModCod, String sepuCod, String ubicEstaCons, String ubicIndInst, String ubicUserMod,
			Date ubicFecMod, String ubicEstaCod, short ubicNivel, BigDecimal ubicSecContigua,
			Set<VtaOperUbicModel> vtaOperUbics) {
		this.ubicSec = ubicSec;
		this.emprCod = emprCod;
		this.unegCod = unegCod;
		this.sectCod = sectCod;
		this.ubicModCod = ubicModCod;
		this.ubicSubModCod = ubicSubModCod;
		this.sepuCod = sepuCod;
		this.ubicEstaCons = ubicEstaCons;
		this.ubicIndInst = ubicIndInst;
		this.ubicUserMod = ubicUserMod;
		this.ubicFecMod = ubicFecMod;
		this.ubicEstaCod = ubicEstaCod;
		this.ubicNivel = ubicNivel;
		this.ubicSecContigua = ubicSecContigua;
		this.vtaOperUbics = vtaOperUbics;
	}

	@Id

	@Column(name = "UBIC_SEC", unique = true, nullable = false, precision = 23, scale = 0)
	public BigDecimal getUbicSec() {
		return this.ubicSec;
	}

	public void setUbicSec(BigDecimal ubicSec) {
		this.ubicSec = ubicSec;
	}

	@Version
	@Column(name = "VERSION", nullable = false, precision = 5, scale = 0)
	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Column(name = "EMPR_COD", nullable = false, length = 10)
	public String getEmprCod() {
		return this.emprCod;
	}

	public void setEmprCod(String emprCod) {
		this.emprCod = emprCod;
	}

	@Column(name = "UNEG_COD", nullable = false, length = 10)
	public String getUnegCod() {
		return this.unegCod;
	}

	public void setUnegCod(String unegCod) {
		this.unegCod = unegCod;
	}

	@Column(name = "SECT_COD", nullable = false, length = 10)
	public String getSectCod() {
		return this.sectCod;
	}

	public void setSectCod(String sectCod) {
		this.sectCod = sectCod;
	}

	@Column(name = "UBIC_MOD_COD", nullable = false, precision = 5, scale = 0)
	public int getUbicModCod() {
		return this.ubicModCod;
	}

	public void setUbicModCod(int ubicModCod) {
		this.ubicModCod = ubicModCod;
	}

	@Column(name = "UBIC_SUB_MOD_COD", nullable = false, precision = 5, scale = 0)
	public int getUbicSubModCod() {
		return this.ubicSubModCod;
	}

	public void setUbicSubModCod(int ubicSubModCod) {
		this.ubicSubModCod = ubicSubModCod;
	}

	@Column(name = "SEPU_COD", nullable = false, length = 10)
	public String getSepuCod() {
		return this.sepuCod;
	}

	public void setSepuCod(String sepuCod) {
		this.sepuCod = sepuCod;
	}

	@Column(name = "UBIC_ESTA_CONS", length = 15)
	public String getUbicEstaCons() {
		return this.ubicEstaCons;
	}

	public void setUbicEstaCons(String ubicEstaCons) {
		this.ubicEstaCons = ubicEstaCons;
	}

	@Column(name = "UBIC_IND_INST", length = 2)
	public String getUbicIndInst() {
		return this.ubicIndInst;
	}

	public void setUbicIndInst(String ubicIndInst) {
		this.ubicIndInst = ubicIndInst;
	}

	@Column(name = "UBIC_USER_MOD", nullable = false, length = 30)
	public String getUbicUserMod() {
		return this.ubicUserMod;
	}

	public void setUbicUserMod(String ubicUserMod) {
		this.ubicUserMod = ubicUserMod;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UBIC_FEC_MOD", nullable = false, length = 7)
	public Date getUbicFecMod() {
		return this.ubicFecMod;
	}

	public void setUbicFecMod(Date ubicFecMod) {
		this.ubicFecMod = ubicFecMod;
	}

	@Column(name = "UBIC_ESTA_COD", nullable = false, length = 20)
	public String getUbicEstaCod() {
		return this.ubicEstaCod;
	}

	public void setUbicEstaCod(String ubicEstaCod) {
		this.ubicEstaCod = ubicEstaCod;
	}

	@Column(name = "UBIC_NIVEL", nullable = false, precision = 4, scale = 0)
	public short getUbicNivel() {
		return this.ubicNivel;
	}

	public void setUbicNivel(short ubicNivel) {
		this.ubicNivel = ubicNivel;
	}

	@Column(name = "UBIC_SEC_CONTIGUA", precision = 23, scale = 0)
	public BigDecimal getUbicSecContigua() {
		return this.ubicSecContigua;
	}

	public void setUbicSecContigua(BigDecimal ubicSecContigua) {
		this.ubicSecContigua = ubicSecContigua;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vtaUbicacion")
	public Set<VtaOperUbicModel> getVtaOperUbics() {
		return this.vtaOperUbics;
	}

	public void setVtaOperUbics(Set<VtaOperUbicModel> vtaOperUbics) {
		this.vtaOperUbics = vtaOperUbics;
	}

}
