package main.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Corriente  extends Cuenta{
private double giroEnDescubierto;

public Corriente() {
	// TODO Auto-generated constructor stub
}

public Corriente(double giroEnDescubierto) {
	this.giroEnDescubierto = giroEnDescubierto;
}

public Corriente(int numeroDeCuenta, Titular titular, Calendar fechaApertura, double saldo, double giroEnDescubierto) {
	super(numeroDeCuenta, titular, fechaApertura, saldo);
	this.giroEnDescubierto = giroEnDescubierto;
}

public Corriente(Titular titular, Calendar fechaApertura, double saldo, double giroEnDescubierto) {
	super(titular, fechaApertura, saldo);
	this.giroEnDescubierto = giroEnDescubierto;
}

public double getGiroEnDescubierto() {
	return giroEnDescubierto;
}

public void setGiroEnDescubierto(double giroEnDescubierto) {
	this.giroEnDescubierto = giroEnDescubierto;
}

@Override
	public String toString() {
		// TODO Auto-generated method stub
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/YYYY");
		return ""+getNumeroDeCuenta()+";"+getTitular().getNombre()+";"+getTitular().getDocumento()+";"+simpleDateFormat.format(getFechaApertura().getTime())+";"+getGiroEnDescubierto()+";"+getSaldo();
	}
}
