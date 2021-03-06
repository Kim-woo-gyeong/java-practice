package test.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SelectTest {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			//1. JDBC Driver(MyDriver) loading
			Class.forName("com.mysql.jdbc.Driver");
			
			//2. 연결하기- DirverManager에게 Connection을 달라고 요청. DriverManager중에 등록되어있는 Driver의 connection을 얻음..
			String url = "jdbc:mysql://127.0.0.1:3306/webdb";
			conn = DriverManager.getConnection(url,"webdb","webdb");
			
			//3. statement 객체 생성
			stmt = conn.createStatement();
			
			//4.sql 문 실행
			String sql = "select no,name from dept";
			rs = stmt.executeQuery(sql);
			
			//5. result set patch (결과 가져오기)
			while(rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2); // -> 나중에는 객체에 담아야 함
				
				System.out.println(no + " " + name);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch(SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// 6. 자원 정리
			try {
				if(rs != null)
					rs.close();
				if(stmt != null)
					stmt.close();
				if(conn !=null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
