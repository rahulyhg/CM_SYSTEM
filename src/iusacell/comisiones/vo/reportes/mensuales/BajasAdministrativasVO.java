package iusacell.comisiones.vo.reportes.mensuales;

import java.util.Map;

import iusacell.comisiones.vo.ValueObject;

public class BajasAdministrativasVO extends ValueObject{
	
	private String[] campos = {"cuenta","cveCanal","cveContrato","cvePlan","cveUsuario","esn","fecAct",
			"fecBaja","mdn","movErroneos","razonMovimiento"};
	
	private int[] longitudes = {5000,5000,5000,5000,5000,5000,5000,
			5000,5000,5000,5000};
	
	private String cuenta;
	private String cveCanal;
	private String cveContrato;
	private String cvePlan;
	private String cveUsuario;
	private String esn;
	private String fecAct;
	private String fecBaja;
	private String mdn;
	private String movErroneos;
	private String razonMovimiento;
	
	public BajasAdministrativasVO() {}
	
	public BajasAdministrativasVO(Map<String, Object> dato) {
		this.cuenta = String.valueOf(dato.get("BB_CUENTA"));
		this.cveCanal = String.valueOf(dato.get("BB_CVE_CANAL"));
		this.cveContrato = String.valueOf(dato.get("BB_CVE_CONTRATO"));
		this.cvePlan = String.valueOf(dato.get("BB_CVE_PLAN"));
		this.cveUsuario = String.valueOf(dato.get("BB_CVE_USUARIO"));
		this.esn = String.valueOf(dato.get("BB_ESN"));
		this.fecAct = String.valueOf(dato.get("BB_FEC_ACT"));
		this.fecBaja = String.valueOf(dato.get("BB_FEC_BAJA"));
		this.mdn = String.valueOf(dato.get("BB_MDN"));
		this.movErroneos = String.valueOf(dato.get("BB_MOV_ERRONEOS"));
		this.razonMovimiento = String.valueOf(dato.get("BB_RAZON_MOVIMIENTO"));
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
	public String getCveContrato() {
		return cveContrato;
	}
	public void setCveContrato(String cveContrato) {
		this.cveContrato = cveContrato;
	}
	public String getCvePlan() {
		return cvePlan;
	}
	public void setCvePlan(String cvePlan) {
		this.cvePlan = cvePlan;
	}
	public String getCveUsuario() {
		return cveUsuario;
	}
	public void setCveUsuario(String cveUsuario) {
		this.cveUsuario = cveUsuario;
	}
	public String getEsn() {
		return esn;
	}
	public void setEsn(String esn) {
		this.esn = esn;
	}
	public String getFecAct() {
		return fecAct;
	}
	public void setFecAct(String fecAct) {
		this.fecAct = fecAct;
	}
	public String getFecBaja() {
		return fecBaja;
	}
	public void setFecBaja(String fecBaja) {
		this.fecBaja = fecBaja;
	}
	public String getMdn() {
		return mdn;
	}
	public void setMdn(String mdn) {
		this.mdn = mdn;
	}
	public String getMovErroneos() {
		return movErroneos;
	}
	public void setMovErroneos(String movErroneos) {
		this.movErroneos = movErroneos;
	}
	public String getRazonMovimiento() {
		return razonMovimiento;
	}
	public void setRazonMovimiento(String razonMovimiento) {
		this.razonMovimiento = razonMovimiento;
	}
	
	

}
