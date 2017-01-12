package iusacell.comisiones.vo.reportes.mensuales;

import java.util.Map;

import iusacell.comisiones.vo.ValueObject;

public class PrepagoEqNuevo extends ValueObject{
	
	private String[] campos = {"nombre","activMex","region","mdn","esnD","fecRep","desPlan",
			"modelo","precioVta","comision","descOrigen","poblacion","division","estado",
			"numFactura","nomVendedor"};
	
	private int[] longitudes = {};
	
	private String nombre;
	private String activMex;
	private String region;
	private String mdn;
	private String esnD;
	private String fecRep;
	private String desPlan;
	private String modelo;
	private String precioVta;
	private String comision;
	private String descOrigen;
	private String poblacion;
	private String division;
	private String estado;
	private String numFactura;
	private String nomVendedor;
	
	public PrepagoEqNuevo() {}
	
	public PrepagoEqNuevo(Map<String, Object> dato) {
		this.nombre = String.valueOf(dato.get("NOMBRE"));
		this.activMex = String.valueOf(dato.get("ACTIV_MEX"));
		this.region = String.valueOf(dato.get("REGION"));
		this.mdn = String.valueOf(dato.get("MDN"));
		this.esnD = String.valueOf(dato.get("ESN_D"));
		this.fecRep = String.valueOf(dato.get("FEC_REP"));
		this.desPlan = String.valueOf(dato.get("DES_PLAN"));
		this.modelo = String.valueOf(dato.get("MODELO"));
		this.precioVta = String.valueOf(dato.get("PRECIO_VTA"));
		this.comision = String.valueOf(dato.get("COMISION"));
		this.descOrigen = String.valueOf(dato.get("DESC_ORIGEN"));
		this.poblacion = String.valueOf(dato.get("POBLACION"));
		this.division = String.valueOf(dato.get("DIVISION"));
		this.estado = String.valueOf(dato.get("ESTADO"));
		this.numFactura = String.valueOf(dato.get("NUM_FACTURA"));
		this.nomVendedor = String.valueOf(dato.get("NOM_VENDEDOR"));
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
	public String getActivMex() {
		return activMex;
	}
	public void setActivMex(String activMex) {
		this.activMex = activMex;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
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
	public String getDesPlan() {
		return desPlan;
	}
	public void setDesPlan(String desPlan) {
		this.desPlan = desPlan;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getPrecioVta() {
		return precioVta;
	}
	public void setPrecioVta(String precioVta) {
		this.precioVta = precioVta;
	}
	public String getComision() {
		return comision;
	}
	public void setComision(String comision) {
		this.comision = comision;
	}
	public String getDescOrigen() {
		return descOrigen;
	}
	public void setDescOrigen(String descOrigen) {
		this.descOrigen = descOrigen;
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
	public String getNumFactura() {
		return numFactura;
	}
	public void setNumFactura(String numFactura) {
		this.numFactura = numFactura;
	}
	public String getNomVendedor() {
		return nomVendedor;
	}
	public void setNomVendedor(String nomVendedor) {
		this.nomVendedor = nomVendedor;
	}

}
