package iusacell.comisiones.vo.reportes.semanales;

import java.util.Map;

import iusacell.comisiones.vo.ValueObject;

public class PrepagoVO extends ValueObject{
	
	private String[] campos = {"REGION","CVE_CANAL","DESC_CANAL","MDN","ESN_D","FEC_REP","DESCRIPCION_TT",
			"DESCRIPCION_OEQ","MODELO","DES_PLAN","PRECIO_VTA","COMISION","NUM_FACTURA","ORIGEN_EMP"};
	
	private int[] longitudes = {5000,5000,5000,5000,5000,5000,5000,
			5000,5000,5000,5000,5000,5000,5000};
	
	private String REGION;
	private String CVE_CANAL;
	private String DESC_CANAL;
	private String MDN;
	private String ESN_D;
	private String FEC_REP;
	private String DESCRIPCION_TT;
	private String DESCRIPCION_OEQ;
	private String MODELO;
	private String DES_PLAN;
	private String PRECIO_VTA;
	private String COMISION;
	private String NUM_FACTURA;
	private String ORIGEN_EMP;
	
	public PrepagoVO() {}
	
	public PrepagoVO(Map<String, Object> dato) {
		this.REGION = String.valueOf(dato.get("REGION"));
		this.CVE_CANAL = String.valueOf(dato.get("CVE_CANAL"));
		this.DESC_CANAL = String.valueOf(dato.get("DESC_CANAL"));
		this.MDN = String.valueOf(dato.get("MDN"));
		this.ESN_D = String.valueOf(dato.get("ESN_D"));
		this.FEC_REP = String.valueOf(dato.get("FEC_REP"));
		this.DESCRIPCION_TT = String.valueOf(dato.get("DESCRIPCION_TT"));
		this.DESCRIPCION_OEQ = String.valueOf(dato.get("DESCRIPCION_OEQ"));
		this.MODELO = String.valueOf(dato.get("MODELO"));
		this.DES_PLAN = String.valueOf(dato.get("DES_PLAN"));
		this.PRECIO_VTA = String.valueOf(dato.get("PRECIO_VTA"));
		this.COMISION = String.valueOf(dato.get("COMISION"));
		this.NUM_FACTURA = String.valueOf(dato.get("NUM_FACTURA"));
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
	public String getMDN() {
		return MDN;
	}
	public void setMDN(String MDN) {
		this.MDN = MDN;
	}
	public String getESN_D() {
		return ESN_D;
	}
	public void setESN_D(String ESN_D) {
		this.ESN_D = ESN_D;
	}
	public String getFEC_REP() {
		return FEC_REP;
	}
	public void setFEC_REP(String FEC_REP) {
		this.FEC_REP = FEC_REP;
	}
	public String getDESCRIPCION_TT() {
		return DESCRIPCION_TT;
	}
	public void setDESCRIPCION_TT(String DESCRIPCION_TT) {
		this.DESCRIPCION_TT = DESCRIPCION_TT;
	}
	public String getDESCRIPCION_OEQ() {
		return DESCRIPCION_OEQ;
	}
	public void setDESCRIPCION_OEQ(String DESCRIPCION_OEQ) {
		this.DESCRIPCION_OEQ = DESCRIPCION_OEQ;
	}
	public String getMODELO() {
		return MODELO;
	}
	public void setMODELO(String MODELO) {
		this.MODELO = MODELO;
	}
	public String getDES_PLAN() {
		return DES_PLAN;
	}
	public void setDES_PLAN(String DES_PLAN) {
		this.DES_PLAN = DES_PLAN;
	}
	public String getPRECIO_VTA() {
		return PRECIO_VTA;
	}
	public void setPRECIO_VTA(String PRECIO_VTA) {
		this.PRECIO_VTA = PRECIO_VTA;
	}
	public String getCOMISION() {
		return COMISION;
	}
	public void setCOMISION(String COMISION) {
		this.COMISION = COMISION;
	}
	public String getNUM_FACTURA() {
		return NUM_FACTURA;
	}
	public void setNUM_FACTURA(String NUM_FACTURA) {
		this.NUM_FACTURA = NUM_FACTURA;
	}
	public String getORIGEN_EMP() {
		return ORIGEN_EMP;
	}
	public void setORIGEN_EMP(String ORIGEN_EMP) {
		this.ORIGEN_EMP = ORIGEN_EMP;
	}
	
	

}
