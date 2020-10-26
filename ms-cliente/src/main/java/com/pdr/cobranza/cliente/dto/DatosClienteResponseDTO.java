package com.pdr.cobranza.cliente.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DatosClienteResponseDTO {
	
	
	private GenPersonasDTO cliente;
	private List<GenDireccionesResponse> direcciones;
	private List<GenTelefonoResponse> telefonos;
	private List<GenMailDTO> emails;

}
