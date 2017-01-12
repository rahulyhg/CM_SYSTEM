/*
 * Creado el 21/11/2014
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package iusacell.comisiones.form;

import iusacell.comisiones.vo.TablaComisionesExcelVO;

import java.util.List;

import org.apache.struts.action.ActionForm;

/**
 * @author jarredondoi
 *
 * TODO Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
public class ComisionesForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6800493609353066619L;

	private String semana;
	private String anio;
	private String periodo;
	private String contrato;
	private String anioD;
	private String periodoD;
	private String seleccionadosD;
	private String publicado;
	private String semanaD;
	private String mesD;
	private List<TablaComisionesExcelVO> listaDetalle;
	private String status;
	private String ams;
	
	public String getSemana() {
		return semana;
	}
	public void setSemana(String semana) {
		this.semana = semana;
	}
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
	public String getContrato() {
		return contrato;
	}
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}
	public String getAnioD() {
		return anioD;
	}
	public void setAnioD(String anioD) {
		this.anioD = anioD;
	}
	public String getPeriodoD() {
		return periodoD;
	}
	public void setPeriodoD(String periodoD) {
		this.periodoD = periodoD;
	}
	public String getSeleccionadosD() {
		return seleccionadosD;
	}
	public void setSeleccionadosD(String seleccionadosD) {
		this.seleccionadosD = seleccionadosD;
	}
	public String getPublicado() {
		return publicado;
	}
	public void setPublicado(String publicado) {
		this.publicado = publicado;
	}
	public String getSemanaD() {
		return semanaD;
	}
	public void setSemanaD(String semanaD) {
		this.semanaD = semanaD;
	}
	public String getMesD() {
		return mesD;
	}
	public void setMesD(String mesD) {
		this.mesD = mesD;
	}
	public List<TablaComisionesExcelVO> getListaDetalle() {
		return listaDetalle;
	}
	public void setListaDetalle(List<TablaComisionesExcelVO> listaDetalle) {
		this.listaDetalle = listaDetalle;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAms() {
		return ams;
	}
	public void setAms(String ams) {
		this.ams = ams;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
}
