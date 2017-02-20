package iusacell.comisiones.vo.reportes.mensuales;

import java.util.Map;

import iusacell.comisiones.vo.ValueObject;

public class AdonsVO extends ValueObject{
	
	private String[] campos = {"PC_CVE_CANAL","PC_DESC_CANAL","NUM_CONTRATO","NUM_TELEFONO","PC_CVE_PAQUETE","PC_DESC_LARGA_PLAN",
			"PC_FECHA_VENTA","FEC_ACT_SERV","FEC_DESA_SERV","SNCODE","DESCRIPCION","ACCESSFEE","PC_PORC_DESC","PC_PORC_DESC_ADI",
			"PC_CUENTA","CUSTOMER_ID","PC_CVE_CONCEPTO","PC_COMISION","PC_CVE_ESQUEMA","PC_PLZ_FOR"};
	
	private int[] longitudes = {5000,5000,5000,5000,5000,5000,
			5000,5000,5000,5000,5000,5000,5000,5000,
			5000,5000,5000,5000,5000,5000,5000,
			5000,5000,5000};
	
	private String PC_CVE_CANAL;
	private String PC_DESC_CANAL;
	private String NUM_CONTRATO;
	private String NUM_TELEFONO;
	private String PC_CVE_PAQUETE;
	private String PC_DESC_LARGA_PLAN;
	private String PC_FECHA_VENTA;
	private String FEC_ACT_SERV;
	private String FEC_DESA_SERV;
	private String SNCODE;
	private String DESCRIPCION;
	private String ACCESSFEE;
	private String PC_PORC_DESC;
	private String PC_PORC_DESC_ADI;
	private String PC_CUENTA;
	private String CUSTOMER_ID;
	private String PC_CVE_CONCEPTO;
	private String PC_COMISION;
	private String PC_CVE_ESQUEMA;
	private String PC_PLZ_FOR ;
	
	
	public AdonsVO() {}
	
