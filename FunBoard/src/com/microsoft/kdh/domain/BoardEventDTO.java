package com.microsoft.kdh.domain;

public class BoardEventDTO {
	private String type;
	private int b_num;
	private String m_id;
	public BoardEventDTO() {
		// TODO Auto-generated constructor stub
	}
	public BoardEventDTO(String type, int b_num, String m_id) {
		super();
		this.type = type;
		this.b_num = b_num;
		this.m_id = m_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getB_num() {
		return b_num;
	}
	public void setB_num(int b_num) {
		this.b_num = b_num;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	
}
