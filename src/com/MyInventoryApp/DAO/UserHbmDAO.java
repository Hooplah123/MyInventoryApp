package com.MyInventoryApp.DAO;

import javax.inject.Named;

import org.hibernate.Query;
import org.hibernate.Session;

import com.MyInventoryApp.DTO.User;

@Named
public class UserHbmDAO implements IUserDAO {

	@Override
	public void insertUser(User user) throws Exception {
		//Save the User to the database
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.save(user);
		
		session.getTransaction().commit();
		
	}

	@Override
	public void update(User user) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User user) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User fetchUser(User user) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			User u1 = (User) session.load(User.class, user.getUsername());
			return u1;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}