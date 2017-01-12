package iusacell.comisiones.vo.reportes.mensuales;

import java.util.Map;

import iusacell.comisiones.vo.ValueObject;

public class CobranzaVO extends ValueObject{
	
	private String[] campos = {"cdfCia","cdgCsi","cdgRegion","numTransaccion","cdgCptoVta","cobranzaMes",
			"comision","customerId","cveCanal","cveEsquema","cveVendedor","descCpto","fecTrans","mdm",
			"monto","nomVend","origenEmp","tipoTransaccion"};
	
	private int[] longitudes = {};
	
	private String cdfCia;
	private String cdgCsi;
	private String cdgRegion;
	private String numTransaccion;
	private String cdgCptoVta;
	private String cobranzaMes;
	private String comision;
	private String customerId;
	private String cveCanal;
	private String cveEsquema;
	private String cveVendedor;
	private String descCpto;
	private String fecTrans;
	private String mdm;
	private String monto;
	private String nomVend;
	private String origenEmp;
	private String tipoTransaccion;
	
	public CobranzaVO() {}
	
	public CobranzaVO(Map<String, Object> dato) {
		this.cdfCia = String.valueOf(dato.get("CDG_CIA"));
		this.cdgCsi = String.valueOf(dato.get("CDG_CSI"));
		this.cdgRegion = String.valueOf(dato.get("CDG_REGION"));
		this.numTransaccion = String.valueOf(dato.get("NUM_TRANSACCION"));
		this.cdgCptoVta = String.valueOf(dato.get("PC_CDG_CPTO_VTA"));
		this.cobranzaMes = String.valueOf(dato.get("PC_COBRANZA_MES"));
		this.comision = String.valueOf(dato.get("PC_COMISION"));
		this.customerId = String.valueOf(dato.get("PC_CUSTOMER_ID"));
		this.cveCanal = String.valueOf(dato.get("PC_CVE_CANAL"));
		this.cveEsquema = String.valueOf(dato.get("PC_CVE_ESQUEMA"));
		this.cveVendedor = String.valueOf(dato.get("PC_CVE_VENDEDOR"));
		this.descCpto = String.valueOf(dato.get("PC_DESC_CPTO"));
		this.fecTrans = String.valueOf(dato.get("PC_FEC_TRANS"));
		this.mdm = String.valueOf(dato.get("PC_MDN"));
		this.monto = String.valueOf(dato.get("PC_MONTO"));
		this.nomVend = String.valueOf(dato.get("PC_NOM_VEND"));
		this.origenEmp = String.valueOf(dato.get("PC_ORIGEN_EMP"));
		this.tipoTransaccion = String.valueOf(dato.get("TIPO_TRANSACCION"));
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
	public String getCdfCia() {
		return cdfCia;
	}
	public void setCdfCia(String cdfCia) {
		this.cdfCia = cdfCia;
	}
	public String getCdgCsi() {
		return cdgCsi;
	}
	public void setCdgCsi(String cdgCsi) {
		this.cdgCsi = cdgCsi;
	}
	public String getCdgRegion() {
		return cdgRegion;
	}
	public void setCdgRegion(String cdgRegion) {
		this.cdgRegion = cdgRegion;
	}
	public String getNumTransaccion() {
		return numTransaccion;
	}
	public void setNumTransaccion(String numTransaccion) {
		this.numTransaccion = numTransaccion;
	}
	public String getCdgCptoVta() {
		return cdgCptoVta;
	}
	public void setCdgCptoVta(String cdgCptoVta) {
		this.cdgCptoVta = cdgCptoVta;
	}
	public String getCobranzaMes() {
		return cobranzaMes;
	}
	public void setCobranzaMes(String cobranzaMes) {
		this.cobranzaMes = cobranzaMes;
	}
	public String getComision() {
		return comision;
	}
	public void setComision(String comision) {
		this.comision = comision;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCveCanal() {
		return cveCanal;
	}
	public void setCveCanal(String cveCanal) {
		this.cveCanal = cveCanal;
	}
	public String getCveEsquema() {
		return cveEsquema;
	}
	public void setCveEsquema(String cveEsquema) {
		this.cveEsquema = cveEsquema;
	}
	public String getCveVendedor() {
		return cveVendedor;
	}
	public void setCveVendedor(String cveVendedor) {
		this.cveVendedor = cveVendedor;
	}
	public String getDescCpto() {
		return descCpto;
	}
	public void setDescCpto(String descCpto) {
		this.descCpto = descCpto;
	}
	public String getFecTrans() {
		return fecTrans;
	}
	public void setFecTrans(String fecTrans) {
		this.fecTrans = fecTrans;
	}
	public String getMdm() {
		return mdm;
	}
	public void setMdm(String mdm) {
		this.mdm = mdm;
	}
	public String getMonto() {
		return monto;
	}
	public void setMonto(String monto) {
		this.monto = monto;
	}
	public String getNomVend() {
		return nomVend;
	}
	public void setNomVend(String nomVend) {
		this.nomVend = nomVend;
	}
	public String getOrigenEmp() {
		return origenEmp;
	}
	public void setOrigenEmp(String origenEmp) {
		this.origenEmp = origenEmp;
	}
	public String getTipoTransaccion() {
		return tipoTransaccion;
	}
	public void setTipoTransaccion(String tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}
	
	

}
