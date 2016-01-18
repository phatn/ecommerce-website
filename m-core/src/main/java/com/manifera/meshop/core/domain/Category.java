package com.manifera.meshop.core.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import com.manifera.meshop.core.domain.common.AuditSection;
import com.manifera.meshop.core.domain.common.Auditable;


/**
 *  
 * @author Phat Nguyen
 * 
 */

@Entity
@Table(name = "es_category")
public class Category implements Auditable, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "category_id")
	@TableGenerator(name = "table_generator", table = "es_id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", pkColumnValue = "category_id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator="table_generator")
	private Long id;
	
	@Column(name = "category_image")
	private String categoryImage;
	
	@Column(name = "sort_order")
	private Integer sortOrder = 0;
	
	@Column(name = "visible")
	private boolean visible;
	
	@Column(name = "depth")
	private Integer depth;

	@Column(name = "lineage")
	private String lineage;
	
	@Column(name= "code", length = 100, nullable = false)
	private String code;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id")
	private Category parent;
	
	@OneToMany(mappedBy = "parent", cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.LAZY)
	private Set<Category> categories = new HashSet<Category>();
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "category")
	private Set<CategoryDescription> descriptions = new HashSet<CategoryDescription>();

	@ManyToMany(mappedBy = "categories")
	private Set<Product> products = new HashSet<Product>();
	
	@Transient
	private List<Category> subCategories = new ArrayList<Category>();
	
	@Column(name = "is_deleted")
	private Boolean deleted = false;
	
	@Embedded
	private AuditSection auditSection = new AuditSection();
	
	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryImage() {
		return categoryImage;
	}

	public void setCategoryImage(String categoryImage) {
		this.categoryImage = categoryImage;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public Set<CategoryDescription> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(Set<CategoryDescription> descriptions) {
		this.descriptions = descriptions;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public CategoryDescription getDescription() {
		if(descriptions != null && !descriptions.isEmpty()) {
			return descriptions.iterator().next();
		}
		return null;
	}

	public Integer getDepth() {
		return depth;
	}

	public void setDepth(Integer depth) {
		this.depth = depth;
	}

	public String getLineage() {
		return lineage;
	}

	public void setLineage(String lineage) {
		this.lineage = lineage;
	}

	public List<Category> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(List<Category> subCategories) {
		this.subCategories = subCategories;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public AuditSection getAuditSection() {
		return auditSection;
	}

	@Override
	public void setAuditSection(AuditSection auditSection) {
		this.auditSection = auditSection;
	}
}
