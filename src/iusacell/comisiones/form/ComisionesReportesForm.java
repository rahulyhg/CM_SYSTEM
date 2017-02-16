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
	private String tipoReporteMes;
	private String tipoReporteSemana;
	
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
	public void setTipoReporteMes(String tipoReporteMes) {
		switch(new Integer(tipoMes))
		{
			case 1: this.tipoReporteMes = "ACTIVACIONES"; break;
			case 2: this.tipoReporteMes = "RENOVACIONES"; break;
			case 3: this.tipoReporteMes = "CHARGE_BACK_POSPAGO"; break;
			case 4: this.tipoReporteMes = "CHARGE_BACK_RENOV_POSPAGO"; break;
			case 5: this.tipoReporteMes = "COM_DIFERIDA_ACTIVACIONES_KYH"; break; 
			case 6: this.tipoReporteMes = "COM_DIFERIDA_RENOVACIONES_KYH"; break;   
			case 7: this.tipoReporteMes = "DESCUENTOS_MULTILINEA"; break;
			case 8: this.tipoReporteMes = "DESCUENTOS_ADICIONAL"; break;
			case 9: this.tipoReporteMes = "DCTOS_MULTILINEA_TOTALES"; break;
			case 10: this.tipoReporteMes = "DCTOS_ADICIONAL_TOTALES"; break;
			case 11: this.tipoReporteMes = "PREPAGO_EQ_NUEVO"; break;
			case 12: this.tipoReporteMes = "PREPAGO_EQ_CAJON"; break;
			case 13: this.tipoReporteMes = "COBRANZA"; break;
			case 14: this.tipoReporteMes = "CAES_ARSA"; break;
			case 15: this.tipoReporteMes = "ADONS"; break;
			case 16: this.tipoReporteMes = "MOVIMIENTOS_ADONS"; break;
			case 17: this.tipoReporteMes = "BAJAS_ADMINISTRATIVAS"; break;
			case 18: this.tipoReporteMes = "REPORTE_RESIDUALES"; break;

		}	
		
	}
	public String getTipoReporteMes() {
		return tipoReporteMes;
	}
	public void setTipoReporteSemana(String tipoReporteSemana) {
		switch(new Integer(tipoSemana))
		{
			case 1: this.tipoReporteSemana = "ACTIVACIONES"; break;
			case 2: this.tipoReporteSemana = "RENOVACIONES"; break;
			case 3: this.tipoReporteSemana = "BAJAS_ACTIVACIONES"; break;
			case 4: this.tipoReporteSemana = "BAJAS_RENOVACIONES"; break;
			case 5: this.tipoReporteSemana = "COBRANZA"; break; 
			case 6: this.tipoReporteSemana = "PREPAGO"; break;   
			case 7: this.tipoReporteSemana = "REPORTE_PORTABILIDAD"; break;
		}	
		
	}
	public String getTipoReporteSemana() {
		return tipoReporteSemana;
	}
	
}
