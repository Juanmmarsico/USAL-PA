package main.model;


public class ViajeLargo extends Viaje implements Costo{
	
	private final int excesoDistancia = 150;
	private final double excesoCosto = 0.015;
	private double costoTotal;
	

	public ViajeLargo(int distance, int numeroDeViaje, Camion camion) {
		super(distance, numeroDeViaje, camion);
		// TODO Auto-generated constructor stub
	}
	public ViajeLargo(int distance, int numeroDeViaje, Camion camion,Peon[] peones) {
		super(distance, numeroDeViaje, camion, peones);
		// TODO Auto-generated constructor stub
	}
	public double costoTotal() {
		costoTotal=calcularCostoTotal();
		return costoTotal;
	}
	public double getCosto() {
		return costoTotal;
	}
	
	private double calcularCostoTotal(){
		double costo=super.getCostoBasico();
		double costoAuxiliar=0;
		costoAuxiliar = costoAuxiliar + ((distance>1000)?(costo*((distance-1000)/excesoDistancia)*excesoCosto):0);
		return costoAuxiliar;
	}
	
	
}
