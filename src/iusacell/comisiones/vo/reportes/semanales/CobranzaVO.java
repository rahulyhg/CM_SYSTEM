package iusacell.comisiones.vo.reportes.semanales;

import java.util.Map;

import iusacell.comisiones.vo.ValueObject;

public class CobranzaVO extends ValueObject{
	
	private String[] campos = {"REGION","CSI","DESC_CANAL","CVE_CANAL","MONTO","COMISION","DESC_CPTO",
			"PC_CDG_CPTO_VTA","POBKPNOMBRE","DES_DIVISION","EDODENOMBRE","ORIGEN_EMP"};
	
	private int[] longitudes = {5000,5000,5000,5000,5000,5000,5000,
			5000,5000,5000,5000,5000};
	
	private String REGION;
	private String CSI;
	private String DESC_CANAL;
	private String CVE_CANAL;
	private String MONTO;
	private String COMISION;
	private String DESC_CPTO;
	private String PC_CDG_CPTO_VTA;
	private String POBKPNOMBRE;
	private String DES_DIVISION;
	private String EDODENOMBRE;
	private String ORIGEN_EMP;
	
	public CobranzaVO() {}
	
	public CobranzaVO(Map<String, Object> dato) {
		this.REGION = String.valueOf(dato.get("REGION"));
		this.CSI = String.valueOf(dato.get("CSI"));
		this.DESC_CANAL = String.valueOf(dato.get("DESC_CANAL"));
		this.CVE_CANAL = String.valueOf(dato.get("CVE_CANAL"));
		this.MONTO = String.valueOf(dato.get("MONTO"));
		this.COMISION = String.valueOf(dato.get("COMISION"));
		this.DESC_CPTO = String.valueOf(dato.get("DESC_CPTO"));
		this.PC_CDG_CPTO_VTA = String.valueOf(dato.get("PC_CDG_CPTO_VTA"));
		this.POBKPNOMBRE = String.valueOf(dato.get("POBKPNOMBRE"));
		this.DES_DIVISION = String.valueOf(dato.get("DES_DIVISION"));
		this.EDODENOMBRE = String.valueOf(dato.get("EDODENOMBRE"));
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
	public String getCSI() {
		return CSI;
	}
	public void setCSI(String CSI) {
		this.CSI = CSI;
	}
	public String getDESC_CANAL() {
		return DESC_CANAL;
	}
	public void setDESC_CANAL(String DESC_CANAL) {
		this.DESC_CANAL = DESC_CANAL;
	}
	public String getCVE_CANAL() {
		return CVE_CANAL;
	}
	public void setCVE_CANAL(String CVE_CANAL) {
		this.CVE_CANAL = CVE_CANAL;
	}
	public String getMONTO() {
		return MONTO;
	}
	public void setMONTO(String MONTO) {
		this.MONTO = MONTO;
	}
	public String getCOMISION() {
		return COMISION;
	}
	public void setCOMISION(String COMISION) {
		this.COMISION = COMISION;
	}
	public String getDESC_CPTO() {
		return DESC_CPTO;
	}
	public void setDESC_CPTO(String DESC_CPTO) {
		this.DESC_CPTO = DESC_CPTO;
	}
	public String getPOBKPNOMBRE() {
		return POBKPNOMBRE;
	}
	public void setPOBKPNOMBRE(String POBKPNOMBRE) {
		this.POBKPNOMBRE = POBKPNOMBRE;
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
	public String getORIGEN_EMP() {
		return ORIGEN_EMP;
	}
	public void setORIGEN_EMP(String ORIGEN_EMP) {
		this.ORIGEN_EMP = ORIGEN_EMP;
	}

	public void setPC_CDG_CPTO_VTA(String pC_CDG_CPTO_VTA) {
		PC_CDG_CPTO_VTA = pC_CDG_CPTO_VTA;
	}

	public String getPC_CDG_CPTO_VTA() {
		return PC_CDG_CPTO_VTA;
	}
	
	

}
