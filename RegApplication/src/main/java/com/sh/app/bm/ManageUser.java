package com.sh.app.bm;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sh.app.dao.UserDetails;
import com.sh.app.dao.factory.DaoFactory;

/**
 * This class provides funtionanlity to check User already exist in the system or not
 * Also, provides fuctionality to save the user to Data base
 *  
 * @author SHavara1
 * 
 */

public class ManageUser {

	private static int count = 0;
	private static final String SUCCESS= "Registration Successfull";
	private static final String ALREDY_REGISTRED= " is Already Registered";
	
	/**
	 * Checks of the user is already existed in the system using Hibernate NamedParam
	 * @param user_name
	 * @return
	 */
	public boolean isUserRegistered(String user_name) {
		
		System.out.println("Starting searching");
		SessionFactory sessionFactory = DaoFactory.getSessioFactoryInstance();
		Session session = sessionFactory.openSession();
		Query query = session.getNamedQuery("UserDetails.byName");
		query.setParameter(0, user_name);

		if (query.list().size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * The method whether the used is existed or not, then save. For the first user DB is not checked
	 * @param userDetails
	 * @return
	 * 
	 */
	public String saveUser(UserDetails userDetails) {

		if (count == 0) {
			count++;
			saveUserDetails(userDetails);
			return SUCCESS;
		} else {
			if (isUserRegistered(userDetails.getUsername())) {
				return userDetails.getUsername()+ ALREDY_REGISTRED;
			} else {
				saveUserDetails(userDetails);
				return SUCCESS;
			}
		}
	}
	
	/**
	 * Saves the User Details Entity to DB
	 * @param userDetails
	 * @return
	 */
	private void saveUserDetails(UserDetails userDetails){
		System.out.println("Starting save");
		SessionFactory sessionFactory = DaoFactory.getSessioFactoryInstance();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(userDetails);
		session.getTransaction().commit();
		session.close();
	}
		
		
}
