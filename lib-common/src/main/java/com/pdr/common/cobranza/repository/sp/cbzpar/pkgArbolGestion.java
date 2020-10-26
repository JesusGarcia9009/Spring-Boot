package com.pdr.common.cobranza.repository.sp.cbzpar;

import java.util.List;

import com.pdr.common.dto.CarteraClienteDTO;
import com.pdr.common.dto.CarteraPkgRequestDTO;
import com.pdr.common.dto.CarteraVigenteDTO;
import com.pdr.common.dto.EjecutivoDTO;
import com.pdr.common.dto.MotoristaDTO;
import com.pdr.common.dto.PeriodoVigenteDTO;
import com.pdr.common.dto.ProcMotoristaDTO;
import com.pdr.common.dto.obtienPeriodoDTO;
import com.pdr.common.exception.StoredProcedureException;

public interface pkgArbolGestion {

	obtienPeriodoDTO obtienePeriodo();

	/**
	 * Llamado al procedimiento almacenado que procesa los ruts de motorista y los
	 * contratos que se pretenden asociar
	 *
	 * @author BS2
	 * @since 1.0
	 * @version jdk-11
	 */
	List<ProcMotoristaDTO> procProcesamientoMotorista(String ids, String codCartera, String persIdSupervisor) throws StoredProcedureException;

	/**
	 * Obtener los datos de los trabajadores asociados al supervisor de cobranza
	 *
	 * @author BS2
	 * @since 1.0
	 * @version jdk-11
	 */
	public List<EjecutivoDTO> getDatosEjecutivos(String idSupervisor) throws StoredProcedureException;

	/**
	 * Obtener los datos de los trabajadores asociados al supervisor de motorista
	 *
	 * @author BS2
	 * @since 1.0
	 * @version jdk-11
	 */
	public List<MotoristaDTO> getDatosMotoristas(String idSupervisor) throws StoredProcedureException;

	/**
	 * Obtener los datos de la cartera vigente actual
	 *
	 * @author BS2
	 * @since 1.0
	 * @version jdk-11
	 */
	public CarteraVigenteDTO getDatosCarteraVigente() throws StoredProcedureException;

	/**
	 * Llamado al procedimiento almacenado que devuelve la cartera
	 *
	 * @author BS2
	 * @since 1.0
	 * @version jdk-11
	 */
	List<CarteraClienteDTO> getCarteraClientes(CarteraPkgRequestDTO cartera) throws StoredProcedureException;


	/**
	 * Llamado al procedimiento que trae los datos del periodo Vigente
	 *
	 * @author BS2
	 * @since 1.0
	 * @version jdk-11
	 */
	PeriodoVigenteDTO getPeriodoActual() throws StoredProcedureException;
}
