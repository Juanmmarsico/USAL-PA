package javax.main.gui;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import javax.main.controller.FixtureController;
import javax.main.controller.TeamController;
import javax.main.controller.Validations;
import javax.main.controller.playersController;

public class FixtureView {
private Scanner s = new Scanner(System.in);
private int daysCounter=0;
private Calendar dia= Calendar.getInstance();
	private playersController playersController = new playersController();
	private TeamController teamController = new TeamController();
 	private FixtureController fixtureController;
 	private Validations validations= new Validations();
 	
	public void main(String [] args){
//		FixtureView f= new FixtureView();
		generadorArchivosEquipos();
		menu(args);
	}
	
	private void menu(String [] args){
		leerEquipos();
		
		System.out.println("Ingrese el costo del torneo");
		double d = /*validations.validarSiLaOpcionEsUnNumeroConComa()*/3;
		fixtureController = new FixtureController(d, teamController, playersController);
	
	try {
		generarFixture(args[0]);

	} catch (NullPointerException e) {
		System.out.println();
		if (teamController.getEquipos().size()==0) {
			System.err.println("NO HAY EQUIPOS PARA JUGAR");
			System.exit(0);
		}
		
	}
	partidosPendientesAJugar();
	menuGoles();
	buscarGanadores();
	generarEstadisticas();
	System.out.println("desea ver estadisticas de algun Year en particular ingrese 1 para si o otro numero para terminar");
	int si= validations.validarSiLaOpcionEsUnNumero();
	switch (si) {
	case 1:
		menuEstadistica(args);
		break;

	default:
		System.exit(0);
		break;
	}
	}
	private void menuEstadistica(String [] args) {
		// TODO Auto-generated method stub
		String folder = "./"+"Files/Tablas";//s.nextLine();
		File[] files= new File(folder).listFiles();
		String aImprimir = "cantidad de torneos \t promedio de goles \n";
			aImprimir += fixtureController.calcularPromedioDeGoles(files);
		System.out.println(aImprimir);
		System.out.println();
		ArrayList<String> imp= fixtureController.mostrarTablaDePosiciones(args[1],args[2],files);
		Iterator<String> i = imp.iterator();
		while (i.hasNext()) {
			String string = (String) i.next();
			System.out.println(string);
		}
	}

	private void generarEstadisticas() {
		// TODO Auto-generated method stub
		fixtureController.generarEstadisticas(dia,daysCounter);
	}

	private void buscarGanadores() {
		// TODO Auto-generated method stub
		String primero=teamController.buscarGanadores().get(0).getNombreFantacia();
		String segundo=teamController.buscarGanadores().get(1).getNombreFantacia();
		System.out.printf("los equipos ganadores son:\n %s \n %s \n y sus premios respectivamente son %f y %f, mientras nosotros nos robamos %f \n",primero,segundo,(fixtureController.pagar()[2]/7),(fixtureController.pagar()[1]/7),fixtureController.pagar()[0]);
	}

	private void menuGoles() {
		// TODO Auto-generated method stub
		int contadorPartidos=teamController.getEquipos().size()*(teamController.getEquipos().size()-1);
		while (contadorPartidos>0) {
//			if ((dias*teamController.getEquipos().size())<daysCounter) {
//				break;
//			}
			while(!fixtureController.pasarDias(daysCounter)){
				dia.add(dia.DATE, 1);
				daysCounter++;
				System.out.println("hoy no se jugo ningun partido");
			}
			
			System.out.println("Ingrese los goles Locales");
			int golesLocal= validations.validarSiLaOpcionEsUnNumero();
			System.out.println("Ingrese los goles Visitante");
			int golesVisitante= validations.validarSiLaOpcionEsUnNumero();
			fixtureController.seJugoUnPartido(daysCounter, golesLocal, golesVisitante);
			daysCounter++;
			contadorPartidos=contadorPartidos-2;
//			menuGoles();
		}
//			else{
			System.out.println("Se termino EL TORNEO \n");
			return;
//		}
	}

	private void partidosPendientesAJugar() {
		// TODO Auto-generated method stub
		ArrayList<String> arrayList=new ArrayList<String>(fixtureController.partidosPendientesParaJugar());
	int contador=0;
		for (String string : arrayList) {
		System.out.printf("%d - %s \n",contador,string);
		contador++;
	}
	}
	int dias=0;
	private void generarFixture(String string) {
		// TODO Auto-generated method stub
		 dias= Integer.parseInt(string);
		fixtureController.generateAllMathces(1);
	}

	private void leerEquipos(){
		teamController.setPlayersController(playersController);
		System.out.println("ingrese la carpeta donde estan todos los archivos de equipos");
		String folder = "./"+"Files/Equipos";//s.nextLine();
		File[] files= new File(folder).listFiles();
		if ((files.length%2)!=0) {
			File [] aux = new File[files.length-1];
			int random = (new Random()).nextInt(files.length);
			int contador=0;
			for (int i = 0; i < aux.length; i++) {
				if(i!=random){
					aux[i]= files[contador];	
				}
				contador++;
				
			}
		}
		String [] filesNames = new String[files.length];
		for (int i = 0; i < files.length; i++)         { 
			if (files[i].isFile())             {
                filesNames[i] = files[i].getName();
                System.out.println(files);
            }
        }
		for (String string : filesNames) {
			teamController.lectorDeTXT(folder+"/"+string);
		}		
	}

	private void generadorArchivosEquipos(){
		Random r= new Random();
		int cantidadDeEquipos = r.nextInt(10);
		String [] equipos= new String[cantidadDeEquipos]; 
		for(int i = 0; i<cantidadDeEquipos;i++){
			equipos[i] = "Equipo"+i+".txt";
		}
		
		for (String string : equipos) {
			String aEscribir="Equipo: ";
			for(int q=0;q<r.nextInt(20);q++){
			aEscribir+= ""+(char) (r.nextInt(25)+97);
			}
		aEscribir+="\n"+playersController.devolverSieteEmpleadosRandom();
			try {
				FileWriter f = new FileWriter("./Files/Equipos/"+string);
				f.write(aEscribir);
				f.flush();
				f.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
