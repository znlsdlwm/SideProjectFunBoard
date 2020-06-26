package com.naver.rjs;

import java.io.Serializable;

public class RJSBoardDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int r_num;
	private String r_writer;
	private String r_title;
	private String r_content;
	private String r_writeday;
	private int r_readcnt;
	private int r_repRoot;
	private int r_repStep;
	private int r_repIndent;
	
	public RJSBoardDTO() {
		// TODO Auto-generated constructor stub
	}
	public RJSBoardDTO(int r_num, String r_writer, String r_title, String r_content, String r_writeday, int r_readcnt, int r_repRoot,
			int r_repStep, int r_repIndent ) {
		super();
		this.r_num = r_num;
		this.r_writer = r_writer;
		this.r_title = r_title;
		this.r_content = r_content;
		this.r_writeday = r_writeday;
		this.r_readcnt = r_readcnt;
		this.r_repRoot = r_repRoot;
		this.r_repStep = r_repStep;
		this.r_repIndent = r_repIndent;
	}
	public int getR_num() {
		return r_num;
	}
	public void setR_num(int r_num) {
		this.r_num = r_num;
	}
	public String getR_writer() {
		return r_writer;
	}
	public void setR_writer(String r_writer) {
		this.r_writer = r_writer;
	}
	public String getR_title() {
		return r_title;
	}
	public void setR_title(String r_title) {
		this.r_title = r_title;
	}
	public String getR_content() {
		return r_content;
	}
	public void setR_content(String r_content) {
		this.r_content = r_content;
	}
	public String getR_writeday() {
		return r_writeday;
	}
	public void setR_writeday(String r_writeday) {
		this.r_writeday = r_writeday;
	}
	public int getR_readcnt() {
		return r_readcnt;
	}
	public void setR_readcnt(int r_readcnt) {
		this.r_readcnt = r_readcnt;
	}
	public int getR_repRoot() {
		return r_repRoot;
	}
	public void setR_repRoot(int r_repRoot) {
		this.r_repRoot = r_repRoot;
	}
	public int getR_repStep() {
		return r_repStep;
	}
	public void setR_repStep(int r_repStep) {
		this.r_repStep = r_repStep;
	}
	public int getR_repIndent() {
		return r_repIndent;
	}
	public void setR_repIndent(int r_repIndent) {
		this.r_repIndent = r_repIndent;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + r_num;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RJSBoardDTO other = (RJSBoardDTO) obj;
		if (r_num != other.r_num)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BoardDTO [r_num=" + r_num + ", r_writer=" + r_writer + ", r_title=" + r_title + ", r_content="
				+ r_content + ", r_writeday=" + r_writeday + ", r_readcnt=" + r_readcnt + ", r_repRoot=" + r_repRoot
				+ ", r_repStep=" + r_repStep + ", r_repIndent=" + r_repIndent + "]";
	}
	
	
	
	
	
	
}
