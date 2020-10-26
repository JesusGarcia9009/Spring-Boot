package com.ms.cliente.controller.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.cliente.controller.MailController;
import com.ms.cliente.dto.DemograficDataRequest;
import com.ms.cliente.dto.GenMailDTO;
import com.ms.cliente.dto.RatificarMailRequest;
import com.ms.cliente.service.MailService;
import com.ms.cliente.utils.ConstantesUtil;
import com.pdr.common.exception.NotRatificationException;
import com.pdr.common.exception.UserNotFoundException;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/mail")
@Slf4j
public class MailControllerImpl implements MailController {

	@Autowired
	private MailService mailService;
	
	@PostMapping("/ratificar-mail")
	public ResponseEntity<Boolean> ratificaMail(@Valid @RequestBody RatificarMailRequest dataRatificacion)
		throws NotRatificationException {
		log.info("RatificarDatosCliente::Inicio del metodo");
		ResponseEntity<Boolean> response = null;

		boolean resultado = mailService.ratificarMail(dataRatificacion);
		
		if (resultado) 
			response = new ResponseEntity<>(resultado, HttpStatus.OK);
		else
			throw NotRatificationException.createWith(ConstantesUtil.TIPO_RATIFICACION_MAIL);
		
		log.info("RatificarDatosCliente::fin del metodo");
		return response;
	}
	
	@PostMapping("/buscar-mails")
	public ResponseEntity<List<GenMailDTO>> buscarMails(@Valid @RequestBody DemograficDataRequest genMailRequest) throws UserNotFoundException{
		log.info("buscarMails::Inicio del metodo");
		ResponseEntity<List<GenMailDTO>> response = null;

		List<GenMailDTO> result = mailService.buscarMails(genMailRequest);
		
		if (result != null && !result.isEmpty())
			response = new ResponseEntity<>(result, HttpStatus.OK);
		else
			response = new ResponseEntity<>(result , HttpStatus.NO_CONTENT);
		
		log.info("buscarMails::fin del metodo");
		return response;
	}

}
