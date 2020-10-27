package com.pdr.cobranza.cliente.controller;

import static org.assertj.core.api.Assertions.assertThat;
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
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.lib.common.exception.DataNotFoundException;
import com.ms.cliente.controller.AplicacionControllerImpl;
import com.ms.cliente.dto.AplicacionesDTO;
import com.ms.cliente.service.AplicacionService;
import com.pdr.cobranza.cliente.controller.mock.AplicacionMock;

import lombok.extern.slf4j.Slf4j;

/**
 * @author BS2
 *
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@Slf4j
public class AplicacionControllerTest {

	@InjectMocks
	private AplicacionControllerImpl  controller;

	@Mock
	private AplicacionService service;

	@Test
	public void obtenerAplicacionesTest() throws DataNotFoundException{
		log.info("[obtenerAplicacionesTest]:: inicio del metodo");
		
		ResponseEntity<List<AplicacionesDTO>> responseEntity;
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        when(service.obtenerAplicaciones()).thenReturn(AplicacionMock.mockAplicacion());
        responseEntity = controller.obtenerAplicaciones();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
        
        when(service.obtenerAplicaciones()).thenReturn(new ArrayList<>());
        responseEntity = controller.obtenerAplicaciones();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(204);
        
        log.info("[obtenerListadoCampannas]:: fin del metodo");
	}
	
	
	

}