	public AdonsVO(Map<String, Object> dato) {
		this.PC_CVE_CANAL = String.valueOf(dato.get("PC_CVE_CANAL"));
		this.PC_DESC_CANAL = String.valueOf(dato.get("PC_DESC_CANAL"));
		this.NUM_CONTRATO = String.valueOf(dato.get("NUM_CONTRATO"));
		this.NUM_TELEFONO = String.valueOf(dato.get("NUM_TELEFONO"));
		this.PC_CVE_PAQUETE = String.valueOf(dato.get("PC_CVE_PAQUETE"));
		this.PC_DESC_LARGA_PLAN = String.valueOf(dato.get("PC_DESC_LARGA_PLAN"));
		this.PC_FECHA_VENTA = String.valueOf(dato.get("PC_FECHA_VENTA"));
		this.FEC_ACT_SERV = String.valueOf(dato.get("FEC_ACT_SERV"));
		this.FEC_DESA_SERV = String.valueOf(dato.get("FEC_DESA_SERV"));
		this.SNCODE = String.valueOf(dato.get("SNCODE"));
		this.DESCRIPCION = String.valueOf(dato.get("DESCRIPCION"));
		this.ACCESSFEE = String.valueOf(dato.get("ACCESSFEE"));
		this.PC_PORC_DESC = String.valueOf(dato.get("PC_PORC_DESC"));
		this.PC_PORC_DESC_ADI = String.valueOf(dato.get("PC_PORC_DESC_ADI"));
		this.PC_CUENTA = String.valueOf(dato.get("PC_CUENTA"));
		this.CUSTOMER_ID = String.valueOf(dato.get("CUSTOMER_ID"));
		this.PC_CVE_CONCEPTO = String.valueOf(dato.get("PC_CVE_CONCEPTO"));
		this.PC_COMISION = String.valueOf(dato.get("PC_COMISION"));
		this.PC_CVE_ESQUEMA = String.valueOf(dato.get("PC_CVE_ESQUEMA"));
		this.PC_PLZ_FOR  = String.valueOf(dato.get("PC_PLZ_FOR"));
		
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

	public String getPC_CVE_CANAL() {
		return PC_CVE_CANAL;
	}

	public void setPC_CVE_CANAL(String pc_cve_canal) {
		PC_CVE_CANAL = pc_cve_canal;
	}

	public String getPC_DESC_CANAL() {
		return PC_DESC_CANAL;
	}

	public void setPC_DESC_CANAL(String pc_desc_canal) {
		PC_DESC_CANAL = pc_desc_canal;
	}

	public String getNUM_CONTRATO() {
		return NUM_CONTRATO;
	}

	public void setNUM_CONTRATO(String num_contrato) {
		NUM_CONTRATO = num_contrato;
	}

	public String getNUM_TELEFONO() {
		return NUM_TELEFONO;
	}

	public void setNUM_TELEFONO(String num_telefono) {
		NUM_TELEFONO = num_telefono;
	}

	public String getPC_CVE_PAQUETE() {
		return PC_CVE_PAQUETE;
	}

	public void setPC_CVE_PAQUETE(String pc_cve_paquete) {
		PC_CVE_PAQUETE = pc_cve_paquete;
	}

	public String getPC_DESC_LARGA_PLAN() {
		return PC_DESC_LARGA_PLAN;
	}

	public void setPC_DESC_LARGA_PLAN(String pc_desc_larga_plan) {
		PC_DESC_LARGA_PLAN = pc_desc_larga_plan;
	}

	public String getPC_FECHA_VENTA() {
		return PC_FECHA_VENTA;
	}

	public void setPC_FECHA_VENTA(String pc_fecha_venta) {
		PC_FECHA_VENTA = pc_fecha_venta;
	}

	public String getFEC_ACT_SERV() {
		return FEC_ACT_SERV;
	}

	public void setFEC_ACT_SERV(String fec_act_serv) {
		FEC_ACT_SERV = fec_act_serv;
	}

	public String getFEC_DESA_SERV() {
		return FEC_DESA_SERV;
	}

	public void setFEC_DESA_SERV(String fec_desa_serv) {
		FEC_DESA_SERV = fec_desa_serv;
	}

	public String getSNCODE() {
		return SNCODE;
	}

	public void setSNCODE(String sncode) {
		SNCODE = sncode;
	}

	public String getDESCRIPCION() {
		return DESCRIPCION;
	}

	public void setDESCRIPCION(String descripcion) {
		DESCRIPCION = descripcion;
	}

	public String getACCESSFEE() {
		return ACCESSFEE;
	}

	public void setACCESSFEE(String accessfee) {
		ACCESSFEE = accessfee;
	}

	public String getPC_PORC_DESC() {
		return PC_PORC_DESC;
	}

	public void setPC_PORC_DESC(String pc_porc_desc) {
		PC_PORC_DESC = pc_porc_desc;
	}

	public String getPC_PORC_DESC_ADI() {
		return PC_PORC_DESC_ADI;
	}

	public void setPC_PORC_DESC_ADI(String pc_porc_desc_adi) {
		PC_PORC_DESC_ADI = pc_porc_desc_adi;
	}

	public String getPC_CUENTA() {
		return PC_CUENTA;
	}

	public void setPC_CUENTA(String pc_cuenta) {
		PC_CUENTA = pc_cuenta;
	}

	public String getCUSTOMER_ID() {
		return CUSTOMER_ID;
	}

	public void setCUSTOMER_ID(String customer_id) {
		CUSTOMER_ID = customer_id;
	}

	public String getPC_CVE_CONCEPTO() {
		return PC_CVE_CONCEPTO;
	}

	public void setPC_CVE_CONCEPTO(String pc_cve_concepto) {
		PC_CVE_CONCEPTO = pc_cve_concepto;
	}

	public String getPC_COMISION() {
		return PC_COMISION;
	}

	public void setPC_COMISION(String pc_comision) {
		PC_COMISION = pc_comision;
	}

	public String getPC_CVE_ESQUEMA() {
		return PC_CVE_ESQUEMA;
	}

	public void setPC_CVE_ESQUEMA(String pc_cve_esquema) {
		PC_CVE_ESQUEMA = pc_cve_esquema;
	}

	public String getPC_PLZ_FOR() {
		return PC_PLZ_FOR;
	}

	public void setPC_PLZ_FOR(String pc_plz_for) {
		PC_PLZ_FOR = pc_plz_for;
	}

	

}
