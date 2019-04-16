import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.nebula.domain.Customer;
import com.nebula.domain.Login;
import com.nebula.domain.dao.DbCustomerDao;
import org.junit.Test;

public class ValidateLoginTest {
    @Test
    public void evalBadCredentials() {
        DbCustomerDao woodenDao = new DbCustomerDao();
        Customer customer = woodenDao.validateCustomer(new Login("totally not a user", "def not user"));
        assertNull(customer);
    }
}
