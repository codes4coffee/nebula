package db;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 * 
 * @author mehra
 * getConnection method help us to connect to the appropriate database. In this project we only have one
 * database. Data comes from MyDB interface.
 */
public class DbManager implements MyDB{

	public Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConnection = DriverManager.getConnection(CONN_URL,USER,PASS);
			return myConnection;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
