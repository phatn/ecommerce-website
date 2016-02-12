package com.manifera.meshop.core.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "es_manufacturer")
public class Manufacturer implements Auditable, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "manufacturer_id")
	@TableGenerator(name = "table_generator", table = "es_id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", pkColumnValue = "manufacturer_id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "table_generator")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Embedded
	private AuditSection auditSection = new AuditSection();
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "manufacturer")
	private Set<ManufacturerDescription> descriptions = new HashSet<>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "manufacturer")
	private Set<Product> products = new HashSet<>();
	
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

	public Set<ManufacturerDescription> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(Set<ManufacturerDescription> descriptions) {
		this.descriptions = descriptions;
	}

	@Override
	public AuditSection getAuditSection() {
		return auditSection;
	}

	@Override
	public void setAuditSection(AuditSection auditSection) {
		this.auditSection = auditSection;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
}
