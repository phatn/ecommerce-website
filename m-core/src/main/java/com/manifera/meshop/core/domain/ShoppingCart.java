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
@Table(name = "es_shopping_cart")
public class ShoppingCart implements Auditable, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "shopping_cart_id")
	@TableGenerator(name = "table_generator", table = "es_id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", pkColumnValue = "shopping_cart_id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "table_generator")
	private Long id;
	
	@Column(name = "shopping_cart_code", unique = true, nullable = false)
	private String shoppingCartCode;
	
	@Embedded
	private AuditSection auditSection = new AuditSection();
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL ,mappedBy = "shoppingCart")
	private Set<ShoppingCartItem> lineItems = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShoppingCartCode() {
		return shoppingCartCode;
	}

	public void setShoppingCartCode(String shoppingCartCode) {
		this.shoppingCartCode = shoppingCartCode;
	}

	public AuditSection getAuditSection() {
		return auditSection;
	}

	public void setAuditSection(AuditSection auditSection) {
		this.auditSection = auditSection;
	}

	public Set<ShoppingCartItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(Set<ShoppingCartItem> lineItems) {
		this.lineItems = lineItems;
	}
}
