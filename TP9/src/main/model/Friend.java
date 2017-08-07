package main.model;

public class Friend {
	
	private String name;
	private String lastName;
	private AppRequest appRequest;
	private double adeuda;
	private static int id;
	private boolean hasChange = false;

	
	public Friend(String mail, long celNumber, String name, String lastName, double adeuda) {
		this();
		this.appRequest = new AppRequest(mail, celNumber);
		this.name = name;
		this.lastName = lastName;
		this.adeuda = adeuda;
	}
	public Friend(String name, String lastName, double adeuda) {
		this();
		this.name = name;
		this.lastName = lastName;
		this.adeuda = adeuda;
	}
	public Friend() {
		// TODO Auto-generated constructor stub
		id ++;
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
		this.appRequest = new AppRequest(mail, celNumber);
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setAdeuda(double adeuda) {
		this.adeuda = adeuda;
	}
	public boolean isAdeuda() {
		return adeuda>0;
	}
	public double getAdeuda() {
		return adeuda;
	}
	public void setHasChange(boolean hasChange) {
		this.hasChange = hasChange;
	}
	
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		if(appRequest.equals(null)){
			return  id +";" +name + ";" + lastName+ adeuda  + " ;" + " ;"+ " ;"  + "\n";
		}
		return  id + ";" 
		+name + ";" 
		+ lastName + ";"
		+  adeuda  + ";"
		+ appRequest.toString()
		 + "\n";
	}
	
	
	
}
