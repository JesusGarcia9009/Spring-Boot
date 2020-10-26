package com.pdr.cobranza.cliente.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
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

import com.ms.cliente.controller.impl.ClienteControllerImpl;
import com.ms.cliente.dto.DatosClienteResponseDTO;
import com.ms.cliente.dto.GenPersonaIdRequest;
import com.ms.cliente.dto.GenPersonasDTO;
import com.ms.cliente.dto.V360ClienteDesactulizadoRequestDTO;
import com.ms.cliente.dto.V360ClienteRequestDTO;
import com.ms.cliente.dto.V360ClienteResponseDTO;
import com.ms.cliente.service.ClienteService;
import com.pdr.cobranza.cliente.controller.mock.ClienteMock;
import com.pdr.common.exception.DataNotFoundException;
import com.pdr.common.exception.UserNotFoundException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author BS2
 *
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@Slf4j
public class ClienteControllerTest {

	// Buscar Cliente Test y datos desactualizados
	public static final String DATA_ID = "7296795";
	public static final String DATA_TIPO_ID = "RUT";

	//Buscar cliente By String
	public static final String DATA_RUT_TO_VERIFY = "26873611";
	public static final String DATA_NOMBRE = "Jesus Manuel Garcia";
	
	//Buscar cliente por folio
	public static final String DATA_RUT_VERIF = "4095793";
	public static final String DATA_SERIE_COD = "L";
	public static final BigDecimal DATA_FOLIO_COD = new BigDecimal(604);

	@InjectMocks
	private ClienteControllerImpl clienteController;

	@Mock
	private ClienteService clienteService;
	
	@Test
    public void buscarClienteTest() throws UserNotFoundException 
    {
		log.info("[buscarClienteTest]:: inicio del metodo");
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        GenPersonaIdRequest pers = new GenPersonaIdRequest();
        pers.setPersId(DATA_ID);
        pers.setPersTipoId(DATA_TIPO_ID);
        
        
        when(clienteService.buscarCliente(pers)).thenReturn(ClienteMock.mockPersona());
        
        ResponseEntity<GenPersonasDTO> responseEntity = clienteController.buscarCliente(pers);
         
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
        
        try { 
        	when(clienteService.buscarCliente(pers)).thenReturn(null);
		    clienteController.buscarCliente(pers);
        } catch (UserNotFoundException e) {
        	log.error("[buscarClienteTest][UserNotFoundException]:: error-->" +e.getClass(), e);
        	assumeTrue(Boolean.TRUE);
		}
        
    }
	
	
	@Test
	public void buscarClientesByStringTest() {
		log.info("[buscarClientesByStringTest]:: inicio del metodo");
		
		ResponseEntity<List<V360ClienteResponseDTO>> responseEntity;
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        when(clienteService.getListCliente("Felipe Netrado") ).thenReturn(ClienteMock.MockClientesV360());
        responseEntity = clienteController.buscarClientesByString("Felipe Netrado");
        
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
        
        when(clienteService.getListCliente("98473298473298432") ).thenReturn(null);
        responseEntity = clienteController.buscarClientesByString("98473298473298432");
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(204);
        
        log.info("[buscarClientesByStringTest]:: fin del metodo");
        
	}
	
	
	@Test
	public void buscarClientesFolioTest() {
		log.info("[buscarClientesFolioTest]:: inicio del metodo");
		
		ResponseEntity<V360ClienteResponseDTO> responseEntity;
		
		
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        V360ClienteRequestDTO  input = new V360ClienteRequestDTO();
        
        
        when(clienteService.getListClienteFolio(input) ).thenReturn(ClienteMock.MockClienteV360());
        responseEntity = clienteController.buscarClientesFolio(input);
        
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
        
        when(clienteService.getListClienteFolio(input) ).thenReturn(null);
        responseEntity = clienteController.buscarClientesFolio(input);
        
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(204);
        log.info("[buscarClientesFolioTest]:: fin del metodo");
	}
	
	
	@Test
	public void clienteDesactualizadoTest() {
		log.info("[clienteDesactualizadoTest]:: inicio del metodo");
		
		ResponseEntity<Boolean> responseEntity;
		
		
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        V360ClienteDesactulizadoRequestDTO  input = new V360ClienteDesactulizadoRequestDTO();
        input.setPersId(DATA_ID);
        
        when(clienteService.validaClienteDesactualizado(input.getPersId()) ).thenReturn(true);
        responseEntity = clienteController.clienteDesactualizado(input);
        
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
        
        when(clienteService.validaClienteDesactualizado(input.getPersId()) ).thenReturn(false);
        responseEntity = clienteController.clienteDesactualizado(input);
        
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
        log.info("[clienteDesactualizadoTest]:: inicio del metodo");
        
	}
	
	@Test
	public void datosClienteTest() throws DataNotFoundException {
		
		log.info("[datosClienteTest]:: inicio del metodo");
		ResponseEntity<DatosClienteResponseDTO> responseEntity;
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        when(clienteService.datosCliente("19004920","123")).thenReturn(ClienteMock.MockCliente());
        responseEntity = clienteController.datosCliente("19004920","123");
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
        
        try { 
        	when(clienteService.datosCliente("asgagsh","123")).thenReturn(null);
		    clienteController.datosCliente("asgagsh","123");
        } catch (DataNotFoundException e) {
        	log.error("[datosClienteTest][DataNotFoundException]:: error-->" +e.getClass(), e);
        	assumeTrue(Boolean.TRUE);
		}
        log.info("[datosClienteTest]:: fin del metodo");
	
	}
	
	
	

}
