package iusacell.comisiones.vo.reportes.mensuales;

import iusacell.comisiones.vo.ValueObject;

import java.util.Map;

public class dctosAdicionalTotalesVO extends ValueObject{
	
private String[] campos = {"cveContrato","fecDesc","descAdi","descPlanServicio","rentaFija"};
	
	private int[] longitudes = {5000,5000,5000,5000,5000};
	
	private String cveContrato;
	private String fecDesc;
	private String descAdi;
	private String descPlanServicio;
	private String rentaFija;
	
	public dctosAdicionalTotalesVO() {}
	
	public dctosAdicionalTotalesVO(Map<String, Object> dato) {
		this.cveContrato = String.valueOf(dato.get("CONTRATO"));
		this.fecDesc = String.valueOf(dato.get("FEC_DESC"));
		this.descAdi = String.valueOf(dato.get("DESC_ADI"));
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
	public String getDescAdi() {
		return descAdi;
	}
	public void setDescAdi(String descAdi) {
		this.descAdi = descAdi;
	}

}
