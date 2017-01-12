package iusacell.comisiones.vo.reportes.mensuales;

import java.util.Map;

import iusacell.comisiones.vo.ValueObject;

public class ActivacionesVO extends ValueObject{
	
	private String[] campos = {"nombreCanal","activMes","region","descLargaPlan","cveContrato","cuenta",
			"cliente","esn","numTelefono","fechaVenta","plazo_for","monto_activ","poblacion","division",
			"estado","modelo","renta","porcDescuento","porcDescAdic"};
	
	private int[] longitudes = {5000,5000,5000,5000,5000,5000,
			5000,5000,5000,5000,5000,5000,5000,5000,
			5000,5000,5000,5000,5000};
	
	private String nombreCanal;
	private String activMes;
	private String region;
	private String descLargaPlan;
	private String cveContrato;
	private String cuenta;
	private String cliente;
	private String esn;
	private String numTelefono;
	private String fechaVenta;
	private String plazo_for;
	private String monto_activ;
	private String poblacion;
	private String division;
	private String estado;
	private String modelo;
	private String renta;
	private String porcDescuento;
	private String porcDescAdic;
	
	public ActivacionesVO() {}
	
	public ActivacionesVO(Map<String, Object> dato) {
		this.nombreCanal = String.valueOf(dato.get("NOMBRE_CANAL"));
		this.activMes = String.valueOf(dato.get("ACTIV_MES"));
		this.region = String.valueOf(dato.get("REGION"));
		this.descLargaPlan = String.valueOf(dato.get("DESC_LARGA_PLAN"));
		this.cveContrato = String.valueOf(dato.get("CVE_CONTRATO"));
		this.cuenta = String.valueOf(dato.get("CUENTA"));
		this.cliente = String.valueOf(dato.get("CLIENTE"));
		this.esn = String.valueOf(dato.get("ESN"));
		this.numTelefono = String.valueOf(dato.get("NUM_TELEFONO"));
		this.fechaVenta = String.valueOf(dato.get("FECHA_VENTA"));
		this.plazo_for = String.valueOf(dato.get("PLAZO_FOR"));
		this.monto_activ = String.valueOf(dato.get("MONTO_ACTIV"));
		this.poblacion = String.valueOf(dato.get("POBLACION"));
		this.division = String.valueOf(dato.get("DIVISION"));
		this.estado = String.valueOf(dato.get("ESTADO"));
		this.modelo = String.valueOf(dato.get("MODELO"));
		this.renta = String.valueOf(dato.get("RENTA"));
		this.porcDescuento = String.valueOf(dato.get("PORC_DESCUENTO"));
		this.porcDescAdic = String.valueOf(dato.get("PORC_DESC_ADIC"));
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
	public String getActivMes() {
		return activMes;
	}
	public void setActivMes(String activMes) {
		this.activMes = activMes;
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
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
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
	public void setNumTelefono(String num_telefono) {
		this.numTelefono = num_telefono;
	}
	public String getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(String fecha_venta) {
		this.fechaVenta = fecha_venta;
	}
	public String getPlazo_for() {
		return plazo_for;
	}
	public void setPlazo_for(String plazo_for) {
		this.plazo_for = plazo_for;
	}
	public String getMonto_activ() {
		return monto_activ;
	}
	public void setMonto_activ(String monto_activ) {
		this.monto_activ = monto_activ;
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
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getRenta() {
		return renta;
	}
	public void setRenta(String renta) {
		this.renta = renta;
	}
	public String getPorcDescuento() {
		return porcDescuento;
	}
	public void setPorcDescuento(String porcDescuento) {
		this.porcDescuento = porcDescuento;
	}
	public String getPorcDescAdic() {
		return porcDescAdic;
	}
	public void setPorcDescAdic(String porcDescAdic) {
		this.porcDescAdic = porcDescAdic;
	}
	

}
