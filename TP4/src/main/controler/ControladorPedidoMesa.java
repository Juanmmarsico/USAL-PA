package main.controler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import main.model.PedidoMesa;

public class ControladorPedidoMesa {
ControladorMenu controladorMenu;
ArrayList<PedidoMesa> pedidoMesas;

	public void escritorArchivos(int identificacion,int numMesa, int  codigo, int  cantidad){
	
		try {
			PedidoMesa pedidoMesa = new PedidoMesa(identificacion,numMesa,controladorMenu.buscarMenu(codigo),cantidad);

			FileWriter pedidos = new FileWriter(new File("./Files/Pedidos"),true);
			pedidos.write(pedidoMesa.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void nuevoPedido(int identificacion,int numMesa, int  codigo, int  cantidad){
		pedidoMesas.add(new PedidoMesa(identificacion, numMesa, controladorMenu.buscarMenu(codigo), cantidad));
	}
	public PedidoMesa buscarMesa(int numeroMesa){
		for (PedidoMesa pedidoMesa : pedidoMesas) {
			if (pedidoMesa.getNumMesa()==numeroMesa) {
				return pedidoMesa;
			}
		}
		throw new NullPointerException("no existe la mesa seleccionado");
	}
	private String generadorDePedidos(int numeroMesa) {
		String m="";	
		int codigo;
		String descripcion;
		double precio;
		
	
//		m +=  codigo +";"+ descripcion+";"+'\"'+String.format("%.2f", precio)+'\"'+'\n';

		
		return m;
		}
}
