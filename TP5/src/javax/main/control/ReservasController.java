package javax.main.control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.main.model.Habitacion;
import javax.main.model.Huesped;
import javax.main.model.Precio;
import javax.main.model.Producto;
import javax.main.model.Reserva;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;


public class ReservasController {
	private ArrayList<Reserva> reservas;
	private HuespedController huespedes;
	private ArrayList<Precio> precios;
	private ConsumoController consumos;
	private ArrayList<Habitacion> habitaciones;
	int numeroDeReserva=0;
	
	public void cuponGenerator(double importeRandom,int mes){
		for (Reserva reserva : reservas) {
			double totalParaCupon ;
			if (reserva.consumosTotalPrice()> importeRandom) {
				if (reserva.getCheckIn().get(Calendar.MONTH) == mes||
					reserva.getCheckOut().get(Calendar.MONTH) == mes) {
					totalParaCupon= (reserva.getPrecioTotal());
					reserva.getHuesped().setPromocion(Calendar.getInstance(), totalParaCupon);	
				}
			}
		}	
	}
	public ReservasController(String habitacionesTXT, String preciosTXT) {
		// TODO Auto-generated constructor stub
		 reservas= new ArrayList<>();
//		huespedes= new HuespedController();
		 precios= new ArrayList<>();
//		 consumos = new ConsumoController();
	 habitaciones = new ArrayList<>();
	pasarAMemoria(habitacionesTXT, preciosTXT);
	
	}
	
	
	public ReservasController(HuespedController huespedes, ConsumoController consumos,String habita,String pre) {
		this(habita,pre);
		this.huespedes = huespedes;
		this.consumos = consumos;
	}
	public void pasarAMemoria(String habitacionesTXT, String preciosTXT) {
		try {
			Scanner p = new Scanner(new File(preciosTXT));
			Scanner h = new Scanner(new File(habitacionesTXT));
			pasarTXTSAMemoria(h, p);
 		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.err.println(e.toString());
		}
	}
	
	private void pasarTXTSAMemoria(Scanner habitacionesTXT,Scanner preciosTXT) {
		// TODO Auto-generated method stub
		Scanner preciosTXTaux=(preciosTXT.useDelimiter("[\\n,;]+"));
		Scanner habitacionTXTaux= (habitacionesTXT.useDelimiter("[\\n,;]+"));
			while(preciosTXTaux.hasNext()){
				int capacidad=preciosTXTaux.nextInt();
				String aux=preciosTXTaux.next();
				String categoria=aux;
				String pr=preciosTXTaux.next().replace("\"", "");
				double p= Double.parseDouble(pr);
			        precios.add(new Precio(capacidad, categoria, p));
			        }
			while(habitacionTXTaux.hasNext()){
				int nh = habitacionTXTaux.nextInt();
				int cant = habitacionTXTaux.nextInt();
				boolean bal=habitacionTXTaux.nextBoolean();
				String des=habitacionTXTaux.next();
				String cat=habitacionTXTaux.next();		
				
			       habitaciones.add(new Habitacion(nh , bal, des,relacionarHabitacionConPrecios(cant, cat)));
			}
	}

	private Precio relacionarHabitacionConPrecios(int cantidad, String categoria) {
		// TODO Auto-generated method stub
			for (Precio precio : precios) {
				if(categoria.equals(precio.getCategoria()) && cantidad==(precio.getCapacidad())){
					return precio;
				}
			}
		
		return new Precio(cantidad,categoria,0);
	}

