package com.manifera.meshop.core.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.manifera.meshop.core.domain.common.AuditListener;
import com.manifera.meshop.core.domain.common.AuditSection;
import com.manifera.meshop.core.domain.common.Auditable;
import com.manifera.meshop.core.util.DomainUtil;

import flexjson.JSON;


/**
 * 
 * @author Phat Nguyen
 * 
 */

@Entity
@EntityListeners(value = AuditListener.class)
@Table(name = "es_product")
public class Product implements Auditable, Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "product_id")
	@TableGenerator(name = "table_generator", table = "es_id_gen", 
		pkColumnName = "gen_name", valueColumnName = "gen_val", pkColumnValue = "product_id")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "table_generator")
	private Long id;
	
	@Column(name = "sku")
	private String sku;
	
	@Column(name = "product_price")
	@NumberFormat(style = Style.CURRENCY)
	private BigDecimal price;
	
	@Column(name = "product_sale_price")
	@NumberFormat(style = Style.CURRENCY)
	private BigDecimal salePrice;
	
	@Embedded
	private AuditSection auditSection = new AuditSection();
	
	@Column(name = "available")
	private boolean available;

	@Column(name = "sort_order")
	private Integer sortOrder;
	
	@Column(name = "quantity_ordered")
	private Integer quantityOrdered;
	
	@Column(name = "review_count")
	private Integer reviewCount;
	
	@Column(name = "featured_seller")
	private boolean featuredSeller;
	
	@Column(name = "new_arrival")
	private boolean newArrival;
	
	@Column(name = "clearance")
	private boolean clearance;
	
	@Column(name = "is_deleted")
	private boolean deleted = false;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="product")
	private Set<ProductDescription> descriptions = new HashSet<>();
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="product")
	private Set<ProductImage> productImages = new HashSet<>();
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "product")
	private Set<ProductRelationship> relationships = new HashSet<>();
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "product")
	private Set<ProductAttribute> attributes = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinTable(name="es_category_product",
	joinColumns = {@JoinColumn(name="product_id")},
	inverseJoinColumns = {@JoinColumn(name = "category_id")})
	private Set<Category> categories = new HashSet<>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product", orphanRemoval = true)
	private Set<OrderLine> orderLines = new HashSet<>();
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	@JoinColumn(name="manufacturer_id", nullable=true)
	private Manufacturer manufacturer;
	
	//===================== CUSTOM METHODS =======================
	
	public ProductImage getMediumImage() {
		if(getProductImages() != null) {
			for(ProductImage image : getProductImages()) {
				if(image.getImageSize() == ImageSize.MEDIUM && image.isActive()) {
					return image;
				}
			}
		}
		return null;
	}
	
	// Get name of product
	public ProductAttributeValue getNameAttributeValue() {
		if(getAttributes() != null) {
			for(ProductAttribute attribute : getAttributes()) {
				if("Name".equalsIgnoreCase(attribute.getName()) && attribute.getAttributeValues() != null) {
					for(ProductAttributeValue attributeValue : attribute.getAttributeValues()) {
						if(attribute.getAttributeType() == ProductAttributeType.TEXT) {
							return attributeValue;
						}
					}
				}
			}
		}
		return null;
	}
	
	public String getSefUrl() {
		ProductAttributeValue nameAttributeValue = getNameAttributeValue();
		if(nameAttributeValue != null && !nameAttributeValue.getValue().isEmpty()) {
			String name = (nameAttributeValue.getValue().toLowerCase() + " " + getId().toString());
			return DomainUtil.getSefUrl(name);
		}
		return getId().toString();
	}
	
	public ProductAttribute getAttribute() {
		if(getAttributes() != null) {
			Iterator<ProductAttribute> it = getAttributes().iterator();
			return it.next();
		}
		return null;
	}
	
	public ProductImage getSmallImage() {
		if(getProductImages() != null) {
			for(ProductImage image : getProductImages()) {
				if(image.getImageSize() == ImageSize.SMALL) {
					return image;
				}
			}
		}
		return null;
	}
	
	public List<ProductImage> getTinyImages() {
		List<ProductImage> tinyImages = new ArrayList<ProductImage>();
		if(getProductImages() != null) {
			for(ProductImage image : getProductImages()) {
				if(image.getImageSize() == ImageSize.TINY) {
					tinyImages.add(image);
				}
			}
		}
		return tinyImages;
	}
	
	@JSON(include = false)
	public List<ProductImage> getMediumImages() {
		List<ProductImage> mediumImages = new ArrayList<ProductImage>();
		if(getProductImages() != null) {
			for(ProductImage image : getProductImages()) {
				if(image.getImageSize() == ImageSize.MEDIUM) {
					mediumImages.add(image);
				}
			}
		}
		return mediumImages;
	}
	
	@JSON(include = false)
	public List<ProductImage> getBigImages() {
		List<ProductImage> bigImages = new ArrayList<ProductImage>();
		if(getProductImages() != null) {
			for(ProductImage image : getProductImages()) {
				if(image.getImageSize() == ImageSize.BIG) {
					bigImages.add(image);
				}
			}
		}
		return bigImages;
	}
	
	public ProductDescription getDescription() {
		if(descriptions != null && !descriptions.isEmpty()) {
			return descriptions.iterator().next();
		}
		return null;
	}
	
	public ProductDescription getDescription(Language language) {
		if(descriptions != null && !descriptions.isEmpty()) {
			for(ProductDescription productDescription : descriptions) {
				if(productDescription.getLanguage().equals(language)) {
					return productDescription;
				}
			}
		}
		return null;
	}
	
	public ProductAttribute getAttributeByName(String name) {
		if(attributes != null && !attributes.isEmpty()) {
			for(ProductAttribute att : attributes) {
				if(att.getName() != null && att.getName().equalsIgnoreCase("Name")) {
					return att;
				}
			}
		}
		return null;
	}
	
	//=================== HASHCODE AND EQUALS ========================
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	//================== GETTER AND SETTER ======================
	
	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Set<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(Set<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AuditSection getAuditSection() {
		return auditSection;
	}

	public void setAuditSection(AuditSection auditSection) {
		this.auditSection = auditSection;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Integer getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(Integer quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	public Integer getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(Integer reviewCount) {
		this.reviewCount = reviewCount;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}
	
	public Set<ProductDescription> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(Set<ProductDescription> descriptions) {
		this.descriptions = descriptions;
	}

	public Set<ProductImage> getProductImages() {
		return productImages;
	}

	public void setProductImages(Set<ProductImage> productImages) {
		this.productImages = productImages;
	}

	public Set<ProductRelationship> getRelationships() {
		return relationships;
	}

	public void setRelationships(Set<ProductRelationship> relationships) {
		this.relationships = relationships;
	}

	public Set<ProductAttribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(Set<ProductAttribute> attributes) {
		this.attributes = attributes;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}
	
	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public boolean isFeaturedSeller() {
		return featuredSeller;
	}

	public void setFeaturedSeller(boolean featuredSeller) {
		this.featuredSeller = featuredSeller;
	}

	public boolean isNewArrival() {
		return newArrival;
	}

	public void setNewArrival(boolean newArrival) {
		this.newArrival = newArrival;
	}

	public boolean isClearance() {
		return clearance;
	}

	public void setClearance(boolean clearance) {
		this.clearance = clearance;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}
