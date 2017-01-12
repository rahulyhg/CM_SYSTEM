/*
 * Creado el 23/04/2013
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package iusacell.comisiones.vo;

/**
 * 
 * @author jarredondoi
 *
 * TODO Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
public class TablaComisionesAgregarVO {
	
	public String contrato;
	public String fecha;
	public String tipoVenta;
	public String claveCanal;
	public String status;
	
	public TablaComisionesAgregarVO(){
		
	}
	
	public TablaComisionesAgregarVO(String contrato, String fecha,String tipoVenta,
			String claveCanal,String status){
		
		this.contrato = contrato;
		this.fecha = fecha;
		this.tipoVenta = tipoVenta;
		this.claveCanal = claveCanal;
		this.status = status;
		
	}
	
	
	
	/**
	 * @return Devuelve contrato.
	 */
	public String getContrato() {
		return contrato;
	}
	/**
	 * @param contrato El contrato a establecer.
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}
	/**
	 * @return Devuelve esn.
	 */
	public String getTipoVenta() {
		return tipoVenta;
	}
	/**
	 * @param esn El esn a establecer.
	 */
	public void setTipoVenta(String esn) {
		this.tipoVenta = esn;
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
	 * @return Devuelve mdn.
	 */
	public String getClaveCanal() {
		return claveCanal;
	}
	/**
	 * @param mdn El mdn a establecer.
	 */
	public void setClaveCanal(String mdn) {
		this.claveCanal = mdn;
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
}