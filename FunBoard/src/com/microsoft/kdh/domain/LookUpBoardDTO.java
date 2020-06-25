package com.microsoft.kdh.domain;

import java.io.Serializable;

public class LookUpBoardDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int num;
	private String writer;
	private String title;
	private String content;
	private String writeDay;
	private int readcnt;
	private int b_good_total;
	private int b_bad_total;
	public LookUpBoardDTO() {
		// TODO Auto-generated constructor stub
	}
	public LookUpBoardDTO(int num, String writer, String title, String content, String writeDay, int readcnt,
			int b_good_total, int b_bad_total) {
		super();
		this.num = num;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.writeDay = writeDay;
		this.readcnt = readcnt;
		this.b_good_total = b_good_total;
		this.b_bad_total = b_bad_total;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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
	public String getWriteDay() {
		return writeDay;
	}
	public void setWriteDay(String writeDay) {
		this.writeDay = writeDay;
	}
	public int getReadcnt() {
		return readcnt;
	}
	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}
	public int getB_good_total() {
		return b_good_total;
	}
	public void setB_good_total(int b_good_total) {
		this.b_good_total = b_good_total;
	}
	public int getB_bad_total() {
		return b_bad_total;
	}
	public void setB_bad_total(int b_bad_total) {
		this.b_bad_total = b_bad_total;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
