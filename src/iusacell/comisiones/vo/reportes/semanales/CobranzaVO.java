package iusacell.comisiones.vo.reportes.semanales;

import java.util.Map;

import iusacell.comisiones.vo.ValueObject;

public class CobranzaVO extends ValueObject{
	
	private String[] campos = {"region","csi","descCanal","cveCanal","monto","comision","descCpto",
			"pobkpombre","desDivision","edodenombre","origenEmp"};
	
	private int[] longitudes = {5000,5000,5000,5000,5000,5000,5000,
			5000,5000,5000,5000};
	
	private String region;
	private String csi;
	private String descCanal;
	private String cveCanal;
	private String monto;
	private String comision;
	private String descCpto;
	private String pobkpombre;
	private String desDivision;
	private String edodenombre;
	private String origenEmp;
	
	public CobranzaVO() {}
	
	public CobranzaVO(Map<String, Object> dato) {
		this.region = String.valueOf(dato.get("REGION"));
		this.csi = String.valueOf(dato.get("CSI"));
		this.descCanal = String.valueOf(dato.get("DESC_CANAL"));
		this.cveCanal = String.valueOf(dato.get("CVE_CANAL"));
		this.monto = String.valueOf(dato.get("MONTO"));
		this.comision = String.valueOf(dato.get("COMISION"));
		this.descCpto = String.valueOf(dato.get("DESC_CPTO"));
		this.pobkpombre = String.valueOf(dato.get("POBKPNOMBRE"));
		this.desDivision = String.valueOf(dato.get("DES_DIVISION"));
		this.edodenombre = String.valueOf(dato.get("EDODENOMBRE"));
		this.origenEmp = String.valueOf(dato.get("ORIGEN_EMP"));
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
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCsi() {
		return csi;
	}
	public void setCsi(String csi) {
		this.csi = csi;
	}
	public String getDescCanal() {
		return descCanal;
	}
	public void setDescCanal(String descCanal) {
		this.descCanal = descCanal;
	}
	public String getCveCanal() {
		return cveCanal;
	}
	public void setCveCanal(String cveCanal) {
		this.cveCanal = cveCanal;
	}
	public String getMonto() {
		return monto;
	}
	public void setMonto(String monto) {
		this.monto = monto;
	}
	public String getComision() {
		return comision;
	}
	public void setComision(String comision) {
		this.comision = comision;
	}
	public String getDescCpto() {
		return descCpto;
	}
	public void setDescCpto(String descCpto) {
		this.descCpto = descCpto;
	}
	public String getPobkpombre() {
		return pobkpombre;
	}
	public void setPobkpombre(String pobkpombre) {
		this.pobkpombre = pobkpombre;
	}
	public String getDesDivision() {
		return desDivision;
	}
	public void setDesDivision(String desDivision) {
		this.desDivision = desDivision;
	}
	public String getEdodenombre() {
		return edodenombre;
	}
	public void setEdodenombre(String edodenombre) {
		this.edodenombre = edodenombre;
	}
	public String getOrigenEmp() {
		return origenEmp;
	}
	public void setOrigenEmp(String origenEmp) {
		this.origenEmp = origenEmp;
	}
	
	

}
