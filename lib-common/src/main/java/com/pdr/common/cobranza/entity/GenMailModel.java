package com.pdr.common.cobranza.entity;

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author BS2
 */
@Entity
@Table(name = "GEN_MAIL", schema = "GENPAR")
public class GenMailModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GenMailIdModel id;
	private GenPersonasModel genPersonas;
	private String mailEmail;
	private String mailUserMod;
	private Date mailFecMod;

	public GenMailModel() {
	}

	public GenMailModel(GenMailIdModel id, GenPersonasModel genPersonas, String mailEmail) {
		this.id = id;
		this.genPersonas = genPersonas;
		this.mailEmail = mailEmail;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "persTipoId", column = @Column(name = "PERS_TIPO_ID", nullable = false, length = 4)),
			@AttributeOverride(name = "persId", column = @Column(name = "PERS_ID", nullable = false, length = 10)),
			@AttributeOverride(name = "tipoDocto", column = @Column(name = "TIPO_DOCTO", nullable = false, length = 20)),
			@AttributeOverride(name = "numDocto", column = @Column(name = "NUM_DOCTO", nullable = false, precision = 23, scale = 0)) })
	public GenMailIdModel getId() {
		return this.id;
	}

	public void setId(GenMailIdModel id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "PERS_TIPO_ID", referencedColumnName = "PERS_TIPO_ID", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "PERS_ID", referencedColumnName = "PERS_ID", nullable = false, insertable = false, updatable = false) })
	public GenPersonasModel getGenPersonas() {
		return this.genPersonas;
	}

	public void setGenPersonas(GenPersonasModel genPersonas) {
		this.genPersonas = genPersonas;
	}

	@Column(name = "MAIL_EMAIL", nullable = false, length = 80)
	public String getMailEmail() {
		return this.mailEmail;
	}

	public void setMailEmail(String mailEmail) {
		this.mailEmail = mailEmail;
	}

	@Column(name = "MAIL_USER_MOD", length = 30)
	public String getMailUserMod() {
		return this.mailUserMod;
	}

	public void setMailUserMod(String mailUserMod) {
		this.mailUserMod = mailUserMod;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "MAIL_FEC_MOD", length = 7)
	public Date getMailFecMod() {
		return this.mailFecMod;
	}

	public void setMailFecMod(Date mailFecMod) {
		this.mailFecMod = mailFecMod;
	}
}
