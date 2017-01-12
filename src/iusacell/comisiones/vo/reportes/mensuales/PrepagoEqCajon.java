package iusacell.comisiones.vo.reportes.mensuales;

import java.util.Map;

import iusacell.comisiones.vo.ValueObject;

public class PrepagoEqCajon extends ValueObject{
	
	private String[] campos = {"nombre","actvMes","concepto","tipoVenta","mdn","esnD","fecRep",
			"descPlan","precioVta","numFactura","descOrigen","comision"};
	
	private int[] longitudes = {};
	
	private String nombre;
	private String actvMes;
	private String concepto;
	private String tipoVenta;
	private String mdn;
	private String esnD;
	private String fecRep;
	private String descPlan;
	private String precioVta;
	private String numFactura;
	private String descOrigen;
	private String comision;
	
	public PrepagoEqCajon() {}
	
	public PrepagoEqCajon(Map<String, Object> dato) {
		this.nombre = String.valueOf(dato.get("NOMBRE"));
		this.actvMes = String.valueOf(dato.get("ACTIV_MES"));
		this.concepto = String.valueOf(dato.get("CONCEPTO"));
		this.tipoVenta = String.valueOf(dato.get("TIPO_VENTA"));
		this.mdn = String.valueOf(dato.get("MDN"));
		this.esnD = String.valueOf(dato.get("ESN_D"));
		this.fecRep = String.valueOf(dato.get("FEC_REP"));
		this.descPlan = String.valueOf(dato.get("DESC_PLAN"));
		this.precioVta = String.valueOf(dato.get("PRECIO_VTA"));
		this.numFactura = String.valueOf(dato.get("NUM_FACTURA"));
		this.descOrigen = String.valueOf(dato.get("DESC_ORIGEN"));
		this.comision = String.valueOf(dato.get("COMISION"));
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getActvMes() {
		return actvMes;
	}
	public void setActvMes(String actvMes) {
		this.actvMes = actvMes;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public String getTipoVenta() {
		return tipoVenta;
	}
	public void setTipoVenta(String tipoVenta) {
		this.tipoVenta = tipoVenta;
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
	public String getDescPlan() {
		return descPlan;
	}
	public void setDescPlan(String descPlan) {
		this.descPlan = descPlan;
	}
	public String getPrecioVta() {
		return precioVta;
	}
	public void setPrecioVta(String precioVta) {
		this.precioVta = precioVta;
	}
	public String getNumFactura() {
		return numFactura;
	}
	public void setNumFactura(String numFactura) {
		this.numFactura = numFactura;
	}
	public String getDescOrigen() {
		return descOrigen;
	}
	public void setDescOrigen(String descOrigen) {
		this.descOrigen = descOrigen;
	}
	public String getComision() {
		return comision;
	}
	public void setComision(String comision) {
		this.comision = comision;
	}
	
	

}
