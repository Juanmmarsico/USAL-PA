package main.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DeAhorro extends Cuenta {
	private double interesesOtorgados;
	
	public DeAhorro() {
		// TODO Auto-generated constructor stub
	}

	public DeAhorro(int numeroDeCuenta, Titular titular, Calendar fechaApertura, double saldo,
			double interesesOtorgados) {
		super(numeroDeCuenta, titular, fechaApertura, saldo);
		this.interesesOtorgados = interesesOtorgados;
	}

	public DeAhorro(Titular titular, Calendar fechaApertura, double saldo, double interesesOtorgados) {
		super(titular, fechaApertura, saldo);
		this.interesesOtorgados = interesesOtorgados;
	}

	public double getInteresesOtorgados() {
		return interesesOtorgados;
	}

	public void setInteresesOtorgados(double interesesOtorgados) {
		this.interesesOtorgados = interesesOtorgados;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/YYYY");
		return ""+getNumeroDeCuenta()+";"+getTitular().getNombre()+";"+getTitular().getDocumento()+";"+simpleDateFormat.format(getFechaApertura().getTime())+";"+getInteresesOtorgados()+";"+getSaldo();
	}
}
