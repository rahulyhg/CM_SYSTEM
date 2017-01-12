package iusacell.comisiones.vo.reportes.semanales;

import java.util.Map;

import iusacell.comisiones.vo.ValueObject;

public class BajaRenovacionesVO extends ValueObject{
	
	private String[] campos = {"region","planUso","descLargaPlan","cveCanal","descCanal","cveContrato",
			"cuenta","numTelefono","fechaVenta","fechaBaja","diasDiff","sumaMontos","ponkpnombre",
			"desDivision","edodenombre","origenEqpo","montoEqpo","origenEmp"};
	
	private int[] longitudes = {5000,5000,5000,5000,5000,5000,
			5000,5000,5000,5000,5000,5000,5000,
			5000,5000,5000,5000,5000};
	
	private String region;
	private String planUso;
	private String descLargaPlan;
	private String cveCanal;
	private String descCanal;
	private String cveContrato;
	private String cuenta;
	private String numTelefono;
	private String fechaVenta;
	private String fechaBaja;
	private String diasDiff;
	private String sumaMontos;
	private String ponkpnombre;
	private String desDivision;
	private String edodenombre;
	private String origenEqpo;
	private String montoEqpo;
	private String origenEmp;
	
	public BajaRenovacionesVO() {}
	
	public BajaRenovacionesVO(Map<String, Object> dato) {
		this.region = String.valueOf(dato.get("REGION"));
		this.planUso = String.valueOf(dato.get("PLAN_USO"));
		this.descLargaPlan = String.valueOf(dato.get("DESC_LARGA_PLAN"));
		this.cveCanal = String.valueOf(dato.get("CVE_CANAL"));
		this.descCanal = String.valueOf(dato.get("DESC_CANAL"));
		this.cveContrato = String.valueOf(dato.get("CVE_CONTRATO"));
		this.cuenta = String.valueOf(dato.get("CUENTA"));
		this.numTelefono = String.valueOf(dato.get("NUM_TELEFONO"));
		this.fechaVenta = String.valueOf(dato.get("FECHA_VENTA"));
		this.fechaBaja = String.valueOf(dato.get("FECHA_BAJA"));
		this.diasDiff = String.valueOf(dato.get("DIAS_DIFF"));
		this.sumaMontos = String.valueOf(dato.get("SUMA_MONTOS"));
		this.ponkpnombre = String.valueOf(dato.get("POBKPNOMBNRE"));
		this.desDivision = String.valueOf(dato.get("DES_DIVISION"));
		this.edodenombre = String.valueOf(dato.get("EDODENOMBRE"));
		this.origenEqpo = String.valueOf(dato.get("ORIGEN_EQPO"));
		this.montoEqpo = String.valueOf(dato.get("MONTO_EQPO"));
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
	public String getPlanUso() {
		return planUso;
	}
	public void setPlanUso(String planUso) {
		this.planUso = planUso;
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
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public String getNumTelefono() {
		return numTelefono;
	}
	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}
	public String getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(String fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	public String getFechaBaja() {
		return fechaBaja;
	}
	public void setFechaBaja(String fechaBaja) {
		this.fechaBaja = fechaBaja;
	}
	public String getDiasDiff() {
		return diasDiff;
	}
	public void setDiasDiff(String diasDiff) {
		this.diasDiff = diasDiff;
	}
	public String getSumaMontos() {
		return sumaMontos;
	}
	public void setSumaMontos(String sumaMontos) {
		this.sumaMontos = sumaMontos;
	}
	public String getPonkpnombre() {
		return ponkpnombre;
	}
	public void setPonkpnombre(String ponkpnombre) {
		this.ponkpnombre = ponkpnombre;
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
	public String getOrigenEqpo() {
		return origenEqpo;
	}
	public void setOrigenEqpo(String origenEqpo) {
		this.origenEqpo = origenEqpo;
	}
	public String getMontoEqpo() {
		return montoEqpo;
	}
	public void setMontoEqpo(String montoEqpo) {
		this.montoEqpo = montoEqpo;
	}
	public String getOrigenEmp() {
		return origenEmp;
	}
	public void setOrigenEmp(String origenEmp) {
		this.origenEmp = origenEmp;
	}
	
	

}
