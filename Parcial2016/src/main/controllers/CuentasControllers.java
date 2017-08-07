package main.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Scanner;

import main.model.*;

public class CuentasControllers {
ArrayList<Cuenta> cuentas;
TitularesControllers tC;

public CuentasControllers() {
	// TODO Auto-generated constructor stub
	cuentas = new ArrayList<Cuenta>();
}
public void pasarAMemoria(String file) throws NumberFormatException, Exception{
	File f = new File(file);
	try {
		Scanner s = new Scanner(f);
		while (s.hasNextLine()) {
			String string = (String) s.nextLine();
			String[] aux = string.split(";");
			int numeroDeCuenta= Integer.parseInt(aux[0]);
			Titular titular = tC.buscarTitular(aux[1],Integer.parseInt(aux[2]));
			String []fecha = aux[3].split("/");
			Calendar fechaApertura = new GregorianCalendar(Integer.parseInt(fecha[2]),Integer.parseInt(fecha[1])-1,Integer.parseInt(fecha[0]));
			double saldo = Double.parseDouble(aux[4]);
			
			if(numeroDeCuenta>0){
				double interesesOtorgados = Double.parseDouble(aux[5]);
			cuentas.add(new DeAhorro(titular, fechaApertura, saldo, interesesOtorgados));
			}else{
				double giroDescubierto = Double.parseDouble(aux[5]);
				cuentas.add(new Corriente(titular, fechaApertura, saldo, giroDescubierto));
			}
			}
		s.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public String[] mostrarOrdenadas (){
	String [] devolver = new String[cuentas.size()];
	Comparator<Cuenta> com= new Comparator<Cuenta>() {
		@Override
		public int compare(Cuenta o1, Cuenta o2) {
			// TODO Auto-generated method stub
			return (int) (o1.getSaldo()-o2.getSaldo());
		}
	};
	ArrayList<Cuenta> aux = new ArrayList<Cuenta>(cuentas);
	aux.sort(com);
	for (int i = 0; i < devolver.length; i++) {
		devolver [i] = aux.get(i).toString();
	}
	return null;
}

}
