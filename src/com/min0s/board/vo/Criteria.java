package com.min0s.board.vo;

public class Criteria {
	private int page;
	private int amout;
	
	public Criteria() {
		page = 1;
		amout = 10;
	}
	public Criteria(int page, int amout) {
		this.page = page;
		this.amout = amout;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getAmout() {
		return amout;
	}
	public void setAmout(int amout) {
		this.amout = amout;
	}
}
