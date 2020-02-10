package com.douzone.bookshop.vo;

public class CustomerVo {
	private Long cusNo;
	private String cusName;
	private String email;
	private String tel;
	private String password;
	
	public CustomerVo(){
		
	}
	
	public CustomerVo(String name, String email, String password) {
		this.cusName = name;
		this.email = email;
		this.password = password;
	}
	
	public String getCusName() {
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Long getCusNo() {
		return cusNo;
	}

	public void setCusNo(Long cusNo) {
		this.cusNo = cusNo;
	}

	@Override
	public String toString() {
		return "CustomerVo [" + cusNo + "번 고객이름=" + cusName + ", email=" + email + ", 전화번호=" + tel
				+ ", 비밀번호=" + password + "]";
	}
	
}