	public HashMap<Integer, Habitacion> relacionarHabitacion(String categoria, int cantidad, boolean balcon){
		HashMap<Integer,Habitacion> puedeOcupar= new HashMap<Integer, Habitacion>();
		for (Habitacion habitacion : habitaciones) {
			if (habitacion.getPrecio().getCategoria().equalsIgnoreCase(categoria) && habitacion.getPrecio().getCapacidad()==cantidad && habitacion.isBalcon()==balcon && !habitacion.isOcupada()) {
				puedeOcupar.put(habitacion.getNumero(), habitacion);
			}
		}
		return puedeOcupar;
	}
	public HashMap<Integer, Habitacion> relacionarHabitacionSuplente(String categoria, int cantidad, boolean balcon){
		HashMap<Integer,Habitacion> puedeOcupar= new HashMap<Integer, Habitacion>();
		for (Habitacion habitacion : habitaciones) {
			if (habitacion.getPrecio().getCategoria().equalsIgnoreCase(categoria) && habitacion.getPrecio().getCapacidad()>=cantidad && !habitacion.isOcupada()) {
				puedeOcupar.put(habitacion.getNumero(), habitacion);
			}
		}
		return puedeOcupar;
	}
	public boolean agregarConsumoAHabitacion(int numeroDeHabitacion, int cantidad,int codigoProducto){
	Producto producto= consumos.productoPorNumero(codigoProducto);
	try {
		getReservaWithRoomNumber(numeroDeHabitacion).setConsumo(cantidad, producto);
		consumos.escribirConsumos(getReservaWithRoomNumber(numeroDeHabitacion));
return true;
	} catch (NullPointerException e) {
		// TODO: handle exception
		System.err.println(e.getMessage());
		return false;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	}
	private Reserva getReservaWithRoomNumber(int numeroHabitacion){
		for (Reserva reserva : reservas) {
			if (reserva.getHabitacion().getNumero()==numeroHabitacion) {
				return reserva;
			}
			}
		throw new NullPointerException("La habitacion no existe");
	}
	public String imprimirConsumoDeHabitacion(int numeroHabitacion){
		String aDevolver =(getReservaWithRoomNumber(numeroHabitacion)).consumoToString();
		aDevolver+="Nombre \t apellido \t edad \n";
		aDevolver+=getReservaWithRoomNumber(numeroHabitacion).getHuesped().acompanantes();
		return aDevolver;
	}
	public Calendar finalizarReserva(int numeroHabitacion){
		Calendar devolver = Calendar.getInstance();
		try {
			
			System.out.println(getReservaWithRoomNumber(numeroHabitacion).calcularCostoTotalAlCheckOut());
			devolver = getReservaWithRoomNumber(numeroHabitacion).getCheckOut();
			getReservaWithRoomNumber(numeroHabitacion).clienteDejaHabitacion();
			consumos.cerrarConsumos(getReservaWithRoomNumber(numeroHabitacion));
			return devolver;
		} catch (NullPointerException e) {
			// TODO: handle exception
			return devolver;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}	
		return devolver;

	}
	public void generarReservaNueva(int numeroDeHabitacio,Calendar checkOut,int cantidad, Huesped huesped){
		numeroDeReserva++;
		huesped.setCliente(true);
		reservas.add(new Reserva(numeroDeReserva, habitaciones.get(numeroDeHabitacio), huesped, Calendar.getInstance(), cantidad,checkOut));	
		habitaciones.get(numeroDeHabitacio).setOcupada(true);
		System.out.println();
	}
	public String habitacionesToString() {
		// TODO Auto-generated method stub
		String todasLasHabitaciones= "Numero" + '\t' + "Comentario" + '\t' +"Balcon"+ '\t' +"capacidad"+ '\t' + "categoria" + '\t' +"precio" +'\n';
		for (Habitacion habitacion : habitaciones) {
			todasLasHabitaciones+=habitacion.toString();
		}
		return todasLasHabitaciones;
	}
	public String habitacionesLibresToString() {
		// TODO Auto-generated method stub
		String todasLasHabitaciones= "Numero" + '\t' + "Comentario" + '\t' +"Balcon"+ '\t' +"capacidad"+ '\t' + "categoria" + '\t' +"precio" +'\n';
		for (Habitacion habitacion : habitaciones) {
			if (habitacion.isOcupada()) {
				todasLasHabitaciones+=habitacion.toString();
			}
		}
		return todasLasHabitaciones;
	}
	public boolean estaOcupada(int hab) {
		// TODO Auto-generated method stub
		for (Habitacion habitacion : habitaciones) {
			if (habitacion.getNumero()==hab && habitacion.isOcupada()) {
				return true;
			}
		}
		return false;
	}
	public ArrayList<String> categoriasPosibles() {
		// TODO Auto-generated method stub
		ArrayList<String> categorias = new ArrayList<String>();
		for (Precio precio : precios) {
			if(!categorias.contains(precio.getCategoria())){
				categorias.add(precio.getCategoria());
			}
		}
		return categorias;
	}
}
