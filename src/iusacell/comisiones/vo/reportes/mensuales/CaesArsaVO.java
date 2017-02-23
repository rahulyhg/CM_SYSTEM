package iusacell.comisiones.vo.reportes.mensuales;

import java.util.Map;

import iusacell.comisiones.vo.ValueObject;

public class CaesArsaVO extends ValueObject{
	
	private String[] campos = {"CSI","NOM_PTOVENTAS","DATE_TIME","PRODUCTO","NUM_CEL","ABONO_ATM"};
	
	private int[] longitudes = {5000,5000,5000,5000,5000,5000};
	
	private String CSI;
	private String NOM_PTOVENTAS;
	private String DATE_TIME;
	private String PRODUCTO;
	private String NUM_CEL;
	private String ABONO_ATM;
	
	public CaesArsaVO() {}
	
	public CaesArsaVO(Map<String, Object> dato) {
		this.CSI = String.valueOf(dato.get("CSI"));
		this.NOM_PTOVENTAS = String.valueOf(dato.get("NOM_PTOVENTAS"));
		this.DATE_TIME = String.valueOf(dato.get("DATE_TIME"));
		this.PRODUCTO = String.valueOf(dato.get("PRODUCTO"));
		this.NUM_CEL = String.valueOf(dato.get("NUM_CEL"));
		this.ABONO_ATM = String.valueOf(dato.get("ABONO_ATM"));
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

	public String getCSI() {
		return CSI;
	}

	public void setCSI(String csi) {
		CSI = csi;
	}

	public String getNOM_PTOVENTAS() {
		return NOM_PTOVENTAS;
	}

	public void setNOM_PTOVENTAS(String nom_ptoventas) {
		NOM_PTOVENTAS = nom_ptoventas;
	}

	public String getDATE_TIME() {
		return DATE_TIME;
	}

	public void setDATE_TIME(String date_time) {
		DATE_TIME = date_time;
	}

	public String getPRODUCTO() {
		return PRODUCTO;
	}

	public void setPRODUCTO(String producto) {
		PRODUCTO = producto;
	}

	public String getNUM_CEL() {
		return NUM_CEL;
	}

	public void setNUM_CEL(String num_cel) {
		NUM_CEL = num_cel;
	}

	public String getABONO_ATM() {
		return ABONO_ATM;
	}

	public void setABONO_ATM(String abono_atm) {
		ABONO_ATM = abono_atm;
	}
	
	

}
