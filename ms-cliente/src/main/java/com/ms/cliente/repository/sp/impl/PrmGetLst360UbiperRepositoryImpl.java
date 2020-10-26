package com.ms.cliente.repository.sp.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.ms.cliente.dto.V360ClienteResponseDTO;
import com.ms.cliente.repository.sp.PrmGetLst360UbiperRepository;
import com.ms.cliente.utils.GenericUtils;
import com.pdr.common.cobranza.entity.GenPersonasModel;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class PrmGetLst360UbiperRepositoryImpl implements PrmGetLst360UbiperRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private EntityManager entityManager = null;

	@Autowired
	private DozerBeanMapper mapper;
	

	@Autowired
	public PrmGetLst360UbiperRepositoryImpl(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Map<String, Object> getListClienteV360(String buscador) {
		log.info("[getListClienteV360]:: inicio llamada al procedimiento de oracle");
		Map<String, Object> out;

		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName("PRISMA")
				.withCatalogName("PACK_VISTA_360").withFunctionName("PRM_GET_LST_360_UBIPER")
				.declareParameters(new SqlOutParameter("sys_refcursor", Types.REF_CURSOR),
						new SqlParameter("in_string", Types.VARCHAR), new SqlParameter("in_rows", Types.NUMERIC))
				.returningResultSet("sys_refcursor", new RowMapper<V360ClienteResponseDTO>() {
					@Override
					public V360ClienteResponseDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
						return mapRowCliente(rs);
					}
				}).withReturnValue();

		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("in_string", buscador).addValue("in_rows",
				20);

		jdbcCall.compile();
		out = jdbcCall.execute(paramMap);

		log.info("[getListClienteV360]:: fin llamada al procedimiento de oracle");
		return out;
	}

	public List<V360ClienteResponseDTO> getListClienteV360v2(String buscador) {
		log.info("[getListClienteV360]:: inicio llamada al procedimiento de oracle");

		
		TypedQuery<GenPersonasModel> q = this.entityManager.createNamedQuery("prm_get_lst_360_ubiper",
				GenPersonasModel.class);
		q.setParameter(1, buscador);
		q.setParameter(2, 0);
		List<GenPersonasModel> listado = q.getResultList();

		List<V360ClienteResponseDTO> result = new ArrayList<>();

		for (GenPersonasModel genPersona : listado) {
			result.add(mapper.map(genPersona, V360ClienteResponseDTO.class));
		}
		
		
		return result;
	}

	private V360ClienteResponseDTO mapRowCliente(ResultSet rs) throws SQLException {

		V360ClienteResponseDTO cliente = new V360ClienteResponseDTO();
		cliente.setPersTipoId(GenericUtils.ifNullisBlank(rs.getObject("PERS_TIPO_ID")));
		cliente.setPersId(GenericUtils.ifNullisBlank(rs.getObject("PERS_ID")));
		cliente.setPersDigVer(GenericUtils.ifNullisBlank(rs.getObject("PERS_DIG_VER")));
		cliente.setPersApePat(GenericUtils.ifNullisBlank(rs.getObject("PERS_APE_PAT")));
		cliente.setPersApeMat(GenericUtils.ifNullisBlank(rs.getObject("PERS_APE_MAT")));
		cliente.setPersNombres(GenericUtils.ifNullisBlank(rs.getObject("PERS_NOMBRES")));
		cliente.setPersRazonSocial(GenericUtils.ifNullisBlank(rs.getObject("PERS_RAZON_SOCIAL")));
		cliente.setPersNomFantasia(GenericUtils.ifNullisBlank(rs.getObject("PERS_NOM_FANTASIA")));
		cliente.setPersNivelEduc(GenericUtils.ifNullisBlank(rs.getObject("PERS_NIVEL_EDUC")));
		cliente.setPersFecNac(GenericUtils.ifNullisDate(rs.getObject("PERS_FEC_NAC")));
		cliente.setPersFecDefun(GenericUtils.ifNullisDate(rs.getObject("PERS_FEC_DEFUN")));
		cliente.setPersEdadDefun(GenericUtils.ifNullisBlank(rs.getObject("PERS_EDAD_DEFUN")));
		cliente.setPersEstCivil(GenericUtils.ifNullisBlank(rs.getObject("PERS_EST_CIVIL")));
		cliente.setPersNaci(GenericUtils.ifNullisBlank(rs.getObject("PERS_NACI")));
		cliente.setPersSexo(GenericUtils.ifNullisBlank(rs.getObject("PERS_SEXO")));
		cliente.setPersTipo(GenericUtils.ifNullisBlank(rs.getObject("PERS_TIPO")));
		cliente.setPersGiro(GenericUtils.ifNullisBlank(rs.getObject("PERS_GIRO")));
		cliente.setPersUserMod(GenericUtils.ifNullisBlank(rs.getObject("PERS_USER_MOD")));
		cliente.setPersFecDefun(GenericUtils.ifNullisDate(rs.getObject("PERS_FEC_MOD")));

		return cliente;
	}

}
