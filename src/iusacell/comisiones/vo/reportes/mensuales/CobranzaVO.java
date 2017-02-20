package iusacell.comisiones.vo.reportes.mensuales;

import java.util.Map;

import iusacell.comisiones.vo.ValueObject;

public class CobranzaVO extends ValueObject{
	
	private String[] campos = {"CDG_CIA","CDG_CSI","CDG_REGION","NUM_TRANSACCION","PC_CDG_CPTO_VTA","PC_COBRANZA_MES",
			"PC_COMISION","PC_CUSTOMER_ID","PC_CVE_CANAL","PC_CVE_ESQUEMA","PC_CVE_VENDEDOR","PC_DESC_CPTO","PC_FEC_TRANS","PC_MDN",
			"PC_MONTO","PC_NOM_VEND","PC_ORIGEN_EMP","TIPO_TRANSACCION"};
	
	private int[] longitudes = {};
	
	private String CDG_CIA;
	private String CDG_CSI;
	private String CDG_REGION;
	private String NUM_TRANSACCION;
	private String PC_CDG_CPTO_VTA;
	private String PC_COBRANZA_MES;
	private String PC_COMISION;
	private String PC_CUSTOMER_ID;
	private String PC_CVE_CANAL;
	private String PC_CVE_ESQUEMA;
	private String PC_CVE_VENDEDOR;
	private String PC_DESC_CPTO;
	private String PC_FEC_TRANS;
	private String PC_MDN;
	private String PC_MONTO;
	private String PC_NOM_VEND;
	private String PC_ORIGEN_EMP;
	private String TIPO_TRANSACCION;
	
	public CobranzaVO() {}
	
	public CobranzaVO(Map<String, Object> dato) {
		this.CDG_CIA = String.valueOf(dato.get("CDG_CIA"));
		this.CDG_CSI = String.valueOf(dato.get("CDG_CSI"));
		this.CDG_REGION= String.valueOf(dato.get("CDG_REGION"));
		this.NUM_TRANSACCION = String.valueOf(dato.get("NUM_TRANSACCION"));
		this.PC_CDG_CPTO_VTA = String.valueOf(dato.get("PC_CDG_CPTO_VTA"));
		this.PC_COBRANZA_MES = String.valueOf(dato.get("PC_COBRANZA_MES"));
		this.PC_COMISION = String.valueOf(dato.get("PC_COMISION"));
		this.PC_CUSTOMER_ID = String.valueOf(dato.get("PC_CUSTOMER_ID"));
		this.PC_CVE_CANAL = String.valueOf(dato.get("PC_CVE_CANAL"));
		this.PC_CVE_ESQUEMA = String.valueOf(dato.get("PC_CVE_ESQUEMA"));
		this.PC_CVE_VENDEDOR = String.valueOf(dato.get("PC_CVE_VENDEDOR"));
		this.PC_DESC_CPTO = String.valueOf(dato.get("PC_DESC_CPTO"));
		this.PC_FEC_TRANS = String.valueOf(dato.get("PC_FEC_TRANS"));
		this.PC_MDN = String.valueOf(dato.get("PC_MDN"));
		this.PC_MONTO = String.valueOf(dato.get("PC_MONTO"));
		this.PC_NOM_VEND = String.valueOf(dato.get("PC_NOM_VEND"));
		this.PC_ORIGEN_EMP = String.valueOf(dato.get("PC_ORIGEN_EMP"));
		this.TIPO_TRANSACCION = String.valueOf(dato.get("TIPO_TRANSACCION"));
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

	public String getCDG_CIA() {
		return CDG_CIA;
	}

	public void setCDG_CIA(String cdg_cia) {
		CDG_CIA = cdg_cia;
	}

	public String getCDG_CSI() {
		return CDG_CSI;
	}

	public void setCDG_CSI(String cdg_csi) {
		CDG_CSI = cdg_csi;
	}

	public String getCDG_REGION() {
		return CDG_REGION;
	}

	public void setCDG_REGION(String cdg_region) {
		CDG_REGION = cdg_region;
	}

	public String getNUM_TRANSACCION() {
		return NUM_TRANSACCION;
	}

	public void setNUM_TRANSACCION(String num_transaccion) {
		NUM_TRANSACCION = num_transaccion;
	}

	public String getPC_CDG_CPTO_VTA() {
		return PC_CDG_CPTO_VTA;
	}

	public void setPC_CDG_CPTO_VTA(String pc_cdg_cpto_vta) {
		PC_CDG_CPTO_VTA = pc_cdg_cpto_vta;
	}

	public String getPC_COBRANZA_MES() {
		return PC_COBRANZA_MES;
	}

	public void setPC_COBRANZA_MES(String pc_cobranza_mes) {
		PC_COBRANZA_MES = pc_cobranza_mes;
	}

	public String getPC_COMISION() {
		return PC_COMISION;
	}

	public void setPC_COMISION(String pc_comision) {
		PC_COMISION = pc_comision;
	}

	public String getPC_CUSTOMER_ID() {
		return PC_CUSTOMER_ID;
	}

	public void setPC_CUSTOMER_ID(String pc_customer_id) {
		PC_CUSTOMER_ID = pc_customer_id;
	}

	public String getPC_CVE_CANAL() {
		return PC_CVE_CANAL;
	}

	public void setPC_CVE_CANAL(String pc_cve_canal) {
		PC_CVE_CANAL = pc_cve_canal;
	}

	public String getPC_CVE_ESQUEMA() {
		return PC_CVE_ESQUEMA;
	}

	public void setPC_CVE_ESQUEMA(String pc_cve_esquema) {
		PC_CVE_ESQUEMA = pc_cve_esquema;
	}

	public String getPC_CVE_VENDEDOR() {
		return PC_CVE_VENDEDOR;
	}

	public void setPC_CVE_VENDEDOR(String pc_cve_vendedor) {
		PC_CVE_VENDEDOR = pc_cve_vendedor;
	}

	public String getPC_DESC_CPTO() {
		return PC_DESC_CPTO;
	}

	public void setPC_DESC_CPTO(String pc_desc_cpto) {
		PC_DESC_CPTO = pc_desc_cpto;
	}

	public String getPC_FEC_TRANS() {
		return PC_FEC_TRANS;
	}

	public void setPC_FEC_TRANS(String pc_fec_trans) {
		PC_FEC_TRANS = pc_fec_trans;
	}

	public String getPC_MDN() {
		return PC_MDN;
	}

	public void setPC_MDN(String pc_mdn) {
		PC_MDN = pc_mdn;
	}

	public String getPC_MONTO() {
		return PC_MONTO;
	}

	public void setPC_MONTO(String pc_monto) {
		PC_MONTO = pc_monto;
	}

	public String getPC_NOM_VEND() {
		return PC_NOM_VEND;
	}

	public void setPC_NOM_VEND(String pc_nom_vend) {
		PC_NOM_VEND = pc_nom_vend;
	}

	public String getPC_ORIGEN_EMP() {
		return PC_ORIGEN_EMP;
	}

	public void setPC_ORIGEN_EMP(String pc_origen_emp) {
		PC_ORIGEN_EMP = pc_origen_emp;
	}

	public String getTIPO_TRANSACCION() {
		return TIPO_TRANSACCION;
	}

	public void setTIPO_TRANSACCION(String tipo_transaccion) {
		TIPO_TRANSACCION = tipo_transaccion;
	}
		
	

}
