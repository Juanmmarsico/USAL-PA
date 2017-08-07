package javax.main.control;

import java.io.File;
import java.io.IOException;
import javax.main.model.Cupon;
import javax.main.model.Huesped;

import junit.framework.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HuespedController {
	private ArrayList<Huesped> huespedes;	
	
	public HuespedController() {
		// TODO Auto-generated constructor stub
		huespedes= new ArrayList<>();
	}
	
	public HuespedController(String huespedesTXTName) {
		// TODO Auto-generated constructor stub
		this();
		pasarTXTAMemoria(huespedesTXTName);
	}

	private void pasarTXTAMemoria(String huespedesTXT) {
		// TODO Auto-generated method stub
		Scanner huespedTXTaux=null;
		try {	
			huespedTXTaux= (new Scanner(new File(huespedesTXT)));
			while(huespedTXTaux.hasNextLine()){
				String line= huespedTXTaux.nextLine();
				if (line.length()>0) {
					String nombre=leerAnchoFijo(line.substring(0, 45));
				 	String apellido=leerAnchoFijo(line.substring(45,90));
					int dni= Integer.parseInt(line.substring(90,98));
				 	Calendar bday=new GregorianCalendar(Integer.parseInt(line.substring(102,106)), Integer.parseInt(line.substring(100,102)), Integer.parseInt(line.substring(98,100)));				 	
				 	ArrayList<Cupon> cups = new ArrayList<>();
				 		Calendar vencimiento=Calendar.getInstance();
							 vencimiento = new GregorianCalendar(Integer.parseInt(line.substring(110,114)), Integer.parseInt(line.substring(108,110)), Integer.parseInt(line.substring(106,108)));
				 		Long p=Long.parseLong(line.substring(114,118));				 
				 	huespedes.add(new Huesped(nombre, apellido,dni, bday,vencimiento,p));
				} 
				
			        }
			} catch (IOException e) {
			// TODO: handle exception
			System.err.println(e.toString());
		}catch (InputMismatchException e) {
			// TODO: handle exception
		
		}
	}

	public String leerAnchoFijo(String aux){
		for(int x=0;x<aux.length();x++){
			if(aux.charAt(x)=='$'){
				aux=aux.substring(0,x);
				break;
			}
		}
		return aux;
	}
	
	public Huesped buscarHuesped(long DNI) throws HuespedException{
		
			for (Huesped huesped : huespedes) {
				if (huesped.getdNI()==DNI) {
					return huesped;
				}
			}

			throw new HuespedException(DNI); 
		
	}
}
