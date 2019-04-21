import com.nebula.domain.*;
import com.nebula.domain.Thread;
import com.nebula.domain.dao.DbCustomerDao;
import com.nebula.domain.dao.DbThreadDao;
import org.junit.Test;

import java.io.IOException;

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
    public void createThread() throws IOException {
        DbThreadDao threadDao = new DbThreadDao();
        Customer customer = new Customer("name-jeff", "1234", "Bob", new Location());
        RootMessage op = new RootMessage(customer.getUsername(), "Body message", "Title message", "TEXT", "asdf");
        Location loc = new Location("2600:1700:730:7b30:c4b6:1ac7:7833:9b19");
        Thread thread = threadDao.postThread(customer, loc, op);
        assertEquals(op, thread.getOpeningPost());
        assertEquals(loc, thread.getLocation());
        assertEquals(customer.getUsername(), thread.getCustomerId());
    }
}
