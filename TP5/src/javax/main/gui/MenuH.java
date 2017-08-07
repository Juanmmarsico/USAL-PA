package javax.main.gui;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Random;

import javax.main.control.ConsumoController;
import javax.main.control.HuespedController;
import javax.main.control.HuespedException;
import javax.main.control.ReservasController;
import javax.main.control.Validations;
import javax.main.model.Habitacion;
import javax.main.model.Huesped;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

public class MenuH {
Validations validations;
ReservasController reservasController;
ConsumoController consumoController;
HuespedController huespedController;
String [] args;

//MenuPrincupal menuPrincupal;
//MenuClientes menuClientes;
//MenuHabitaciones menuHabitaciones;
public Huesped generarHuesped(){
	Huesped huesped;
	try {
		System.out.println("ingrese el DNI de la parsona");
		long dni=validations.validarSiLaOpcionEsUnNumeroLong();
		huesped=huespedController.buscarHuesped(dni);
	} catch (HuespedException e) {
		// TODO: handle exception
		System.out.println("por favor ingrese el nombre de la persona");
		String nombre=validations.validarSiLaOpcionEsUnString();
		System.out.println("por favor ingrese el apellid de la persona");
		String apellido=validations.validarSiLaOpcionEsUnString();
		System.out.println("ingrese el nacimiento de la persona");
		Calendar nacimiento=validations.validatorFecha();
		 huesped=e.crearHuesped(nombre, apellido, nacimiento);
		return huesped;

	}
	return huesped;
}

public MenuH(String [] args) {
	// TODO Auto-generated constructor stub
//	consumoController = new ConsumoController("./Files/productos");
//	reservasController= new ReservasController("./Files/precios", "./Files/habitaciones");
//	huespedController= new HuespedController("./Files/huespedes");
	 consumoController = new ConsumoController("./Files/productos");
	 huespedController = new HuespedController("./Files/huespedes");
//	 reservasController = new ReservasController("./Files/habitaciones","./Files/precios");
	 reservasController = new ReservasController(huespedController, consumoController, "./Files/habitaciones", "./Files/precios");
	validations= new Validations();
//menuClientes=new MenuClientes();
//menuHabitaciones = new MenuHabitaciones();
//menuPrincupal= new MenuPrincupal();
//menuPrincupal.menuprincipal();
	this.args = args;

}


public void agregarAcompanante(Huesped huesped) {
	System.out.println("ingrese opcion 1 para agregar otro acompanante o 2 para volver al menu anterior");
	int op=validations.validarSiLaOpcionEsUnNumero();
	while (op<0 && op>2 ){
		op= validations.validarSiLaOpcionEsUnNumero();
	}
	switch (op) {
	case 1:
		huesped.agregarHuesped(generarHuesped());
		agregarAcompanante(huesped);
		break;

	default:
		return;
//		break;
	}
}

private int counter = 0;
public void menuprincipal(){
	
    System.out.println("Menu");
    System.out.println("1. Crear una nueva Reserva");
    System.out.println("2. Finalizar una Reserva");
    System.out.println("3. Consultar consumos de una habitacion");
    System.out.println("4. Agregar Huesped");
    System.out.println("5. Agregar Consumo a una habitacion");
    System.out.println("6. Generar Cupones");
    System.out.println("O cualquier otro valor para Finalizar");
    int opA = validations.validarSiLaOpcionEsUnNumero();
    
    switch (opA) {
        case 1:
            seleccionDeDatos();
        	System.out.println("Gracias por elegir la opcion 1 por favor ingrese los datos");

            break;
        case 2:
        	System.out.println(reservasController.habitacionesLibresToString());
        	System.out.println("por favor seleccione el numero de la habitacion");
        	int hab=0;
        	int count=0;
        do {
        	hab=validations.validarSiLaOpcionEsUnNumero();
        	if (hab==0) {
				break;
			}
        	while(hab>150 || hab<0){
        		System.out.println("el numero no corresponde a una habitacion");
        		hab =validations.validarSiLaOpcionEsUnNumero();
        	}
        	if (count==5) {
				System.out.println("muchos errores");
			break;
        	}
			count++;
		} while (!reservasController.estaOcupada(hab));	
        System.out.println("precio");
        Calendar calendar =liberarHabitacion(hab);
        System.out.println("nro");
        System.out.println(hab);
        System.out.println("fecha");
        System.out.println(""+calendar.get(Calendar.DATE)+'/'+calendar.get(Calendar.MONTH)+'/'+calendar.get(Calendar.YEAR));

            menuprincipal();
            break;
        case 3:
        	System.out.println(reservasController.habitacionesLibresToString());
        	System.out.println("por favor seleccione el numero de la habitacion");
        	consultarConsumos();
        	menuprincipal();
            break;
        case 4:
        	generarHuesped();
        	menuprincipal();
            break;
        case 5:
        	System.out.println(reservasController.habitacionesLibresToString());
        	System.out.println("por favor seleccione el numero de la habitacion");
        	 hab=0;
        	 int prod=0;
        	 int cant=0;
        do {
        	hab=validations.validarSiLaOpcionEsUnNumero();
        	if (hab==0) {
				break;
			}
        	while(hab>150 || hab<0){
        		System.out.println("el numero no corresponde a una habitacion");
        		hab =validations.validarSiLaOpcionEsUnNumero();
        	}
        	System.out.println("por favor ingrese el codigo del producto");
        		prod=validations.validarSiLaOpcionEsUnNumero();
        	while(!consumoController.verificarQueExistaElProducto(prod)){
        		prod=validations.validarSiLaOpcionEsUnNumero();
        	}
        	System.out.println("ingrese la cantidad");
        	cant= validations.validarSiLaOpcionEsUnNumero();
		} while (!reservasController.agregarConsumoAHabitacion(hab, cant, prod));
        	
        	
        	menuprincipal();
            break;
        case 6: 
//        	System.out.println("Ingrese el mes que desea");
        	double importeRandom = (new Random()).nextInt(1000);
        	int mes = 0;
        	do {
        	if (counter==args.length) {
				counter=0;
			}
            	mes=Integer.parseInt(args[counter]);
            	counter++;
            	if (mes==0) {
    				break;
    			}
        	}while(mes>12 || mes<0);
        	reservasController.cuponGenerator(importeRandom, mes-1);
        	menuprincipal();
        	break;
        default:
           System.exit(0);
    
}
}
public void seleccionDeDatos(){
	String string= reservasController.categoriasPosibles().toString();
	System.out.printf("Porfavor ingrese la categoria que desee de estas: %s \n",string.replaceAll("[\\[\\]]", ""));
	String categoria=validations.validarSiEsUnaCategoria();	
	System.out.println("Por favor ingrese la cantidad de personas que van a ser");
	int cantidadDePersonas=validations.validarSiLaOpcionEsUnNumero();
	System.out.println("Por favor indique si desea balcon");
	boolean balcon=validations.validarBoolean();
	
	String mostrarHabitacionesDisponibles="";
	HashMap<Integer , Habitacion> aList = reservasController.relacionarHabitacion(categoria, cantidadDePersonas, balcon);
	if (aList.isEmpty()) {
		aList = reservasController.relacionarHabitacionSuplente(categoria, cantidadDePersonas, balcon);
	System.out.println("no poseemos las caracteristicas solicitadas");
	}
	if (aList.isEmpty()) {
		System.out.println("no hay habitaciones con esa descripcion ni nada que podamos ofreserle");
		menuprincipal();
	}
	for (Habitacion hab: aList.values()){
	try {
		mostrarHabitacionesDisponibles += hab.toString() + '\n';
	} catch (NullPointerException e) {
		// TODO: handle exception
		System.err.println("la habitacion no dispone de precio");
	}
	}
	System.out.println("estas son las opciones disponibles ");
	System.out.println("Nro \t Comentario \t \t \t \t Balcon \t Capacidad \t Precio");
	System.out.println(mostrarHabitacionesDisponibles);
	System.out.println("por favor seleccione una de ellas");
	int h=validations.validarSiLaOpcionEsUnNumero()-1;
		while (!aList.containsKey(h)) {
			System.out.println("no exixte dicha habitacion, por favor seleccione otra ");
		h=validations.validarSiLaOpcionEsUnNumero();		
	}
	seleccionarHabitacion(h, cantidadDePersonas);
}
public void consultarConsumos(){
	System.out.println("habitaciones disponibles");
	System.out.println("ingrese el numero de habitacion");
	int i = validations.validarSiLaOpcionEsUnNumero();
	while (i>150) {
		System.out.println("no exixte dicha habitacion, por favor seleccione otra ");
		i = validations.validarSiLaOpcionEsUnNumero();
	}
	System.out.println("fecha \t codigo\t cantidad \t Total");
	System.out.println(reservasController.imprimirConsumoDeHabitacion(i));
}

public void mostrarInformacionHabitaciones(){
	reservasController.habitacionesToString();
}

public Calendar liberarHabitacion(int reserva){
	return reservasController.finalizarReserva(reserva);
}
public void seleccionarHabitacion(int habitacionNumero,int cantidadDePersonas){
System.out.println("Informe la fecha de Check Out");
Calendar checkOut= validations.validatorFechaPosteriorAActual();
Huesped huesped = generarHuesped();
huesped.setCliente(true);
agregarAcompanante(huesped);

	if(huesped.getHuespedes().size()>cantidadDePersonas){
		System.out.println("Disculpe pero son mas personas de las mencionadas anteriormente");
		seleccionDeDatos();
	}
reservasController.generarReservaNueva(habitacionNumero, checkOut, cantidadDePersonas, huesped);

menuprincipal();		
}

}
