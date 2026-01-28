package com.zepto.search.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zepto.search.entity.ProductEntity;
import com.zepto.search.request.SearchRequest;
import com.zepto.search.service.ProductService;

@RestController
public class ProductSearchController {

	@Autowired
	ProductService productService;

	@GetMapping("/searchProduct")
	public ResponseEntity searchProduct(@RequestBody SearchRequest searchRequest) {

		System.out.println(searchRequest.getSearchString());
		List<ProductEntity> list = new ArrayList<ProductEntity>();

		list = productService.searchProduct(searchRequest.getSearchString());

		return ResponseEntity.ok(list);

	}

}
