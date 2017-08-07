package javax.main.model;

import java.util.Calendar;
import java.util.GregorianCalendar;


public abstract class Persona {
protected String nombre;
protected String apellido;
protected String segundoNombre;
protected long dNI;
protected Calendar nacimiento;
protected int edad;
private int sexo;
private int ultimoNumeroCuil;


public int getSexo() {
	return sexo;
}

public int getUltimoNumeroCuil() {
	return ultimoNumeroCuil;
}

public void setSexo(int sexo) {
	this.sexo = sexo;
}

public void setUltimoNumeroCuil(int ultimoNumeroCuil) {
	this.ultimoNumeroCuil = ultimoNumeroCuil;
}

public Persona(String nombre, String apellido, long dNI, int sexo, int ultimoNumeroCuil) {
	this.nombre = nombre;
	this.apellido = apellido;
	this.dNI = dNI;
	this.sexo = sexo;
	this.ultimoNumeroCuil = ultimoNumeroCuil;
}

public Persona(String nombre, String apellido, long dNI, Calendar nacimiento, int sexo, int ultimoNumeroCuil) {
	this.nombre = nombre;
	this.apellido = apellido;
	this.dNI = dNI;
	this.nacimiento = nacimiento;
	this.sexo = sexo;
	this.ultimoNumeroCuil = ultimoNumeroCuil;
}
public Persona(String nombre, String apellido, long dNI, int edad, int sexo, int ultimoNumeroCuil) {
	this.nombre = nombre;
	this.apellido = apellido;
	this.dNI = dNI;
	this.edad = edad;
	this.sexo = sexo;
	this.ultimoNumeroCuil = ultimoNumeroCuil;
}

public Persona() {
	// TODO Auto-generated constructor stub
}

public Persona(String nombre, String apellido) {
	this.nombre = nombre;
	this.apellido = apellido;
}

public Persona(String nombre, String apellido, long dNI) {
	this(nombre, apellido);
	this.dNI = dNI;
}

public Persona(String nombre, String apellido, int edad) {
	this(nombre, apellido);
	this.edad = edad;
}
public Persona(String nombre, String apellido, Calendar nacimiento) {
	this(nombre, apellido);
	this.nacimiento = nacimiento;
}

public Persona(String nombre, String apellido, String segundoNombre) {
	this(segundoNombre, apellido);
	this.segundoNombre=segundoNombre;
}

public Persona(String nombre, String apellido, String segundoNombre, long dNI) {
	this(nombre, apellido, segundoNombre);
	this.dNI = dNI;
}
public Persona(String nombre, String apellido, long dNI, int edad) {
	this(nombre, apellido, dNI);
	this.edad = edad;
}
public Persona(String nombre, String apellido, long dNI, Calendar nacimiento) {
	this(nombre, apellido, dNI);
	this.nacimiento = nacimiento;
}
public Persona(String nombre, String apellido, String segundoNombre, int edad) {
	this(nombre, apellido, segundoNombre);
	this.edad = edad;
}
public Persona(String nombre, String apellido, String segundoNombre, Calendar nacimiento) {
	this(nombre, apellido, segundoNombre);
	this.nacimiento = nacimiento;
}

public Persona(String nombre, String apellido, String segundoNombre, long dNI, Calendar nacimiento) {
	this(nombre, apellido, segundoNombre,dNI);
	this.nacimiento = nacimiento;
}
public Persona(String nombre, String apellido, String segundoNombre, long dNI, int edad) {
	this(nombre, apellido, segundoNombre,dNI);
	this.edad = edad;
}

public Persona(String nombre, String apellido, String segundoNombre, long dNI, Calendar nacimiento, int edad) {
	this.nombre = nombre;
	this.apellido = apellido;
	this.segundoNombre = segundoNombre;
	this.dNI = dNI;
	this.nacimiento = nacimiento;
	this.edad = edad;
}

public String getNombre() {
	return nombre;
}
public String getApellido() {
	return apellido;
}
public String getSegundoNombre() {
	return segundoNombre;
}
public long getdNI() {
	return dNI;
}
public Calendar getNacimiento() {
	return nacimiento;
}
public int getEdad() {
	return edad;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public void setSegundoNombre(String segundoNombre) {
	this.segundoNombre = segundoNombre;
}
public void setdNI(long dNI) {
	this.dNI = dNI;
}
public void setNacimiento(Calendar nacimiento) {
	this.nacimiento = nacimiento;
}
public void setEdad(int edad) {
	this.edad = edad;
}

protected  int calcularEdadPorCalendario(Calendar fecha){
	int age = (Calendar.getInstance().get(Calendar.YEAR) - fecha.get(Calendar.YEAR));
	Calendar now= Calendar.getInstance();
	if ((fecha.get(Calendar.MONTH) > now.get(Calendar.MONTH))
	        || (fecha.get(Calendar.MONTH) == now.get(Calendar.MONTH) && fecha.get(Calendar.DAY_OF_MONTH) > now
	            .get(Calendar.DAY_OF_MONTH))) {
	      age--;
	    }
	return age;
}
protected  Calendar calcularAnoNacimientoPorEdad(int fecha){
int year= Calendar.getInstance().get(Calendar.YEAR)-fecha;	
return new GregorianCalendar(year, 1, 1);
}

}
