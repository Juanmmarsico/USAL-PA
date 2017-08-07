package main.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Operacion {
private Calendar fechaDeLaOperacion;
private int tipoDeOperacion;
private double importe;

public Operacion() {
	// TODO Auto-generated constructor stub
}

public Operacion(Calendar fechaDeLaOperacion, int tipoDeOperacion, double importe) {
	this.fechaDeLaOperacion = fechaDeLaOperacion;
	this.tipoDeOperacion = tipoDeOperacion;
	this.importe = importe;
}

public Calendar getFechaDeLaOperacion() {
	return fechaDeLaOperacion;
}

public int getTipoDeOperacion() {
	return tipoDeOperacion;
}

public double getImporte() {
	return importe;
}

public void setFechaDeLaOperacion(Calendar fechaDeLaOperacion) {
	this.fechaDeLaOperacion = fechaDeLaOperacion;
}

public void setTipoDeOperacion(int tipoDeOperacion) {
	this.tipoDeOperacion = tipoDeOperacion;
}

public void setImporte(double importe) {
	this.importe = importe;
}

@Override
public String toString() {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
	return "" + sdf.format(fechaDeLaOperacion.getTime()) + '\t' + tipoDeOperacion + '\t'+ importe ;
}



}
