package com.pdr.common.cobranza.repository.sp.cbzpar;

import java.math.BigDecimal;
import java.util.List;

import com.pdr.common.cobranza.entity.CbzCatalogoPgreDetalleTempModel;
import com.pdr.common.dto.AsignacionResponseDTO;
import com.pdr.common.dto.EjecutivoDTO;
import com.pdr.common.dto.PrevisualizacionRequestDTO;
import com.pdr.common.dto.PrevisualizarResponseDTO;
import com.pdr.common.exception.StoredProcedureException;

public interface pkgMantenedor {

	/**
	 * Llamado al procedimiento que carga el la lista de los contratos  a asignar a los motoristas
	 *
	 * @author BS2
	 * @since 1.0
	 * @version jdk-11
	 */
	List<CbzCatalogoPgreDetalleTempModel> procContratosByCriterioUno(Long criterioUnoId, String tipoAsignacion) throws StoredProcedureException;

	
	/**
	 * Obtener los datos ejecutivos de cobranza
	 *
	 * @author BS2
	 * @since 1.0
	 * @version jdk-11
	 */
	public List<EjecutivoDTO> getDatosEjecutivos(String idSupervisor) throws StoredProcedureException;


	/**
	 * Obtener los datos de previsualizacion para un periodo
	 *
	 * @author BS2
	 * @since 1.0
	 * @version jdk-11
	 */
	public List<PrevisualizarResponseDTO> getDatosPrevisualizacion(Long idCpcPeriodo,  BigDecimal valorUF, String tipoCartera, String tipoFase, String estadoPeriodo) throws StoredProcedureException;
	
	
	
	/**
	 * Visualizar regla de asignacion
	 *
	 * @author BS2
	 * @since 1.0
	 * @version jdk-11
	 */
	public AsignacionResponseDTO visualizarRegla(Integer idCpcPeriodo) throws StoredProcedureException;
	
	
	
	/**
	 * Previsualizar Informacion de regla a calcular
	 *
	 * @author BS2
	 * @since 1.0
	 * @version jdk-11
	 */
	public AsignacionResponseDTO previsualizarRegla(PrevisualizacionRequestDTO previsualizacion) throws StoredProcedureException;
	
}
