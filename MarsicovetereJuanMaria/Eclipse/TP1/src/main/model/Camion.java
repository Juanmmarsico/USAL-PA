package main.model;

import java.lang.reflect.Array;
import java.sql.Date;
import java.util.ArrayList;

public class Camion {
private String patente;
private Date fechaPatentamiento;
private int cargaMaxima;
private boolean enUso;


public Camion(String patente, Date fechaPatentamiento, int cargaMaxima) {
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


}
