package com.kodewala.zepto.servic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.kodewala.zepto.bean.PaymentBean;
import com.kodewala.zepto.dao.PaymentDAO;
import com.kodewala.zepto.entity.PaymentEntity;

@Primary
@Service
public class CardPayment implements IPaymentService {

	@Autowired
	PaymentDAO paymentDAO;

	@Override
	public String pay(PaymentBean paymentBean) {

		System.out.println("I am card");

		PaymentEntity entity = new PaymentEntity();

		entity.setPaymentRefNo(paymentBean.getPaymentRefNo());
		entity.setOrderId(paymentBean.getOrderId());
		entity.setAmount(paymentBean.getAmount());
		entity.setStatus(paymentBean.getStatus());
		entity.setDescription(paymentBean.getDescription());

		String result = paymentDAO.processPayment(entity);

		System.out.println(result);

		return result;

	}

}
