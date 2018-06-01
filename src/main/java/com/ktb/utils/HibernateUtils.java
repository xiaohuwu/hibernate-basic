package com.ktb.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	
	private HibernateUtils(){}
	
	private static HibernateUtils instance = new HibernateUtils();
	
	public static HibernateUtils getInstance() {
		return instance;
	}

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration config = new Configuration().configure(); // Hibernate框架加载hibernate.cfg.xml文件
			sessionFactory = config.buildSessionFactory();
		}
		return sessionFactory;
	}
	
	public Session getSession(){
		return getSessionFactory().getCurrentSession();
	}

}
