package com.douzone.bookshop.vo;

public class CartVo {
	private String title;
	private int count;
	private Long cusNo;
	private Long bookNo;
	private int price;
	private String cusName;
	
	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public CartVo() {
		
	}
	
	public CartVo(Long cusNo,Long bookNo, int count) {
		this.count = count;
		this.cusNo = cusNo;
		this.bookNo = bookNo;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public Long getCusNo() {
		return cusNo;
	}

	public void setCusNo(Long cusNo) {
		this.cusNo = cusNo;
	}

	@Override
	public String toString() {
		return "CartVo [" +cusNo + "." + cusName + "] [책 제목=" + title + ", 수량=" + count + " 권, 가격 =" + price + "]";
	}
}
