package com.min0s.board.vo;

import java.util.List;

public class Board{
	private int boardno;
	private String title;
	private String content;
	private String writer;
	private String writerName;
	private int hitCount;
	private String regDate;
	private String modDate;
	private List<BoardFile> fileList;
	
	public List<BoardFile> getFileList() {
		return fileList;
	}
	public void setFileList(List<BoardFile> fileList) {
		this.fileList = fileList;
	}
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWriterName() {
		return writerName;
	}
	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	public int getHitCount() {
		return hitCount;
	}
	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getModDate() {
		return modDate;
	}
	public void setModDate(String modDate) {
		this.modDate = modDate;
	}
	@Override
	public String toString() {
		return "Board [boardno=" + boardno + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", writerName=" + writerName + ", hitCount=" + hitCount + ", regDate=" + regDate + ", modDate="
				+ modDate + ", fileList=" + fileList + "]";
	}
}
