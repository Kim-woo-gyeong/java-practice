package com.douzone.bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookshop.vo.OrderBookVo;
import com.douzone.bookshop.vo.OrderVo;

public class OrderDao {
	
	public List<OrderVo> findAll(){
		List<OrderVo> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "select a.no, a.order_no, b.name,b.email,a.total_price, a.address from orders a, customer b where a.cus_no = b.no";
			pst = conn.prepareStatement(sql);
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				Long orderNo = rs.getLong(1);
				String orderNum = rs.getString(2);
				String cusName = rs.getString(3);
				String email = rs.getString(4);
				int totalPrice = rs.getInt(5);
				String address = rs.getString(6);
				
				OrderVo vo = new OrderVo();
				vo.setOrderNo(orderNo);
				vo.setOrderNum(orderNum);
				vo.setCusname(cusName);
				vo.setEmail(email);
				vo.setTotalPrice(totalPrice);
				vo.setAddress(address);
				
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
	
	public List<OrderBookVo> OrderBookFind(){
		List<OrderBookVo> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "select a.order_no, d.book_no, d.title, c.count\r\n" + 
					" from orders a, customer b, order_book c, book d\r\n" + 
					" where a.no = c.no \r\n" + 
					"	and a.cus_no = b.no\r\n" + 
					"    and c.book_no = d.book_no;";
			pst = conn.prepareStatement(sql);
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				String orderNum = rs.getString(1);
				Long bookNo = rs.getLong(2);
				String title = rs.getString(3);
				int count = rs.getInt(4);
				
				OrderBookVo vo = new OrderBookVo();
				vo.setOrderNum(orderNum);
				vo.setBookNo(bookNo);
				vo.setTitle(title);
				vo.setCount(count);
				
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
	
	public Boolean insert(OrderVo orderVo) {
		Connection conn = null;
		PreparedStatement pst = null;
		Boolean result = false;
		
		try {
			conn = getConnection();
			
			String sql = "insert into orders values(null, concat(date_format(now(),'%Y%m%d'),'-',?), ?, ?, ?)";
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, orderVo.getOrderNum());
			pst.setInt(2, orderVo.getTotalPrice());
			pst.setString(3, orderVo.getAddress());
			pst.setLong(4, orderVo.getCusNo());
			
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
	
	public Boolean OrderBookInsert(OrderBookVo Vo) {
		Connection conn = null;
		PreparedStatement pst = null;
		Boolean result = false;
		
		try {
			conn = getConnection();
			
			String sql = "insert into order_book values(?, ?, ?)";
			pst = conn.prepareStatement(sql);
			
			pst.setLong(1, Vo.getBookNo());
			pst.setLong(2, Vo.getOrderNo());
			pst.setInt(3, Vo.getCount());
			
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
