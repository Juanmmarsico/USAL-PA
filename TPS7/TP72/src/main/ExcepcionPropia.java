package main;

public class ExcepcionPropia extends Exception{
String err;
	public ExcepcionPropia() {
	// TODO Auto-generated constructor stub	
}
public ExcepcionPropia(int i) {
	// TODO Auto-generated constructor stub	
	err=((i==0)?("El numero "):((i==1)?("El camion "):("El Array que paso "))) +" no se encuentra en la clase ClaseRandom, Porfavor vuelva a verificar la informacion";
//	System.err.printf("% no se encuentra en la clase ClaseRandom, Porfavor vuelva a verificar la informacion",((i==0)?("El numero "):((i==1)?("El camion "):("El Array que paso "))));
}
public String getError(){
	return err;
}
}
