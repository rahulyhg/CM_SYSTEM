package iusacell.comisiones.vo.reportes.mensuales;

import java.util.Map;

import iusacell.comisiones.vo.ValueObject;

public class DescuentosAdicionalVO extends ValueObject{
	
	private String[] campos = {"vendedor","descCanal","contrato","descto"};
	
	private int[] longitudes = {5000,5000,5000,5000};
	
	private String vendedor;
	private String descCanal;
	private String contrato;
	private String descto;
	
	public DescuentosAdicionalVO() {}
	
	public DescuentosAdicionalVO(Map<String, Object> dato) {
		this.vendedor = String.valueOf(dato.get("VENDEDOR"));
		this.descCanal = String.valueOf(dato.get("DESC_CANAL"));
		this.contrato = String.valueOf(dato.get("CONTRATO"));
		this.descto = String.valueOf(dato.get("DESCTO"));
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
	public String getVendedor() {
		return vendedor;
	}
	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}
	public String getDescCanal() {
		return descCanal;
	}
	public void setDescCanal(String descCanal) {
		this.descCanal = descCanal;
	}
	public String getContrato() {
		return contrato;
	}
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}
	public String getDescto() {
		return descto;
	}
	public void setDescto(String descto) {
		this.descto = descto;
	}
	

}
