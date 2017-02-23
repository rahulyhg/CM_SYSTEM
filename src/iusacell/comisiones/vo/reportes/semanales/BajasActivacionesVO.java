package iusacell.comisiones.vo.reportes.semanales;

import java.util.Map;

import iusacell.comisiones.vo.ValueObject;

public class BajasActivacionesVO extends ValueObject{
	
	private String[] campos = {"REGION","PLAN_USO","DESC_LARGA_PLAN","CVE_CANAL","DESC_CANAL","CVE_CONTRATO",
			"CUENTA","NUM_TELEFONO","FECHA_VENTA","FECHA_BAJA","DIAS_DIFF","SUMA_MONTOS","POBKPNOMBRE","DES_DIVISION",
			"EDODENOMBRE","ORIGEN_EQPO","MONTO_EQPO","ORIGEN_EMP"};
	
	private int[] longitudes = {5000,5000,5000,5000,5000,5000,
			5000,5000,5000,5000,5000,5000,5000,5000,
			5000,5000,5000,5000};
	
	private String REGION;
	private String PLAN_USO;
	private String DESC_LARGA_PLAN;
	private String CVE_CANAL;
	private String DESC_CANAL;
	private String CVE_CONTRATO;
	private String CUENTA;
	private String NUM_TELEFONO;
	private String FECHA_VENTA;
	private String FECHA_BAJA;
	private String DIAS_DIFF;
	private String SUMA_MONTOS;
	private String POBKPNOMBRE;
	private String DES_DIVISION;
	private String EDODENOMBRE;
	private String ORIGEN_EQPO;
	private String MONTO_EQPO;
	private String ORIGEN_EMP;
	
	public BajasActivacionesVO() {}
	
	public BajasActivacionesVO(Map<String, Object> dato) {
		this.REGION = String.valueOf(dato.get("REGION"));
		this.PLAN_USO = String.valueOf(dato.get("PLAN_USO"));
		this.DESC_LARGA_PLAN = String.valueOf(dato.get("DESC_LARGA_PLAN"));
		this.CVE_CANAL = String.valueOf(dato.get("CVE_CANAL"));
		this.DESC_CANAL = String.valueOf(dato.get("DESC_CANAL"));
		this.CVE_CONTRATO = String.valueOf(dato.get("CVE_CONTRATO"));
		this.CUENTA = String.valueOf(dato.get("CUENTA"));
		this.NUM_TELEFONO = String.valueOf(dato.get("NUM_TELEFONO"));
		this.FECHA_VENTA = String.valueOf(dato.get("FECHA_VENTA"));
		this.FECHA_BAJA = String.valueOf(dato.get("FECHA_BAJA"));
		this.DIAS_DIFF = String.valueOf(dato.get("DIAS_DIFF"));
		this.SUMA_MONTOS = String.valueOf(dato.get("SUMA_MONTOS"));
		this.POBKPNOMBRE = String.valueOf(dato.get("POBKPNOMBRE"));
		this.DES_DIVISION = String.valueOf(dato.get("DES_DIVISION"));
		this.EDODENOMBRE = String.valueOf(dato.get("EDODENOMBRE"));
		this.ORIGEN_EQPO = String.valueOf(dato.get("ORIGEN_EQPO"));
		this.MONTO_EQPO = String.valueOf(dato.get("MONTO_EQPO"));
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
	public String getPLAN_USO() {
		return PLAN_USO;
	}
	public void setPLAN_USO(String PLAN_USO) {
		this.PLAN_USO = PLAN_USO;
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
	public String getCUENTA() {
		return CUENTA;
	}
	public void setCUENTA(String CUENTA) {
		this.CUENTA = CUENTA;
	}
	public String getNUM_TELEFONO() {
		return NUM_TELEFONO;
	}
	public void setNUM_TELEFONO(String NUM_TELEFONO) {
		this.NUM_TELEFONO = NUM_TELEFONO;
	}
	public String getFECHA_VENTA() {
		return FECHA_VENTA;
	}
	public void setFECHA_VENTA(String FECHA_VENTA) {
		this.FECHA_VENTA = FECHA_VENTA;
	}
	public String getFECHA_BAJA() {
		return FECHA_BAJA;
	}
	public void setFECHA_BAJA(String FECHA_BAJA) {
		this.FECHA_BAJA = FECHA_BAJA;
	}
	public String getDIAS_DIFF() {
		return DIAS_DIFF;
	}
	public void setDIAS_DIFF(String DIAS_DIFF) {
		this.DIAS_DIFF = DIAS_DIFF;
	}
	public String getSUMA_MONTOS() {
		return SUMA_MONTOS;
	}
	public void setSUMA_MONTOS(String SUMA_MONTOS) {
		this.SUMA_MONTOS = SUMA_MONTOS;
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
	public String getORIGEN_EQPO() {
		return ORIGEN_EQPO;
	}
	public void setORIGEN_EQPO(String ORIGEN_EQPO) {
		this.ORIGEN_EQPO = ORIGEN_EQPO;
	}
	public String getMONTO_EQPO() {
		return MONTO_EQPO;
	}
	public void setMONTO_EQPO(String MONTO_EQPO) {
		this.MONTO_EQPO = MONTO_EQPO;
	}
	public String getORIGEN_EMP() {
		return ORIGEN_EMP;
	}
	public void setORIGEN_EMP(String ORIGEN_EMP) {
		this.ORIGEN_EMP = ORIGEN_EMP;
	}
	
	

}
