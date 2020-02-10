package driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDriverTest {

	public static void main(String[] args) {
		
		try {
			//1. JDBC Driver(MyDriver) loading
			Class.forName("driver.MyDriver");
			
			//2. 연결하기- DirverManager에게 Connection을 달라고 요청. DriverManager중에 등록되어있는 Driver의 connection을 얻음..
			String url = "jdbc:mydb//127.0.0.1:9999/webdb";
			Connection connection = DriverManager.getConnection(url,"webdb","webdb");
			System.out.println(connection);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
