package iusacell.comisiones.vo.reportes.mensuales;

import java.util.Map;

import iusacell.comisiones.vo.ValueObject;

public class ComDiferidaRenovacionesKyhVO extends ValueObject{
	
	private String[] campos = {"cveContratoAct","rentaAct","porcDesc","porcDescAdi","cveCanal","cveEsquema",
			"plzFor","esn","numTelefono","numPagoStr","cveCobranza","origen","fechaVenta","comision"};
	
	private int[] longitudes = {5000,5000,5000,5000,5000,5000,
			5000,5000,5000,5000,5000,5000,5000,5000};
	
	private String cveContratoAct;
	private String rentaAct;
	private String porcDesc;
	private String porcDescAdi;
	private String cveCanal;
	private String cveEsquema;
	private String plzFor;
	private String esn;
	private String numTelefono;
	private String numPagoStr;
	private String cveCobranza;
	private String origen;
	private String fechaVenta;
	private String comision;
	
	public ComDiferidaRenovacionesKyhVO() {}
	
	public ComDiferidaRenovacionesKyhVO(Map<String, Object> dato) {
		this.cveContratoAct = String.valueOf(dato.get("CVE_CONTRATO_ACT"));
		this.rentaAct = String.valueOf(dato.get("RENTA_ACT"));
		this.porcDesc = String.valueOf(dato.get("PORC_DESC"));
		this.porcDescAdi = String.valueOf(dato.get("PORC_DESC_ADI"));
		this.cveCanal = String.valueOf(dato.get("CVE_CANAL"));
		this.cveEsquema = String.valueOf(dato.get("CVE_ESQUEMA"));
		this.plzFor = String.valueOf(dato.get("PLZ_FOR"));
		this.esn = String.valueOf(dato.get("ESN"));
		this.numTelefono = String.valueOf(dato.get("NUM_TELEFONO"));
		this.numPagoStr = String.valueOf(dato.get("NUM_PAGO_STR"));
		this.cveCobranza = String.valueOf(dato.get("CVE_COBRANZA"));
		this.origen = String.valueOf(dato.get("ORIGEN"));
		this.fechaVenta = String.valueOf(dato.get("FECHA_VENTA"));
		this.comision = String.valueOf(dato.get("COMISION"));
	}
	
	public String[] getCampos() {
		return campos;
	}
	public void setCampos(String[] campos) {
		this.campos = campos;
	}
	public int[] getLongitudes() {
		return longitudes;
	}
	public void setLongitudes(int[] longitudes) {
		this.longitudes = longitudes;
	}
	public String getCveContratoAct() {
		return cveContratoAct;
	}
	public void setCveContratoAct(String cveContratoAct) {
		this.cveContratoAct = cveContratoAct;
	}
	public String getRentaAct() {
		return rentaAct;
	}
	public void setRentaAct(String rentaAct) {
		this.rentaAct = rentaAct;
	}
	public String getPorcDesc() {
		return porcDesc;
	}
	public void setPorcDesc(String porcDesc) {
		this.porcDesc = porcDesc;
	}
	public String getPorcDescAdi() {
		return porcDescAdi;
	}
	public void setPorcDescAdi(String porcDescAdi) {
		this.porcDescAdi = porcDescAdi;
	}
	public String getCveCanal() {
		return cveCanal;
	}
	public void setCveCanal(String cveCanal) {
		this.cveCanal = cveCanal;
	}
	public String getCveEsquema() {
		return cveEsquema;
	}
	public void setCveEsquema(String cveEsquema) {
		this.cveEsquema = cveEsquema;
	}
	public String getPlzFor() {
		return plzFor;
	}
	public void setPlzFor(String plzFor) {
		this.plzFor = plzFor;
	}
	public String getEsn() {
		return esn;
	}
	public void setEsn(String esn) {
		this.esn = esn;
	}
	public String getNumTelefono() {
		return numTelefono;
	}
	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}
	public String getNumPagoStr() {
		return numPagoStr;
	}
	public void setNumPagoStr(String numPagoStr) {
		this.numPagoStr = numPagoStr;
	}
	public String getCveCobranza() {
		return cveCobranza;
	}
	public void setCveCobranza(String cveCobranza) {
		this.cveCobranza = cveCobranza;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(String fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	public String getComision() {
		return comision;
	}
	public void setComision(String comision) {
		this.comision = comision;
	}
	
	

}
