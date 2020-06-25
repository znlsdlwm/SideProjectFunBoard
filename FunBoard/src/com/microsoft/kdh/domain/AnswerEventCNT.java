package com.microsoft.kdh.domain;

public class AnswerEventCNT {
	private int c_num;
	private int c_good_total;
	private int c_bad_total;
	private int d_warning_total;
	public AnswerEventCNT(int c_num, int c_good_total, int c_bad_total, int d_warning_total) {
		super();
		this.c_num = c_num;
		this.c_good_total = c_good_total;
		this.c_bad_total = c_bad_total;
		this.d_warning_total = d_warning_total;
	}
	public int getC_num() {
		return c_num;
	}
	public void setC_num(int c_num) {
		this.c_num = c_num;
	}
	public int getC_good_total() {
		return c_good_total;
	}
	public void setC_good_total(int c_good_total) {
		this.c_good_total = c_good_total;
	}
	public int getC_bad_total() {
		return c_bad_total;
	}
	public void setC_bad_total(int c_bad_total) {
		this.c_bad_total = c_bad_total;
	}
	public int getD_warning_total() {
		return d_warning_total;
	}
	public void setD_warning_total(int d_warning_total) {
		this.d_warning_total = d_warning_total;
	}
	
}
