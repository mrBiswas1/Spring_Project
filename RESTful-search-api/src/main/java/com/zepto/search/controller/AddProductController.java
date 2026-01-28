package com.zepto.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zepto.search.bean.ProductBean;
import com.zepto.search.service.ProductService;

@RestController
public class AddProductController {

	@Autowired
	ProductService productService;

	@PostMapping("/addProduct")
	public ResponseEntity addProduct(@RequestBody ProductBean productBean) {

		System.out.println("product bean hited" + productBean.getProductName());

		productService.addProduct(productBean);

		return ResponseEntity.ok("Product added Successfully");

	}

}
