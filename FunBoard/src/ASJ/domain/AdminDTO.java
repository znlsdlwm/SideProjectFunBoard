package ASJ.domain;

import java.io.Serializable;

public class AdminDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	private int pw;
	public AdminDTO() {
		// TODO Auto-generated constructor stub
	}
	public AdminDTO(String id, int pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPw() {
		return pw;
	}
	public void setPw(int pw) {
		this.pw = pw;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + pw;
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
		AdminDTO other = (AdminDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pw != other.pw)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AdminDTO [id=" + id + ", pw=" + pw + "]";
	}
	

}
