package main.model;

import java.util.Calendar;

import javax.annotation.processing.RoundEnvironment;

public class VentasDiasMesa extends VentasDias{
	private Calendar fecha; 
	private PedidoMesa mesa; 
	private double total;
	
	public VentasDiasMesa(Calendar fecha, PedidoMesa mesa, double total) {
		super(fecha);
		this.mesa = mesa;
		this.total = total;
	}

	
	public VentasDiasMesa() {
		// TODO Auto-generated constructor stub
	}


	public Calendar getFecha() {
		return fecha;
	}


	public PedidoMesa getMesa() {
		return mesa;
	}


	public double getTotal() {
		return total;
	}


	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}


	public void setMesa(PedidoMesa mesa) {
		this.mesa = mesa;
	}


	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public double calcularTotal(int numeroMesa) {
		// TODO Auto-generated method stub
		double pedidoPorDia=0;
		for (PedidoMesa pm : pedidoMesa) {
			if (numeroMesa==pm.getNumMesa()) {
				pedidoPorDia+=pm.getPlato().getPrecio();
			}
		}
		total=pedidoPorDia;
		return pedidoPorDia;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "fecha, "+fecha.get(Calendar.YEAR)+"/"+(fecha.get(Calendar.MONTH)+1)+"/"+fecha.get(Calendar.DATE) +" mesa "+mesa.getNumMesa()+" y total vendido por mesa " +String.format("%.2f", total);
	}
}
