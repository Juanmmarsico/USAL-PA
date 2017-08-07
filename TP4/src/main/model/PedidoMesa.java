package main.model;
import main.model.MenuDetalle;
public class PedidoMesa {
	
	private int identificacion,numMesa;
	private MenuDetalle plato;
	private int cantidad;
	
	public PedidoMesa(){}
	
	public PedidoMesa(int identificacion, int numMesa, MenuDetalle plato,int cantidad) {
		this.identificacion=identificacion;
		this.numMesa=numMesa;
		this.plato=plato;
		this.cantidad=cantidad;
	}
	
	//------------------------------------

	public double getIdentificacion() {
		return identificacion;
	}

	public double getNumMesa() {
		return numMesa;
	}

	public MenuDetalle getPlato() {
		return plato;
	}

	//----------------------------------------------------
	
	public void setIdentificacion(int identificacion) {
		this.identificacion = identificacion;
	}

	public void setNumMesa(int numMesa) {
		this.numMesa = numMesa;
	}

	public void setPlato(MenuDetalle plato) {
		this.plato = plato;
	}	
	
	public String toString(int i) {
		return ""+identificacion+'\t'+numMesa+'\t'+plato.getCodigo()+'\t'+cantidad;
	}

}
