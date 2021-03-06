package com.saurav.bankingapp.service;

import com.saurav.bankingapp.model.User;
import com.saurav.bankingapp.model.enums.UserType;

/**
 * 
 * @author Saurav Sharma
 *
 */
public interface UserService {
	/**
	 * Create a new user and adds it to repository
	 * @param name name of the user
	 * @param email email id of user
	 * @param password password for user
	 * @param phone phone number
	 * @param address address of user
	 * @param type user type of the customer: PREMIUM or REGULAR etc
	 */
	public void add(String name, String email, String password, String phone, String address, UserType type);

	/**
	 * Deletes a user from repository
	 * @param id unique id of user
	 */
	public void delete(long id);

	/**
	 * Updates the info of a user
	 * @param id unique id of user
	 * @param user user object containing info to be updated
	 */
	public void update(long id, User user);
	
	/**
	 * Returns a user by phone number
	 * @param phone phone number of user
	 * @return user object having given phone number
	 */
	public User get(String phone);

	/**
	 * Returns a user by its Id
	 * @param id unique id of user
	 * @return user object with given Id
	 */
	public User getById(long id);

	/**
	 * Checks if a user with given phone number is present
	 * @param phone phone number
	 * @return true if user is present or else false
	 */
	public boolean hasUser(String phone);

	/**
	 * Checks if a user with given id is present
	 * @param id unique id of user
	 * @return true if user with id is present or else false
	 */
	public boolean hasUser(long id);

}
