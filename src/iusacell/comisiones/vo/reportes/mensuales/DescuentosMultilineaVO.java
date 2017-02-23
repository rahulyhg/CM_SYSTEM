package iusacell.comisiones.vo.reportes.mensuales;

import java.util.Map;

import iusacell.comisiones.vo.ValueObject;

public class DescuentosMultilineaVO extends ValueObject{
	
	private String[] campos = {"VENDEDOR","DESC_CANAL","NUM_CONTRATO","PORC_DESC"};
	
	private int[] longitudes = {5000,5000,5000,5000};
	
	private String VENDEDOR;
	private String DESC_CANAL;
	private String NUM_CONTRATO;
	private String PORC_DESC;
	
	public DescuentosMultilineaVO() {}
	
	public DescuentosMultilineaVO(Map<String, Object> dato) {
		this.VENDEDOR = String.valueOf(dato.get("VENDEDOR"));
		this.DESC_CANAL = String.valueOf(dato.get("DESC_CANAL"));
		this.NUM_CONTRATO = String.valueOf(dato.get("NUM_CONTRATO"));
		this.PORC_DESC = String.valueOf(dato.get("PORC_DESC"));
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

	public String getNUM_CONTRATO() {
		return NUM_CONTRATO;
	}

	public void setNUM_CONTRATO(String num_contrato) {
		NUM_CONTRATO = num_contrato;
	}

	public String getPORC_DESC() {
		return PORC_DESC;
	}

	public void setPORC_DESC(String porc_desc) {
		PORC_DESC = porc_desc;
	}
		
	

}
