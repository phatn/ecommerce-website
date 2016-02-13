package com.manifera.meshop.core.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.manifera.meshop.core.domain.common.AuditListener;
import com.manifera.meshop.core.domain.common.AuditSection;
import com.manifera.meshop.core.domain.common.Auditable;

@Entity
@EntityListeners(value = AuditListener.class)
@Table(name = "es_product_price_range")
public class ProductPriceRange implements Auditable, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "product_price_range_id")
	@TableGenerator(name = "table_generator", table = "es_id_gen", pkColumnName = "gen_name", 
		valueColumnName = "gen_val", pkColumnValue = "product_price_range_id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "table_generator")
	private Long id;
	
	@Column(name = "min")
	private BigDecimal min;
	
	@Column(name = "max")
	private BigDecimal max;

	@Embedded
	private AuditSection auditSection = new AuditSection();
	
	@Column(name = "sort_order")
	private Integer sortOrder;
	
	@Column(name = "sef_url")
	private String sefUrl;
	
	public String getSefUrl() {
		return sefUrl;
	}

	public void setSefUrl(String sefUrl) {
		this.sefUrl = sefUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public BigDecimal getMin() {
		return min;
	}

	public void setMin(BigDecimal min) {
		this.min = min;
	}

	public BigDecimal getMax() {
		return max;
	}

	public void setMax(BigDecimal max) {
		this.max = max;
	}

	@Override
	public AuditSection getAuditSection() {
		return auditSection;
	}

	@Override
	public void setAuditSection(AuditSection auditSection) {
		this.auditSection = auditSection;
	}
	
	@Override
	public String toString() {
		return "[Min] " + min + ", [Max] " + max;
	}
}
