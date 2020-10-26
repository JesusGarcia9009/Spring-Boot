/**
 * 
 */
package com.pdr.common.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author BS2
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CarteraPkgRequestDTO {
	
	private Integer pagina;             
	private Integer paginaTotal;       
	private Integer totalRegistro;     
	private String orderColumn;       
	private String orderBy;           
	private BigDecimal codPeriodo;          
    private String persIdCob;          
    private String estaCod;             
    private String prdoTipo;            
    private String cartTipoCod;        
    private String comuCod;             
    private String rut;                  
    private String nombre;               
    private String serie;                
    private Date fechaProximaGestion;
    private String idSupervisor;        
    private String idEjecutivo;         
    private Date fechaAsignacion;     
    private String rutMotorista;        
    private String profiles;

}
