package iusacell.comisiones.vo.reportes.mensuales;

import java.util.Map;

import iusacell.comisiones.vo.ValueObject;

public class PrepagoEqCajon extends ValueObject{
	
	private String[] campos = {"NOMBRE","ACTIV_MES","CONCEPTO","TIPO_VENTA","MDN","ESN_D","FEC_REP",
			"DESC_PLAN","PRECIO_VTA","NUM_FACTURA","DESC_ORIGEN","COMISION"};
	
	private int[] longitudes = {};
	
	private String NOMBRE;
	private String ACTIV_MES;
	private String CONCEPTO;
	private String TIPO_VENTA;
	private String MDN;
	private String ESN_D;
	private String FEC_REP;
	private String DESC_PLAN;
	private String PRECIO_VTA;
	private String NUM_FACTURA;
	private String DESC_ORIGEN;
	private String COMISION;
	
	public PrepagoEqCajon() {}
	
	public PrepagoEqCajon(Map<String, Object> dato) {
		this.NOMBRE = String.valueOf(dato.get("NOMBRE"));
		this.ACTIV_MES = String.valueOf(dato.get("ACTIV_MES"));
		this.CONCEPTO = String.valueOf(dato.get("CONCEPTO"));
		this.TIPO_VENTA = String.valueOf(dato.get("TIPO_VENTA"));
		this.MDN = String.valueOf(dato.get("MDN"));
		this.ESN_D = String.valueOf(dato.get("ESN_D"));
		this.FEC_REP = String.valueOf(dato.get("FEC_REP"));
		this.DESC_PLAN = String.valueOf(dato.get("DESC_PLAN"));
		this.PRECIO_VTA = String.valueOf(dato.get("PRECIO_VTA"));
		this.NUM_FACTURA = String.valueOf(dato.get("NUM_FACTURA"));
		this.DESC_ORIGEN = String.valueOf(dato.get("DESC_ORIGEN"));
		this.COMISION = String.valueOf(dato.get("COMISION"));
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

	public String getNOMBRE() {
		return NOMBRE;
	}

	public void setNOMBRE(String nombre) {
		NOMBRE = nombre;
	}

	public String getACTIV_MES() {
		return ACTIV_MES;
	}

	public void setACTIV_MES(String activ_mes) {
		ACTIV_MES = activ_mes;
	}

	public String getCONCEPTO() {
		return CONCEPTO;
	}

	public void setCONCEPTO(String concepto) {
		CONCEPTO = concepto;
	}

	public String getTIPO_VENTA() {
		return TIPO_VENTA;
	}

	public void setTIPO_VENTA(String tipo_venta) {
		TIPO_VENTA = tipo_venta;
	}

	public String getMDN() {
		return MDN;
	}

	public void setMDN(String mdn) {
		MDN = mdn;
	}

	public String getESN_D() {
		return ESN_D;
	}

	public void setESN_D(String esn_d) {
		ESN_D = esn_d;
	}

	public String getFEC_REP() {
		return FEC_REP;
	}

	public void setFEC_REP(String fec_rep) {
		FEC_REP = fec_rep;
	}

	public String getDESC_PLAN() {
		return DESC_PLAN;
	}

	public void setDESC_PLAN(String desc_plan) {
		DESC_PLAN = desc_plan;
	}

	public String getPRECIO_VTA() {
		return PRECIO_VTA;
	}

	public void setPRECIO_VTA(String precio_vta) {
		PRECIO_VTA = precio_vta;
	}

	public String getNUM_FACTURA() {
		return NUM_FACTURA;
	}

	public void setNUM_FACTURA(String num_factura) {
		NUM_FACTURA = num_factura;
	}

	public String getDESC_ORIGEN() {
		return DESC_ORIGEN;
	}

	public void setDESC_ORIGEN(String desc_origen) {
		DESC_ORIGEN = desc_origen;
	}

	public String getCOMISION() {
		return COMISION;
	}

	public void setCOMISION(String comision) {
		COMISION = comision;
	}
	
	
	

}
