package domain.login;

/**
 * @author mehra
 * The methods that we need to save and retrieve data from the database.
 */
public interface CustomerDao {
    int register(Customer c);

    Customer validateCustomer(Login login);

    // This method does not needed as we have the Login object.
    //Customer getCustomer(String username, String pass);
}