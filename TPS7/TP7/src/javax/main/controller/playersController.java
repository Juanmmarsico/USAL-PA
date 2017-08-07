package javax.main.controller;

import java.io.File;
import java.io.IOException;
import java.io.NotActiveException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import javax.main.model.Empleado;

public class playersController {
HashMap<Long, Empleado> jugadores= new HashMap<Long, Empleado>();
public playersController() {
	// TODO Auto-generated constructor stub
pasarTXTAMemoria("./Files/empleados.txt");
}

	private void pasarTXTAMemoria(String EmpleadosTXT) {
		// TODO Auto-generated method stub
		Scanner EmpleadoTXTaux=null;
		try {	
			EmpleadoTXTaux= (new Scanner(new File(EmpleadosTXT)));
			while(EmpleadoTXTaux.hasNextLine()){
				String line= EmpleadoTXTaux.nextLine();
				if (line.length()>0) {
					String nombre=leerAnchoFijo(line.substring(0, 45));
				 	String apellido=leerAnchoFijo(line.substring(45,90));
					int dni= Integer.parseInt(line.substring(92,100));
					int sexo= Integer.parseInt(line.substring(90,92));
					int ultimoNumeroCuil= Integer.parseInt(line.substring(100,101));
				 	Calendar bday=new GregorianCalendar(Integer.parseInt(line.substring(105,109)), Integer.parseInt(line.substring(103,105)), Integer.parseInt(line.substring(101,103)));				 	
				 	crearJugador(nombre, apellido, dni, sexo, ultimoNumeroCuil);
				} 
				
			        }
			} catch (IOException e) {
			// TODO: handle exception
			System.err.println(e.toString());
		}catch (InputMismatchException e) {
			// TODO: handle exception
		
		}
	}

	private String leerAnchoFijo(String aux){
		for(int x=0;x<aux.length();x++){
			if(aux.charAt(x)=='$'){
				aux=aux.substring(0,x);
				break;
			}
		}
		return aux;
	}
	
private void crearJugador(String nombre,String apellido, int dNI, int sexo,int ultimoNumeroCuil){
	long cuil=((((long)sexo)*1000000000)+(((int) dNI)*10)+ultimoNumeroCuil);
	if(!existeElJugador(cuil))
		jugadores.put(cuil, new Empleado(nombre, apellido, dNI, sexo, ultimoNumeroCuil));
	else{
		System.err.println("El Empleado ya existe");
	}
		
}

public boolean existeElJugador(long dNI) {
	// TODO Auto-generated method stub
	return jugadores.containsKey(dNI);
}

public Empleado devolverJugador(long dNI){
	Empleado j=existeElJugador(dNI)?jugadores.get(dNI):null;
	return existeElJugador(dNI)?jugadores.get(dNI):null;
}

public String devolverSieteEmpleadosRandom() {
	// TODO Auto-generated method stub
	String aDevolver = "";
	Random random = new Random();
	ArrayList<Empleado> e= new ArrayList<Empleado>(jugadores.values());
	for(int i = 0; i<=7;i++){
		aDevolver+=e.get(random.nextInt(e.size())).toStringParaEquipo();
	}
	return aDevolver;
}
}
