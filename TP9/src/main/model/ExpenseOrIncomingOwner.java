package main.model;

public class ExpenseOrIncomingOwner extends AbstractExpense {
	private String categoria;
	private boolean isIncome;
	
	public ExpenseOrIncomingOwner() {
		// TODO Auto-generated constructor stub
	}
	

	public ExpenseOrIncomingOwner(String place, double totalValue, String categoria, boolean isIncome) {
		super(place,(isIncome?(-totalValue):(totalValue)));
		this.categoria = categoria;
		this.isIncome = isIncome;
	}


	public ExpenseOrIncomingOwner(String categoria, boolean isIncome) {
		this.categoria = categoria;
		this.isIncome = isIncome;
	}

	public String getCategoria() {
		return categoria;
	}

	public boolean isIncome() {
		return isIncome;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void setIncome(boolean isIncome) {
		this.isIncome = isIncome;
	}


	@Override
	public String toString() {
		return categoria + ";" + isIncome + "\n";
	}



}
