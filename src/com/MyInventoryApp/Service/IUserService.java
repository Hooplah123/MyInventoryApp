package com.MyInventoryApp.Service;

import com.MyInventoryApp.DTO.User;


/**
 * IUserService includes all business-related function for a User and related
 * entities
 * @author Andy Freeman
 *
 */
public interface IUserService {

	
	/**
	 * Return a User that contains the given text
	 * @param filter - a substring that should be contained in returned User
	 * @return matching User
	 */
	public User filterUser(String filter);
	
	/**
	 * Save the user and perform a validation check
	 * @param user - the user we are persisting
	 * @throws Exception if unable to save
	 */
	void save(User user) throws Exception;

	/**
	 * Take field input for username and password, and see if a user
	 * exists in the database
	 * @param user - a user whose username and password we are searching for
	 * @return true if username and password are correct, false otherwise
	 */
	public boolean validateUser(User user);

}