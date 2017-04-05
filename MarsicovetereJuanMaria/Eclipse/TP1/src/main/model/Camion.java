package main.model;

import java.util.Calendar;

public class Camion {
	
private String patente;
private Calendar fechaPatentamiento;
private int cargaMaxima;
private boolean enUso;


public Camion(String patente, Calendar fechaPatentamiento, int cargaMaxima) {
	this.patente = patente;
	this.fechaPatentamiento = fechaPatentamiento;
	this.cargaMaxima = cargaMaxima;
	enUso = false;
}


public void cambiarEstadoCamion(){
	enUso = enUso?false:true;
}

public boolean estaSiendoUsado(){
	return enUso;
}
public String getPatente() {
	return patente;
}
public int getCargaMaxima() {
	return cargaMaxima;
}
public void setCargaMaxima(int cargaMaxima) {
	this.cargaMaxima = cargaMaxima;
}
public Calendar getFechaPatentamiento() {
	return fechaPatentamiento;
}
}
