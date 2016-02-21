package com.manifera.meshop.core.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "es_product_attribute")
public class ProductAttribute implements Auditable, Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "product_attribute_id")
	@TableGenerator(name = "table_generator", table = "es_id_gen", 
		pkColumnName = "gen_name", valueColumnName = "gen_val", pkColumnValue = "product_attribute_id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "table_generator")
	private Long id;
	
	@Column(name = "name")
	private String name;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "attribute")
	private Set<ProductAttributeValue> attributeValues = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@Embedded
	private AuditSection auditSection = new AuditSection();
	
	@Column(name = "product_attribute_type")
	@Enumerated(value = EnumType.STRING)
	private ProductAttributeType attributeType;
	
	//================= CUSTOM METHODS =====================
	
	
	
	
	//================= GETTER AND SETTER ==================
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

	public Set<ProductAttributeValue> getAttributeValues() {
		return attributeValues;
	}

	public void setAttributeValues(Set<ProductAttributeValue> attributeValues) {
		this.attributeValues = attributeValues;
	}

	/*public ProductAttributeValue getAttributeValue() {
		if(getAttributeValues() != null) {
			Iterator<ProductAttributeValue> it = getAttributeValues().iterator();
			return it.next();
		}
		return null;
	}*/

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public AuditSection getAuditSection() {
		return auditSection;
	}

	@Override
	public void setAuditSection(AuditSection auditSection) {
		this.auditSection = auditSection;
	}
	
	public ProductAttributeType getAttributeType() {
		return attributeType;
	}

	public void setAttributeType(ProductAttributeType attributeType) {
		this.attributeType = attributeType;
	}
}
