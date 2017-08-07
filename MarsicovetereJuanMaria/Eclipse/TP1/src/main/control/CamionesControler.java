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
	Camion cam = verifyValidCamion(patente,fechaPatentamiento)?(new Camion(patente.toUpperCase(),fechaPatentamiento,cargaMaxima)):null;
	camiones.add(cam);
}

private boolean verifyValidCamion(String patente, Calendar fechaPatentamiento) {
	// TODO Auto-generated method stub
 try {
	return validarPatente(patente) &&  ValidatorPatentamiento(fechaPatentamiento);
	
} catch (Exception e) {
	// TODO: handle exception
	System.err.println(e.getMessage());
	
}
	return false;
}

private boolean ValidatorPatentamiento(Calendar fechaPatentamiento) throws Exception {

	// TODO Auto-generated method stub
	if ((fechaPatentamiento.get(Calendar.YEAR))>=(((Calendar.getInstance()).get(Calendar.YEAR))-3)) {
		return true;
	}else{
		throw new Exception("Fecha de patentamiento invalida");
	}
}

private boolean validarPatente(String patente) throws Exception {
	// TODO Auto-generated method stub
	if (patente.matches("[a-z]{2,3}[ ]{0,1}[0-9]{3}[ ]{0,1}[a-z]{0,2}")) {
		return true;
	}else{
	throw new Exception("Patente invalida");
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


private String imprimirPatenteCamion(Camion camion) {	
	return camion.getPatente();
}
}
