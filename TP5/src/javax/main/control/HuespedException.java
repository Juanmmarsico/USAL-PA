package javax.main.control;

import javax.main.model.Huesped;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class HuespedException extends Exception{

	long DNI;
	public HuespedException(long dNI) {
		DNI = dNI;
	}
	
	public double getDNI() {
		return DNI;
	}

	public Huesped crearHuesped(String nombre,String apellido,Calendar nacimiento) {
		String dateAux=((nacimiento.get(Calendar.DATE)+"").length()==2)?(nacimiento.get(Calendar.DATE)+""):("0"+nacimiento.get(Calendar.DATE));
		String monthAux=(((nacimiento.get(Calendar.MONTH)+1)+"").length()==2)?((nacimiento.get(Calendar.MONTH)+1)+""):("0"+(nacimiento.get(Calendar.MONTH)+1));
		String dn= ""+DNI;

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
		String	huespedes = nombre+apellido+DNI+dateAux+monthAux+nacimiento.get(Calendar.YEAR)+'\n';
		try {
			FileWriter hues = new FileWriter(new File("./Files/huespedes"),true);
			hues.write(huespedes);
			hues.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	return new Huesped(nombre, apellido, DNI, nacimiento);	 
	}

	
}
