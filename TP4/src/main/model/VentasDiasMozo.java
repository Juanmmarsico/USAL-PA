package main.model;

import java.util.Calendar;

public class VentasDiasMozo extends VentasDias{
	private int mozo; 
	private double total;
	
	public VentasDiasMozo(Calendar fecha, int mozo, double total) {
		super(fecha);
		this.mozo = mozo;
		this.total = total;
	}

	
	public VentasDiasMozo() {
		// TODO Auto-generated constructor stub
	}


	public int getMozo() {
		return mozo;
	}


	public double getTotal() {
		return total;
	}



	public void setMesa(int mozo) {
		this.mozo = mozo;
	}


	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public double calcularTotal(int identificacion) {
		// TODO Auto-generated method stub
		double pedidoPorDia=0;
		for (PedidoMesa pm : pedidoMesa) {
			if (identificacion==pm.getIdentificacion()) {
				pedidoPorDia+=pm.getPlato().getPrecio();
			}
		}
		total=pedidoPorDia;
		return pedidoPorDia;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "fecha, "+getFecha().get(Calendar.YEAR)+"/"+(getFecha().get(Calendar.MONTH)+1)+"/"+getFecha().get(Calendar.DATE) +" mozo "+mozo+" y total vendido por mesa " +String.format("%.2f", total);
	}


}
