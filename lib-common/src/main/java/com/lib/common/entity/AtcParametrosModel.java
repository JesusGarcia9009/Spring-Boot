package com.lib.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ATC_PARAMETROS", schema = "ATCPAR")
public class AtcParametrosModel {

	@Id
	@Column(name = "PARA_CODIGO", length = 100)
	private String paraCodigo;
	
	@Column(name = "PARA_VALOR", length = 100)
	private String paraValor;
	
	@Column(name = "PARA_DESC", length = 100)
	private String paraDesc;
}
