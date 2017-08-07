package javax.main.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

import javax.main.model.Empleado;
import javax.main.model.Equipo;


public class TeamController {
	private HashMap<String, Equipo> equipos = new HashMap<>();
	private playersController playersController;
	
	public TeamController() {
		// TODO Auto-generated constructor stub
	}
	public TeamController(playersController playersController){
		this.playersController= playersController;
	}

	private boolean verificarQueNoEsteEnUnEquipo(long dni){
	return	playersController.devolverJugador(dni).getEstaEnUnEquipo();
//		for (Equipo equipo : equipos.values()) {
//			if(equipo.getJugadores().containsKey(dni)){
//				return true;
//			}
//		}
//		return false;
	}
	
	public void agregarJugadorAUnEquipo(String nombreFantacia,long dNI) /*throws Exception*/{
		if (equipos.containsKey(nombreFantacia)) {
				if (!verificarQueNoEsteEnUnEquipo(dNI)) {
						equipos.get(nombreFantacia).agregarJugadorAlEquipo(playersController.devolverJugador(dNI));					
				}else {
					cancelarSuscripcion(nombreFantacia);
//						throw new TeamException(dNI);
				}		
			}
		}
	public void agregarVariosJugadoresAUnEquipo(String nombreFantacia, ArrayList<Empleado> jugadores){
		for (Empleado empleado : jugadores) {
			agregarJugadorAUnEquipo(nombreFantacia, empleado.getdNI());
		}
	}

	private void cancelarSuscripcion(String nombreFantacia){
		equipos.remove(nombreFantacia);
	}
	

	public HashMap<String, Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(HashMap<String, Equipo> equipos) {
		this.equipos = equipos;
	}

	public HashMap<String, Equipo> leerArchivosDeEquipos() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean seJugoUnPartido(String local, String visitante, int golesLocal, int golesVisitante) {
		// TODO Auto-generated method stub
		if (!equipos.containsKey(local) && !equipos.containsKey(visitante)) {
			equipos.get(local).jugoElPartidoContra(visitante, golesVisitante, golesLocal);
			equipos.get(visitante).jugoElPartidoContra(local, golesLocal, golesVisitante);
			try {
				FileWriter fw=new FileWriter(new File("./Files/Resultados.txt"),true);
				fw.write(equipos.get(local).devolverUnResultadoParaTXT(visitante));
				
			} catch (IOException e) {
				// TODO: handle exception
			}
			return true;
		}
		String string= (equipos.containsKey(local))?visitante:((equipos.containsKey(visitante))?local:(local +" y " + visitante));
		System.err.printf("%s nunca se inscribieron como equipo \n",string);
		return false;
		
	}
	public boolean seJugoUnPartidoHoy(Calendar dia,int golesLocal, int golesVisitante) {
		// TODO Auto-generated method stub
		ArrayList<Equipo> aux = new ArrayList<>(equipos.values());
		int [] partido = verSiHayPartidoHoy(dia);
		Equipo local =aux.get(partido[0]);
		Equipo visitante =	equipos.get(local.getJugoContra().get(partido[1]).getVisitante().getNombreFantacia());
		
		local.jugoElPartidoContra(visitante.getNombreFantacia(), golesVisitante, golesLocal);
		visitante.jugoElPartidoContra(local.getNombreFantacia(), golesVisitante, golesLocal);
		String aDevolver= equipos.get(local.getNombreFantacia()).devolverUnResultadoParaTXT(visitante.getNombreFantacia())+"\n";
			try {
				File file =new File("./Files/Resultados.txt");
				FileWriter fwa=new FileWriter(file,true);
				fwa.write(aDevolver);
				fwa.flush();
				
			} catch (IOException e) {
				// TODO: handle exception
			}
			return true;		
	}


