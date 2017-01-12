/*
 * Creado el 10/03/2015
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package mx.com.iusacell.comisiones.utilerias;

import iusacell.comisiones.vo.TablaComisionesAgregarVO;
import iusacell.comisiones.vo.TablaComisionesVO;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * @author jarredondoi
 *
 * Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
public class Util {
	
	protected static final Logger logger = Logger.getLogger(Util.class);

	/**
     * Regresa un onjeto Json de una lista
     * @param objetos
     * @return
     */
    @SuppressWarnings("unchecked")
	public static final String obtenerObjetoJSON(List objetos){
		
		String elemento = "{\"tabla\":";
		try{
			
			elemento += "[";
			for(int i=0; i<objetos.size(); i++){
				Object obj = (Object)objetos.get(i);
				Class cs = obj.getClass();
				Field[] f = cs.getFields();
				elemento += "{";
					for(int j=0; j<f.length; j++){
						elemento += "\"" + f[j].getName() + "\":\"" + (f[j].get(obj)!=null ? f[j].get(obj) : "") + "\"";
						if(j != f.length-1){
							elemento += ",";
						}
					}
					elemento += "}";
		
					if(i != objetos.size()-1){
					elemento += ",";
				}
					
			}
			elemento += "]}";
			
		} catch (Exception exc) {
			System.out.println("Error en metodo obtenerEntProfPen : " + exc);
			return null;
		}
			
		 return elemento;
	}
    
    public static final Date stringToDate(String dateInString, String pattern){
    	SimpleDateFormat formatter = new SimpleDateFormat(pattern);
    	Date date = null;
    	try {
    		date = formatter.parse(dateInString);
    	} catch (ParseException e) {
    	}
    	return date;
    }
    
    public static void pasarGarbageCollector(){
		 
      Runtime garbage = Runtime.getRuntime();
      System.out.println("Memoria libre antes de limpieza: "+garbage.freeMemory());
      garbage.gc();

      System.out.println("Memoria libre tras  la limpieza: "+garbage.freeMemory());
    }
    
    /**
	 * formato yyyyMMdd
	 * 0 -> fecha inicio de la semana
	 * 1 -> fecha fin de semana 
	 * 2 -> fecha inicio del mes
	 * 3 -> fecha fin del mes
	 * 4 -> dia fin del mes
	 * 5 -> fecha fin de semana dd/MM/yyyy
	 * 6 -> semana
	 * 7 -> semana anterior
	 * @return
	 */
	public static String[] obtenerFechasInicioFin(String anio, String mes, String semana){
		
		String[] fechas = new String[9];
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			if(anio != null && !anio.equals(""))
				date = formatter2.parse("01/"+mes+"/"+anio);
		} catch (ParseException e) {
			e.printStackTrace();
			logger.error("ComisionesBOImpl",e);
		}

		logger.info(date);
		logger.info(formatter.format(date));
		
		
		Calendar cal = Calendar.getInstance();
		Calendar ini = Calendar.getInstance();
		Calendar fin = Calendar.getInstance();
		cal.setTime(date);
		ini.setTime(date);
		fin.setTime(date);
		if(semana!=null && !semana.equals("")){
			ini.set(Calendar.WEEK_OF_YEAR, Integer.valueOf(semana)+1);
			fin.set(Calendar.WEEK_OF_YEAR, Integer.valueOf(semana)+1);
		}
			 
		
		int sem = cal.get(Calendar.WEEK_OF_YEAR)-1;
		int semAnt = cal.get(Calendar.WEEK_OF_YEAR)-2;
		int day = cal.get(Calendar.DAY_OF_WEEK);
		
		logger.info("Semana: " + sem);
		logger.info("Dia: " + day);
		
		switch (day) {
		case 1:
			ini.add(Calendar.DAY_OF_YEAR,-6);
			fin.add(Calendar.DAY_OF_YEAR,0);
			fechas[0] = formatter.format(ini.getTime());
			fechas[1] = formatter.format(fin.getTime());
			fechas[5] = formatter2.format(fin.getTime());
			break;
		case 2:
			ini.add(Calendar.DAY_OF_YEAR,0);
			fin.add(Calendar.DAY_OF_YEAR,6);
			fechas[0] = formatter.format(ini.getTime());
			fechas[1] = formatter.format(fin.getTime());
			fechas[5] = formatter2.format(fin.getTime());
			break;
		case 3:
			ini.add(Calendar.DAY_OF_YEAR,-1);
			fin.add(Calendar.DAY_OF_YEAR,5);
			fechas[0] = formatter.format(ini.getTime());
			fechas[1] = formatter.format(fin.getTime());
			fechas[5] = formatter2.format(fin.getTime());
			break;
		case 4:
			ini.add(Calendar.DAY_OF_YEAR,-2);
			fin.add(Calendar.DAY_OF_YEAR,4);
			fechas[0] = formatter.format(ini.getTime());
			fechas[1] = formatter.format(fin.getTime());
			fechas[5] = formatter2.format(fin.getTime());
			break;
		case 5:
			ini.add(Calendar.DAY_OF_YEAR,-3);
			fin.add(Calendar.DAY_OF_YEAR,3);
			fechas[0] = formatter.format(ini.getTime());
			fechas[1] = formatter.format(fin.getTime());
			fechas[5] = formatter2.format(fin.getTime());
			break;
		case 6:
			ini.add(Calendar.DAY_OF_YEAR,-4);
			fin.add(Calendar.DAY_OF_YEAR,2);
			fechas[0] = formatter.format(ini.getTime());
			fechas[1] = formatter.format(fin.getTime());
			fechas[5] = formatter2.format(fin.getTime());
			break;
		case 7:
			ini.add(Calendar.DAY_OF_YEAR,-5);
			fin.add(Calendar.DAY_OF_YEAR,1);
			fechas[0] = formatter.format(ini.getTime());
			fechas[1] = formatter.format(fin.getTime());
			fechas[5] = formatter2.format(fin.getTime());
			break;
		}
		
		//fecha inicio del mes 
		Calendar iniMes = Calendar.getInstance();
		iniMes.setTime(date);
		iniMes.set(cal.get(Calendar.YEAR),
		iniMes.get(Calendar.MONTH),
		iniMes.getActualMinimum(Calendar.DAY_OF_MONTH),
		iniMes.getMinimum(Calendar.HOUR_OF_DAY),
		iniMes.getMinimum(Calendar.MINUTE),
		iniMes.getMinimum(Calendar.SECOND));
		fechas[2] = formatter.format(iniMes.getTime());
		
		//fecha fin del mes
		Calendar finMes = Calendar.getInstance();
		finMes.setTime(date);
		finMes.set(cal.get(Calendar.YEAR),
		finMes.get(Calendar.MONTH),
		finMes.getActualMaximum(Calendar.DAY_OF_MONTH),
		finMes.getMaximum(Calendar.HOUR_OF_DAY),
		finMes.getMaximum(Calendar.MINUTE),
		finMes.getMaximum(Calendar.SECOND));
		fechas[3] = formatter.format(finMes.getTime());
		fechas[4] = String.valueOf(finMes.get(Calendar.DAY_OF_MONTH));
		
		fechas[6] = String.valueOf(sem);
		fechas[7] = String.valueOf(semAnt);
		/**
		 * formato yyyyMMdd
		 * 0 -> fecha inicio de la semana
		 * 1 -> fecha fin de semana 
		 * 2 -> fecha inicio del mes
		 * 3 -> fecha fin del mes
		 * 4 -> dia fin del mes
		 * 5 -> fecha fin de semana dd/MM/yyyy
		 * 6 -> semana
		 * @return
		 */
		System.out.println("Inicio de semana(yyyyMMdd) "+fechas[0]);
		System.out.println("Fin de semana (yyyyMMdd) "+fechas[1]);
		System.out.println("Inicio de mes (yyyyMMdd) "+fechas[2]);
		System.out.println("fin de mes (yyyyMMdd) "+fechas[3]);
		System.out.println("dia fin de mes"+fechas[4]);
		System.out.println("fecha fin semana (dd/MM/yyyy) "+fechas[5]);
		System.out.println("Semana "+fechas[6]);
		System.out.println("Semana Ant"+fechas[7]);
		return fechas;
	}
	
	public static String obtenerObjetoJSONTabla(List<TablaComisionesVO> objetos, String sem){
		
		String elemento = "{\"tabla\":";
		try{
			elemento += "[";
			for(int i=0; i<objetos.size(); i++){
				TablaComisionesVO tab = objetos.get(i);
				elemento += "{";
				elemento += "\"claveDistribuidor\":\"" + tab.getClaveDistribuidor() + "\",";
				elemento += "\"descDistribuidor\":\"" + tab.getDescDistribuidor() + "\",";
				elemento += "\"activacionesCantidad\":\"" + tab.getActivacionesCantidad() + "\",";
				elemento += "\"activacionesMonto\":\"" + tab.getActivacionesMonto() + "\",";
				elemento += "\"renovacionesCantidad\":\"" + tab.getRenovacionesCantidad() + "\",";
				elemento += "\"renovacionesMonto\":\"" + tab.getRenovacionesMonto() + "\",";
				elemento += "\"totalesCantidad\":\"" + tab.getTotalesCantidad() + "\",";
				elemento += "\"totalesMonto\":\"" + tab.getTotalesMonto() + "\",";
				elemento += "\"semana\":\"" + sem + "\",";
				elemento += "\"status\":\"" + tab.getStatus() + "\"";
				elemento += "}";
				if(i != objetos.size()-1){
					elemento += ",";
				}
			}
			elemento += "]}";
		} catch (Exception exc) {
			System.out.println("Error en metodo obtenerEntProfPen : " + exc);
			return null;
		}
			
		 return elemento;
	}
	
	public static String obtenerObjetoJSONTablaAgregar(List<TablaComisionesAgregarVO> objetos, String status){
		
		String elemento = "{\"tabla\":";
		
		try{
			
			elemento += "[";
			for(int i=0; i<objetos.size(); i++){
				TablaComisionesAgregarVO tab = objetos.get(i);
				elemento += "{";
				elemento += "\"contrato\":\"" + tab.getContrato() + "\",";
				elemento += "\"fecha\":\"" + tab.getFecha() + "\",";
				elemento += "\"tipoVenta\":\"" + tab.getTipoVenta() + "\",";
				elemento += "\"claveCanal\":\"" + tab.getClaveCanal() + "\",";
				elemento += "\"status\":\"" + tab.getStatus() + "\"";
				elemento += "}";
		
				if(i != objetos.size()-1){
					elemento += ",";
				}
					
			}
			elemento += "],\"okCode\":\""+status+"\"}";
			
		} catch (Exception exc) {
			System.out.println("Error en metodo obtenerEntProfPen : " + exc);
			return null;
		}
			
		 return elemento;
	}
}
