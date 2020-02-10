package com.douzone.bookshop.app;

import com.douzone.bookshop.dao.test.BookDaoTest;
import com.douzone.bookshop.dao.test.CartDaoTest;
import com.douzone.bookshop.dao.test.CategoryDaoTest;
import com.douzone.bookshop.dao.test.CustomerDaoTest;
import com.douzone.bookshop.dao.test.OrderDaoTest;

public class BookShopApp {

	public static void main(String[] args) {
		//insert, update(파라미터 : 비밀번호), select 구현
		System.out.println("*********고객 정보 출력**********");
		new CustomerDaoTest();
		CustomerDaoTest.main(args);
		System.out.println();
		
		//insert, delete(파라미터 : 카테고리번호), select 구현
		System.out.println("*********카테고리 정보 출력**********");
		new CategoryDaoTest();
		CategoryDaoTest.main(args);
		System.out.println();
		
		//insert, delete(파라미터 : 책제목), select 구현
		System.out.println("*********도서 정보 출력**********");
		new BookDaoTest();
		BookDaoTest.main(args);
		System.out.println();
		
		//insert, select 구현
		System.out.println("*********카트 정보 출력**********");
		new CartDaoTest();
		CartDaoTest.main(args);
		System.out.println();
		
		//insert, select구현
		new OrderDaoTest();
		OrderDaoTest.main(args);
		System.out.println();
		
	}
	
}
