package main.model;


public class ViajeCorto extends Viaje implements Costo{

	private boolean efectivo;
private int descuentoPorEfectivo =95;
private double costo;

public ViajeCorto(int distance, int numeroDeViaje, Camion camion) {
	super(distance, numeroDeViaje, camion);
	// TODO Auto-generated constructor stub
}

public ViajeCorto(int distance, int numeroDeViaje, Camion camion, Peon [] peones) {
	super(distance, numeroDeViaje, camion, peones);
	// TODO Auto-generated constructor stub
}

public double getCosto() {
	return costo;
}

public double costoTotal(boolean pagoEnEfectivo) {
	efectivo=pagoEnEfectivo;
	costo=costoTotal();
	return costo;
}





@Override
public double costoTotal() {
	double costo=super.getCostoBasico();
	double costoAuxiliar=(efectivo)?((costo*descuentoPorEfectivo)/100):costo;
	return costoAuxiliar;
}
}
