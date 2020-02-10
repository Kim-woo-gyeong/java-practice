package com.douzone.bookshop.dao.test;

import java.util.List;

import com.douzone.bookshop.dao.CartDao;
import com.douzone.bookshop.vo.CartVo;

public class CartDaoTest {

	public static void main(String[] args) {
//		insertTest(new CartVo(1L,1L,2));
//		insertTest(new CartVo(2L,3L,1));
//		insertTest(new CartVo(1L,2L,1));
		selectTest();
	}
	
	public static void insertTest(CartVo vo) {
		
		vo.setCusNo(vo.getCusNo());
		vo.setBookNo(vo.getBookNo());
		vo.setCount(vo.getCount());
		
		new CartDao().insert(vo);
	}
	
	public static void selectTest() {
		List<CartVo> list = new CartDao().findAll();
		for(CartVo vo : list) {
			System.out.println(vo);
		}
	}
}
