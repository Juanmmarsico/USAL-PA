package main.view;

import main.controler.ControladorMenu;
import main.controler.ControladorVentas;

public class Restaurant {

	public static void main(String[] args) {
		ControladorVentas controladorVentas = new ControladorVentas();
		controladorVentas.getControladorMenu().generadorArchivos();
		controladorVentas.getControladorMenu().leerArchivo();
	}
}
