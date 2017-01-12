package iusacell.comisiones.vo.reportes.mensuales;

import java.util.Map;

import iusacell.comisiones.vo.ValueObject;

public class ChargeBackPospagoVO extends ValueObject{
	
	private String[] campos = {"nombreCanal","bajaMes","esn","region","descLargaPlan","cuenta","cveContrato",
			"numTelefono","fechaVenta","fechaBaja","montoAct","montoResid","comision","plazoFor","dias",
			"poblacion","division","estado","razonMov","origenEquip","montoEquip"};
	
	private int[] longitudes = {5000,5000,5000,5000,5000,5000,5000,
			5000,5000,5000,5000,5000,5000,5000,5000,
			5000,5000,5000,5000,5000,5000};

	private String nombreCanal;
	private String bajaMes;
	private String esn;
	private String region;
	private String descLargaPlan;
	private String cuenta;
	private String cveContrato;
	private String numTelefono;
	private String fechaVenta;
	private String fechaBaja;
	private String montoAct;
	private String montoResid;
	private String comision;
	private String plazoFor;
	private String dias;
	private String poblacion;
	private String division;
	private String estado;
	private String razonMov;
	private String origenEquip;
	private String montoEquip;
	
	public ChargeBackPospagoVO() {}
	
	public ChargeBackPospagoVO(Map<String, Object> dato) {
		this.nombreCanal = String.valueOf(dato.get("NOMBRE_CANAL"));
		this.bajaMes = String.valueOf(dato.get("BAJA_MES"));
		this.esn = String.valueOf(dato.get("ESN"));
		this.region = String.valueOf(dato.get("REGION"));
		this.descLargaPlan = String.valueOf(dato.get("DESC_LARGA_PLAN"));
		this.cuenta = String.valueOf(dato.get("CUENTA"));
		this.cveContrato = String.valueOf(dato.get("CVE_CONTRATO"));
		this.numTelefono = String.valueOf(dato.get("NUM_TELEFONO"));
		this.fechaVenta = String.valueOf(dato.get("FECHA_VENTA"));
		this.fechaBaja = String.valueOf(dato.get("FECHA_BAJA"));
		this.montoAct = String.valueOf(dato.get("MONTO_ACT"));
		this.montoResid = String.valueOf(dato.get("MONTO_RESID"));
		this.comision = String.valueOf(dato.get("COMISION"));
		this.plazoFor = String.valueOf(dato.get("PLAZO_FOR"));
		this.dias = String.valueOf(dato.get("DIAS"));
		this.poblacion = String.valueOf(dato.get("POBLACION"));
		this.division = String.valueOf(dato.get("DIVISION"));
		this.estado = String.valueOf(dato.get("ESTADO"));
		this.razonMov = String.valueOf(dato.get("RAZON_MOV"));
		this.origenEquip = String.valueOf(dato.get("ORIGEN_EQUIP"));
		this.montoEquip = String.valueOf(dato.get("MONTO_EQUIP"));
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
	public String getNombreCanal() {
		return nombreCanal;
	}
	public void setNombreCanal(String nombreCanal) {
		this.nombreCanal = nombreCanal;
	}
	public String getBajaMes() {
		return bajaMes;
	}
	public void setBajaMes(String bajaMes) {
		this.bajaMes = bajaMes;
	}
	public String getEsn() {
		return esn;
	}
	public void setEsn(String esn) {
		this.esn = esn;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getDescLargaPlan() {
		return descLargaPlan;
	}
	public void setDescLargaPlan(String descLargaPlan) {
		this.descLargaPlan = descLargaPlan;
	}
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public String getCveContrato() {
		return cveContrato;
	}
	public void setCveContrato(String cveContrato) {
		this.cveContrato = cveContrato;
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
	public String getMontoAct() {
		return montoAct;
	}
	public void setMontoAct(String montoAct) {
		this.montoAct = montoAct;
	}
	public String getMontoResid() {
		return montoResid;
	}
	public void setMontoResid(String montoResid) {
		this.montoResid = montoResid;
	}
	public String getComision() {
		return comision;
	}
	public void setComision(String comision) {
		this.comision = comision;
	}
	public String getPlazoFor() {
		return plazoFor;
	}
	public void setPlazoFor(String plazoFor) {
		this.plazoFor = plazoFor;
	}
	public String getDias() {
		return dias;
	}
	public void setDias(String dias) {
		this.dias = dias;
	}
	public String getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getRazonMov() {
		return razonMov;
	}
	public void setRazonMov(String razonMov) {
		this.razonMov = razonMov;
	}
	public String getOrigenEquip() {
		return origenEquip;
	}
	public void setOrigenEquip(String origenEquip) {
		this.origenEquip = origenEquip;
	}
	public String getMontoEquip() {
		return montoEquip;
	}
	public void setMontoEquip(String montoEquip) {
		this.montoEquip = montoEquip;
	}
	
	
}
