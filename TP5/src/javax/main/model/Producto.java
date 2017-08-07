package javax.main.model;


public class Producto {
private int codigoDeProducto;
private String descripcion;
private double precio;


public Producto() {
	// TODO Auto-generated constructor stub
}

public Producto(int codigoDeProducto, String descripcion, double precio) {
	this.codigoDeProducto = codigoDeProducto;
	this.descripcion = descripcion;
	this.precio = precio;
}

public int getCodigoDeProducto() {
	return codigoDeProducto;
}

public String getDescripcion() {
	return descripcion;
}

public double getPrecio() {
	return precio;
}

public void setCodigoDeProducto(int codigoDeProducto) {
	this.codigoDeProducto = codigoDeProducto;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

public void setPrecio(double precio) {
	this.precio = precio;
}

@Override
	public String toString() {
		// TODO Auto-generated method stub
		return codigoDeProducto+" " + descripcion+ " "+precio;
	}


}
