package iusacell.comisiones.vo.reportes.semanales;

import java.util.Map;

public class ReportePortabilidadVO {

	private String[] campos = {"MDN","MDN_PROVISIONAL","FECHA_PORTADO"};
	
	private int[] longitudes = {5000,5000,5000};
	
	private String MDN;
	private String MDN_PROVISIONAL;
	private String FECHA_PORTADO;
	
	public ReportePortabilidadVO() {}
	
	public ReportePortabilidadVO(Map<String, Object> dato) {
		this.MDN = String.valueOf(dato.get("MDN"));
		this.MDN_PROVISIONAL = String.valueOf(dato.get("MDN_PROVISIONAL"));
		this.FECHA_PORTADO = String.valueOf(dato.get("FECHA_PORTADO"));
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
	public String getMDN() {
		return MDN;
	}
	public void setMDN(String MDN) {
		this.MDN = MDN;
	}
	public String getMDN_PROVISIONAL() {
		return MDN_PROVISIONAL;
	}
	public void setMDN_PROVISIONAL(String MDN_PROVISIONAL) {
		this.MDN_PROVISIONAL = MDN_PROVISIONAL;
	}
	public String getFECHA_PORTADO() {
		return FECHA_PORTADO;
	}
	public void setFECHA_PORTADO(String FECHA_PORTADO) {
		this.FECHA_PORTADO = FECHA_PORTADO;
	}
	
	
}
