package com.pdr.cobranza.cliente.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.ms.cliente.controller.impl.TipoDireccionControllerImpl;
import com.ms.cliente.dto.CbzTipoDocumentoResponseDTO;
import com.ms.cliente.service.TipoDireccionService;
import com.pdr.cobranza.cliente.controller.mock.TipoDireccionMock;
import com.pdr.common.exception.DataNotFoundException;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@Slf4j
public class TipoDireccionControllerTest {

	@InjectMocks
	private TipoDireccionControllerImpl controller;

	@Mock
	private TipoDireccionService tipoDireccionService;

	@Test
	public void buscarDireccionesTest() throws Exception {
		log.info("[buscarDireccionesTest]:: inicio del test");
		ResponseEntity<List<CbzTipoDocumentoResponseDTO>> response;

		when(tipoDireccionService.getTipoDireccion()).thenReturn(TipoDireccionMock.tipoDocumentoMock());
		response = controller.obtenerTipoDireccion();
		assertThat(response.getStatusCodeValue()).isEqualTo(200);

		try {
			when(tipoDireccionService.getTipoDireccion()).thenReturn(new ArrayList<CbzTipoDocumentoResponseDTO>());
			controller.obtenerTipoDireccion();
		} catch (DataNotFoundException e) {
			log.error("[buscarDireccionesTest][DataNotFoundException]:: error-->" +e.getClass(), e);
        	assumeTrue(Boolean.TRUE);
		}
		log.info("[buscarDireccionesTest]:: fin del test");
	}

}
