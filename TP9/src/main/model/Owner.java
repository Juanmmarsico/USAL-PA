package main.model;

import java.util.ArrayList;
import java.util.Calendar;

import main.control.action.AddFriendAction;


public class Owner {

	private long id;
	private String name;
	private String lastName;
	private ArrayList<AbstractExpense> expenses;
	private ArrayList<Friend> friends = new ArrayList<Friend>();
	private AppRequest appRequest;
	private double disponible;
	private double gastado;

	
	public Owner(long id, String name, String lastName, ArrayList<AbstractExpense> expenseWithFriends,
			ArrayList<Friend> friends, AppRequest appRequest, double disponible, double gastado) {
		this();
	this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.expenses = expenseWithFriends;
		this.friends = friends;
		this.appRequest = appRequest;
		this.disponible = disponible;
		this.gastado = gastado;
	}
	public Owner(long id, String name, String lastName,
			ArrayList<AbstractExpense> expenseWithFriends, AppRequest appRequest, double disponible,
			double gastado) {
		this();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.expenses = expenseWithFriends;
		this.appRequest = appRequest;
		this.disponible = disponible;
		this.gastado = gastado;
	}
	public Owner(long id, String name, String lastName, AppRequest appRequest, double disponible, double gastado) {
		this();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.appRequest = appRequest;
		this.disponible = disponible;
		this.gastado = gastado;
	}
	public Owner(long id, String name, String lastName, AppRequest appRequest, double disponible) {
		this();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.appRequest = appRequest;
		this.disponible = disponible;
	}
	
	public Owner() {
		// TODO Auto-generated constructor stub
		expenses = new ArrayList<AbstractExpense>();
		friends = new ArrayList<Friend>();

	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public ArrayList<AbstractExpense> getExpense() {
		return expenses;
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

	public void setExpenseWithFriends(ArrayList<AbstractExpense> expenseWithFriends) {
		this.expenses = expenseWithFriends;
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

	public ArrayList<Friend> getFriends() {
		return friends;
	}
	public void setFriends(ArrayList<Friend> friends) {
		this.friends = friends;
	}
	public void  AddFriend(Friend friend){
		friends.add(friend.getId(),friend);
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
		
	public void addIncome(int repetition,int [] repetitionsDays,String place, double totalValue, Calendar dateOfExpense, int repetitions){
		switch (repetition) {
		case 0:
			expenses.add(new Income(repetition,repetitionsDays,place, totalValue, dateOfExpense));
			break;
		case 1:
			
			break;
		case 2:
			for (int i = 0; i < repetition; i++) {
				dateOfExpense.add(Calendar.DATE, 15*i);
				expenses.add(new Income(repetition,repetitionsDays,place, totalValue, dateOfExpense));
			}
			break;
		case 3:
			for (int i = 0; i < repetition; i++) {
				dateOfExpense.add(Calendar.MONTH, i);
				expenses.add(new Income(repetition,repetitionsDays,place, totalValue, dateOfExpense));
			}
			break;
		case 4:
			for (int i = 0; i < repetition; i++) {
				dateOfExpense.add(Calendar.MONTH, i*2);
				expenses.add(new Income(repetition,repetitionsDays,place, totalValue, dateOfExpense));
			}
			break;
		case 5:
			for (int i = 0; i < repetition; i++) {
				dateOfExpense.add(Calendar.MONTH, i*4);
				expenses.add(new Income(repetition,repetitionsDays,place, totalValue, dateOfExpense));
			}
			break;
		case 6:
			for (int i = 0; i < repetition; i++) {
				dateOfExpense.add(Calendar.MONTH, i*6);
				expenses.add(new Income(repetition,repetitionsDays,place, totalValue, dateOfExpense));
			}
			break;
		case 7:
			for (int i = 0; i < repetition; i++) {
				dateOfExpense.add(Calendar.YEAR, i);
				expenses.add(new Income(repetition,repetitionsDays,place, totalValue, dateOfExpense));
			}
			break;
			
		default:
			break;
		}	
	}	

	public  void addExpense(String place, double totalValue, Calendar dateOfExpense, double splitValue) {
		// TODO Auto-generated method stub
		expenses.add(new Expense(place, totalValue, dateOfExpense, splitValue));
		
	}
	public  void addExpense(String place, double totalValue, Calendar dateOfExpense, ArrayList<Friend> friendsInTheExpense,
			double splitValue) {
		// TODO Auto-generated method stub
		expenses.add(new Expense(place, totalValue, dateOfExpense, friendsInTheExpense, splitValue));

	}
	public  void addExpense(String place, double totalValue, Calendar dateOfExpense, ArrayList<Friend> friendsInTheExpense,
			double splitValue, boolean tieneCuotas, int cuotas) {
		// TODO Auto-generated method stub
		for (int i = 0; i < cuotas; i++) {
			dateOfExpense.add(Calendar.MONTH, i);
			expenses.add(new Expense(place, totalValue, dateOfExpense, friendsInTheExpense, splitValue, tieneCuotas, cuotas));
		}

	}
	
	public void addFriend(Friend friend){
		friends.add(friend);
	}
	public void addFriend(String name, String lastName){
		friends.add(new Friend(name, lastName, 0));
	}
	
	@Override
	public String toString() {

		return id
		+ ";" + name 
		+ ";" + lastName  
		+ ";" + appRequest.toString() 
		+ ";" + disponible 
		+ ";" + gastado 
		+ "\n";
	}
	
}
