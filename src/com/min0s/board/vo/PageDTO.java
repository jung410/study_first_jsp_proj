package com.min0s.board.vo;

public class PageDTO {
	private Criteria cri;
	private int startPage;
	private int endPage;
	private int total;
	private boolean prev;
	private boolean next;
	
	public PageDTO() {}
	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		// 끝페이지, 시작페이지를 구하고
		endPage = ((cri.getPage()-1)/10 + 1) * 10;
		startPage = endPage - 9;
		
		// 게시물이 10개씩 안떨어질 경우의 실제 마지막 page를 구하고
		int realEnd = (total - 1) / cri.getAmout() + 1;
		
		// startPage가 1보다 크면 이전버튼 가능
		prev = startPage > 1;
		next = endPage < realEnd;
		
		// 마지막 페이지는 next가 있다면 endpage로 대입
		// 없다면 realEnd로 대입
		endPage = !next ? realEnd : endPage;
	}
	
	public Criteria getCri() {
		return cri;
	}
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	@Override
	public String toString() {
		return "PageDTO [cri=" + cri + ", startPage=" + startPage + ", endPage=" + endPage + ", total=" + total
				+ ", prev=" + prev + ", next=" + next + "]";
	}
}
