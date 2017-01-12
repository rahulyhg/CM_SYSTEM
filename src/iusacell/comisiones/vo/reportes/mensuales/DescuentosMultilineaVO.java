package iusacell.comisiones.vo.reportes.mensuales;

import java.util.Map;

import iusacell.comisiones.vo.ValueObject;

public class DescuentosMultilineaVO extends ValueObject{
	
	private String[] campos = {"vendedor","descCanal","numContrato","porcDesc"};
	
	private int[] longitudes = {5000,5000,5000,5000};
	
	private String vendedor;
	private String descCanal;
	private String numContrato;
	private String porcDesc;
	
	public DescuentosMultilineaVO() {}
	
	public DescuentosMultilineaVO(Map<String, Object> dato) {
		this.vendedor = String.valueOf(dato.get("VENDEDOR"));
		this.descCanal = String.valueOf(dato.get("DESC_CANAL"));
		this.numContrato = String.valueOf(dato.get("NUM_CONTRATO"));
		this.porcDesc = String.valueOf(dato.get("PORC_DESC"));
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
	public String getNumContrato() {
		return numContrato;
	}
	public void setNumContrato(String numContrato) {
		this.numContrato = numContrato;
	}
	public String getPorcDesc() {
		return porcDesc;
	}
	public void setPorcDesc(String porcDesc) {
		this.porcDesc = porcDesc;
	}
	
	

}
