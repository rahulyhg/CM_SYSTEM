/*
 * Created on 13/08/2009
 *
 */
package iusacell.comisiones.ayuda;



/**
 * @author DP
 *
 */
public interface LoginServices {

	/**
	 * Parametros de Conexion para GrupoSalinas 
	 * @return String
	 */
	public String getParametrosSoap();
	
	/**
	 * Parametros de Usuario de bitacora
	 * @return String
	 */
	public String getParametrosBitacora() ;
	
	/**
	 * Parametros de Mensaje de regreso de comida
	 * @return String
	 */
	public String getParametrosAviso();
	
}
