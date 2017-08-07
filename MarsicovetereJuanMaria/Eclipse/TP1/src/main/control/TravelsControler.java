package main.control;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import main.model.Camion;
import main.model.Peaje;
import main.model.Peon;
import main.model.Viaje;
import main.model.ViajeCorto;
import main.model.ViajeLargo;

public class TravelsControler {
	int numeroViaje=0;
	ArrayList <Viaje> viajes;
	PeonesCreator peonesCreator;
	CamionesControler camionesControler;
	int [] noPagoEnEfectivo= new int[100];
	int noEfectivoNumero=0;
	double costoBasico;
	
	public TravelsControler(CamionesControler camionesControler, PeonesCreator peonesCreator) {
		// TODO Auto-generated constructor stub
		this.peonesCreator=peonesCreator;
		this.camionesControler=camionesControler;
		viajes= new ArrayList<Viaje>();
	}
	
public void crearViajeLargo(String patente, int distancia, double peso) throws Exception {
	if(camionesControler.getCamion(patente).getCargaMaxima()>peso){
	viajes.add(numeroViaje,new ViajeLargo(distancia, numeroViaje, camionesControler.getCamion(patente)));
	viajes.get(numeroViaje).setFechaDePartida(Calendar.getInstance());
	setBasicos(numeroViaje, peso);
	numeroViaje++;
	}else
	{
		throw new Exception("El camion " +patente+" no puede llevar ese peso");
	}
	
}
public void crearViajeCorto(String patente, int distancia, double peso) throws Exception {
	if(camionesControler.getCamion(patente).getCargaMaxima()>peso){
	viajes.add(numeroViaje, new ViajeCorto(distancia, numeroViaje, camionesControler.getCamion(patente)));		
	viajes.get(numeroViaje).setFechaDePartida(Calendar.getInstance());
	setBasicos(numeroViaje, peso);
	numeroViaje++;
	}else
	{
		throw new Exception("El camion " +patente+" no puede llevar ese peso");
	}
	
}
	private void setBasicos(int numeroViaje,double peso){
		viajes.get(numeroViaje).setCostoBasico(costoBasico);
		viajes.get(numeroViaje).setPeso(peso);
}
public Viaje devolverUnViaje(int viajeNumero) {
	return viajes.get(viajeNumero);
}
public void setCostoBasico(int numeroDeViaje, double costoBasico){
viajes.get(numeroDeViaje).setCostoBasico(costoBasico);
}
public void setPeso(int numeroDeViaje, double peso){
Viaje viaje =viajes.get(numeroDeViaje);
if (viaje.getCamion().getCargaMaxima()>=peso) {
	viaje.setPeso(peso);
}else System.err.println("El peso es mayor al que puede llevar el camion, por favor seleccione otro camion");
}
public void setCustodia(int numeroDeViaje, boolean custodia){
viajes.get(numeroDeViaje).setCustodia(custodia);
}
public void agregarPeajeAlViaje(int numeroDeViaje, int importe,String lugar){	
	viajes.get(numeroDeViaje).agregarPeaje(new Peaje(importe, lugar));
}
public void setFechaPartida(int numeroDeViaje, Calendar fechaDePartida){
viajes.get(numeroDeViaje).setFechaDePartida(fechaDePartida);
}
private double calcularPeajesYPeones(int nviaje,int dias){
	Viaje v=viajes.get(nviaje);
	double precioADevolver= 0;
	 for(int i = 0; i < v.peonesEnViaje().length;i++){
		 if (v.peonesEnViaje()[i]!=null) {
			 precioADevolver=precioADevolver+ ((v.peonesEnViaje()[i]).getCostoDiario()*dias);	 

		}
	 }
	 for(Peaje peaje:v.getPeajes()){
		precioADevolver=precioADevolver + peaje.getImporte();
	 }
	return precioADevolver;
}
private double calcularCosto(int numeroViaje,int dias) {
	double costoFinal = calcularPeajesYPeones(numeroViaje, dias)+((ViajeLargo)viajes.get(numeroViaje)).costoTotal();
	
	return costoFinal;
}
private double calcularCosto(int numeroViaje,boolean pagoEnEfectivo, int dias) {	
	Viaje v=viajes.get(numeroViaje);
	if (!pagoEnEfectivo) {
		noPagoEnEfectivo[noEfectivoNumero]=numeroViaje;
		noEfectivoNumero++;
	}
	double precioFinal=((ViajeCorto)v).costoTotal(pagoEnEfectivo)+calcularPeajesYPeones(numeroViaje, dias);	
	return precioFinal;
}
@SuppressWarnings("rawtypes")
public int getNumeroDeUnViajeActivop(String patenteAVerificar) {
	for (Iterator iterator = viajes.iterator(); iterator.hasNext();) {
		Viaje viaje = (Viaje) iterator.next();
		if (viaje.getCamionEnEsteViaje().equals(patenteAVerificar.toUpperCase())) {
			return viaje.getNumeroDeViaje();
		}
	}
	return 0;
}
@SuppressWarnings("rawtypes")
public String viajesEnCurso() {
	// TODO Auto-generated method stub
	try {
		String viajesNoFinalizados="";
		for (Iterator iterator = viajes.iterator(); iterator.hasNext();) {
			Viaje viaje = (Viaje) iterator.next();
			if (!viaje.getFinalizado()) {
				viajesNoFinalizados= viajesNoFinalizados + " Numero de viaje " + viaje.getNumeroDeViaje() + " Patente del Camion " + viaje.getCamionEnEsteViaje() + '\n';
			}	
		}
		return viajesNoFinalizados;

	} catch (Exception e) {
		// TODO: handle exception
		System.err.println("No hay viajes en Curso");
	}
	return null;
}
public boolean isShortTravel(int nviaje) {
	// TODO Auto-generated method stub
return (viajes.get(nviaje).getClass()==(ViajeCorto.class));
}
public String finalizarViaje(int nviaje, Calendar fin, boolean efectivo) {
	double costoDelViaje=0;
	viajes.get(nviaje).setFechaDeLlegada(fin);
	
	costoDelViaje = calcularCosto(nviaje,efectivo,fin.compareTo(viajes.get(nviaje).getFechaPartida()));
	return "El costo del viaje fue: " + costoDelViaje;
}
public String finalizarViaje(int nviaje, Calendar fin) {
	double costoDelViaje=0;
	viajes.get(nviaje).setFechaDeLlegada(fin);
	int days=(int) TimeUnit.MILLISECONDS.toDays(Math.abs((viajes.get(nviaje).getFechaDeLlegada().getTimeInMillis()-viajes.get(nviaje).getFechaDePartida().getTimeInMillis())));
	costoDelViaje = calcularCosto(nviaje,days);
	viajes.get(nviaje).removerTodosLosPeones();
	return "El costo del viaje fue: " + costoDelViaje;
}
public void asignarPeonAlViaje(int nViaje, int dni){
	viajes.get(nViaje).agregarPeonAlViaje(peonesCreator.usarPeon(dni));
}
public Camion getCamion(int nviaje){
	return viajes.get(nviaje).getCamion();
			
}
public void setCostoBasico(double costoBasico){
	this.costoBasico=costoBasico;
}
public double getCostoBasico() {
	return costoBasico;
}

public String peonesYPeajesMayoresANumeroRandom(int random) {
	String devolver="";
	int contador=0;
	for(Viaje v:viajes){
		if (v.getFinalizado()) {
			int cantidadPeonesYpeajes= v.cantidadDePeajesEnELViaje()+v.peonesEnElViaje();
			if (cantidadPeonesYpeajes > random ) {
				devolver = "N viaje "+ v.getNumeroDeViaje()+'\t' +"Fecha salida "+ v.getFechaPartida()+'\t' +"Patente: "+ v.getCamionEnEsteViaje()+'\t' +"Kilos Transportados "+ v.getPeso()+'\t' +"Costo total "+ v.getCosto() +'\n' ;
			contador++;
			}
		}
	}
	if (contador==0) {
		System.out.println("No hay viajes que cumplan el requisito");
	}
	return devolver;
}
public String pagadoConCheque() {
	String devolver="";
	double sumaDeLosCostosDeLosViajes=0;
	int cantidad=0;
	for (int i = 0; i < noPagoEnEfectivo.length; i++) {
		Viaje v=viajes.get(noPagoEnEfectivo[i]);
		if (v.getFinalizado() && (v.getFechaPartida().get(Calendar.YEAR)==Calendar.getInstance().get(Calendar.YEAR))) {
			if ((Calendar.getInstance().get(Calendar.MONTH)-6)<v.getFechaPartida().get(Calendar.MONTH)) {
				sumaDeLosCostosDeLosViajes=sumaDeLosCostosDeLosViajes+v.getCosto();
				cantidad++;
			}
		}
	}
	devolver= "El valor total de los viajes en efectivo es de \n" + sumaDeLosCostosDeLosViajes +'\n'+ "y fueron: " + cantidad + "Viajes";
	return devolver;
}


public String custodiaYPeso() {
	// TODO Auto-generated method stub
	ArrayList<Peon> peones = peonesCreator.getAllPeones();
	String devolver="";
	for (Peon p : peones) {
		for (Viaje v : viajes) {
			if (v.getCustodia() && (v.getPeso()>850) && (v.getFechaPartida().get(Calendar.YEAR)==Calendar.getInstance().get(Calendar.YEAR))) {
				devolver=devolver+p.getNombre()+'\n';
				devolver = devolver +"\t Viaje " + v.getNumeroDeViaje()+ "\n\t Fecha de Partida "+ v.getFechaPartida() + "\n\t Forma de pago "+ (verifyPagoEnEfectivo(v.getNumeroDeViaje())?"\n\t Efectivo ":"\n\t Cheque ")+'\n'+'\t'+ pasoPor(v.getNumeroDeViaje()) + "\n\t el valor cobrado fue "+ v.costoTotal();
			}
		}
		
	}
	if (devolver!="") {
		return devolver;
	}
	return "No hay peones que cumplan esos requisitos";
}

private String pasoPor(int nviaje) {
	// TODO Auto-generated method stub
	String devolver="";
	ArrayList<Peaje> peajes= viajes.get(nviaje).getPeajes();
	if (peajes.size()>0) {
		devolver=devolver + " Los lugares por donde paso son: ";
		for (Peaje peaje : peajes) {
			devolver= devolver + '\n'+'\t'+'\t'+peaje.getLugar()+ " El importe fue "+peaje.getImporte();
		}
	}
	return devolver;
}

private boolean verifyPagoEnEfectivo(int nviaje) {
	// TODO Auto-generated method stub
	for (int i = 0; i < noPagoEnEfectivo.length; i++) {
		if (noPagoEnEfectivo[i]== nviaje) {
			return true;
		}
	}
	return false;
}
public String peajesPorPrimerasLetras(String tresLetras) {
	String devolver="";
	for(Viaje v:viajes){
		ArrayList<Peaje> peajes= v.getPeajes();
		if (peajes.size()>0) {					
			boolean siHayPeaje=false;
			boolean yaEntro=false;
			for (Peaje peaje : peajes) {
				if(!yaEntro){
				String string=peaje.getLugar().substring(0, 3).toUpperCase();
				if (string.contains(tresLetras.toUpperCase())) {				
					siHayPeaje=true;
					yaEntro=true;
					}
				}
			}
			if (siHayPeaje && v.getFinalizado()) {
				devolver= devolver +"El numero de viaje fue: "+v.getNumeroDeViaje()+pasoPor(v.getNumeroDeViaje());		
				String [] p=new String[100];
				for(int i=0;i < v.peonesEnViaje().length;i++){
				if (v.peonesEnViaje()==null) {
					int days=(int) TimeUnit.MILLISECONDS.toDays(Math.abs((v.getFechaDeLlegada().getTimeInMillis()-v.getFechaDePartida().getTimeInMillis())));
					p[i] = '\n'+ (v.peonesEnViaje()[i]).getNombre()+ " " +((v.peonesEnViaje()[i]).getCostoDiario()*days);				
				}				
				}
				for (int i = 0; i < v.peonesEnViaje().length; i++) {
					devolver=devolver + p[i];
					}
				}		
				if (devolver!="") {
					return devolver;
				}
				return "No hay peones que cumplan esos requisitos";
			}	
	
	}
	return devolver;
}
public int cantidadDeViajesCortos() {
	int counter=0;
	for(Viaje v:viajes){
	if(v.getClass()==(ViajeCorto.class)){
		counter++;
	}	
	}
	return counter;
}

}
