package com.douzone.bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookshop.vo.CustomerVo;

public class CustomerDao {
	
	public List<CustomerVo> findAll(){
		List<CustomerVo> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "select no, name, email, tel, password from customer";
			pst = conn.prepareStatement(sql);
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				Long cusNo = rs.getLong(1);
				String cusName = rs.getString(2);
				String email = rs.getString(3);
				String tel = rs.getString(4);
				String password = rs.getString(5);
				
				CustomerVo vo = new CustomerVo();
				
				vo.setCusNo(cusNo);
				vo.setCusname(cusName);
				vo.setEmail(email);
				vo.setTel(tel);
				vo.setPassword(password);
				
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

	public Boolean insert(CustomerVo cusVo) {
		Connection conn = null;
		PreparedStatement pst = null;
		Boolean result = false;
		
		try {
			conn = getConnection();
			
			String sql = "insert into customer values(null,?,?,?,?)";
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, cusVo.getCusName());
			pst.setString(2, cusVo.getEmail());
			pst.setString(3, cusVo.getTel());
			pst.setString(4, cusVo.getPassword());
			
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
	
	public Boolean update(CustomerVo vo) {
		Connection conn = null;
		PreparedStatement pst = null;
		Boolean result = false;
		try {
			
			conn = getConnection();
			
			//4.sql 문 실행
			String sql = "update customer set password = ? where email = ? and name = ?";
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, vo.getPassword());
			pst.setString(2, vo.getEmail());
			pst.setString(3, vo.getCusName());
			
			int count = pst.executeUpdate(); // --> insert 갯수
			
			//5. 성공여부
			 result = count == 1;
		} catch(SQLException e) {
			System.out.println("error:" + e);
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
