package com.manifera.meshop.shop.controller.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.manifera.meshop.core.service.ManufacturerService;
import com.manifera.meshop.core.service.ProductPriceRangeService;

@ControllerAdvice(basePackages={"com.manifera.meshop.shop.controller"})
public class BaseControllerAdvice {

	@Autowired
	private ManufacturerService manufacturerService;
	
	@Autowired
	private ProductPriceRangeService productPriceRangeService;
	
	@ModelAttribute
    public void globalAttributes(Model model, HttpServletRequest request) {
		model.addAttribute("laptopManufacturers", manufacturerService.getManufacturersByCategoryName("Laptop"));
        model.addAttribute("desktopManufacturers", manufacturerService.getManufacturersByCategoryName("Desktops"));
		model.addAttribute("productPriceRanges", productPriceRangeService.getAllPriceRanges());
    }
}
