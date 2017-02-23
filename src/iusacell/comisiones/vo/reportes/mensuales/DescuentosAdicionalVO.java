package iusacell.comisiones.vo.reportes.mensuales;

import java.util.Map;

import iusacell.comisiones.vo.ValueObject;

public class DescuentosAdicionalVO extends ValueObject{
	
	private String[] campos = {"VENDEDOR","DESC_CANAL","CONTRATO","DESCTO"};
	
	private int[] longitudes = {5000,5000,5000,5000};
	
	private String VENDEDOR;
	private String DESC_CANAL;
	private String CONTRATO;
	private String DESCTO;
	
	public DescuentosAdicionalVO() {}
	
	public DescuentosAdicionalVO(Map<String, Object> dato) {
		this.VENDEDOR = String.valueOf(dato.get("VENDEDOR"));
		this.DESC_CANAL = String.valueOf(dato.get("DESC_CANAL"));
		this.CONTRATO = String.valueOf(dato.get("CONTRATO"));
		this.DESCTO = String.valueOf(dato.get("DESCTO"));
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

	public String getVENDEDOR() {
		return VENDEDOR;
	}

	public void setVENDEDOR(String vendedor) {
		VENDEDOR = vendedor;
	}

	public String getDESC_CANAL() {
		return DESC_CANAL;
	}

	public void setDESC_CANAL(String desc_canal) {
		DESC_CANAL = desc_canal;
	}

	public String getCONTRATO() {
		return CONTRATO;
	}

	public void setCONTRATO(String contrato) {
		CONTRATO = contrato;
	}

	public String getDESCTO() {
		return DESCTO;
	}

	public void setDESCTO(String descto) {
		DESCTO = descto;
	}
	
	

}
