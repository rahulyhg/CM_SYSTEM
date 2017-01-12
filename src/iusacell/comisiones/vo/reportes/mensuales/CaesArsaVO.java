package iusacell.comisiones.vo.reportes.mensuales;

import java.util.Map;

import iusacell.comisiones.vo.ValueObject;

public class CaesArsaVO extends ValueObject{
	
	private String[] campos = {"csi","nomPtoventas","dateTime","producto","numCel","abonoAtm"};
	
	private int[] longitudes = {5000,5000,5000,5000,5000,5000};
	
	private String csi;
	private String nomPtoventas;
	private String dateTime;
	private String producto;
	private String numCel;
	private String abonoAtm;
	
	public CaesArsaVO() {}
	
	public CaesArsaVO(Map<String, Object> dato) {
		this.csi = String.valueOf(dato.get("CSI"));
		this.nomPtoventas = String.valueOf(dato.get("NOM_PTOVENTAS"));
		this.dateTime = String.valueOf(dato.get("DATE_TIME"));
		this.producto = String.valueOf(dato.get("PRODUCTO"));
		this.numCel = String.valueOf(dato.get("NUM_CEL"));
		this.abonoAtm = String.valueOf(dato.get("ABONO_ATM"));
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
	public String getCsi() {
		return csi;
	}
	public void setCsi(String csi) {
		this.csi = csi;
	}
	public String getNomPtoventas() {
		return nomPtoventas;
	}
	public void setNomPtoventas(String nomPtoventas) {
		this.nomPtoventas = nomPtoventas;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public String getNumCel() {
		return numCel;
	}
	public void setNumCel(String numCel) {
		this.numCel = numCel;
	}
	public String getAbonoAtm() {
		return abonoAtm;
	}
	public void setAbonoAtm(String abonoAtm) {
		this.abonoAtm = abonoAtm;
	}
	
	

}
