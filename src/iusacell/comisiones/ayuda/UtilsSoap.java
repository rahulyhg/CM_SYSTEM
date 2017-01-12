/*
 * Created on 8/10/2009
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package iusacell.comisiones.ayuda;

import java.util.StringTokenizer;

/**
 * @author hb
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class UtilsSoap {

	public static int convertBooleanToNumber(boolean blnValor){
		int intReturn = 0;
		try{
			if(blnValor)
				intReturn = 1;
			else
				intReturn = 0;
		}catch(Exception exc){
			intReturn = 0;
		}
		return intReturn;
	}
	
	public static boolean convertNumberToBoolean(int number){
		boolean blnReturn = false;
		try{
			if(number==1)
				blnReturn = true;
			else
				blnReturn = false;
		}catch(Exception exc){
			blnReturn = false;
		}
		return blnReturn;
	}
	
	public static String  recortarCadena(String cadena ,int numeroDigitosInicio ,int numeroDigitosInicioFin){
		return cadena.substring(4,10);
	}
	/**
	 * rellena con ceros a la izquierda  (es necesario especificar el numero de posiiciones a rellenar(numeroDigitosRelleno)) 
	 * @param numero
	 * @param numeroDigitosRelleno (numero  de digitos a rellenar)
	 * @return
	 */
	public static String  rellenarIzquierdaConCeros(int numero,int numeroDigitosRelleno ){
		StringBuffer cadenaConCeros = new StringBuffer();
		String cadena = String.valueOf(numero);
		for(int i=cadena.length();i<numeroDigitosRelleno;i++){
			cadenaConCeros.append("0");
		}
		cadenaConCeros.append(numero);
		return cadenaConCeros.toString();
	}
	
	/**
	 * rellena  con ceros ala izquierda a 10 posiciones por default
	 * @param numero
	 * @return cadena  con ceros a la izquierda
	 */
	public static String  rellenarIzquierdaConCeros(long numero){
		StringBuffer cadenaConCeros = new StringBuffer();
		String cadena = String.valueOf(numero);
		for(int i=cadena.length();i<10;i++){
			cadenaConCeros.append("0");
		}
		cadenaConCeros.append(numero);
		return cadenaConCeros.toString();
	}
	
	public static String  rellenarIzquierdaConCeros(String numero){
		StringBuffer cadenaConCeros = new StringBuffer();
		String cadena = String.valueOf(numero);
		for(int i=cadena.length();i<10;i++){
			cadenaConCeros.append("0");
		}
		cadenaConCeros.append(numero);
		return cadenaConCeros.toString();
	}
	
	public static boolean convertStringtoBoolean(String valor){
		if(valor!=null && valor.trim().length()>0 && valor.equals("on"))
			return true;
		else if(valor!=null && valor.trim().length()>0 && valor.equals("1"))
			return true;
		else if(valor!=null && valor.trim().length()>0 && valor.equals("true"))
			return true;
		else
			return false;
	}
	
	public static String[] split(String cadena, String separador){
		StringTokenizer st = new StringTokenizer(cadena, separador);
		String[] split = new String[st.countTokens()];
		int i=0;
		while(st.hasMoreTokens()){
			split[i] = st.nextToken();
			i++;
		}
		return split;
	}
	
	public static boolean isEmpty(String string){
		
		if(string != null){
			if(string.trim().length() > 0){
				return false;
			}
		}
		return true;
	}
	
}
