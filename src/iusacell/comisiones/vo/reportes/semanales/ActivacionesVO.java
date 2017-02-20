package iusacell.comisiones.vo.reportes.semanales;

import java.util.Map;

import iusacell.comisiones.vo.ValueObject;

public class ActivacionesVO extends ValueObject{
	
	private String[] campos = {"REGION","CVE_PAQUETE","DESC_LARGA_PLAN","CVE_CANAL","DESC_CANAL","CVE_CONTRATO",
			"CUSTCODE","NOMBRE_USUA","ESN","NUM_TELEFONO","CVE_GPO","FEC_ALTA_CLIENTE","PLAZO_FOR","MONTO_ACTIV",
			"POBKNOMBRE","DES_DIVISION","EDODENOMBRE","RENTA","ORIGEN_EMP"};
	
	private int[] longitudes = {5000,5000,5000,5000,5000,5000,
			5000,5000,5000,5000,5000,5000,5000,5000,
			5000,5000,5000,5000,5000};
	
	private String REGION;
	private String CVE_PAQUETE;
	private String DESC_LARGA_PLAN;
	private String CVE_CANAL;
	private String DESC_CANAL;
	private String CVE_CONTRATO;
	private String CUSTCODE;
	private String NOMBRE_USUA;
	private String ESN;
	private String NUM_TELEFONO;
	private String CVE_GPO;
	private String FEC_ALTA_CLIENTE;
	private String PLAZO_FOR;
	private String MONTO_ACTIV;
	private String POBKNOMBRE;
	private String DES_DIVISION;
	private String EDODENOMBRE;
	private String RENTA;
	private String ORIGEN_EMP;
	
	public ActivacionesVO() {}
	
	public ActivacionesVO(Map<String, Object> dato) {
		this.REGION = String.valueOf(dato.get("REGION"));
		this.CVE_PAQUETE = String.valueOf(dato.get("CVE_PAQUETE"));
		this.DESC_LARGA_PLAN = String.valueOf(dato.get("DESC_LARGA_PLAN"));
		this.CVE_CANAL = String.valueOf(dato.get("CVE_CANAL"));
		this.DESC_CANAL = String.valueOf(dato.get("DESC_CANAL"));
		this.CVE_CONTRATO = String.valueOf(dato.get("CVE_CONTRATO"));
		this.CUSTCODE = String.valueOf(dato.get("CUSTCODE"));
		this.NOMBRE_USUA = String.valueOf(dato.get("NOMBRE_USUA"));
		this.ESN = String.valueOf(dato.get("ESN"));
		this.NUM_TELEFONO = String.valueOf(dato.get("NUM_TELEFONO"));
		this.CVE_GPO = String.valueOf(dato.get("CVE_GPO"));
		this.FEC_ALTA_CLIENTE = String.valueOf(dato.get("FEC_ALTA_CLIENTE"));
		this.PLAZO_FOR = String.valueOf(dato.get("PLAZO_FOR"));
		this.MONTO_ACTIV = String.valueOf(dato.get("MONTO_ACTIV"));
		this.POBKNOMBRE = String.valueOf(dato.get("POBKNOMBRE"));
		this.DES_DIVISION = String.valueOf(dato.get("DES_DIVISION"));
		this.EDODENOMBRE = String.valueOf(dato.get("EDODENOMBRE"));
		this.RENTA = String.valueOf(dato.get("RENTA"));
		this.ORIGEN_EMP = String.valueOf(dato.get("ORIGEN_EMP"));
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
	public String getREGION() {
		return REGION;
	}
	public void setREGION(String REGION) {
		this.REGION = REGION;
	}
	public String getCVE_PAQUETE() {
		return CVE_PAQUETE;
	}
	public void setCVE_PAQUETE(String CVE_PAQUETE) {
		this.CVE_PAQUETE = CVE_PAQUETE;
	}
	public String getDESC_LARGA_PLAN() {
		return DESC_LARGA_PLAN;
	}
	public void setDESC_LARGA_PLAN(String DESC_LARGA_PLAN) {
		this.DESC_LARGA_PLAN = DESC_LARGA_PLAN;
	}
	public String getCVE_CANAL() {
		return CVE_CANAL;
	}
	public void setCVE_CANAL(String CVE_CANAL) {
		this.CVE_CANAL = CVE_CANAL;
	}
	public String getDESC_CANAL() {
		return DESC_CANAL;
	}
	public void setDESC_CANAL(String DESC_CANAL) {
		this.DESC_CANAL = DESC_CANAL;
	}
	public String getCVE_CONTRATO() {
		return CVE_CONTRATO;
	}
	public void setCVE_CONTRATO(String CVE_CONTRATO) {
		this.CVE_CONTRATO = CVE_CONTRATO;
	}
	public String getCUSTCODE() {
		return CUSTCODE;
	}
	public void setCUSTCODE(String CUSTCODE) {
		this.CUSTCODE = CUSTCODE;
	}
	public String getNOMBRE_USUA() {
		return NOMBRE_USUA;
	}
	public void setNOMBRE_USUA(String NOMBRE_USUA) {
		this.NOMBRE_USUA = NOMBRE_USUA;
	}
	public String getESN() {
		return ESN;
	}
	public void setESN(String ESN) {
		this.ESN = ESN;
	}
	public String getNUM_TELEFONO() {
		return NUM_TELEFONO;
	}
	public void setNUM_TELEFONO(String NUM_TELEFONO) {
		this.NUM_TELEFONO = NUM_TELEFONO;
	}
	public String getCVE_GPO() {
		return CVE_GPO;
	}
	public void setCVE_GPO(String CVE_GPO) {
		this.CVE_GPO = CVE_GPO;
	}
	public String getFEC_ALTA_CLIENTE() {
		return FEC_ALTA_CLIENTE;
	}
	public void setFEC_ALTA_CLIENTE(String FEC_ALTA_CLIENTE) {
		this.FEC_ALTA_CLIENTE = FEC_ALTA_CLIENTE;
	}
	public String getPLAZO_FOR() {
		return PLAZO_FOR;
	}
	public void setPLAZO_FOR(String PLAZO_FOR) {
		this.PLAZO_FOR = PLAZO_FOR;
	}
	public String getMONTO_ACTIV() {
		return MONTO_ACTIV;
	}
	public void setMONTO_ACTIV(String MONTO_ACTIV) {
		this.MONTO_ACTIV = MONTO_ACTIV;
	}
	public String getPOBKNOMBRE() {
		return POBKNOMBRE;
	}
	public void setPOBKNOMBRE(String POBKNOMBRE) {
		this.POBKNOMBRE = POBKNOMBRE;
	}
	public String getDES_DIVISION() {
		return DES_DIVISION;
	}
	public void setDES_DIVISION(String DES_DIVISION) {
		this.DES_DIVISION = DES_DIVISION;
	}
	public String getEDODENOMBRE() {
		return EDODENOMBRE;
	}
	public void setEDODENOMBRE(String EDODENOMBRE) {
		this.EDODENOMBRE = EDODENOMBRE;
	}
	public String getRENTA() {
		return RENTA;
	}
	public void setRENTA(String RENTA) {
		this.RENTA = RENTA;
	}
	public String getORIGEN_EMP() {
		return ORIGEN_EMP;
	}
	public void setORIGEN_EMP(String ORIGEN_EMP) {
		this.ORIGEN_EMP = ORIGEN_EMP;
	}
	
	

}
