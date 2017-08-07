package main.model;


public class ViajeCorto extends Viaje {

	private boolean efectivo;
	private double costo;
	private static int contadorViajesCortos;
	
public ViajeCorto(){}

public ViajeCorto(int numeroDeViaje, Camion camion) {
	super(numeroDeViaje, camion);
	contadorViajesCortos++;
	// TODO Auto-generated constructor stub
}

public ViajeCorto(int numeroDeViaje, Camion camion, Peon [] peones) {
	super(numeroDeViaje, camion, peones);
	contadorViajesCortos++;
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
	double costoAuxiliar=(efectivo)?((costo* Costo.descuentoPorEfectivo)/100):costo;
	if (peonesEnElViaje()>0) {
		for (Peon p : peones) {
			costoAuxiliar = costoAuxiliar + p.getCostoDiario();
		}
	}
	if(cantidadDePeajesEnELViaje()>0){
		for (Peaje peaje : peajes) {
			costoAuxiliar = costoAuxiliar + peaje.getImporte();
		}
	}
	return costoAuxiliar;
}

public boolean isEfectivo() {
	return efectivo;
}
 
public static int getContadorViajesCortos() {
	return contadorViajesCortos;
}

public void setEfectivo(boolean efectivo) {
	this.efectivo = efectivo;
}

public void setCosto(double costo) {
	this.costo = costo;
}

public static void setContadorViajesCortos(int contadorViajesCortos) {
	ViajeCorto.contadorViajesCortos = contadorViajesCortos;
}

@Override
public double devolverCostoDeEsteViaje() {
	// TODO Auto-generated method stub
	if(super.getFinalizado()){
		return costo;
	}else
	return -1;
}


}
