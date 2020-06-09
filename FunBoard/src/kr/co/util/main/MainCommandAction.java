package kr.co.util.main;

public class MainCommandAction {
	private boolean isRedirect;
	private String where;
	public MainCommandAction() {
		// TODO Auto-generated constructor stub
	}
	public MainCommandAction(boolean isRedirect, String where) {
		super();
		this.isRedirect = isRedirect;
		this.where = where;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getWhere() {
		return where;
	}
	public void setWhere(String where) {
		this.where = where;
	}
	
}
