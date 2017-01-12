package iusacell.comisiones.vo.reportes.semanales;

import java.util.Map;

import iusacell.comisiones.vo.ValueObject;

public class ActivacionesVO extends ValueObject{
	
	private String[] campos = {"region","cvePaquete","descLargaPlan","cveCanal","descCanal","cveContrato",
			"custcode","nombreUsua","esn","numTelefono","cveGpo","fecAltaCliente","plazoFor","montoActiv",
			"pobknombre","desDivicion","edoDeNombre","renta","origenEmp"};
	
	private int[] longitudes = {5000,5000,5000,5000,5000,5000,
			5000,5000,5000,5000,5000,5000,5000,5000,
			5000,5000,5000,5000,5000};
	
	private String region;
	private String cvePaquete;
	private String descLargaPlan;
	private String cveCanal;
	private String descCanal;
	private String cveContrato;
	private String custcode;
	private String nombreUsua;
	private String esn;
	private String numTelefono;
	private String cveGpo;
	private String fecAltaCliente;
	private String plazoFor;
	private String montoActiv;
	private String pobknombre;
	private String desDivicion;
	private String edoDeNombre;
	private String renta;
	private String origenEmp;
	
	public ActivacionesVO() {}
	
	public ActivacionesVO(Map<String, Object> dato) {
		this.region = String.valueOf(dato.get("REGION"));
		this.cvePaquete = String.valueOf(dato.get("CVE_PAQUETE"));
		this.descLargaPlan = String.valueOf(dato.get("DESC_LARGA_PLAN"));
		this.cveCanal = String.valueOf(dato.get("CVE_CANAL"));
		this.descCanal = String.valueOf(dato.get("DESC_CANAL"));
		this.cveContrato = String.valueOf(dato.get("CVE_CONTRATO"));
		this.custcode = String.valueOf(dato.get("CUSTCODE"));
		this.nombreUsua = String.valueOf(dato.get("NOMBRE_USUA"));
		this.esn = String.valueOf(dato.get("ESN"));
		this.numTelefono = String.valueOf(dato.get("NUM_TELEFONO"));
		this.cveGpo = String.valueOf(dato.get("CVE_GPO"));
		this.fecAltaCliente = String.valueOf(dato.get("FEC_ALTA_CLIENTE"));
		this.plazoFor = String.valueOf(dato.get("PLAZO_FOR"));
		this.montoActiv = String.valueOf(dato.get("MONTO_ACTIV"));
		this.pobknombre = String.valueOf(dato.get("POBKNOMBRE"));
		this.desDivicion = String.valueOf(dato.get("DES_DIVISION"));
		this.edoDeNombre = String.valueOf(dato.get("EDODENOMBRE"));
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
	public String getCveGpo() {
		return cveGpo;
	}
	public void setCveGpo(String cveGpo) {
		this.cveGpo = cveGpo;
	}
	public String getFecAltaCliente() {
		return fecAltaCliente;
	}
	public void setFecAltaCliente(String fecAltaCliente) {
		this.fecAltaCliente = fecAltaCliente;
	}
	public String getPlazoFor() {
		return plazoFor;
	}
	public void setPlazoFor(String plazoFor) {
		this.plazoFor = plazoFor;
	}
	public String getMontoActiv() {
		return montoActiv;
	}
	public void setMontoActiv(String montoActiv) {
		this.montoActiv = montoActiv;
	}
	public String getPobknombre() {
		return pobknombre;
	}
	public void setPobknombre(String pobknombre) {
		this.pobknombre = pobknombre;
	}
	public String getDesDivicion() {
		return desDivicion;
	}
	public void setDesDivicion(String desDivicion) {
		this.desDivicion = desDivicion;
	}
	public String getEdoDeNombre() {
		return edoDeNombre;
	}
	public void setEdoDeNombre(String edoDeNombre) {
		this.edoDeNombre = edoDeNombre;
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
