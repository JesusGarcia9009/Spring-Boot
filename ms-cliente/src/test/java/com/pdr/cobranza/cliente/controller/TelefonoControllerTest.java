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

import com.ms.cliente.controller.impl.TelefonoControllerImpl;
import com.ms.cliente.dto.DemograficDataRequest;
import com.ms.cliente.dto.GenTelefonoDTO;
import com.ms.cliente.dto.GenTelefonoResponse;
import com.ms.cliente.dto.RatificarDatosRequest;
import com.ms.cliente.service.TelefonoService;
import com.pdr.cobranza.cliente.controller.mock.TelefonoMock;
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
public class TelefonoControllerTest {

	// Data
	public static final BigDecimal DATA_DOCTO = new BigDecimal(72262);
	public static final String DATA_PERS_ID = "7296795";

	// ratificar
	public static final String DATA_USER = "pmartinez";
	public static final Integer DATA_ID_TEL = 3156;

	// ratificar
	public static final String DATA_FONO_TIPO = "PART";
	public static final String DATA_FONO_NUMERO = "+56 911237786";
	public static final BigDecimal DATA_NUM_DOCTO = new BigDecimal(72262);
	public static final String DATA_FONO_USER_MOD = "pad.prueba1";
	public static final String DATA_PERSID = "7296795";
	public static final String DATA_PERS_TIPO_ID = "RUT";

	@InjectMocks
	private TelefonoControllerImpl controller;

	@Mock
	private TelefonoService telefonoService;

	@Test
	public void buscarTelefonosTest() throws Exception {

		log.info("[buscarTelefonosTest]:: inicio del metodo");
		ResponseEntity<List<GenTelefonoResponse>> response;
		DemograficDataRequest param = new DemograficDataRequest();
		param.setNumDocto(DATA_DOCTO);
		param.setPersId(DATA_PERS_ID);

		when(telefonoService.buscarTelefonos(param)).thenReturn(TelefonoMock.telefonoMock());
		response = controller.buscarTelefonos(param);
		assertThat(response.getStatusCodeValue()).isEqualTo(200);

		when(telefonoService.buscarTelefonos(param)).thenReturn(null);
		response = controller.buscarTelefonos(param);
		assertThat(response.getStatusCodeValue()).isEqualTo(204);

		when(telefonoService.buscarTelefonos(param)).thenReturn(new ArrayList<GenTelefonoResponse>());
		response = controller.buscarTelefonos(param);
		assertThat(response.getStatusCodeValue()).isEqualTo(204);

		log.info("[buscarTelefonosTest]:: fin del metodo");
	}

	@Test
	public void ratificarTelefonosTest() throws Exception {
		log.info("[ratificarTelefonosTest]:: inicio del metodo");

		ResponseEntity<Boolean> response;
		RatificarDatosRequest param = new RatificarDatosRequest();
		param.setIdDatoRatificacion(DATA_ID_TEL);
		param.setUsuario(DATA_USER);

		when(telefonoService.ratificarTelefono(param)).thenReturn(Boolean.TRUE);

		response = controller.ratificaTelefono(param);
		assertThat(response.getStatusCodeValue()).isEqualTo(200);

		try {
			when(telefonoService.ratificarTelefono(param)).thenReturn(Boolean.FALSE);
			controller.ratificaTelefono(param);
		} catch (NotRatificationException e) {
			log.error("[ratificarTelefonosTest][NotRatificationException]:: error-->" + e.getClass(), e);
			assumeTrue(Boolean.TRUE);
		}

		log.info("[ratificarTelefonosTest]:: fin del metodo");
	}

	@Test
	public void insertTelefonoTest() throws Exception {
		log.info("[insertTelefonoTest]:: inicio del metodo");
		GenTelefonoDTO param = new GenTelefonoDTO();
		param.setFonoNumero(DATA_FONO_NUMERO);
		param.setFonoTipo(DATA_FONO_TIPO);
		param.setFonoUserMod(DATA_FONO_USER_MOD);
		param.setNumDocto(DATA_NUM_DOCTO);
		param.setPersId(DATA_PERSID);
		param.setPersTipoId(DATA_PERS_TIPO_ID);


		when(telefonoService.insertTelefono(param)).thenReturn(Boolean.TRUE);

		boolean resultado = ((ResponseEntity<Boolean>) controller.insertTelefono(param)).getBody();
		assertThat(resultado).isEqualTo(true);

		try {
			when(telefonoService.insertTelefono(param)).thenReturn(Boolean.FALSE);
			controller.insertTelefono(param);
		} catch (InsertOrUpdateException e) {
			log.error("[InsertOrUpdateException][InsertOrUpdateException]:: error-->" + e.getClass(), e);
			assumeTrue(Boolean.TRUE);
		}

		log.info("[insertTelefonoTest]:: fin del metodo");

	}

}