package main.model;

public class CUIL {
private int sexo;
private int DNI;
private int ultimoNumero;

public CUIL(int sexo,int DNI, int ultimoNumero) {
	// TODO Auto-generated constructor stub
	this.DNI=DNI;
	this.sexo=sexo;
	this.ultimoNumero=ultimoNumero;
}

public int getDNI() {
	return DNI;
}
public int getSexo() {
	return sexo;
}
public int getUltimoNumero() {
	return ultimoNumero;
}
}
