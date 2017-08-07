package javax.main.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class Torneo implements Premios{
private HashMap<String,Equipo> equipos;
private Calendar year;
private double costoDelTorneo;

public Torneo(Calendar year, double costoDelTorneo) {
	this.year = year;
	this.costoDelTorneo = costoDelTorneo;
	equipos = new HashMap<>();
}

public Torneo() {
}

public HashMap<String, Equipo> getEquipos() {
	return equipos;
}

public Calendar getYear() {
	return year;
}

public double getCostoDelTorneo() {
	return costoDelTorneo;
}


public void setYear(Calendar year) {
	this.year = year;
}

public void setCostoDelTorneo(double costoDelTorneo) {
	this.costoDelTorneo = costoDelTorneo;
}
public void setEquipos(HashMap<String, Equipo> equipos) {
	this.equipos = equipos;
}
//Como los jugadores son empleados pueden existir si no hay equipos
public void setEquipo(String nombreFantacia,HashMap<Long,Empleado> jugadores) {
	equipos.put(nombreFantacia, new Equipo(nombreFantacia,jugadores));
}

public ArrayList<String> PartidosPendientesParaJugar() {
	// TODO Auto-generated method stub
	ArrayList <Equipo> aux = new ArrayList<Equipo>(equipos.values());
	ArrayList<String> pasados = new ArrayList<String>();
	ArrayList<String> devolver = new ArrayList<>();
	for (Equipo equipo : aux) {
		if (!pasados.isEmpty()) {
			if ((pasados.size()+2)==aux.size()) {
				return devolver;
			}
				devolver.add((equipo.partidosQueLeFaltaJugar(pasados).toString()));
				pasados.add(equipo.getNombreFantacia());
			
		}else{
			pasados.add(equipo.getNombreFantacia());
		}
	}
	
	return devolver;
}

public double[] pagar() {
	// TODO Auto-generated method stub
	double total= costoDelTorneo*equipos.size();
	double totalEmpresa = total*empresa;
	double totalprimero = total*primero;
	double totalSegundo = total*segundo;

	double [] devolver = {totalEmpresa,totalprimero,totalSegundo};
	
	return devolver;
}

}
