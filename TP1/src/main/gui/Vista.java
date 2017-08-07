package main.gui;

import main.control.CamionesControler;
import main.control.PeonesCreator;
import main.control.TravelsControler;
import main.model.ViajeLargo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Scanner;

import javax.sound.midi.Soundbank;


public class Vista {
	TravelsControler travelsControler;
	CamionesControler camionesControler;
	PeonesCreator peonesCreator;
	double precioBasico=2000;
	String [] args;
	
	public TravelsControler getTravelsControler() {
		return travelsControler;
	}
	public CamionesControler getCamionesControler() {
		return camionesControler;
	}
	public PeonesCreator getPeonesCreator() {
		return peonesCreator;
	}
	public double getPrecioBasico() {
		return precioBasico;
	}
	public void setTravelsControler(TravelsControler travelsControler) {
		this.travelsControler = travelsControler;
	}
	public void setCamionesControler(CamionesControler camionesControler) {
		this.camionesControler = camionesControler;
	}
	public void setPeonesCreator(PeonesCreator peonesCreator) {
		this.peonesCreator = peonesCreator;
	}
	public void setPrecioBasico(double precioBasico) {
		this.precioBasico = precioBasico;
	}
	
	public Vista() {
		// TODO Auto-generated constructor stub
	}
	public Vista(String[] args) {
		// TODO Auto-generated constructor stub
		camionesControler =	new CamionesControler();
		peonesCreator = new PeonesCreator();
		peonesCreator.CrearLosPeonesParaPrueba();
		travelsControler =new TravelsControler(camionesControler,peonesCreator);
		camionesPrueba();
		setearBasicos();
		this.args=args;
	}
	@SuppressWarnings("resource")
	public void menuInicial() {
		// TODO Auto-generated method stub
		System.out.println("Ingrese el precio basico para cualquier viaje");
		precioBasico= (new Scanner(System.in).nextDouble());
		menuPrincipal();
	}
        private void setearBasicos() {
		// TODO Auto-generated method stub
        	travelsControler.setCostoBasico(precioBasico);
	}

