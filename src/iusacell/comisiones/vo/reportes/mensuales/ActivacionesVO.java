package iusacell.comisiones.vo.reportes.mensuales;

import java.util.Map;

import iusacell.comisiones.vo.ValueObject;

public class ActivacionesVO extends ValueObject{
	
	private String[] campos = {"NOMBRE_CANAL","ACTIV_MES","REGION","DESC_LARGA_PLAN","CVE_CONTRATO","CUENTA",
			"CLIENTE","ESN","NUM_TELEFONO","FECHA_VENTA","PLAZO_FOR","MONTO_ACTIV","POBLACION","DIVISION",
			"ESTADO","MODELO","RENTA","PORC_DESCUENTO","PORC_DESC_ADIC"};
	
	private int[] longitudes = {5000,5000,5000,5000,5000,5000,
			5000,5000,5000,5000,5000,5000,5000,5000,
			5000,5000,5000,5000,5000};
	
	private String NOMBRE_CANAL;
	private String ACTIV_MES;
	private String REGION;
	private String DESC_LARGA_PLAN;	
	private String CVE_CONTRATO;
	private String CUENTA;
	private String CLIENTE;
	private String ESN;
	private String NUM_TELEFONO;
	private String FECHA_VENTA;
	private String PLAZO_FOR;
	private String MONTO_ACTIV;
	private String POBLACION;
	private String DIVISION;
	private String ESTADO;
	private String MODELO;
	private String RENTA;
	private String PORC_DESCUENTO;
	private String PORC_DESC_ADIC;
	
	public ActivacionesVO() {}
	
	public ActivacionesVO(Map<String, Object> dato) {
		this.NOMBRE_CANAL = String.valueOf(dato.get("NOMBRE_CANAL"));
		this.ACTIV_MES = String.valueOf(dato.get("ACTIV_MES"));
		this.REGION =String.valueOf(dato.get("REGION"));
		this.DESC_LARGA_PLAN = String.valueOf(dato.get("DESC_LARGA_PLAN"));
		this.CVE_CONTRATO = String.valueOf(dato.get("CVE_CONTRATO"));
		this.CUENTA = String.valueOf(dato.get("CUENTA"));
		this.CLIENTE = String.valueOf(dato.get("CLIENTE"));
		this.ESN = String.valueOf(dato.get("ESN"));
		this.NUM_TELEFONO = String.valueOf(dato.get("NUM_TELEFONO"));
		this.FECHA_VENTA = String.valueOf(dato.get("FECHA_VENTA"));
		this.PLAZO_FOR = String.valueOf(dato.get("PLAZO_FOR"));
		this.MONTO_ACTIV = String.valueOf(dato.get("MONTO_ACTIV"));
		this.POBLACION = String.valueOf(dato.get("POBLACION"));
		this.DIVISION = String.valueOf(dato.get("DIVISION"));
		this.ESTADO = String.valueOf(dato.get("ESTADO"));
		this.MODELO = String.valueOf(dato.get("MODELO"));
		this.RENTA = String.valueOf(dato.get("RENTA"));
		this.PORC_DESCUENTO = String.valueOf(dato.get("PORC_DESCUENTO"));
		this.PORC_DESC_ADIC = String.valueOf(dato.get("PORC_DESC_ADIC"));
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
	
	public void setNOMBRE_CANAL(String nOMBRE_CANAL) {
		NOMBRE_CANAL = nOMBRE_CANAL;
	}

	public String getNOMBRE_CANAL() {
		return NOMBRE_CANAL;
	}

	public void setACTIV_MES(String aCTIV_MES) {
		ACTIV_MES = aCTIV_MES;
	}

	public String getACTIV_MES() {
		return ACTIV_MES;
	}

	public void setREGION(String rEGION) {
		REGION = rEGION;
	}

	public String getREGION() {
		return REGION;
	}
	
	
	public String getDESC_LARGA_PLAN() {
		return DESC_LARGA_PLAN;
	}

	public void setDESC_LARGA_PLAN(String desc_larga_plan) {
		DESC_LARGA_PLAN = desc_larga_plan;
	}

	public String getCVE_CONTRATO() {
		return CVE_CONTRATO;
	}

	public void setCVE_CONTRATO(String cve_contrato) {
		CVE_CONTRATO = cve_contrato;
	}

	public String getCUENTA() {
		return CUENTA;
	}

	public void setCUENTA(String cuenta) {
		CUENTA = cuenta;
	}

	public String getCLIENTE() {
		return CLIENTE;
	}

	public void setCLIENTE(String cliente) {
		CLIENTE = cliente;
	}

	public String getESN() {
		return ESN;
	}

	public void setESN(String esn) {
		ESN = esn;
	}

	public String getNUM_TELEFONO() {
		return NUM_TELEFONO;
	}

	public void setNUM_TELEFONO(String num_telefono) {
		NUM_TELEFONO = num_telefono;
	}

	public String getFECHA_VENTA() {
		return FECHA_VENTA;
	}

	public void setFECHA_VENTA(String fecha_venta) {
		FECHA_VENTA = fecha_venta;
	}

	public String getPLAZO_FOR() {
		return PLAZO_FOR;
	}

	public void setPLAZO_FOR(String plazo_for) {
		PLAZO_FOR = plazo_for;
	}

	public String getMONTO_ACTIV() {
		return MONTO_ACTIV;
	}

	public void setMONTO_ACTIV(String monto_activ) {
		MONTO_ACTIV = monto_activ;
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

	public String getMODELO() {
		return MODELO;
	}

	public void setMODELO(String modelo) {
		MODELO = modelo;
	}

	public String getRENTA() {
		return RENTA;
	}

	public void setRENTA(String renta) {
		RENTA = renta;
	}

	public String getPORC_DESCUENTO() {
		return PORC_DESCUENTO;
	}

	public void setPORC_DESCUENTO(String porc_descuento) {
		PORC_DESCUENTO = porc_descuento;
	}

	public String getPORC_DESC_ADIC() {
		return PORC_DESC_ADIC;
	}

	public void setPORC_DESC_ADIC(String porc_desc_adic) {
		PORC_DESC_ADIC = porc_desc_adic;
	}

	

}
