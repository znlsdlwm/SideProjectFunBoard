package com.microsoft.kdh.domain;

public class CommentDTO {
	private int c_num;
	private String c_writer;
	private String c_content;
	private String c_password;
	private String c_writeday;
	private int c_good;
	private int c_bad;
	private int c_warning;
	private int c_root;
	private int c_step;
	private int c_indent;
	private int b_num;
	public CommentDTO() {
		// TODO Auto-generated constructor stub
	}
	public CommentDTO(int c_num, String c_writer, String c_content, String c_password, String c_writeday, int c_good,
			int c_bad, int c_warning, int c_root, int c_step, int c_indent, int b_num) {
		super();
		this.c_num = c_num;
		this.c_writer = c_writer;
		this.c_content = c_content;
		this.c_password = c_password;
		this.c_writeday = c_writeday;
		this.c_good = c_good;
		this.c_bad = c_bad;
		this.c_warning = c_warning;
		this.c_root = c_root;
		this.c_step = c_step;
		this.c_indent = c_indent;
		this.b_num = b_num;
	}
	public int getC_num() {
		return c_num;
	}
	public void setC_num(int c_num) {
		this.c_num = c_num;
	}
	public String getC_writer() {
		return c_writer;
	}
	public void setC_writer(String c_writer) {
		this.c_writer = c_writer;
	}
	public String getC_content() {
		return c_content;
	}
	public void setC_content(String c_content) {
		this.c_content = c_content;
	}
	public String getC_password() {
		return c_password;
	}
	public void setC_password(String c_password) {
		this.c_password = c_password;
	}
	public String getC_writeday() {
		return c_writeday;
	}
	public void setC_writeday(String c_writeday) {
		this.c_writeday = c_writeday;
	}
	public int getC_good() {
		return c_good;
	}
	public void setC_good(int c_good) {
		this.c_good = c_good;
	}
	public int getC_bad() {
		return c_bad;
	}
	public void setC_bad(int c_bad) {
		this.c_bad = c_bad;
	}
	public int getC_warning() {
		return c_warning;
	}
	public void setC_warning(int c_warning) {
		this.c_warning = c_warning;
	}
	public int getC_root() {
		return c_root;
	}
	public void setC_root(int c_root) {
		this.c_root = c_root;
	}
	public int getC_step() {
		return c_step;
	}
	public void setC_step(int c_step) {
		this.c_step = c_step;
	}
	public int getC_indent() {
		return c_indent;
	}
	public void setC_indent(int c_indent) {
		this.c_indent = c_indent;
	}
	public int getB_num() {
		return b_num;
	}
	public void setB_num(int b_num) {
		this.b_num = b_num;
	}
	
}
