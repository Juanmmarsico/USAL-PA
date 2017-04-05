package test;

import java.util.InputMismatchException;

import main.gui.Vista;

public class Test {

	
	public static void main(String[] args) {
		Vista vista = new Vista();
		try {
//			System.out.println("Ingrese numero de viajes random a agregar hasta un maximo de 5 o 0 si desea no agregar ninguno");
//			int cantidadDeViajes=(new Scanner(System.in).nextInt());
			int cantidadDeViajes=0;

			if(cantidadDeViajes ==0){
			vista.menuInicial();
			}else{
				vista.menuPrincipal(cantidadDeViajes);
			}
				
		} catch (InputMismatchException e) {
			// TODO: handle exception
			System.err.println("Selecciono una opcion invalida");
			vista.menuPrincipal();
		}
		}

}
