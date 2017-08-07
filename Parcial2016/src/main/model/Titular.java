package main.model;

public class Titular {
private String nombre;
private int documento;
public Titular(String nombre, int documento) {
	this.nombre = nombre;
	this.documento = documento;
}
public Titular() {
}
public String getNombre() {
	return nombre;
}
public int getDocumento() {
	return documento;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public void setDocumento(int documento) {
	this.documento = documento;
}

@Override
public String toString() {
	return nombre + "\t" + documento;
}



}