	public void lectorDeTXT(String txt){
		try {
			if (txt.equals("./Files/Equipos/.DS_Store")) {
				return;
			}
			File f = new File(txt);
			Scanner scanner = new Scanner(f);
			for(int i=0;scanner.hasNextLine();i++){
				String string = scanner.nextLine();
				if (i==0 ){						
					if(!string.contains("Equipo: ")) {
					System.err.println("NO TIENE EL FORMATO SOLICITADO");
					return;
					}
					}else{
				String [] aux = scanner.nextLine().split(";");
				if (aux.length!=3) {
					System.err.println("NO TIENE EL FORMATO SOLICITADO");
					return;
				}
				if (!playersController.existeElJugador(Long.parseLong(aux[0]))) {
					System.err.printf("La persona %s no pertenece a la empresa \n",aux[2]);
					return;
				}else{
					if (!playersController.devolverJugador(Long.parseLong(aux[0])).getApellido().equals(aux[2]) || !playersController.devolverJugador(Long.parseLong(aux[0])).getNombre().equals(aux[1])) {
						System.err.printf("Los datos de la persona %s no son los que estan agendados \n",aux[1]);
						return;
					}
				}
					}
				if (i>8) {
					System.err.println("NO TIENE EL FORMATO SOLICITADO");
					return;
				}
			}
			scanner.close();
			Scanner equipoAMemoria = new Scanner(f);
			String equipoNombre= equipoAMemoria.nextLine().substring(7);
			String[] jugador1= equipoAMemoria.nextLine().split(";");
			String[] jugador2= equipoAMemoria.nextLine().split(";");
			String[] jugador3= equipoAMemoria.nextLine().split(";");
			String[] jugador4= equipoAMemoria.nextLine().split(";");
			String[] jugador5= equipoAMemoria.nextLine().split(";");
			String[] jugador6= equipoAMemoria.nextLine().split(";");
			String[] jugador7= equipoAMemoria.nextLine().split(";");
			HashMap<Long, Empleado> jugadores = new HashMap<>();
			jugadores.put(Long.parseLong(jugador1[0]), playersController.devolverJugador(Long.parseLong(jugador1[0])));
			jugadores.put(Long.parseLong(jugador2[0]), playersController.devolverJugador(Long.parseLong(jugador2[0])));
			jugadores.put(Long.parseLong(jugador3[0]), playersController.devolverJugador(Long.parseLong(jugador3[0])));
			jugadores.put(Long.parseLong(jugador4[0]), playersController.devolverJugador(Long.parseLong(jugador4[0])));
			jugadores.put(Long.parseLong(jugador5[0]), playersController.devolverJugador(Long.parseLong(jugador5[0])));
			jugadores.put(Long.parseLong(jugador6[0]), playersController.devolverJugador(Long.parseLong(jugador6[0])));
			jugadores.put(Long.parseLong(jugador7[0]), playersController.devolverJugador(Long.parseLong(jugador7[0])));
			equipos.put(equipoNombre, new Equipo(equipoNombre,jugadores));
			
			equipoAMemoria.close();
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

	
	public int[] verSiHayPartidoHoy(Calendar dia) {
		// TODO Auto-generated method stub		
		int posicion=0;
		int[] devolver= {-1,-1};
		ArrayList<Equipo> arrayList = new ArrayList<>(equipos.values());
		ArrayList<Equipo> aux = new ArrayList<>(equipos.values());

		for (Equipo e : arrayList) {
			if (e.tienePartidoHoy(dia)>=0) {
				System.out.printf("Felicitaciones hoy es el partido entre %s y %s \n",e.getNombreFantacia(),e.getJugoContra().get(e.tienePartidoHoy(dia)));
				devolver[0]=posicion;
				devolver[1]=e.tienePartidoHoy(dia);
				return devolver;
			}
			posicion++;
		}
		return devolver;
	}



public ArrayList<Equipo> buscarGanadores(){
Comparator<Equipo> compPuntos= new Comparator<Equipo>() {
	@Override
	public int compare(Equipo o1, Equipo o2) {
		// TODO Auto-generated method stub
		return 	((o1.puntosDeEsteEquipo()-o2.puntosDeEsteEquipo())!=0)?o1.puntosDeEsteEquipo()-o2.puntosDeEsteEquipo():o1.cantidadDeGoles()-o2.cantidadDeGoles();

	}
};

ArrayList <Equipo> aux = new ArrayList<Equipo>(equipos.values());
aux.sort(compPuntos);

return aux;	
}
public playersController getPlayersController() {
	return playersController;
}
public void setPlayersController(playersController playersController) {
	this.playersController = playersController;
}
public String CantidadTotalDeGoles() {
	// TODO Auto-generated method stub
	int cantidadDeGoles =0;
	ArrayList<Equipo> a = new ArrayList<>(equipos.values());
	for (Equipo equipo : a) {
		cantidadDeGoles+=equipo.cantidadDeGoles();
	}
	return null;
}
public String generarTablaDePosiciones() {
	// TODO Auto-generated method stub
	String aDevolver ="";
//	"nombre del equipo\t puntos obtenidos												\t partidos ganados\t partidos empatados\t de partidos perdidos\t 									de goles a favor\t en contra\t diferencia de estos \n"
	ArrayList<Equipo> ganadores = new ArrayList<Equipo>(buscarGanadores());
	for (Equipo equipo : ganadores) {
		aDevolver+= equipo.getNombreFantacia() + '\t'+equipo.puntosDeEsteEquipo() + '\t'+equipo.calcularTipoDeResultado()[0]+ '\t'+equipo.calcularTipoDeResultado()[1]+ '\t'+equipo.calcularTipoDeResultado()[2]+ '\t'+equipo.cantidadDeGoles()+ '\t'+equipo.cantidadDeGolesEnContra()+'\t'+(-equipo.cantidadDeGoles()+equipo.cantidadDeGolesEnContra())+'\n';
	}
	return aDevolver;
}


}
