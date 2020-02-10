package com.douzone.bookshop.vo;

public class OrderBookVo {
	private Long bookNo;
	private String title;
	private int count;
	private Long orderNo;
	private String orderNum;
	
	public OrderBookVo() {
		
	}
	
	public OrderBookVo(Long orderNo, Long bookNo, int count) {
		this.orderNo = orderNo;
		this.bookNo = bookNo;
		this.count = count;
	}
	
	public Long getBookNo() {
		return bookNo;
	}

	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Long getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	@Override
	public String toString() {
		return "OrderBookVo [주문번호 = " + orderNum + ", 주문도서번호 = " + bookNo +", 주문도서책제목 = " + title + ", 수량 = " + count + " 권]";
	}
	
	
}
