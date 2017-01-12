/*
 * Created on 10/12/2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package mx.com.iusacell.comisiones.web.seguridad.struts.action;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
/**
 * @author EHERNANDEZH
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class LoginForm extends ActionForm{
	
	
	
	String ncCveUnica;
	String veNomCompleto;
	String monto;
	String distribuidor;
	String periodo;
	String grupo;
	String concepto;
	String clave;
	String esquemaInt;
	String semana;
	String paquete;
	String nombrePaquete;
	String periodoExaminar;
	String usuario;
	String password;
	String pass;
	String integrador;
	
	String esquema;
	String movimientos;
	String montoPagar;
	
	
	private FormFile reclamacionFile;
	protected String filePath;
	
	//Empty Constructor
	public LoginForm() {
	}
	
	//Real Constructor
	public LoginForm(String ncCveUnica, String veNomCompleto,String monto, String distribuidor, String periodo, String grupo, String concepto, String clave, String paquete,String semana,String esquemaInt) {
		setNcCveUnica(ncCveUnica);
		setVeNomCompleto(veNomCompleto);
		setMonto(monto);
		setDistribuidor(distribuidor);
		setPeriodo(periodo);
		setGrupo(grupo);
		setConcepto(concepto);
		setClave(clave);
		setSemana(semana);
		setEsquemaInt(esquemaInt);
		setPaquete(paquete);
	}

	//Setters and Getters

	/**
	 * @return
	 */
	public FormFile getReclamacionFile() {
		return reclamacionFile;
	}

	/**
	 * @param file
	 */
	public void setReclamacionFile(FormFile file) {
		reclamacionFile = file;
	}	
	/**
	 * @return Returns the monto.
	 */
	public String getMonto() {
		return monto;
	}
	/**
	 * @param monto The monto to set.
	 */
	public void setMonto(String monto) {
		this.monto = monto;
	}
	/**
	 * @return Returns the ncCveUnica.
	 */
	public String getNcCveUnica() {
		return ncCveUnica;
	}
	/**
	 * @param ncCveUnica The ncCveUnica to set.
	 */
	public void setNcCveUnica(String ncCveUnica) {
		this.ncCveUnica = ncCveUnica;
	}
	/**
	 * @return Returns the veNomCompleto.
	 */
	public String getVeNomCompleto() {
		return veNomCompleto;
	}
	/**
	 * @param veNomCompleto The veNomCompleto to set.
	 */
	public void setVeNomCompleto(String veNomCompleto) {
		this.veNomCompleto = veNomCompleto;
	}
	
	/**
	 * Metodo que devuelve el objeto en una cadena
	 * @return 
	 */
	public String toString(){
		StringBuffer result = new StringBuffer();
		result.append("[");
		result.append(" ncCveUnica = " + getNcCveUnica() + ",");
		result.append(" veNomCompleto = " + getVeNomCompleto() + ",");
		result.append(" monto = " + getMonto() + ",");
		result.append("]");
		return result.toString();
	}
	/**Limpiar 
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		ncCveUnica = ""; //pk
		veNomCompleto = "";
		monto = "";
		
	}
	
	/**
	 * @return
	 */
	public String getDistribuidor() {
		return distribuidor;
	}

	/**
	 * @param string
	 */
	public void setDistribuidor(String string) {
		distribuidor = string;
	}

	/**
	 * @return
	 */
	public String getPeriodo() {
		return periodo;
	}

	/**
	 * @param string
	 */
	public void setPeriodo(String string) {
		periodo = string;
	}

	/**
	 * @return
	 */
	public String getConcepto() {
		return concepto;
	}

	/**
	 * @return
	 */
	public String getGrupo() {
		return grupo;
	}

	/**
	 * @param string
	 */
	public void setConcepto(String string) {
		concepto = string;
	}

	/**
	 * @param string
	 */
	public void setGrupo(String string) {
		grupo = string;
	}

	/**
	 * @return
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * @param string
	 */
	public void setClave(String string) {
		clave = string;
	}

	/**
	 * @return
	 */
	public String getPaquete() {
		return paquete;
	}

	/**
	 * @param string
	 */
	public void setPaquete(String string) {
		paquete = string;
	}

	/**
	 * @return
	 */
	public String getNombrePaquete() {
		return nombrePaquete;
	}

	/**
	 * @param string
	 */
	public void setNombrePaquete(String string) {
		nombrePaquete = string;
	}

	/**
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return
	 */
	public String getPeriodoExaminar() {
		return periodoExaminar;
	}

	/**
	 * @return
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param string
	 */
	public void setPassword(String string) {
		password = string;
	}

	/**
	 * @param string
	 */
	public void setPeriodoExaminar(String string) {
		periodoExaminar = string;
	}

	/**
	 * @param string
	 */
	public void setUsuario(String string) {
		usuario = string;
	}

	/**
	 * @return
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * @param string
	 */
	public void setPass(String string) {
		pass = string;
	}


	/**
	 * @return
	 */
	public String getSemana() {
		return semana;
	}

	/**
	 * @param string
	 */
	public void setSemana(String string) {
		semana = string;
	}
	
	
		/**
	 * @return
	 */
	public String getEsquemaInt() {
		return esquemaInt;
	}

	/**
	 * @param string
	 */
	public void setEsquemaInt(String string) {
		esquemaInt = string;
	}
	

	/**
	 * @return
	 */
	public String getIntegrador() {
		return integrador;
	}

	/**
	 * @param string
	 */
	public void setIntegrador(String string) {
		integrador = string;
	}

	/**
	 * @return
	 */
	public String getEsquema() {
		return esquema;
	}

	/**
	 * @return
	 */
	public String getMontoPagar() {
		return montoPagar;
	}

	/**
	 * @return
	 */
	public String getMovimientos() {
		return movimientos;
	}

	/**
	 * @param string
	 */
	public void setEsquema(String string) {
		esquema = string;
	}

	/**
	 * @param string
	 */
	public void setMontoPagar(String string) {
		montoPagar = string;
	}

	/**
	 * @param string
	 */
	public void setMovimientos(String string) {
		movimientos = string;
	}

}


