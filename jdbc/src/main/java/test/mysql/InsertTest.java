package test.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {

	public static void main(String[] args) {
		Boolean result = insert("디자인팀");
		if(result) {
			System.out.println("성공");
		}
		
	}
	
	public static boolean insert(String name) {
		Connection conn = null;
		Statement stmt = null;
		Boolean result = false;
		try {
			//1. JDBC Driver(MyDriver) loading
			Class.forName("com.mysql.jdbc.Driver");
			
			//2. 연결하기- DirverManager에게 Connection을 달라고 요청. DriverManager중에 등록되어있는 Driver의 connection을 얻음..
			String url = "jdbc:mysql://127.0.0.1:3306/webdb";
			conn = DriverManager.getConnection(url,"webdb","webdb");
			
			//3. statement 객체 생성
			stmt = conn.createStatement();
			
			//4.sql 문 실행
			String sql = "insert into dept values(null, '"+ name + "')";
			int count = stmt.executeUpdate(sql); // --> insert 갯수
			
			//5. 성공여부
			 result = count == 1;
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch(SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// 6. 자원 정리
			try {
				if(stmt != null)
					stmt.close();
				if(conn !=null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
