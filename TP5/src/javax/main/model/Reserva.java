package javax.main.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Reserva  implements Costo{
	private int numeroDeReserva;
	private Habitacion habitacion;
	private Huesped huesped;
	private Calendar checkIn;
	private int capacidad;
	private ArrayList<Consumo> consumos;
	private double precioTotal;
	private Calendar checkOut;
	
	public Reserva() {
		// TODO Auto-generated constructor stub
	}
	public Reserva(int numeroDeReserva, Habitacion habitacion, Huesped huesped, Calendar checkIn, int capacidad,
			 double precioTotal, Calendar checkOut) {
		this.numeroDeReserva = numeroDeReserva;
		this.habitacion = habitacion;
		this.huesped = huesped;
		this.checkIn = checkIn;
		this.capacidad = capacidad;
		this.precioTotal = precioTotal;
		this.checkOut = checkOut;
		habitacion.setOcupada(true);
		consumos= new ArrayList<Consumo>();
	}

	public Reserva(int numeroDeReserva, Habitacion habitacion, Huesped huesped, Calendar checkIn, int capacidad,
			 double precioTotal) {
		this.numeroDeReserva = numeroDeReserva;
		this.habitacion = habitacion;
		this.huesped = huesped;
		this.checkIn = checkIn;
		this.capacidad = capacidad;
		this.consumos = consumos ;
		this.precioTotal = precioTotal;
		habitacion.setOcupada(true);
		consumos= new ArrayList<Consumo>();
	}
	
	public Reserva(int numeroDeReserva, Habitacion habitacion, Huesped huesped, Calendar checkIn, int capacidad
) {
		this.numeroDeReserva = numeroDeReserva;
		this.habitacion = habitacion;
		this.huesped = huesped;
		this.checkIn = checkIn;
		this.capacidad = capacidad;
		this.consumos = consumos;
		habitacion.setOcupada(true);
		consumos= new ArrayList<Consumo>();
	}
	
	public Reserva(int numeroDeReserva, Habitacion habitacion, Huesped huesped, Calendar checkIn, int capacidad,
			Calendar checkOut) {
		this.numeroDeReserva = numeroDeReserva;
		this.habitacion = habitacion;
		this.huesped = huesped;
		this.checkIn = checkIn;
		this.capacidad = capacidad;
		this.checkOut = checkOut;
		consumos= new ArrayList<Consumo>();
 
	}
	
public int getNumeroDeReserva() {
		return numeroDeReserva;
	}
	public Habitacion getHabitacion() {
		return habitacion;
	}
	public Huesped getHuesped() {
		return huesped;
	}
	public Calendar getCheckIn() {
		return checkIn;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public ArrayList<Consumo> getConsumos() {
		return consumos;
	}
	public double getPrecioTotal() {
		return precioTotal;
	}
	public Calendar getCheckOut() {
		return checkOut;
	}
	public void setNumeroDeReserva(int numeroDeReserva) {
		this.numeroDeReserva = numeroDeReserva;
	}
	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}
	public void setHuesped(Huesped huesped) {
		this.huesped = huesped;
	}
	public void setCheckIn(Calendar checkIn) {
		this.checkIn = checkIn;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	public void setCheckOut(Calendar checkOut) {
		this.checkOut = checkOut;
	}
	@Override
	public double calcularCostoTotalAlCheckOut() {
		// TODO Auto-generated method stub
		int days = (int) TimeUnit.MILLISECONDS.toDays(Math.abs((checkOut.getTimeInMillis()-checkIn.getTimeInMillis())));
			double cupones= huesped.hasCupons()?Costo.promocion:1;
			Precio p = habitacion.getPrecio();
			double cost=p.getCosto();
			double precioHab=(cost*days)*((days>7)?Costo.descuento:1);
			precioTotal= precioHab*(cupones);
		return precioTotal;
	}
	public double consumosTotalPrice(){
		double precio=0;
		for (Consumo consumo : consumos) {
			precio+=consumo.getProducto().getPrecio();
		}
		return precio;
	}
public void setConsumo(int cantidad, Producto producto){
	consumos.add(new Consumo(Calendar.getInstance(), producto, cantidad));
}
	public void clienteDejaHabitacion() {
		huesped.setCliente(false);
		habitacion.vaciar();
	}
public String consumoToString() {
	String c="";
	if(consumos.isEmpty()) return c;
for (Consumo consumo : consumos) {
	c+= consumo.toString()+"&";
}
		return c;
}
}
