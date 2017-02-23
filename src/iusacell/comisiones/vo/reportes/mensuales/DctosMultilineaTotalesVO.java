package iusacell.comisiones.vo.reportes.mensuales;

import java.util.Map;

import iusacell.comisiones.vo.ValueObject;

public class DctosMultilineaTotalesVO extends ValueObject{
	
	private String[] campos = {"CVE_CONTRATO","FEC_DESC","PORC_DESC","DESCRIPCION_PLAN_SERVICIO","RENTA_FIJA"};
	
	private int[] longitudes = {5000,5000,5000,5000,5000};
	
	private String CVE_CONTRATO;
	private String FEC_DESC;
	private String PORC_DESC;
	private String DESCRIPCION_PLAN_SERVICIO;
	private String RENTA_FIJA;
	
	public DctosMultilineaTotalesVO() {}
	
	public DctosMultilineaTotalesVO(Map<String, Object> dato) {
		this.CVE_CONTRATO = String.valueOf(dato.get("CVE_CONTRATO"));
		this.FEC_DESC = String.valueOf(dato.get("FEC_DESC"));
		this.PORC_DESC = String.valueOf(dato.get("PORC_DESC"));
		this.DESCRIPCION_PLAN_SERVICIO = String.valueOf(dato.get("DESCRIPCION_PLAN_SERVICIO"));
		this.RENTA_FIJA = String.valueOf(dato.get("RENTA_FIJA"));
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
	public String getCVE_CONTRATO() {
		return CVE_CONTRATO;
	}
	public void setCVE_CONTRATO(String CVE_CONTRATO) {
		this.CVE_CONTRATO = CVE_CONTRATO;
	}
	public String getFEC_DESC() {
		return FEC_DESC;
	}
	public void setFEC_DESC(String FEC_DESC) {
		this.FEC_DESC = FEC_DESC;
	}
	public String getPORC_DESC() {
		return PORC_DESC;
	}
	public void setPORC_DESC(String PORC_DESC) {
		this.PORC_DESC = PORC_DESC;
	}
	public String getDESCRIPCION_PLAN_SERVICIO() {
		return DESCRIPCION_PLAN_SERVICIO;
	}
	public void setDESCRIPCION_PLAN_SERVICIO(String DESCRIPCION_PLAN_SERVICIO) {
		this.DESCRIPCION_PLAN_SERVICIO = DESCRIPCION_PLAN_SERVICIO;
	}
	public String getRENTA_FIJA() {
		return RENTA_FIJA;
	}
	public void setRENTA_FIJA(String RENTA_FIJA) {
		this.RENTA_FIJA = RENTA_FIJA;
	}

}
