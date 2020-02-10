package com.douzone.bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookshop.vo.CategoryVo;


public class CategoryDao {
	public List<CategoryVo> findAll(){
		List<CategoryVo> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "select no,name from category";
			pst = conn.prepareStatement(sql);
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				Long categoryNo = rs.getLong(1);
				String categoryName = rs.getString(2);
				
				CategoryVo vo = new CategoryVo();
				
				vo.setCategoryNo(categoryNo);
				vo.setCategoryName(categoryName);
				
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
	
	public Boolean insert(CategoryVo cateVo) {
		Connection conn = null;
		PreparedStatement pst = null;
		Boolean result = false;
		
		try {
			conn = getConnection();
			
			String sql = "insert into category values(null, ?)";
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, cateVo.getCategoryName());
			
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
	
	public Boolean delete(Long no) {
		Connection conn = null;
		PreparedStatement pst = null;
		Boolean result = false;
		
		try {
			conn = getConnection();
			
			String sql = "delete from category where no = ?";
			pst = conn.prepareStatement(sql);
			
			pst.setLong(1, no);
			
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
