package com.manifera.meshop.shop.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.manifera.meshop.core.constant.Constant;
import com.manifera.meshop.core.dao.common.Page;
import com.manifera.meshop.core.domain.Product;
import com.manifera.meshop.core.domain.ProductRelationship;
import com.manifera.meshop.core.service.ProductPriceRangeService;
import com.manifera.meshop.core.service.ProductRelationshipService;
import com.manifera.meshop.core.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductPriceRangeService productPriceRangeService;
	
	@Autowired
	private ProductRelationshipService productRelationshipService;
	
	@RequestMapping("/list/{categorySefUrl}/manufacturer/{manufacturerSefUrl}")
	public String listProductsByCatAndManufacturer(Model model, HttpServletRequest request, 
			@PathVariable("categorySefUrl") String categorySefUrl,
			@PathVariable("manufacturerSefUrl") String manufacturerSefUrl,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page) {
		
		Locale locale = RequestContextUtils.getLocale(request);
		Page<Product> productPage = productService.getByCatSefUrlAndManuSefUrl(categorySefUrl, 
				manufacturerSefUrl, locale.getLanguage(), getOffsetFromPageNumber(page),  Constant.PAGE_SIZE);
		
		model.addAttribute("productPage", productPage);
		model.addAttribute("currentPage", page);
		
		return "products-by-cat-manu";
	}
	
	@RequestMapping("/list/{categorySefUrl}/price-range/{priceRangeSefUrl}")
	public String listProductsByCatAndPriceRange(Model model, HttpServletRequest request, 
			@PathVariable("categorySefUrl") String categorySefUrl,
			@PathVariable("priceRangeSefUrl") String priceRangeSefUrl,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page) {
		
		Locale locale = RequestContextUtils.getLocale(request);
		Page<Product> productPage = productService.getByCatUrlAndPriceRange(categorySefUrl, 
				productPriceRangeService.getBySefUrl(priceRangeSefUrl), locale.getLanguage(), 
				getOffsetFromPageNumber(page), Constant.PAGE_SIZE);
		
		model.addAttribute("productPage", productPage);
		model.addAttribute("currentPage", page);
		
		return "products-by-cat-price-range";
	}
	
	@RequestMapping("/details/{productSefUrl}")
	public String showProductDetails(Model model, HttpServletRequest request, 
			@PathVariable("productSefUrl") String productSefUrl) {
		
		Locale locale = RequestContextUtils.getLocale(request);
		Product product = productService.getBySefUrl(productSefUrl, locale.getLanguage());
		List<ProductRelationship> productRelationships = productRelationshipService.getProductRelationships(product);
		
		model.addAttribute("product", product);
		model.addAttribute("productRelationships", productRelationships);
		
		return "product-details";
	}
	
	private int getOffsetFromPageNumber(int page) {
		return (page - 1) * Constant.PAGE_SIZE;
	}
}
