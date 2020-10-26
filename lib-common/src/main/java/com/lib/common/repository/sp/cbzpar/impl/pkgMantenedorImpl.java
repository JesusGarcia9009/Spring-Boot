package com.lib.common.repository.sp.cbzpar.impl;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.lib.common.dto.AsignacionResponseDTO;
import com.lib.common.dto.EjecutivoDTO;
import com.lib.common.dto.PrevisualizacionRequestDTO;
import com.lib.common.dto.PrevisualizarResponseDTO;
import com.lib.common.entity.CbzCatalogoPgreDetalleTempModel;
import com.lib.common.exception.StoredProcedureException;
import com.lib.common.repository.sp.cbzpar.pkgMantenedor;
import com.lib.common.utils.GenericUtils;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class pkgMantenedorImpl implements pkgMantenedor {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// VARIABLES
	public static final String SCHEMA = "CBZPAR";
	public static final String CATALOG = "PKG_MANTENEDOR";
	public static final String CURSOR = "P_CURSOR";
	public static final String P_CODE = "P_CODE";
	public static final String P_ERRM = "P_ERRM";
	public static final String P_SUPERVISOR = "P_SUPERVISOR";

	public static final String PI_ID_CPC_PERIODO = "PI_ID_CPC_PERIODO";
	public static final String PI_UF_VAL = "PI_UF_VAL";
	public static final String PI_TIPO_CARTERA = "PI_TIPO_CARTERA";
	public static final String PI_TIPO_FASE = "PI_TIPO_FASE";
	public static final String PI_ESTADO_PERIODO = "PI_ESTADO_PERIODO";

	@Override
	@SuppressWarnings("unchecked")
	public List<CbzCatalogoPgreDetalleTempModel> procContratosByCriterioUno(Long criterioUnoId, String tipoAsignacion)
			throws StoredProcedureException {
		log.info("[procContratosByCriterioUno] :: inicio del metodo");
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName(SCHEMA).withCatalogName(CATALOG)
				.withProcedureName("PROC_OBTENER_DATA_CRITERIO")
				.declareParameters(new SqlOutParameter(CURSOR, Types.REF_CURSOR),
						new SqlParameter("ID_CRITERIO_UNO", Types.NUMERIC),
						new SqlParameter("TIPO_ASIGNACION", Types.VARCHAR))
				.returningResultSet(CURSOR, new RowMapper<CbzCatalogoPgreDetalleTempModel>() {
					@Override
					public CbzCatalogoPgreDetalleTempModel mapRow(ResultSet rs, int rowNum) throws SQLException {
						return mapRowCatalogoPgreDetalleTemp(rs);
					}
				});

		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("ID_CRITERIO_UNO", criterioUnoId)
				.addValue("TIPO_ASIGNACION", tipoAsignacion);

		jdbcCall.compile();
		Map<String, ?> map = jdbcCall.execute(paramMap);

		// Error en el SP
		Integer valorError = Integer.valueOf(map.get(P_CODE) == null ? "0" : map.get(P_CODE).toString());
		if (valorError != 0) {
			throw StoredProcedureException.createWith("PROC_CONTRATOS_CRITERIO_UNO", valorError.toString(),
					(String) map.get(P_ERRM));
		}

		List<CbzCatalogoPgreDetalleTempModel> result = (List<CbzCatalogoPgreDetalleTempModel>) map.get(CURSOR);

		log.info("[procContratosByCriterioUno] :: fin del metodo");
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EjecutivoDTO> getDatosEjecutivos(String idSupervisor) throws StoredProcedureException {
		log.info("[getDatosEjecutivos] :: inicio del metodo");
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName(SCHEMA).withCatalogName(CATALOG)
				.withProcedureName("PROC_DATOS_EJECUTIVOS")
				.declareParameters(new SqlOutParameter(CURSOR, Types.REF_CURSOR),
						new SqlParameter(P_SUPERVISOR, Types.VARCHAR))
				.returningResultSet(CURSOR, new RowMapper<EjecutivoDTO>() {
					@Override
					public EjecutivoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
						return mapRowEjecutivoCobranza(rs);
					}
				});

		SqlParameterSource paramMap = new MapSqlParameterSource().addValue(P_SUPERVISOR, idSupervisor);

		jdbcCall.compile();
		Map<String, ?> map = jdbcCall.execute(paramMap);
		List<EjecutivoDTO> result = (List<EjecutivoDTO>) map.get(CURSOR);

		// Error en el SP
		Integer valorError = Integer.valueOf(map.get(P_CODE) == null ? "0" : map.get(P_CODE).toString());
		if (valorError != 0) {
			throw StoredProcedureException.createWith("PROC_DATOS_EJECUTIVOS", valorError.toString(),
					(String) map.get(P_ERRM));
		}

		log.info("[getDatosEjecutivos] :: fin del metodo");
		return result;
	}

	

	@SuppressWarnings("unchecked")
	@Override
	public List<PrevisualizarResponseDTO> getDatosPrevisualizacion(Long idCpcPeriodo, BigDecimal valorUF, String tipoCartera,
			String tipoFase, String estadoPeriodo) throws StoredProcedureException {

		log.info("[getDatosPrevisualizacion] :: inicio del metodo");
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName(SCHEMA).withCatalogName(CATALOG)
				.withProcedureName("PROC_DATOS_PREVISUALIZACION")
				.declareParameters(
					    new SqlParameter(PI_ID_CPC_PERIODO, Types.NUMERIC),
						new SqlParameter(PI_UF_VAL, Types.NUMERIC),
						new SqlParameter(PI_TIPO_CARTERA, Types.VARCHAR),
						new SqlParameter(PI_TIPO_FASE, Types.VARCHAR),
						new SqlParameter(PI_ESTADO_PERIODO, Types.VARCHAR),
						new SqlOutParameter(CURSOR, Types.REF_CURSOR)
						)
				.returningResultSet(CURSOR, new RowMapper<PrevisualizarResponseDTO>() {
					@Override
					public PrevisualizarResponseDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
						return mapRowPRevisualizar(rs);
					}
				});

		SqlParameterSource paramMap = 
					new MapSqlParameterSource()
						.addValue(PI_ID_CPC_PERIODO, idCpcPeriodo)
						.addValue(PI_UF_VAL, valorUF)
						.addValue(PI_TIPO_CARTERA, tipoCartera)
						.addValue(PI_TIPO_FASE, tipoFase)
						.addValue(PI_ESTADO_PERIODO, estadoPeriodo.toUpperCase());
						
		jdbcCall.compile();
		Map<String, ?> map = jdbcCall.execute(paramMap);
		List<PrevisualizarResponseDTO> result = (List<PrevisualizarResponseDTO>) map.get(CURSOR);

		// Error en el SP
		Integer valorError = Integer.valueOf(map.get(P_CODE) == null ? "0" : map.get(P_CODE).toString());
		if (valorError != 0) {
			throw StoredProcedureException.createWith("PROC_DATOS_PREVISUALIZACION", valorError.toString(),
					(String) map.get(P_ERRM));
		}

		log.info("[getDatosPrevisualizacion] :: fin del metodo");
		return result;

	}
	
	@Override
	public AsignacionResponseDTO visualizarRegla(Integer idCpcPeriodo) throws StoredProcedureException {
		log.info("[visualizarRegla] :: inicio del metodo");
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName(SCHEMA).withCatalogName(CATALOG)
				.withProcedureName("PROC_VISUALIZAR_REGLA")
				.declareParameters(new SqlParameter("P_ID_CPC_PERIODO", Types.NUMERIC));

		SqlParameterSource paramMap = 
					new MapSqlParameterSource()
						.addValue("P_ID_CPC_PERIODO", idCpcPeriodo);
						
		jdbcCall.compile();
		Map<String, ?> map = jdbcCall.execute(paramMap);

		// Error en el SP
		Integer valorError = Integer.valueOf(map.get(P_CODE) == null ? "0" : map.get(P_CODE).toString());
		if (valorError != 0) {
			throw StoredProcedureException.createWith("PROC_VISUALIZAR_REGLA", valorError.toString(),
					(String) map.get(P_ERRM));
		}
		
		BigDecimal totalContratosRestantes = GenericUtils.ifNullisCero(map.get("P_CONTRATOS"));
        BigDecimal totalUfRestantes = GenericUtils.ifNullisCero(map.get("P_UF"));

		log.info("[visualizarRegla] :: fin del metodo");
		return new AsignacionResponseDTO(totalContratosRestantes, totalUfRestantes) ;
	}

	@Override
	public AsignacionResponseDTO previsualizarRegla(PrevisualizacionRequestDTO previsualizacion)
			throws StoredProcedureException {
		log.info("[previsualizarRegla] :: inicio del metodo");
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName(SCHEMA).withCatalogName(CATALOG)
				.withProcedureName("PROC_PRE_VISUALIZAR_REGLA")
				.declareParameters( new SqlParameter("P_PRDO_COD", Types.VARCHAR),
									new SqlParameter("P_FASE_COD", Types.VARCHAR),
									new SqlParameter("P_RENEG_DESDE", Types.NUMERIC),
									new SqlParameter("P_RENEG_HASTA", Types.NUMERIC),
									new SqlParameter("P_CUOTAS_DESDE", Types.NUMERIC),
									new SqlParameter("P_CUOTAS_HASTA", Types.NUMERIC));

		SqlParameterSource paramMap = 
					new MapSqlParameterSource()
						.addValue("P_PRDO_COD", previsualizacion.getPrdoCod())
						.addValue("P_FASE_COD", previsualizacion.getCuCodFase())
						.addValue("P_RENEG_DESDE", previsualizacion.getCuNumRenegDesde())
						.addValue("P_RENEG_HASTA", previsualizacion.getCuNumRenegHasta())
						.addValue("P_CUOTAS_DESDE", previsualizacion.getCuotasDesde())
						.addValue("P_CUOTAS_HASTA", previsualizacion.getCuotasHasta());
						
		jdbcCall.compile();
		Map<String, ?> map = jdbcCall.execute(paramMap);

		// Error en el SP
		Integer valorError = Integer.valueOf(map.get(P_CODE) == null ? "0" : map.get(P_CODE).toString());
		if (valorError != 0) {
			throw StoredProcedureException.createWith("PROC_PRE_VISUALIZAR_REGLA", valorError.toString(),
					(String) map.get(P_ERRM));
		}
		
		BigDecimal totalContratosRestantes = GenericUtils.ifNullisCero(map.get("P_CONTRATOS"));
        BigDecimal totalUfRestantes = GenericUtils.ifNullisCero(map.get("P_UF"));

		log.info("[previsualizarRegla] :: fin del metodo");
		return new AsignacionResponseDTO(totalContratosRestantes, totalUfRestantes) ;
	}


	private PrevisualizarResponseDTO mapRowPRevisualizar(ResultSet rs) throws SQLException {
		PrevisualizarResponseDTO result = new PrevisualizarResponseDTO();
		result.setCriteriosAsignacion(GenericUtils.ifNullisBlank(rs.getObject("CRITERIOS_ASIGN")));
		result.setNContratos(GenericUtils.ifNullisCero(rs.getObject("N_CONTRATOS")).longValue());
		result.setNombreEjecutivo(GenericUtils.ifNullisBlank(rs.getObject("NOMBRE_COBR")));
		result.setPmtSaldoUf(GenericUtils.ifNullisCero(rs.getObject("SUMA_SALDO_UF")));

		return result;
	}
	
	
	private CbzCatalogoPgreDetalleTempModel mapRowCatalogoPgreDetalleTemp(ResultSet rs) throws SQLException {
		CbzCatalogoPgreDetalleTempModel result = new CbzCatalogoPgreDetalleTempModel();

		result.setIdCatPgreDetalleTemp(null);
		result.setIdCatPgreDetalle(GenericUtils.ifNullisCero(rs.getObject("ID_CAT_PGRE_DETALLE")));
		result.setIdUsuarioAsignado(GenericUtils.ifNullisCero(rs.getObject("ID_USUARIO_ASIGNADO")));
		result.setCdetCuotaTotConReneg(GenericUtils.ifNullisCero(rs.getObject("CDET_CUOTA_TOT_CON_RENEG")).longValue());
		result.setCdetSec(GenericUtils.ifNullisCero(rs.getObject("CDET_SEC")));
		result.setCdetFechaContrato(GenericUtils.ifNullisDate(rs.getObject("CDET_FECHA_CONTRATO")));
		result.setCdetSaldoPmt(GenericUtils.ifNullisCero(rs.getObject("CDET_SALDO_PMT")));
		result.setCdetFechaUltPgo(GenericUtils.ifNullisDate(rs.getObject("CDET_FECHA_ULT_PGO")));
		result.setCdetFechaPriVencMora(GenericUtils.ifNullisDate(rs.getObject("CDET_FECHA_PRI_VENC_MORA")));
		result.setCdetNumreneg(GenericUtils.ifNullisCero(rs.getObject("CDET_NUMRENEG")).longValue());
		result.setCdetFechaUltreneg(GenericUtils.ifNullisDate(rs.getObject("CDET_FECHA_ULTRENEG")));
		result.setCdetSepultado(
				GenericUtils.ifNullisBlank(rs.getObject("CDET_SEPULTADO")).equals("1") ? Boolean.TRUE : Boolean.FALSE);
		result.setCdetCampanaVig(GenericUtils.ifNullisBlank(rs.getObject("CDET_CAMPANA_VIG")));
		result.setCdetAbonoreneg(GenericUtils.ifNullisCero(rs.getObject("CDET_ABONORENEG")));
		result.setCdetAbonorenegPac(GenericUtils.ifNullisCero(rs.getObject("CDET_ABONORENEG_PAC")));
		result.setCdetValCutaprom(GenericUtils.ifNullisCero(rs.getObject("CDET_VAL_CUTAPROM")));
		result.setCdetCuotasVenc(GenericUtils.ifNullisCero(rs.getObject("CDET_CUOTAS_VENC")));
		result.setCdetPmtVencidas(GenericUtils.ifNullisCero(rs.getObject("CDET_PMT_VENCIDAS")));
		result.setCdetCuotPend(GenericUtils.ifNullisCero(rs.getObject("CDET_CUOT_PEND")));
		result.setCdetCuotaOriginalCont(
				GenericUtils.ifNullisCero(rs.getObject("CDET_CUOTA_ORIGINAL_CONT")).longValue());
		result.setCdetCuototIncluReneg(GenericUtils.ifNullisCero(rs.getObject("CDET_CUOTOT_INCLU_RENEG")));
		result.setCdetComprFallecido(
				GenericUtils.ifNullisBlank(rs.getObject("CDET_COMPR_FALLECIDO")).equals("1") ? Boolean.TRUE
						: Boolean.FALSE);
		result.setNombreUsuario(GenericUtils.ifNullisBlank(rs.getObject("NOMBRE_USUARIO")));
		result.setCdetPeriodo(GenericUtils.ifNullisBlank(rs.getObject("CDET_PERIODO")));
		result.setCdetNombreResponsable(GenericUtils.ifNullisBlank(rs.getObject("CDET_NOMBRE_RESPONSABLE")));
		result.setCdetValorVencido(GenericUtils.ifNullisBlank(rs.getObject("CDET_VALOR_VENCIDO")));
		result.setCdetUbicacion(GenericUtils.ifNullisBlank(rs.getObject("CDET_UBICACION")));
		result.setCdetContEstaCod(GenericUtils.ifNullisBlank(rs.getObject("CDET_CONT_ESTA_COD")));
		result.setCdetFechaComprFallecido(GenericUtils.ifNullisDate(rs.getObject("CDET_FECHA_COMPR_FALLECIDO")));
		result.setCdetSerieCod(GenericUtils.ifNullisBlank(rs.getObject("CDET_SERIE_COD")));
		result.setCdetProdCod(GenericUtils.ifNullisBlank(rs.getObject("CDET_PROD_COD")));
		result.setCdetPmtVencUf(GenericUtils.ifNullisCero(rs.getObject("CDET_PMT_VENC_UF")));
		result.setCdetPmtSaldoUf(GenericUtils.ifNullisCero(rs.getObject("CDET_PMT_SALDO_UF")));
		result.setCdetValorCuotaUf(GenericUtils.ifNullisCero(rs.getObject("CDET_VALOR_CUOTA_UF")));
		result.setCdetCantSepultados(GenericUtils.ifNullisCero(rs.getObject("CDET_CANT_SEPULTADOS")).longValue());
		result.setCdetIndContMandato(GenericUtils.ifNullisBlank(rs.getObject("CDET_IND_CONT_MANDATO")));
		result.setCdetFechaUltPgoDias(GenericUtils.ifNullisCero(rs.getObject("CDET_FECHA_ULT_PGO_DIAS")).intValue());
		result.setCdetFechaUltPgoMeses(GenericUtils.ifNullisCero(rs.getObject("CDET_FECHA_ULT_PGO_MESES")).intValue());
		result.setCdetFechaUltPgoTrimestres(
				GenericUtils.ifNullisCero(rs.getObject("CDET_FECHA_ULT_PGO_TRIMESTRES")).intValue());
		result.setCdetTotalFono(GenericUtils.ifNullisCero(rs.getObject("CDET_TOTAL_FONO")).intValue());
		result.setCdetRenegCuotasPag(GenericUtils.ifNullisCero(rs.getObject("CDET_RENEG_CUOTAS_PAG")).intValue());
		result.setCdetCodMoneda(GenericUtils.ifNullisBlank(rs.getObject("CDET_COD_MONEDA")));
		result.setIdCcpCampParam(GenericUtils.ifNullisCero(rs.getObject("ID_CCP_CAMP_PARAM")).longValue());
		result.setCdetCampFactor(GenericUtils.ifNullisCero(rs.getObject("CDET_CAMP_FACTOR")));
		result.setCdetCampAbonoMinUf(GenericUtils.ifNullisCero(rs.getObject("CDET_CAMP_ABONO_MIN_UF")));
		result.setCdetCampAbonoMinPesos(GenericUtils.ifNullisCero(rs.getObject("CDET_CAMP_ABONO_MIN_PESOS")));
		result.setCdetCampNombre(GenericUtils.ifNullisBlank(rs.getObject("CDET_CAMP_NOMBRE")));
		result.setIdCapAbminim(GenericUtils.ifNullisCero(rs.getObject("ID_CAP_ABMINIM")).longValue());
		result.setCdetAminPacpat(GenericUtils.ifNullisCero(rs.getObject("CDET_AMIN_PACPAT")));
		result.setCdetAminCrut(GenericUtils.ifNullisCero(rs.getObject("CDET_AMIN_CRUT")));
		result.setCdetAminPacpatPesos(GenericUtils.ifNullisCero(rs.getObject("CDET_AMIN_PACPAT_PESOS")));
		result.setCdetAminCrutPesos(GenericUtils.ifNullisCero(rs.getObject("CDET_AMIN_CRUT_PESOS")));
		result.setCdetAminPac(GenericUtils.ifNullisCero(rs.getObject("CDET_AMIN_PAC")));
		result.setCdetAminPacCtaRut(GenericUtils.ifNullisCero(rs.getObject("CDET_AMIN_PAC_CTA_RUT")));
		result.setIdCcpCategoria(GenericUtils.ifNullisCero(rs.getObject("ID_CCP_CATEGORIA")).longValue());
		result.setCdetCatNombCategoria(GenericUtils.ifNullisBlank(rs.getObject("CDET_CAT_NOMB_CATEGORIA")));
		result.setIdCspSegmentacion(GenericUtils.ifNullisCero(rs.getObject("ID_CSP_SEGMENTACION")).intValue());
		result.setCdetSegNombClasificacion(GenericUtils.ifNullisBlank(rs.getObject("CDET_SEG_NOMB_CLASIFICACION")));
		result.setRutCobr("");
		result.setNombreCobr("");
		result.setTipoCriterio(GenericUtils.ifNullisBlank(rs.getObject("TIPO_CRITERIO")));
		result.setCriterioAplicado(GenericUtils.ifNullisCero(rs.getObject("ID_CU_CRITERIO_UNO")).longValue());

		return result;
	}

	private EjecutivoDTO mapRowEjecutivoCobranza(ResultSet rs) throws SQLException {
		EjecutivoDTO result = new EjecutivoDTO();
		result.setNombre(GenericUtils.ifNullisBlank(rs.getObject("NOMBRE")));
		result.setIdEjecutivo(GenericUtils.ifNullisBlank(rs.getObject("RUT")));

		return result;
	}

	

}
