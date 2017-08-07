package main.model;

import java.util.ArrayList;
import java.util.Calendar;

public abstract class VentasDias {

	protected Calendar fecha;
	protected double totalVendid;
	protected ArrayList<PedidoMesa> pedidoMesa;
	protected ArrayList<MenuDetalle> menuDetalles;
	
	//angi request
	public VentasDias(Calendar fecha, double totalVendid, ArrayList<PedidoMesa> pedidoMesa) {
		this.fecha = fecha;
		this.totalVendid = totalVendid;
		this.pedidoMesa= pedidoMesa;
	}
	public VentasDias() {
	}
	
	public ArrayList<PedidoMesa> getPedidoMesa() {
		return pedidoMesa;
	}
	public void setPedidoMesa(ArrayList<PedidoMesa> pedidoMesa) {
		this.pedidoMesa = pedidoMesa;
	}
	public Calendar getFecha() {
		return fecha;
	}
	public double getTotalVendid() {
		return totalVendid;
	}
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	public void setTotalVendid(double totalVendid) {
		this.totalVendid = totalVendid;
	}
	public VentasDias(Calendar fecha) {
		this.fecha = fecha;
	}
	public abstract double calcularTotal(int ID);

	public void agregarUnPedidoAUnaMesa(int numeroMesa, int identificacion,int codigoPlato,int cantidad){
		for (MenuDetalle menuDetalle : menuDetalles) {
			if (menuDetalle.getCodigo()==codigoPlato) {
				pedidoMesa.add(new PedidoMesa(identificacion, numeroMesa, menuDetalle, cantidad));
			return;
			}
		}
		System.err.println("No se encontro ese codigo de plato");
	}
	public double calcularTotalDia() {
		// TODO Auto-generated method stub
		double pedidoPorDia=0;
		for (PedidoMesa pm : pedidoMesa) {
			pedidoPorDia+=pm.getPlato().getPrecio();
		}
		totalVendid=pedidoPorDia;
		return pedidoPorDia;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return fecha.get(Calendar.YEAR)+"/"+(fecha.get(Calendar.MONTH)+1)+"/"+fecha.get(Calendar.DATE)+" "+String.format("%.2f", totalVendid) ;
	}
	
}
