package com.pdr.common.cobranza.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CBZ_TIPO_DIRECCION", schema = "CBZPAR")
public class CbzTipoDireccionModel {

	@Id
	@Column(name = "ID_TIPO_DIRECCION", unique = true, nullable = false, precision = 8, scale = 0)
	private Long idTipoDireccion;
	
	@Column(name = "TIPO_DIR_TRIO", length = 100)
	private String tipoDirTrio;
	
	@Column(name = "TIPO_DIR_DESCRIPCION", length = 100)
	private String tipoDirDescripcion;
}
