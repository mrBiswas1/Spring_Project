package com.kodewala.zepto.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodewala.zepto.order.bean.OrderInfo;
import com.kodewala.zepto.order.dao.OrderDAO;
import com.kodewala.zepto.order.entity.Order;

@Service
public class OrderService {

	@Autowired
	OrderDAO orderDAO;

	public int saveOrder(OrderInfo orderInfo) {
		Order orderEntity = new Order();

		orderEntity.setItemName(orderInfo.getItemName());
		orderEntity.setItemQty(orderInfo.getItemQty());
		orderEntity.setItemPrice(orderInfo.getItemPrice());
		orderEntity.setAddress(orderInfo.getAddress());

		int orderId = orderDAO.saveOrder(orderEntity);

		return orderId;

	}

}
