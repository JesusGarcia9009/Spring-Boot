package com.lib.common.session.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author BS2
 */
@Entity
@Table(name = "APPLICATION_TYPE", schema = "EXTPAR")
public class ApplicationTypeModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal idApplicationType;
	private String name;
	private Set<ApplicationModel> applications = new HashSet<ApplicationModel>(0);

	public ApplicationTypeModel() {
	}

	public ApplicationTypeModel(BigDecimal idApplicationType, String name) {
		this.idApplicationType = idApplicationType;
		this.name = name;
	}

	public ApplicationTypeModel(BigDecimal idApplicationType, String name, Set<ApplicationModel> applications) {
		this.idApplicationType = idApplicationType;
		this.name = name;
		this.applications = applications;
	}

	@Id

	@Column(name = "ID_APPLICATION_TYPE", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdApplicationType() {
		return this.idApplicationType;
	}

	public void setIdApplicationType(BigDecimal idApplicationType) {
		this.idApplicationType = idApplicationType;
	}

	@Column(name = "NAME", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "applicationType")
	public Set<ApplicationModel> getApplications() {
		return this.applications;
	}

	public void setApplications(Set<ApplicationModel> applications) {
		this.applications = applications;
	}

}
