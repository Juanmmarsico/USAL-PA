package javax.main.model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Cupon {
	
private static int id=0;
private Calendar vencimiento;
private double total;


public Cupon(int id, Calendar vencimiento, double total) {
	id++;
	this.vencimiento = vencimientoGenerator(vencimiento);
	this.total = total;
}

public Cupon(Calendar vencimiento, double total) {
	this.vencimiento = vencimientoGenerator(vencimiento);
	this.total = total;
	id++;
}

private Calendar vencimientoGenerator(Calendar venc) {
	// TODO Auto-generated method stub
	return new GregorianCalendar(venc.get(Calendar.YEAR)+1,venc.get(Calendar.MONTH) , venc.get(Calendar.DATE));
}
public Cupon() {	
	// TODO Auto-generated constructor stub
	id++;
}
public int getId() {
	return id;
}
public Calendar getVencimiento() {
	return vencimiento;
}
public double getTotal() {
	return total;
}

public void setVencimiento(Calendar vencimiento) {
	this.vencimiento = vencimiento;
}
public void setTotal(double total) {
	this.total = total;
}

@Override
public String toString() {
	return vencimiento.get(Calendar.DATE)+"/"+(vencimiento.get(Calendar.MONTH)+1)+"/"+(vencimiento.get(Calendar.YEAR)-1)
			+"|" + vencimiento.get(Calendar.DATE)+"/"+(vencimiento.get(Calendar.MONTH)+1)+"/"+(vencimiento.get(Calendar.YEAR))
			+ "|" + total 
			;
}
public String toStringToWrite() {
	return  vencimiento.get(Calendar.DATE)+"/"+(vencimiento.get(Calendar.MONTH)+1)+"/"+(vencimiento.get(Calendar.YEAR))
			+ "|" + total 
			;
}

}
