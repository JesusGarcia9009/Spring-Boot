package com.pdr.common.cobranza.entity;

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
 * @author BS2
 */
@Entity
@Table(name = "GEN_EMPR_UNEG", schema = "GENPAR")
public class GenEmprUnegModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5408638099939486127L;
	private GenEmprUnegIdModel id;
	private GenUnidNegociosModel genUnidNegocios;
	private GenEmpresasModel genEmpresas;
	private String emegTipo;

	public GenEmprUnegModel() {
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "emprCod", column = @Column(name = "EMPR_COD", nullable = false, length = 10)),
			@AttributeOverride(name = "unegCod", column = @Column(name = "UNEG_COD", nullable = false, length = 10)) })
	public GenEmprUnegIdModel getId() {
		return this.id;
	}

	public void setId(GenEmprUnegIdModel id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UNEG_COD", nullable = false, insertable = false, updatable = false)
	public GenUnidNegociosModel getGenUnidNegocios() {
		return this.genUnidNegocios;
	}

	public void setGenUnidNegocios(GenUnidNegociosModel genUnidNegocios) {
		this.genUnidNegocios = genUnidNegocios;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMPR_COD", nullable = false, insertable = false, updatable = false)
	public GenEmpresasModel getGenEmpresas() {
		return this.genEmpresas;
	}

	public void setGenEmpresas(GenEmpresasModel genEmpresas) {
		this.genEmpresas = genEmpresas;
	}

	@Column(name = "EMEG_TIPO", nullable = false, length = 10)
	public String getEmegTipo() {
		return this.emegTipo;
	}

	public void setEmegTipo(String emegTipo) {
		this.emegTipo = emegTipo;
	}

}
