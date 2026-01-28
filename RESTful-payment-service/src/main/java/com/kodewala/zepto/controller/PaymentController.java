package com.kodewala.zepto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kodewala.zepto.bean.PaymentBean;
import com.kodewala.zepto.servic.IPaymentService;

@RestController
public class PaymentController {

	@Qualifier("cardPayment")
	@Autowired
	IPaymentService iPaymentService;

	@PostMapping("confirmPayment")
	public String doPayment(@RequestBody PaymentBean paymentBean) {

		System.out.println(paymentBean.getAmount());

		String result = iPaymentService.pay(paymentBean);

		return result;

	}
}
