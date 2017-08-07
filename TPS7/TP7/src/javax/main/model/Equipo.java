package javax.main.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.StringTokenizer;

import org.omg.PortableInterceptor.ServerRequestInfo;

public class Equipo {
private String nombreFantacia;
private HashMap<Long,Empleado> jugadores;
private ArrayList<Resultado> jugoContra;

public Equipo() {
	// TODO Auto-generated constructor stub
this.jugadores= new HashMap<>();
this.jugoContra= new ArrayList<>();
}

public Equipo(String nombreFantacia, HashMap<Long, Empleado> jugadores) {
	this();
	this.nombreFantacia = nombreFantacia;
	this.jugadores = jugadores;
}

public String getNombreFantacia() {
	return nombreFantacia;
}

public HashMap<Long, Empleado> getJugadores() {
	return jugadores;
}

public ArrayList<Resultado> getJugoContra() {
	return jugoContra;
}

public void setNombreFantacia(String nombreFantacia) {
	this.nombreFantacia = nombreFantacia;
}

public void setJugadores(HashMap<Long, Empleado> jugadores) {
	this.jugadores = jugadores;
}

public void agregarJugoContraUnEquipo(Calendar fechaDelPartido,Equipo visitante) {
	jugoContra.add(new Resultado(fechaDelPartido, visitante));
}
public void jugoElPartidoContra(String visitante, int golesVisitante,int golesLocal) {
	for (Resultado resultado : jugoContra) {
		if (resultado.getVisitante().getNombreFantacia().equals(visitante)) {
			resultado.setGolesL(golesLocal);
			resultado.setGolesV(golesVisitante);
			resultado.setSeJugo(true);
			return;
		}
	}
}

public void agregarJugadorAlEquipo(Empleado jugador){
	jugadores.put(jugador.getdNI(), jugador);
}

public int puntosDeEsteEquipo() {
	int sum=0;
	for (Resultado resultado : jugoContra) {
		if (resultado.gane()) {
			sum+=3;
		}else{
			if (resultado.empate()) {
				sum+=1;
			}	
		}
	}
	return sum;
}
public int cantidadDeGoles(){
	int sum=0;
	for (Resultado resultado : jugoContra) {
		sum+=resultado.getGolesL();
	}
	return sum;
}
public String devolverUnResultado(String equipo){
	return buscarEnResultados(equipo).toString()+'\t'+nombreFantacia;
}
private Resultado buscarEnResultados(String equipo) {
	// TODO Auto-generated method stub
	for (Resultado resultado : jugoContra) {
		String string=resultado.getVisitante().getNombreFantacia();
		if (string.equals(equipo)) {
			return resultado;		
		}
	}
	return null;
}

public String devolverUnResultadoParaTXT(String equipo){
	
	return buscarEnResultados(equipo).ResultodoAEscribir(getNombreFantacia());
}

//public ArrayList<Resultado> partidosQueLeFaltaJugar(ArrayList<String> equipo) {
//	// TODO Auto-generated method stub
//	ArrayList<Resultado> arrayList = new ArrayList<Resultado>(jugoContra);
//	ArrayList<Resultado> aux = new ArrayList<Resultado>(arrayList);
//
//	for (Resultado resultado : arrayList) {
//		if (resultado.getVisitante().getNombreFantacia().equals(equipo)) {
//			aux.remove(resultado);
//		}
//	}
//	return partidosQueLeFaltaJugar(aux);
//}
public ArrayList<Resultado> partidosQueLeFaltaJugar(ArrayList<String> arrayList) {
	// TODO Auto-generated method stub
ArrayList<Resultado> devolver = new ArrayList<Resultado>();
ArrayList<Resultado> aux = new ArrayList<Resultado>(jugoContra);
	for (String r : arrayList) {
		aux.remove(buscarEnResultados(r));
	}
	for (Resultado resultado : aux) {
		if (!resultado.isSeJugo()) {
			devolver.add(resultado);
		}
	}
	return devolver;
}
public ArrayList<Resultado> partidosQueLeFaltaJugar() {
	// TODO Auto-generated method stub
ArrayList<Resultado> devolver = new ArrayList<Resultado>(jugoContra);
	for (Resultado resultado : jugoContra) {
		if (resultado.isSeJugo()) {
			devolver.remove(resultado);
		}
	}
	return devolver;
}
public Resultado partidoDeHoy(Calendar dia){
	if(tienePartidoHoy(dia)>0){
	for (Resultado resultado : jugoContra) {
		Calendar x = resultado.getFechaDelPartido();
//		Calendar aux1= new GregorianCalendar(x.get(Calendar.YEAR),x.get(Calendar.MONTH),x.get(Calendar.DATE));
//		Calendar aux2 = new GregorianCalendar(dia.get(Calendar.YEAR),dia.get(Calendar.MONTH),dia.get(Calendar.DATE));
		if (x.get(x.YEAR)==dia.get(x.YEAR)) {
			if (x.get(x.MONTH)==dia.get(x.MONTH)) {
				if (x.get(x.DATE)==dia.get(x.DATE)) {
					return resultado;
				}
			}
		}
		
	}
	}
	return null;
	} 
public int tienePartidoHoy(Calendar dia) {
	// TODO Auto-generated method stub
	int posicion=0;
	for (Resultado resultado : jugoContra) {
		Calendar x = resultado.getFechaDelPartido();
		if (x.get(x.YEAR)==dia.get(x.YEAR)) {
			if (x.get(x.MONTH)==dia.get(x.MONTH)) {
				if (x.get(x.DATE)==dia.get(x.DATE)) {
					return posicion;
				}
			}
		}
		posicion++;
	}
	return -1;
}
public int[] calcularTipoDeResultado(){
	int gano=0;
	int perdio =0;
	int empato=0;
	for (Resultado resultado : jugoContra) {
		if (resultado.gane()) {
			gano++;
		}else{
			if(resultado.empate()){
				empato++;
			}else{
				perdio++;
			}
		}
	}
	int [] devolver={gano,empato,perdio};
	return devolver;
}

public int cantidadDeGolesEnContra() {
	// TODO Auto-generated method stub
	int sum=0;
	for (Resultado resultado : jugoContra) {
		sum+=resultado.getGolesV();
	}
	return sum;
}
}
