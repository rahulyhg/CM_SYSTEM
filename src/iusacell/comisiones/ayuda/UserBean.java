/*
 * Created on 7/10/2009
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package iusacell.comisiones.ayuda;

/**
 * @author hb
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class UserBean {

	private String usuario;
	private String nombre;
	private String apellidos;
	private String compania;
	private String numEmpleado;
	private String mail;
	private String ip;
	private String respuesta;
	
	private boolean administrador;
	private String menu;
	
	public UserBean() {
		super();
	}
	public UserBean(String usuario, String nombre, String apellidos,
			String compania, String numEmpleado, String mail, String ip) {
		super();
		this.usuario = usuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.compania = compania;
		this.numEmpleado = numEmpleado;
		this.mail = mail;
		this.ip = ip;
	}
	
	public UserBean(String usuario, String nombre, String apellidos,
			String compania, String numEmpleado, String mail, String ip, String respuesta) {
		super();
		this.usuario = usuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.compania = compania;
		this.numEmpleado = numEmpleado;
		this.mail = mail;
		this.ip = ip;
		this.respuesta = respuesta;
	}
	public String toString(){
		StringBuffer sb = new StringBuffer(super.toString());
		sb.append("\n");
		sb.append("usuario =").append(this.usuario).append(",\n");
		sb.append("nombre =").append(this.nombre).append(",\n");
		sb.append("apellidos =").append(this.apellidos).append(",\n");
		sb.append("compania =").append(this.compania).append(",\n");
		sb.append("numEmpleado =").append(this.numEmpleado).append(",\n");
		sb.append("mail =").append(this.mail).append(",\n");
		sb.append("ip =").append(this.ip).append(",\n");
		sb.append("respuesta =").append(this.respuesta).append(",\n");
		sb.append("administrador =").append(this.administrador).append(",\n");
		sb.append("menu =").append(this.menu);
		return(sb.toString());
	}

	/**
	 * @return Returns the usuario.
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario The usuario to set.
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}




	/**
	 * @return the administrador
	 */
	public boolean isAdministrador() {
		return administrador;
	}

	/**
	 * @param administrador the administrador to set
	 */
	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}

	/**
	 * @return the menu.
	 */
	public String getMenu() {
		return menu;
	}

	/**
	 * @param menu the menu to set
	 */
	public void setMenu(String menu) {
		this.menu = menu;
	}

	/**
	 * @return String
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre String
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return String
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos String
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return String
	 */
	public String getCompania() {
		return compania;
	}

	/**
	 * @param compania String
	 */
	public void setCompania(String compania) {
		this.compania = compania;
	}

	/**
	 * @return String
	 */
	public String getNumEmpleado() {
		return numEmpleado;
	}

	/**
	 * @param numEmpleado String
	 */
	public void setNumEmpleado(String numEmpleado) {
		this.numEmpleado = numEmpleado;
	}

	/**
	 * @return String
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail String
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return String
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @param ip String
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * @return UsuarioBean
	 */
	public UserBean getUsuarioBean() {
		return new UserBean(
				this.usuario,
				this.nombre,
				this.apellidos,
				this.compania,
				this.numEmpleado,
				this.mail,
				this.ip);
	}
	/**
	 * @return String
	 */
	public String getRespuesta() {
		return respuesta;
	}
	/**
	 * @param respuesta String
	 */
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	
}
