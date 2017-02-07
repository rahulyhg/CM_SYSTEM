/*
 * Creado el 21/11/2014
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package iusacell.comisiones.form;

import org.apache.struts.action.ActionForm;

/**
 * @author jarredondoi
 *
 * TODO Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
public class ComisionesReportesForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 156418645348651513L;
	private String anio; 
	private String periodo;
	private String mesPeriodo;
	private String semMes;
	private String mesSemana;
	private String tipoMes;
	private String tipoSemana;
	private String go;
	private String semana;
	
	public String getAnio() {
		return anio;
	}
	public void setAnio(String anio) {
		this.anio = anio;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public String getMesPeriodo() {
		return mesPeriodo;
	}
	public void setMesPeriodo(String mesPeriodo) {
		this.mesPeriodo = mesPeriodo;
	}
	public String getSemMes() {
		return semMes;
	}
	public void setSemMes(String semMes) {
		this.semMes = semMes;
	}
	public String getMesSemana() {
		return mesSemana;
	}
	public void setMesSemana(String mesSemana) {
		this.mesSemana = mesSemana;
	}
	public String getTipoMes() {
		return tipoMes;
	}
	public void setTipoMes(String tipoMes) {
		this.tipoMes = tipoMes;
	}
	public String getTipoSemana() {
		return tipoSemana;
	}
	public void setTipoSemana(String tipoSemana) {
		this.tipoSemana = tipoSemana;
	}
	public String getGo() {
		return go;
	}
	public void setGo(String go) {
		this.go = go;
	}
	public String getSemana() {
		return semana;
	}
	public void setSemana(String semana) {
		this.semana = semana;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
}
