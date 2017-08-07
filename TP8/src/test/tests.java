package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class tests {

public static void main(String [] args){
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/YYYY");

	Calendar calendar= new GregorianCalendar(1992, 11, 31);
	
	System.out.println(simpleDateFormat.format(calendar.getTime()));
}
}
