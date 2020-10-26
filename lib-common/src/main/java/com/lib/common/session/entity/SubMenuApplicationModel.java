package com.lib.common.session.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author BS2
 */
@Entity
@Table(name = "SUB_MENU_APPLICATION", schema = "EXTPAR")
public class SubMenuApplicationModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal idSubMenuApplication;
	private String name;
	private String description;
	private String url;
	private Date createDate;
	private BigDecimal createUser;
	private Date updateDate;
	private BigDecimal updateUser;
	private Character valid;
	private String icono;
	private String datatarget;
	private Set<ProfileSubApplicationModel> profileSubApplications = new HashSet<ProfileSubApplicationModel>(0);
	private Set<SubMenuFuncionModel> subMenuFuncions = new HashSet<SubMenuFuncionModel>(0);

	public SubMenuApplicationModel() {
	}

	public SubMenuApplicationModel(BigDecimal idSubMenuApplication, String name, String description, Date createDate,
			BigDecimal createUser) {
		this.idSubMenuApplication = idSubMenuApplication;
		this.name = name;
		this.description = description;
		this.createDate = createDate;
		this.createUser = createUser;
	}

	public SubMenuApplicationModel(BigDecimal idSubMenuApplication, String name, String description, String url,
			Date createDate, BigDecimal createUser, Date updateDate, BigDecimal updateUser, Character valid,
			String icono, String datatarget, Set<ProfileSubApplicationModel> profileSubApplications,
			Set<SubMenuFuncionModel> subMenuFuncions) {
		this.idSubMenuApplication = idSubMenuApplication;
		this.name = name;
		this.description = description;
		this.url = url;
		this.createDate = createDate;
		this.createUser = createUser;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
		this.valid = valid;
		this.icono = icono;
		this.datatarget = datatarget;
		this.profileSubApplications = profileSubApplications;
		this.subMenuFuncions = subMenuFuncions;
	}

	@Id

	@Column(name = "ID_SUB_MENU_APPLICATION", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdSubMenuApplication() {
		return this.idSubMenuApplication;
	}

	public void setIdSubMenuApplication(BigDecimal idSubMenuApplication) {
		this.idSubMenuApplication = idSubMenuApplication;
	}

	@Column(name = "NAME", nullable = false, length = 200)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DESCRIPTION", nullable = false, length = 200)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "URL", length = 200)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE", nullable = false, length = 11)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "CREATE_USER", nullable = false, precision = 22, scale = 0)
	public BigDecimal getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(BigDecimal createUser) {
		this.createUser = createUser;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATE_DATE", length = 11)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "UPDATE_USER", precision = 22, scale = 0)
	public BigDecimal getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(BigDecimal updateUser) {
		this.updateUser = updateUser;
	}

	@Column(name = "VALID", length = 1)
	public Character getValid() {
		return this.valid;
	}

	public void setValid(Character valid) {
		this.valid = valid;
	}

	@Column(name = "ICONO", length = 100)
	public String getIcono() {
		return this.icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	@Column(name = "DATATARGET", length = 100)
	public String getDatatarget() {
		return this.datatarget;
	}

	public void setDatatarget(String datatarget) {
		this.datatarget = datatarget;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subMenuApplication")
	public Set<ProfileSubApplicationModel> getProfileSubApplications() {
		return this.profileSubApplications;
	}

	public void setProfileSubApplications(Set<ProfileSubApplicationModel> profileSubApplications) {
		this.profileSubApplications = profileSubApplications;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subMenuApplication")
	public Set<SubMenuFuncionModel> getSubMenuFuncions() {
		return this.subMenuFuncions;
	}

	public void setSubMenuFuncions(Set<SubMenuFuncionModel> subMenuFuncions) {
		this.subMenuFuncions = subMenuFuncions;
	}

}
