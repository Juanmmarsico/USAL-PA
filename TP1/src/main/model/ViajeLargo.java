package main.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class ViajeLargo extends Viaje {
	

	private double costoTotal;
	protected Calendar fechaDeLlegada;
	public ArrayList<String> localidades;
	protected double distance;


	

	public ViajeLargo(int distance, int numeroDeViaje, Camion camion) {
		super(numeroDeViaje, camion);
		this.distance= distance;
		// TODO Auto-generated constructor stub
	}
	public ViajeLargo(int distance, int numeroDeViaje, Camion camion,Peon[] peones) {
		super(numeroDeViaje, camion, peones);
		// TODO Auto-generated constructor stub
		this.distance= distance;

	}
	public double costoTotal() {
		costoTotal=calcularCostoTotal();
		return costoTotal;
	}
	public double getCosto() {
		return costoTotal;
	}
	


	public double getCostoTotal() {
		return costoTotal;
	}
	public Calendar getFechaDeLlegada() {
		return fechaDeLlegada;
	}
	public void setCostoTotal(double costoTotal) {
		this.costoTotal = costoTotal;
	}
	public void setFechaDeLlegada(Calendar fechaDeLlegada) {
		this.fechaDeLlegada = fechaDeLlegada;
	}
	public ArrayList<String> getLocalidades() {
		return localidades;
	}
	public void setLocalidades(ArrayList<String> localidades) {
		this.localidades = localidades;
	}
	public void agregarLocalidades(String localidad){
		localidades.add(localidad);
	}
	public Iterator<String> enumerarLocalidades(){
		return localidades.iterator();
	}
	@Override
	public double devolverCostoDeEsteViaje() {
		// TODO Auto-generated method stub
		if(super.getFinalizado()){
			return costoTotal;
		}else
		return -1;
	}
	private double calcularCostoTotal(){
		double costo=super.getCostoBasico();
		double costoAuxiliar=0;
		costoAuxiliar = costoAuxiliar + ((distance>1000)?(costo*((distance-1000)/excesoDistancia)*excesoCosto):0);
		int days=getDays();
		if (peonesEnElViaje()>0) {
			for (Peon p : peones) {
				costoAuxiliar = costoAuxiliar + (p.getCostoDiario()*days);
			}
		}
		if(cantidadDePeajesEnELViaje()>0){
			for (Peaje peaje : peajes) {
				costoAuxiliar = costoAuxiliar + peaje.getImporte();
			}
		}
		return costoAuxiliar;
	}
	public int getDays() {
		// TODO Auto-generated method stub
		return (int) TimeUnit.MILLISECONDS.toDays(Math.abs((getFechaDeLlegada().getTimeInMillis()-getFechaDePartida().getTimeInMillis())));
	}
	
}
