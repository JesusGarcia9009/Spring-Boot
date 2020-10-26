package com.pdr.common.cobranza.entity.cbzpar;
// Generated 22-10-2020 19:09:54 by Hibernate Tools 5.2.12.Final

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "CBZ_GEST_DIAS_FESTIVOS", schema = "CBZPAR")
public class CbzGestDiasFestivos implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID_GDF_DIA_FESTIVO", unique = true, nullable = false, precision = 16, scale = 0)
	private long idGdfDiaFestivo;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "GDF_DIA_FESTIVO", length = 7)
	private Date gdfDiaFestivo;

}
