package javax.main.model;


public class Habitacion {
private int numero;
private boolean balcon;
private String comentario;
private Precio precio;
private boolean ocupada;



public Habitacion(int numero, boolean balcon, String comentario,  Precio precio,
		boolean ocupada) {
	this.numero = numero;
	this.balcon = balcon;
	this.comentario = comentario;
	this.precio = precio;
	this.ocupada = ocupada;
}

public Habitacion(int numero,  boolean balcon, String comentario) {
	this.numero = numero;
	this.balcon = balcon;
	this.comentario = comentario;
}

public Habitacion(int numero, boolean balcon, String comentario, Precio precio) {
	this.numero = numero;
	this.balcon = balcon;
	this.comentario = comentario;
	this.precio = precio;
}

public Habitacion() {
}

public int getNumero() {
	return numero;
}

public boolean isBalcon() {
	return balcon;
}

public String getComentario() {
	return comentario;
}

public Precio getPrecio() {
	return precio;
}

public void setNumero(int numero) {
	this.numero = numero;
}

public void setBalcon(boolean balcon) {
	this.balcon = balcon;
}

public void setComentario(String comentario) {
	this.comentario = comentario;
}

public void setPrecio(Precio precio) {
	this.precio = precio;
}

public boolean isOcupada() {
	return ocupada;
}

public void setOcupada(boolean ocupada) {
	this.ocupada = ocupada;
}
public void vaciar(){
	ocupada=false;
}

@Override
	public String toString() throws NullPointerException{
		// TODO Auto-generated method stub
	
		return  "" + numero  + '\t' + comentario + '\t' +(balcon?"si":"no")+ '\t' +precio.getCapacidad() + '\t' + precio.getCategoria() + '\t' +String.format("%.2f", precio.getCosto())+'\n';
	}
}
