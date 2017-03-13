package main.model;

import java.sql.Date;
import java.util.ArrayList;

public abstract class Viaje {
protected int distance;
protected ArrayList<Peaje> peaje;
protected Date fechaDePartida;
protected Date fechaDeLlegada;
protected int numeroDeViaje=0;
protected boolean custodia= false;
protected Camion camion;

public Viaje(int distance, ArrayList<Peaje> peaje, int numeroDeViaje, Camion camion) {
	this.distance = distance;
	this.peaje = peaje;
	this.numeroDeViaje = numeroDeViaje;
	this.camion = camion;
	
}
protected ArrayList<Peon> peones;

abstract void agregarPeon(Peon peon);
abstract void removerPeon(Peon peon);
abstract boolean estaEnElCamion(Peon peon);
abstract ArrayList<Peon> peonesEnCamion();


}
