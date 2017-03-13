package main.model;

import java.util.ArrayList;

public class ViajeCorto extends Viaje {

private double costoReal;
private int descuentoPorEfectivo =95;

public ViajeCorto(int distance, ArrayList<Peaje> peaje, int numeroDeViaje, Camion camion) {
	super(distance, peaje, numeroDeViaje, camion);
	// TODO Auto-generated constructor stub
}

public double costoTotal(boolean pagoEnEfectivo) {
	return (pagoEnEfectivo)?((costoReal*descuentoPorEfectivo)/100):costoReal;
}
@Override
void agregarPeon(Peon peon) {
	// TODO Auto-generated method stub
	peones.add(peon);
}
@Override
void removerPeon(Peon peon) {
	// TODO Auto-generated method stub
	peones.remove(peon);

}
@Override
boolean estaEnElCamion(Peon peon) {
	// TODO Auto-generated method stub
	return peones.contains(peon);

}
@Override
ArrayList<Peon> peonesEnCamion() {
	// TODO Auto-generated method stub
	return peones;
}
}
