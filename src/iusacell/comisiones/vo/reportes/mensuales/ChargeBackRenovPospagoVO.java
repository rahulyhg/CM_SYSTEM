package iusacell.comisiones.vo.reportes.mensuales;

import java.util.Map;

import iusacell.comisiones.vo.ValueObject;

public class ChargeBackRenovPospagoVO extends ValueObject{
	
	private String[] campos = {"nombreCanal","bajaMes","esn","region","descLargaPlan","cuenta","cveContrato",
			"numTelefono","fechaVenta","fechaBaja","comision","montoServ","dias","poblacion","division",
			"estado","razonMov","origenEqpo","montoEqpo"};
	
	private int[] longitudes = {5000,5000,5000,5000,5000,5000,5000,
			5000,5000,5000,5000,5000,5000,5000,5000,
			5000,5000,5000,5000};
	
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
	private String comision;
	private String montoServ;
	private String dias;
	private String poblacion;
	private String division;
	private String estado;
	private String razonMov;
	private String origenEqpo;
	private String montoEqpo;
	
	public ChargeBackRenovPospagoVO() {}
	
	public ChargeBackRenovPospagoVO(Map<String, Object> dato) {
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
		this.comision = String.valueOf(dato.get("COMISION"));
		this.montoServ = String.valueOf(dato.get("MONTO_SERV"));
		this.dias = String.valueOf(dato.get("DIAS"));
		this.poblacion = String.valueOf(dato.get("POBLACION"));
		this.division = String.valueOf(dato.get("DIVISION"));
		this.estado = String.valueOf(dato.get("ESTADO"));
		this.razonMov = String.valueOf(dato.get("RAZON_MOV"));
		this.origenEqpo = String.valueOf(dato.get("ORIGEN_EQPO"));
		this.montoEqpo = String.valueOf(dato.get("MONTO_EQPO"));
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
	public String getComision() {
		return comision;
	}
	public void setComision(String comision) {
		this.comision = comision;
	}
	public String getMontoServ() {
		return montoServ;
	}
	public void setMontoServ(String montoServ) {
		this.montoServ = montoServ;
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

}
