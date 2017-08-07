package main.model;

public class MenuDetalle {
private int codigo;
private String descripcion;
private double precio;

public MenuDetalle() {
}

public MenuDetalle(int codigo, String descripcion, double precio) {
	this.codigo = codigo;
	this.descripcion = descripcion;
	this.precio = precio;
}



public int getCodigo() {
	return codigo;
}

public String getDescripcion() {
	return descripcion;
}

public double getPrecio() {
	return precio;
}

public void setCodigo(int codigo) {
	this.codigo = codigo;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

public void setPrecio(double precio) {
	this.precio = precio;
}

@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ""+codigo+";"+descripcion+";"+String.format("%.2f", precio);
	}
}
