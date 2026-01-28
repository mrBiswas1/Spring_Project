package com.dailyShop.hibernate.connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateCfg {

	public Session hibernateconfigure() {

		Configuration cfg = new Configuration();

		cfg.configure("\\com\\dailyShop\\hibernate\\connection\\hibernate-cfg.xml");

		SessionFactory sessionFactory = cfg.buildSessionFactory();

		Session session = sessionFactory.openSession();

		return session;

	}

}
