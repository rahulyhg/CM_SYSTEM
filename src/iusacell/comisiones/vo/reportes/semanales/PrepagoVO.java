package iusacell.comisiones.vo.reportes.semanales;

import java.util.Map;

import iusacell.comisiones.vo.ValueObject;

public class PrepagoVO extends ValueObject{
	
	private String[] campos = {"region","cveCanal","descCanal","mdn","esnD","fecRep","descriptionTT",
			"descripcionOeq","modelo","desPlan","precioVta","comision","numFactura","origenEmp"};
	
	private int[] longitudes = {5000,5000,5000,5000,5000,5000,5000,
			5000,5000,5000,5000,5000,5000,5000};
	
	private String region;
	private String cveCanal;
	private String descCanal;
	private String mdn;
	private String esnD;
	private String fecRep;
	private String descriptionTT;
	private String descripcionOeq;
	private String modelo;
	private String desPlan;
	private String precioVta;
	private String comision;
	private String numFactura;
	private String origenEmp;
	
	public PrepagoVO() {}
	
	public PrepagoVO(Map<String, Object> dato) {
		this.region = String.valueOf(dato.get("REGION"));
		this.cveCanal = String.valueOf(dato.get("CVE_CANAL"));
		this.descCanal = String.valueOf(dato.get("DESC_CANAL"));
		this.mdn = String.valueOf(dato.get("MDN"));
		this.esnD = String.valueOf(dato.get("ESN_D"));
		this.fecRep = String.valueOf(dato.get("FEC_REP"));
		this.descriptionTT = String.valueOf(dato.get("DESCRIPCION_TT"));
		this.descripcionOeq = String.valueOf(dato.get("DESCRIPCION_OEQ"));
		this.modelo = String.valueOf(dato.get("MODELO"));
		this.desPlan = String.valueOf(dato.get("DES_PLAN"));
		this.precioVta = String.valueOf(dato.get("PRECIO_VTA"));
		this.comision = String.valueOf(dato.get("COMISION"));
		this.numFactura = String.valueOf(dato.get("NUM_FACTURA"));
		this.origenEmp = String.valueOf(dato.get("ORIGEN_EMP"));
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
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCveCanal() {
		return cveCanal;
	}
	public void setCveCanal(String cveCanal) {
		this.cveCanal = cveCanal;
	}
	public String getDescCanal() {
		return descCanal;
	}
	public void setDescCanal(String descCanal) {
		this.descCanal = descCanal;
	}
	public String getMdn() {
		return mdn;
	}
	public void setMdn(String mdn) {
		this.mdn = mdn;
	}
	public String getEsnD() {
		return esnD;
	}
	public void setEsnD(String esnD) {
		this.esnD = esnD;
	}
	public String getFecRep() {
		return fecRep;
	}
	public void setFecRep(String fecRep) {
		this.fecRep = fecRep;
	}
	public String getDescriptionTT() {
		return descriptionTT;
	}
	public void setDescriptionTT(String descriptionTT) {
		this.descriptionTT = descriptionTT;
	}
	public String getDescripcionOeq() {
		return descripcionOeq;
	}
	public void setDescripcionOeq(String descripcionOeq) {
		this.descripcionOeq = descripcionOeq;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getDesPlan() {
		return desPlan;
	}
	public void setDesPlan(String desPlan) {
		this.desPlan = desPlan;
	}
	public String getPrecioVta() {
		return precioVta;
	}
	public void setPrecioVta(String precioVta) {
		this.precioVta = precioVta;
	}
	public String getComision() {
		return comision;
	}
	public void setComision(String comision) {
		this.comision = comision;
	}
	public String getNumFactura() {
		return numFactura;
	}
	public void setNumFactura(String numFactura) {
		this.numFactura = numFactura;
	}
	public String getOrigenEmp() {
		return origenEmp;
	}
	public void setOrigenEmp(String origenEmp) {
		this.origenEmp = origenEmp;
	}
	
	

}
