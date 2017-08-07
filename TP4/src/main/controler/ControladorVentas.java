package main.controler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import main.model.VentasDiasMesa;
import main.model.VentasDiasMozo;

public class ControladorVentas {
private ControladorMenu controladorMenu;
private	ControladorPedidoMesa controladorPedidoMesa;
private ArrayList<VentasDiasMesa> vMesas;
private ArrayList<VentasDiasMozo> vMozo;
	public ControladorVentas() {
		// TODO Auto-generated constructor stub
	controladorMenu = new ControladorMenu();
	controladorPedidoMesa = new ControladorPedidoMesa();
	vMesas= new ArrayList<>();
	vMozo=new ArrayList<>();
	}
	public void escritorArchivos(int mozo,int numMesa, int  codigo, int  cantidad){
		
			try {
				VentasDiasMesa mesa = new VentasDiasMesa();
				FileWriter mesas = new FileWriter(new File("./Files/Mesa"),true);
					mesas.write(mesa.toString());	
				VentasDiasMozo moz = new VentasDiasMozo();
				FileWriter mozos = new FileWriter(new File("./Files/mozo"),true);
					mozos.write(moz.toString());	
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (NullPointerException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
	
	public void crearNuevoPedido(int identificacion,int numMesa, int  codigo, int  cantidad,Calendar fecha) {
		boolean entro=false;
		for (VentasDiasMesa ventasDiasMesa : vMesas) {
			if (ventasDiasMesa.getMesa().getNumMesa()==numMesa) {
				ventasDiasMesa.agregarUnPedidoAUnaMesa(numMesa, identificacion, codigo, cantidad);
				entro=true;
			}
		}
		
		try {
			if (!entro) {
				vMesas.add(new VentasDiasMesa(fecha,controladorPedidoMesa.buscarMesa(numMesa),(controladorMenu.buscarMenu(codigo).getPrecio()*cantidad)));
			}
			controladorPedidoMesa.nuevoPedido(identificacion, numMesa, codigo, cantidad);
			controladorPedidoMesa.escritorArchivos(identificacion, numMesa, codigo, cantidad);
		} catch (NullPointerException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		entro=false;
		for (VentasDiasMozo ventasDiasMozo : vMozo) {
			if (ventasDiasMozo.getMozo()==identificacion) {
				ventasDiasMozo.agregarUnPedidoAUnaMesa(numMesa, identificacion, codigo, cantidad);
				entro=true;
			}
		}
		
		try {
			if (!entro) {
				vMesas.add(new VentasDiasMesa(fecha,controladorPedidoMesa.buscarMesa(numMesa),(controladorMenu.buscarMenu(codigo).getPrecio()*cantidad)));
			}
			controladorPedidoMesa.nuevoPedido(identificacion, numMesa, codigo, cantidad);
			controladorPedidoMesa.escritorArchivos(identificacion, numMesa, codigo, cantidad);
		} catch (NullPointerException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	
	public ControladorMenu getControladorMenu() {
		return controladorMenu;
	}
	
	private String generadorDeVentasMozo(int mozo) {
		String m="";	
		int codigo;
		String descripcion;
		double precio;
		
		
//		m +=  codigo +";"+ descripcion+";"+'\"'+String.format("%.2f", precio)+'\"'+'\n';
		return m;
		}
}
