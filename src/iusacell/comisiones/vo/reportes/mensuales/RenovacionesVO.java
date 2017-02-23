package iusacell.comisiones.vo.reportes.mensuales;

import java.util.Map;

import iusacell.comisiones.vo.ValueObject;

public class RenovacionesVO extends ValueObject{
	
	private String[] campos = {"EMPRESARIO","PERIODO","REGION","DESCRIPCION_DEL_PLAN","FECHA_RENOVACION",
			"FECHA_ACTIVACION","PLAZO_FORZOSO","CUENTA","CONTRATO","ESN","TELEFONO","CLIENTE",
			"DESCUENTO_MULTILINEA","DESCUENTO_ADICIONAL","MARCA","RENTA","COMISION","POBLACION",
			"DIVISION","ESTADO"};
	private int[] longitudes = {5000,5000,5000,5000,5000,
			5000,5000,5000,5000,5000,5000,5000,
			5000,5000,5000,5000,5000,5000,
			5000,5000};

	private String EMPRESARIO;
	private String PERIODO;
	private String REGION;
	private String DESCRIPCION_DEL_PLAN;
	private String FECHA_RENOVACION;
	private String FECHA_ACTIVACION;
	private String PLAZO_FORZOSO;
	private String CUENTA;
	private String CONTRATO;
	private String ESN;
	private String TELEFONO;
	private String CLIENTE;
	private String DESCUENTO_MULTILINEA;
	private String DESCUENTO_ADICIONAL;
	private String MARCA;
	private String RENTA;
	private String COMISION;
	private String POBLACION;
	private String DIVISION;
	private String ESTADO;
	
	public RenovacionesVO() {}
	
	public RenovacionesVO(Map<String, Object> dato) {
		this.EMPRESARIO = String.valueOf(dato.get("EMPRESARIO"));
		this.PERIODO = String.valueOf(dato.get("PERIODO"));
		this.REGION = String.valueOf(dato.get("REGION"));
		this.DESCRIPCION_DEL_PLAN = String.valueOf(dato.get("DESCRIPCION_DEL_PLAN"));
		this.FECHA_RENOVACION = String.valueOf(dato.get("FECHA_RENOVACION"));
		this.FECHA_ACTIVACION = String.valueOf(dato.get("FECHA_ACTIVACION"));
		this.PLAZO_FORZOSO = String.valueOf(dato.get("PLAZO_FORZOSO"));
		this.CUENTA = String.valueOf(dato.get("CUENTA"));
		this.CONTRATO = String.valueOf(dato.get("CONTRATO"));
		this.ESN = String.valueOf(dato.get("ESN"));
		this.TELEFONO = String.valueOf(dato.get("TELEFONO"));
		this.CLIENTE = String.valueOf(dato.get("CLIENTE"));
		this.DESCUENTO_MULTILINEA = String.valueOf(dato.get("DESCUENTO_MULTILINEA"));
		this.DESCUENTO_ADICIONAL = String.valueOf(dato.get("DESCUENTO_ADICIONAL"));
		this.MARCA = String.valueOf(dato.get("MARCA"));
		this.RENTA = String.valueOf(dato.get("RENTA"));
		this.COMISION = String.valueOf(dato.get("COMISION"));
		this.POBLACION = String.valueOf(dato.get("POBLACION"));
		this.DIVISION = String.valueOf(dato.get("DIVISION"));
		this.ESTADO = String.valueOf(dato.get("ESTADO"));
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

	public String getEMPRESARIO() {
		return EMPRESARIO;
	}

	public void setEMPRESARIO(String empresario) {
		EMPRESARIO = empresario;
	}

	public String getPERIODO() {
		return PERIODO;
	}

	public void setPERIODO(String periodo) {
		PERIODO = periodo;
	}

	public String getREGION() {
		return REGION;
	}

	public void setREGION(String region) {
		REGION = region;
	}

	public String getDESCRIPCION_DEL_PLAN() {
		return DESCRIPCION_DEL_PLAN;
	}

	public void setDESCRIPCION_DEL_PLAN(String descripcion_del_plan) {
		DESCRIPCION_DEL_PLAN = descripcion_del_plan;
	}

	public String getFECHA_RENOVACION() {
		return FECHA_RENOVACION;
	}

	public void setFECHA_RENOVACION(String fecha_renovacion) {
		FECHA_RENOVACION = fecha_renovacion;
	}

	public String getFECHA_ACTIVACION() {
		return FECHA_ACTIVACION;
	}

	public void setFECHA_ACTIVACION(String fecha_activacion) {
		FECHA_ACTIVACION = fecha_activacion;
	}

	public String getPLAZO_FORZOSO() {
		return PLAZO_FORZOSO;
	}

	public void setPLAZO_FORZOSO(String plazo_forzoso) {
		PLAZO_FORZOSO = plazo_forzoso;
	}

	public String getCUENTA() {
		return CUENTA;
	}

	public void setCUENTA(String cuenta) {
		CUENTA = cuenta;
	}

	public String getCONTRATO() {
		return CONTRATO;
	}

	public void setCONTRATO(String contrato) {
		CONTRATO = contrato;
	}

	public String getESN() {
		return ESN;
	}

	public void setESN(String esn) {
		ESN = esn;
	}

	public String getTELEFONO() {
		return TELEFONO;
	}

	public void setTELEFONO(String telefono) {
		TELEFONO = telefono;
	}

	public String getCLIENTE() {
		return CLIENTE;
	}

	public void setCLIENTE(String cliente) {
		CLIENTE = cliente;
	}

	public String getDESCUENTO_MULTILINEA() {
		return DESCUENTO_MULTILINEA;
	}

	public void setDESCUENTO_MULTILINEA(String descuento_multilinea) {
		DESCUENTO_MULTILINEA = descuento_multilinea;
	}

	public String getDESCUENTO_ADICIONAL() {
		return DESCUENTO_ADICIONAL;
	}

	public void setDESCUENTO_ADICIONAL(String descuento_adicional) {
		DESCUENTO_ADICIONAL = descuento_adicional;
	}

	public String getMARCA() {
		return MARCA;
	}

	public void setMARCA(String marca) {
		MARCA = marca;
	}

	public String getRENTA() {
		return RENTA;
	}

	public void setRENTA(String renta) {
		RENTA = renta;
	}

	public String getCOMISION() {
		return COMISION;
	}

	public void setCOMISION(String comision) {
		COMISION = comision;
	}

	public String getPOBLACION() {
		return POBLACION;
	}

	public void setPOBLACION(String poblacion) {
		POBLACION = poblacion;
	}

	public String getDIVISION() {
		return DIVISION;
	}

	public void setDIVISION(String division) {
		DIVISION = division;
	}

	public String getESTADO() {
		return ESTADO;
	}

	public void setESTADO(String estado) {
		ESTADO = estado;
	}
	
}
