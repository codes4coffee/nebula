import com.nebula.domain.*;
import com.nebula.domain.Thread;
import com.nebula.domain.dao.DbCustomerDao;
import com.nebula.domain.dao.DbThreadDao;
import org.junit.Test;

import static org.junit.Assert.*;

public class DbThreadDaoTest {
    @Test
    public void getThread() {
        DbThreadDao threadDao = new DbThreadDao();
        Thread[] feed = threadDao.getFeed(2);
        assertEquals(2, feed.length);
        assertNotNull(feed);
    }

    @Test
    public void createThread() {
        DbThreadDao threadDao = new DbThreadDao();
        Customer customer = new Customer("name-jeff", "1234", "Bob", new Location());
        RootMessage op = new RootMessage(customer.getUsername(), "Body message", "Title message", "TEXT", "asdf");
        Location loc = new Location();
        loc.setCity("Dallas");
        loc.setCountry("US");
        loc.setLatitude("3");
        loc.setLongitude("2");
        loc.setPostalCode("75080");
        Thread thread = threadDao.postThread(customer, loc, op);
        assertEquals(op, thread.getOpeningPost());
        assertEquals(loc, thread.getLocation());
        assertEquals(customer.getUsername(), thread.getCustomerId());
    }
}
