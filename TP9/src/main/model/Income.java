package main.model;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

public class Income extends AbstractExpense {
	private static final String [] frecuencia = {"No repetir","Dias","Semanal","Quincenal","Mensual","Bimestral","Cuatrimestral","Semestral","Anual"};
	private static final String [] days = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
	private int repetitions;
	private int [] repetitionsDays = new int [7];

	
	public Income() {
		// TODO Auto-generated constructor stub
	}
	
	public Income(int repetitions,int[] repetitionsDays,String place, double totalValue, Calendar dateOfExpense) {
		super(place, totalValue, dateOfExpense);
		// TODO Auto-generated constructor stub
		this.repetitions = repetitions;
		this.repetitionsDays =repetitionsDays;
	}

	public int getRepetitions() {
		return repetitions;
	}

	public int[] getRepetitionsDays() {
		return repetitionsDays;
	}

	public void setRepetitions(int repetitions) {
		this.repetitions = repetitions;
	}

	public void setRepetitionsDays(int[] repetitionsDays) {
		this.repetitionsDays = repetitionsDays;
	}

	public static String[] getFrecuencia() {
		return frecuencia;
	}

	public static String[] getDays() {
		return days;
	}

	@Override
	public double availableAfterTransaction(double disponible) {
		// TODO Auto-generated method stub
		return disponible+totalValue;
	}

	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return repetitions + ";" + Arrays.toString(repetitionsDays) + ";" + place + ";" + totalValue + ";"
				+ sdf.format(dateOfExpense.getTime())  +"\n";
	}

	
}
