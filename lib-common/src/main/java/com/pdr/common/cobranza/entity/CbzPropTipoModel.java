package com.pdr.common.cobranza.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author BS2
 */
@Entity
@Table(name = "CBZ_PROP_TIPO", schema = "CBZPAR")
public class CbzPropTipoModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5798832930876220977L;
	private int idCptTipo;
	private String cptTipoDesc;
	private BigDecimal cptActivo;
	private Set<CbzPropiedadesModel> cbzPropiedadeses = new HashSet<CbzPropiedadesModel>(0);

	public CbzPropTipoModel() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE_PROP_TIPO")
	@SequenceGenerator(name = "ID_SEQUENCE_PROP_TIPO", allocationSize = 1, sequenceName = "SEQ_PROP_TIPO", schema = "CBZPAR")
	@Column(name = "ID_CPT_TIPO", unique = true, nullable = false, precision = 8, scale = 0)
	public int getIdCptTipo() {
		return this.idCptTipo;
	}

	public void setIdCptTipo(int idCptTipo) {
		this.idCptTipo = idCptTipo;
	}

	@Column(name = "CPT_TIPO_DESC", length = 25)
	public String getCptTipoDesc() {
		return this.cptTipoDesc;
	}

	public void setCptTipoDesc(String cptTipoDesc) {
		this.cptTipoDesc = cptTipoDesc;
	}

	@Column(name = "CPT_ACTIVO", precision = 22, scale = 0)
	public BigDecimal getCptActivo() {
		return this.cptActivo;
	}

	public void setCptActivo(BigDecimal cptActivo) {
		this.cptActivo = cptActivo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cbzPropTipo")
	public Set<CbzPropiedadesModel> getCbzPropiedadeses() {
		return this.cbzPropiedadeses;
	}

	public void setCbzPropiedadeses(Set<CbzPropiedadesModel> cbzPropiedadeses) {
		this.cbzPropiedadeses = cbzPropiedadeses;
	}

}
