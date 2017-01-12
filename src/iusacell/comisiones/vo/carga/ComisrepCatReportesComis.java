/*
 * Creado el 10/03/2015
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package iusacell.comisiones.vo.carga;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jarredondoi
 *
 * TODO Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
public class ComisrepCatReportesComis {
	
	private Integer idReportes;
	private String reporteDescripcion;
	private Integer idCanal;
	private Integer periocidad;
	private String columnas;
	private String columOrd;
	private Integer numColumnas;
	private String columDate;
	private String idArchivo;
	private String numInsert;
	private Set<String> columDateHas;
	
	/**
	 * 
	 */
	public ComisrepCatReportesComis() {
	}

	
	/**
	 * @return Devuelve columDate.
	 */
	public String getColumDate() {
		return columDate;
	}
	/**
	 * @param columDate El columDate a establecer.
	 */
	public void setColumDate(String columDate) {
		this.columDate = columDate;
	}
	/**
	 * @return Devuelve columnas.
	 */
	public String getColumnas() {
		return columnas;
	}
	/**
	 * @param columnas El columnas a establecer.
	 */
	public void setColumnas(String columnas) {
		this.columnas = columnas;
	}
	/**
	 * @return Devuelve idCanal.
	 */
	public Integer getIdCanal() {
		return idCanal;
	}
	/**
	 * @param idCanal El idCanal a establecer.
	 */
	public void setIdCanal(Integer idCanal) {
		this.idCanal = idCanal;
	}
	/**
	 * @return Devuelve idReportes.
	 */
	public Integer getIdReportes() {
		return idReportes;
	}
	/**
	 * @param idReportes El idReportes a establecer.
	 */
	public void setIdReportes(Integer idReportes) {
		this.idReportes = idReportes;
	}
	/**
	 * @return Devuelve numColumnas.
	 */
	public Integer getNumColumnas() {
		return numColumnas;
	}
	/**
	 * @param numColumnas El numColumnas a establecer.
	 */
	public void setNumColumnas(Integer numColumnas) {
		this.numColumnas = numColumnas;
	}
	/**
	 * @return Devuelve periocidad.
	 */
	public Integer getPeriocidad() {
		return periocidad;
	}
	/**
	 * @param periocidad El periocidad a establecer.
	 */
	public void setPeriocidad(Integer periocidad) {
		this.periocidad = periocidad;
	}
	/**
	 * @return Devuelve reporteDescripcion.
	 */
	public String getReporteDescripcion() {
		return reporteDescripcion;
	}
	/**
	 * @param reporteDescripcion El reporteDescripcion a establecer.
	 */
	public void setReporteDescripcion(String reporteDescripcion) {
		this.reporteDescripcion = reporteDescripcion;
	}
	
	public String getIdArchivo() {
		return idArchivo;
	}
	public void setIdArchivo(String idArchivo) {
		this.idArchivo = idArchivo;
	}
	
	public Set<String> getColumDateHas() {
		if(this.columDateHas == null && columDate!= null){
			Set<String> col = new HashSet<String>();
			String[] dates = columDate.split(",");
			for (int i = 0; i < dates.length; i++) {
				col.add(dates[i]);
				
			}
			this.columDateHas = col;
		}
		return columDateHas;
	}
	public void setColumDateHas(Set<String> columDateHas) {
		this.columDateHas = columDateHas;
	}
	public String getColumOrd() {
		if(this.columOrd == null && columnas != null && columnas != "" && numColumnas != null){
			StringBuffer colum = new StringBuffer();
			String[] cols = new String[numColumnas.intValue()];
			String[] datos = columnas.split(",");
			for (int i = 0; i < datos.length; i++) {
				String[] dat = datos[i].split("::");
				int key = Integer.valueOf(dat[0]).intValue()-1;
				cols[key] = dat[1];
			}
			for (int i = 0; i < cols.length; i++) {
				String dat = cols[i];
				colum.append(",").append(dat);
			}
			colum = colum.toString().equals("")?colum:new StringBuffer(colum.substring(1));
			this.columOrd = colum.toString();
		}
		return columOrd;
	}
	public void setColumOrd(String columOrd) {
		this.columOrd = columOrd;
	}
	public String getNumInsert() {
		if(this.numInsert ==null && numColumnas != null){
			StringBuffer res = new StringBuffer();
			for (int i = 0; i < numColumnas.intValue()-2; i++) {
				res.append("?, ");
			}
			res.append("SYSDATE,?");
			this.numInsert = res.toString();
		}
		return numInsert;
	}
	public void setNumInsert(String numInsert) {
		this.numInsert = numInsert;
	}
}
