package com.min0s.board.vo;

public class BoardFile {
	private int fileno;
	private int boardno;
	private int fileorder;
	private String filename;
	private String originname;
	private String mimetype;
	private String filepath;
	private int filesize;
	private String regdate;
	
	public int getFileno() {
		return fileno;
	}
	public void setFileno(int fileno) {
		this.fileno = fileno;
	}
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}
	public int getFileorder() {
		return fileorder;
	}
	public void setFileorder(int fileorder) {
		this.fileorder = fileorder;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getOriginname() {
		return originname;
	}
	public void setOriginname(String originname) {
		this.originname = originname;
	}
	public String getMimetype() {
		return mimetype;
	}
	public void setMimetype(String mimetype) {
		this.mimetype = mimetype;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public int getFilesize() {
		return filesize;
	}
	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "BoardFile [fileno=" + fileno + ", boardno=" + boardno + ", fileorder=" + fileorder + ", filename="
				+ filename + ", originname=" + originname + ", mimetype=" + mimetype + ", filepath=" + filepath
				+ ", filesize=" + filesize + ", regdate=" + regdate + "]";
	}
}
