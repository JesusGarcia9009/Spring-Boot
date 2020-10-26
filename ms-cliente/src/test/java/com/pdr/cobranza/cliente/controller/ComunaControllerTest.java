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

import com.pdr.cobranza.cliente.controller.impl.ComunasControllerImpl;
import com.pdr.cobranza.cliente.controller.mock.ComunasMock;
import com.pdr.cobranza.cliente.dto.GenComunasResponseDTO;
import com.pdr.cobranza.cliente.service.GenComunasService;
import com.pdr.common.exception.DataNotFoundException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author BS2
 *
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@Slf4j
public class ComunaControllerTest {

	// listar
	public static final Integer DATA_ID_REGION = 5;

	@InjectMocks
	private ComunasControllerImpl controller;

	@Mock
	private GenComunasService genComunasService;

	@Test
	public void listarComunasTest() {
		log.info("[listarComunasTest]::inicio");
		log.debug("[listarComunasTest]::msg=datos-->" + DATA_ID_REGION);

		ResponseEntity<List<GenComunasResponseDTO>> response;
		when(genComunasService.getComuna(DATA_ID_REGION)).thenReturn(ComunasMock.mockComunas());
		try {
			response = controller.listarComunas(DATA_ID_REGION);
			assertThat(response.getStatusCodeValue()).isEqualTo(200);
			
			when(genComunasService.getComuna(DATA_ID_REGION)).thenReturn(new ArrayList<GenComunasResponseDTO>() );
			response = controller.listarComunas(DATA_ID_REGION);
			
			
		} catch ( DataNotFoundException e) {
			log.error("[listarComunasTest][DataNotFoundException]:: error-->" +e.getClass(), e);
        	assumeTrue(Boolean.TRUE);

		}

	}

}
