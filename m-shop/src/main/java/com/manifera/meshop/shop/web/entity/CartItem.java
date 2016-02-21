package com.manifera.meshop.shop.web.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.manifera.meshop.core.domain.Product;


/**
 *  
 * @author Phat Nguyen
 * 
 */

public class CartItem implements Serializable {
	
	private static final long serialVersionUID = -5187698497860524019L;

	private int quantity;
	
	private Product product;
	
	private BigDecimal totalPrice;
	
	public CartItem() {}
	
	public CartItem(Product product) {
		this.product = product;
		this.quantity = 1;
		this.totalPrice = product.getPrice();
	}
	
	public CartItem(int quantity, Product product) {
		this.quantity = quantity;
		this.product = product;
		this.totalPrice = product.getPrice().multiply(new BigDecimal(quantity));
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
		updateTotalPrice();
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
		updateTotalPrice();
	}
	
	private void updateTotalPrice() {
		this.totalPrice = this.product.getPrice().multiply(new BigDecimal(this.quantity));
	}
	
	public BigDecimal getTotalPrice() {
		return this.totalPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
		CartItem other = (CartItem) obj;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}
}