		private void camionesPrueba() {
		// TODO Auto-generated method stub
      		camionesControler.crearNuevoCamion("eui003", Calendar.getInstance(), 900);
     		camionesControler.crearNuevoCamion("eui103", Calendar.getInstance(), 1211);
     		camionesControler.crearNuevoCamion("an213qw", Calendar.getInstance(), 2321);
     		camionesControler.crearNuevoCamion("asd123", Calendar.getInstance(), 3214);
     		camionesControler.crearNuevoCamion("req436", Calendar.getInstance(), 6);

     		try {
				travelsControler.crearViajeCorto("eui003", 12, 12);
				travelsControler.crearViajeLargo("an213qw", 1223, 1000);
				travelsControler.crearViajeLargo("asd123", 1223, 132);

				travelsControler.devolverUnViaje(travelsControler.getNumeroDeUnViajeActivo("eui003")).agregarPeonAlViaje(peonesCreator.getPeon(32837475));
				travelsControler.devolverUnViaje(travelsControler.getNumeroDeUnViajeActivo("asd123")).agregarPeonAlViaje(peonesCreator.getPeon(12854556));
				travelsControler.devolverUnViaje(travelsControler.getNumeroDeUnViajeActivo("asd123")).setCustodia(true);


			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

		public void menuPrincipal(){
            System.out.println("Menu");
            System.out.println("1. Opciones de Viajes");
            System.out.println("2. Opciones de Camiones y Peones");
            System.out.println("3. Opciones de Impresion");
            System.out.println("O cualquier otro valor para Finalizar");

            Scanner sc = new Scanner(System.in);
            int opA = validarSiLaOpcionEsUnNumero(sc);
            switch (opA) {
                case 1:
                    menuViajes();
                    break;
                case 2:
                    menuCamionesYPeones();
                    break;
                case 3:
                    menuImpresion();
                    break;
                default:
                	sc.close();
                   System.exit(0);
            }

        }

	public int	validarSiLaOpcionEsUnNumero(Scanner sc){
		 int opA = sc.nextInt();
         while(!sc.hasNextInt()){
         	System.out.println("El dato ingresado no es un numero ");
         	opA= sc.nextInt();
         }	
		return opA;
		}
    

    private void menuImpresion() {
			// TODO Auto-generated method stub
    	   Scanner sc = new Scanner(System.in);
           System.out.println("--------------------Viajes--------------------");
           System.out.println("1. Viajes que superan un numero aleatoreo");
           System.out.println("2. Camiones Libres");
           System.out.println("3. Pagados en cheque");
           System.out.println("4. Cantidad de viajes de corta distancia");
           System.out.println("5. Viajes que pasaron por los peajes que estan en las ciudades que empieza por:");
           System.out.println("6. Con custodia y mas de 850KG ");
           System.out.println("7. Viajes que pasaron por la localidad que empieza por: ");
           System.out.println("8. Costo del viaje: ");
           System.out.println("9. Volver al menu anterior ");
           System.out.println("0 Salir");

           System.out.println("Cualquier otro valor para empezar de 0");
           final int opB = validarSiLaOpcionEsUnNumero(sc);
          
           switch (opB) {
               case 1:
            	  System.out.println( travelsControler.peonesYPeajesMayoresANumeroRandom((new Random().nextInt(900)+100)));
            	   menuPrincipal();
                   break;   	
               case 2:
            	   
            	   for (String string : camionesControler.camionesAsignadosArray(args)) {
						System.out.println("Este camion es nuestro y esta libre " + string);
				}
            	 
               	  menuPrincipal();
                     break;
     				         
               	  
               case 3:
                  System.out.println(travelsControler.pagadoConCheque());
                  menuPrincipal();
                   break;
               case 4:
            	  System.out.println(travelsControler.cantidadDeViajesCortos());
               	menuPrincipal();
                   break;
               case 5:
            	   Scanner s = new Scanner(System.in);
            	   System.out.println("Ingrese tres letras \n");
            	   final String st=s.nextLine();
            	 if (st.length()>3) {
					System.err.println("Tenia mas de 3 letras \n");
                  	menuPrincipal();
				}
            	 if (st.length()<3) {
 					System.err.println("no llegaba a las 3 letras \n");
                   	menuPrincipal();
 				}
            	   System.out.println(travelsControler.peajesPorPrimerasLetras(st));
                  	menuPrincipal();
                   break;
               case 6:
            	   System.out.println(travelsControler.custodiaYPeso());
                 menuPrincipal();
                   break;
               case 7:
            	   System.out.println("ingrese el numero de viaje que desea seleccionar ");
            	   int nv = new Scanner(System.in).nextInt();
            	   while (travelsControler.isShortTravel(nv) || !travelsControler.existeElViaje(nv)) {
            		   System.err.println("El numero seleccionado no pertenece a un viaje largo");
            		   System.out.println("ingrese el numero de viaje que desea seleccionar ");
                	   nv = new Scanner(System.in).nextInt();
				}
            	   ViajeLargo vLargo = (ViajeLargo)travelsControler.devolverUnViaje(nv);
            	   
            	  ArrayList<String> local = vLargo.getLocalidades();
            	  System.out.println("las localidades por las que paso son:");
            	   for (String string : local) {
					System.out.print(string + ", ");
				}
            	   System.out.println();
                   menuPrincipal();
                     break;
               case 8:
            	   System.out.println("ingrese el numero de viaje que desea seleccionar ");
            	   int nv1 = new Scanner(System.in).nextInt();
            	   while (!travelsControler.existeElViaje(nv1)) {
            		   System.err.println("El numero seleccionado no pertenece a un viaje");
            		   System.out.println("ingrese el numero de viaje que desea seleccionar ");
                	   nv1 = new Scanner(System.in).nextInt();
				} 
            	   System.out.println("el costo del viaje fue");
            	  System.out.println( travelsControler.devolverUnViaje(nv1).devolverCostoDeEsteViaje());
                   menuPrincipal();
                     break;
               case 9:
                   menuPrincipal();
                     break;
               default:
            	   sc.close();
                   System.exit(0);
           }
		}
    

	private void menuCamionesYPeones() {
			// TODO Auto-generated method stub

        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------Peones y Camiones--------------------");
        System.out.println("1. Agregar un camion");
        System.out.println("2. modificar carga Maxima");
        System.out.println("3. ir a menu de Viajes");
        System.out.println("4. volver al Menu anterior");
        System.out.println("5 Salir");

        System.out.println("Cualquier otro valor para empezar de 0");
        final int opB = validarSiLaOpcionEsUnNumero(sc);
       
        switch (opB) {
            case 1:
                	 System.out.println("escriba la patente del Camion a ingresar");
                	String pat1 = (new Scanner(System.in)).nextLine();
                	while(!camionesControler.validarPatente(pat1)){
               		 System.err.println("Patente invalidad por favor ");

                		 System.out.println("escriba la patente del Camion a ingresar");
                     	 pat1 = (new Scanner(System.in)).nextLine();
                	}
        
                  	 System.out.println("escriba el ano del patentamiento del Camion a ingresar");
                  	int ano1=(new Scanner(System.in)).nextInt();
                	 Calendar fech1 = new GregorianCalendar(ano1, 0, 1) ;
                	 while(camionesControler.ValidatorPatentamiento(fech1)){
                		 System.err.println("La fecha ingresada es invalida");
                     	 System.out.println("escriba el ano del patentamiento del Camion a ingresar");
                        ano1=(new Scanner(System.in)).nextInt();
                   	  fech1 = new GregorianCalendar(ano1, 0, 1) ;
                	 }
                	 System.out.println("escriba la cargaMaximaDelCamion del Camion a ingresar");
                 	int carg1 = (new Scanner(System.in)).nextInt(); 

              		camionesControler.crearNuevoCamion(pat1, fech1, carg1);
                menuPrincipal();
                break;
				          
            	
            case 2:
            	  System.out.println("escriba una de las siguientes patentes para modificar su peso maximo");
            	  try {
                		camionesControler.camionesDisponibles();
                		
    				} catch (Exception e) {
      					// TODO: handle exception
      					System.err.println(e.getMessage());
      					menuCamionesYPeones();
      					break;
      				}   
            	  final String pat2=sc.nextLine();
                  System.out.println("indique la Carga maxima para ese camion");
                  final int peso=sc.nextInt();
                  camionesControler.getCamion(pat2).setCargaMaxima(peso);
                  menuPrincipal();
                  break;
            	  
            case 3:
                menuViajes();
                break;
            case 4:
            	 menuPrincipal();
                break;
            default:
            	sc.close();
                System.exit(0);
        }

		}

	public  void menuViajes() {
	
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------Viajes--------------------");
        System.out.println("1. Agregar nuevo Viaje Largo");
        System.out.println("2. Agregar nuevo Viaje Corto");
        System.out.println("3. Modificar Viaje");
        System.out.println("4. Finalizar Viaje");
        System.out.println("5. Volver al menu anterior ");
        System.out.println("6 Salir");

        System.out.println("Cualquier otro valor para empezar de 0");
        final int opB = validarSiLaOpcionEsUnNumero(sc);
       
        switch (opB) {
            case 1:
                System.out.println("escriba una de las siguientes patentes para agregar al viaje"+'\n');
                
                try {
              		System.out.println(camionesControler.camionesDisponibles());
              		
  				} catch (Exception e) {
  					// TODO: handle exception
  					System.err.println(e.getMessage());
  					menuCamionesYPeones();
  					break;
  				}    
                final String pat1=(new Scanner(System.in).nextLine());
         		 System.out.println("indique la distancia del viaje");
                final int dis1=(new Scanner(System.in).nextInt());
                System.out.println("indique el peso del viaje");
                double peso1=(new Scanner(System.in).nextDouble());
				while(travelsControler.crearViajeLargo(pat1,dis1,peso1)){
					System.out.println("El camion " +pat1+" no puede llevar ese peso");
					System.out.println("indique el peso del viaje");
	                 peso1=(new Scanner(System.in).nextDouble());	
				}
			
                modificarViaje(pat1);
                break;
				          
            	
            case 2:
            	  System.out.println("escriba una de las siguientes patentes para agregar al viaje");
                  try {
                		System.out.println(camionesControler.camionesDisponibles());
                		
    				} catch (Exception e) {
    					// TODO: handle exception
    					System.err.println(e.getMessage());
    					menuCamionesYPeones();
    					break;
    				} 
                  final String pat2=(new Scanner(System.in).nextLine());
                  System.out.println("indique la distancia del viaje");
                  final int dis2=(new Scanner(System.in).nextInt());
                  System.out.println("indique el peso del viaje");
                  double peso2=(new Scanner(System.in).nextDouble());
  				while(travelsControler.crearViajeCorto(pat2,dis2,peso2)){
  					System.out.println("El camion " +pat2+" no puede llevar ese peso");
  					System.out.println("indique el peso del viaje");
  	                 peso2=(new Scanner(System.in).nextDouble());	
  				}
                  modificarViaje(pat2);
                  break;
  				         
            	  
            case 3:
                System.out.println("seleccione uno de los siguientes viajes que esta en curso para modificar, usando el numero de viaje");
               System.out.println(travelsControler.viajesEnCurso());
                final int mod=sc.nextInt();
                modificarViaje(mod);
                break;
            case 4:
            	 System.out.println("seleccione uno de los siguientes viajes que esta en curso para finalizar, usando el numero de viaje");
               System.out.println(travelsControler.viajesEnCurso());
                  int mod2=sc.nextInt();
               while(!travelsControler.getViajesEnCurso().contains(mod2)){
            	   System.err.println("El viaje seleccionado no pertenece a la lista ");

            	   System.out.println("seleccione uno de los siguientes viajes que esta en curso para finalizar, usando el numero de viaje");
                   System.out.println(travelsControler.viajesEnCurso());
                    mod2=sc.nextInt();
               }
               if(!travelsControler.isShortTravel(mod2)){
                 System.out.println("escriba la hora de llegada");
             	int hora=(new Scanner(System.in)).nextInt();
             	System.out.println("escriba los minutos de llegada");
              	int min=(new Scanner(System.in)).nextInt();
         	 System.out.println("escriba el dia de llegada");
             	int dia=(new Scanner(System.in)).nextInt();
          	 System.out.println("escriba el mes de llegada");
            	int mes=(new Scanner(System.in)).nextInt()-1;
            	 System.out.println("escriba el ano de llegada");
            	int ano=(new Scanner(System.in)).nextInt();
          	 Calendar fech1 = new GregorianCalendar(ano, mes, dia,hora, min) ; 
            
          	 while(travelsControler.devolverUnViaje(mod2).getFechaDePartida().compareTo(fech1)<=0){
          	   System.err.println("El camion no puede llegar antes de partir ");
          		 System.out.println("escriba la hora de llegada");
            	 hora=(new Scanner(System.in)).nextInt();
            	System.out.println("escriba los minutos de llegada");
             	 min=(new Scanner(System.in)).nextInt();
        	 System.out.println("escriba el dia de llegada");
            	 dia=(new Scanner(System.in)).nextInt();
         	 System.out.println("escriba el mes de llegada");
           	 mes=(new Scanner(System.in)).nextInt()-1;
           	 System.out.println("escriba el ano de llegada");
           	 ano=(new Scanner(System.in)).nextInt();
         	  fech1 = new GregorianCalendar(ano, mes, dia,hora, min) ;
          	 }
          	 String costoTotal =""+ travelsControler.finalizarViaje(mod2, fech1);
              System.out.println("El costo del viaje n: "+ mod2 +" es de "+ costoTotal );
               }
            	  if (travelsControler.isShortTravel(mod2)) {
                 	 System.out.println("seleccione uno si se pago en efectivo o dos si se pago con cheque(cualquier otro valor sera considerado como cheque)");
                 	 final int esCorto= (new Scanner(System.in).nextInt());               	  	                	 
                 	 String costoTotal =""+ travelsControler.finalizarViaje(mod2,(esCorto==1)?true:false);
                      System.out.println("El costo del viaje n: "+ mod2 +" es de "+ costoTotal );
            	  }      
                 menuViajes();
                break;
            case 5:
              menuPrincipal();
                break;
            default:
            	sc.close();
                System.exit(0);
        }

    }

	private void modificarViaje(String pat) {
		// TODO Auto-generated method stub
		modificarViaje(travelsControler.getNumeroDeUnViajeActivo(pat));
	}

	@SuppressWarnings("resource")
	private void modificarViaje(int numeroViaje) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub

        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------Peones y Camiones--------------------");
        System.out.println("1. Agregar un peaje");
        System.out.println("2. Agregar Peones al Viaje");
        System.out.println("3. Cambiar Camion de este viaje");
//        System.out.println("4. seleccionar fecha de partida");
        if (!travelsControler.isShortTravel(numeroViaje)) {
        	System.out.println("4. Agregar Localidad al Viaje");
		}
        System.out.println("5. Modificar el peso");
        System.out.println("6. Asignar Custodia");


        System.out.println("7. Volver al menu anterior ");
        System.out.println("8 Salir");

        System.out.println("Cualquier otro valor para empezar de 0");
        final int opB = validarSiLaOpcionEsUnNumero(sc);
       
        switch (opB) {
            case 1:
            	System.out.println("Ingrese el lugar del Peaje");
            	String lugar= (new Scanner(System.in).nextLine());
            	System.out.println("ingrese el Precio del Peaje");
            	int importe= (new Scanner(System.in).nextInt());
               travelsControler.agregarPeajeAlViaje(numeroViaje, importe,lugar);               
               modificarViaje(numeroViaje);
                break;
				          
            	
            case 2:
            	  System.out.println("Ingrese el documento de uno de los siguientes peones");
            	  try {
                		System.out.println(peonesCreator.getPeonesLibres()); 
                		travelsControler.asignarPeonAlViaje(numeroViaje, (new Scanner(System.in).nextInt()));
                		
    				} catch (Exception e) {
      					// TODO: handle exception
      					System.err.println("no esta en la lista de los ofrecidos");
      					menuViajes();
      					break;
      				}   
                  modificarViaje(numeroViaje);
                  break;
            	  
            case 3:
            	 System.out.println("escriba una de las siguientes patentes usar como nuevo camion");
                 try {
               		System.out.println(camionesControler.camionesDisponibles());
               		
   				} catch (Exception e) {
   					// TODO: handle exception
   					System.err.println(e.getMessage());
   					menuViajes();
   					break;
   				} 
                 final String pat1=(new Scanner(System.in).nextLine());
            	travelsControler.devolverUnViaje(numeroViaje).cambiarCamion(camionesControler.getCamion(pat1));
                modificarViaje(numeroViaje);
                break;
            case 4:
//                modificarFechaPartida(numeroViaje);
            	if (travelsControler.isShortTravel(numeroViaje)) {
            		System.err.println("Usted a ingresado una opcion que esta en desarrollo, no lo vuelva a hacer");
                    modificarViaje(numeroViaje);
				}else{
	            	 System.out.println("escriba una de las siguientes patentes usar como nuevo camion");
	                 final String loc=(new Scanner(System.in).nextLine());
	                 travelsControler.agregarLocalidadAlViaje(loc,numeroViaje);
                    modificarViaje(numeroViaje);
				}
            	
                break;
            case 5:
                System.out.println("Ingrese nuevo valor de peso para el viaje");
                final double mod5=sc.nextDouble();
                travelsControler.devolverUnViaje(numeroViaje).setPeso(mod5);
                modificarViaje(numeroViaje);
                break;
            case 6:
                System.out.println("Ingrese 1 si quiere asignarle custodia o 2 si quiere sacarsela");
                final int mod6=sc.nextInt();
            	travelsControler.devolverUnViaje(numeroViaje).setCustodia((mod6==1));
                modificarViaje(numeroViaje);
                break;
            case 7:
                 menuViajes();
                break;
            default:
            	sc.close();
                System.exit(0);
        }
	}

	@SuppressWarnings("resource")
	private void modificarFechaPartida(int mod) {
		// TODO Auto-generated method stub
	   	 System.out.println("escriba el dia de inicio");
	       	int dia=(new Scanner(System.in)).nextInt()-1;
	   	 System.out.println("escriba el mes de inicio");
       	int mes=(new Scanner(System.in)).nextInt()-1;
       	 System.out.println("escriba el ano de inicio");
       	int ano=(new Scanner(System.in)).nextInt();
     	 Calendar fech1 = new GregorianCalendar(ano, mes, dia) ; 
     	 travelsControler.setFechaPartida(mod, fech1);
   
	}





}
