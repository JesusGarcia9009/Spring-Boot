package com.pdr.common.cobranza.repository.sp.atcpar.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
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

import com.pdr.common.cobranza.repository.sp.atcpar.PkgServiciosWeb;
import com.pdr.common.dto.PersonaDTO;
import com.pdr.common.dto.ResultLstControlDTO;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class PkgServiciosWebImpl implements PkgServiciosWeb {

//	@Autowired
//	private EntityManager em;
//	
//	@PersistenceContext
//    public void setEntityManager(EntityManager entityManager) {
//        this.em = entityManager;
//    }
//	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	public Map<String, Object> getlstcontrol(PersonaDTO dto) {
		log.info("inicio del metodo");
		Map<String, Object> out;

		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName("ATCPAR")
				.withCatalogName("pkatc_servicios_web3")
				.withFunctionName("getlstcontrol")
				.declareParameters(new SqlOutParameter("contratos", Types.REF_CURSOR),
						new SqlParameter("P_COUNT", Types.NUMERIC), 
						new SqlParameter("P_OFFSET", Types.NUMERIC),
						new SqlParameter("P_NUMREG", Types.NUMERIC), 
						new SqlOutParameter("P_TOT_REG", Types.NUMERIC),
						new SqlOutParameter("P_COD_ERR", Types.NUMERIC),
						new SqlOutParameter("P_DES_ERR", Types.VARCHAR), 
						new SqlParameter("P_ORD_BY", Types.VARCHAR),
						new SqlParameter("P_PERS_TIPO_ID", Types.VARCHAR), 
						new SqlParameter("P_PERS_ID", Types.VARCHAR),
						new SqlParameter("P_ESTA_DOM", Types.VARCHAR), 
						new SqlParameter("P_SERIE_COD", Types.VARCHAR),
						new SqlParameter("P_DOCTO_FOLIO", Types.NUMERIC),
						new SqlParameter("P_TIPO_QUERY", Types.VARCHAR), 
						new SqlParameter("P_NUM_OPE", Types.VARCHAR))
				.returningResultSet("contratos", new RowMapper<ResultLstControlDTO>() {
					@Override
					public ResultLstControlDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
						
						ResultLstControlDTO obj = new ResultLstControlDTO();
						obj.setEmpCod(rs.getObject("EMPR_COD").toString());		
						obj.setUnegCod(rs.getObject("UNEG_COD").toString());	
						obj.setUnegEmprDesc(rs.getObject("UNEG_EMPR_DESC").toString());	
						obj.setContVtopNunFmt(rs.getObject("CONT_VTOP_NUM_FMT").toString());	
						obj.setTipoProducto(rs.getObject("TIPO_PRODUCTO").toString());	
						obj.setContVtopFech(rs.getObject("CONT_VTOP_FECH").toString());	
						obj.setContVtopFechFmt(rs.getObject("CONT_VTOP_FECH_FMT").toString());	
						obj.setContVtopEsta(rs.getObject("CONT_VTOP_ESTA").toString());	
						obj.setContVtopEstaDesc(rs.getObject("CONT_VTOP_ESTA_DESC").toString());		
						obj.setContVtopNece(rs.getObject("CONT_VTOP_NECE").toString());	
						obj.setContVtopNeceDesc(rs.getObject("CONT_VTOP_NECE_DESC").toString());		
						obj.setRol(rs.getObject("ROL").toString());	
						obj.setIndEstaDeudaDesc(rs.getObject("IND_ESTA_DEUDA_DESC").toString());			
						obj.setPersIdCompFmt(rs.getObject("PERS_ID_COMP_FMT").toString());	
						obj.setPersNomCompFmt(rs.getObject("PERS_NOM_COMP_FMT").toString());		 	
						obj.setUbicFmt(rs.getObject("UBIC_FMT").toString());		
						obj.setPersTipoIdComp(rs.getObject("PERS_TIPO_ID_COMP").toString());	
						obj.setPersIdComp(rs.getObject("PERS_ID_COMP").toString());			
						obj.setVtopCod(rs.getObject("VTOP_COD").toString());			
						obj.setVtopCodCont(rs.getObject("VTOP_COD_CONT").toString());			
						obj.setPesoRol(rs.getObject("PESO_ROL").toString());	
						obj.setTipoDocto(rs.getObject("TIPO_DOCTO").toString());			
						obj.setNumDocto(rs.getObject("NUM_DOCTO").toString());			
						obj.setLnngCod(rs.getObject("LNNG_COD").toString());			
						obj.setVtopIndNif(rs.getObject("VTOP_IND_NIF") != null ? rs.getObject("VTOP_IND_NIF").toString() : ""  );			
						obj.setNumOpe(rs.getObject("NUM_OPE").toString());	
						
						return obj;
					}
				});

		SqlParameterSource paramMap = new MapSqlParameterSource().addValue("P_COUNT", dto.getCommonRequest().getCount())
				.addValue("P_OFFSET", dto.getCommonRequest().getOffSet())
				.addValue("P_NUMREG", dto.getCommonRequest().getNumReg())
				.addValue("P_ORD_BY", dto.getCommonRequest().getOrderBy())
				.addValue("P_PERS_TIPO_ID", dto.getPersTipoId())
				.addValue("P_PERS_ID", dto.getPersId())
				.addValue("P_ESTA_DOM", dto.getEstaDom())
				.addValue("P_SERIE_COD", dto.getSerieCod())
				.addValue("P_DOCTO_FOLIO", dto.getDoctoFolio())
				.addValue("P_TIPO_QUERY", dto.getTipoQuery())
				.addValue("P_NUM_OPE", dto.getNumOper());

		jdbcCall.compile();
		out = jdbcCall.execute(paramMap);

		log.info("[getListContrato]:: fin llamada al procedimiento de oracle");
		return out;
	}
	
	
//	@Override
//	@Transactional
//	public void getlstcontrol(PersonaDTO persona) {
//		
//		log.debug("[getlstcontrol]::inicio...");
//		Session session = em.unwrap( Session.class );
//		 
//		
//		ResultSet resp = session.doReturningWork(
//		    connection -> {
//		    try (CallableStatement function = connection
//		        .prepareCall(
//		            "{ ? = call atcpar.pkatc_servicios_web3.getlstcontrol(?,?,?,?,?,?,?,?,?,?,?,?,?,?) }" )) {
//		        function.registerOutParameter( 1, Types.REF_CURSOR ); //Respuesta
//		        function.setLong( 2, 0 );//p_count
//		        function.setLong( 3, 0 );//_offset
//		        function.setLong( 4, 0 );//p_numreg
//		        function.setLong( 5, 0 );//p_tot_reg
//		        function.setString( 6, "" );//p_cod_err
//		        function.setString( 7, "" );//p_des_err
//		        function.setString( 8, "" );//p_ord_by
//		        function.setString( 9, "RUT" );//p_pers_tipo_id
//		        function.setString( 10, "13922881" );//p_pers_id
//		        function.setString( 11, "" );//p_esta_dom
//		        function.setString( 12, "" );//p_serie_cod
//		        
//		        function.setLong( 13, 0 );//p_docto_folio
//		        function.setString( 14, "" );//p_tipo_query
//		        function.setInt( 15, 0 );//p_num_ope
//		        function.execute();
//		        return (ResultSet)function.getObject(1);
//		    }
//		} );
//
//		log.debug("[getlstcontrol]::fin...");
//	}

}
