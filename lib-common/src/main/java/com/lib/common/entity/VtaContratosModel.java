package com.lib.common.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * @author BS2
 */
@Entity
@Table(name = "VTA_CONTRATOS", schema = "VTAPAR")
public class VtaContratosModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal vtopCodCont;
	private GenPersonasModel genPersonas;
	private VtaOperModel vtaOper;
	private String contTipoCont;
	private Date contFechCont;
	private String neceTipo;
	private String contTipoVta;
	private String moneCodVta;
	private String fogeCod;
	private String subFamiCod;
	private String serieCod;
	private BigDecimal doctoFolio;
	private Short sepuNumCptos;
	private Short sepuNumRedu;
	private String contSepuTmpPer;
	private String contSepuTrraHorm;
	private String sepuCrac;
	private Integer contSepuMesRest;
	private BigDecimal contPrcoListaUf;
	private Long contPrcoVtaPeso;
	private BigDecimal contPrcoVtaUf;
	private Long contMntoPiePesos;
	private BigDecimal contMntoPieUf;
	private Long contMntoCredPeso;
	private BigDecimal contMntoCredUf;
	private BigDecimal contValCuotCred;
	private BigDecimal contMaLista;
	private BigDecimal contMaVta;
	private Date contFechCuotMant;
	private BigDecimal contValCuotMant;
	private String contIndPacCred;
	private String contIndPacMant;
	private String contIndBenePac;
	private String contIndClauAnxSeg;
	private String contIndDclSegSal;
	private String contIndFcpCmpDomi;
	private String contIndAsistDeceso;
	private String contIndFtcpCeduId;
	private String contIndMndtoDicom;
	private Date contFechIngr;
	private Date contFechLimi;
	private String contVeriEstaCod;
	private String contUserMod;
	private Date contFecMod;
	private Date contVeriEstaFecMod;
	private Date contFechEmi;
	private String contDespEstaCod;
	private Date contFechRestOrig;
	private Date contFechRestAct;
	private String contEstaCod;
	private String contIndBloqueo;
	private Long contRegTitulo;
	private BigDecimal fledSec;
	private String contIndSmad;
	private String contIndClauSegMant;
	private BigDecimal contClauComplUf;
	private Long contClauComplPeso;
	private Set<VtaPgreOperContModel> vtaPgreOperConts = new HashSet<>(0);
	private Set<CbzSimulacionModel> cbzSimulacions = new HashSet<>(0);
	private Set<CobContMantencionModel> cobContMantencions = new HashSet<>(0);

	public VtaContratosModel() {
	}

	public VtaContratosModel(VtaOperModel vtaOper, String contTipoCont, Date contFechCont, String neceTipo, String contUserMod,
			Date contFecMod) {
		this.vtaOper = vtaOper;
		this.contTipoCont = contTipoCont;
		this.contFechCont = contFechCont;
		this.neceTipo = neceTipo;
		this.contUserMod = contUserMod;
		this.contFecMod = contFecMod;
	}

	public VtaContratosModel(GenPersonasModel genPersonas, VtaOperModel vtaOper, String contTipoCont, Date contFechCont,
			String neceTipo, String contTipoVta, String moneCodVta, String fogeCod, String subFamiCod, String serieCod,
			BigDecimal doctoFolio, Short sepuNumCptos, Short sepuNumRedu, String contSepuTmpPer,
			String contSepuTrraHorm, String sepuCrac, Integer contSepuMesRest, BigDecimal contPrcoListaUf,
			Long contPrcoVtaPeso, BigDecimal contPrcoVtaUf, Long contMntoPiePesos, BigDecimal contMntoPieUf,
			Long contMntoCredPeso, BigDecimal contMntoCredUf, BigDecimal contValCuotCred, BigDecimal contMaLista,
			BigDecimal contMaVta, Date contFechCuotMant, BigDecimal contValCuotMant, String contIndPacCred,
			String contIndPacMant, String contIndBenePac, String contIndClauAnxSeg, String contIndDclSegSal,
			String contIndFcpCmpDomi, String contIndAsistDeceso, String contIndFtcpCeduId, String contIndMndtoDicom,
			Date contFechIngr, Date contFechLimi, String contVeriEstaCod, String contUserMod, Date contFecMod,
			Date contVeriEstaFecMod, Date contFechEmi, String contDespEstaCod, Date contFechRestOrig,
			Date contFechRestAct, String contEstaCod, String contIndBloqueo, Long contRegTitulo, BigDecimal fledSec,
			String contIndSmad, String contIndClauSegMant, BigDecimal contClauComplUf, Long contClauComplPeso,
			Set<VtaPgreOperContModel> vtaPgreOperConts, Set<CbzSimulacionModel> cbzSimulacions,
			Set<CobContMantencionModel> cobContMantencions) {
		this.genPersonas = genPersonas;
		this.vtaOper = vtaOper;
		this.contTipoCont = contTipoCont;
		this.contFechCont = contFechCont;
		this.neceTipo = neceTipo;
		this.contTipoVta = contTipoVta;
		this.moneCodVta = moneCodVta;
		this.fogeCod = fogeCod;
		this.subFamiCod = subFamiCod;
		this.serieCod = serieCod;
		this.doctoFolio = doctoFolio;
		this.sepuNumCptos = sepuNumCptos;
		this.sepuNumRedu = sepuNumRedu;
		this.contSepuTmpPer = contSepuTmpPer;
		this.contSepuTrraHorm = contSepuTrraHorm;
		this.sepuCrac = sepuCrac;
		this.contSepuMesRest = contSepuMesRest;
		this.contPrcoListaUf = contPrcoListaUf;
		this.contPrcoVtaPeso = contPrcoVtaPeso;
		this.contPrcoVtaUf = contPrcoVtaUf;
		this.contMntoPiePesos = contMntoPiePesos;
		this.contMntoPieUf = contMntoPieUf;
		this.contMntoCredPeso = contMntoCredPeso;
		this.contMntoCredUf = contMntoCredUf;
		this.contValCuotCred = contValCuotCred;
		this.contMaLista = contMaLista;
		this.contMaVta = contMaVta;
		this.contFechCuotMant = contFechCuotMant;
		this.contValCuotMant = contValCuotMant;
		this.contIndPacCred = contIndPacCred;
		this.contIndPacMant = contIndPacMant;
		this.contIndBenePac = contIndBenePac;
		this.contIndClauAnxSeg = contIndClauAnxSeg;
		this.contIndDclSegSal = contIndDclSegSal;
		this.contIndFcpCmpDomi = contIndFcpCmpDomi;
		this.contIndAsistDeceso = contIndAsistDeceso;
		this.contIndFtcpCeduId = contIndFtcpCeduId;
		this.contIndMndtoDicom = contIndMndtoDicom;
		this.contFechIngr = contFechIngr;
		this.contFechLimi = contFechLimi;
		this.contVeriEstaCod = contVeriEstaCod;
		this.contUserMod = contUserMod;
		this.contFecMod = contFecMod;
		this.contVeriEstaFecMod = contVeriEstaFecMod;
		this.contFechEmi = contFechEmi;
		this.contDespEstaCod = contDespEstaCod;
		this.contFechRestOrig = contFechRestOrig;
		this.contFechRestAct = contFechRestAct;
		this.contEstaCod = contEstaCod;
		this.contIndBloqueo = contIndBloqueo;
		this.contRegTitulo = contRegTitulo;
		this.fledSec = fledSec;
		this.contIndSmad = contIndSmad;
		this.contIndClauSegMant = contIndClauSegMant;
		this.contClauComplUf = contClauComplUf;
		this.contClauComplPeso = contClauComplPeso;
		this.vtaPgreOperConts = vtaPgreOperConts;
		this.cbzSimulacions = cbzSimulacions;
		this.cobContMantencions = cobContMantencions;
	}

	@GenericGenerator(name = "com.pdr.common.cobranza.entity.VtaContratosIdGenerator", strategy = "foreign", parameters = @Parameter(name = "property", value = "vtaOper"))
	@Id
	@GeneratedValue(generator = "com.pdr.common.cobranza.entity.VtaContratosIdGenerator")

	@Column(name = "VTOP_COD_CONT", unique = true, nullable = false, precision = 23, scale = 0)
	public BigDecimal getVtopCodCont() {
		return this.vtopCodCont;
	}

	public void setVtopCodCont(BigDecimal vtopCodCont) {
		this.vtopCodCont = vtopCodCont;
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

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public VtaOperModel getVtaOper() {
		return this.vtaOper;
	}

	public void setVtaOper(VtaOperModel vtaOper) {
		this.vtaOper = vtaOper;
	}

	@Column(name = "CONT_TIPO_CONT", nullable = false, length = 20)
	public String getContTipoCont() {
		return this.contTipoCont;
	}

	public void setContTipoCont(String contTipoCont) {
		this.contTipoCont = contTipoCont;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CONT_FECH_CONT", nullable = false, length = 7)
	public Date getContFechCont() {
		return this.contFechCont;
	}

	public void setContFechCont(Date contFechCont) {
		this.contFechCont = contFechCont;
	}

	@Column(name = "NECE_TIPO", nullable = false, length = 20)
	public String getNeceTipo() {
		return this.neceTipo;
	}

	public void setNeceTipo(String neceTipo) {
		this.neceTipo = neceTipo;
	}

	@Column(name = "CONT_TIPO_VTA", length = 20)
	public String getContTipoVta() {
		return this.contTipoVta;
	}

	public void setContTipoVta(String contTipoVta) {
		this.contTipoVta = contTipoVta;
	}

	@Column(name = "MONE_COD_VTA", length = 10)
	public String getMoneCodVta() {
		return this.moneCodVta;
	}

	public void setMoneCodVta(String moneCodVta) {
		this.moneCodVta = moneCodVta;
	}

	@Column(name = "FOGE_COD", length = 20)
	public String getFogeCod() {
		return this.fogeCod;
	}

	public void setFogeCod(String fogeCod) {
		this.fogeCod = fogeCod;
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

	@Column(name = "SEPU_NUM_CPTOS", precision = 4, scale = 0)
	public Short getSepuNumCptos() {
		return this.sepuNumCptos;
	}

	public void setSepuNumCptos(Short sepuNumCptos) {
		this.sepuNumCptos = sepuNumCptos;
	}

	@Column(name = "SEPU_NUM_REDU", precision = 4, scale = 0)
	public Short getSepuNumRedu() {
		return this.sepuNumRedu;
	}

	public void setSepuNumRedu(Short sepuNumRedu) {
		this.sepuNumRedu = sepuNumRedu;
	}

	@Column(name = "CONT_SEPU_TMP_PER", length = 20)
	public String getContSepuTmpPer() {
		return this.contSepuTmpPer;
	}

	public void setContSepuTmpPer(String contSepuTmpPer) {
		this.contSepuTmpPer = contSepuTmpPer;
	}

	@Column(name = "CONT_SEPU_TRRA_HORM", length = 20)
	public String getContSepuTrraHorm() {
		return this.contSepuTrraHorm;
	}

	public void setContSepuTrraHorm(String contSepuTrraHorm) {
		this.contSepuTrraHorm = contSepuTrraHorm;
	}

	@Column(name = "SEPU_CRAC", length = 20)
	public String getSepuCrac() {
		return this.sepuCrac;
	}

	public void setSepuCrac(String sepuCrac) {
		this.sepuCrac = sepuCrac;
	}

	@Column(name = "CONT_SEPU_MES_REST", precision = 5, scale = 0)
	public Integer getContSepuMesRest() {
		return this.contSepuMesRest;
	}

	public void setContSepuMesRest(Integer contSepuMesRest) {
		this.contSepuMesRest = contSepuMesRest;
	}

	@Column(name = "CONT_PRCO_LISTA_UF", precision = 14)
	public BigDecimal getContPrcoListaUf() {
		return this.contPrcoListaUf;
	}

	public void setContPrcoListaUf(BigDecimal contPrcoListaUf) {
		this.contPrcoListaUf = contPrcoListaUf;
	}

	@Column(name = "CONT_PRCO_VTA_PESO", precision = 14, scale = 0)
	public Long getContPrcoVtaPeso() {
		return this.contPrcoVtaPeso;
	}

	public void setContPrcoVtaPeso(Long contPrcoVtaPeso) {
		this.contPrcoVtaPeso = contPrcoVtaPeso;
	}

	@Column(name = "CONT_PRCO_VTA_UF", precision = 14)
	public BigDecimal getContPrcoVtaUf() {
		return this.contPrcoVtaUf;
	}

	public void setContPrcoVtaUf(BigDecimal contPrcoVtaUf) {
		this.contPrcoVtaUf = contPrcoVtaUf;
	}

	@Column(name = "CONT_MNTO_PIE_PESOS", precision = 14, scale = 0)
	public Long getContMntoPiePesos() {
		return this.contMntoPiePesos;
	}

	public void setContMntoPiePesos(Long contMntoPiePesos) {
		this.contMntoPiePesos = contMntoPiePesos;
	}

	@Column(name = "CONT_MNTO_PIE_UF", precision = 14)
	public BigDecimal getContMntoPieUf() {
		return this.contMntoPieUf;
	}

	public void setContMntoPieUf(BigDecimal contMntoPieUf) {
		this.contMntoPieUf = contMntoPieUf;
	}

	@Column(name = "CONT_MNTO_CRED_PESO", precision = 14, scale = 0)
	public Long getContMntoCredPeso() {
		return this.contMntoCredPeso;
	}

	public void setContMntoCredPeso(Long contMntoCredPeso) {
		this.contMntoCredPeso = contMntoCredPeso;
	}

	@Column(name = "CONT_MNTO_CRED_UF", precision = 14)
	public BigDecimal getContMntoCredUf() {
		return this.contMntoCredUf;
	}

	public void setContMntoCredUf(BigDecimal contMntoCredUf) {
		this.contMntoCredUf = contMntoCredUf;
	}

	@Column(name = "CONT_VAL_CUOT_CRED", precision = 14)
	public BigDecimal getContValCuotCred() {
		return this.contValCuotCred;
	}

	public void setContValCuotCred(BigDecimal contValCuotCred) {
		this.contValCuotCred = contValCuotCred;
	}

	@Column(name = "CONT_MA_LISTA", precision = 14)
	public BigDecimal getContMaLista() {
		return this.contMaLista;
	}

	public void setContMaLista(BigDecimal contMaLista) {
		this.contMaLista = contMaLista;
	}

	@Column(name = "CONT_MA_VTA", precision = 14)
	public BigDecimal getContMaVta() {
		return this.contMaVta;
	}

	public void setContMaVta(BigDecimal contMaVta) {
		this.contMaVta = contMaVta;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CONT_FECH_CUOT_MANT", length = 7)
	public Date getContFechCuotMant() {
		return this.contFechCuotMant;
	}

	public void setContFechCuotMant(Date contFechCuotMant) {
		this.contFechCuotMant = contFechCuotMant;
	}

	@Column(name = "CONT_VAL_CUOT_MANT", precision = 14)
	public BigDecimal getContValCuotMant() {
		return this.contValCuotMant;
	}

	public void setContValCuotMant(BigDecimal contValCuotMant) {
		this.contValCuotMant = contValCuotMant;
	}

	@Column(name = "CONT_IND_PAC_CRED", length = 2)
	public String getContIndPacCred() {
		return this.contIndPacCred;
	}

	public void setContIndPacCred(String contIndPacCred) {
		this.contIndPacCred = contIndPacCred;
	}

	@Column(name = "CONT_IND_PAC_MANT", length = 2)
	public String getContIndPacMant() {
		return this.contIndPacMant;
	}

	public void setContIndPacMant(String contIndPacMant) {
		this.contIndPacMant = contIndPacMant;
	}

	@Column(name = "CONT_IND_BENE_PAC", length = 2)
	public String getContIndBenePac() {
		return this.contIndBenePac;
	}

	public void setContIndBenePac(String contIndBenePac) {
		this.contIndBenePac = contIndBenePac;
	}

	@Column(name = "CONT_IND_CLAU_ANX_SEG", length = 2)
	public String getContIndClauAnxSeg() {
		return this.contIndClauAnxSeg;
	}

	public void setContIndClauAnxSeg(String contIndClauAnxSeg) {
		this.contIndClauAnxSeg = contIndClauAnxSeg;
	}

	@Column(name = "CONT_IND_DCL_SEG_SAL", length = 2)
	public String getContIndDclSegSal() {
		return this.contIndDclSegSal;
	}

	public void setContIndDclSegSal(String contIndDclSegSal) {
		this.contIndDclSegSal = contIndDclSegSal;
	}

	@Column(name = "CONT_IND_FCP_CMP_DOMI", length = 2)
	public String getContIndFcpCmpDomi() {
		return this.contIndFcpCmpDomi;
	}

	public void setContIndFcpCmpDomi(String contIndFcpCmpDomi) {
		this.contIndFcpCmpDomi = contIndFcpCmpDomi;
	}

	@Column(name = "CONT_IND_ASIST_DECESO", length = 2)
	public String getContIndAsistDeceso() {
		return this.contIndAsistDeceso;
	}

	public void setContIndAsistDeceso(String contIndAsistDeceso) {
		this.contIndAsistDeceso = contIndAsistDeceso;
	}

	@Column(name = "CONT_IND_FTCP_CEDU_ID", length = 2)
	public String getContIndFtcpCeduId() {
		return this.contIndFtcpCeduId;
	}

	public void setContIndFtcpCeduId(String contIndFtcpCeduId) {
		this.contIndFtcpCeduId = contIndFtcpCeduId;
	}

	@Column(name = "CONT_IND_MNDTO_DICOM", length = 2)
	public String getContIndMndtoDicom() {
		return this.contIndMndtoDicom;
	}

	public void setContIndMndtoDicom(String contIndMndtoDicom) {
		this.contIndMndtoDicom = contIndMndtoDicom;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CONT_FECH_INGR", length = 7)
	public Date getContFechIngr() {
		return this.contFechIngr;
	}

	public void setContFechIngr(Date contFechIngr) {
		this.contFechIngr = contFechIngr;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CONT_FECH_LIMI", length = 7)
	public Date getContFechLimi() {
		return this.contFechLimi;
	}

	public void setContFechLimi(Date contFechLimi) {
		this.contFechLimi = contFechLimi;
	}

	@Column(name = "CONT_VERI_ESTA_COD", length = 20)
	public String getContVeriEstaCod() {
		return this.contVeriEstaCod;
	}

	public void setContVeriEstaCod(String contVeriEstaCod) {
		this.contVeriEstaCod = contVeriEstaCod;
	}

	@Column(name = "CONT_USER_MOD", nullable = false, length = 20)
	public String getContUserMod() {
		return this.contUserMod;
	}

	public void setContUserMod(String contUserMod) {
		this.contUserMod = contUserMod;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CONT_FEC_MOD", nullable = false, length = 7)
	public Date getContFecMod() {
		return this.contFecMod;
	}

	public void setContFecMod(Date contFecMod) {
		this.contFecMod = contFecMod;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CONT_VERI_ESTA_FEC_MOD", length = 7)
	public Date getContVeriEstaFecMod() {
		return this.contVeriEstaFecMod;
	}

	public void setContVeriEstaFecMod(Date contVeriEstaFecMod) {
		this.contVeriEstaFecMod = contVeriEstaFecMod;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CONT_FECH_EMI", length = 7)
	public Date getContFechEmi() {
		return this.contFechEmi;
	}

	public void setContFechEmi(Date contFechEmi) {
		this.contFechEmi = contFechEmi;
	}

	@Column(name = "CONT_DESP_ESTA_COD", length = 20)
	public String getContDespEstaCod() {
		return this.contDespEstaCod;
	}

	public void setContDespEstaCod(String contDespEstaCod) {
		this.contDespEstaCod = contDespEstaCod;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CONT_FECH_REST_ORIG", length = 7)
	public Date getContFechRestOrig() {
		return this.contFechRestOrig;
	}

	public void setContFechRestOrig(Date contFechRestOrig) {
		this.contFechRestOrig = contFechRestOrig;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CONT_FECH_REST_ACT", length = 7)
	public Date getContFechRestAct() {
		return this.contFechRestAct;
	}

	public void setContFechRestAct(Date contFechRestAct) {
		this.contFechRestAct = contFechRestAct;
	}

	@Column(name = "CONT_ESTA_COD", length = 20)
	public String getContEstaCod() {
		return this.contEstaCod;
	}

	public void setContEstaCod(String contEstaCod) {
		this.contEstaCod = contEstaCod;
	}

	@Column(name = "CONT_IND_BLOQUEO", length = 2)
	public String getContIndBloqueo() {
		return this.contIndBloqueo;
	}

	public void setContIndBloqueo(String contIndBloqueo) {
		this.contIndBloqueo = contIndBloqueo;
	}

	@Column(name = "CONT_REG_TITULO", precision = 10, scale = 0)
	public Long getContRegTitulo() {
		return this.contRegTitulo;
	}

	public void setContRegTitulo(Long contRegTitulo) {
		this.contRegTitulo = contRegTitulo;
	}

	@Column(name = "FLED_SEC", precision = 23, scale = 0)
	public BigDecimal getFledSec() {
		return this.fledSec;
	}

	public void setFledSec(BigDecimal fledSec) {
		this.fledSec = fledSec;
	}

	@Column(name = "CONT_IND_SMAD", length = 2)
	public String getContIndSmad() {
		return this.contIndSmad;
	}

	public void setContIndSmad(String contIndSmad) {
		this.contIndSmad = contIndSmad;
	}

	@Column(name = "CONT_IND_CLAU_SEG_MANT", length = 2)
	public String getContIndClauSegMant() {
		return this.contIndClauSegMant;
	}

	public void setContIndClauSegMant(String contIndClauSegMant) {
		this.contIndClauSegMant = contIndClauSegMant;
	}

	@Column(name = "CONT_CLAU_COMPL_UF", precision = 14)
	public BigDecimal getContClauComplUf() {
		return this.contClauComplUf;
	}

	public void setContClauComplUf(BigDecimal contClauComplUf) {
		this.contClauComplUf = contClauComplUf;
	}

	@Column(name = "CONT_CLAU_COMPL_PESO", precision = 14, scale = 0)
	public Long getContClauComplPeso() {
		return this.contClauComplPeso;
	}

	public void setContClauComplPeso(Long contClauComplPeso) {
		this.contClauComplPeso = contClauComplPeso;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vtaContratos")
	public Set<VtaPgreOperContModel> getVtaPgreOperConts() {
		return this.vtaPgreOperConts;
	}

	public void setVtaPgreOperConts(Set<VtaPgreOperContModel> vtaPgreOperConts) {
		this.vtaPgreOperConts = vtaPgreOperConts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vtaContratos")
	public Set<CbzSimulacionModel> getCbzSimulacions() {
		return this.cbzSimulacions;
	}

	public void setCbzSimulacions(Set<CbzSimulacionModel> cbzSimulacions) {
		this.cbzSimulacions = cbzSimulacions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vtaContratos")
	public Set<CobContMantencionModel> getCobContMantencions() {
		return this.cobContMantencions;
	}

	public void setCobContMantencions(Set<CobContMantencionModel> cobContMantencions) {
		this.cobContMantencions = cobContMantencions;
	}

}
