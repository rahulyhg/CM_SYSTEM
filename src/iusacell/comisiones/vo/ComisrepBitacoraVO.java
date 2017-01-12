/*
 * Creado el 6/04/2015
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package iusacell.comisiones.vo;

import java.util.Date;

/**
 * @author jarredondoi
 *
 * TODO Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
public class ComisrepBitacoraVO {
	
	private Integer idBitacora;
	private Date fecha;
	private Integer idReporte;
	private Integer numFilas;
	private String observaciones;
	private String numEmpleado;
	private String status;
	private Integer idArchivo;
	
	

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Integer getIdBitacora() {
		return idBitacora;
	}
	public void setIdBitacora(Integer idBitacora) {
		this.idBitacora = idBitacora;
	}
	public Integer getIdReporte() {
		return idReporte;
	}
	public void setIdReporte(Integer idReporte) {
		this.idReporte = idReporte;
	}
	public String getNumEmpleado() {
		return numEmpleado;
	}
	public void setNumEmpleado(String numEmpleado) {
		this.numEmpleado = numEmpleado;
	}
	public Integer getNumFilas() {
		return numFilas;
	}
	public void setNumFilas(Integer numFilas) {
		this.numFilas = numFilas;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getIdArchivo() {
		return idArchivo;
	}
	public void setIdArchivo(Integer idArchivo) {
		this.idArchivo = idArchivo;
	}
}
