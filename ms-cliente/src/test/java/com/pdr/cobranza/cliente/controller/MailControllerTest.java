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

import com.ms.cliente.controller.impl.MailControllerImpl;
import com.ms.cliente.dto.DemograficDataRequest;
import com.ms.cliente.dto.GenMailDTO;
import com.ms.cliente.dto.RatificarMailRequest;
import com.ms.cliente.service.MailService;
import com.pdr.cobranza.cliente.controller.mock.MailMock;
import com.pdr.common.exception.NotRatificationException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author BS2
 *
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@Slf4j
public class MailControllerTest {

	// Data
	public static final BigDecimal DATA_DOCTO = new BigDecimal(72262);
	public static final String DATA_PERS_ID = "7296795";
	
	//ratificar
	public static final String DATA_USER = "pmartinez";
	public static final String DATA_MAIL = "MARGARETH.GONZALEZ@VTR.NET";
	public static final String DATA_PERS_TIPO_ID = "RUT";
	public static final String DATA_PERS_ID_RATIFICAR = "8301865";
	public static final String DATA_TIPO_DOCTO = "VTA_CONT";
	public static final BigDecimal DATA_NUM_DOCTO = new BigDecimal(68577);

	@InjectMocks
	private MailControllerImpl controller;

	@Mock
	private MailService mailService;
	
	

	@Test
	public void buscarMailsTest() throws Exception {
		log.info("[buscarMailsTest]:: inicio del metodo");
		ResponseEntity<List<GenMailDTO>> response;
		DemograficDataRequest param = new DemograficDataRequest();
		param.setNumDocto(DATA_DOCTO);
		param.setPersId(DATA_PERS_ID);

		when(mailService.buscarMails(param) ).thenReturn(MailMock.mockMail());
		response = controller.buscarMails(param);
		assertThat(response.getStatusCodeValue()).isEqualTo(200);
		
		
		when(mailService.buscarMails(param) ).thenReturn(null);
		response = controller.buscarMails(param);
		assertThat(response.getStatusCodeValue()).isEqualTo(204);
		
		
		when(mailService.buscarMails(param) ).thenReturn(new ArrayList<GenMailDTO>());
		response = controller.buscarMails(param);
		assertThat(response.getStatusCodeValue()).isEqualTo(204);
		
		
		log.info("[buscarMailsTest]:: fin del metodo");

	}
	
	
	@Test
	public void ratificarMailsTest() throws Exception {
		log.info("[ratificarMailsTest]:: inicio del metodo");
		
		ResponseEntity<Boolean> response;
		RatificarMailRequest param = new RatificarMailRequest();
		param.setUsuario(DATA_USER);
		param.setMail(DATA_MAIL);
		param.setPersTipoId(DATA_PERS_TIPO_ID);
		param.setPersId(DATA_PERS_ID_RATIFICAR);
		param.setTipoDocto(DATA_TIPO_DOCTO);
		param.setNumDocto(DATA_NUM_DOCTO);

		when(mailService.ratificarMail(param) ).thenReturn(Boolean.TRUE);
		
		response =  controller.ratificaMail(param);
		assertThat(response.getStatusCodeValue()).isEqualTo(200);
		
		try {
			when(mailService.ratificarMail(param) ).thenReturn(Boolean.FALSE);
			controller.ratificaMail(param);
		} catch( NotRatificationException e) {
			log.error("[ratificarMailsTest][NotRatificationException]:: error-->" +e.getClass(), e);
        	assumeTrue(Boolean.TRUE);
		}
		
		
		log.info("[ratificarMailsTest]:: fin del metodo");
	}
	
	
	
}