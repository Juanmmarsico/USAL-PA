package javax.main.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Scanner;

import javax.main.model.Equipo;
import javax.main.model.Torneo;

import org.hamcrest.DiagnosingMatcher;

public class FixtureController {
	Torneo torneo;
	TeamController teamController;
	playersController playersController;


	public FixtureController() {
		// TODO Auto-generated constructor stub
	}
	public FixtureController(double costo){

		torneo= new Torneo(Calendar.getInstance(), costo);
		escribirEnTXT(costo,Calendar.getInstance().get(Calendar.YEAR));
	}
	public FixtureController(double costo, TeamController teamController,playersController playersController){
		this.teamController= teamController;
		torneo= new Torneo(Calendar.getInstance(), costo);
		escribirEnTXT(costo,Calendar.getInstance().get(Calendar.YEAR));
	}
	private void escribirEnTXT(double costo, int i) {
		// TODO Auto-generated method stub
		try {
			File f= new File("./Files/InscripcionesValorAnual.txt");
			if (f.exists()) {
				FileWriter fileWriter = new FileWriter(f,true);				
				fileWriter.write(""+i+'\t'+costo+'\n');
				fileWriter.flush();
			}else{
				FileWriter fileWriter = new FileWriter(f,true);				
				fileWriter.write(""+"Year"+'\t'+"Costo"+'\n');
				fileWriter.write(""+i+'\t'+costo+'\n');
				fileWriter.flush();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void generateAllMathces(int days) throws NullPointerException{
		String aTXT= "Fecha \t Visitante \t Local \n";
		torneo.setEquipos(teamController.getEquipos());
		ArrayList<String> keys= new ArrayList<>(teamController.getEquipos().keySet());
		if(teamController.getEquipos().size()%2!=0){
			String keyToDelete= keys.get((new Random()).nextInt(keys.size()));
			System.out.printf("El Equipo '%s' Fue descartado, pobres empleados!! nos van a hacer huelga \n",keyToDelete);
			torneo.getEquipos().remove(keyToDelete);
			keys.remove(keyToDelete);
		}
		if(keys.size()<2){
		System.err.println("No hay suficientes equipos para hacer el torneo, los empleados deben estar trabajando, y usted quiere un torneo? quien lo entiende");
		return;
		}
		ArrayList<String> aux = new ArrayList<String>(keys);
		Collections.shuffle(aux);
		int multiplicador=1;
		for (String local : keys) {
			aux.remove(local);
			if (!aux.isEmpty()) {
				for (String visitante : aux) {
					Calendar calendar = Calendar.getInstance();
					calendar.add(Calendar.DATE, days+multiplicador);
					teamController.getEquipos().get(local).agregarJugoContraUnEquipo(calendar, teamController.getEquipos().get(visitante));
					teamController.getEquipos().get(visitante).agregarJugoContraUnEquipo(calendar, teamController.getEquipos().get(local));
				System.out.println(calendar.get(calendar.DATE)+""+"/"+calendar.get(Calendar.MONTH));
					aTXT+=teamController.getEquipos().get(visitante).devolverUnResultado(teamController.getEquipos().get(local).getNombreFantacia());
					aTXT+="\n";
					multiplicador++;	
				}	
			}
		}
		try {
			FileWriter fWriter = new FileWriter(new File("./Files/Fixture.txt"));
		fWriter.write(aTXT);
		fWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean seJugoUnPartido(String local,String Visitante, int golesLocal,int golesVisitante){
		
		return teamController.seJugoUnPartido( local, Visitante,  golesLocal, golesVisitante);
	}
public boolean seJugoUnPartido(int diasQuePasaron, int golesLocal,int golesVisitante){
	Calendar dia = new GregorianCalendar(torneo.getYear().get(Calendar.YEAR), torneo.getYear().get(Calendar.MONTH), torneo.getYear().get(Calendar.DATE));
	dia.add(Calendar.DATE, diasQuePasaron);
		return teamController.seJugoUnPartidoHoy(dia,  golesLocal, golesVisitante);
	}
	public ArrayList<String> partidosPendientesParaJugar(){
		return torneo.PartidosPendientesParaJugar();
	}
	public boolean pasarDias(int diasQuePasaron){	
		Calendar dia = new GregorianCalendar(torneo.getYear().get(Calendar.YEAR), torneo.getYear().get(Calendar.MONTH), torneo.getYear().get(Calendar.DATE));
		dia.add(Calendar.DATE, diasQuePasaron);
//		System.out.println(""+ dia.get(Calendar.DATE)+ "/"+dia.get(Calendar.MONTH)+ "/"+dia.get(Calendar.YEAR));
		return (teamController.verSiHayPartidoHoy(dia)[0]>=0);
	}
public ArrayList<Equipo> buscarGanadores(){
	return teamController.buscarGanadores();
}
public double[] pagar(){
	return torneo.pagar();	
}
public double totalObtenidoPorElTorneo(){
	return teamController.getEquipos().size()*torneo.getCostoDelTorneo();
}
public void generarEstadisticas(Calendar dia, int daysCounter) {
	// TODO Auto-generated method stub
	File file = new File("./Files/general.txt");
	try {
		FileWriter fileWriter = new FileWriter(file);
		String year =""+torneo.getYear().get(Calendar.YEAR);
		String tamano=""+torneo.getEquipos().size();
		
		String estadistica= ""+year+" "+tamano+" "+ buscarGanadores().get(0).getNombreFantacia()+" " + buscarGanadores().get(buscarGanadores().size()-1).getNombreFantacia()+ teamController.CantidadTotalDeGoles();
	fileWriter.write(estadistica);
	fileWriter.flush();
	fileWriter.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	dia.add(Calendar.DATE, daysCounter);
	String nombreDeArchivo="tablaPosiciones"+dia.get(Calendar.YEAR)+""+dia.get(Calendar.MONTH);
	File f = new File("./Files/Tablas/"+nombreDeArchivo+".txt");
	try {
		FileWriter fileWriter = new FileWriter(f);
		String estadistica= "nombre del equipo\t puntos obtenidos\t partidos ganados\t partidos empatados\t de partidos perdidos\t de goles a favor\t en contra\t diferencia de estos \n";
		estadistica+= teamController.generarTablaDePosiciones() +'\n';
	fileWriter.write(estadistica);
	fileWriter.flush();
	fileWriter.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public String calcularPromedioDeGoles(File[] files) {
	// TODO Auto-generated method stub
	String aDevolver =""+ (files.length-1) +'\t';
	long promedioGoles =0;
	for (File file : files) {	
		if (!file.getName().equals("./Files/Tablas/.DS_Store")) {
		try {
			Scanner scanner = new Scanner(file);
			boolean primeraVuelta = true;
			while (scanner.hasNextLine()) {
				String string = (String) scanner.nextLine();
				if (!primeraVuelta) {
					String [] s= (string.split("\t"));
					if (s.length<5) {
					break;
					}
					promedioGoles+=Long.parseLong((s[5]));	
				}else{
					primeraVuelta = false;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	promedioGoles = promedioGoles/(files.length-1);
	aDevolver+= promedioGoles+'\n';
	return aDevolver;
}
public ArrayList<String> mostrarTablaDePosiciones(String string, String string2,File[] files) {
	// TODO Auto-generated method stub
	ArrayList<String> aDevolver = new ArrayList<String>();
	boolean encontrado=false;
	for (File file : files) {
		String comp ="tablaPosiciones"+string+string2+".txt";
		if (file.getName().equals(comp)) {
			try {
				Scanner scanner = new Scanner(file);
				while (scanner.hasNextLine()) {
					String s = (String) scanner.nextLine();
					aDevolver.add(s);
				}
				Collections.reverse(aDevolver);
				return aDevolver;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			encontrado = true;
			break;
		}
	}
	if (!encontrado) {
		aDevolver.add("la fecha que ingreso por parametros no es valida");
		return aDevolver;
	}
	return null;
}
}
