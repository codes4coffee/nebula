import com.nebula.domain.Customer;
import com.nebula.domain.Location;
import com.nebula.domain.Login;
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
}
