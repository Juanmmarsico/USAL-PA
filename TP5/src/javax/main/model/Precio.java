package javax.main.model;

public class Precio {
private int capacidad;
private String categoria;
private double costo;

public Precio() {
	// TODO Auto-generated constructor stub
}

public Precio(int capacidad, String categoria, double costo) {
	this.capacidad = capacidad;
	this.categoria = categoria;
	this.costo = costo;
}

public int getCapacidad() {
	return capacidad;
}

public String getCategoria() {
	return categoria;
}

public double getCosto() {
	return costo;
}

public void setCapacidad(int capacidad) {
	this.capacidad = capacidad;
}

public void setCategoria(String categoria) {
	this.categoria = categoria;
}

public void setCosto(double costo) {
	this.costo = costo;
}

}
