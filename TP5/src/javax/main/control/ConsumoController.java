package javax.main.control;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.main.model.Reserva;
import javax.main.model.Consumo;
import javax.main.model.Producto;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsumoController {

	private ArrayList<Producto> productos;
	private ArrayList<Consumo> consumos;

	
	public ConsumoController() {
		// TODO Auto-generated constructor stub
		productos= new ArrayList<>();
		consumos= new ArrayList<>();


	}
	public ConsumoController(String productosTXTName) {
		// TODO Auto-generated constructor stub
		productos= new ArrayList<>();
		pasarTXTAMemoria(productosTXTName);
	}
	private void pasarTXTAMemoria(String productosTXT) {
		// TODO Auto-generated method stub
		
		Scanner productosTXTaux=null;
		try {	
			productosTXTaux= (new Scanner(new File(productosTXT)));
			while(productosTXTaux.hasNextLine()){	
				String line= productosTXTaux.nextLine();
				int codigo=Integer.parseInt(line.substring(0,8));
				String descripcion= leerAnchoFijo(line.substring(8,53));
				double precio=  Double.parseDouble(line.substring(53,61));
			        productos.add(new Producto(codigo, descripcion, precio));
			}
			} catch (IOException e) {
			// TODO: handle exception
			System.err.println(e.toString());
		}
	}
	
	public String leerAnchoFijo(String aux){
		for(int x=0;x<aux.length();x++){
			if(aux.charAt(x)=='$'){
				aux=aux.substring(0,x);
				break;
			}
		}
		return aux;
	}
	public void escribirConsumos(Reserva reserva) throws IOException{
		String numero = (reserva.getHabitacion().getNumero()<10?("00"):(reserva.getHabitacion().getNumero()<100?("0"):""))+reserva.getHabitacion().getNumero();
		FileWriter fileWriter = new FileWriter(new File("./Files/Consumos/cons"+(numero)+".txt"),true);
		fileWriter.write(reserva.consumoToString());
		fileWriter.close();
	}
	public void cerrarConsumos(Reserva reserva) throws IOException{
		String numero = (reserva.getHabitacion().getNumero()<10?("00"):(reserva.getHabitacion().getNumero()<100?("0"):""))+reserva.getHabitacion().getNumero();
		File fileWriter = new File("./Files/Consumos/cons"+(numero)+".txt");
		fileWriter.delete();
	}
public Producto productoPorNumero(int numero){
	for (Producto producto : productos) {
		if (producto.getCodigoDeProducto()==numero) {
		return producto;	
		}
	}
	return null;
}
public boolean verificarQueExistaElProducto(int prod) {
	// TODO Auto-generated method stub
	for (Producto producto : productos) {
		if(producto.getCodigoDeProducto()==prod)
			return true;
	}
	return false;
}
}
