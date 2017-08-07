package javax.main.model;

import java.util.Calendar;

public class Resultado{
	private Calendar fechaDelPartido;
	private Equipo visitante;
	private int golesV;
	private int golesL;
	private boolean seJugo;
	

	public Resultado(Calendar fechaDelPartido, Equipo visitante, int golesV, int golesL, boolean seJugo) {
		this.fechaDelPartido = fechaDelPartido;
		this.visitante = visitante;
		this.golesV = golesV;
		this.golesL = golesL;
		this.seJugo = seJugo;
	}
	public Resultado(Calendar fechaDelPartido, Equipo visitante, int golesV, int golesL) {
		this.fechaDelPartido = fechaDelPartido;
		this.visitante = visitante;
		this.golesV = golesV;
		this.golesL = golesL;
	}
	public Resultado(Calendar fechaDelPartido, Equipo visitante) {
		this.fechaDelPartido = fechaDelPartido;
		this.visitante = visitante;
		seJugo=false;
	}
	public Resultado() {
		// TODO Auto-generated constructor stub
	}
	
	public Calendar getFechaDelPartido() {
		return fechaDelPartido;
	}

	public Equipo getVisitante() {
		return visitante;
	}

	public int getGolesV() {
		return golesV;
	}

	public int getGolesL() {
		return golesL;
	}


	public void setFechaDelPartido(Calendar fechaDelPartido) {
		this.fechaDelPartido = fechaDelPartido;
	}

	public void setVisitante(Equipo visitante) {
		this.visitante = visitante;
	}

	public void setGolesV(int golesV) {
		this.golesV = golesV;
	}

	public void setGolesL(int golesL) {
		this.golesL = golesL;
	}

	public boolean gane(){
		return golesL>golesV;
	}

	public boolean empate(){
		return golesL<golesV;
	}
	
	public boolean isSeJugo() {
		return seJugo;
	}
	public void setSeJugo(boolean seJugo) {
		this.seJugo = seJugo;
	}
	private String fechaToString(Calendar cal){
		return "" + (cal.get(Calendar.DATE)<10?("0"+cal.get(Calendar.DATE)):cal.get(Calendar.DATE))+ '/'+(cal.get(Calendar.MONTH)<10?("0"+cal.get(Calendar.MONTH)):cal.get(Calendar.MONTH))+'/'+ cal.get(Calendar.YEAR);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return fechaToString(fechaDelPartido)+'\t'+visitante.getNombreFantacia()+'\t';
	}
	public String ResultodoAEscribir(String equipoLocal){
	
		int cantidadCaracteres =45-visitante.getNombreFantacia().length();
		int cantidadCaracteres2 =45-equipoLocal.length();
		String visit= (cantidadCaracteres>0)?visitante.getNombreFantacia():visitante.getNombreFantacia().substring(0, 45);
		while (cantidadCaracteres>0) {
			visit+='*';
			cantidadCaracteres =45-visit.length();
			}
		
		String loca= (cantidadCaracteres2>0)?equipoLocal:equipoLocal.substring(0, 45);
		while (cantidadCaracteres2>0) {
			loca+='*';
			cantidadCaracteres2 =45-loca.length();
			}
		
		return fechaToString(getFechaDelPartido())+loca+visit+((golesL<10)?("0"+golesL):golesL)+((golesV<10)?("0"+golesV):golesV);
	}
	
}
