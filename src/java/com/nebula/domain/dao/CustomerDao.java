package com.nebula.domain.dao;

import com.nebula.domain.Customer;
import com.nebula.domain.Login;

/**
 * The methods that we need to save and retrieve data from the database.
 */
public interface CustomerDao {
	int register(Customer c);
	
	/**
	 * Retrieve the Customer object from the database.
	 */
	Customer validateCustomer(Login login);
}
