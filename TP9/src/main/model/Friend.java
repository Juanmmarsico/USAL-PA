package main.model;

public class Friend {
	
	private String name;
	private String lastName;
	private AppRequest appRequest;
	private boolean adeuda = false;

	
	public Friend(String mail, long id, long celNumber, String name, String lastName) {
		this.appRequest = new AppRequest(mail, id, celNumber);
		this.name = name;
		this.lastName = lastName;
	}
	public Friend(String name, String lastName) {
		this.name = name;
		this.lastName = lastName;
	}
	public Friend() {
		// TODO Auto-generated constructor stub
	}
	public AppRequest getAppRequest() {
		return appRequest;
	}
	public String getName() {
		return name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setAppRequest(String mail, long id, long celNumber) {
		this.appRequest = new AppRequest(mail, id, celNumber);
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setAdeuda(boolean adeuda) {
		this.adeuda = adeuda;
	}
	public boolean isAdeuda() {
		return adeuda;
	}
	@Override
	public String toString() {
		return name + ";" + lastName + ";" + appRequest + "\n";
	}
	
	
	
}
