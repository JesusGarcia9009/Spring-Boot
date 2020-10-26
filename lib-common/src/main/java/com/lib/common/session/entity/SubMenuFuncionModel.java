package com.lib.common.session.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author BS2
 */
@Entity
@Table(name = "SUB_MENU_FUNCION", schema = "EXTPAR")
public class SubMenuFuncionModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal idSubMenuFuncion;
	private SubMenuApplicationModel subMenuApplication;
	private String name;
	private String description;
	private String url;
	private Date createDate;
	private BigDecimal createUser;
	private Date updateDate;
	private BigDecimal updateUser;
	private Character valid;

	public SubMenuFuncionModel() {
	}

	public SubMenuFuncionModel(BigDecimal idSubMenuFuncion, SubMenuApplicationModel subMenuApplication, String name,
			String description, Date createDate, BigDecimal createUser) {
		this.idSubMenuFuncion = idSubMenuFuncion;
		this.subMenuApplication = subMenuApplication;
		this.name = name;
		this.description = description;
		this.createDate = createDate;
		this.createUser = createUser;
	}

	public SubMenuFuncionModel(BigDecimal idSubMenuFuncion, SubMenuApplicationModel subMenuApplication, String name,
			String description, String url, Date createDate, BigDecimal createUser, Date updateDate,
			BigDecimal updateUser, Character valid) {
		this.idSubMenuFuncion = idSubMenuFuncion;
		this.subMenuApplication = subMenuApplication;
		this.name = name;
		this.description = description;
		this.url = url;
		this.createDate = createDate;
		this.createUser = createUser;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
		this.valid = valid;
	}

	@Id

	@Column(name = "ID_SUB_MENU_FUNCION", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdSubMenuFuncion() {
		return this.idSubMenuFuncion;
	}

	public void setIdSubMenuFuncion(BigDecimal idSubMenuFuncion) {
		this.idSubMenuFuncion = idSubMenuFuncion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SUB_MENU_APPLICATION", nullable = false)
	public SubMenuApplicationModel getSubMenuApplication() {
		return this.subMenuApplication;
	}

	public void setSubMenuApplication(SubMenuApplicationModel subMenuApplication) {
		this.subMenuApplication = subMenuApplication;
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

}
