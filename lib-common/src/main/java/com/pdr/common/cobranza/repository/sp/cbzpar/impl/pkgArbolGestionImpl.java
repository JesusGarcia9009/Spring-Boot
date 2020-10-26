package com.pdr.common.cobranza.repository.sp.cbzpar.impl;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
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

import com.pdr.common.cobranza.repository.sp.cbzpar.pkgArbolGestion;
import com.pdr.common.dto.CarteraClienteDTO;
import com.pdr.common.dto.CarteraPkgRequestDTO;
import com.pdr.common.dto.CarteraVigenteDTO;
import com.pdr.common.dto.EjecutivoDTO;
import com.pdr.common.dto.MotoristaDTO;
import com.pdr.common.dto.PeriodoVigenteDTO;
import com.pdr.common.dto.ProcMotoristaDTO;
import com.pdr.common.dto.obtienPeriodoDTO;
import com.pdr.common.exception.StoredProcedureException;
import com.pdr.common.utils.GenericUtils;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class pkgArbolGestionImpl implements pkgArbolGestion {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public obtienPeriodoDTO obtienePeriodo() {
		return null;
	}

	// VARIABLES
	public static final String SCHEMA = "CBZPAR";
	public static final String CATALOG = "PKG_ARBOL_GESTION";
	public static final String CURSOR = "P_CURSOR";
	public static final String P_CODE = "P_CODE";
	public static final String P_ERRM = "P_ERRM";
	public static final String P_SUPERVISOR = "P_SUPERVISOR";
	
	public static final String PROC_DATOS_CARTERA = "PROC_DATOS_CARTERA_VIGENTE";

	@SuppressWarnings("unchecked")
	@Override
	public List<ProcMotoristaDTO> procProcesamientoMotorista(String ids, String codPeriodo, String persIdSupervisor)
			throws StoredProcedureException {
		log.info("[procProcesamientoMotorista] :: inicio del metodo");
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName(SCHEMA).withCatalogName(CATALOG)
				.withProcedureName("PROC_PROCESAMIENTO_MOTORISTA")
				.declareParameters(new SqlOutParameter(CURSOR, Types.REF_CURSOR),
						new SqlParameter("P_LISTADO", Types.VARCHAR), new SqlParameter("P_COD_CARTERA", Types.VARCHAR),
						new SqlParameter("P_SUP_MOTORISTA", Types.VARCHAR))
				.returningResultSet(CURSOR, new RowMapper<ProcMotoristaDTO>() {
					@Override
					public ProcMotoristaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
						return mapRowMotorista(rs);
					}
				});

		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("P_LISTADO", ids)
				.addValue("P_COD_CARTERA", codPeriodo).addValue("P_SUP_MOTORISTA", persIdSupervisor);

		jdbcCall.compile();
		Map<String, ?> map = jdbcCall.execute(paramMap);

		// Error en el SP
		Integer valorError = Integer.valueOf( map.get(P_CODE) == null ? "0" : map.get(P_CODE).toString());
		if (valorError != 0) {
			throw StoredProcedureException.createWith("PROC_PROCESAMIENTO_MOTORISTA", valorError.toString(), (String) map.get(P_ERRM));
		}

		List<ProcMotoristaDTO> result = (List<ProcMotoristaDTO>) map.get(CURSOR);

		log.info("[procProcesamientoMotorista] :: fin del metodo");
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CarteraClienteDTO> getCarteraClientes(CarteraPkgRequestDTO dto) throws StoredProcedureException {
		log.info("[getCarteraClientes] :: inicio del metodo");
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName(SCHEMA).withCatalogName(CATALOG)
				.withProcedureName("PROC_CARTERA")
				.declareParameters(new SqlOutParameter(CURSOR, Types.REF_CURSOR),
						new SqlParameter("P_PAGINA", Types.NUMERIC), new SqlParameter("P_PAGINA_TOTAL", Types.NUMERIC),
						new SqlParameter("P_ORDER_COLUMN", Types.VARCHAR),
						new SqlParameter("P_ORDER_BY", Types.VARCHAR), new SqlParameter("cod_periodo", Types.NUMERIC),
						new SqlParameter("pers_id_cob", Types.VARCHAR), new SqlParameter("esta_cod", Types.VARCHAR),
						new SqlParameter("prdo_tipo", Types.VARCHAR), new SqlParameter("cart_tipo_cod", Types.VARCHAR),
						new SqlParameter("comu_cod", Types.VARCHAR), new SqlParameter("rut", Types.VARCHAR),
						new SqlParameter("nombre", Types.VARCHAR), new SqlParameter("serie", Types.VARCHAR),
						new SqlParameter("fecha_proxima_gestion", Types.VARCHAR),
						new SqlParameter("id_supervisor", Types.VARCHAR),
						new SqlParameter("id_ejecutivo", Types.VARCHAR),
						new SqlParameter("fecha_asignacion", Types.VARCHAR),
						new SqlParameter("rut_motorista", Types.VARCHAR), new SqlParameter("profile", Types.VARCHAR))
				.returningResultSet(CURSOR, new RowMapper<CarteraClienteDTO>() {
					@Override
					public CarteraClienteDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
						return mapRowCartera(rs);
					}
				});

		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("P_PAGINA", dto.getPagina())
				.addValue("P_PAGINA_TOTAL", dto.getPaginaTotal()).addValue("P_ORDER_COLUMN", dto.getOrderColumn())
				.addValue("P_ORDER_BY", dto.getOrderBy()).addValue("cod_periodo", dto.getCodPeriodo())
				.addValue("pers_id_cob", dto.getPersIdCob()).addValue("esta_cod", dto.getEstaCod())
				.addValue("prdo_tipo", dto.getPrdoTipo()).addValue("cart_tipo_cod", dto.getCartTipoCod())
				.addValue("comu_cod", dto.getComuCod()).addValue("rut", dto.getRut())
				.addValue("nombre", dto.getNombre()).addValue("serie", dto.getSerie())
				.addValue("fecha_proxima_gestion", dto.getFechaProximaGestion())
				.addValue("id_supervisor", dto.getIdSupervisor()).addValue("id_ejecutivo", dto.getIdEjecutivo())
				.addValue("fecha_asignacion", dto.getFechaAsignacion()).addValue("rut_motorista", dto.getRutMotorista())
				.addValue("profile", dto.getProfiles());

		jdbcCall.compile();
		Map<String, ?> map = jdbcCall.execute(paramMap);
		log.info("[getCarteraClientes] :: fin del metodo");

		// Error en el SP
		Integer valorError = Integer.valueOf(map.get(P_CODE) == null ? "0" : map.get(P_CODE).toString());
		if (valorError != 0) {
			throw StoredProcedureException.createWith("PROC_CARTERA", valorError.toString(),
					(String) map.get(P_ERRM));
		}

		return (List<CarteraClienteDTO>) map.get(CURSOR);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MotoristaDTO> getDatosMotoristas(String idSupervisor) throws StoredProcedureException {
		log.info("[procProcesamientoMotorista] :: inicio del metodo");
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName(SCHEMA).withCatalogName(CATALOG)
				.withProcedureName("PROC_DATOS_MOTORISTA")
				.declareParameters(new SqlOutParameter(CURSOR, Types.REF_CURSOR),
						new SqlParameter(P_SUPERVISOR, Types.VARCHAR))
				.returningResultSet(CURSOR, new RowMapper<MotoristaDTO>() {
					@Override
					public MotoristaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
						return mapRowEjecutivoMotorista(rs);
					}
				});

		SqlParameterSource paramMap = new MapSqlParameterSource().addValue(P_SUPERVISOR, idSupervisor);

		jdbcCall.compile();
		Map<String, ?> map = jdbcCall.execute(paramMap);

		// Error en el SP
		Integer valorError = Integer.valueOf(map.get(P_CODE) == null ? "0" : map.get(P_CODE).toString());
		if (valorError != 0) {
			throw StoredProcedureException.createWith("PROC_DATOS_MOTORISTA", valorError.toString(),
					(String) map.get(P_ERRM));
		}

		List<MotoristaDTO> result = (List<MotoristaDTO>) map.get(CURSOR);
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
						return mapRowEjecutivo(rs);
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

	@Autowired
	public CarteraVigenteDTO getDatosCarteraVigente() throws StoredProcedureException {
		log.info("[getDatosEjecutivos] :: inicio del metodo");
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName(SCHEMA).withCatalogName(CATALOG)
				.withProcedureName(PROC_DATOS_CARTERA);

		jdbcCall.compile();
		Map<String, ?> map = jdbcCall.execute();

		// Error en el SP
		Integer valorError = Integer.valueOf(map.get(P_CODE) == null ? "0" : map.get(P_CODE).toString());
		if (valorError != 0) {
			throw StoredProcedureException.createWith("PROC_DATOS_CARTERA_VIGENTE", valorError.toString(),
					(String) map.get(P_ERRM));
		}

		Date fechaIni = (Date) map.get("PERIODO_FECHA_INI");
		Date fechaFin = (Date) map.get("PERIODO_FECHA_FIN");
		BigDecimal periodo = new BigDecimal(map.get("PERIODO").toString());
		log.info("[getDatosEjecutivos] :: fin del metodo");
		return new CarteraVigenteDTO(fechaIni, fechaFin, periodo);
	}
	
	@Autowired
	public PeriodoVigenteDTO getPeriodoActual() throws StoredProcedureException {
		log.info("[getPeriodoActual] :: inicio del metodo");
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName(SCHEMA).withCatalogName(CATALOG)
				.withProcedureName(PROC_DATOS_CARTERA);

		jdbcCall.compile();
		Map<String, ?> map = jdbcCall.execute();

		// Error en el SP
		Integer valorError = Integer.valueOf(map.get(P_CODE) == null ? "0" : map.get(P_CODE).toString());
		if (valorError != 0) {
			throw StoredProcedureException.createWith("PROC_DATOS_CARTERA_VIGENTE", valorError.toString(),
					(String) map.get(P_ERRM));
		}

		Date fechaIni = (Date) map.get("PERIODO_FECHA_INI");
		Date fechaFin = (Date) map.get("PERIODO_FECHA_FIN");
		BigDecimal periodo = new BigDecimal(map.get("PERIODO").toString());
		log.info("[getPeriodoActual] :: fin del metodo");
		return new PeriodoVigenteDTO(fechaIni, fechaFin, periodo);
	}

	private MotoristaDTO mapRowEjecutivoMotorista(ResultSet rs) throws SQLException {
		MotoristaDTO result = new MotoristaDTO();
		result.setNombreMotorista(GenericUtils.ifNullisBlank(rs.getObject("NOMBRE")));
		result.setRutMotorista(GenericUtils.ifNullisBlank(rs.getObject("RUT")));

		return result;
	}

	private EjecutivoDTO mapRowEjecutivo(ResultSet rs) throws SQLException {
		EjecutivoDTO result = new EjecutivoDTO();
		result.setIdEjecutivo(GenericUtils.ifNullisBlank(rs.getObject("RUT")));
		result.setNombre(GenericUtils.ifNullisBlank(rs.getObject("NOMBRE")));

		return result;
	}

	private ProcMotoristaDTO mapRowMotorista(ResultSet rs) throws SQLException {
		ProcMotoristaDTO result = new ProcMotoristaDTO();
		result.setSerie(GenericUtils.ifNullisBlank(rs.getObject("SERIE")));
		result.setFolio(GenericUtils.ifNullisBlank(rs.getObject("FOLIO")));
		result.setNombre(GenericUtils.ifNullisBlank(rs.getObject("NOMBRE")));
		result.setRut(GenericUtils.ifNullisBlank(rs.getObject("RUT")));
		result.setIdUser(GenericUtils.ifNullisCero(rs.getObject("ID_USER")));
		result.setCatpSec(GenericUtils.ifNullisCero(rs.getObject("CATP_SEC")));
		result.setCartera(GenericUtils.ifNullisBlank(rs.getObject("CARTERA")));
		result.setMotivo(GenericUtils.ifNullisBlank(rs.getObject("MOTIVO")));
		result.setResultado(GenericUtils.ifNullisBlank(rs.getObject("RESULTADO")));
		result.setFecha(GenericUtils.ifNotNullParseDate(rs.getObject("FECHA")));
		return result;
	}

	private CarteraClienteDTO mapRowCartera(ResultSet rs) throws SQLException {
		CarteraClienteDTO temp = new CarteraClienteDTO();
		temp.setEjecutivo(GenericUtils.ifNullisBlank(rs.getObject("EJECUTIVO")));
		temp.setComuna(GenericUtils.ifNullisBlank(rs.getObject("COMU")));
		temp.setEstado(GenericUtils.ifNullisBlank(rs.getObject("ESTADO")));
		temp.setContrato(GenericUtils.ifNullisBlank(rs.getObject("CONTRATO")));
		temp.setParque(GenericUtils.ifNullisBlank(rs.getObject("PARQUE")));
		temp.setGrupo(GenericUtils.ifNullisBlank(rs.getObject("GRUPO")));
		temp.setRutCliente(GenericUtils.ifNullisBlank(rs.getObject("RUT")));
		temp.setNombreCliente(GenericUtils.ifNullisBlank(rs.getObject("NOMBRECLIENTE")));
		temp.setUltimaGestion(GenericUtils.ifNullisBlank(rs.getObject("ULTIMAGESTION")));
		temp.setProximaGestion(GenericUtils.ifNullisBlank(rs.getObject("PROXIMAGESTION")));
		temp.setSaldo(GenericUtils.ifNullisCero(rs.getObject("SALDO")));
		temp.setDias(GenericUtils.ifNullisCero(rs.getObject("DIAS")).intValue());
		temp.setNumeroGestiones(GenericUtils.ifNullisCero(rs.getObject("NUMEROGESTIONES")).intValue());
		temp.setNombreMotorista(GenericUtils.ifNullisBlank(rs.getObject("MOTORISTA")));
		temp.setVtopCodCont(GenericUtils.ifNullisCero(rs.getObject("VTOP_COD_CONT")));
		temp.setCodPeriodo(GenericUtils.ifNullisCero(rs.getObject("PRDO_COD")));
		temp.setIdMotorista(GenericUtils.ifNullisCero(rs.getObject("IDMOTORISTA")));
		temp.setFechaAsignacion(GenericUtils.ifNullisDate(rs.getObject("FECHA_ASIGNACION")));
		temp.setCatpSec(GenericUtils.ifNullisCero(rs.getObject("CATP_SEC")));
		temp.setTotal((GenericUtils.ifNullisCero(rs.getObject("RESULT_COUNT"))).intValue());

		return temp;
	}

}
