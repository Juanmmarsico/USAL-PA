package main.model;


public class AppRequest {
	private String mail;
	private long id;
	private long celNumber;
	
	public AppRequest() {
		// TODO Auto-generated constructor stub
	}

	public AppRequest(String mail, long id, long celNumber) {
		this.mail = mail;
		this.id = id;
		this.celNumber = celNumber;
	}

	public String getMail() {
		return mail;
	}

	public long getId() {
		return id;
	}

	public long getCelNumber() {
		return celNumber;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setCelNumber(long celNumber) {
		this.celNumber = celNumber;
	}

	@Override
	public String toString() {
		return mail + ";" + id + ";" + celNumber + "\n";
	}
	
	
}
