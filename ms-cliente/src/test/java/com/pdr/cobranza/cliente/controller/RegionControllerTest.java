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

import com.ms.cliente.controller.impl.RegionesControllerImpl;
import com.ms.cliente.dto.GenRegionesResponseDTO;
import com.ms.cliente.service.GenRegionesService;
import com.pdr.cobranza.cliente.controller.mock.RegionesMock;
import com.pdr.common.exception.DataNotFoundException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author BS2
 *
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@Slf4j
public class RegionControllerTest {

	
	//listaRegiones
	
	@InjectMocks
	private RegionesControllerImpl controller;

	@Mock
	private GenRegionesService genRegionesService;
	
	@Test
	public void listarRegionesTest() throws Exception {
		log.info("[listarRegionesTest]:: inicio del metodo");
		
		ResponseEntity<List<GenRegionesResponseDTO>> response ;
		
		when(genRegionesService.getRegiones()).thenReturn(RegionesMock.regionesMock());
		response = controller.listarRegiones();
		assertThat(response.getStatusCodeValue()).isEqualTo(200);
		
		try {
			when(genRegionesService.getRegiones()).thenReturn(new ArrayList<GenRegionesResponseDTO>());
			controller.listarRegiones();
		}catch (DataNotFoundException e) {
			log.error("[listarRegionesTest][DataNotFoundException]:: error-->" +e.getClass(), e);
        	assumeTrue(Boolean.TRUE);
		}
	}
}
