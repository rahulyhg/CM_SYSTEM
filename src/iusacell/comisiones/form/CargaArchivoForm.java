/*
 * Creado el 24/02/2015
 *
 * Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package iusacell.comisiones.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

/**
 * @author jarredondoi
 *
 * Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
public class CargaArchivoForm extends ActionForm{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3287473952277993382L;
	private FormFile archivo;
	private String idTipoArchivo;
	private String descTipoArchivo;
	private int pag;
	private int accion;
	private String fecha;
	private int idArchivo;
	private String descArchivo;
	private String go;
	private String perfil;
	
	
	
	/**
	 * @return Devuelve archivo.
	 */
	public FormFile getArchivo() {
		return archivo;
	}
	/**
	 * @param archivo El archivo a establecer.
	 */
	public void setArchivo(FormFile archivo) {
		this.archivo = archivo;
	}
	/**
	 * @return Devuelve idTipoArchivo.
	 */
	public String getIdTipoArchivo() {
		return idTipoArchivo;
	}
	/**
	 * @param idTipoArchivo El idTipoArchivo a establecer.
	 */
	public void setIdTipoArchivo(String idTipoArchivo) {
		this.idTipoArchivo = idTipoArchivo;
	}
	/**
	 * @return Devuelve pag.
	 */
	public int getPag() {
		return pag;
	}
	/**
	 * @param pag El pag a establecer.
	 */
	public void setPag(int pag) {
		this.pag = pag;
	}
	/**
	 * @return Devuelve accion.
	 */
	public int getAccion() {
		return accion;
	}
	/**
	 * @param accion El accion a establecer.
	 */
	public void setAccion(int accion) {
		this.accion = accion;
	}
	/**
	 * @return Devuelve fecha.
	 */
	public String getFecha() {
		return fecha;
	}
	/**
	 * @param fecha El fecha a establecer.
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	/**
	 * @return Devuelve idArchivo.
	 */
	public int getIdArchivo() {
		return idArchivo;
	}
	/**
	 * @param idArchivo El idArchivo a establecer.
	 */
	public void setIdArchivo(int idArchivo) {
		this.idArchivo = idArchivo;
	}
	/**
	 * @return Devuelve go.
	 */
	public String getGo() {
		return go;
	}
	/**
	 * @param go El go a establecer.
	 */
	public void setGo(String go) {
		this.go = go;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public String getDescTipoArchivo() {
		return descTipoArchivo;
	}
	public void setDescTipoArchivo(String descTipoArchivo) {
		this.descTipoArchivo = descTipoArchivo;
	}
	public String getDescArchivo() {
		return descArchivo;
	}
	public void setDescArchivo(String descArchivo) {
		this.descArchivo = descArchivo;
	}
}
