package com.douzone.bookshop.dao.test;

import java.util.List;

import com.douzone.bookshop.dao.CategoryDao;
import com.douzone.bookshop.vo.CategoryVo;

public class CategoryDaoTest {

	public static void main(String[] args) {
//		insertTest(new CategoryVo("소설"));
//		insertTest(new CategoryVo("컴퓨터/IT"));
//		insertTest(new CategoryVo("수필"));
//		insertTest(new CategoryVo("예술"));
		selectTest();
//		Boolean result = new CategoryDao().delete(4L);
//		if(result) {
//			System.out.println("********삭제성공********");
//		} else {
//			System.out.println("********삭제실패********");
//		}
//		selectTest();
	}
	
	public static void insertTest(CategoryVo vo) {
		
		vo.setCategoryName(vo.getCategoryName());
		
		new CategoryDao().insert(vo);
	}
	
	public static void selectTest() {
		List<CategoryVo> list = new CategoryDao().findAll();
		for(CategoryVo vo : list) {
			System.out.println(vo);
		}
	}
}
