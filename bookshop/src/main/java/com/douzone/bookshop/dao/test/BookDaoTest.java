package com.douzone.bookshop.dao.test;

import java.util.List;

import com.douzone.bookshop.dao.BookDao;
import com.douzone.bookshop.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
//		insertTest(new BookVo("이클립스", 12000, 1L));
//		insertTest(new BookVo("이것은 자바다", 15000, 2L));
//		insertTest(new BookVo("뉴문", 13000, 1L));
//		insertTest(new BookVo("아프니까 청춘이다", 13000, 3L));
		selectTest();
//		Boolean result = new BookDao().delete("아프니까 청춘이다");
//		if(result) {
//			System.out.println("********삭제성공********");
//		} else {
//			System.out.println("********삭제실패********");
//		}
//		selectTest();
	}
	
	public static void insertTest(BookVo vo) {
		
		vo.setTitle(vo.getTitle());
		vo.setPrice(vo.getPrice());
		vo.setCategoryNo(vo.getCategoryNo());
		
		new BookDao().insert(vo);
	}
	
	public static void selectTest() {
		List<BookVo> list = new BookDao().findAll();
		for(BookVo vo : list) {
			System.out.println(vo);
		}
	}

}
