package iusacell.comisiones.vo.reportes.mensuales;

import java.util.Map;

import iusacell.comisiones.vo.ValueObject;

public class RenovacionesVO extends ValueObject{
	
	private String[] campos = {"empresario","periodo","region","descripcionDelPlan","fechaRenovacion",
			"fechaActivacion","plazoForzoso","cuenta","contrato","esn","telefono","cliente",
			"descuentoMultilinea","descuentoAdicional","marca","renta","comision","poblacion",
			"division","estado"};
	private int[] longitudes = {5000,5000,5000,5000,5000,
			5000,5000,5000,5000,5000,5000,5000,
			5000,5000,5000,5000,5000,5000,
			5000,5000};

	private String empresario;
	private String periodo;
	private String region;
	private String descripcionDelPlan;
	private String fechaRenovacion;
	private String fechaActivacion;
	private String plazoForzoso;
	private String cuenta;
	private String contrato;
	private String esn;
	private String telefono;
	private String cliente;
	private String descuentoMultilinea;
	private String descuentoAdicional;
	private String marca;
	private String renta;
	private String comision;
	private String poblacion;
	private String division;
	private String estado;
	
	public RenovacionesVO() {}
	
	public RenovacionesVO(Map<String, Object> dato) {
		this.empresario = String.valueOf(dato.get("EMPRESARIO"));
		this.periodo = String.valueOf(dato.get("PERIODO"));
		this.region = String.valueOf(dato.get("REGION"));
		this.descripcionDelPlan = String.valueOf(dato.get("DESCRIPCION_DEL_PLAN"));
		this.fechaRenovacion = String.valueOf(dato.get("FECHA_RENOVACION"));
		this.fechaActivacion = String.valueOf(dato.get("FECHA_ACTIVACION"));
		this.plazoForzoso = String.valueOf(dato.get("PLAZO_FORZOSO"));
		this.cuenta = String.valueOf(dato.get("CUENTA"));
		this.contrato = String.valueOf(dato.get("CONTRATO"));
		this.esn = String.valueOf(dato.get("ESN"));
		this.telefono = String.valueOf(dato.get("TELEFONO"));
		this.cliente = String.valueOf(dato.get("CLIENTE"));
		this.descuentoMultilinea = String.valueOf(dato.get("DESCUENTO_MULTILINEA"));
		this.descuentoAdicional = String.valueOf(dato.get("DESCUENTO_ADICIONAL"));
		this.marca = String.valueOf(dato.get("MARCA"));
		this.renta = String.valueOf(dato.get("RENTA"));
		this.comision = String.valueOf(dato.get("COMISION"));
		this.poblacion = String.valueOf(dato.get("POBLACION"));
		this.division = String.valueOf(dato.get("DIVISION"));
		this.estado = String.valueOf(dato.get("ESTADO"));
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
	public String getEmpresario() {
		return empresario;
	}
	public void setEmpresario(String empresario) {
		this.empresario = empresario;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getDescripcionDelPlan() {
		return descripcionDelPlan;
	}
	public void setDescripcionDelPlan(String descripcionDelPlan) {
		this.descripcionDelPlan = descripcionDelPlan;
	}
	public String getFechaRenovacion() {
		return fechaRenovacion;
	}
	public void setFechaRenovacion(String fechaRenovacion) {
		this.fechaRenovacion = fechaRenovacion;
	}
	public String getFechaActivacion() {
		return fechaActivacion;
	}
	public void setFechaActivacion(String fechaActivacion) {
		this.fechaActivacion = fechaActivacion;
	}
	public String getPlazoForzoso() {
		return plazoForzoso;
	}
	public void setPlazoForzoso(String plazoForzoso) {
		this.plazoForzoso = plazoForzoso;
	}
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public String getContrato() {
		return contrato;
	}
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}
	public String getEsn() {
		return esn;
	}
	public void setEsn(String esn) {
		this.esn = esn;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getDescuentoMultilinea() {
		return descuentoMultilinea;
	}
	public void setDescuentoMultilinea(String descuentoMultilinea) {
		this.descuentoMultilinea = descuentoMultilinea;
	}
	public String getDescuentoAdicional() {
		return descuentoAdicional;
	}
	public void setDescuentoAdicional(String descuentoAdicional) {
		this.descuentoAdicional = descuentoAdicional;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getRenta() {
		return renta;
	}
	public void setRenta(String renta) {
		this.renta = renta;
	}
	public String getComision() {
		return comision;
	}
	public void setComision(String comision) {
		this.comision = comision;
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
}
