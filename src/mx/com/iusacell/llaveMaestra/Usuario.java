package mx.com.iusacell.llaveMaestra;

//import mx.com.iusacell.autogestion.service.email.MessageMailVO;


public class Usuario {
	
	private String usuario; 
	private String contrasenia;
	private int idAplicacion;  
	private String llaveAplicacion;
	private String ip;
	private int numeroEmpleado;
	private String llaveMaestra;
	private String token;
//	private MessageMailVO messageMailVO;
	
	/**
	 * 
	 */
	public Usuario() {
		super();
	}
	
	
	/**
	 * @param usuario
	 * @param contrasenia
	 * @param idAplicacion
	 * @param llaveAplicacion
	 * @param ip
	 * @param numeroEmpleado
	 * @param llaveMaestra
	 * @param token
	 */
	public Usuario(String usuario, String contrasenia, int idAplicacion,
			String llaveAplicacion, String ip, int numeroEmpleado,
			String llaveMaestra, String token) {
		super();
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.idAplicacion = idAplicacion;
		this.llaveAplicacion = llaveAplicacion;
		this.ip = ip;
		this.numeroEmpleado = numeroEmpleado;
		this.llaveMaestra = llaveMaestra;
		this.token = token;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public int getIdAplicacion() {
		return idAplicacion;
	}
	public void setIdAplicacion(int idAplicacion) {
		this.idAplicacion = idAplicacion;
	}
	public String getLlaveAplicacion() {
		return llaveAplicacion;
	}
	public void setLlaveAplicacion(String llaveAplicacion) {
		this.llaveAplicacion = llaveAplicacion;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getNumeroEmpleado() {
		return numeroEmpleado;
	}
	public void setNumeroEmpleado(int numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}
	public String getLlaveMaestra() {
		return llaveMaestra;
	}
	public void setLlaveMaestra(String llaveMaestra) {
		this.llaveMaestra = llaveMaestra;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
//	/**
//	 * @return Devuelve messageMailVO.
//	 */
//	public MessageMailVO getMessageMailVO() {
//		return messageMailVO;
//	}
//	/**
//	 * @param messageMailVO El messageMailVO a establecer.
//	 */
//	public void setMessageMailVO(MessageMailVO messageMailVO) {
//		this.messageMailVO = messageMailVO;
//	}
}
