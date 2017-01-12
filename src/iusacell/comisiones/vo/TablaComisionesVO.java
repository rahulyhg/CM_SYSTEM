/*
 * Creado el 23/04/2013
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package iusacell.comisiones.vo;

/**
 * @author JVEGAT
 *
 * TODO Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
public class TablaComisionesVO {
	
	private String claveDistribuidor;
	private String descDistribuidor;
	private String activacionesCantidad;
	private String activacionesMonto;
	private String renovacionesCantidad;
	private String renovacionesMonto;
	private String totalesCantidad;
	private String totalesMonto;
	private String status;
	private String sem;
	
	public TablaComisionesVO(){
		
	}
	
	public TablaComisionesVO(String claveDistribuidor, String descDistribuidor,String activacionesCantidad,
			String activacionesMonto,String renovacionesCantidad,String renovacionesMonto,String totalesCantidad,
			String totalesMonto,String status){
		
		this.claveDistribuidor = claveDistribuidor;
		this.descDistribuidor = descDistribuidor;
		this.activacionesCantidad = activacionesCantidad;
		this.activacionesMonto = activacionesMonto;
		this.renovacionesCantidad = renovacionesCantidad;
		this.renovacionesMonto = renovacionesMonto;
		this.totalesCantidad = totalesCantidad;
		this.totalesMonto = totalesMonto;
		this.status = status;
		
	}
	
	
	/**
	 * @return Devuelve activacionesCantidad.
	 */
	public String getActivacionesCantidad() {
		return activacionesCantidad;
	}
	/**
	 * @param activacionesCantidad El activacionesCantidad a establecer.
	 */
	public void setActivacionesCantidad(String activacionesCantidad) {
		this.activacionesCantidad = activacionesCantidad;
	}
	/**
	 * @return Devuelve activacionesMonto.
	 */
	public String getActivacionesMonto() {
		return activacionesMonto;
	}
	/**
	 * @param activacionesMonto El activacionesMonto a establecer.
	 */
	public void setActivacionesMonto(String activacionesMonto) {
		this.activacionesMonto = activacionesMonto;
	}
	/**
	 * @return Devuelve claveDistribuidor.
	 */
	public String getClaveDistribuidor() {
		return claveDistribuidor;
	}
	/**
	 * @param claveDistribuidor El claveDistribuidor a establecer.
	 */
	public void setClaveDistribuidor(String claveDistribuidor) {
		this.claveDistribuidor = claveDistribuidor;
	}
	/**
	 * @return Devuelve descDistribuidor.
	 */
	public String getDescDistribuidor() {
		return descDistribuidor;
	}
	/**
	 * @param descDistribuidor El descDistribuidor a establecer.
	 */
	public void setDescDistribuidor(String descDistribuidor) {
		this.descDistribuidor = descDistribuidor;
	}
	/**
	 * @return Devuelve renovacionesCantidad.
	 */
	public String getRenovacionesCantidad() {
		return renovacionesCantidad;
	}
	/**
	 * @param renovacionesCantidad El renovacionesCantidad a establecer.
	 */
	public void setRenovacionesCantidad(String renovacionesCantidad) {
		this.renovacionesCantidad = renovacionesCantidad;
	}
	/**
	 * @return Devuelve renovacionesMonto.
	 */
	public String getRenovacionesMonto() {
		return renovacionesMonto;
	}
	/**
	 * @param renovacionesMonto El renovacionesMonto a establecer.
	 */
	public void setRenovacionesMonto(String renovacionesMonto) {
		this.renovacionesMonto = renovacionesMonto;
	}
	/**
	 * @return Devuelve totalesCantidad.
	 */
	public String getTotalesCantidad() {
		return totalesCantidad;
	}
	/**
	 * @param totalesCantidad El totalesCantidad a establecer.
	 */
	public void setTotalesCantidad(String totalesCantidad) {
		this.totalesCantidad = totalesCantidad;
	}
	/**
	 * @return Devuelve totalesMonto.
	 */
	public String getTotalesMonto() {
		return totalesMonto;
	}
	/**
	 * @param totalesMonto El totalesMonto a establecer.
	 */
	public void setTotalesMonto(String totalesMonto) {
		this.totalesMonto = totalesMonto;
	}
	/**
	 * @return Devuelve status.
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status El status a establecer.
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	public void setSem(String sem) {
		this.sem = sem;
	}

	public String getSem() {
		return sem;
	}
}