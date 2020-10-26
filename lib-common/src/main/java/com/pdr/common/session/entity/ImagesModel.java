package com.pdr.common.session.entity;

import java.math.BigDecimal;
import java.sql.Blob;
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
@Table(name = "IMAGES", schema = "EXTPAR")
public class ImagesModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal idImage;
	private Blob content;
	private String ext;
	private String name;
	private Set<ApplicationModel> applications = new HashSet<ApplicationModel>(0);

	public ImagesModel() {
	}

	public ImagesModel(BigDecimal idImage, String ext, String name) {
		this.idImage = idImage;
		this.ext = ext;
		this.name = name;
	}

	public ImagesModel(BigDecimal idImage, Blob content, String ext, String name, Set<ApplicationModel> applications) {
		this.idImage = idImage;
		this.content = content;
		this.ext = ext;
		this.name = name;
		this.applications = applications;
	}

	@Id

	@Column(name = "ID_IMAGE", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdImage() {
		return this.idImage;
	}

	public void setIdImage(BigDecimal idImage) {
		this.idImage = idImage;
	}

	@Column(name = "CONTENT")
	public Blob getContent() {
		return this.content;
	}

	public void setContent(Blob content) {
		this.content = content;
	}

	@Column(name = "EXT", nullable = false, length = 10)
	public String getExt() {
		return this.ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	@Column(name = "NAME", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "images")
	public Set<ApplicationModel> getApplications() {
		return this.applications;
	}

	public void setApplications(Set<ApplicationModel> applications) {
		this.applications = applications;
	}

}
