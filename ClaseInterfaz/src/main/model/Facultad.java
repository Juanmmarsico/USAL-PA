package main.model;

import java.util.ArrayList;

public class Facultad {
private String nombre;
private ArrayList<Carrera> carreras;

public Facultad() {
	// TODO Auto-generated constructor stub
	this.carreras = new ArrayList<Carrera>();

}
public Facultad(String nombre, ArrayList<Carrera> carreras){
	this.carreras = carreras;
	this.nombre= nombre;			
}
public Facultad(String nombre){
	this.carreras = new ArrayList<Carrera>();
	this.nombre= nombre;			
}
public String getNombre() {
	return nombre;
}
public ArrayList<Carrera> getCarreras() {
	return carreras;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public void setCarreras(ArrayList<Carrera> carreras) {
	this.carreras = carreras;
}


}
