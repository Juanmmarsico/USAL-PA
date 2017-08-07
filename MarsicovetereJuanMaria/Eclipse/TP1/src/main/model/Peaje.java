package main.model;

public class Peaje {
private int importe;
private String lugar;

public Peaje(int importe, String lugar) {
	super();
	this.importe = importe;
	this.lugar = lugar;
}
public int getImporte() {
	return importe;
}
public String getLugar() {
	return lugar;
}

}
