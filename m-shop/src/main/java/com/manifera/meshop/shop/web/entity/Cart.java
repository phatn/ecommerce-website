package com.manifera.meshop.shop.web.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.manifera.meshop.core.domain.Product;

/**
 *  
 * @author Phat Nguyen
 * 
 */

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, 
	proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart implements Serializable {
	
	private static final long serialVersionUID = -731260743427639649L;

	private List<CartItem> cartItems;

	private int totalItems;
	
	private BigDecimal grandTotal;
	
	public Cart() {
		cartItems = new ArrayList<>();
		grandTotal = new BigDecimal(0);
	}
	
	public int getTotalItems() {
		totalItems = 0;
		for(CartItem cartItem : cartItems) {
			totalItems += cartItem.getQuantity();
		}
		return totalItems;
	}

	public void add(Product product, int quantity) {
		boolean update = false;
		Iterator<CartItem> it = cartItems.iterator();
		while(it.hasNext() && !update) {
			CartItem cartItem = it.next();
			if(cartItem.getProduct().equals(product)) {
				cartItem.setQuantity(cartItem.getQuantity() + quantity);
				update = true;
			}
		}
		if(!update) {
			cartItems.add(new CartItem(quantity, product));
		}
		updateGrandTotal();
	}
	
	public void remove(Product product) {
		Iterator<CartItem> it = cartItems.iterator();
		boolean continueRemove = true;
		while(it.hasNext() && continueRemove) {
			CartItem item = it.next();
			if(item.getProduct().equals(product)) {
				it.remove();
				continueRemove = false;
			}
		}
		updateGrandTotal();
	}
	
	public void clear() {
		cartItems.clear();
		updateGrandTotal();
	}
	
	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public BigDecimal getGrandTotal() {
		return grandTotal;
	}
	
	public void update(List<CartItem> updateCartItems) {
		
		for(CartItem updateCartItem : updateCartItems) {
			for(int i = 0; i < cartItems.size(); i++) {
				if(cartItems.get(i).getProduct().getId().longValue() == updateCartItem.getProduct().getId().longValue()) {
					cartItems.get(i).setQuantity(updateCartItem.getQuantity());
					break;
				}
			}
		}
		updateGrandTotal();
	}
	
	private void updateGrandTotal() {
		grandTotal = new BigDecimal(0);
		for(CartItem cartItem : cartItems) {
			grandTotal = grandTotal.add(cartItem.getTotalPrice());
		}
	}
}
