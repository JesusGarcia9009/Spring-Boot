package com.pdr.common.session.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author BS2
 */
@Entity
@Table(name = "APPLICATION", schema = "EXTPAR")
public class ApplicationModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal idApplication;
	private ApplicationTypeModel applicationType;
	private ImagesModel images;
	private String name;
	private String description;
	private String url;
	private String packageName;
	private Date createDate;
	private BigDecimal createUser;
	private Date updateDate;
	private BigDecimal updateUser;
	private String valid;
	private String landingPage;
	private String imagen;
	private String color;
	private Set<ProfileApplicationModel> profileApplications = new HashSet<ProfileApplicationModel>(0);

	public ApplicationModel() {
	}


	@Id

	@Column(name = "ID_APPLICATION", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdApplication() {
		return this.idApplication;
	}

	public void setIdApplication(BigDecimal idApplication) {
		this.idApplication = idApplication;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_APPLICATION_TYPE", nullable = false)
	public ApplicationTypeModel getApplicationType() {
		return this.applicationType;
	}

	public void setApplicationType(ApplicationTypeModel applicationType) {
		this.applicationType = applicationType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_APPLICATION_IMAGE")
	public ImagesModel getImages() {
		return this.images;
	}

	public void setImages(ImagesModel images) {
		this.images = images;
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

	@Column(name = "PACKAGE_NAME", length = 200)
	public String getPackageName() {
		return this.packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
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
	public String getValid() {
		return this.valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	@Column(name = "LANDING_PAGE", length = 1)
	public String getLandingPage() {
		return this.landingPage;
	}

	public void setLandingPage(String landingPage) {
		this.landingPage = landingPage;
	}

	@Column(name = "IMAGEN", length = 50)
	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Column(name = "COLOR", length = 50)
	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "application")
	public Set<ProfileApplicationModel> getProfileApplications() {
		return this.profileApplications;
	}

	public void setProfileApplications(Set<ProfileApplicationModel> profileApplications) {
		this.profileApplications = profileApplications;
	}

}
