package com.lib.common.entity;

import java.math.BigDecimal;
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
 * BS2
 */
@Entity
@Table(name = "CBZ_ARBOL_GESTION", schema = "CBZPAR")
public class CbzArbolGestionModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal idArbolGestion;
	private CbzArbolGestionVersionModel cbzArbolGestionVersion;
	private CbzArbolGestionValorModel cbzArbolGestionValor;
	private CbzArbolGestionTipoDatoModel cbzArbolGestionTipoDato;
	private CbzCanalesModel cbzCanales;
	private CbzArbolGestionTitulosModel cbzArbolGestionTitulos;
	private String arbolDescripcion;
	private int idArbolGestionParent;
	private Boolean arbolResultadoGestion;
	private BigDecimal arbolAttrEliminado;
	private Boolean arbolEsPadre;
	private Boolean flagProximaGestion;
	private Boolean flagObservacion;
	private Boolean flagMotorista;
	private String arbolCartera;
	private Set<CbzResultadoArbolGestionModel> cbzResultadoArbolGestions = new HashSet<CbzResultadoArbolGestionModel>(0);

	public CbzArbolGestionModel() {
	}

	public CbzArbolGestionModel(BigDecimal idArbolGestion, CbzArbolGestionVersionModel cbzArbolGestionVersion, CbzCanalesModel cbzCanales,
			int idArbolGestionParent, BigDecimal arbolAttrEliminado) {
		this.idArbolGestion = idArbolGestion;
		this.cbzArbolGestionVersion = cbzArbolGestionVersion;
		this.cbzCanales = cbzCanales;
		this.idArbolGestionParent = idArbolGestionParent;
		this.arbolAttrEliminado = arbolAttrEliminado;
	}

	public CbzArbolGestionModel(BigDecimal idArbolGestion, CbzArbolGestionVersionModel cbzArbolGestionVersion,
			CbzArbolGestionValorModel cbzArbolGestionValor, CbzArbolGestionTipoDatoModel cbzArbolGestionTipoDato,
			CbzCanalesModel cbzCanales, CbzArbolGestionTitulosModel cbzArbolGestionTitulos, String arbolDescripcion,
			int idArbolGestionParent, Boolean arbolResultadoGestion, BigDecimal arbolAttrEliminado,
			Boolean arbolEsPadre, Boolean flagProximaGestion, Boolean flagObservacion, String arbolCartera,
			Set<CbzResultadoArbolGestionModel> cbzResultadoArbolGestions) {
		this.idArbolGestion = idArbolGestion;
		this.cbzArbolGestionVersion = cbzArbolGestionVersion;
		this.cbzArbolGestionValor = cbzArbolGestionValor;
		this.cbzArbolGestionTipoDato = cbzArbolGestionTipoDato;
		this.cbzCanales = cbzCanales;
		this.cbzArbolGestionTitulos = cbzArbolGestionTitulos;
		this.arbolDescripcion = arbolDescripcion;
		this.idArbolGestionParent = idArbolGestionParent;
		this.arbolResultadoGestion = arbolResultadoGestion;
		this.arbolAttrEliminado = arbolAttrEliminado;
		this.arbolEsPadre = arbolEsPadre;
		this.flagProximaGestion = flagProximaGestion;
		this.flagObservacion = flagObservacion;
		this.arbolCartera = arbolCartera;
		this.cbzResultadoArbolGestions = cbzResultadoArbolGestions;
	}

	@Id

	@Column(name = "ID_ARBOL_GESTION", unique = true, nullable = false, precision = 8, scale = 0)
	public BigDecimal getIdArbolGestion() {
		return this.idArbolGestion;
	}

	public void setIdArbolGestion(BigDecimal idArbolGestion) {
		this.idArbolGestion = idArbolGestion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ARB_GEST_VERSION", nullable = false)
	public CbzArbolGestionVersionModel getCbzArbolGestionVersion() {
		return this.cbzArbolGestionVersion;
	}

	public void setCbzArbolGestionVersion(CbzArbolGestionVersionModel cbzArbolGestionVersion) {
		this.cbzArbolGestionVersion = cbzArbolGestionVersion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ARBOL_VALOR")
	public CbzArbolGestionValorModel getCbzArbolGestionValor() {
		return this.cbzArbolGestionValor;
	}

	public void setCbzArbolGestionValor(CbzArbolGestionValorModel cbzArbolGestionValor) {
		this.cbzArbolGestionValor = cbzArbolGestionValor;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ARB_TIPO_DATO")
	public CbzArbolGestionTipoDatoModel getCbzArbolGestionTipoDato() {
		return this.cbzArbolGestionTipoDato;
	}

	public void setCbzArbolGestionTipoDato(CbzArbolGestionTipoDatoModel cbzArbolGestionTipoDato) {
		this.cbzArbolGestionTipoDato = cbzArbolGestionTipoDato;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CANAL", nullable = false)
	public CbzCanalesModel getCbzCanales() {
		return this.cbzCanales;
	}

	public void setCbzCanales(CbzCanalesModel cbzCanales) {
		this.cbzCanales = cbzCanales;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ARBOL_TITULOS")
	public CbzArbolGestionTitulosModel getCbzArbolGestionTitulos() {
		return this.cbzArbolGestionTitulos;
	}

	public void setCbzArbolGestionTitulos(CbzArbolGestionTitulosModel cbzArbolGestionTitulos) {
		this.cbzArbolGestionTitulos = cbzArbolGestionTitulos;
	}

	@Column(name = "ARBOL_DESCRIPCION", length = 100)
	public String getArbolDescripcion() {
		return this.arbolDescripcion;
	}

	public void setArbolDescripcion(String arbolDescripcion) {
		this.arbolDescripcion = arbolDescripcion;
	}

	@Column(name = "ID_ARBOL_GESTION_PARENT", nullable = false, precision = 8, scale = 0)
	public int getIdArbolGestionParent() {
		return this.idArbolGestionParent;
	}

	public void setIdArbolGestionParent(int idArbolGestionParent) {
		this.idArbolGestionParent = idArbolGestionParent;
	}

	@Column(name = "ARBOL_RESULTADO_GESTION", precision = 1, scale = 0)
	public Boolean getArbolResultadoGestion() {
		return this.arbolResultadoGestion;
	}

	public void setArbolResultadoGestion(Boolean arbolResultadoGestion) {
		this.arbolResultadoGestion = arbolResultadoGestion;
	}

	@Column(name = "ARBOL_ATTR_ELIMINADO", nullable = false, precision = 22, scale = 0)
	public BigDecimal getArbolAttrEliminado() {
		return this.arbolAttrEliminado;
	}

	public void setArbolAttrEliminado(BigDecimal arbolAttrEliminado) {
		this.arbolAttrEliminado = arbolAttrEliminado;
	}

	@Column(name = "ARBOL_ES_PADRE", precision = 1, scale = 0)
	public Boolean getArbolEsPadre() {
		return this.arbolEsPadre;
	}

	public void setArbolEsPadre(Boolean arbolEsPadre) {
		this.arbolEsPadre = arbolEsPadre;
	}

	@Column(name = "FLAG_PROXIMA_GESTION", precision = 1, scale = 0)
	public Boolean getFlagProximaGestion() {
		return this.flagProximaGestion;
	}

	public void setFlagProximaGestion(Boolean flagProximaGestion) {
		this.flagProximaGestion = flagProximaGestion;
	}

	@Column(name = "FLAG_OBSERVACION", precision = 1, scale = 0)
	public Boolean getFlagObservacion() {
		return this.flagObservacion;
	}

	public void setFlagObservacion(Boolean flagObservacion) {
		this.flagObservacion = flagObservacion;
	}

	@Column(name = "ARBOL_CARTERA", length = 100)
	public String getArbolCartera() {
		return this.arbolCartera;
	}

	public void setArbolCartera(String arbolCartera) {
		this.arbolCartera = arbolCartera;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cbzArbolGestion")
	public Set<CbzResultadoArbolGestionModel> getCbzResultadoArbolGestions() {
		return this.cbzResultadoArbolGestions;
	}

	public void setCbzResultadoArbolGestions(Set<CbzResultadoArbolGestionModel> cbzResultadoArbolGestions) {
		this.cbzResultadoArbolGestions = cbzResultadoArbolGestions;
	}

	@Column(name = "FLAG_MOTORISTA", precision = 1, scale = 0)
	public Boolean getFlagMotorista() {
		return flagMotorista;
	}

	public void setFlagMotorista(Boolean flagMotorista) {
		this.flagMotorista = flagMotorista;
	}

}
