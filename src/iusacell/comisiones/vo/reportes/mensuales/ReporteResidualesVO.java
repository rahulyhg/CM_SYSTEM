package iusacell.comisiones.vo.reportes.mensuales;

import java.util.Map;

import iusacell.comisiones.vo.ValueObject;

public class ReporteResidualesVO extends ValueObject{
	
	private String[] campos = {"canalTp","clavedistNuevo","claveDistOrig","comision","contrato",
			"descuentoAdicional","descuentoMultilinea","estatusLinea","fechaActivacion","fechaFinPlazo",
			"cveCanal","descCanal","descLargaPlan","descTpCanal","nomPtoVentas","periodo","plan",
			"plazoForzoso","puntoDeVenta","renta","telefono","tipoCliente"};
	
	private int[] longitudes = {5000,5000,5000,5000,5000,
			5000,5000,5000,5000,5000,
			5000,5000,5000,5000,5000,5000,5000,
			5000,5000,5000,5000,5000};
	
	private String canalTp;
	private String clavedistNuevo;
	private String claveDistOrig;
	private String comision;
	private String contrato;
	private String descuentoAdicional;
	private String descuentoMultilinea;
	private String estatusLinea;
	private String fechaActivacion;
	private String fechaFinPlazo;
	private String cveCanal;
	private String descCanal;
	private String descLargaPlan;
	private String descTpCanal;
	private String nomPtoVentas;
	private String periodo;
	private String plan;
	private String plazoForzoso;
	private String puntoDeVenta;
	private String renta;
	private String telefono;
	private String tipoCliente;
	
	public ReporteResidualesVO(){};
	
	public ReporteResidualesVO(Map<String, Object> dato) {
		this.canalTp = String.valueOf(dato.get("CANAL_TP"));
		this.clavedistNuevo = String.valueOf(dato.get("CLAVE_DIST_NUEVO"));
		this.claveDistOrig = String.valueOf(dato.get("CLAVE_DIST_ORIG"));
		this.comision = String.valueOf(dato.get("COMISION"));
		this.contrato = String.valueOf(dato.get("CONTRATO"));
		this.descuentoAdicional = String.valueOf(dato.get("DESCUENTO_ADICIONAL"));
		this.descuentoMultilinea = String.valueOf(dato.get("DESCUENTO_MULTILINEA"));
		this.estatusLinea = String.valueOf(dato.get("ESTATUS_LINEA"));
		this.fechaActivacion = String.valueOf(dato.get("FECHA_ACTIVACION"));
		this.fechaFinPlazo = String.valueOf(dato.get("FECHA_FIN_PLAZO"));
		this.cveCanal = String.valueOf(dato.get("PC_CVE_CANAL"));
		this.descCanal = String.valueOf(dato.get("PC_DESC_CANAL"));
		this.descLargaPlan = String.valueOf(dato.get("PC_DESC_LARGA_PLAN"));
		this.descTpCanal = String.valueOf(dato.get("PC_DESC_TP_CANAL"));
		this.nomPtoVentas = String.valueOf(dato.get("PC_NOM_PTOVENTAS"));
		this.periodo = String.valueOf(dato.get("PERIODO"));
		this.plan = String.valueOf(dato.get("PLAN"));
		this.plazoForzoso = String.valueOf(dato.get("PLAZO_FORZOSO"));
		this.puntoDeVenta = String.valueOf(dato.get("PUNTO_DE_VENTA"));
		this.renta = String.valueOf(dato.get("RENTA"));
		this.telefono = String.valueOf(dato.get("TELEFONO"));
		this.tipoCliente = String.valueOf(dato.get("TIPO_CLIENTE"));
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
	public String getCanalTp() {
		return canalTp;
	}
	public void setCanalTp(String canalTp) {
		this.canalTp = canalTp;
	}
	public String getClavedistNuevo() {
		return clavedistNuevo;
	}
	public void setClavedistNuevo(String clavedistNuevo) {
		this.clavedistNuevo = clavedistNuevo;
	}
	public String getClaveDistOrig() {
		return claveDistOrig;
	}
	public void setClaveDistOrig(String claveDistOrig) {
		this.claveDistOrig = claveDistOrig;
	}
	public String getComision() {
		return comision;
	}
	public void setComision(String comision) {
		this.comision = comision;
	}
	public String getContrato() {
		return contrato;
	}
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}
	public String getDescuentoAdicional() {
		return descuentoAdicional;
	}
	public void setDescuentoAdicional(String descuentoAdicional) {
		this.descuentoAdicional = descuentoAdicional;
	}
	public String getDescuentoMultilinea() {
		return descuentoMultilinea;
	}
	public void setDescuentoMultilinea(String descuentoMultilinea) {
		this.descuentoMultilinea = descuentoMultilinea;
	}
	public String getEstatusLinea() {
		return estatusLinea;
	}
	public void setEstatusLinea(String estatusLinea) {
		this.estatusLinea = estatusLinea;
	}
	public String getFechaActivacion() {
		return fechaActivacion;
	}
	public void setFechaActivacion(String fechaActivacion) {
		this.fechaActivacion = fechaActivacion;
	}
	public String getFechaFinPlazo() {
		return fechaFinPlazo;
	}
	public void setFechaFinPlazo(String fechaFinPlazo) {
		this.fechaFinPlazo = fechaFinPlazo;
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
	public String getDescLargaPlan() {
		return descLargaPlan;
	}
	public void setDescLargaPlan(String descLargaPlan) {
		this.descLargaPlan = descLargaPlan;
	}
	public String getDescTpCanal() {
		return descTpCanal;
	}
	public void setDescTpCanal(String descTpCanal) {
		this.descTpCanal = descTpCanal;
	}
	public String getNomPtoVentas() {
		return nomPtoVentas;
	}
	public void setNomPtoVentas(String nomPtoVentas) {
		this.nomPtoVentas = nomPtoVentas;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public String getPlazoForzoso() {
		return plazoForzoso;
	}
	public void setPlazoForzoso(String plazoForzoso) {
		this.plazoForzoso = plazoForzoso;
	}
	public String getPuntoDeVenta() {
		return puntoDeVenta;
	}
	public void setPuntoDeVenta(String puntoDeVenta) {
		this.puntoDeVenta = puntoDeVenta;
	}
	public String getRenta() {
		return renta;
	}
	public void setRenta(String renta) {
		this.renta = renta;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

}
