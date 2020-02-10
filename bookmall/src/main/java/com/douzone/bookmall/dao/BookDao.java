package com.douzone.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookmall.vo.BookVo;

public class BookDao {
	
	public BookVo find(Long no) {
		return null;
	}
		
	public List<BookVo> findAll(){
		List<BookVo> result = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			conn = getConnection();
			String sql = "select a.no, a.title, a.state, a.author_no, b.name from book a, author b where a.author_no = b.no";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Long no = rs.getLong(1);
				String title = rs.getString(2); // -> 나중에는 객체에 담아야 함
				String state = rs.getString(3);
				Long authorNo = rs.getLong(4);
				String authorName = rs.getString(5);
				
				BookVo vo = new BookVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setState(state);
				vo.setAuthorNo(authorNo);
				vo.setAutohrName(authorName);
				result.add(vo);
			}
		} catch(SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// 6. 자원 정리
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if(conn !=null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public Boolean insert(BookVo bookVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Boolean result = false;
		try {
			conn = getConnection();
			
			String sql = "insert into book values(null, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bookVo.getTitle());
			pstmt.setString(2, bookVo.getState());
			pstmt.setLong(3, bookVo.getAuthorNo());
			int count = pstmt.executeUpdate();
			
			result = count == 1;
		} catch(SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(conn !=null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public Boolean update(Long no, String state) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Boolean result = false;
		try {
			conn = getConnection();
			
			//3. statement 객체 생성
			String sql = "update book set state = ? where no = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, state);
			pstmt.setLong(2, no);
			
			//4.sql 문 실행
			int count = pstmt.executeUpdate(); // --> insert 갯수
			
			//5. 성공여부
			 result = count == 1;
		} catch(SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// 6. 자원 정리
			try {
				if(pstmt != null)
					pstmt.close();
				if(conn !=null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	private Connection getConnection() throws SQLException{
		Connection conn = null;
		
		try {

			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://127.0.0.1:3306/webdb";
			conn = DriverManager.getConnection(url,"webdb","webdb");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} 
		
		return conn;
	}
}
