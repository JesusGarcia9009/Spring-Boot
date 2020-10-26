package com.lib.common.entity.cbzpar;
// Generated 22-10-2020 19:09:54 by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.lib.common.entity.GenComunasModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "CBZ_GEST_COMUNAS_RURALES", schema = "CBZPAR")
public class CbzGestComunasRurales implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID_GCR_REGION_PERM", unique = true, nullable = false, precision = 8, scale = 0)
	private int idGcrRegionPerm;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMU_COD", nullable = false)
	private GenComunasModel genComunas;
}
