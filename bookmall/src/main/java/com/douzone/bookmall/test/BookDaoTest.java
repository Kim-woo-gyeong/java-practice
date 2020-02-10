package com.douzone.bookmall.test;

import java.util.List;

import com.douzone.bookmall.dao.BookDao;
import com.douzone.bookmall.vo.BookVo;

public class BookDaoTest {
	public static void main(String[] args) {
//		insertTest(new BookVo("이클립스","대여가능",6L));
//		insertTest(new BookVo("트와일라잇","대여가능",6L));
//		insertTest(new BookVo("뉴문","대여가능",6L));
//		insertTest(new BookVo("아리랑","대여가능",3L));
//		insertTest(new BookVo("브레이킹던","대여가능",6L));
//		insertTest(new BookVo("젋은그들","대여중",4L));
//		insertTest(new BookVo("아프니까 청춘이다","대여가능",1L));
//		insertTest(new BookVo("귀천","대여가능",2L));
//		insertTest(new BookVo("태백산맥","대여가능",3L));
//		insertTest(new BookVo("풀하우스","대여가능",5L));
		selectTest();
	}
	
	public static void insertTest(BookVo vo) {
		vo.setTitle(vo.getTitle());
		vo.setState(vo.getState());
		vo.setAuthorNo(vo.getAuthorNo());
		vo.setAutohrName(vo.getAutohrName());
		
		new BookDao().insert(vo);
	}
	
	public static void selectTest() {
		List<BookVo> list = new BookDao().findAll();
		for(BookVo vo : list) {
			System.out.println(vo);
		}
	}
}
