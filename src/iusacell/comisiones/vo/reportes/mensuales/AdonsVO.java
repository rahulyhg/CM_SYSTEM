package iusacell.comisiones.vo.reportes.mensuales;

import java.util.Map;

import iusacell.comisiones.vo.ValueObject;

public class AdonsVO extends ValueObject{
	
	private String[] campos = {"accessfee","csStatChng","costumerId","descripcion","diasAlta","diasBaja",
			"fecActServ","fecDesaServ","numContrato","numTelefono","comision","cuenta","cveCanal","cveConcepto",
			"cveEsquema","cvePaquete","descCanal","descLargaPlan","fechaVenta","mesPago","plzFor",
			"porcDesc","porcDescAdi","sncode"};
	
	private int[] longitudes = {5000,5000,5000,5000,5000,5000,
			5000,5000,5000,5000,5000,5000,5000,5000,
			5000,5000,5000,5000,5000,5000,5000,
			5000,5000,5000};
	
	private String accessfee;
	private String csStatChng;
	private String costumerId;
	private String descripcion;
	private String diasAlta;
	private String diasBaja;
	private String fecActServ;
	private String fecDesaServ;
	private String numContrato;
	private String numTelefono;
	private String comision;
	private String cuenta;
	private String cveCanal;
	private String cveConcepto;
	private String cveEsquema;
	private String cvePaquete;
	private String descCanal;
	private String descLargaPlan;
	private String fechaVenta;
	private String mesPago;
	private String plzFor;
	private String porcDesc;
	private String porcDescAdi;
	private String sncode;
	
	public AdonsVO() {}
	
	public AdonsVO(Map<String, Object> dato) {
		this.accessfee = String.valueOf(dato.get("ACCESSFEE"));
		this.csStatChng = String.valueOf(dato.get("CS_STAT_CHNG"));
		this.costumerId = String.valueOf(dato.get("CUSTOMER_ID"));
		this.descripcion = String.valueOf(dato.get("DESCRIPCION"));
		this.diasAlta = String.valueOf(dato.get("DIAS_ALTA"));
		this.diasBaja = String.valueOf(dato.get("DIAS_BAJA"));
		this.fecActServ = String.valueOf(dato.get("FEC_ACT_SERV"));
		this.fecDesaServ = String.valueOf(dato.get("FEC_DESA_SERV"));
		this.numContrato = String.valueOf(dato.get("NUM_CONTRATO"));
		this.numTelefono = String.valueOf(dato.get("NUM_TELEFONO"));
		this.comision = String.valueOf(dato.get("PC_COMISION"));
		this.cuenta = String.valueOf(dato.get("PC_CUENTA"));
		this.cveCanal = String.valueOf(dato.get("PC_CVE_CANAL"));
		this.cveConcepto = String.valueOf(dato.get("PC_CVE_CONCEPTO"));
		this.cveEsquema = String.valueOf(dato.get("PC_CVE_ESQUEMA"));
		this.cvePaquete = String.valueOf(dato.get("PC_CVE_PAQUETE"));
		this.descCanal = String.valueOf(dato.get("PC_DESC_CANAL"));
		this.descLargaPlan = String.valueOf(dato.get("PC_DESC_LARGA_PLAN"));
		this.fechaVenta = String.valueOf(dato.get("PC_FECHA_VENTA"));
		this.mesPago = String.valueOf(dato.get("PC_MES_PAGO"));
		this.plzFor = String.valueOf(dato.get("PC_PLZ_FOR"));
		this.porcDesc = String.valueOf(dato.get("PC_PORC_DESC"));
		this.porcDescAdi = String.valueOf(dato.get("PC_PORC_DESC_ADI"));
		this.sncode = String.valueOf(dato.get("SNCODE"));
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
	public String getAccessfee() {
		return accessfee;
	}
	public void setAccessfee(String accessfee) {
		this.accessfee = accessfee;
	}
	public String getCsStatChng() {
		return csStatChng;
	}
	public void setCsStatChng(String csStatChng) {
		this.csStatChng = csStatChng;
	}
	public String getCostumerId() {
		return costumerId;
	}
	public void setCostumerId(String costumerId) {
		this.costumerId = costumerId;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDiasAlta() {
		return diasAlta;
	}
	public void setDiasAlta(String diasAlta) {
		this.diasAlta = diasAlta;
	}
	public String getDiasBaja() {
		return diasBaja;
	}
	public void setDiasBaja(String diasBaja) {
		this.diasBaja = diasBaja;
	}
	public String getFecDesaServ() {
		return fecDesaServ;
	}
	public void setFecDesaServ(String fecDesaServ) {
		this.fecDesaServ = fecDesaServ;
	}
	public String getNumContrato() {
		return numContrato;
	}
	public void setNumContrato(String numContrato) {
		this.numContrato = numContrato;
	}
	public String getNumTelefono() {
		return numTelefono;
	}
	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}
	public String getComision() {
		return comision;
	}
	public void setComision(String comision) {
		this.comision = comision;
	}
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public String getCveCanal() {
		return cveCanal;
	}
	public void setCveCanal(String cveCanal) {
		this.cveCanal = cveCanal;
	}
	public String getCveConcepto() {
		return cveConcepto;
	}
	public void setCveConcepto(String cveConcepto) {
		this.cveConcepto = cveConcepto;
	}
	public String getCveEsquema() {
		return cveEsquema;
	}
	public void setCveEsquema(String cveEsquema) {
		this.cveEsquema = cveEsquema;
	}
	public String getCvePaquete() {
		return cvePaquete;
	}
	public void setCvePaquete(String cvePaquete) {
		this.cvePaquete = cvePaquete;
	}
	public String getDescCanal() {
		return descCanal;
	}
	public void setDescCanal(String descCanal) {
		this.descCanal = descCanal;
	}
	public String getDescLargaPlan() {
		return descLargaPlan;
	}
	public void setDescLargaPlan(String descLargaPlan) {
		this.descLargaPlan = descLargaPlan;
	}
	public String getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(String fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	public String getMesPago() {
		return mesPago;
	}
	public void setMesPago(String mesPago) {
		this.mesPago = mesPago;
	}
	public String getPlzFor() {
		return plzFor;
	}
	public void setPlzFor(String plzFor) {
		this.plzFor = plzFor;
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
	public String getSncode() {
		return sncode;
	}
	public void setSncode(String sncode) {
		this.sncode = sncode;
	}

	public String getFecActServ() {
		return fecActServ;
	}

	public void setFecActServ(String fecActServ) {
		this.fecActServ = fecActServ;
	}
	
	

}
