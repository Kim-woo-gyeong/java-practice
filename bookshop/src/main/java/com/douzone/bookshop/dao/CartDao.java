package com.douzone.bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookshop.vo.CartVo;

public class CartDao {
	public List<CartVo> findAll(){
		List<CartVo> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "select b.title, a.count, b.price, c.name, c.no from cart a, book b, customer c where a.book_no = b.book_no and a.cus_no = c.no";
			pst = conn.prepareStatement(sql);
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				String title = rs.getString(1);
				int count = rs.getInt(2);
				int price = rs.getInt(3);
				String name = rs.getString(4);
				Long cusNo = rs.getLong(5);
				
				CartVo vo = new CartVo();
				int totalprice = count * price;
				vo.setTitle(title);
				vo.setCount(count);
				vo.setPrice(totalprice);
				vo.setCusName(name);
				vo.setCusNo(cusNo);
				
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
	
	public Boolean insert(CartVo cartVo) {
		Connection conn = null;
		PreparedStatement pst = null;
		Boolean result = false;
		
		try {
			conn = getConnection();
			
			String sql = "insert into cart values(?, ?, ?)";
			pst = conn.prepareStatement(sql);
			
			pst.setLong(2, cartVo.getCusNo());
			pst.setLong(1, cartVo.getBookNo());
			pst.setInt(3,cartVo.getCount());
			
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
