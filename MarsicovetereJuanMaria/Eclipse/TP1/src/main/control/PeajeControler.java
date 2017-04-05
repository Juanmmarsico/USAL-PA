package main.control;

import java.util.ArrayList;

import main.model.Peaje;

public class PeajeControler {
private ArrayList<Peaje> peajes;
public Peaje setearPeaje(int importe, String lugar) {
	peajes.add(new Peaje(importe, lugar));
	return peajes.get(peajes.indexOf(lugar));
}

public String peajesRecientes() {
	String peajesUsados="";
	int n=0;
	for (Peaje peaje : peajes) {
		peajesUsados = n + "  " + peaje.getLugar()+'\n';
	}
	return peajesUsados;
}
public Peaje usarPeajeNuevamente(int npeaje) {
	return peajes.get(npeaje);
}
}
