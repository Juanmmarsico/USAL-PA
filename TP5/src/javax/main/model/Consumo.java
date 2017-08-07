package javax.main.model;

import java.util.Calendar;

public class Consumo {
private Calendar fechaDeConsumo;
private Producto producto;
private int cantidad;
private double totalConsumo;

public Consumo() {
	// TODO Auto-generated constructor stub	
}

public Consumo(Calendar fechaDeConsumo, Producto producto, int cantidad,double totalConsumo) {
	this.fechaDeConsumo = fechaDeConsumo;
	this.producto = producto;
	this.cantidad = cantidad;
	this.totalConsumo=totalConsumo;
}
public Consumo(Calendar fechaDeConsumo, Producto producto, int cantidad) {
	this.fechaDeConsumo = fechaDeConsumo;
	this.producto = producto;
	this.cantidad = cantidad;
	totalConsumo = producto.getPrecio()*cantidad;
}
public Calendar getFechaDeConsumo() {
	return fechaDeConsumo;
}
public Producto getProducto() {
	return producto;
}
public int getCantidad() {
	return cantidad;
}
public void setFechaDeConsumo(Calendar fechaDeConsumo) {
	this.fechaDeConsumo = fechaDeConsumo;
}
public void setProducto(Producto producto) {
	this.producto = producto;
}
public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}

public double getTotalConsumo() {
	return totalConsumo;
}
public void calcularTotalConsumo() {
	this.totalConsumo = cantidad*producto.getPrecio();
}
public void setTotalConsumo(double totalConsumo) {
	this.totalConsumo = totalConsumo;
}

@Override
	public String toString() {
		// TODO Auto-generated method stub
	calcularTotalConsumo();
		return ""+fechaDeConsumo.get(Calendar.DATE)+"-"+fechaDeConsumo.get(Calendar.MONTH)+1+"-"+fechaDeConsumo.get(Calendar.YEAR)+'\t'+producto.getCodigoDeProducto()+'\t'+cantidad+'\t' +producto.getPrecio()+'\t'+totalConsumo+'\n';
	}
}
