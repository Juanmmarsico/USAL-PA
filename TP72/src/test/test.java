package test;

import java.awt.Image;
import java.awt.print.Printable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import main.Camion;
import main.ClaseRandom;
import main.ExcepcionPropia;

public class test {
	int contador=0;
	String aTXT = "";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	test t = new test();
	PrintStream pantalla= System.out;

	try {
		File file = new File("./Files/log.txt");
		PrintStream archivo = new PrintStream(file);
		System.setOut(archivo);
		t.correr(args);

	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.setOut(pantalla);
	System.out.println("llego");
	}
	
 private void correr(String [] args){
ClaseRandom claseRandom = generarListas();
quitarElemento(args, claseRandom);
escribirImprimir(""+claseRandom.maximoValor());
escribirImprimir(claseRandom.ordenDecendente().toString());
escribirImprimir(""+claseRandom.hayRepetidos());
try {
	escribirImprimir(claseRandom.busquedaMultiple(Integer.parseInt(args[1])).toString());
} catch (NumberFormatException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (ExcepcionPropia e) {
	// TODO Auto-generated catch block
	escribirImprimir(e.getError());
}
//iguales valores
CreadorDeArraylistParaIgualesValores(claseRandom);
 }
 private void CreadorDeArraylistParaIgualesValores(ClaseRandom claseRandom) {
	// TODO Auto-generated method stub
	 Random random = new Random();
	 ArrayList<Camion> camiones = new ArrayList<Camion>();
	 for(int i = 0 ; i<random.nextInt(30);i++){
	 	String patente=""+(char) (random.nextInt(25)+97)+""+(char) (random.nextInt(25)+97)+""+(char) (random.nextInt(25)+97)+""+ (random.nextInt(899)+100);
	 	Calendar calendar= new GregorianCalendar((1900+random.nextInt(150)), random.nextInt(11), random.nextInt(31));
	 	camiones.add(new Camion(patente,calendar,random.nextInt(100)));
	 }
	 ArrayList<Integer> enteros = new ArrayList<Integer>();
	 for(int i = 0 ; i<random.nextInt(50);i++){
		 enteros.add(random.nextInt(10000));
		 }
	 try {
		escribirImprimir(claseRandom.igualesValores(enteros).toString());
	} catch (ExcepcionPropia e) {
		// TODO Auto-generated catch block
		escribirImprimir(e.getError());
	}
	 try {
		escribirImprimir(claseRandom.igualesValores(camiones).toString());
	} catch (ExcepcionPropia e) {
		// TODO Auto-generated catch block
		escribirImprimir(e.getError());
	}
}

private void escribirImprimir (String s){
//	 aTXT+= s;
	 System.out.println(s);
 }
 private ClaseRandom generarListas(){
	 Random random = new Random();
ArrayList<Camion> camiones = new ArrayList<Camion>();
for(int i = 0 ; i<random.nextInt(30);i++){
	String patente=""+(char) (random.nextInt(25)+97)+""+(char) (random.nextInt(25)+97)+""+(char) (random.nextInt(25)+97)+""+ (random.nextInt(899)+100);
	Calendar calendar= new GregorianCalendar((1900+random.nextInt(150)), random.nextInt(11), random.nextInt(31));
	camiones.add(new Camion(patente,calendar,random.nextInt(100)));
}
ClaseRandom claseRandom = new ClaseRandom(7,camiones);
escribirImprimir(claseRandom.getCamion().toString());
escribirImprimir(claseRandom.getNoseque().toString());
return claseRandom;
 }
 private void quitarElemento(String [] args,ClaseRandom claseRandom){
	 if (args.length==0) {
			System.err.println("No hay parametros");
		}else{
			try {
				String aux = ""+claseRandom.removerInteger(Integer.parseInt(args[0]));
				escribirImprimir(aux);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExcepcionPropia e) {
				// TODO Auto-generated catch block
				escribirImprimir(e.getError());
			}
			
		}

 }
}
