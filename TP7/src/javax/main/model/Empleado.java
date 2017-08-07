package javax.main.model;

import java.util.Calendar;

public class Empleado extends Persona{
private String empresa;
private boolean estaEnUnEquipo;

public Empleado(String nombre, String apellido, long dNI, int sexo, int ultimoNumeroCuil, String empresa) {
	super(nombre, apellido, dNI, sexo, ultimoNumeroCuil);
	this.empresa = empresa;
}

public Empleado(String nombre, String apellido, long dNI, int sexo, int ultimoNumeroCuil) {
	super(nombre, apellido, dNI, sexo, ultimoNumeroCuil);
}
public Empleado(String nombre, String apellido, long dNI, Calendar nacimiento, int sexo, int ultimoNumeroCuil) {
	// TODO Auto-generated constructor stub
	super(nombre, apellido, dNI,nacimiento,sexo,ultimoNumeroCuil);
}
public Empleado(String nombre, String apellido, long dNI, int sexo, int ultimoNumeroCuil, String empresa,boolean EstaEnUnEquipo) {
	super(nombre, apellido, dNI, sexo, ultimoNumeroCuil);
	this.empresa = empresa;
	estaEnUnEquipo=false;

}

public Empleado(String nombre, String apellido, long dNI, int sexo, int ultimoNumeroCuil,boolean EstaEnUnEquipo) {
	super(nombre, apellido, dNI, sexo, ultimoNumeroCuil);
	estaEnUnEquipo=false;
}
public Empleado(String nombre, String apellido, long dNI, Calendar nacimiento, int sexo, int ultimoNumeroCuil,boolean EstaEnUnEquipo) {
	// TODO Auto-generated constructor stub
	super(nombre, apellido, dNI,nacimiento,sexo,ultimoNumeroCuil);
	estaEnUnEquipo=false;
}

public String getEmpresa() {
	return empresa;
}

public void setEmpresa(String empresa) {
	this.empresa = empresa;
}
public void setEstaEnUnEquipo(boolean estaEnUnEquipo) {
	this.estaEnUnEquipo = estaEnUnEquipo;
}
public boolean getEstaEnUnEquipo() {
	// TODO Auto-generated method stub
return estaEnUnEquipo;
}

@Override
public String toString() {
	return "Jugador empresa= " + empresa + ", nombre= " + nombre + ", apellido= " + apellido + 
			 ", CUIL= " + getSexo() + "-" + dNI +"-" + getUltimoNumeroCuil() + "\n";
}

public String toStringParaEquipo() {
	String dni="";
	String aux=""+dNI;
	for(int i=aux.length();i<8;i++){
		dni+="0";
	}
	dni+=""+dNI;
	return ""+((getSexo()<10?("0"+getSexo()):getSexo())+"" + (dni)+""  + getUltimoNumeroCuil())+";"+ nombre + ";"+apellido  + "\n";
}
}
