package com.pdr.common.cobranza.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author BS2
 */
@Entity
@Table(name = "GEN_VAL_CONV_MOND", schema = "GENPAR")
public class GenValConvMondModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GenValConvMondIdModel id;
	private BigDecimal comoValor;
	private String comoUserMod;
	private Date comoFecMod;
	private String comoEstaCod;

	public GenValConvMondModel() {
	}

	public GenValConvMondModel(GenValConvMondIdModel id, BigDecimal comoValor, String comoUserMod, Date comoFecMod,
			String comoEstaCod) {
		this.id = id;
		this.comoValor = comoValor;
		this.comoUserMod = comoUserMod;
		this.comoFecMod = comoFecMod;
		this.comoEstaCod = comoEstaCod;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "moneCod", column = @Column(name = "MONE_COD", nullable = false, length = 10)),
			@AttributeOverride(name = "comoFech", column = @Column(name = "COMO_FECH", nullable = false, length = 7)) })
	public GenValConvMondIdModel getId() {
		return this.id;
	}

	public void setId(GenValConvMondIdModel id) {
		this.id = id;
	}

	@Column(name = "COMO_VALOR", nullable = false, precision = 14, scale = 4)
	public BigDecimal getComoValor() {
		return this.comoValor;
	}

	public void setComoValor(BigDecimal comoValor) {
		this.comoValor = comoValor;
	}

	@Column(name = "COMO_USER_MOD", nullable = false, length = 30)
	public String getComoUserMod() {
		return this.comoUserMod;
	}

	public void setComoUserMod(String comoUserMod) {
		this.comoUserMod = comoUserMod;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "COMO_FEC_MOD", nullable = false, length = 7)
	public Date getComoFecMod() {
		return this.comoFecMod;
	}

	public void setComoFecMod(Date comoFecMod) {
		this.comoFecMod = comoFecMod;
	}

	@Column(name = "COMO_ESTA_COD", nullable = false, length = 10)
	public String getComoEstaCod() {
		return this.comoEstaCod;
	}

	public void setComoEstaCod(String comoEstaCod) {
		this.comoEstaCod = comoEstaCod;
	}

}
