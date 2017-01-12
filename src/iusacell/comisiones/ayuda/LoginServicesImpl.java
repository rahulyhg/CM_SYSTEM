/*
 * Created on 13/08/2009
 *
 */
package iusacell.comisiones.ayuda;


import iusacell.comisiones.ayuda.ParametrosDao;

/**
 * @author DP
 */
public class LoginServicesImpl implements LoginServices {
	
	private ParametrosDao parametrosDao;
	
	public static final String CONEXION_SOAP 	 = "servicioGS";
	public static final String USERBITACORA 	 = "userBitacora";
	public static final String AVISO_MENU_RUTA	 = "avisoMenuRuta";
	public static final String USER_ADMON_IMG	 = "userAdmonImg";
	public static final String USER_ADMON_GRAL	 = "userAdmonGral";
	public static final String SERVIDOR_SMTP	 = "SMTP_SERVER";
	public static final String GRUPO_DESARROLLO_EMAIL = "GRUPO_DESARROLLO";
	
		
	/**
	 * Parametros de Conexion para GrupoSalinas 
	 * @return String
	 */
	public String getParametrosSoap() {
		return parametrosDao.getParametros(CONEXION_SOAP);
	}
	
	/**
	 * Parametros de Usuario de bitacora
	 * @return String
	 */
	public String getParametrosBitacora() {
		return parametrosDao.getParametros(USERBITACORA);
	}
	
	/**
	 * Parametros de Mensaje de aviso menú ruta
	 * @return String
	 */
	public String getParametrosAviso(){
		return parametrosDao.getParametros(AVISO_MENU_RUTA);
	}
	
	/**
	 * Parametros de Mensaje de aviso menú ruta
	 * @return String
	 */
	public String getMensajeLgn(String msgId){
		return parametrosDao.getParametros(msgId);
	}
	
	/**
	 * Parametros de Usuario de 
	 * Administrador de Imagenes
	 * @return String
	 */
	public String getUserAdmonImg(){
		return parametrosDao.getParametros(USER_ADMON_IMG);
	}
	
	
	/**
	 * Metodo que depura los usuarios para ver ciertos modulos.
	 * @return String
	 */
	public String debugUserAdmon(String userAdmon, String idEmpleado){
		String [] arreglo = userAdmon.split("\\|");
		String idUser = "";
		for(int i=0; i<arreglo.length; i++){
			if(idEmpleado.trim().equals(arreglo[i].trim()))
				idUser = arreglo[i].trim();
		}
		return idUser;
	}
	
	/**
	 * Parametros de Usuario de 
	 * Administrador General
	 * @return String
	 */
	public String getUserAdmonGral(){
		return parametrosDao.getParametros(USER_ADMON_GRAL);
	}


	
	/**
	 * @param parametrosDao The parametrosDao to set.
	 */
	public void setParametrosDao(ParametrosDao parametrosDao) {
		this.parametrosDao = parametrosDao;
	}

	/**
	 * Parametros de Conexion para GrupoSalinas 
	 * @return String
	 */
	public String getParametrosEmail() {
		return parametrosDao.getParametros(SERVIDOR_SMTP);
	}

	
	/**
	 * Correos electronicos del equipo de desarrollo 
	 * @return String
	 */
	public String getParametrosEmailAreaDesa() {
		return parametrosDao.getParametros(GRUPO_DESARROLLO_EMAIL);
	}
}
