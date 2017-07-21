package main.model;

import java.util.ArrayList;

public class Owner {

	private String name;
	private String lastName;
	private ArrayList<ExpenseWithFriends> expenseWithFriends;
	private AppRequest appRequest;
	private double disponible;
	private double gastado;

	public Owner(String name, String lastName,
			ArrayList<ExpenseWithFriends> expenseWithFriends, AppRequest appRequest, double disponible,
			double gastado) {
		this();
		this.name = name;
		this.lastName = lastName;
		this.expenseWithFriends = expenseWithFriends;
		this.appRequest = appRequest;
		this.disponible = disponible;
		this.gastado = gastado;
	}
	public Owner(String name, String lastName, AppRequest appRequest, double disponible, double gastado) {
		this();
		this.name = name;
		this.lastName = lastName;
		this.appRequest = appRequest;
		this.disponible = disponible;
		this.gastado = gastado;
	}
	public Owner(String name, String lastName, AppRequest appRequest, double disponible) {
		this();
		this.name = name;
		this.lastName = lastName;
		this.appRequest = appRequest;
		this.disponible = disponible;
	}
	
	public Owner() {
		// TODO Auto-generated constructor stub
		expenseWithFriends = new ArrayList<ExpenseWithFriends>();
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public ArrayList<ExpenseWithFriends> getExpenseWithFriends() {
		return expenseWithFriends;
	}

	public AppRequest getAppRequest() {
		return appRequest;
	}

	public double getDisponible() {
		return disponible;
	}

	public double getGastado() {
		return gastado;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setExpenseWithFriends(ArrayList<ExpenseWithFriends> expenseWithFriends) {
		this.expenseWithFriends = expenseWithFriends;
	}

	public void setAppRequest(AppRequest appRequest) {
		this.appRequest = appRequest;
	}

	public void setDisponible(double disponible) {
		this.disponible = disponible;
	}

	public void setGastado(double gastado) {
		this.gastado = gastado;
	}

	@Override
	public String toString() {
		String expenseWithFriendsToString ="";
		for (ExpenseWithFriends expenseWithFriends2 : expenseWithFriends) {
			expenseWithFriendsToString += expenseWithFriends2.toString();
		}
		return name + ";" + lastName  + ";" + expenseWithFriendsToString + ";" + appRequest.toString() + ";"
				+ disponible + ";" + gastado + "\n";
	}
	
	
	

	
}
