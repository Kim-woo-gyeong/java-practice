package com.douzone.bookshop.dao.test;

import java.util.List;

import com.douzone.bookshop.dao.OrderDao;
import com.douzone.bookshop.vo.OrderBookVo;
import com.douzone.bookshop.vo.OrderVo;

public class OrderDaoTest {

	public static void main(String[] args) {
//		insertTest(new OrderVo("00001", 39000, "강원도 춘천시 퇴계동",1L));
		System.out.println("*********주문 정보 출력**********");
		selectTest();
//		OrderBookInsert(new OrderBookVo(1L,1L,2));
//		OrderBookInsert(new OrderBookVo(1L,2L,1));
		System.out.println();
		
		System.out.println("*********주문 도서 정보 출력**********");
		OrderBookselect();
	}
	
	public static void insertTest(OrderVo vo) {
		
		vo.setOrderNum(vo.getOrderNum());
		vo.setTotalPrice(vo.getTotalPrice());
		vo.setAddress(vo.getAddress());
		vo.setCusNo(vo.getCusNo());
		
		new OrderDao().insert(vo);
	}
	
	public static void OrderBookInsert(OrderBookVo vo) {
		
		vo.setOrderNo(vo.getOrderNo());
		vo.setBookNo(vo.getBookNo());
		vo.setCount(vo.getCount());
		
		new OrderDao().OrderBookInsert(vo);
	}

	public static void selectTest() {
		List<OrderVo> list = new OrderDao().findAll();
		for(OrderVo vo : list) {
			System.out.println(vo);
		}
	}
	
	public static void OrderBookselect() {
		List<OrderBookVo> list = new OrderDao().OrderBookFind();
		for(OrderBookVo vo : list) {
			System.out.println(vo);
		}
	}
}
