package com.zepto.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zepto.search.bean.ProductBean;
import com.zepto.search.dao.ProductDAO;
import com.zepto.search.entity.ProductEntity;

@Service
public class ProductService {

	@Autowired
	ProductDAO productDAO;

	public void addProduct(ProductBean productBean) {

		System.out.println("Product service");

		ProductEntity productEntity = new ProductEntity();

		productEntity.setProductName(productBean.getProductName());
		productEntity.setDescription(productBean.getDescription());
		productEntity.setQty(productBean.getQty());
		productEntity.setPrice(productBean.getPrice());

		productDAO.saveProduct(productEntity);

	}

	public List<ProductEntity> searchProduct(String name) {
		System.out.println(name);
		List<ProductEntity> products = productDAO.searchProduct(name);

		return products;
	}

}
