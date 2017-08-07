package main.model;

public final class Peon {
private String nombre;
private CUIL CUIL;
private double costoDiario;
private boolean enUso;

public Peon() {
	// TODO Auto-generated constructor stub
}

public Peon(String nombre, CUIL cUIL, double costoDiario) {
	this.nombre = nombre;
	this.CUIL = cUIL;
	this.costoDiario = costoDiario;
}

public String getNombre() {
	return nombre;
}

public CUIL getCUIL() {
	return CUIL;
}

public double getCostoDiario() {
	return costoDiario;
}

@Override
public String toString() {
	return "nombre=" + nombre + ", CUIL= " + CUIL.getSexo()+ " "+CUIL.getDNI()+" "+CUIL.getUltimoNumero() + ", costoDiario=" + costoDiario ;
}

public void setEnUso(boolean enUso) {
	this.enUso = enUso;
}
public boolean getEnUso(){
	return enUso;
}
public boolean  esElPeon(int dni) {
	int n=this.CUIL.getDNI();
	return (n==dni);
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public void setCUIL(CUIL cUIL) {
	CUIL = cUIL;
}

public void setCostoDiario(double costoDiario) {
	this.costoDiario = costoDiario;
}

}
