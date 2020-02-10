package com.douzone.bookshop.vo;

public class BookVo {
	private Long bookNo;
	private String title;
	private int price;
	private Long categoryNo;
	
	public BookVo(){
		
	}
	
	public BookVo(String title, int price, Long categoryNo) {
		this.title = title;
		this.price = price;
		this.categoryNo = categoryNo;
	}
	
	public Long getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(Long categoryNo) {
		this.categoryNo = categoryNo;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "BookVo [책 번호=" + bookNo + ", 책 제목=" + title + ", 가격=" + price + "]";
	}
}
