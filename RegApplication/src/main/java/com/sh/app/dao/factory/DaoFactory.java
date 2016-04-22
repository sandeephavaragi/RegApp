package com.sh.app.dao.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * This provide the Hibernate SessionFactory instance, there will be only one instance created
 * @author SHavara1
 *
 */
public class DaoFactory {

	private static SessionFactory sessionFactoryInstance = new Configuration().configure().buildSessionFactory();
	private DaoFactory() {
		
	}
	public static SessionFactory getSessioFactoryInstance(){
		return sessionFactoryInstance; 
	}

}
