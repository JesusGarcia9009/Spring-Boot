package com.pdr.common.cobranza.entity;

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

/**
 * @author BS2
 */
@Entity
@Table(name = "COB_CAMPAGNA", schema = "COBPAR")
public class CobCampagnaModel implements java.io.Serializable {

	private static final long serialVersionUID = 7586500025348608150L;
	private String campCod;
	private String campDescLarga;
	private String campDescCort;
	private String campIndDefault;
	private String campIndIntMora;
	private String campIndGtosReneg;
	private String campIndPagoCuot;
	private BigDecimal campTasaUf;
	private BigDecimal campTasaPeso;
	private byte campCantPgre;
	private String campIndOtros;
	private String campEstaCod;
	private String campUserMod;
	private Date campFecMod;
	private String campIndMediaCuot;
	private short campNumCuotMax;
	private short campCuotPrimerPgre;
	private String campIndModifCamp;
	private Set<CobCampContModel> cobCampConts = new HashSet<>(0);

	public CobCampagnaModel() {
	}

	public CobCampagnaModel(String campCod, String campDescLarga, String campDescCort, String campIndDefault,
			String campIndIntMora, String campIndGtosReneg, String campIndPagoCuot, BigDecimal campTasaUf,
			BigDecimal campTasaPeso, byte campCantPgre, String campIndOtros, String campEstaCod, String campUserMod,
			Date campFecMod, String campIndMediaCuot, short campNumCuotMax, short campCuotPrimerPgre) {
		this.campCod = campCod;
		this.campDescLarga = campDescLarga;
		this.campDescCort = campDescCort;
		this.campIndDefault = campIndDefault;
		this.campIndIntMora = campIndIntMora;
		this.campIndGtosReneg = campIndGtosReneg;
		this.campIndPagoCuot = campIndPagoCuot;
		this.campTasaUf = campTasaUf;
		this.campTasaPeso = campTasaPeso;
		this.campCantPgre = campCantPgre;
		this.campIndOtros = campIndOtros;
		this.campEstaCod = campEstaCod;
		this.campUserMod = campUserMod;
		this.campFecMod = campFecMod;
		this.campIndMediaCuot = campIndMediaCuot;
		this.campNumCuotMax = campNumCuotMax;
		this.campCuotPrimerPgre = campCuotPrimerPgre;
	}

	@Id
	@Column(name = "CAMP_COD", unique = true, nullable = false, length = 20)
	public String getCampCod() {
		return this.campCod;
	}

	public void setCampCod(String campCod) {
		this.campCod = campCod;
	}

	@Column(name = "CAMP_DESC_LARGA", nullable = false, length = 100)
	public String getCampDescLarga() {
		return this.campDescLarga;
	}

	public void setCampDescLarga(String campDescLarga) {
		this.campDescLarga = campDescLarga;
	}

	@Column(name = "CAMP_DESC_CORT", nullable = false, length = 50)
	public String getCampDescCort() {
		return this.campDescCort;
	}

	public void setCampDescCort(String campDescCort) {
		this.campDescCort = campDescCort;
	}

	@Column(name = "CAMP_IND_DEFAULT", nullable = false, length = 2)
	public String getCampIndDefault() {
		return this.campIndDefault;
	}

	public void setCampIndDefault(String campIndDefault) {
		this.campIndDefault = campIndDefault;
	}

	@Column(name = "CAMP_IND_INT_MORA", nullable = false, length = 2)
	public String getCampIndIntMora() {
		return this.campIndIntMora;
	}

	public void setCampIndIntMora(String campIndIntMora) {
		this.campIndIntMora = campIndIntMora;
	}

	@Column(name = "CAMP_IND_GTOS_RENEG", nullable = false, length = 2)
	public String getCampIndGtosReneg() {
		return this.campIndGtosReneg;
	}

	public void setCampIndGtosReneg(String campIndGtosReneg) {
		this.campIndGtosReneg = campIndGtosReneg;
	}

	@Column(name = "CAMP_IND_PAGO_CUOT", nullable = false, length = 2)
	public String getCampIndPagoCuot() {
		return this.campIndPagoCuot;
	}

	public void setCampIndPagoCuot(String campIndPagoCuot) {
		this.campIndPagoCuot = campIndPagoCuot;
	}

	@Column(name = "CAMP_TASA_UF", nullable = false, precision = 4)
	public BigDecimal getCampTasaUf() {
		return this.campTasaUf;
	}

	public void setCampTasaUf(BigDecimal campTasaUf) {
		this.campTasaUf = campTasaUf;
	}

	@Column(name = "CAMP_TASA_PESO", nullable = false, precision = 4)
	public BigDecimal getCampTasaPeso() {
		return this.campTasaPeso;
	}

	public void setCampTasaPeso(BigDecimal campTasaPeso) {
		this.campTasaPeso = campTasaPeso;
	}

	@Column(name = "CAMP_CANT_PGRE", nullable = false, precision = 2, scale = 0)
	public byte getCampCantPgre() {
		return this.campCantPgre;
	}

	public void setCampCantPgre(byte campCantPgre) {
		this.campCantPgre = campCantPgre;
	}

	@Column(name = "CAMP_IND_OTROS", nullable = false, length = 2)
	public String getCampIndOtros() {
		return this.campIndOtros;
	}

	public void setCampIndOtros(String campIndOtros) {
		this.campIndOtros = campIndOtros;
	}

	@Column(name = "CAMP_ESTA_COD", nullable = false, length = 10)
	public String getCampEstaCod() {
		return this.campEstaCod;
	}

	public void setCampEstaCod(String campEstaCod) {
		this.campEstaCod = campEstaCod;
	}

	@Column(name = "CAMP_USER_MOD", nullable = false, length = 30)
	public String getCampUserMod() {
		return this.campUserMod;
	}

	public void setCampUserMod(String campUserMod) {
		this.campUserMod = campUserMod;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CAMP_FEC_MOD", nullable = false, length = 7)
	public Date getCampFecMod() {
		return this.campFecMod;
	}

	public void setCampFecMod(Date campFecMod) {
		this.campFecMod = campFecMod;
	}

	@Column(name = "CAMP_IND_MEDIA_CUOT", nullable = false, length = 2)
	public String getCampIndMediaCuot() {
		return this.campIndMediaCuot;
	}

	public void setCampIndMediaCuot(String campIndMediaCuot) {
		this.campIndMediaCuot = campIndMediaCuot;
	}

	@Column(name = "CAMP_NUM_CUOT_MAX", nullable = false, precision = 3, scale = 0)
	public short getCampNumCuotMax() {
		return this.campNumCuotMax;
	}

	public void setCampNumCuotMax(short campNumCuotMax) {
		this.campNumCuotMax = campNumCuotMax;
	}

	@Column(name = "CAMP_CUOT_PRIMER_PGRE", nullable = false, precision = 3, scale = 0)
	public short getCampCuotPrimerPgre() {
		return this.campCuotPrimerPgre;
	}

	public void setCampCuotPrimerPgre(short campCuotPrimerPgre) {
		this.campCuotPrimerPgre = campCuotPrimerPgre;
	}

	@Column(name = "CAMP_IND_MODIF_CAMP", length = 2)
	public String getCampIndModifCamp() {
		return this.campIndModifCamp;
	}

	public void setCampIndModifCamp(String campIndModifCamp) {
		this.campIndModifCamp = campIndModifCamp;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cobCampagna")
	public Set<CobCampContModel> getCobCampConts() {
		return this.cobCampConts;
	}

	public void setCobCampConts(Set<CobCampContModel> cobCampConts) {
		this.cobCampConts = cobCampConts;
	}

}
