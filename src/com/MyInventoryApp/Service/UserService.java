package com.MyInventoryApp.Service;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyInventoryApp.DAO.IUserDAO;
import com.MyInventoryApp.DTO.User;

@Named
public class UserService implements IUserService {
	
	@Inject
	IUserDAO userDAO;
	
	@Override
	public User filterUser(String filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(User user) throws Exception {

		if (user.getUsername() == null || user.getUsername().isEmpty()) {
			throw new Exception("Username is empty");
		} else if (user.getPassword() == null || user.getPassword().isEmpty()) {
			throw new Exception("Password is empty");
		} else if (user.getName() == null || user.getName().isEmpty()) {
			throw new Exception("Name is empty");
		}
		
		userDAO.insertUser(user);
	}

	@Override
	public boolean validateUser(User user) {
		try {
			User u1 = userDAO.fetchUser(user);
			if (u1.getUsername().equals(user.getUsername()) &&
				u1.getPassword().equals(user.getPassword())) {
			return true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	

}