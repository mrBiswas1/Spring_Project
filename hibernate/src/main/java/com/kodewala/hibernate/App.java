package com.kodewala.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.kodewala.hibernate.entity.Payment;

public class App {
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("com\\kodewala\\hibernate\\config\\hibernate-cfg.xml");

		SessionFactory sessionFactory = cfg.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction txn = session.beginTransaction();

		Payment payment = new Payment();
		payment.setAmount(1000);
		payment.setDescription("Iphone 17 Pro");
		payment.setSentby("Tusher Behra");
		payment.setStatus("Out of Delivery");

		session.save(payment);

		txn.commit();
	}
}
