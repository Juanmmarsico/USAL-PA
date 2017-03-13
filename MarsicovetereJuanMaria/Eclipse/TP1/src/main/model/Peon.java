package main.model;

public final class Peon {
private String nombre;
private int CUIL;
private double costoDiario;

public Peon(String nombre, int cUIL, double costoDiario) {
	super();
	this.nombre = nombre;
	CUIL = cUIL;
	this.costoDiario = costoDiario;
}

public String getNombre() {
	return nombre;
}

public int getCUIL() {
	return CUIL;
}

public double getCostoDiario() {
	return costoDiario;
}

@Override
public String toString() {
	return "Peon [nombre=" + nombre + ", CUIL=" + CUIL + ", costoDiario=" + costoDiario + "]";
}

}
