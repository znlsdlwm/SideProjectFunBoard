package com.naver.rjs;

import java.io.Serializable;

public class RJSMemberDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String r_id;
	private String r_name;
	private int r_age;
	private String r_pw;
	public RJSMemberDTO() {
		// TODO Auto-generated constructor stub
	}
	public RJSMemberDTO(String r_id, String r_name, int r_age, String r_pw) {
		super();
		this.r_id = r_id;
		this.r_name = r_name;
		this.r_age = r_age;
		this.r_pw = r_pw;
	}
	public String getR_id() {
		return r_id;
	}
	public void setR_id(String r_id) {
		this.r_id = r_id;
	}
	public String getR_name() {
		return r_name;
	}
	public void setR_name(String r_name) {
		this.r_name = r_name;
	}
	public int getR_age() {
		return r_age;
	}
	public void setR_age(int r_age) {
		this.r_age = r_age;
	}
	public String getR_pw() {
		return r_pw;
	}
	public void setR_pw(String r_pw) {
		this.r_pw = r_pw;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((r_id == null) ? 0 : r_id.hashCode());
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
		RJSMemberDTO other = (RJSMemberDTO) obj;
		if (r_id == null) {
			if (other.r_id != null)
				return false;
		} else if (!r_id.equals(other.r_id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MemberDTO [r_id=" + r_id + ", r_name=" + r_name + "]";
	}
	

}
