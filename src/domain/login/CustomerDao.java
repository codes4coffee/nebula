package domain.login;

/**
 * @author mehra
 * The methods that we need to save and retrieve data from the database.
 */
public interface CustomerDao {
	int register(Customer c);
	
	/**
	 * Retrieve the Customer object from the database.
	 */
	Customer validateCustomer(Login login);

	// This method is not needed as we have the Login object.
	//Customer getCustomer(String username, String pass);
}
