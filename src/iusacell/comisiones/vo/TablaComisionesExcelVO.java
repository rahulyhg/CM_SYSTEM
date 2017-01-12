/*
 * Creado el 23/04/2013
 *
 * Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package iusacell.comisiones.vo;


/**
 * 
 * @author jarredondoi
 *
 * Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
public class TablaComisionesExcelVO extends ValueObject {
	
	private String[] campos = {"cveCanal","mesActiv", "semanaVenta", "contrato", "esn", "telefono",
			"fechaActiv", "plazo", "comision", "renta", "descMultimedia", "descAdicional"};

	public String[] headerReporte = {"Clave Canal","Mes Activ", "Semana Venta", "Contrato", "ESN", "Telefono",
			"Fecha Activ", "Plazo", "Comision", "Renta", "Desc Multimedia", "Desc Adicional"};

	public int[] width = {5000,5000, 5000, 5000, 5000, 5000,
			5000, 5000, 5000, 5000, 5000, 5000};

	public int[] longitudes;
	
	public String cveCanal;
	public String mesActiv;
	public String semanaVenta;
	public String contrato;
	public String esn;
	public String telefono;
	public String fechaActiv;
	public String plazo;
	public String comision;
	public String renta;
	public String descMultimedia;
	public String descAdicional;
	
	
	
	private String[] campos1 = {"cdgCia","numTransaccion", "tipoTransaccion", "numContrato", "cdgRregion", "cdgCsi",
			"pcCveCanal", "pcCveEsquema", "pcActivMes", "pcSemanaVenta", "pcNivel", "pcMonto","pcMontoBono", 
			"pcTipoCalcComis", "pcTipoInsert", "pcTipoCalc", "pcCveGpo", "pcStatus", "pcFactura", "pcFacturaMes"};

	public String[] headerReporte1 = {"cdgCia","numTransaccion", "tipoTransaccion", "numContrato", "cdgRregion", "cdgCsi",
			"pcCveCanal", "pcCveEsquema", "pcActivMes", "pcSemanaVenta", "pcNivel", "pcMonto","pcMontoBono", 
			"pcTipoCalcComis", "pcTipoInsert", "pcTipoCalc", "pcCveGpo", "pcStatus", "pcFactura", "pcFacturaMes"};

	public int[] width1 = {5000, 5000, 5000, 5000, 5000, 5000,
			5000, 5000, 5000, 5000, 5000, 5000,5000, 
			5000, 5000, 5000, 5000, 5000, 5000, 5000};
	
//	public String cdgCia;
//	public String numTransaccion;
//	public String tipoTransaccion;
//	public String numContrato;
//	public String cdgRregion;
//	public String cdgCsi;
//	public String pcCveCanal;
//	public String pcCveEsquema;
//	public String pcActivMes;
//	public String pcSemanaVenta;
//	public String pcNivel;
//	public String pcMonto;
//	public String pcMontoBono;
//	public String pcTipoCalcComis;
//	public String pcTipoInsert;
//	public String pcTipoCalc;
//	public String pcCveGpo;
//	public String pcStatus;
//	public String pcFactura;
//	public String pcFacturaMes;
	
	/**
	 * @return Devuelve campos.
	 */
	public String[] getCampos() {
		return campos;
	}
	/**
	 * @param campos El campos a establecer.
	 */
	public void setCampos(String[] campos) {
		this.campos = campos;
	}
	/**
	 * @return Devuelve headerReporte.
	 */
	public String[] getHeaderReporte() {
		return headerReporte;
	}
	/**
	 * @param headerReporte El headerReporte a establecer.
	 */
	public void setHeaderReporte(String[] headerReporte) {
		this.headerReporte = headerReporte;
	}
	/**
	 * @return Devuelve longitudes.
	 */
	public int[] getLongitudes() {
		return longitudes;
	}
	/**
	 * @param longitudes El longitudes a establecer.
	 */
	public void setLongitudes(int[] longitudes) {
		this.longitudes = longitudes;
	}
	/**
	 * @return Devuelve width.
	 */
	public int[] getWidth() {
		return width;
	}
	/**
	 * @param width El width a establecer.
	 */
	public void setWidth(int[] width) {
		this.width = width;
	}
	/**
	 * @return Devuelve comision.
	 */
	public String getComision() {
		return comision;
	}
	/**
	 * @param comision El comision a establecer.
	 */
	public void setComision(String comision) {
		this.comision = comision;
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
	 * @return Devuelve cveCanal.
	 */
	public String getCveCanal() {
		return cveCanal;
	}
	/**
	 * @param cveCanal El cveCanal a establecer.
	 */
	public void setCveCanal(String cveCanal) {
		this.cveCanal = cveCanal;
	}
	/**
	 * @return Devuelve descAdicional.
	 */
	public String getDescAdicional() {
		return descAdicional;
	}
	/**
	 * @param descAdicional El descAdicional a establecer.
	 */
	public void setDescAdicional(String descAdicional) {
		this.descAdicional = descAdicional;
	}
	/**
	 * @return Devuelve descMultimedia.
	 */
	public String getDescMultimedia() {
		return descMultimedia;
	}
	/**
	 * @param descMultimedia El descMultimedia a establecer.
	 */
	public void setDescMultimedia(String descMultimedia) {
		this.descMultimedia = descMultimedia;
	}
	/**
	 * @return Devuelve esn.
	 */
	public String getEsn() {
		return esn;
	}
	/**
	 * @param esn El esn a establecer.
	 */
	public void setEsn(String esn) {
		this.esn = esn;
	}
	/**
	 * @return Devuelve fechaActiv.
	 */
	public String getFechaActiv() {
		return fechaActiv;
	}
	/**
	 * @param fechaActiv El fechaActiv a establecer.
	 */
	public void setFechaActiv(String fechaActiv) {
		this.fechaActiv = fechaActiv;
	}
	/**
	 * @return Devuelve mesActiv.
	 */
	public String getMesActiv() {
		return mesActiv;
	}
	/**
	 * @param mesActiv El mesActiv a establecer.
	 */
	public void setMesActiv(String mesActiv) {
		this.mesActiv = mesActiv;
	}
	/**
	 * @return Devuelve plazo.
	 */
	public String getPlazo() {
		return plazo;
	}
	/**
	 * @param plazo El plazo a establecer.
	 */
	public void setPlazo(String plazo) {
		this.plazo = plazo;
	}
	/**
	 * @return Devuelve renta.
	 */
	public String getRenta() {
		return renta;
	}
	/**
	 * @param renta El renta a establecer.
	 */
	public void setRenta(String renta) {
		this.renta = renta;
	}
	/**
	 * @return Devuelve semanaVenta.
	 */
	public String getSemanaVenta() {
		return semanaVenta;
	}
	/**
	 * @param semanaVenta El semanaVenta a establecer.
	 */
	public void setSemanaVenta(String semanaVenta) {
		this.semanaVenta = semanaVenta;
	}
	/**
	 * @return Devuelve telefono.
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * @param telefono El telefono a establecer.
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public void setCampos1(String[] campos1) {
		this.campos1 = campos1;
	}
	public String[] getCampos1() {
		return campos1;
	}
}

