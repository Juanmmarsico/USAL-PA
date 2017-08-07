package main.control;

import java.util.ArrayList;
import java.util.Calendar;

import main.model.Camion;

public class CamionesControler {
	private ArrayList<Camion> camiones;
	
	public CamionesControler() {
		// TODO Auto-generated constructor stub
		camiones= new ArrayList<Camion>();
	}
	
public void crearNuevoCamion(String patente, Calendar fechaPatentamiento, int cargaMaxima){
	Camion cam = (new Camion(patente.toUpperCase(),fechaPatentamiento,cargaMaxima));
	camiones.add(cam);
}


public boolean ValidatorPatentamiento(Calendar fechaPatentamiento){

	// TODO Auto-generated method stub
	if ((fechaPatentamiento.get(Calendar.YEAR))>=(((Calendar.getInstance()).get(Calendar.YEAR))-3)) {
		return true;
	}
	return false;
}

public boolean validarPatente(String patente) {
	// TODO Auto-generated method stub
	if (patente.matches("[a-z]{2,3}[ ]{0,1}[0-9]{3}[ ]{0,1}[a-z]{0,2}")) {
		return true;
	}else{
		return false;
}
}

public Camion getCamion(String patente) {
	// TODO Auto-generated method stub
	for(Camion cam:camiones){
		if(cam.getPatente().equals(patente.toUpperCase())){
			return cam;
		}
	}
	return null;
}
public boolean estaAsignadoElCamion(String patente) {
	if(varificarSiExisteElCamion(patente)){
		return true;
	}
	return false;
}

public boolean hayUnCamionConEsaPatente(String patente) {
		if(varificarSiExisteElCamion(patente)){
			return true;
		}
	return false;
}
private boolean varificarSiExisteElCamion(String patente) {
	for(Camion cam:camiones){
		if(cam.getPatente().equals(patente.toUpperCase())){
			return true;
		}
	}
	return false;
}


public String camionesDisponibles() throws Exception {	
		String camionesDisponibles="";
		for (Camion camion : camiones) {
			if (!camion.estaSiendoUsado()) {
				camionesDisponibles=camionesDisponibles+ "Patente: " + imprimirPatenteCamion(camion) + " Carga Maxima "+ camion.getCargaMaxima() + '\n';
			}
		}
		if (!(camionesDisponibles=="")) {
			return camionesDisponibles;
		}
		throw new NullPointerException("Usted no tiene camiones disponibles");
}


public ArrayList<Camion> getCamiones() {
	return camiones;
}

public void setCamiones(ArrayList<Camion> camiones) {
	this.camiones = camiones;
}

private String imprimirPatenteCamion(Camion camion) {	
	return camion.getPatente();
}

public ArrayList<String> camionesAsignadosArray(String[] args) {
	ArrayList<String> resultado= new ArrayList<>();
	for (String string : args) {
		   if (estaAsignadoElCamion(string) && hayUnCamionConEsaPatente(string)) {
resultado.add(string);
		   }
	}
	   return resultado;

}
}
