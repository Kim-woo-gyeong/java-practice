package com.douzone.bookshop.vo;

public class OrderVo {
	private Long orderNo;
	private String orderNum;
	private int totalPrice;
	private String address;
	private String cusName;
	private String email;
	private Long cusNo;
	
	public OrderVo() {
		
	}
	public OrderVo(String orderNum, int totalPrice, String address, Long cusNo) {
		this.orderNum = orderNum;
		this.totalPrice = totalPrice;
		this.address = address;
		this.cusNo = cusNo;
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
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCusname() {
		return cusName;
	}
	public void setCusname(String cusName) {
		this.cusName = cusName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getCusNo() {
		return cusNo;
	}
	public void setCusNo(Long cusNo) {
		this.cusNo = cusNo;
	}
	
	@Override
	public String toString() {
		return "OrderVo [" + orderNo + "번째 주문번호 = " + orderNum + ", 주문자 = " + cusName + "/" + email 
				+ ", 결제금액 =" + totalPrice + ", 배송지 ="
				+ address + "]";
	}
}
