package com.douzone.bookshop.dao.test;

import java.util.List;

import com.douzone.bookshop.dao.CustomerDao;
import com.douzone.bookshop.vo.CustomerVo;

public class CustomerDaoTest {

	public static void main(String[] args) {
//		insertTest("김우경","kwgyeong0423@naver.com","010-9194-0594","kwg0423");
//		insertTest("안대혁","kickscar@gmail.com","010-1111-0000","%123");
		selectTest();
	
//		Boolean result = updateTest(new CustomerVo("김우경", "kwgyeong0423@naver.com", "1234&"));
//		if(result) {
//			System.out.println("******성공******");
//		} else {
//			System.out.println("******실패******");
//		}
//		selectTest();
	}

	public static void insertTest(String name, String email, String tel, String password) {
		CustomerVo vo = new CustomerVo();
		
		vo.setCusname(name);
		vo.setEmail(email);
		vo.setTel(tel);
		vo.setPassword(password);
		
		new CustomerDao().insert(vo);
	}
	
	public static Boolean updateTest(CustomerVo vo) {
		
		vo.setCusname(vo.getCusName());
		vo.setEmail(vo.getEmail());
		vo.setPassword(vo.getPassword());
		
		return new CustomerDao().update(vo);
	}
	
	public static void selectTest() {
		List<CustomerVo> list = new CustomerDao().findAll();
		for(CustomerVo vo : list) {
			System.out.println(vo);
		}
	}
}
