import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.nebula.domain.Customer;
import com.nebula.domain.Location;
import com.nebula.domain.Login;
import com.nebula.domain.dao.DbCustomerDao;
import org.junit.Test;

public class DbCustomerDaoTest {
    @Test
    public void nonExistentUserLogin() {
        DbCustomerDao woodenDao = new DbCustomerDao();
        Customer customer = woodenDao.validateCustomer(new Login("totally not a user", "def not user"));
        assertNull(customer);
    }

    @Test
    public void registerUser() {
        DbCustomerDao woodenDao = new DbCustomerDao();
        Customer customer = new Customer("name-jeff", "1234", "Bob", new Location());
        int statCode = woodenDao.register(customer);
        assertEquals(1, statCode);
    }

    @Test
    public void registeredUserLogin() {
        DbCustomerDao woodenDao = new DbCustomerDao();
        Login creds = new Login("name-jeff", "1234");
        Customer customer = woodenDao.validateCustomer(creds);
        assertEquals("Bob", customer.getName());
    }
}
