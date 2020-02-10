package test.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) {
		Connection connection = null;
		try {
			//1. JDBC Driver(MyDriver) loading
			Class.forName("com.mysql.jdbc.Driver");
			
			//2. 연결하기- DirverManager에게 Connection을 달라고 요청. DriverManager중에 등록되어있는 Driver의 connection을 얻음..
			String url = "jdbc:mysql://127.0.0.1:3306/webdb";
			connection = DriverManager.getConnection(url,"webdb","webdb");
			System.out.println("연결 성공");
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch(SQLException e) {
			System.out.println("error:" + e);
		} finally {
			//3. 자원 정리
			try {
				if(connection !=null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
