package com.rainbowsix.cbec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rainbowsix.cbec.model.ProductModel;
import com.rainbowsix.cbec.service.IProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	private IProductService productService = null;
	
	@Autowired
	public void setProductService(IProductService productService) {
		this.productService = productService;
	}
	
	@RequestMapping("all")
	public List<ProductModel> listByAll() throws Exception {
		return productService.getListByAll();
	}
	
}
