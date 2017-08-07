package javax.main.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Huesped extends Persona{

private ArrayList<Cupon> cupones;
private ArrayList<Huesped> huespedes;
private boolean isCliente=false;
private double totalConsumido=0;

public Huesped(String nombre, String apellido, long dNI, Calendar nacimiento,
		ArrayList<Huesped> huespedes,double totalConsumido, boolean isCliente) {
	super(nombre, apellido, dNI, nacimiento);
	this.huespedes = huespedes;
	this.isCliente = isCliente;
	cupones= new ArrayList<Cupon>();
	
}
public Huesped(String nombre, String apellido, long dNI, Calendar nacimiento, Calendar vencimiento,
		Long p) {
	super(nombre, apellido, dNI, nacimiento);
	this.cupones = new ArrayList<Cupon>();
	huespedes =new ArrayList<Huesped>();
	cupones.add(new Cupon(vencimiento,p));
}

public Huesped(String nombre, String apellido, long dNI, Calendar nacimiento) {
	super(nombre, apellido, dNI, nacimiento);
	huespedes = new ArrayList<Huesped>();
	cupones = new ArrayList<Cupon>();

}


public Huesped() {
	// TODO Auto-generated constructor stub
}
public ArrayList<Cupon> getPromociones() {
	return cupones;
}
public ArrayList<Huesped> getHuespedes() {
	return huespedes;
}
public boolean isCliente() {
	return isCliente;
}

public void setHuespedes(ArrayList<Huesped> huespedes) {
	this.huespedes = huespedes;
}
public void setCliente(boolean isCliente) {
	this.isCliente = isCliente;
}
public void setPromocion(Calendar inicio, double total){
	cupones.add(new Cupon(inicio, total));	
}
public boolean hasCupons(){
	if (!cupones.isEmpty()) {
		for (Cupon cupon : cupones) {
			if (!cupon.getVencimiento().before(Calendar.getInstance())) {
				cupones.remove(cupon);
			}
		}
	}
	return !cupones.isEmpty();
}

public void agregarHuesped(Huesped huesped){
	huespedes.add(huesped);
}

public String acompanantes(){
	String devolver= getNombre()+" "+getApellido()+" "+getEdad()+'\n';
	for (Huesped h : huespedes) {
		devolver+= h.getNombre()+" "+h.getApellido()+" "+h.getEdad()+'\n';
				}
	return devolver;
}
@Override
	public String toString() {
		// TODO Auto-generated method stub
	String c= "";
	for (Cupon cupon : cupones) {
		c += cupon.toString()+"+";
	}
		return nombre + ";"+apellido+";"+dNI+";"+nacimiento.get(Calendar.DATE)+"-"+nacimiento.get(Calendar.MONTH)+1+"-"+nacimiento.get(Calendar.YEAR)+";"+c;
	}
}
