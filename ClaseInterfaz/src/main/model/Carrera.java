package main.model;


public class Carrera {
	private String nombre;
	private String perteneceAFacultad;
	
	public Carrera() {
		// TODO Auto-generated constructor stub
	}
	
	public Carrera(String nombre, String perteneceAFacultad){
		this.nombre= nombre;
		this.perteneceAFacultad = perteneceAFacultad;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

}
