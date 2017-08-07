package main.model;

public class Peaje {
private double importe;
private String lugar;

public Peaje() {
	// TODO Auto-generated constructor stub
}
public Peaje(double importe, String lugar) {
	this.importe = importe;
	this.lugar = lugar;
}
public double getImporte() {
	return importe;
}
public String getLugar() {
	return lugar;
}
public void setImporte(double importe) {
	this.importe = importe;
}
public void setLugar(String lugar) {
	this.lugar = lugar;
}

}
