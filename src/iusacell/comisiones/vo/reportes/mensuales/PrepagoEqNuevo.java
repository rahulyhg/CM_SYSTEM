package iusacell.comisiones.vo.reportes.mensuales;

import java.util.Map;

import iusacell.comisiones.vo.ValueObject;

public class PrepagoEqNuevo extends ValueObject{
	
	private String[] campos = {"NOMBRE","ACTIV_MES","REGION","MDN","ESN_D","FEC_REP","DES_PLAN",
			"MODELO","PRECIO_VTA","COMISION","DESC_ORIGEN","POBLACION","DIVISION","ESTADO",
			"NUM_FACTURA","NOM_VENDEDOR"};
	
	private int[] longitudes = {};
	
	private String NOMBRE;
	private String ACTIV_MES;
	private String REGION;
	private String MDN;
	private String ESN_D;
	private String FEC_REP;
	private String DES_PLAN;
	private String MODELO;
	private String PRECIO_VTA;
	private String COMISION;
	private String DESC_ORIGEN;
	private String POBLACION;
	private String DIVISION;
	private String ESTADO;
	private String NUM_FACTURA;
	private String NOM_VENDEDOR;
	
	public PrepagoEqNuevo() {}
	
	public PrepagoEqNuevo(Map<String, Object> dato) {
		this.NOMBRE = String.valueOf(dato.get("NOMBRE"));
		this.ACTIV_MES = String.valueOf(dato.get("ACTIV_MES"));
		this.REGION = String.valueOf(dato.get("REGION"));
		this.MDN = String.valueOf(dato.get("MDN"));
		this.ESN_D = String.valueOf(dato.get("ESN_D"));
		this.FEC_REP = String.valueOf(dato.get("FEC_REP"));
		this.DES_PLAN = String.valueOf(dato.get("DES_PLAN"));
		this.MODELO = String.valueOf(dato.get("MODELO"));
		this.PRECIO_VTA = String.valueOf(dato.get("PRECIO_VTA"));
		this.COMISION = String.valueOf(dato.get("COMISION"));
		this.DESC_ORIGEN = String.valueOf(dato.get("DESC_ORIGEN"));
		this.POBLACION = String.valueOf(dato.get("POBLACION"));
		this.DIVISION = String.valueOf(dato.get("DIVISION"));
		this.ESTADO = String.valueOf(dato.get("ESTADO"));
		this.NUM_FACTURA = String.valueOf(dato.get("NUM_FACTURA"));
		this.NOM_VENDEDOR = String.valueOf(dato.get("NOM_VENDEDOR"));
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

	public String getREGION() {
		return REGION;
	}

	public void setREGION(String region) {
		REGION = region;
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

	public String getDES_PLAN() {
		return DES_PLAN;
	}

	public void setDES_PLAN(String des_plan) {
		DES_PLAN = des_plan;
	}

	public String getMODELO() {
		return MODELO;
	}

	public void setMODELO(String modelo) {
		MODELO = modelo;
	}

	public String getPRECIO_VTA() {
		return PRECIO_VTA;
	}

	public void setPRECIO_VTA(String precio_vta) {
		PRECIO_VTA = precio_vta;
	}

	public String getCOMISION() {
		return COMISION;
	}

	public void setCOMISION(String comision) {
		COMISION = comision;
	}

	public String getDESC_ORIGEN() {
		return DESC_ORIGEN;
	}

	public void setDESC_ORIGEN(String desc_origen) {
		DESC_ORIGEN = desc_origen;
	}

	public String getPOBLACION() {
		return POBLACION;
	}

	public void setPOBLACION(String poblacion) {
		POBLACION = poblacion;
	}

	public String getDIVISION() {
		return DIVISION;
	}

	public void setDIVISION(String division) {
		DIVISION = division;
	}

	public String getESTADO() {
		return ESTADO;
	}

	public void setESTADO(String estado) {
		ESTADO = estado;
	}

	public String getNUM_FACTURA() {
		return NUM_FACTURA;
	}

	public void setNUM_FACTURA(String num_factura) {
		NUM_FACTURA = num_factura;
	}

	public String getNOM_VENDEDOR() {
		return NOM_VENDEDOR;
	}

	public void setNOM_VENDEDOR(String nom_vendedor) {
		NOM_VENDEDOR = nom_vendedor;
	}
	
}
