package main.model;

public class CUIL {
private int sexo;
private int DNI;
private int ultimoNumero;

public CUIL() {
	// TODO Auto-generated constructor stub
}
public CUIL(int sexo,int DNI, int ultimoNumero) {
	// TODO Auto-generated constructor stub
	this.DNI=DNI;
	this.sexo=sexo;
	this.ultimoNumero=ultimoNumero;
}
public void setSexo(int sexo) {
	this.sexo = sexo;
}
public void setDNI(int dNI) {
	DNI = dNI;
}
public void setUltimoNumero(int ultimoNumero) {
	this.ultimoNumero = ultimoNumero;
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
