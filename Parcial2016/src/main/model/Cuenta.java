package main.model;

import java.util.ArrayList;
import java.util.Calendar;

public abstract class Cuenta {
	protected int numeroDeCuenta;
	protected Titular titular;
	protected Calendar fechaApertura;
	protected double saldo;
	protected ArrayList <Operacion> operaciones;

public Cuenta() {
	// TODO Auto-generated constructor stub
	operaciones= new ArrayList<Operacion>();
	
}

public Cuenta(int numeroDeCuenta, Titular titular, Calendar fechaApertura, double saldo) {
	this();
	this.numeroDeCuenta = numeroDeCuenta;
	this.titular = titular;
	this.fechaApertura = fechaApertura;
	this.saldo = saldo;
}



public Cuenta( Titular titular, Calendar fechaApertura, double saldo) {
	this();
	this.titular = titular;
	this.fechaApertura = fechaApertura;
	this.saldo = saldo;
}

public int getNumeroDeCuenta() {
	return numeroDeCuenta;
}

public Titular getTitular() {
	return titular;
}

public Calendar getFechaApertura() {
	return fechaApertura;
}

public double getSaldo() {
	return saldo;
}

public void setNumeroDeCuenta(int numeroDeCuenta) {
	this.numeroDeCuenta = numeroDeCuenta;
}

public void setTitular(Titular titular) {
	this.titular = titular;
}

public void setFechaApertura(Calendar fechaApertura) {
	this.fechaApertura = fechaApertura;
}

public void setSaldo(double saldo) {
	this.saldo = saldo;
}
public ArrayList<Operacion> getOperaciones() {
	return operaciones;
}
public void setOperaciones(Calendar fechaDeLaOperacion, int tipoDeOperacion, double importe) {
operaciones.add(new Operacion(fechaDeLaOperacion, tipoDeOperacion, importe));
}


}
