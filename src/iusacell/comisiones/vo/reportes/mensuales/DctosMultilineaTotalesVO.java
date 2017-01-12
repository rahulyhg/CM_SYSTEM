package iusacell.comisiones.vo.reportes.mensuales;

import java.util.Map;

import iusacell.comisiones.vo.ValueObject;

public class DctosMultilineaTotalesVO extends ValueObject{
	
	private String[] campos = {"cveContrato","fecDesc","porcDesc","descPlanServicio","rentaFija"};
	
	private int[] longitudes = {5000,5000,5000,5000,5000};
	
	private String cveContrato;
	private String fecDesc;
	private String porcDesc;
	private String descPlanServicio;
	private String rentaFija;
	
	public DctosMultilineaTotalesVO() {}
	
	public DctosMultilineaTotalesVO(Map<String, Object> dato) {
		this.cveContrato = String.valueOf(dato.get("CVE_CONTRATO"));
		this.fecDesc = String.valueOf(dato.get("FEC_DESC"));
		this.porcDesc = String.valueOf(dato.get("PORC_DESC"));
		this.descPlanServicio = String.valueOf(dato.get("DESCRIPCION_PLAN_SERVICIO"));
		this.rentaFija = String.valueOf(dato.get("RENTA_FIJA"));
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
	public String getCveContrato() {
		return cveContrato;
	}
	public void setCveContrato(String cveContrato) {
		this.cveContrato = cveContrato;
	}
	public String getFecDesc() {
		return fecDesc;
	}
	public void setFecDesc(String fecDesc) {
		this.fecDesc = fecDesc;
	}
	public String getPorcDesc() {
		return porcDesc;
	}
	public void setPorcDesc(String porcDesc) {
		this.porcDesc = porcDesc;
	}
	public String getDescPlanServicio() {
		return descPlanServicio;
	}
	public void setDescPlanServicio(String descPlanServicio) {
		this.descPlanServicio = descPlanServicio;
	}
	public String getRentaFija() {
		return rentaFija;
	}
	public void setRentaFija(String rentaFija) {
		this.rentaFija = rentaFija;
	}

}
