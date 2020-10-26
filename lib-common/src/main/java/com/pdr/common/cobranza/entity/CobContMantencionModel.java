package com.pdr.common.cobranza.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * @author BS2
 */
@Entity
@Table(name = "COB_CONT_MANTENCION", schema = "COBPAR", uniqueConstraints = @UniqueConstraint(columnNames = "VTOP_COD_CONT"))
public class CobContMantencionModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CobContMantencionIdModel id;
	private GenPersonasModel genPersonas;
	private VtaContratosModel vtaContratos;
	private Date mantFechPrimCuot;
	private BigDecimal mantValCuot;
	private Integer ntsgPrdoPrim;
	private Integer ntsgPrdoCodCobertura;
	private String mantEstaCod;
	private String plzaMantModo;
	private String mantEstaCodSeguro;
	private String indReaj;
	private Set<CobContMantCuotaModel> cobContMantCuotas = new HashSet<CobContMantCuotaModel>(0);

	public CobContMantencionModel() {
	}

	public CobContMantencionModel(CobContMantencionIdModel id, GenPersonasModel genPersonas, VtaContratosModel vtaContratos,
			Date mantFechPrimCuot, BigDecimal mantValCuot, String mantEstaCod, String mantEstaCodSeguro) {
		this.id = id;
		this.genPersonas = genPersonas;
		this.vtaContratos = vtaContratos;
		this.mantFechPrimCuot = mantFechPrimCuot;
		this.mantValCuot = mantValCuot;
		this.mantEstaCod = mantEstaCod;
		this.mantEstaCodSeguro = mantEstaCodSeguro;
	}

	public CobContMantencionModel(CobContMantencionIdModel id, GenPersonasModel genPersonas, VtaContratosModel vtaContratos,
			Date mantFechPrimCuot, BigDecimal mantValCuot, Integer ntsgPrdoPrim, Integer ntsgPrdoCodCobertura,
			String mantEstaCod, String plzaMantModo, String mantEstaCodSeguro, String indReaj,
			Set<CobContMantCuotaModel> cobContMantCuotas) {
		this.id = id;
		this.genPersonas = genPersonas;
		this.vtaContratos = vtaContratos;
		this.mantFechPrimCuot = mantFechPrimCuot;
		this.mantValCuot = mantValCuot;
		this.ntsgPrdoPrim = ntsgPrdoPrim;
		this.ntsgPrdoCodCobertura = ntsgPrdoCodCobertura;
		this.mantEstaCod = mantEstaCod;
		this.plzaMantModo = plzaMantModo;
		this.mantEstaCodSeguro = mantEstaCodSeguro;
		this.indReaj = indReaj;
		this.cobContMantCuotas = cobContMantCuotas;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "vtopCodCont", column = @Column(name = "VTOP_COD_CONT", unique = true, nullable = false, precision = 23, scale = 0)),
			@AttributeOverride(name = "emprCodAdm", column = @Column(name = "EMPR_COD_ADM", nullable = false, length = 10)),
			@AttributeOverride(name = "unegCod", column = @Column(name = "UNEG_COD", nullable = false, length = 10)),
			@AttributeOverride(name = "vtopCod", column = @Column(name = "VTOP_COD", nullable = false, precision = 23, scale = 0)) })
	public CobContMantencionIdModel getId() {
		return this.id;
	}

	public void setId(CobContMantencionIdModel id) {
		this.id = id;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VTOP_COD_CONT", unique = true, nullable = false, insertable = false, updatable = false)
	public VtaContratosModel getVtaContratos() {
		return this.vtaContratos;
	}

	public void setVtaContratos(VtaContratosModel vtaContratos) {
		this.vtaContratos = vtaContratos;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "MANT_FECH_PRIM_CUOT", nullable = false, length = 7)
	public Date getMantFechPrimCuot() {
		return this.mantFechPrimCuot;
	}

	public void setMantFechPrimCuot(Date mantFechPrimCuot) {
		this.mantFechPrimCuot = mantFechPrimCuot;
	}

	@Column(name = "MANT_VAL_CUOT", nullable = false, precision = 14)
	public BigDecimal getMantValCuot() {
		return this.mantValCuot;
	}

	public void setMantValCuot(BigDecimal mantValCuot) {
		this.mantValCuot = mantValCuot;
	}

	@Column(name = "NTSG_PRDO_PRIM", precision = 6, scale = 0)
	public Integer getNtsgPrdoPrim() {
		return this.ntsgPrdoPrim;
	}

	public void setNtsgPrdoPrim(Integer ntsgPrdoPrim) {
		this.ntsgPrdoPrim = ntsgPrdoPrim;
	}

	@Column(name = "NTSG_PRDO_COD_COBERTURA", precision = 6, scale = 0)
	public Integer getNtsgPrdoCodCobertura() {
		return this.ntsgPrdoCodCobertura;
	}

	public void setNtsgPrdoCodCobertura(Integer ntsgPrdoCodCobertura) {
		this.ntsgPrdoCodCobertura = ntsgPrdoCodCobertura;
	}

	@Column(name = "MANT_ESTA_COD", nullable = false, length = 20)
	public String getMantEstaCod() {
		return this.mantEstaCod;
	}

	public void setMantEstaCod(String mantEstaCod) {
		this.mantEstaCod = mantEstaCod;
	}

	@Column(name = "PLZA_MANT_MODO", length = 20)
	public String getPlzaMantModo() {
		return this.plzaMantModo;
	}

	public void setPlzaMantModo(String plzaMantModo) {
		this.plzaMantModo = plzaMantModo;
	}

	@Column(name = "MANT_ESTA_COD_SEGURO", nullable = false, length = 20)
	public String getMantEstaCodSeguro() {
		return this.mantEstaCodSeguro;
	}

	public void setMantEstaCodSeguro(String mantEstaCodSeguro) {
		this.mantEstaCodSeguro = mantEstaCodSeguro;
	}

	@Column(name = "IND_REAJ", length = 2)
	public String getIndReaj() {
		return this.indReaj;
	}

	public void setIndReaj(String indReaj) {
		this.indReaj = indReaj;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cobContMantencion")
	public Set<CobContMantCuotaModel> getCobContMantCuotas() {
		return this.cobContMantCuotas;
	}

	public void setCobContMantCuotas(Set<CobContMantCuotaModel> cobContMantCuotas) {
		this.cobContMantCuotas = cobContMantCuotas;
	}

}
