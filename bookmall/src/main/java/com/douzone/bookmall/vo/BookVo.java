package com.douzone.bookmall.vo;

public class BookVo {
	private Long no;
	private String title;
	private String state;
	
	//private AuthorVo authorNo; <- 원래는 객체지향이면 이렇게..
	private Long authorNo;
	private String authorName;
	
	public BookVo() {
	}
	
	public BookVo(String title, String state, long authorNo) {
		this.title = title;
		this.state = state;
		this.authorNo = authorNo;
	}
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Long getAuthorNo() {
		return authorNo;
	}
	public void setAuthorNo(Long authorNo) {
		this.authorNo = authorNo;
	}
	public String getAutohrName() {
		return authorName;
	}
	public void setAutohrName(String authorName) {
		this.authorName = authorName;
	}
	
	@Override
	public String toString() {
		return "BookVo [no=" + no + ", title=" + title + ", state=" + state + ", authorNo=" + authorNo + ", autohrName="
				+ authorName + "]";
	}
}
