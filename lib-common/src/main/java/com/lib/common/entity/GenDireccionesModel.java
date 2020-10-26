package com.lib.common.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author BS2
 */
@Entity
@Table(name = "GEN_DIRECCIONES", schema = "GENPAR")
public class GenDireccionesModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal direSec;
	private GenComunasModel genComunas;
	private GenPersonasModel genPersonas;
	private String direTipo;
	private String direCalle;
	private String direNumero;
	private String direRestoDire;
	private String direCodPostal;
	private String direNac;
	private String direPais;
	private String direEstaCod;
	private String direIndVerif;
	private Date direFecVerif;
	private BigDecimal soscSec;
	private BigDecimal contNumOpe;
	private BigDecimal reinSec;
	private String direUserMod;
	private Date direFecMod;
	private String tipoDocto;
	private BigDecimal numDocto;
	private String direIndEnvCorr;

	public GenDireccionesModel() {
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence_fono")
	@SequenceGenerator(name = "id_sequence_fono", allocationSize = 1, sequenceName = "GEN_DIRE_SEC", schema = "GENPAR")
	@Column(name = "DIRE_SEC", unique = true, nullable = false, precision = 23, scale = 0)
	public BigDecimal getDireSec() {
		return this.direSec;
	}

	public void setDireSec(BigDecimal direSec) {
		this.direSec = direSec;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMU_COD")
	public GenComunasModel getGenComunas() {
		return this.genComunas;
	}

	public void setGenComunas(GenComunasModel genComunas) {
		this.genComunas = genComunas;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "PERS_TIPO_ID", referencedColumnName = "PERS_TIPO_ID", nullable = false),
			@JoinColumn(name = "PERS_ID", referencedColumnName = "PERS_ID", nullable = false) })
	public GenPersonasModel getGenPersonas() {
		return this.genPersonas;
	}

	public void setGenPersonas(GenPersonasModel genPersonas) {
		this.genPersonas = genPersonas;
	}

	@Column(name = "DIRE_TIPO", nullable = false, length = 5)
	public String getDireTipo() {
		return this.direTipo;
	}

	public void setDireTipo(String direTipo) {
		this.direTipo = direTipo;
	}

	@Column(name = "DIRE_CALLE", length = 100)
	public String getDireCalle() {
		return this.direCalle;
	}

	public void setDireCalle(String direCalle) {
		this.direCalle = direCalle;
	}

	@Column(name = "DIRE_NUMERO", length = 20)
	public String getDireNumero() {
		return this.direNumero;
	}

	public void setDireNumero(String direNumero) {
		this.direNumero = direNumero;
	}

	@Column(name = "DIRE_RESTO_DIRE", length = 30)
	public String getDireRestoDire() {
		return this.direRestoDire;
	}

	public void setDireRestoDire(String direRestoDire) {
		this.direRestoDire = direRestoDire;
	}

	@Column(name = "DIRE_COD_POSTAL", length = 15)
	public String getDireCodPostal() {
		return this.direCodPostal;
	}

	public void setDireCodPostal(String direCodPostal) {
		this.direCodPostal = direCodPostal;
	}

	@Column(name = "DIRE_NAC", nullable = false, length = 1)
	public String getDireNac() {
		return this.direNac;
	}

	public void setDireNac(String direNac) {
		this.direNac = direNac;
	}

	@Column(name = "DIRE_PAIS", length = 20)
	public String getDirePais() {
		return this.direPais;
	}

	public void setDirePais(String direPais) {
		this.direPais = direPais;
	}

	@Column(name = "DIRE_ESTA_COD", nullable = false, length = 20)
	public String getDireEstaCod() {
		return this.direEstaCod;
	}

	public void setDireEstaCod(String direEstaCod) {
		this.direEstaCod = direEstaCod;
	}

	@Column(name = "DIRE_IND_VERIF", length = 20)
	public String getDireIndVerif() {
		return this.direIndVerif;
	}

	public void setDireIndVerif(String direIndVerif) {
		this.direIndVerif = direIndVerif;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DIRE_FEC_VERIF", length = 7)
	public Date getDireFecVerif() {
		return this.direFecVerif;
	}

	public void setDireFecVerif(Date direFecVerif) {
		this.direFecVerif = direFecVerif;
	}

	@Column(name = "SOSC_SEC", precision = 23, scale = 0)
	public BigDecimal getSoscSec() {
		return this.soscSec;
	}

	public void setSoscSec(BigDecimal soscSec) {
		this.soscSec = soscSec;
	}

	@Column(name = "CONT_NUM_OPE", precision = 23, scale = 0)
	public BigDecimal getContNumOpe() {
		return this.contNumOpe;
	}

	public void setContNumOpe(BigDecimal contNumOpe) {
		this.contNumOpe = contNumOpe;
	}

	@Column(name = "REIN_SEC", precision = 23, scale = 0)
	public BigDecimal getReinSec() {
		return this.reinSec;
	}

	public void setReinSec(BigDecimal reinSec) {
		this.reinSec = reinSec;
	}

	@Column(name = "DIRE_USER_MOD", length = 30)
	public String getDireUserMod() {
		return this.direUserMod;
	}

	public void setDireUserMod(String direUserMod) {
		this.direUserMod = direUserMod;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DIRE_FEC_MOD", length = 7)
	public Date getDireFecMod() {
		return this.direFecMod;
	}

	public void setDireFecMod(Date direFecMod) {
		this.direFecMod = direFecMod;
	}

	@Column(name = "TIPO_DOCTO", length = 20)
	public String getTipoDocto() {
		return this.tipoDocto;
	}

	public void setTipoDocto(String tipoDocto) {
		this.tipoDocto = tipoDocto;
	}

	@Column(name = "NUM_DOCTO", precision = 23, scale = 0)
	public BigDecimal getNumDocto() {
		return this.numDocto;
	}

	public void setNumDocto(BigDecimal numDocto) {
		this.numDocto = numDocto;
	}

	@Column(name = "DIRE_IND_ENV_CORR", length = 2)
	public String getDireIndEnvCorr() {
		return this.direIndEnvCorr;
	}

	public void setDireIndEnvCorr(String direIndEnvCorr) {
		this.direIndEnvCorr = direIndEnvCorr;
	}
}
