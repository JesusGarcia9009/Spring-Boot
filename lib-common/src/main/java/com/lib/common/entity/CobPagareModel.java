package com.lib.common.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author BS2
 */
@Entity
@Table(name = "COB_PAGARE", schema = "COBPAR")
public class CobPagareModel implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal pgreSec;
	private GenPersonasModel genPersonas;
	private CobCtaCarteraModel cobCtaCartera;
	private String unegCodOrig;
	private String subFamiCod;
	private String serieCod;
	private BigDecimal doctoFolio;
	private String moneCod;
	private Date pgreFech;
	private long pgreMntoPeso;
	private BigDecimal pgreMntoUf;
	private BigDecimal pgreTasaInte;
	private String pgrePrddCuot;
	private int pgreNumeCuot;
	private long pgreMntoCuotPeso;
	private BigDecimal pgreMntoCuotUf;
	private BigDecimal pgreMntoCuotKapi;
	private BigDecimal pgreMntoCuotIkapi;
	private Date pgreFechPrimVcto;
	private Short pgrePrdoGrcia;
	private BigDecimal pgreKapiTasa;
	private String pgreIndEstrCred;
	private String tipoDocto;
	private BigDecimal numDocto;
	private String pgreEstaCod;
	private String pgreLegaEstaCod;
	private BigDecimal legaSec;
	private BigDecimal cupoSec;
	private String pgreUserMod;
	private Date pgreFecMod;
	private Integer imtmPrdoCod;
	private BigDecimal trspSec;
	private String pgreIndMixto;
	private String pgreIndBueno;
	private Long pgreMntoCuotPesoCalc;
	private BigDecimal pgreMntoCuotUfCalc;
	private String pgreIdInstitucCed;
	private Set<VtaPgreOperContModel> vtaPgreOperConts = new HashSet<>(0);
	private Set<CbzSimulacionPagaresModel> cbzSimulacionPagareses = new HashSet<>(0);
	private Set<CobRenegPgreCuotasModel> cobRenegPgreCuotases = new HashSet<>(0);

	public CobPagareModel() {
	}



	@Id
	@Column(name = "PGRE_SEC", unique = true, nullable = false, precision = 23, scale = 0)
	public BigDecimal getPgreSec() {
		return this.pgreSec;
	}

	public void setPgreSec(BigDecimal pgreSec) {
		this.pgreSec = pgreSec;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "PERS_TIPO_ID", referencedColumnName = "PERS_TIPO_ID"),
			@JoinColumn(name = "PERS_ID", referencedColumnName = "PERS_ID") })
	public GenPersonasModel getGenPersonas() {
		return this.genPersonas;
	}

	public void setGenPersonas(GenPersonasModel genPersonas) {
		this.genPersonas = genPersonas;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "EMPR_COD_ORIG", referencedColumnName = "EMPR_COD", insertable=false, updatable=false),
			@JoinColumn(name = "CCAR_COD", referencedColumnName = "CCAR_COD",insertable=false, updatable=false ) })
	public CobCtaCarteraModel getCobCtaCartera() {
		return this.cobCtaCartera;
	}

	public void setCobCtaCartera(CobCtaCarteraModel cobCtaCartera) {
		this.cobCtaCartera = cobCtaCartera;
	}

	@Column(name = "UNEG_COD_ORIG", nullable = false, length = 10)
	public String getUnegCodOrig() {
		return this.unegCodOrig;
	}

	public void setUnegCodOrig(String unegCodOrig) {
		this.unegCodOrig = unegCodOrig;
	}

	@Column(name = "SUB_FAMI_COD", length = 20)
	public String getSubFamiCod() {
		return this.subFamiCod;
	}

	public void setSubFamiCod(String subFamiCod) {
		this.subFamiCod = subFamiCod;
	}

	@Column(name = "SERIE_COD", length = 10)
	public String getSerieCod() {
		return this.serieCod;
	}

	public void setSerieCod(String serieCod) {
		this.serieCod = serieCod;
	}

	@Column(name = "DOCTO_FOLIO", precision = 23, scale = 0)
	public BigDecimal getDoctoFolio() {
		return this.doctoFolio;
	}

	public void setDoctoFolio(BigDecimal doctoFolio) {
		this.doctoFolio = doctoFolio;
	}

	@Column(name = "MONE_COD", nullable = false, length = 10)
	public String getMoneCod() {
		return this.moneCod;
	}

	public void setMoneCod(String moneCod) {
		this.moneCod = moneCod;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "PGRE_FECH", nullable = false, length = 7)
	public Date getPgreFech() {
		return this.pgreFech;
	}

	public void setPgreFech(Date pgreFech) {
		this.pgreFech = pgreFech;
	}

	@Column(name = "PGRE_MNTO_PESO", nullable = false, precision = 14, scale = 0)
	public long getPgreMntoPeso() {
		return this.pgreMntoPeso;
	}

	public void setPgreMntoPeso(long pgreMntoPeso) {
		this.pgreMntoPeso = pgreMntoPeso;
	}

	@Column(name = "PGRE_MNTO_UF", nullable = false, precision = 14)
	public BigDecimal getPgreMntoUf() {
		return this.pgreMntoUf;
	}

	public void setPgreMntoUf(BigDecimal pgreMntoUf) {
		this.pgreMntoUf = pgreMntoUf;
	}

	@Column(name = "PGRE_TASA_INTE", nullable = false, precision = 5)
	public BigDecimal getPgreTasaInte() {
		return this.pgreTasaInte;
	}

	public void setPgreTasaInte(BigDecimal pgreTasaInte) {
		this.pgreTasaInte = pgreTasaInte;
	}

	@Column(name = "PGRE_PRDD_CUOT", length = 20)
	public String getPgrePrddCuot() {
		return this.pgrePrddCuot;
	}

	public void setPgrePrddCuot(String pgrePrddCuot) {
		this.pgrePrddCuot = pgrePrddCuot;
	}

	@Column(name = "PGRE_NUME_CUOT", nullable = false, precision = 5, scale = 0)
	public int getPgreNumeCuot() {
		return this.pgreNumeCuot;
	}

	public void setPgreNumeCuot(int pgreNumeCuot) {
		this.pgreNumeCuot = pgreNumeCuot;
	}

	@Column(name = "PGRE_MNTO_CUOT_PESO", nullable = false, precision = 14, scale = 0)
	public long getPgreMntoCuotPeso() {
		return this.pgreMntoCuotPeso;
	}

	public void setPgreMntoCuotPeso(long pgreMntoCuotPeso) {
		this.pgreMntoCuotPeso = pgreMntoCuotPeso;
	}

	@Column(name = "PGRE_MNTO_CUOT_UF", nullable = false, precision = 14)
	public BigDecimal getPgreMntoCuotUf() {
		return this.pgreMntoCuotUf;
	}

	public void setPgreMntoCuotUf(BigDecimal pgreMntoCuotUf) {
		this.pgreMntoCuotUf = pgreMntoCuotUf;
	}

	@Column(name = "PGRE_MNTO_CUOT_KAPI", precision = 14)
	public BigDecimal getPgreMntoCuotKapi() {
		return this.pgreMntoCuotKapi;
	}

	public void setPgreMntoCuotKapi(BigDecimal pgreMntoCuotKapi) {
		this.pgreMntoCuotKapi = pgreMntoCuotKapi;
	}

	@Column(name = "PGRE_MNTO_CUOT_IKAPI", precision = 14)
	public BigDecimal getPgreMntoCuotIkapi() {
		return this.pgreMntoCuotIkapi;
	}

	public void setPgreMntoCuotIkapi(BigDecimal pgreMntoCuotIkapi) {
		this.pgreMntoCuotIkapi = pgreMntoCuotIkapi;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "PGRE_FECH_PRIM_VCTO", nullable = false, length = 7)
	public Date getPgreFechPrimVcto() {
		return this.pgreFechPrimVcto;
	}

	public void setPgreFechPrimVcto(Date pgreFechPrimVcto) {
		this.pgreFechPrimVcto = pgreFechPrimVcto;
	}

	@Column(name = "PGRE_PRDO_GRCIA", precision = 3, scale = 0)
	public Short getPgrePrdoGrcia() {
		return this.pgrePrdoGrcia;
	}

	public void setPgrePrdoGrcia(Short pgrePrdoGrcia) {
		this.pgrePrdoGrcia = pgrePrdoGrcia;
	}

	@Column(name = "PGRE_KAPI_TASA", precision = 5)
	public BigDecimal getPgreKapiTasa() {
		return this.pgreKapiTasa;
	}

	public void setPgreKapiTasa(BigDecimal pgreKapiTasa) {
		this.pgreKapiTasa = pgreKapiTasa;
	}

	@Column(name = "PGRE_IND_ESTR_CRED", length = 2)
	public String getPgreIndEstrCred() {
		return this.pgreIndEstrCred;
	}

	public void setPgreIndEstrCred(String pgreIndEstrCred) {
		this.pgreIndEstrCred = pgreIndEstrCred;
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

	@Column(name = "PGRE_ESTA_COD", nullable = false, length = 20)
	public String getPgreEstaCod() {
		return this.pgreEstaCod;
	}

	public void setPgreEstaCod(String pgreEstaCod) {
		this.pgreEstaCod = pgreEstaCod;
	}

	@Column(name = "PGRE_LEGA_ESTA_COD", nullable = false, length = 20)
	public String getPgreLegaEstaCod() {
		return this.pgreLegaEstaCod;
	}

	public void setPgreLegaEstaCod(String pgreLegaEstaCod) {
		this.pgreLegaEstaCod = pgreLegaEstaCod;
	}

	@Column(name = "LEGA_SEC", precision = 23, scale = 0)
	public BigDecimal getLegaSec() {
		return this.legaSec;
	}

	public void setLegaSec(BigDecimal legaSec) {
		this.legaSec = legaSec;
	}

	@Column(name = "CUPO_SEC", precision = 23, scale = 0)
	public BigDecimal getCupoSec() {
		return this.cupoSec;
	}

	public void setCupoSec(BigDecimal cupoSec) {
		this.cupoSec = cupoSec;
	}

	@Column(name = "PGRE_USER_MOD", nullable = false, length = 20)
	public String getPgreUserMod() {
		return this.pgreUserMod;
	}

	public void setPgreUserMod(String pgreUserMod) {
		this.pgreUserMod = pgreUserMod;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "PGRE_FEC_MOD", nullable = false, length = 7)
	public Date getPgreFecMod() {
		return this.pgreFecMod;
	}

	public void setPgreFecMod(Date pgreFecMod) {
		this.pgreFecMod = pgreFecMod;
	}

	@Column(name = "IMTM_PRDO_COD", precision = 6, scale = 0)
	public Integer getImtmPrdoCod() {
		return this.imtmPrdoCod;
	}

	public void setImtmPrdoCod(Integer imtmPrdoCod) {
		this.imtmPrdoCod = imtmPrdoCod;
	}

	@Column(name = "TRSP_SEC", precision = 23, scale = 0)
	public BigDecimal getTrspSec() {
		return this.trspSec;
	}

	public void setTrspSec(BigDecimal trspSec) {
		this.trspSec = trspSec;
	}

	@Column(name = "PGRE_IND_MIXTO", nullable = false, length = 2)
	public String getPgreIndMixto() {
		return this.pgreIndMixto;
	}

	public void setPgreIndMixto(String pgreIndMixto) {
		this.pgreIndMixto = pgreIndMixto;
	}

	@Column(name = "PGRE_IND_BUENO", length = 2)
	public String getPgreIndBueno() {
		return this.pgreIndBueno;
	}

	public void setPgreIndBueno(String pgreIndBueno) {
		this.pgreIndBueno = pgreIndBueno;
	}

	@Column(name = "PGRE_MNTO_CUOT_PESO_CALC", precision = 14, scale = 0)
	public Long getPgreMntoCuotPesoCalc() {
		return this.pgreMntoCuotPesoCalc;
	}

	public void setPgreMntoCuotPesoCalc(Long pgreMntoCuotPesoCalc) {
		this.pgreMntoCuotPesoCalc = pgreMntoCuotPesoCalc;
	}

	@Column(name = "PGRE_MNTO_CUOT_UF_CALC", precision = 14)
	public BigDecimal getPgreMntoCuotUfCalc() {
		return this.pgreMntoCuotUfCalc;
	}

	public void setPgreMntoCuotUfCalc(BigDecimal pgreMntoCuotUfCalc) {
		this.pgreMntoCuotUfCalc = pgreMntoCuotUfCalc;
	}

	@Column(name = "PGRE_ID_INSTITUC_CED", length = 20)
	public String getPgreIdInstitucCed() {
		return this.pgreIdInstitucCed;
	}

	public void setPgreIdInstitucCed(String pgreIdInstitucCed) {
		this.pgreIdInstitucCed = pgreIdInstitucCed;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cobPagare")
	public Set<VtaPgreOperContModel> getVtaPgreOperConts() {
		return this.vtaPgreOperConts;
	}

	public void setVtaPgreOperConts(Set<VtaPgreOperContModel> vtaPgreOperConts) {
		this.vtaPgreOperConts = vtaPgreOperConts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cobPagare")
	public Set<CbzSimulacionPagaresModel> getCbzSimulacionPagareses() {
		return this.cbzSimulacionPagareses;
	}

	public void setCbzSimulacionPagareses(Set<CbzSimulacionPagaresModel> cbzSimulacionPagareses) {
		this.cbzSimulacionPagareses = cbzSimulacionPagareses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cobPagare")
	public Set<CobRenegPgreCuotasModel> getCobRenegPgreCuotases() {
		return this.cobRenegPgreCuotases;
	}

	public void setCobRenegPgreCuotases(Set<CobRenegPgreCuotasModel> cobRenegPgreCuotases) {
		this.cobRenegPgreCuotases = cobRenegPgreCuotases;
	}


}
