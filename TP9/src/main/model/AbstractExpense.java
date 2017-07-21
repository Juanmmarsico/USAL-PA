package main.model;

public abstract class AbstractExpense {
	private String place;
	private double totalValue;
	
	public AbstractExpense(String place, double totalValue) {
		this.place = place;
		this.totalValue = totalValue;
	}
	
public AbstractExpense() {
	// TODO Auto-generated constructor stub
}

public String getPlace() {
	return place;
}

public double getTotalValue() {
	return totalValue;
}

public void setPlace(String place) {
	this.place = place;
}

public void setTotalValue(double totalValue) {
	this.totalValue = totalValue;
}

@Override
public String toString() {
	return place + ";" + totalValue + "\n";
}


}
