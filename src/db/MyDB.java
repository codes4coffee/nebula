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

	String USER="project";
	String PASS="password";
	String CONN_URL="jdbc:mysql://localhost:3306/projecttest";
	
	
}
/**
CREATE TABLE `customer` (
`userId` char(20) NOT NULL,
`password` char(10) DEFAULT NULL,
`name` char(20) DEFAULT NULL
)


jdbc:mysql://127.0.0.1:3306/coursedatabase?user=coursedatabase_admin

*/
