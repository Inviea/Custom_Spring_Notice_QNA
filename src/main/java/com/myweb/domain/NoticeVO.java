package com.myweb.domain;

import java.util.Date;

public class NoticeVO {
	private int nno;
	private String title;
	private String content;
	private String writer;
	private String img;
	private String file;
	private Date regd8;
	private Date modd8;
	private int readcount;
	
	public NoticeVO() {}
	
	public NoticeVO(String title, String writer, String content) {
		this.title = title;
		this.writer = writer;
		this.content = content;
	}

	public NoticeVO(int nno, String title, String content) {
		this.nno = nno;
		this.title = title;
		this.content = content;
	}

	public int getNno() {
		return nno;
	}
	public void setNno(int nno) {
		this.nno = nno;
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
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public Date getRegd8() {
		return regd8;
	}
	public void setRegd8(Date regd8) {
		this.regd8 = regd8;
	}
	public Date getModd8() {
		return modd8;
	}
	public void setModd8(Date modd8) {
		this.modd8 = modd8;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
}
