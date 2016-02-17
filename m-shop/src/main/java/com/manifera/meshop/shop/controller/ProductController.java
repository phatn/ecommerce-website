package com.manifera.meshop.shop.controller;

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
import com.manifera.meshop.core.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/list/{categorySefUrl}/{manufacturerSefUrl}")
	public String listProductsByManufacturerSelUrl(Model model, HttpServletRequest request, 
			@PathVariable("categorySefUrl") String categorySefUrl,
			@PathVariable("manufacturerSefUrl") String manufacturerSefUrl,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page) {
		
		int offset = (page - 1) * Constant.PAGE_SIZE;
		int limit = Constant.PAGE_SIZE;
		
		Locale locale = RequestContextUtils.getLocale(request);
		
		Page<Product> productPage = productService.getByCatSefUrlAndManuSefUrl(categorySefUrl, manufacturerSefUrl, locale.getLanguage(), offset, limit);
		model.addAttribute("productPage", productPage);
		model.addAttribute("currentPage", page);
		
		return "products";
	}
	
	public String listProductsByCategory() {
		
		return "";
	}
	
}
