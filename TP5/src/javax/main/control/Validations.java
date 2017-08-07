package javax.main.control;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Validations {
	Scanner sc;
	boolean entro=false;

	public int	validarSiLaOpcionEsUnNumero(){
		sc=new Scanner(System.in);
		boolean esValido= false;
		int opA=0; 

//		sc.nextLine();
		while (!esValido){
     try {
 		opA=sc.nextInt(); 
 
    	 esValido=true;
         
	} catch (InputMismatchException e) {
		// TODO: handle exception
		System.out.println("El dato ingresado no es un numero reingrese");
		sc.nextLine();
	}
			
        }
        System.out.println(opA);
		 entro=false;
        
		return opA;
		}
	
	public String validarSiLaOpcionEsUnString(){
		sc=new Scanner(System.in);
       while(!sc.hasNextLine()){
       sc.nextLine();
   	if(entro){
   	System.out.println("El dato ingresado no es un numero ");
   	entro= true;
   	}
       }	
		 String opA = sc.nextLine();
		 System.out.println(opA);
		 entro=false;
        
		return opA;
		}
	
	public double validarSiLaOpcionEsUnNumeroConComa(){
		sc=new Scanner(System.in);

       while(!sc.hasNextDouble()){
    	   sc.nextDouble();
       	if(entro){
       	System.out.println("El dato ingresado no es un numero ");
       	entro= true;
       	}
       }	
		 double opA = sc.nextDouble();
       System.out.println(opA);
		 entro=false;
      
		return opA;
		}
	public Long validarSiLaOpcionEsUnNumeroLong(){
		sc=new Scanner(System.in);

       while(!sc.hasNextLong()){
    	   sc.nextDouble();
       	if(entro){
       	System.out.println("El dato ingresado no es un numero ");
       	entro= true;
       	}
       }	
		 Long opA = sc.nextLong();
       System.out.println(opA);
		 entro=false;
      
		return opA;
		}
	public Calendar validatorFechaPosteriorAActual(){	
		sc=new Scanner(System.in);

		Calendar fecha= new GregorianCalendar(1000,1,1);
		// TODO Auto-generated method stub
		while ((fecha.before(Calendar.getInstance()))) {
			System.out.println("ingrese el dia");
			int day=validarSiLaOpcionEsUnNumero();
			while(day>31 || day<0){
				day=validarSiLaOpcionEsUnNumero();
				sc.nextInt();
	        	if(!entro){
	        	System.out.println("El dato ingresado no es un numero ");
	        	entro= true;
	        	}
			}
			 entro=false;
				System.out.println("ingrese el mes");
			int month=validarSiLaOpcionEsUnNumero()-1;
			while (month>11 || month<-1) {
			month=validarSiLaOpcionEsUnNumero()-1;
//			sc.nextInt();
        	if(!entro){
        	System.out.println("El dato ingresado no es un numero ");
        	entro= true;
        	}
   		 entro=false;

			}
			System.out.println("ingrese el year");

			int year=validarSiLaOpcionEsUnNumero();
			while (year<Calendar.getInstance().get(Calendar.YEAR)) {
//				sc.nextInt();
	        	if(!entro){
	        	System.out.println("El dato ingresado no es un numero ");
	        	entro= true;

	        	}	
	        	
	        	}
			 fecha= new GregorianCalendar(year,month,day);
		}
        
		 entro=false;
		
		return fecha;

	}
	
	public Calendar validatorFecha(){	
		sc=new Scanner(System.in);

		Calendar fecha= new GregorianCalendar(1000,1,1);
		// TODO Auto-generated method stub
			System.out.println("ingrese el dia");
			int day=validarSiLaOpcionEsUnNumero();
			while(day>31 || day<0){
				day=validarSiLaOpcionEsUnNumero();
//				sc.nextInt();
	        	if(entro){
	        	System.out.println("El dato ingresado no es un numero ");
	        	entro= true;
	        	}
			}
			 entro=false;
				System.out.println("ingrese el mes");
			int month=validarSiLaOpcionEsUnNumero()-1;
			while (month>11 || month<-1) {
			month=validarSiLaOpcionEsUnNumero()-1;
//			sc.nextInt();
        	if(entro){
        	System.out.println("El dato ingresado no es un numero ");
        	entro= true;
        	}
   		 entro=false;

			}
			System.out.println("ingrese el year");

			int year=validarSiLaOpcionEsUnNumero();
			while (year<1920 || year>2016) {
//				sc.nextInt();
	        	if(entro){
	        	System.out.println("El dato ingresado no es un numero ");
	        	entro= true;
	        	}			
	        	}
			 fecha= new GregorianCalendar(year,month,day);
		
        
		 entro=false;
		
		return fecha;

	}
	
	public boolean validarBoolean(){
		sc=new Scanner(System.in);
      while((sc.hasNext())){
    	  String s= sc.nextLine();
    	  if (s.toUpperCase().equals("SI") || s.toUpperCase().equals("TRUE")) {
			return true;
		}
    	  if (s.toUpperCase().equals("NO") || s.toUpperCase().equals("FALSE")) {
  			return false;
  		}
      		System.out.println("El dato ingresado no es valido");

      }
		 entro=false;
     
		return false;
	}

	public String validarSiEsUnaCategoria() {
		// TODO Auto-generated method stub
		sc=new Scanner(System.in);
//		sc.nextLine();
		String opA="";
		do {
        	opA=(sc.nextLine()).toUpperCase();
        	if (opA.equals("CLASICA")|| opA.equals("PREMIUM") || opA.equals("SUPERIOR") || opA.equals("ECONOMICA") ) {
				return opA;
			}
        	
        	if(entro){
        	System.out.println("El dato ingresado no es una categoria valida por favor reingrese");
        	sc.nextLine();
        	}

        	entro= true;
        } while(sc.hasNextLine());
		opA=sc.nextLine(); 
        System.out.println(opA);
		 entro=false;
        
		return opA;
	}
}
