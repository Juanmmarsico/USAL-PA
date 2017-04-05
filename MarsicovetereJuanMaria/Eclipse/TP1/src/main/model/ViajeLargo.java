package main.model;

import java.util.ArrayList;

public class viajeLargo extends Viaje{
	
	private double costo;
	private final int excesoDistancia = 150;
	private final double excesoCosto = 0.015;
	private double costoTotal;
	

	public viajeLargo(int distance, ArrayList<Peaje> peaje, int numeroDeViaje, Camion camion) {
		super(distance, peaje, numeroDeViaje, camion);
		// TODO Auto-generated constructor stub
		costoTotal= costo + ((distance>1000)?(costo*((distance-1000)/150)*excesoCosto):0);
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
