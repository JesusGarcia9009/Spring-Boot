package com.ms.cliente.controller.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ms.cliente.controller.ClienteController;
import com.ms.cliente.dto.DatosClienteResponseDTO;
import com.ms.cliente.dto.GenPersonaIdRequest;
import com.ms.cliente.dto.GenPersonasDTO;
import com.ms.cliente.dto.V360ClienteDesactulizadoRequestDTO;
import com.ms.cliente.dto.V360ClienteRequestDTO;
import com.ms.cliente.dto.V360ClienteResponseDTO;
import com.ms.cliente.service.ClienteService;
import com.pdr.common.exception.DataNotFoundException;
import com.pdr.common.exception.UserNotFoundException;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ClienteControllerImpl implements ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PostMapping("/buscar-cliente")
	public ResponseEntity<GenPersonasDTO> buscarCliente(@Valid @RequestBody GenPersonaIdRequest cliente)
			throws UserNotFoundException {
		log.info("BuscarCliente::Inicio del metodo");
		ResponseEntity<GenPersonasDTO> response = null;

		GenPersonasDTO dto = clienteService.buscarCliente(cliente);

		if (dto != null)
			response = new ResponseEntity<>(dto, HttpStatus.OK);
		else
			throw UserNotFoundException.createWith(cliente.getPersId());

		log.info("BuscarCliente::fin del metodo");
		return response;
	}

	@Override
	@GetMapping("/lista-clientes/{buscador}")
	public ResponseEntity<List<V360ClienteResponseDTO>> buscarClientesByString(
			@PathVariable(value = "buscador") String buscador) {

		log.info("BuscarListaClientes::Inicio del metodo");
		ResponseEntity<List<V360ClienteResponseDTO>> response = null;

		List<V360ClienteResponseDTO> dto = clienteService.getListCliente(buscador);

		if (dto != null)
			response = new ResponseEntity<>(dto, HttpStatus.OK);
		else
			response = new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
		

		log.info("BuscarCliente::fin del metodo");
		return response;

	}

	@Override
	@PostMapping("/lista-clientes-folio")
	public ResponseEntity<V360ClienteResponseDTO> buscarClientesFolio(@Valid @RequestBody V360ClienteRequestDTO folio) {

		log.info("BuscarListaClientesFolio::Inicio del metodo");
		ResponseEntity<V360ClienteResponseDTO> response = null;

		V360ClienteResponseDTO dto = clienteService.getListClienteFolio(folio);

		if (dto != null)
			response = new ResponseEntity<>(dto, HttpStatus.OK);
		else
			response = new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);

		log.info("BuscarClienteFolio::fin del metodo");
		return response;

	}

	@Override
	@PostMapping("/cliente-desactualizado")
	public ResponseEntity<Boolean> clienteDesactualizado(
			@Valid @RequestBody V360ClienteDesactulizadoRequestDTO persId) {
		log.info("ClienteDesactualizado::Inicio del metodo");
		ResponseEntity<Boolean> response = null;

		boolean resultado = clienteService.validaClienteDesactualizado(persId.getPersId());

		response = new ResponseEntity<>(resultado, HttpStatus.OK);

		log.info("ClienteDesactualizado::fin del metodo");
		return response;
	}

	@Override
	@GetMapping("/datos-cliente/{persid}/{numDocto}")
	public ResponseEntity<DatosClienteResponseDTO> datosCliente(@PathVariable(value = "persid")  String persID,@PathVariable(value = "numDocto")  String numDocto) throws DataNotFoundException {
		log.info("datosCliente::Inicio del metodo");
		ResponseEntity<DatosClienteResponseDTO> response = null;
		DatosClienteResponseDTO resultado = clienteService.datosCliente(persID, numDocto);
		
		if (resultado != null)
			response = new ResponseEntity<>(resultado, HttpStatus.OK);
		else
			throw DataNotFoundException.createWith(persID);
		
		log.info("datosCliente::fin del metodo");
		return response;
	}

}
