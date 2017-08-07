package main.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import main.model.Titular;

public class TitularesControllers {

	ArrayList<Titular> titulares;
	
	public TitularesControllers() {
		// TODO Auto-generated constructor stub
	titulares = new ArrayList<Titular>();
	}
	
	public void pasarAMemoria(String file){
		File fil= new File(file);
		try {
			Scanner scanner= new Scanner(fil);
			while (scanner.hasNextLine()) {
				String [] string = ((String) scanner.nextLine()).split("\t");
				titulares.add(new Titular(string[0], Integer.parseInt(string[1])));
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Titular buscarTitular(String nombre, int documento) throws Exception {
		// TODO Auto-generated method stub
		for (Titular titular : titulares) {
			if (titular.getDocumento() == documento) {
				return titular;
			}
		}
		throw new Exception();
	}

}
