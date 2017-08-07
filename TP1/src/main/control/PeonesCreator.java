package main.control;

import java.util.ArrayList;

import main.model.CUIL;
import main.model.Peon;

public class PeonesCreator {
	private ArrayList<Peon> peones;
	
	public PeonesCreator() {
		// TODO Auto-generated constructor stub
		peones=new ArrayList<Peon>();
	}
	
	public void crearPeon(String nombre, CUIL cUIL, double costoDiario){
		peones.add(new Peon(nombre, cUIL, costoDiario));

	}
	
	public Peon getPeon(int DNI) throws Exception {
		int devolver=-1;
		for (int i = 0; i < peones.size(); i++) {
			boolean p=(peones.get(i).esElPeon(DNI));
		devolver = p?i:-1;
		if (devolver>=0) {
			return peones.get(devolver);
		}			
		}
		throw new Exception("el peon solicitado no existe");
 	}
	
	public Peon usarPeon(int dni) {
		try {
			getPeon(dni).setEnUso(true);
			return getPeon(dni);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void dejarDeUsarPeon(int dni) {
		try {
			getPeon(dni).setEnUso(false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getPeonesLibres() {
		// TODO Auto-generated method stub
		String peonesSueltos="";
		for (Peon peon : peones) {
			if(!peon.getEnUso()){
				peonesSueltos= peonesSueltos+peon.toString() +'\n';
		
			}
		}
		return peonesSueltos;	
	}

	public ArrayList<Peon> getAllPeones() {
		return peones;
	}
	public void CrearLosPeonesParaPrueba() {
		// TODO Auto-generated method stub
		crearPeon("Pablo Perez", new CUIL(20, 32837475, 3), 100);
		crearPeon("Florencia Gomez", new CUIL(24, 34233245, 5), 120);
		crearPeon("Eduardo Gonzales", new CUIL(18, 12854556, 2), 80);
		crearPeon("Patricia Ramirez", new CUIL(20, 93434322, 4), 60);
		crearPeon("Pablo puaj", new CUIL(20, 92314211, 9), 100);
		
	}

	public ArrayList<Peon> getPeones() {
		return peones;
	}

	public void setPeones(ArrayList<Peon> peones) {
		this.peones = peones;
	}
	
}
