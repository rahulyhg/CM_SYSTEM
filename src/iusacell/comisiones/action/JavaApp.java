/*
 * Creado el 14/08/2015
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package iusacell.comisiones.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JavaApp {

	public static void main(String[] args) {
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String dateInString = "22/09/2015";

		try {
			date = formatter.parse(dateInString);
			System.out.println(date);
			System.out.println(formatter.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Calendar cal = Calendar.getInstance();
		Calendar ini = Calendar.getInstance();
		Calendar fin = Calendar.getInstance();
		cal.setTime(date);
		ini.setTime(date);
		fin.setTime(date);
		
		int sem = cal.get(Calendar.WEEK_OF_YEAR);
		int day = cal.get(Calendar.DAY_OF_WEEK);
		
		System.out.println(sem);
		System.out.println(day);
		
		switch (day) {
		case 1:
			ini.add(Calendar.DAY_OF_YEAR,-6);
			fin.add(Calendar.DAY_OF_YEAR,0);
			System.out.println(formatter.format(ini.getTime()));
			System.out.println(formatter.format(fin.getTime()));
			break;
		case 2:
			ini.add(Calendar.DAY_OF_YEAR,0);
			fin.add(Calendar.DAY_OF_YEAR,6);
			System.out.println(formatter.format(ini.getTime()));
			System.out.println(formatter.format(fin.getTime()));
			break;
		case 3:
			ini.add(Calendar.DAY_OF_YEAR,-1);
			fin.add(Calendar.DAY_OF_YEAR,5);
			System.out.println(formatter.format(ini.getTime()));
			System.out.println(formatter.format(fin.getTime()));
			break;
		case 4:
			ini.add(Calendar.DAY_OF_YEAR,-2);
			fin.add(Calendar.DAY_OF_YEAR,4);
			System.out.println(formatter.format(ini.getTime()));
			System.out.println(formatter.format(fin.getTime()));
			break;
		case 5:
			ini.add(Calendar.DAY_OF_YEAR,-3);
			fin.add(Calendar.DAY_OF_YEAR,3);
			System.out.println(formatter.format(ini.getTime()));
			System.out.println(formatter.format(fin.getTime()));
			break;
		case 6:
			ini.add(Calendar.DAY_OF_YEAR,-4);
			fin.add(Calendar.DAY_OF_YEAR,2);
			System.out.println(formatter.format(ini.getTime()));
			System.out.println(formatter.format(fin.getTime()));
			break;
		case 7:
			ini.add(Calendar.DAY_OF_YEAR,-5);
			fin.add(Calendar.DAY_OF_YEAR,1);
			System.out.println(formatter.format(ini.getTime()));
			System.out.println(formatter.format(fin.getTime()));
			break;
		}
		
	}
}
