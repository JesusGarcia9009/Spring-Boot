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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author BS2
 */
@Entity
@Table(name = "VTA_OPER", schema = "VTAPAR")
public class VtaOperModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal vtopCod;
	private GenPersonasModel genPersonasByVtaOperPers1Fk;
	private GenPersonasModel genPersonasByVtaOperPersLegalFk;
	private GenEmpleadosModel genEmpleados;
	private GenUnidNegociosModel genUnidNegocios;
	private VtaPeriodoModel vtaPeriodo;
	private GenEmpresasModel genEmpresas;
	private VtaFuenteModel vtaFuente;
	private GenOrgGrpVtaModelModel genOrgGrpVta;
	private BigDecimal vtopNumOpe;
	private String vtopTipoOpe;
	private Date vtopFecInfo;
	private String vtarId;
	private String carrCod;
	private String vtopPrdd;
	private String vtopEstaCod;
	private String vtopUserMod;
	private Date vtopFecMod;
	private String vtopTipoVta;
	private String vtopIndPacMant;
	private String vtopIndPacCred;
	private String vtopSubTipoOper;
	private String neceTipo;
	private String vtopIndPieCuot;
	private BigDecimal vtopMntoPieCuot;
	private BigDecimal vtopValCuotCred;
	private Short vtopNumCuotCred;
	private BigDecimal vtopValCuotMant;
	private Date vtopFechCuotMant;
	private BigDecimal vtopPrcoVtaUf;
	private String moneCodVta;
	private Date vtopFechPmerVcto;
	private BigDecimal fledSec;
	private BigDecimal vtopCodCont;
	private Date vtopFechEmi;
	private String vtopIndReprLegal;
	private BigDecimal vtopReneNum;
	private String vtopIndConsaguinidad;
	private String vtopIndTrasl;
	private String persTipoIdAut;
	private String persIdAut;
	private String vtopRescMtvo;
	private String vtopRescIndCavn;
	private String persTipoIdCavn;
	private String persIdCavn;
	private BigDecimal vtopTransPrcoCalcUf;
	private BigDecimal vtopTransPrcoVtaUf;
	private Long vtopTransPrcoVtaPeso;
	private BigDecimal prdoSecCome;
	private BigDecimal prdoSecCont;
	private BigDecimal jvtaSec;
	private BigDecimal gvtaSec;
	private Date vtopFechIngr;
	private Date contFechCont;
	private BigDecimal vtopPrcoVtaUfOrig;
	private BigDecimal vtopNumOpeSvep;
	private String vtopIndFall;
	private Set<VtaPgreOperContModel> vtaPgreOperConts = new HashSet<VtaPgreOperContModel>(0);
	private Set<CbzSimulacionModel> cbzSimulacions = new HashSet<CbzSimulacionModel>(0);
	private VtaContratosModel vtaContratos;
	private Set<VtaOperUbicModel> vtaOperUbics = new HashSet<VtaOperUbicModel>(0);

	public VtaOperModel() {
	}

	
	@Id

	@Column(name = "VTOP_COD", unique = true, nullable = false, precision = 23, scale = 0)
	public BigDecimal getVtopCod() {
		return this.vtopCod;
	}

	public void setVtopCod(BigDecimal vtopCod) {
		this.vtopCod = vtopCod;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "PERS_TIPO_ID", referencedColumnName = "PERS_TIPO_ID"),
			@JoinColumn(name = "PERS_ID", referencedColumnName = "PERS_ID") })
	public GenPersonasModel getGenPersonasByVtaOperPers1Fk() {
		return this.genPersonasByVtaOperPers1Fk;
	}

	public void setGenPersonasByVtaOperPers1Fk(GenPersonasModel genPersonasByVtaOperPers1Fk) {
		this.genPersonasByVtaOperPers1Fk = genPersonasByVtaOperPers1Fk;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "PERS_TIPO_ID_REPR_LEGAL", referencedColumnName = "PERS_TIPO_ID"),
			@JoinColumn(name = "PERS_ID_REPR_LEGAL", referencedColumnName = "PERS_ID") })
	public GenPersonasModel getGenPersonasByVtaOperPersLegalFk() {
		return this.genPersonasByVtaOperPersLegalFk;
	}

	public void setGenPersonasByVtaOperPersLegalFk(GenPersonasModel genPersonasByVtaOperPersLegalFk) {
		this.genPersonasByVtaOperPersLegalFk = genPersonasByVtaOperPersLegalFk;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "PERS_TIPO_ID_VEND", referencedColumnName = "PERS_TIPO_ID"),
			@JoinColumn(name = "PERS_ID_VEND", referencedColumnName = "PERS_ID") })
	public GenEmpleadosModel getGenEmpleados() {
		return this.genEmpleados;
	}

	public void setGenEmpleados(GenEmpleadosModel genEmpleados) {
		this.genEmpleados = genEmpleados;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UNEG_COD", nullable = false)
	public GenUnidNegociosModel getGenUnidNegocios() {
		return this.genUnidNegocios;
	}

	public void setGenUnidNegocios(GenUnidNegociosModel genUnidNegocios) {
		this.genUnidNegocios = genUnidNegocios;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRDO_SEC_EMI")
	public VtaPeriodoModel getVtaPeriodo() {
		return this.vtaPeriodo;
	}

	public void setVtaPeriodo(VtaPeriodoModel vtaPeriodo) {
		this.vtaPeriodo = vtaPeriodo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMPR_COD", nullable = false, insertable = false, updatable = false)
	public GenEmpresasModel getGenEmpresas() {
		return this.genEmpresas;
	}

	public void setGenEmpresas(GenEmpresasModel genEmpresas) {
		this.genEmpresas = genEmpresas;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FNTE_COD")
	public VtaFuenteModel getVtaFuente() {
		return this.vtaFuente;
	}

	public void setVtaFuente(VtaFuenteModel vtaFuente) {
		this.vtaFuente = vtaFuente;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GRVT_SEC")
	public GenOrgGrpVtaModelModel getGenOrgGrpVta() {
		return this.genOrgGrpVta;
	}

	public void setGenOrgGrpVta(GenOrgGrpVtaModelModel genOrgGrpVta) {
		this.genOrgGrpVta = genOrgGrpVta;
	}

	@Column(name = "VTOP_NUM_OPE", precision = 23, scale = 0)
	public BigDecimal getVtopNumOpe() {
		return this.vtopNumOpe;
	}

	public void setVtopNumOpe(BigDecimal vtopNumOpe) {
		this.vtopNumOpe = vtopNumOpe;
	}

	@Column(name = "VTOP_TIPO_OPE", nullable = false, length = 20)
	public String getVtopTipoOpe() {
		return this.vtopTipoOpe;
	}

	public void setVtopTipoOpe(String vtopTipoOpe) {
		this.vtopTipoOpe = vtopTipoOpe;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "VTOP_FEC_INFO", length = 7)
	public Date getVtopFecInfo() {
		return this.vtopFecInfo;
	}

	public void setVtopFecInfo(Date vtopFecInfo) {
		this.vtopFecInfo = vtopFecInfo;
	}

	@Column(name = "VTAR_ID", length = 20)
	public String getVtarId() {
		return this.vtarId;
	}

	public void setVtarId(String vtarId) {
		this.vtarId = vtarId;
	}

	@Column(name = "CARR_COD", length = 10)
	public String getCarrCod() {
		return this.carrCod;
	}

	public void setCarrCod(String carrCod) {
		this.carrCod = carrCod;
	}

	@Column(name = "VTOP_PRDD", length = 20)
	public String getVtopPrdd() {
		return this.vtopPrdd;
	}

	public void setVtopPrdd(String vtopPrdd) {
		this.vtopPrdd = vtopPrdd;
	}

	@Column(name = "VTOP_ESTA_COD", nullable = false, length = 20)
	public String getVtopEstaCod() {
		return this.vtopEstaCod;
	}

	public void setVtopEstaCod(String vtopEstaCod) {
		this.vtopEstaCod = vtopEstaCod;
	}

	@Column(name = "VTOP_USER_MOD", length = 30)
	public String getVtopUserMod() {
		return this.vtopUserMod;
	}

	public void setVtopUserMod(String vtopUserMod) {
		this.vtopUserMod = vtopUserMod;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "VTOP_FEC_MOD", length = 7)
	public Date getVtopFecMod() {
		return this.vtopFecMod;
	}

	public void setVtopFecMod(Date vtopFecMod) {
		this.vtopFecMod = vtopFecMod;
	}

	@Column(name = "VTOP_TIPO_VTA", length = 20)
	public String getVtopTipoVta() {
		return this.vtopTipoVta;
	}

	public void setVtopTipoVta(String vtopTipoVta) {
		this.vtopTipoVta = vtopTipoVta;
	}

	@Column(name = "VTOP_IND_PAC_MANT", length = 2)
	public String getVtopIndPacMant() {
		return this.vtopIndPacMant;
	}

	public void setVtopIndPacMant(String vtopIndPacMant) {
		this.vtopIndPacMant = vtopIndPacMant;
	}

	@Column(name = "VTOP_IND_PAC_CRED", length = 2)
	public String getVtopIndPacCred() {
		return this.vtopIndPacCred;
	}

	public void setVtopIndPacCred(String vtopIndPacCred) {
		this.vtopIndPacCred = vtopIndPacCred;
	}

	@Column(name = "VTOP_SUB_TIPO_OPER", length = 20)
	public String getVtopSubTipoOper() {
		return this.vtopSubTipoOper;
	}

	public void setVtopSubTipoOper(String vtopSubTipoOper) {
		this.vtopSubTipoOper = vtopSubTipoOper;
	}

	@Column(name = "NECE_TIPO", length = 2)
	public String getNeceTipo() {
		return this.neceTipo;
	}

	public void setNeceTipo(String neceTipo) {
		this.neceTipo = neceTipo;
	}

	@Column(name = "VTOP_IND_PIE_CUOT", length = 20)
	public String getVtopIndPieCuot() {
		return this.vtopIndPieCuot;
	}

	public void setVtopIndPieCuot(String vtopIndPieCuot) {
		this.vtopIndPieCuot = vtopIndPieCuot;
	}

	@Column(name = "VTOP_MNTO_PIE_CUOT", precision = 14)
	public BigDecimal getVtopMntoPieCuot() {
		return this.vtopMntoPieCuot;
	}

	public void setVtopMntoPieCuot(BigDecimal vtopMntoPieCuot) {
		this.vtopMntoPieCuot = vtopMntoPieCuot;
	}

	@Column(name = "VTOP_VAL_CUOT_CRED", precision = 14)
	public BigDecimal getVtopValCuotCred() {
		return this.vtopValCuotCred;
	}

	public void setVtopValCuotCred(BigDecimal vtopValCuotCred) {
		this.vtopValCuotCred = vtopValCuotCred;
	}

	@Column(name = "VTOP_NUM_CUOT_CRED", precision = 3, scale = 0)
	public Short getVtopNumCuotCred() {
		return this.vtopNumCuotCred;
	}

	public void setVtopNumCuotCred(Short vtopNumCuotCred) {
		this.vtopNumCuotCred = vtopNumCuotCred;
	}

	@Column(name = "VTOP_VAL_CUOT_MANT", precision = 14)
	public BigDecimal getVtopValCuotMant() {
		return this.vtopValCuotMant;
	}

	public void setVtopValCuotMant(BigDecimal vtopValCuotMant) {
		this.vtopValCuotMant = vtopValCuotMant;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "VTOP_FECH_CUOT_MANT", length = 7)
	public Date getVtopFechCuotMant() {
		return this.vtopFechCuotMant;
	}

	public void setVtopFechCuotMant(Date vtopFechCuotMant) {
		this.vtopFechCuotMant = vtopFechCuotMant;
	}

	@Column(name = "VTOP_PRCO_VTA_UF", precision = 14)
	public BigDecimal getVtopPrcoVtaUf() {
		return this.vtopPrcoVtaUf;
	}

	public void setVtopPrcoVtaUf(BigDecimal vtopPrcoVtaUf) {
		this.vtopPrcoVtaUf = vtopPrcoVtaUf;
	}

	@Column(name = "MONE_COD_VTA", length = 10)
	public String getMoneCodVta() {
		return this.moneCodVta;
	}

	public void setMoneCodVta(String moneCodVta) {
		this.moneCodVta = moneCodVta;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "VTOP_FECH_PMER_VCTO", length = 7)
	public Date getVtopFechPmerVcto() {
		return this.vtopFechPmerVcto;
	}

	public void setVtopFechPmerVcto(Date vtopFechPmerVcto) {
		this.vtopFechPmerVcto = vtopFechPmerVcto;
	}

	@Column(name = "FLED_SEC", precision = 23, scale = 0)
	public BigDecimal getFledSec() {
		return this.fledSec;
	}

	public void setFledSec(BigDecimal fledSec) {
		this.fledSec = fledSec;
	}

	@Column(name = "VTOP_COD_CONT", precision = 23, scale = 0)
	public BigDecimal getVtopCodCont() {
		return this.vtopCodCont;
	}

	public void setVtopCodCont(BigDecimal vtopCodCont) {
		this.vtopCodCont = vtopCodCont;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "VTOP_FECH_EMI", length = 7)
	public Date getVtopFechEmi() {
		return this.vtopFechEmi;
	}

	public void setVtopFechEmi(Date vtopFechEmi) {
		this.vtopFechEmi = vtopFechEmi;
	}

	@Column(name = "VTOP_IND_REPR_LEGAL", length = 2)
	public String getVtopIndReprLegal() {
		return this.vtopIndReprLegal;
	}

	public void setVtopIndReprLegal(String vtopIndReprLegal) {
		this.vtopIndReprLegal = vtopIndReprLegal;
	}

	@Column(name = "VTOP_RENE_NUM", precision = 23, scale = 0)
	public BigDecimal getVtopReneNum() {
		return this.vtopReneNum;
	}

	public void setVtopReneNum(BigDecimal vtopReneNum) {
		this.vtopReneNum = vtopReneNum;
	}

	@Column(name = "VTOP_IND_CONSAGUINIDAD", length = 2)
	public String getVtopIndConsaguinidad() {
		return this.vtopIndConsaguinidad;
	}

	public void setVtopIndConsaguinidad(String vtopIndConsaguinidad) {
		this.vtopIndConsaguinidad = vtopIndConsaguinidad;
	}

	@Column(name = "VTOP_IND_TRASL", length = 2)
	public String getVtopIndTrasl() {
		return this.vtopIndTrasl;
	}

	public void setVtopIndTrasl(String vtopIndTrasl) {
		this.vtopIndTrasl = vtopIndTrasl;
	}

	@Column(name = "PERS_TIPO_ID_AUT", length = 4)
	public String getPersTipoIdAut() {
		return this.persTipoIdAut;
	}

	public void setPersTipoIdAut(String persTipoIdAut) {
		this.persTipoIdAut = persTipoIdAut;
	}

	@Column(name = "PERS_ID_AUT", length = 10)
	public String getPersIdAut() {
		return this.persIdAut;
	}

	public void setPersIdAut(String persIdAut) {
		this.persIdAut = persIdAut;
	}

	@Column(name = "VTOP_RESC_MTVO", length = 20)
	public String getVtopRescMtvo() {
		return this.vtopRescMtvo;
	}

	public void setVtopRescMtvo(String vtopRescMtvo) {
		this.vtopRescMtvo = vtopRescMtvo;
	}

	@Column(name = "VTOP_RESC_IND_CAVN", length = 2)
	public String getVtopRescIndCavn() {
		return this.vtopRescIndCavn;
	}

	public void setVtopRescIndCavn(String vtopRescIndCavn) {
		this.vtopRescIndCavn = vtopRescIndCavn;
	}

	@Column(name = "PERS_TIPO_ID_CAVN", length = 4)
	public String getPersTipoIdCavn() {
		return this.persTipoIdCavn;
	}

	public void setPersTipoIdCavn(String persTipoIdCavn) {
		this.persTipoIdCavn = persTipoIdCavn;
	}

	@Column(name = "PERS_ID_CAVN", length = 10)
	public String getPersIdCavn() {
		return this.persIdCavn;
	}

	public void setPersIdCavn(String persIdCavn) {
		this.persIdCavn = persIdCavn;
	}

	@Column(name = "VTOP_TRANS_PRCO_CALC_UF", precision = 14)
	public BigDecimal getVtopTransPrcoCalcUf() {
		return this.vtopTransPrcoCalcUf;
	}

	public void setVtopTransPrcoCalcUf(BigDecimal vtopTransPrcoCalcUf) {
		this.vtopTransPrcoCalcUf = vtopTransPrcoCalcUf;
	}

	@Column(name = "VTOP_TRANS_PRCO_VTA_UF", precision = 14)
	public BigDecimal getVtopTransPrcoVtaUf() {
		return this.vtopTransPrcoVtaUf;
	}

	public void setVtopTransPrcoVtaUf(BigDecimal vtopTransPrcoVtaUf) {
		this.vtopTransPrcoVtaUf = vtopTransPrcoVtaUf;
	}

	@Column(name = "VTOP_TRANS_PRCO_VTA_PESO", precision = 14, scale = 0)
	public Long getVtopTransPrcoVtaPeso() {
		return this.vtopTransPrcoVtaPeso;
	}

	public void setVtopTransPrcoVtaPeso(Long vtopTransPrcoVtaPeso) {
		this.vtopTransPrcoVtaPeso = vtopTransPrcoVtaPeso;
	}

	@Column(name = "PRDO_SEC_COME", precision = 23, scale = 0)
	public BigDecimal getPrdoSecCome() {
		return this.prdoSecCome;
	}

	public void setPrdoSecCome(BigDecimal prdoSecCome) {
		this.prdoSecCome = prdoSecCome;
	}

	@Column(name = "PRDO_SEC_CONT", precision = 23, scale = 0)
	public BigDecimal getPrdoSecCont() {
		return this.prdoSecCont;
	}

	public void setPrdoSecCont(BigDecimal prdoSecCont) {
		this.prdoSecCont = prdoSecCont;
	}

	@Column(name = "JVTA_SEC", precision = 23, scale = 0)
	public BigDecimal getJvtaSec() {
		return this.jvtaSec;
	}

	public void setJvtaSec(BigDecimal jvtaSec) {
		this.jvtaSec = jvtaSec;
	}

	@Column(name = "GVTA_SEC", precision = 23, scale = 0)
	public BigDecimal getGvtaSec() {
		return this.gvtaSec;
	}

	public void setGvtaSec(BigDecimal gvtaSec) {
		this.gvtaSec = gvtaSec;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "VTOP_FECH_INGR", nullable = false, length = 7)
	public Date getVtopFechIngr() {
		return this.vtopFechIngr;
	}

	public void setVtopFechIngr(Date vtopFechIngr) {
		this.vtopFechIngr = vtopFechIngr;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CONT_FECH_CONT", length = 7)
	public Date getContFechCont() {
		return this.contFechCont;
	}

	public void setContFechCont(Date contFechCont) {
		this.contFechCont = contFechCont;
	}

	@Column(name = "VTOP_PRCO_VTA_UF_ORIG", precision = 14)
	public BigDecimal getVtopPrcoVtaUfOrig() {
		return this.vtopPrcoVtaUfOrig;
	}

	public void setVtopPrcoVtaUfOrig(BigDecimal vtopPrcoVtaUfOrig) {
		this.vtopPrcoVtaUfOrig = vtopPrcoVtaUfOrig;
	}

	@Column(name = "VTOP_NUM_OPE_SVEP", precision = 23, scale = 0)
	public BigDecimal getVtopNumOpeSvep() {
		return this.vtopNumOpeSvep;
	}

	public void setVtopNumOpeSvep(BigDecimal vtopNumOpeSvep) {
		this.vtopNumOpeSvep = vtopNumOpeSvep;
	}

	@Column(name = "VTOP_IND_FALL", length = 2)
	public String getVtopIndFall() {
		return this.vtopIndFall;
	}

	public void setVtopIndFall(String vtopIndFall) {
		this.vtopIndFall = vtopIndFall;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vtaOper")
	public Set<VtaPgreOperContModel> getVtaPgreOperConts() {
		return this.vtaPgreOperConts;
	}

	public void setVtaPgreOperConts(Set<VtaPgreOperContModel> vtaPgreOperConts) {
		this.vtaPgreOperConts = vtaPgreOperConts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vtaOper")
	public Set<CbzSimulacionModel> getCbzSimulacions() {
		return this.cbzSimulacions;
	}

	public void setCbzSimulacions(Set<CbzSimulacionModel> cbzSimulacions) {
		this.cbzSimulacions = cbzSimulacions;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "vtaOper")
	public VtaContratosModel getVtaContratos() {
		return this.vtaContratos;
	}

	public void setVtaContratos(VtaContratosModel vtaContratos) {
		this.vtaContratos = vtaContratos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vtaOper")
	public Set<VtaOperUbicModel> getVtaOperUbics() {
		return this.vtaOperUbics;
	}

	public void setVtaOperUbics(Set<VtaOperUbicModel> vtaOperUbics) {
		this.vtaOperUbics = vtaOperUbics;
	}

}
