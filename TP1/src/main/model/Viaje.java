package main.model;

import java.util.ArrayList;
import java.util.Calendar;

public abstract class Viaje implements Costo{

protected int numeroDeViaje;	
protected ArrayList<Peaje> peajes= new ArrayList<Peaje>();
protected Calendar fechaDePartida;
protected double peso;
protected boolean custodia= false;
protected Camion camion;
protected Peon [] peones = new Peon[5];
protected double costoBasico;
protected boolean viajeFinalizado;

public Viaje(){}

public Viaje(int numeroDeViaje,Camion camion){
	this.numeroDeViaje = numeroDeViaje;
	this.camion = camion;
	camion.cambiarEstadoCamion();
	viajeFinalizado= false;
}

public Viaje(int numeroDeViaje, Camion camion,Peon[] peones) {
	this(numeroDeViaje, camion);
	this.peones = peones;
	
}
/*Metodo que agrega un arreglo de peones al viaje
 * preCondicion que los peone no hayan sido usados en otro viaje
 * */
protected void agregarPeonesAlViaje(Peon[] peonesParaAgregar) {
	for (Peon peon : peonesParaAgregar) {
		peon.setEnUso(true);
	}
	peones = peonesParaAgregar;
	
}
public void agregarPeonAlViaje(Peon peonParaAgregar) {
	for (int i = 0; i < peones.length; i++) {
		if(peones[i]==(null)){
			peonParaAgregar.setEnUso(true);
			peones[i]=peonParaAgregar;
			break;
		}
	}
	
}

/*
 * Remueve los peones pasados en el array ya sea uno o todos los que estan en el viaje
 */
protected void removerPeonesDelViaje(Peon[] peonesParaRemover){
		for(int j = 0; j < peonesParaRemover.length ; j++){
			removerPeonDelViaje(peonesParaRemover[j]);
		}		
}
protected void removerPeonDelViaje(Peon peon){
	for(int i = 0; i <peones.length;i++){
		if (estaEnElViaje(peon, i)) {
			peon.setEnUso(false);
			peones[i]= null;
		}
	}	
}
public void removerTodosLosPeones() {
	for(int i = 0; i <peones.length;i++){
		if ((peones[i]!=(null))) {
			peones[i].setEnUso(false);
		}
	}	
}

public int peonesEnElViaje(){
	int resultado=0;
	for(int i = 0; i <peones.length;i++){
		if ((peones[i]!=(null))) {
			resultado++;
		}
	}	
	return resultado;
}
public int cantidadDePeajesEnELViaje() {
	return peajes.size();
}


/*
 * Metodo que devuelve si un peon esta en el camion o no
 * 
 * peon Objeto del tipo Peon pasado como Peon de comparacion
 * numeroEnPeones Variable asignada para saber en que parte del array Peones estoy
 */
protected boolean estaEnElViaje(Peon peon, int numeroEnPeones){
	return (peones[numeroEnPeones].equals(peon))?true:false;
}

public Peon[] peonesEnViaje(){
	return peones;
}

/*Metodo que agrega un peaje luego de pasarlo
 * peaje Variable del tipo Peaje pasada para determinar que peaje se paso
 * peajesAgregados variable del tipo entero determinada para saber cuantos peajes ya fueron agregados al viaje
 * */
public void agregarPeaje(String localidad, double precio){
	Peaje peaje= new Peaje(precio,localidad);
	peajes.add(peaje);
}


protected double getCostoBasico() {
	return costoBasico;
}

public void setFechaDePartida(Calendar fechaDePartida) {
	this.fechaDePartida = fechaDePartida;
}

public void setPeso(double peso) {
	this.peso = peso;
}

public void setCustodia(boolean custodia) {
	this.custodia = custodia;
}

public void setCostoBasico(double costoBasico) {
	this.costoBasico = costoBasico;
}

public boolean getFinalizado() {
	// TODO Auto-generated method stub
return viajeFinalizado;
}
public void cambiarCamion(Camion camionDeCambio) {
	camion.cambiarEstadoCamion();
	camionDeCambio.cambiarEstadoCamion();
	camion= camionDeCambio;
}
public void removerCamion() {
	camion.cambiarEstadoCamion();
}
public String getCamionEnEsteViaje() {
	return camion.getPatente();
}
public int getNumeroDeViaje() {
	return numeroDeViaje;
}

public Calendar getFechaPartida() {
	// TODO Auto-generated method stub
	return fechaDePartida;
}

public ArrayList<Peaje> getPeajes() {
	return peajes;
}

public Camion getCamion() {
	// TODO Auto-generated method stub
	return camion;
}

public double getPeso() {
	// TODO Auto-generated method stub
	return peso;
}
public boolean getCustodia(){
	return custodia;
}
public Calendar getFechaDePartida() {
	return fechaDePartida;
}

public Peon[] getPeones() {
	return peones;
}

public boolean isViajeFinalizado() {
	return viajeFinalizado;
}

public void setNumeroDeViaje(int numeroDeViaje) {
	this.numeroDeViaje = numeroDeViaje;
}


public void setPeajes(ArrayList<Peaje> peajes) {
	this.peajes = peajes;
}

public void setCamion(Camion camion) {
	this.camion = camion;
}

public void setPeones(Peon[] peones) {
	this.peones = peones;
}

public void setViajeFinalizado(boolean viajeFinalizado) {
	this.viajeFinalizado = viajeFinalizado;
}
public abstract double devolverCostoDeEsteViaje();
}
