package com.lib.common.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Table(name = "COB_CAMP_CONT", schema = "COBPAR")
public class CobCampContModel implements java.io.Serializable {

	private static final long serialVersionUID = 7586500025348608150L;
	private BigDecimal vtopCodCont;
	private GenPersonasModel genPersonas;
	private CobCampagnaModel cobCampagna;
	private VtaContratosModel vtaContratos;
	private String cactIndReneg;
	private String cactIndMntoFijoCuot;
	private BigDecimal cactAbonoMinCuot;
	private long cactValorMinCuotPeso;
	private String campIndDefault;
	private String campIndIntMora;
	private String campIndGtosReneg;
	private String campIndPagoCuot;
	private BigDecimal campTasaUf;
	private BigDecimal campTasaPeso;
	private byte campCantPgre;
	private String campIndOtros;
	private String campIndMediaCuot;
	private short campNumCuotMax;
	private short campCuotPrimerPgre;
	private String cactUserMod;
	private Date cactFecMod;

	public CobCampContModel() {
	}

	public CobCampContModel(CobCampagnaModel cobCampagna, VtaContratosModel vtaContratos, String cactIndReneg,
			String cactIndMntoFijoCuot, BigDecimal cactAbonoMinCuot, long cactValorMinCuotPeso, String campIndDefault,
			String campIndIntMora, String campIndGtosReneg, String campIndPagoCuot, BigDecimal campTasaUf,
			BigDecimal campTasaPeso, byte campCantPgre, String campIndOtros, String campIndMediaCuot,
			short campNumCuotMax, short campCuotPrimerPgre, String cactUserMod, Date cactFecMod) {
		this.cobCampagna = cobCampagna;
		this.vtaContratos = vtaContratos;
		this.cactIndReneg = cactIndReneg;
		this.cactIndMntoFijoCuot = cactIndMntoFijoCuot;
		this.cactAbonoMinCuot = cactAbonoMinCuot;
		this.cactValorMinCuotPeso = cactValorMinCuotPeso;
		this.campIndDefault = campIndDefault;
		this.campIndIntMora = campIndIntMora;
		this.campIndGtosReneg = campIndGtosReneg;
		this.campIndPagoCuot = campIndPagoCuot;
		this.campTasaUf = campTasaUf;
		this.campTasaPeso = campTasaPeso;
		this.campCantPgre = campCantPgre;
		this.campIndOtros = campIndOtros;
		this.campIndMediaCuot = campIndMediaCuot;
		this.campNumCuotMax = campNumCuotMax;
		this.campCuotPrimerPgre = campCuotPrimerPgre;
		this.cactUserMod = cactUserMod;
		this.cactFecMod = cactFecMod;
	}

	public CobCampContModel(GenPersonasModel genPersonas, CobCampagnaModel cobCampagna, VtaContratosModel vtaContratos, String cactIndReneg,
			String cactIndMntoFijoCuot, BigDecimal cactAbonoMinCuot, long cactValorMinCuotPeso, String campIndDefault,
			String campIndIntMora, String campIndGtosReneg, String campIndPagoCuot, BigDecimal campTasaUf,
			BigDecimal campTasaPeso, byte campCantPgre, String campIndOtros, String campIndMediaCuot,
			short campNumCuotMax, short campCuotPrimerPgre, String cactUserMod, Date cactFecMod) {
		this.genPersonas = genPersonas;
		this.cobCampagna = cobCampagna;
		this.vtaContratos = vtaContratos;
		this.cactIndReneg = cactIndReneg;
		this.cactIndMntoFijoCuot = cactIndMntoFijoCuot;
		this.cactAbonoMinCuot = cactAbonoMinCuot;
		this.cactValorMinCuotPeso = cactValorMinCuotPeso;
		this.campIndDefault = campIndDefault;
		this.campIndIntMora = campIndIntMora;
		this.campIndGtosReneg = campIndGtosReneg;
		this.campIndPagoCuot = campIndPagoCuot;
		this.campTasaUf = campTasaUf;
		this.campTasaPeso = campTasaPeso;
		this.campCantPgre = campCantPgre;
		this.campIndOtros = campIndOtros;
		this.campIndMediaCuot = campIndMediaCuot;
		this.campNumCuotMax = campNumCuotMax;
		this.campCuotPrimerPgre = campCuotPrimerPgre;
		this.cactUserMod = cactUserMod;
		this.cactFecMod = cactFecMod;
	}

	@GenericGenerator(name = "com.pdr.cobranza.cliente.entity.CobCampContIdGenerator", strategy = "foreign", parameters = @Parameter(name = "property", value = "vtaContratos"))
	@Id
	@GeneratedValue(generator = "com.pdr.cobranza.cliente.entity.CobCampContIdGenerator")

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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CAMP_COD", nullable = false)
	public CobCampagnaModel getCobCampagna() {
		return this.cobCampagna;
	}

