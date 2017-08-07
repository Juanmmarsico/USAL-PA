package javax.testHotel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;


import javax.main.gui.MenuH;

public class Test {
	Random r= new Random();
	String cupones="";
	
	public static void main(String [] args) {
		Test test = new Test();
		test.generadorArchivos();
		MenuH menuH= new MenuH(args);
		menuH.menuprincipal();
	}
	public void generadorArchivos(){
		int cantidadHuespedes = r.nextInt(100)+1;
		int cantidadProductos = r.nextInt(40)+1;
		
		try {
			FileWriter hab = new FileWriter(new File("./Files/habitaciones"));
			hab.write(generadorHabitaciones());
			hab.close();
			FileWriter hues = new FileWriter(new File("./Files/huespedes"));
			hues.write(generadorHuesped(cantidadHuespedes));
			hues.close();
			FileWriter prec = new FileWriter(new File("./Files/precios"));
			prec.write(generadorPrecio());
			prec.close();
			FileWriter prod = new FileWriter(new File("./Files/productos"));
			prod.write(generadorProductos(cantidadProductos));
			prod.close();
			FileWriter cup = new FileWriter(new File("./Files/cupones"));
			cup.write(cupones);
			cup.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String generadorNombre(){
		String [] nombre ={"ANTONIO",
				"JOSE",
				"MANUEL",
				"FRANCISCO",
				"JUAN",
				"DAVID",
				"JOSE ANTONIO",
				"JOSE LUIS",
				"JAVIER",
				"JESUS",
				"FRANCISCO JAVIER",
				"CARLOS",
				"DANIEL",
				"MIGUEL",
				"RAFAEL",
				"JOSE MANUEL",
				"PEDRO",
				"ALEJANDRO",
				"ANGEL",
				"MIGUEL ANGEL",
				"JOSE MARIA",
				"FERNANDO",
				"LUIS",
				"PABLO",
				"SERGIO",
				"JORGE",
				"ALBERTO",
				"JUAN CARLOS",
				"JUAN JOSE",
				"RAMON",
				"ENRIQUE",
				"DIEGO",
				"JUAN ANTONIO",
				"VICENTE",
				"ALVARO",
				"RAUL",
				"ADRIAN",
				"JOAQUIN",
				"IVAN",
				"ANDRES",
				"OSCAR",
				"RUBEN",
				"JUAN MANUEL",
				"SANTIAGO",
				"EDUARDO",
				"VICTOR",
				"ROBERTO",
				"JAIME",
				"FRANCISCO JOSE",
				"IGNACIO",
				"ALFONSO",
				"SALVADOR",
				"RICARDO",
				"MARIO",
				"JORDI",
				"EMILIO",
				"MARCOS",
				"JULIAN",
				"JULIO",
				"TOMAS",
				"AGUSTIN",
				"GUILLERMO",
				"GABRIEL",
				"JOSE MIGUEL",
				"FELIX",
				"JOSE RAMON",
				"MOHAMED",
				"GONZALO",
				"JOAN",
				"MARC",
				"MARIANO",
				"ISMAEL",
				"DOMINGO",
				"JOSEP",
				"CRISTIAN",
				"JUAN FRANCISCO",
				"ALFREDO",
				"NICOLAS",
				"SEBASTIAN",
				"JOSE CARLOS",
				"FELIPE",
				"SAMUEL",
				"HUGO",
				"MARTIN",
				"CESAR",
				"AITOR",
				"JOSE ANGEL",
				"JOSE IGNACIO",
				"GREGORIO",
				"VICTOR MANUEL",
				"HECTOR",
				"LUIS MIGUEL",
				"JOSE FRANCISCO",
				"JUAN LUIS",
				"LORENZO",
				"ALBERT",
				"CRISTOBAL",
				"ESTEBAN",
				"XAVIER",
				"EUGENIO",
				"IKER",
				"RODRIGO",
				"ANTONIO JOSE",
				"ALEX",
				"ARTURO",
				"BORJA",
				"VALENTIN",
				"JOSE JAVIER",
				"JESUS MARIA",
				"JUAN MIGUEL",
				"JAUME",
				"ANTONIO JESUS",
				"GERMAN",
				"LUCAS",
				"FRANCISCO MANUEL",
				"JONATHAN",
				"PEDRO JOSE",
				"JOSE VICENTE",
				"ADOLFO",
				"ISAAC",
				"PAU",
				"BENITO",
				"MOHAMMED",
				"MOISES",
				"ISIDRO",
				"JUAN RAMON",
				"ABEL",
				"JUAN PEDRO",
				"AHMED",
				"BERNARDO",
				"ERNESTO",
				"CHRISTIAN",
				"GERARDO",
				"AARON",
				"MANUEL JESUS",
				"SERGI",
				"MIKEL",
				"CARMELO",
				"PASCUAL",
				"FEDERICO",
				"ASIER",
				"ANTONIO MANUEL",
				"MIQUEL",
				"JOEL",
				"MARCELINO",
				"FRANCESC",
				"BARTOLOME",
				"ISRAEL","MARIA CARMEN",
				"MARIA",
				"CARMEN",
				"JOSEFA",
				"ISABEL",
				"ANA MARIA",
				"MARIA DOLORES",
				"MARIA PILAR",
				"MARIA TERESA",
				"ANA",
				"LAURA",
				"FRANCISCA",
				"ANTONIA",
				"DOLORES",
				"MARIA ANGELES",
				"CRISTINA",
				"MARTA",
				"MARIA JOSE",
				"MARIA ISABEL",
				"PILAR",
				"MARIA LUISA",
				"LUCIA",
				"CONCEPCION",
				"ELENA",
				"MERCEDES",
				"MANUELA",
				"ROSA MARIA",
				"RAQUEL",
				"SARA",
				"MARIA JESUS",
				"PAULA",
				"JUANA",
				"TERESA",
				"ROSARIO",
				"ENCARNACION",
				"BEATRIZ",
				"ROSA",
				"NURIA",
				"SILVIA",
				"MONTSERRAT",
				"JULIA",
				"PATRICIA",
				"IRENE",
				"MONICA",
				"ANDREA",
				"ROCIO",
				"ANGELA",
				"MARIA MAR",
				"MARGARITA",
				"SONIA",
				"SANDRA",
				"SUSANA",
				"ALICIA",
				"YOLANDA",
				"ALBA",
				"MARIA JOSEFA",
				"MARINA",
				"NATALIA",
				"MARIA ROSARIO",
				"INMACULADA",
				"ANGELES",
				"ESTHER",
				"MARIA MERCEDES",
				"ANA ISABEL",
				"EVA",
				"VERONICA",
				"AMPARO",
				"NOELIA",
				"MARIA ROSA",
				"MARIA VICTORIA",
				"MARIA CONCEPCION",
				"CAROLINA",
				"CLAUDIA",
				"EVA MARIA",
				"CATALINA",
				"CONSUELO",
				"VICTORIA",
				"LORENA",
				"ANA BELEN",
				"MARIA ANTONIA",
				"MARIA ELENA",
				"MIRIAM",
				"EMILIA",
				"NEREA",
				"LUISA",
				"INES",
				"MARIA NIEVES",
				"GLORIA",
				"LIDIA",
				"CARLA",
				"AURORA",
				"ESPERANZA",
				"JOSEFINA",
				"SOFIA",
				"MILAGROS",
				"OLGA",
				"CELIA",
				"MARIA SOLEDAD",
				"PURIFICACION",
				"MARIA CRISTINA",
				"VIRGINIA",
				"MARIA LUZ",
				"FATIMA",
				"LOURDES",
				"VANESA",
				"ALEJANDRA",
				"CLARA",
				"ANNA",
				"MAGDALENA",
				"VICENTA",
				"ASUNCION",
				"MATILDE",
				"ISABEL MARIA",
				"MARIA BELEN",
				"ELISA",
				"ESTEFANIA",
				"REMEDIOS",
				"AINHOA",
				"ARACELI",
				"TRINIDAD",
				"MARIA ASUNCION",
				"MARIA PAZ",
				"ELVIRA",
				"SOLEDAD",
				"NATIVIDAD",
				"GEMA",
				"BELEN",
				"BLANCA",
				"DANIELA",
				"MARIA ESTHER",
				"MARIA LOURDES",
				"FELISA",
				"ASCENSION",
				"TAMARA",
				"VANESSA",
				"NIEVES",
				"MARIA CRUZ",
				"GEMMA",
				"PALOMA",
				"RAFAELA",
				"REBECA",
				"ALMUDENA",
				"ADELA",
				"ADRIANA",
				"MARIA INMACULADA",
				"MARIA AMPARO",
				"AMALIA"};
		return nombre[r.nextInt(nombre.length)];
		}
	public String generadorApellido(){
		String [] apellidos={
				"GARCIA",
				"GONZALEZ",
				"RODRIGUEZ",
				"FERNANDEZ",
				"LOPEZ",
				"MARTINEZ",
				"SANCHEZ",
				"PEREZ",
				"GOMEZ",
				"MARTIN",
				"JIMENEZ",
				"RUIZ",
				"HERNANDEZ",
				"DIAZ",
				"MORENO",
				"ALVAREZ",
				"ROMERO",
				"ALONSO",
				"GUTIERREZ",
				"NAVARRO",
				"TORRES",
				"DOMINGUEZ",
				"VAZQUEZ",
				"RAMOS",
				"GIL",
				"RAMIREZ",
				"SERRANO",
				"BLANCO",
				"SUAREZ",
				"MOLINA",
				"MORALES",
				"ORTEGA",
				"DELGADO",
				"CASTRO",
				"ORTIZ",
				"RUBIO",
				"MARIN",
				"SANZ",
				"IGLESIAS",
				"MEDINA",
				"GARRIDO",
				"SANTOS",
				"CASTILLO",
				"CORTES",
				"LOZANO",
				"GUERRERO",
				"CANO",
				"PRIETO",
				"MENDEZ",
				"CALVO",
				"CRUZ",
				"GALLEGO",
				"VIDAL",
				"LEON",
				"HERRERA",
				"MARQUEZ",
				"CABRERA",
				"FLORES",
				"CAMPOS",
				"VEGA",
				"DIEZ",
				"FUENTES",
				"CARRASCO",
				"CABALLERO",
				"NIETO",
				"REYES",
				"AGUILAR",
				"PASCUAL",
				"HERRERO",
				"SANTANA",
				"LORENZO",
				"HIDALGO",
				"MONTERO",
				"GIMENEZ",
				"FERRER",
				"DURAN",
				"VICENTE",
				"BENITEZ",
				"MORA",
				"SANTIAGO",
				"ARIAS",
				"VARGAS",
				"CARMONA",
				"CRESPO",
				"ROMAN",
				"PASTOR",
				"SOTO",
				"SAEZ",
				"VELASCO",
				"SOLER",
				"MOYA",
				"ESTEBAN",
				"PARRA",
				"BRAVO",
				"GALLARDO",
				"ROJAS",
				"PARDO",
				"MERINO",
				"FRANCO",
				"ESPINOSA",
				"IZQUIERDO",
				"LARA",
				"RIVAS",
				"SILVA",
				"RIVERA",
				"CASADO",
				"ARROYO",
				"REDONDO",
				"CAMACHO",
				"REY",
				"VERA",
				"OTERO",
				"LUQUE",
				"GALAN",
				"MONTES",
				"RIOS",
				"SIERRA",
				"SEGURA",
				"CARRILLO",
				"MARCOS",
				"MARTI",
				"SORIANO",
				"MENDOZA",
				"ROBLES",
				"BERNAL",
				"VILA",
				"VALERO",
				"PALACIOS",
				"EXPOSITO",
				"BENITO",
				"ANDRES",
				"VARELA",
				"PEREIRA",
				"MACIAS",
				"GUERRA",
				"HEREDIA",
				"BUENO",
				"ROLDAN",
				"MATEO",
				"VILLAR",
				"CONTRERAS",
				"MIRANDA",
				"GUILLEN",
				"MATEOS",
				"ESCUDERO",
				"AGUILERA",
				"MENENDEZ",
				"CASAS",
				"APARICIO",
				"RIVERO",
				"ESTEVEZ",
				"BELTRAN",
				"PADILLA",
				"GRACIA",
				"RICO",
				"CALDERON",
				"ABAD",
				"GALVEZ",
				"CONDE",
				"SALAS",
				"JURADO",
				"QUINTANA",
				"PLAZA",
				"ACOSTA",
				"ARANDA",
				"BLAZQUEZ",
				"ROCA",
				"BERMUDEZ",
				"COSTA",
				"MIGUEL",
				"SANTAMARIA",
				"SALAZAR",
				"GUZMAN",
				"SERRA",
				"VILLANUEVA",
				"CUESTA",
				"MANZANO",
				"TOMAS",
				"HURTADO",
				"TRUJILLO",
				"RUEDA",
				"PACHECO",
				"AVILA",
				"SIMON",
				"PONS",
				"LAZARO",
				"SANCHO",
				"MESA",
				"ESCOBAR",
				"MILLAN",
				"BLASCO",
				"ALARCON",
				"LUNA",
				"ZAMORA",
				"SALVADOR",
				"BERMEJO",
				"PAREDES",
				"ANTON",
				"BALLESTEROS",
				"VALVERDE",
				"MALDONADO",
				"BAUTISTA",
				"VALLE",
				"PONCE",
				"RODRIGO",
				"LORENTE",
				"OLIVA",
				"JUAN",
				"CORDERO",
				"MAS",
				"COLLADO",
				"MURILLO",
				"POZO",
				"CUENCA",
				"MONTOYA",
				"MARTOS",
				"CUEVAS",
				"MARCO",
				"BARROSO",
				"ROS",
				"QUESADA",
				"BARRERA",
				"ORDOʹEZ",
				"GIMENO",
				"CORRAL",
				"ALBA",
				"PUIG",
				"CABELLO",
				"PULIDO",
				"ROJO",
				"NAVAS",
				"SAIZ",
				"SORIA",
				"ARENAS",
				"AGUADO",
				"DOMINGO",
				"GALINDO",
				"VALLEJO",
				"MENA",
				"ESCRIBANO",
				"ASENSIO",
				"RAMON",
				"VALENCIA",
				"LUCAS",
				"CARO",
				"POLO",
				"AGUIRRE",
				"NARANJO",
				"MATA",
				"VILLALBA",
				"REINA",
				"PAZ",
				"AMADOR",
				"MORAN",
				"LINARES",
				"OJEDA",
				"LEAL",
				"BURGOS",
				"CHEN",
				"OLIVER",
				"CARRETERO",
				"BONILLA",
				"SOSA",
				"ROIG",
				"ARAGON",
				"CARRION",
				"CLEMENTE",
				"VILLA",
				"CASTELLANO",
				"CARRERA",
				"HERNANDO",
				"CORDOBA",
				"ROSA",
				"ANDREU",
				"CACERES",
				"CALERO",
				"CORREA",
				"MOHAMED",
				"COBO",
				"CARDENAS",
				"FERREIRA",
				"ALCARAZ",
				"JUAREZ",
				"VELAZQUEZ",
				"DOMENECH",
				"SOLA",
				"CHACON",
				"RIERA",
				"SAAVEDRA",
				"TOLEDO",
				"LLORENTE"};
		
		int n=r.nextInt(apellidos.length);
		return apellidos[n];
		}
	public int generadorDNI(){
		return r.nextInt(99999999);
		}
	public String generadorHuesped(int cantidadHuespedes){		
		ArrayList<Integer> dnis = new ArrayList<>();
		String huespedes="";
		for(int i=0;i< cantidadHuespedes; i++){
			int d=generadorDNI();
			while(dnis.contains(d)){
				d= generadorDNI();
			}
			dnis.add(d);
			String dn= ""+d;
			Calendar nacimiento = new GregorianCalendar(1900+r.nextInt(120), r.nextInt(11), r.nextInt(28));
			String nombre= generadorNombre();
			String apellido= generadorApellido();
			if (nombre.length()>=45) {
				nombre+=nombre.substring(0, 44);
			}
			if (apellido.length()>=45) {
				apellido+=apellido.substring(0, 44);
			}
			do {
				nombre+="$";
			} while (nombre.length()<45);
			do {
				apellido+="$";
			} while (apellido.length()<45);
			String auxDni="";
			for(int z = dn.length();z<8;z++){
				auxDni+=0;
			}
			String dateAux=((nacimiento.get(Calendar.DATE)+"").length()==2)?(nacimiento.get(Calendar.DATE)+""):("0"+nacimiento.get(Calendar.DATE));
			String monthAux=(((nacimiento.get(Calendar.MONTH)+1)+"").length()==2)?((nacimiento.get(Calendar.MONTH)+1)+""):("0"+(nacimiento.get(Calendar.MONTH)+1));
			huespedes+=nombre+apellido+auxDni+d+dateAux+monthAux+nacimiento.get(Calendar.YEAR)+generadorCupon(nombre,apellido)+'\n';
		}	
		return huespedes;
	}
	public String generadorHabitaciones(){
		String habitaciones="";
		
		for (int i=1;i<150;i++){
		String [] categoria= {"CLASICA","ECONOMICA","PREMIUM","SUPERIOR"};
		String [] balcon= {"true","false"};
		String detalle= "Tendria que tener "+ r.nextInt(10) +" estrellas este hotel";
		int capacidad=Math.abs(r.nextInt(10));
		habitaciones+=  i+";"+capacidad+";"+r.nextBoolean()+";"+detalle+";"+categoria[r.nextInt(4)]+'\n';
//		habitaciones+=  i+";"+3+";"+true+";"+detalle+";"+"CLASICA"+'\n';

		}
		return habitaciones;
		}
	public String generadorCupon(String nombre,String apellido){
		Calendar vencimiento=new GregorianCalendar(1970+r.nextInt(40), r.nextInt(11), r.nextInt(28));
		String dateAux=((vencimiento.get(Calendar.DATE)+"").length()==2)?(vencimiento.get(Calendar.DATE)+""):("0"+vencimiento.get(Calendar.DATE));
		String monthAux=(((vencimiento.get(Calendar.MONTH)+1)+"").length()==2)?((vencimiento.get(Calendar.MONTH)+1)+""):("0"+(vencimiento.get(Calendar.MONTH)+1));
		cupones+=dateAux+dateAux+(vencimiento.get(Calendar.YEAR))
				+ r.nextInt(9)+ r.nextInt(9)+ r.nextInt(9)+ r.nextInt(9)  + nombre + apellido+'\n'
				;
		return 	dateAux+monthAux+(vencimiento.get(Calendar.YEAR))
				+ r.nextInt(9)+ r.nextInt(9)+ r.nextInt(9)+ r.nextInt(9) + nombre + apellido+'\n'
				;
		}
	public String generadorPrecio(){
		String precio="";
		double costo= r.nextDouble()*100;

		for (int i=1;i<20;i++){
//		int capacidad=Math.abs(r.nextInt(10));
//		precio+=  capacidad +";"+ categoria[r.nextInt(4)]+";"+'\"'+costo+'\"'+'\n';
		precio+=  i +";"+ "CLASICA"+";"+'\"'+costo+'\"'+'\n';
		costo= r.nextDouble()*100;
		precio+=  i +";"+ "ECONOMICA"+";"+'\"'+costo+'\"'+'\n';
		costo= r.nextDouble()*100;
		precio+=  i +";"+ "PREMIUM"+";"+'\"'+costo+'\"'+'\n';
		costo= r.nextDouble()*100;
		precio+=  i +";"+ "SUPERIOR"+";"+'\"'+costo+'\"'+'\n';
		costo= r.nextDouble()*100;

		}
		return precio;
		}
	public String generadorProductos(int cantidadProductos){
		ArrayList<Integer> codigo = new ArrayList<>();
		String productos = "";
		for(int j=0;j<cantidadProductos;j++){
		int cod= r.nextInt(1000);
		while(codigo.contains(cod)){
			cod = r.nextInt(1000);
		}
		String descripcion ="";
		for (int i = 0; i < r.nextInt(10)+1; i++) {
			descripcion+=generadorApellido();
		}
		int precio= r.nextInt(100);
		String codAux="";
		String descripcionAux="";
		String precioAux="";
		if (descripcion.length()>=45) {
			descripcion = descripcion.substring(0, 44);
		}
		do {
			codAux+="0";
		} while ((cod+"").length() + codAux.length()<8);
		do {
			descripcionAux+="$";
		} while (descripcion.length()+descripcionAux.length()<45);
		do {
			precioAux+="0";
		} while (((precio+"").length() + precioAux.length())<8);
		productos+= codAux+cod+descripcion+descripcionAux+precioAux+precio+'\n';
		}
		return productos;
	}
	
}
