package com.manifera.meshop.core.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.manifera.meshop.core.domain.common.AuditListener;
import com.manifera.meshop.core.domain.common.AuditSection;
import com.manifera.meshop.core.domain.common.Auditable;

/**
 * 
 * @author Phat Nguyen
 * 
 */

@Entity
@EntityListeners(value = AuditListener.class)
@Table(name = "es_category_description")
public class CategoryDescription implements Auditable, Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "category_description_id")
	@TableGenerator(name = "table_generator", table = "es_id_gen", 
		pkColumnName = "gen_name", valueColumnName = "gen_val", pkColumnValue = "category_description_id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "table_generator")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "language_id")
	private Language language;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	// Search engine friendly url
	@Column(name = "sef_url", length = 120)
	private String sefUrl;
	
	@Embedded
	private AuditSection auditSection = new AuditSection();
	
	public AuditSection getAuditSection() {
		return auditSection;
	}

	public void setAuditSection(AuditSection auditSection) {
		this.auditSection = auditSection;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getSefUrl() {
		return sefUrl;
	}

	public void setSefUrl(String sefUrl) {
		this.sefUrl = sefUrl;
	}
}
