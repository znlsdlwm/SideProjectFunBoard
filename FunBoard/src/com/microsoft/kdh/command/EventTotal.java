package com.microsoft.kdh.command;

public class EventTotal {
	private int b_num;
	private int b_good_total;
	private int b_bad_total;
	private int b_warning_total;
	public EventTotal() {
		// TODO Auto-generated constructor stub
	}
	public EventTotal(int b_num, int b_good_total, int b_bad_total, int b_warning_total) {
		super();
		this.b_num = b_num;
		this.b_good_total = b_good_total;
		this.b_bad_total = b_bad_total;
		this.b_warning_total = b_warning_total;
	}

	public int getB_num() {
		return b_num;
	}
	public void setB_num(int b_num) {
		this.b_num = b_num;
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
	public int getB_warning_total() {
		return b_warning_total;
	}
	public void setB_warning_total(int b_warning_total) {
		this.b_warning_total = b_warning_total;
	}
	
}
