package main.controler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import main.model.MenuDetalle;


public class ControladorMenu {
	ArrayList<MenuDetalle> menu;
	
	public void leerArchivo()  {
		try {
			Scanner menus = new Scanner(new File("./Files/Menu"));
			menus.useDelimiter("[\\n,;]+");
			while(menus.hasNext()){
					menu.add((new MenuDetalle(menus.nextInt(), menus.nextLine(), menus.nextDouble())));
				}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public MenuDetalle buscarMenu(int codigo){
		for (MenuDetalle menuDetalle : menu) {
			if (menuDetalle.getCodigo() == codigo) {
				return menuDetalle;
			}
		}
		throw new NullPointerException("no existe el menu seleccionado");
	}
	public void generadorArchivos(){
		
		try {
			FileWriter menu = new FileWriter(new File("./Files/Menu"));
			menu.write(generadorDeMenu());
			menu.close();
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private String generadorDeMenu() {
		String m="";	
		int codigo;
		String descripcion;
		double precio;
		
		for (int i=1;i<20;i++){
		codigo=i;
		descripcion= "    "+ i + "   ";
		precio= i+(i/10);
		m +=  codigo +";"+ descripcion+";"+'\"'+String.format("%.2f", precio)+'\"'+'\n';

		}
		return m;
		}

}
