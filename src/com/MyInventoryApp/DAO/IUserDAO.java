package com.MyInventoryApp.DAO;

import com.MyInventoryApp.DTO.User;

public interface IUserDAO {

	public void insertUser(User user) throws Exception;

	public void update(User user) throws Exception;

	public void delete(User user) throws Exception;

	public User fetchUser(User user) throws Exception;

}