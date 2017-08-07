package main.control.controllers;

import java.util.ArrayList;

import main.model.AbstractExpense;

public class ExpenseController {
	
	ArrayList<AbstractExpense> expenses;
	FriendController friendController;
	String expensePath;
	
	public ExpenseController(String expensePath,FriendController friendController) {
		// TODO Auto-generated constructor stub
		this.expensePath = expensePath;
		this.friendController = friendController;
	}
	
}
