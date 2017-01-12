package iusacell.comisiones.vo.reportes.semanales;

import java.util.Map;

import iusacell.comisiones.vo.ValueObject;

public class RenovacionesVO extends ValueObject{
	
	private String[] campos = {"region","cvePaquete","descLargaPlan","cveCanal","descCanal","fecActivacion",
			"fechaRenova","cveContrato","custcode","nombreUsua","esn","numTelefono","plazoFor","montoRenova",
			"pobkpnombre","desDivision","edodenombre","renta","origenEmp"};
	
	private int[] longitudes = {5000,5000,5000,5000,5000,5000,
			5000,5000,5000,5000,5000,5000,5000,5000,
			5000,5000,5000,5000,5000};
	
	private String region;
	private String cvePaquete;
	private String descLargaPlan;
	private String cveCanal;
	private String descCanal;
	private String fecActivacion;
	private String fechaRenova;
	private String cveContrato;
	private String custcode;
	private String nombreUsua;
	private String esn;
	private String numTelefono;
	private String plazoFor;
	private String montoRenova;
	private String pobkpnombre;
	private String desDivision;
	private String edodenombre;
	private String renta;
	private String origenEmp;
	
	public RenovacionesVO() {}
	
	public RenovacionesVO(Map<String, Object> dato) {
		this.region = String.valueOf(dato.get("REGION"));
		this.cvePaquete = String.valueOf(dato.get("CVE_PAQUETE"));
		this.descLargaPlan = String.valueOf(dato.get("DESC_LARGA_PLAN"));
		this.cveCanal = String.valueOf(dato.get("CVE_CANAL"));
		this.descCanal = String.valueOf(dato.get("DESC_CANAL"));
		this.fecActivacion = String.valueOf(dato.get("FEC_ACTIVACION"));
		this.fechaRenova = String.valueOf(dato.get("FECHA_RENOVA"));
		this.cveContrato = String.valueOf(dato.get("CVE_CONTRATO"));
		this.custcode = String.valueOf(dato.get("CUSTCODE"));
		this.nombreUsua = String.valueOf(dato.get("NOMBRE_USUA"));
		this.esn = String.valueOf(dato.get("ESN"));
		this.numTelefono = String.valueOf(dato.get("NUM_TELEFONO"));
		this.plazoFor = String.valueOf(dato.get("PLAZO_FOR"));
		this.montoRenova = String.valueOf(dato.get("MONTO_RENOVA"));
		this.pobkpnombre = String.valueOf(dato.get("POBKPNOMBRE"));
		this.desDivision = String.valueOf(dato.get("DES_DIVISION"));
		this.edodenombre = String.valueOf(dato.get("EDODENOMBRE"));
		this.renta = String.valueOf(dato.get("RENTA"));
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
	public String getCvePaquete() {
		return cvePaquete;
	}
	public void setCvePaquete(String cvePaquete) {
		this.cvePaquete = cvePaquete;
	}
	public String getDescLargaPlan() {
		return descLargaPlan;
	}
	public void setDescLargaPlan(String descLargaPlan) {
		this.descLargaPlan = descLargaPlan;
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
	public String getFecActivacion() {
		return fecActivacion;
	}
	public void setFecActivacion(String fecActivacion) {
		this.fecActivacion = fecActivacion;
	}
	public String getFechaRenova() {
		return fechaRenova;
	}
	public void setFechaRenova(String fechaRenova) {
		this.fechaRenova = fechaRenova;
	}
	public String getCveContrato() {
		return cveContrato;
	}
	public void setCveContrato(String cveContrato) {
		this.cveContrato = cveContrato;
	}
	public String getCustcode() {
		return custcode;
	}
	public void setCustcode(String custcode) {
		this.custcode = custcode;
	}
	public String getNombreUsua() {
		return nombreUsua;
	}
	public void setNombreUsua(String nombreUsua) {
		this.nombreUsua = nombreUsua;
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
	public String getPlazoFor() {
		return plazoFor;
	}
	public void setPlazoFor(String plazoFor) {
		this.plazoFor = plazoFor;
	}
	public String getMontoRenova() {
		return montoRenova;
	}
	public void setMontoRenova(String montoRenova) {
		this.montoRenova = montoRenova;
	}
	public String getPobkpnombre() {
		return pobkpnombre;
	}
	public void setPobkpnombre(String pobkpnombre) {
		this.pobkpnombre = pobkpnombre;
	}
	public String getDesDivision() {
		return desDivision;
	}
	public void setDesDivision(String desDivision) {
		this.desDivision = desDivision;
	}
	public String getEdodenombre() {
		return edodenombre;
	}
	public void setEdodenombre(String edodenombre) {
		this.edodenombre = edodenombre;
	}
	public String getRenta() {
		return renta;
	}
	public void setRenta(String renta) {
		this.renta = renta;
	}
	public String getOrigenEmp() {
		return origenEmp;
	}
	public void setOrigenEmp(String origenEmp) {
		this.origenEmp = origenEmp;
	}
	
	

}