	public void setCobCampagna(CobCampagnaModel cobCampagna) {
		this.cobCampagna = cobCampagna;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public VtaContratosModel getVtaContratos() {
		return this.vtaContratos;
	}

	public void setVtaContratos(VtaContratosModel vtaContratos) {
		this.vtaContratos = vtaContratos;
	}

	@Column(name = "CACT_IND_RENEG", nullable = false, length = 2)
	public String getCactIndReneg() {
		return this.cactIndReneg;
	}

	public void setCactIndReneg(String cactIndReneg) {
		this.cactIndReneg = cactIndReneg;
	}

	@Column(name = "CACT_IND_MNTO_FIJO_CUOT", nullable = false, length = 2)
	public String getCactIndMntoFijoCuot() {
		return this.cactIndMntoFijoCuot;
	}

	public void setCactIndMntoFijoCuot(String cactIndMntoFijoCuot) {
		this.cactIndMntoFijoCuot = cactIndMntoFijoCuot;
	}

	@Column(name = "CACT_ABONO_MIN_CUOT", nullable = false, precision = 14)
	public BigDecimal getCactAbonoMinCuot() {
		return this.cactAbonoMinCuot;
	}

	public void setCactAbonoMinCuot(BigDecimal cactAbonoMinCuot) {
		this.cactAbonoMinCuot = cactAbonoMinCuot;
	}

	@Column(name = "CACT_VALOR_MIN_CUOT_PESO", nullable = false, precision = 14, scale = 0)
	public long getCactValorMinCuotPeso() {
		return this.cactValorMinCuotPeso;
	}

	public void setCactValorMinCuotPeso(long cactValorMinCuotPeso) {
		this.cactValorMinCuotPeso = cactValorMinCuotPeso;
	}

	@Column(name = "CAMP_IND_DEFAULT", nullable = false, length = 2)
	public String getCampIndDefault() {
		return this.campIndDefault;
	}

	public void setCampIndDefault(String campIndDefault) {
		this.campIndDefault = campIndDefault;
	}

	@Column(name = "CAMP_IND_INT_MORA", nullable = false, length = 2)
	public String getCampIndIntMora() {
		return this.campIndIntMora;
	}

	public void setCampIndIntMora(String campIndIntMora) {
		this.campIndIntMora = campIndIntMora;
	}

	@Column(name = "CAMP_IND_GTOS_RENEG", nullable = false, length = 2)
	public String getCampIndGtosReneg() {
		return this.campIndGtosReneg;
	}

	public void setCampIndGtosReneg(String campIndGtosReneg) {
		this.campIndGtosReneg = campIndGtosReneg;
	}

	@Column(name = "CAMP_IND_PAGO_CUOT", nullable = false, length = 2)
	public String getCampIndPagoCuot() {
		return this.campIndPagoCuot;
	}

	public void setCampIndPagoCuot(String campIndPagoCuot) {
		this.campIndPagoCuot = campIndPagoCuot;
	}

	@Column(name = "CAMP_TASA_UF", nullable = false, precision = 4)
	public BigDecimal getCampTasaUf() {
		return this.campTasaUf;
	}

	public void setCampTasaUf(BigDecimal campTasaUf) {
		this.campTasaUf = campTasaUf;
	}

	@Column(name = "CAMP_TASA_PESO", nullable = false, precision = 4)
	public BigDecimal getCampTasaPeso() {
		return this.campTasaPeso;
	}

	public void setCampTasaPeso(BigDecimal campTasaPeso) {
		this.campTasaPeso = campTasaPeso;
	}

	@Column(name = "CAMP_CANT_PGRE", nullable = false, precision = 2, scale = 0)
	public byte getCampCantPgre() {
		return this.campCantPgre;
	}

	public void setCampCantPgre(byte campCantPgre) {
		this.campCantPgre = campCantPgre;
	}

	@Column(name = "CAMP_IND_OTROS", nullable = false, length = 2)
	public String getCampIndOtros() {
		return this.campIndOtros;
	}

	public void setCampIndOtros(String campIndOtros) {
		this.campIndOtros = campIndOtros;
	}

	@Column(name = "CAMP_IND_MEDIA_CUOT", nullable = false, length = 2)
	public String getCampIndMediaCuot() {
		return this.campIndMediaCuot;
	}

	public void setCampIndMediaCuot(String campIndMediaCuot) {
		this.campIndMediaCuot = campIndMediaCuot;
	}

	@Column(name = "CAMP_NUM_CUOT_MAX", nullable = false, precision = 3, scale = 0)
	public short getCampNumCuotMax() {
		return this.campNumCuotMax;
	}

	public void setCampNumCuotMax(short campNumCuotMax) {
		this.campNumCuotMax = campNumCuotMax;
	}

	@Column(name = "CAMP_CUOT_PRIMER_PGRE", nullable = false, precision = 3, scale = 0)
	public short getCampCuotPrimerPgre() {
		return this.campCuotPrimerPgre;
	}

	public void setCampCuotPrimerPgre(short campCuotPrimerPgre) {
		this.campCuotPrimerPgre = campCuotPrimerPgre;
	}

	@Column(name = "CACT_USER_MOD", nullable = false, length = 30)
	public String getCactUserMod() {
		return this.cactUserMod;
	}

	public void setCactUserMod(String cactUserMod) {
		this.cactUserMod = cactUserMod;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CACT_FEC_MOD", nullable = false, length = 7)
	public Date getCactFecMod() {
		return this.cactFecMod;
	}

	public void setCactFecMod(Date cactFecMod) {
		this.cactFecMod = cactFecMod;
	}

}
