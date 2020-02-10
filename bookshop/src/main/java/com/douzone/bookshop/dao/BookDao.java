package com.douzone.bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookshop.vo.BookVo;
public class BookDao {
	public List<BookVo> findAll(){
		List<BookVo> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "select book_no, title, price, category_no from book";
			pst = conn.prepareStatement(sql);
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				Long bookNo = rs.getLong(1);
				String title = rs.getString(2);
				int price = rs.getInt(3);
				Long categoryNo = rs.getLong(4);
				
				BookVo vo = new BookVo();
				
				vo.setBookNo(bookNo);
				vo.setTitle(title);
				vo.setPrice(price);
				vo.setCategoryNo(categoryNo);
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 6. 자원 정리
			try {
				if(rs != null)
					rs.close();
				if(pst != null)
					pst.close();
				if(conn !=null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public Boolean insert(BookVo bookVo) {
		Connection conn = null;
		PreparedStatement pst = null;
		Boolean result = false;
		
		try {
			conn = getConnection();
			
			String sql = "insert into book values(null, ?, ?, ?)";
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, bookVo.getTitle());
			pst.setInt(2, bookVo.getPrice());
			pst.setLong(3, bookVo.getCategoryNo());
			
			int count = pst.executeUpdate();
			
			result = count == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pst != null)
					pst.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public Boolean delete(String title) {
		Connection conn = null;
		PreparedStatement pst = null;
		Boolean result = false;
		
		try {
			conn = getConnection();
			
			String sql = "delete from book where title = ?";
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, title);
			
			int count = pst.executeUpdate();
			
			result = count == 1;
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			// 6. 자원 정리
			try {
				if(pst != null)
					pst.close();
				if(conn !=null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		
		try {

			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://127.0.0.1:3306/bookshop";
			conn = DriverManager.getConnection(url,"bookshop","bookshop");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} 
		
		return conn;
	}
}
