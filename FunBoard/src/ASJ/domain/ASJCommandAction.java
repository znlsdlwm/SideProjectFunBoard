package ASJ.domain;

public class ASJCommandAction {
	private boolean isRedirect;
	private String where;
	public ASJCommandAction() {
		// TODO Auto-generated constructor stub
	}
	public ASJCommandAction(boolean isRedirect, String where) {
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
