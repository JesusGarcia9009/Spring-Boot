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
@Table(name = "GEN_TELEFONOS", schema = "GENPAR")
public class GenTelefonosModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal fonoSec;
	private GenPersonasModel genPersonas;
	private String fonoTipo;
	private String fonoNumero;
	private String fonoArea;
	private BigDecimal soscSec;
	private String tipoDocto;
	private BigDecimal numDocto;
	private String fonoIndCelu;
	private String fonoUserMod;
	private Date fonoFecMod;
	private String fonoNumeroResp;

	public GenTelefonosModel() {
	}

	public GenTelefonosModel(BigDecimal fonoSec, GenPersonasModel genPersonas, String fonoTipo, String fonoNumero,
			String tipoDocto, BigDecimal numDocto, String fonoUserMod, Date fonoFecMod) {
		this.fonoSec = fonoSec;
		this.genPersonas = genPersonas;
		this.fonoTipo = fonoTipo;
		this.fonoNumero = fonoNumero;
		this.tipoDocto = tipoDocto;
		this.numDocto = numDocto;
		this.fonoUserMod = fonoUserMod;
		this.fonoFecMod = fonoFecMod;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence_fono")
	@SequenceGenerator(name = "id_sequence_fono", allocationSize = 1, sequenceName = "GEN_FONO_SEC", schema = "GENPAR")
	@Column(name = "FONO_SEC", unique = true, nullable = false, precision = 23, scale = 0)
	public BigDecimal getFonoSec() {
		return this.fonoSec;
	}

	public void setFonoSec(BigDecimal fonoSec) {
		this.fonoSec = fonoSec;
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

	@Column(name = "FONO_TIPO", nullable = false, length = 5)
	public String getFonoTipo() {
		return this.fonoTipo;
	}

	public void setFonoTipo(String fonoTipo) {
		this.fonoTipo = fonoTipo;
	}

	@Column(name = "FONO_NUMERO", nullable = false, length = 20)
	public String getFonoNumero() {
		return this.fonoNumero;
	}

	public void setFonoNumero(String fonoNumero) {
		this.fonoNumero = fonoNumero;
	}

	@Column(name = "FONO_AREA", length = 30)
	public String getFonoArea() {
		return this.fonoArea;
	}

	public void setFonoArea(String fonoArea) {
		this.fonoArea = fonoArea;
	}

	@Column(name = "SOSC_SEC", precision = 23, scale = 0)
	public BigDecimal getSoscSec() {
		return this.soscSec;
	}

	public void setSoscSec(BigDecimal soscSec) {
		this.soscSec = soscSec;
	}

	@Column(name = "TIPO_DOCTO", nullable = false, length = 20)
	public String getTipoDocto() {
		return this.tipoDocto;
	}

	public void setTipoDocto(String tipoDocto) {
		this.tipoDocto = tipoDocto;
	}

	@Column(name = "NUM_DOCTO", nullable = false, precision = 23, scale = 0)
	public BigDecimal getNumDocto() {
		return this.numDocto;
	}

	public void setNumDocto(BigDecimal numDocto) {
		this.numDocto = numDocto;
	}

	@Column(name = "FONO_IND_CELU", length = 2)
	public String getFonoIndCelu() {
		return this.fonoIndCelu;
	}

	public void setFonoIndCelu(String fonoIndCelu) {
		this.fonoIndCelu = fonoIndCelu;
	}

	@Column(name = "FONO_USER_MOD", nullable = false, length = 30)
	public String getFonoUserMod() {
		return this.fonoUserMod;
	}

	public void setFonoUserMod(String fonoUserMod) {
		this.fonoUserMod = fonoUserMod;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FONO_FEC_MOD", nullable = false, length = 7)
	public Date getFonoFecMod() {
		return this.fonoFecMod;
	}

	public void setFonoFecMod(Date fonoFecMod) {
		this.fonoFecMod = fonoFecMod;
	}

	@Column(name = "FONO_NUMERO_RESP", length = 50)
	public String getFonoNumeroResp() {
		return this.fonoNumeroResp;
	}

	public void setFonoNumeroResp(String fonoNumeroResp) {
		this.fonoNumeroResp = fonoNumeroResp;
	}

}
