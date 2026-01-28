package com.kodewala.zepto.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kodewala.zepto.entity.PaymentEntity;

@Repository
public class PaymentDAO {

	@Autowired
	SessionFactory sessionFactory;

	public String processPayment(PaymentEntity paymentEntity) {

		System.out.println("I am payment dao");

		Session session = null;
		Transaction txn = null;

		try {

			session = sessionFactory.openSession();
			txn = session.beginTransaction();

			session.save(paymentEntity);

			txn.commit();

			// Return a success message or reference number
			return "Payment Successfully. Ref No : " + paymentEntity.getPaymentRefNo();

		} catch (Exception e) {

			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();

			return "Payment Failed : " + e.getMessage();

		} finally {

			if (session != null) {
				session.close();
			}
		}
	}

}
