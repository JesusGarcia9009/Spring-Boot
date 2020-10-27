package com.ms.cliente.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AplicacionesDTO {
	
	@JsonProperty
	public Long idAplicacion;
	 
	@JsonProperty
    public String url;
    
	@JsonProperty
    public String nombre;
    
	@JsonProperty
    public String descripcion;
    
	@JsonProperty
    public String icono;
    
	@JsonProperty
    public String color;
	

}
