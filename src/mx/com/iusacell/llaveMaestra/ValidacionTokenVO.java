package mx.com.iusacell.llaveMaestra;


public class ValidacionTokenVO {
	
	private boolean auth;
	private String mensaje;
	private String cambioLlave;
	private String fechaCad;
	

	public boolean isAuth() {
		return auth;
	}
	public void setAuth(boolean auth) {
		this.auth = auth;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	/**
	 * @return Returns the cambioLlave.
	 */
	public String getCambioLlave() {
		return cambioLlave;
	}
	/**
	 * @param cambioLlave The cambioLlave to set.
	 */
	public void setCambioLlave(String cambioLlave) {
		this.cambioLlave = cambioLlave;
	}
	/**
	 * @return Returns the fechaCad.
	 */
	public String getFechaCad() {
		return fechaCad;
	}
	/**
	 * @param fechaCad The fechaCad to set.
	 */
	public void setFechaCad(String fechaCad) {
		this.fechaCad = fechaCad;
	}
}
