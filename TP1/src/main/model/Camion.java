package main.model;

import java.util.Calendar;

public class Camion {
	
private String patente;
private Calendar fechaPatentamiento;
private double cargaMaxima;
private boolean enUso;

public Camion(){}

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
public double getCargaMaxima() {
	return cargaMaxima;
}
public void setCargaMaxima(int cargaMaxima) {
	this.cargaMaxima = cargaMaxima;
}
public Calendar getFechaPatentamiento() {
	return fechaPatentamiento;
}


public boolean isEnUso() {
	return enUso;
}


public void setPatente(String patente) {
	this.patente = patente;
}


public void setFechaPatentamiento(Calendar fechaPatentamiento) {
	this.fechaPatentamiento = fechaPatentamiento;
}


public void setEnUso(boolean enUso) {
	this.enUso = enUso;
}
}
