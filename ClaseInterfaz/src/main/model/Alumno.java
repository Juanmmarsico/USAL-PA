package main.model;

public class Alumno extends Persona{
	
public Alumno() {
	// TODO Auto-generated constructor stub
}
public Alumno(String nombre, String Apellido, int dni) {
	// TODO Auto-generated constructor stub
	super(nombre, Apellido, dni);
}

@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nombre + ";" +apellido+";"+dNI ;
		
		
	}
}
