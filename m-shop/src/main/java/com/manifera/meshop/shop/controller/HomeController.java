package com.manifera.meshop.shop.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.manifera.meshop.core.dao.common.Page;
import com.manifera.meshop.core.domain.Category;
import com.manifera.meshop.core.domain.Manufacturer;
import com.manifera.meshop.core.domain.Product;
import com.manifera.meshop.core.service.CategoryService;
import com.manifera.meshop.core.service.ManufacturerService;
import com.manifera.meshop.core.service.ProductService;

/**
 *  
 * @author Phat Nguyen
 * 
 */

@Controller
public class HomeController {

	private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ManufacturerService manufacturerService;
	
	@RequestMapping("/")
	public String home(Model model, HttpServletRequest request) {
		Locale locale = RequestContextUtils.getLocale(request);
		
		List<Category> categories = categoryService.getAllCategories(locale.getLanguage());
		LOG.debug("Total categories: " + categories.size());
		
		Page<Product> newArrivalProduct = productService.getNewArrivalProducts(locale.getLanguage());
		LOG.debug("Total new arrival products: " + newArrivalProduct.getTotalRecords());
		
		Page<Product> featuredProduct = productService.getFeaturedProducts(locale.getLanguage());
		LOG.debug("Total featured products: " + featuredProduct.getTotalRecords());
		
		List<Manufacturer> manufacturers = manufacturerService.getManufacturersByCategoryName("Laptop");
		
		model.addAttribute("categories", categories);
		model.addAttribute("newArrivalProduct", newArrivalProduct);
		model.addAttribute("featuredProduct", featuredProduct);
		model.addAttribute("manufacturers", manufacturers);
		
		return "home";
	}
}
