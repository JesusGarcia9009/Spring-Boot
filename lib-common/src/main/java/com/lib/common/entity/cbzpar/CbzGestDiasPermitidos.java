package com.lib.common.entity.cbzpar;
// Generated 22-10-2020 19:09:54 by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "CBZ_GEST_DIAS_PERMITIDOS", schema = "CBZPAR")
public class CbzGestDiasPermitidos implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID_GDP_DIA_PERM", unique = true, nullable = false, precision = 8, scale = 0)
	private int idGdpDiaPerm;
	
	@Column(name = "GDP_DIA", length = 25)
	private String gdpDia;
	
	@Column(name = "GDP_HORA_INI", length = 10)
	private String gdpHoraIni;
	
	@Column(name = "GDP_HORA_FIN", length = 10)
	private String gdpHoraFin;
	
	@Column(name = "SOLO_COMUNA_RURAL", precision = 1, scale = 0)
	private Boolean soloComunaRural;

}
