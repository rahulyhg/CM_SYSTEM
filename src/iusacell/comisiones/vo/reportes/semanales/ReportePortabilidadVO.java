package iusacell.comisiones.vo.reportes.semanales;

import java.util.Map;

public class ReportePortabilidadVO {

	private String[] campos = {"mdn","mdnProvisional","fechaPortado"};
	
	private int[] longitudes = {5000,5000,5000};
	
	private String mdn;
	private String mdnProvisional;
	private String fechaPortado;
	
	public ReportePortabilidadVO() {}
	
	public ReportePortabilidadVO(Map<String, Object> dato) {
		this.mdn = String.valueOf(dato.get("MDN"));
		this.mdnProvisional = String.valueOf(dato.get("MDN_PROVISIONAL"));
		this.fechaPortado = String.valueOf(dato.get("FECHA_PORTADO"));
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
	public String getMdn() {
		return mdn;
	}
	public void setMdn(String mdn) {
		this.mdn = mdn;
	}
	public String getMdnProvisional() {
		return mdnProvisional;
	}
	public void setMdnProvisional(String mdnProvisional) {
		this.mdnProvisional = mdnProvisional;
	}
	public String getFechaPortado() {
		return fechaPortado;
	}
	public void setFechaPortado(String fechaPortado) {
		this.fechaPortado = fechaPortado;
	}
	
	
}
