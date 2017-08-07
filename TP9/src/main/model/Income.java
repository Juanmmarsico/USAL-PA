package main.model;

import java.util.ArrayList;


public class ExpenseWithFriends extends AbstractExpense {
	private ArrayList<Friend> friendsGroup;
	private double splitValue;
	
	public ExpenseWithFriends() {
		// TODO Auto-generated constructor stub
		friendsGroup = new ArrayList<Friend>();
	}

	public ExpenseWithFriends(ArrayList<Friend> friendsGroup, double splitValue) {
		this.friendsGroup = friendsGroup;
		this.splitValue = splitValue;
	}

	public ArrayList<Friend> getFriendsGroup() {
		return friendsGroup;
	}

	public double getSplitValue() {
		return splitValue;
	}

	public void setFriendsGroup(ArrayList<Friend> friendsGroup) {
		this.friendsGroup = friendsGroup;
	}

	public void setSplitValue(double splitValue) {
		this.splitValue = splitValue;
	}
	
	public boolean addFriend(Friend friend){
		return friendsGroup.add(friend);
	}

	public void removeFriend(Friend friend){
		 friendsGroup.remove(friend);
	}
	@Override
	public String toString() {
		String friendsString= "";
		for (Friend friend : friendsGroup) {
			friendsString += friend.toString();
		}
		return friendsString + ";" + splitValue + "\n";
	}
	
	
	
}
