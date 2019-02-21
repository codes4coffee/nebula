package db;
/**
 *
 * @author mehra
 * MYSQL database schema :coursedatabase
 * user :coursedatabase_admin
 * pass :Test1234
 *
 */
public interface MyDB {

	String USER="root";
	String PASS="Test1234";
	String CONN_URL="jdbc:mysql://localhost:3306/";


}
/**
CREATE TABLE `customer` (
`userId` char(20) NOT NULL,
`password` char(10) DEFAULT NULL,
`name` char(20) DEFAULT NULL
)


jdbc:mysql://127.0.0.1:3306/coursedatabase?user=coursedatabase_admin

*/
