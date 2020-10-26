package com.pdr.cobranza.cliente.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.pdr.cobranza.cliente.controller.impl.DireccionControllerImpl;
import com.pdr.cobranza.cliente.controller.mock.DireccionMock;
import com.pdr.cobranza.cliente.dto.GenDireccionesDTO;
import com.pdr.cobranza.cliente.dto.GenDireccionesResponse;
import com.pdr.cobranza.cliente.dto.RatificarDatosRequest;
import com.pdr.cobranza.cliente.service.DireccionService;
import com.pdr.cobranza.cliente.utils.ConstantesUtil;
import com.pdr.common.exception.InsertOrUpdateException;
import com.pdr.common.exception.NotRatificationException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author BS2
 *
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@Slf4j
public class DireccionControllerTest {

	// Data
	public static final BigDecimal DATA_DOCTO = new BigDecimal(280456);
	public static final String DATA_TIPO_ID = "RUT";

	// ratificar
	public static final String DATA_USER = "pmartinez";
	public static final Integer DATA_ID_DIR = 6053;

	// insertar
	public static final String DATA_COMU_COD = "SANTIAGO";
	public static final String DATA_CALLE = "Teatinos M";
	public static final String DATA_NUMERO = "20201";
	public static final String DATA_RESTO = "apto 154";
	public static final String DATA_TIPO_DIRECCION = "PART";
	public static final String DATA_USUARIO = "pad.prueba1";
	public static final BigDecimal DATA_NUM_DOCTO = new BigDecimal(72262);
	public static final String DATA_PERS_ID = "7296795";

	@InjectMocks
	private DireccionControllerImpl controller;

	@Mock
	private DireccionService direccionService;

	@Test
	public void buscarDireccionesTest() throws Exception {

		log.info("[buscarDireccionesTest]:: inicio del metodo");

		ResponseEntity<List<GenDireccionesResponse>> response;
		
		when(direccionService.buscarDirecciones(DATA_DOCTO)).thenReturn(DireccionMock.mockDirecciones());
		response = controller.buscarDirecciones(DATA_DOCTO);
		assertThat(response.getStatusCodeValue()).isEqualTo(200);
		
		
		when(direccionService.buscarDirecciones(DATA_DOCTO)).thenReturn(new ArrayList<GenDireccionesResponse>());
		response = controller.buscarDirecciones(DATA_DOCTO);
		assertThat(response.getStatusCodeValue()).isEqualTo(204);
		
		
		when(direccionService.buscarDirecciones(DATA_DOCTO)).thenReturn(null);
		response = controller.buscarDirecciones(DATA_DOCTO);
		assertThat(response.getStatusCodeValue()).isEqualTo(204);
		
	}

	@Test
	public void ratificarDireccionesTest() throws Exception {
		log.info("[ratificarDireccionesTest]:: inicio del metodo");
		RatificarDatosRequest param = new RatificarDatosRequest();
		param.setIdDatoRatificacion(DATA_ID_DIR);
		param.setUsuario(DATA_USER);

		ResponseEntity<Boolean> response;
		when(direccionService.ratificarDireccion(param)).thenReturn(Boolean.TRUE);
		response = controller.ratificaDireccion(param);
		assertThat(response.getStatusCodeValue()).isEqualTo(200);

		try {
			when(direccionService.ratificarDireccion(param)).thenReturn(Boolean.FALSE);
			response = controller.ratificaDireccion(param);
		} catch (NotRatificationException e) {
			log.error("[ratificarDireccionesTest][NotRatificationException]:: error-->" +e.getClass(), e);
        	assumeTrue(Boolean.TRUE);
		}
		
		log.info("[ratificarDireccionesTest]:: fin del metodo");
	
	}

	@Test
	public void insertarDireccionTest() throws Exception {
		log.info("[insertarDireccionTest]:: inicio del metodo");
		GenDireccionesDTO param = new GenDireccionesDTO();
		param.setComuCod(DATA_COMU_COD);
		param.setDireCalle(DATA_CALLE);
		param.setDireNumero(DATA_NUMERO);
		param.setDireRestoDire(DATA_RESTO);
		param.setDireTipo(DATA_TIPO_DIRECCION);
		param.setDireUserMod(DATA_USUARIO);
		param.setNumDocto(DATA_NUM_DOCTO);
		param.setPersId(DATA_PERS_ID);
		param.setTipoDocto(ConstantesUtil.TIPO_DOCTO);

		when(direccionService.insertDireccion(param)).thenReturn(Boolean.TRUE);
		
		boolean resultado = ((ResponseEntity<Boolean>) controller.insertarDireccion(param)).getBody();
		assertThat(resultado).isEqualTo(true);
		
		try {
			when(direccionService.insertDireccion(param)).thenReturn(Boolean.FALSE);
			controller.insertarDireccion(param);
		} catch (InsertOrUpdateException e) {
			log.error("[insertarDireccionTest][InsertOrUpdateException]:: error-->" +e.getClass(), e);
        	assumeTrue(Boolean.TRUE);
		}
		
		log.info("[insertarDireccionTest]:: fin del metodo");
		
	}

}
