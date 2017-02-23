package iusacell.comisiones.vo.reportes.mensuales;

import iusacell.comisiones.vo.ValueObject;

import java.util.Map;

public class dctosAdicionalTotalesVO extends ValueObject{
	
private String[] campos = {"CONTRATO","FEC_DESC","DESC_ADI","DESCRIPCION_PLAN_SERVICIO","RENTA_FIJA"};
	
	private int[] longitudes = {5000,5000,5000,5000,5000};
	
	private String CONTRATO;
	private String FEC_DESC;
	private String DESC_ADI;
	private String DESCRIPCION_PLAN_SERVICIO;
	private String RENTA_FIJA;
	
	public dctosAdicionalTotalesVO() {}
	
	public dctosAdicionalTotalesVO(Map<String, Object> dato) {
		this.CONTRATO = String.valueOf(dato.get("CONTRATO"));
		this.FEC_DESC = String.valueOf(dato.get("FEC_DESC"));
		this.DESC_ADI = String.valueOf(dato.get("DESC_ADI"));
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
	public String getCONTRATO() {
		return CONTRATO;
	}
	public void setCONTRATO(String CONTRATO) {
		this.CONTRATO = CONTRATO;
	}
	public String getFEC_DESC() {
		return FEC_DESC;
	}
	public void setFEC_DESC(String FEC_DESC) {
		this.FEC_DESC = FEC_DESC;
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
	public String getDESC_ADI() {
		return DESC_ADI;
	}
	public void setDESC_ADI(String DESC_ADI) {
		this.DESC_ADI = DESC_ADI;
	}

}
