package iusacell.comisiones.vo.reportes.mensuales;

import java.util.Map;

import iusacell.comisiones.vo.ValueObject;

public class ReporteResidualesVO extends ValueObject{
	
	private String[] campos = {"PC_CVE_CANAL","PUNTO_DE_VENTA","PLAN","RENTA","CONTRATO",
			"ESTATUS_LINEA","DESCUENTO_MULTILINEA","DESCUENTO_ADICIONAL","PLAZO_FORZOSO","FECHA_ACTIVACION","FECHA_FIN_PLAZO",
			"COMISION","PERIODO","CLAVE_DIST_ORIG","CLAVE_DIST_NUEV","TIPO_CLIENTE","TELEFONO","PC_DESC_LARGA_PLAN",
			"PC_DESC_CANAL","CANAL_TP","PC_DESC_TP_CANAL","PC_NOM_PTOVENTAS"};
	
	private int[] longitudes = {5000,5000,5000,5000,5000,
			5000,5000,5000,5000,5000,
			5000,5000,5000,5000,5000,5000,5000,
			5000,5000,5000,5000,5000};
	
	private String PC_CVE_CANAL;
	private String PUNTO_DE_VENTA;
	private String PLAN;
	private String RENTA;
	private String CONTRATO;
	private String ESTATUS_LINEA;
	private String DESCUENTO_MULTILINEA;
	private String DESCUENTO_ADICIONAL;
	private String PLAZO_FORZOSO;
	private String FECHA_ACTIVACION;
	private String FECHA_FIN_PLAZO;
	private String COMISION;
	private String PERIODO;
	private String CLAVE_DIST_ORIG;
	private String CLAVE_DIST_NUEV;
	private String TIPO_CLIENTE;
	private String TELEFONO;
	private String PC_DESC_LARGA_PLAN;
	private String PC_DESC_CANAL;
	private String CANAL_TP;
	private String PC_DESC_TP_CANAL;
	private String PC_NOM_PTOVENTAS;
	
	public ReporteResidualesVO(){};
	
	public ReporteResidualesVO(Map<String, Object> dato) {
		this.PC_CVE_CANAL = String.valueOf(dato.get("PC_CVE_CANAL"));
		this.PUNTO_DE_VENTA = String.valueOf(dato.get("PUNTO_DE_VENTA"));
		this.PLAN = String.valueOf(dato.get("PLAN"));
		this.RENTA = String.valueOf(dato.get("RENTA"));
		this.CONTRATO = String.valueOf(dato.get("CONTRATO"));
		this.ESTATUS_LINEA = String.valueOf(dato.get("ESTATUS_LINEA"));
		this.DESCUENTO_MULTILINEA = String.valueOf(dato.get("DESCUENTO_MULTILINEA"));
		this.DESCUENTO_ADICIONAL = String.valueOf(dato.get("DESCUENTO_ADICIONAL"));
		this.PLAZO_FORZOSO = String.valueOf(dato.get("PLAZO_FORZOSO"));
		this.FECHA_ACTIVACION = String.valueOf(dato.get("FECHA_ACTIVACION"));
		this.FECHA_FIN_PLAZO = String.valueOf(dato.get("FECHA_FIN_PLAZO"));
		this.COMISION = String.valueOf(dato.get("COMISION"));
		this.PERIODO = String.valueOf(dato.get("PERIODO"));
		this.CLAVE_DIST_ORIG = String.valueOf(dato.get("CLAVE_DIST_ORIG"));
		this.CLAVE_DIST_NUEV = String.valueOf(dato.get("CLAVE_DIST_NUEVO"));
		this.TIPO_CLIENTE = String.valueOf(dato.get("TIPO_CLIENTE"));
		this.TELEFONO = String.valueOf(dato.get("TELEFONO"));
		this.PC_DESC_LARGA_PLAN = String.valueOf(dato.get("PC_DESC_LARGA_PLAN"));
		this.PC_DESC_CANAL = String.valueOf(dato.get("PC_DESC_CANAL"));
		this.CANAL_TP = String.valueOf(dato.get("CANAL_TP"));
		this.PC_DESC_TP_CANAL = String.valueOf(dato.get("PC_DESC_TP_CANAL"));
		this.PC_NOM_PTOVENTAS = String.valueOf(dato.get("PC_NOM_PTOVENTAS"));
		
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

	public String getPC_CVE_CANAL() {
		return PC_CVE_CANAL;
	}

	public void setPC_CVE_CANAL(String pc_cve_canal) {
		PC_CVE_CANAL = pc_cve_canal;
	}

	public String getPUNTO_DE_VENTA() {
		return PUNTO_DE_VENTA;
	}

	public void setPUNTO_DE_VENTA(String punto_de_venta) {
		PUNTO_DE_VENTA = punto_de_venta;
	}

	public String getPLAN() {
		return PLAN;
	}

	public void setPLAN(String plan) {
		PLAN = plan;
	}

	public String getRENTA() {
		return RENTA;
	}

	public void setRENTA(String renta) {
		RENTA = renta;
	}

	public String getCONTRATO() {
		return CONTRATO;
	}

	public void setCONTRATO(String contrato) {
		CONTRATO = contrato;
	}

	public String getESTATUS_LINEA() {
		return ESTATUS_LINEA;
	}

	public void setESTATUS_LINEA(String estatus_linea) {
		ESTATUS_LINEA = estatus_linea;
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

	public String getPLAZO_FORZOSO() {
		return PLAZO_FORZOSO;
	}

	public void setPLAZO_FORZOSO(String plazo_forzoso) {
		PLAZO_FORZOSO = plazo_forzoso;
	}

	public String getFECHA_ACTIVACION() {
		return FECHA_ACTIVACION;
	}

	public void setFECHA_ACTIVACION(String fecha_activacion) {
		FECHA_ACTIVACION = fecha_activacion;
	}

	public String getFECHA_FIN_PLAZO() {
		return FECHA_FIN_PLAZO;
	}

	public void setFECHA_FIN_PLAZO(String fecha_fin_plazo) {
		FECHA_FIN_PLAZO = fecha_fin_plazo;
	}

	public String getCOMISION() {
		return COMISION;
	}

	public void setCOMISION(String comision) {
		COMISION = comision;
	}

	public String getPERIODO() {
		return PERIODO;
	}

	public void setPERIODO(String periodo) {
		PERIODO = periodo;
	}

	public String getCLAVE_DIST_ORIG() {
		return CLAVE_DIST_ORIG;
	}

	public void setCLAVE_DIST_ORIG(String clave_dist_orig) {
		CLAVE_DIST_ORIG = clave_dist_orig;
	}

	public String getCLAVE_DIST_NUEV() {
		return CLAVE_DIST_NUEV;
	}

	public void setCLAVE_DIST_NUEV(String clave_dist_nuev) {
		CLAVE_DIST_NUEV = clave_dist_nuev;
	}

	public String getTIPO_CLIENTE() {
		return TIPO_CLIENTE;
	}

	public void setTIPO_CLIENTE(String tipo_cliente) {
		TIPO_CLIENTE = tipo_cliente;
	}

	public String getTELEFONO() {
		return TELEFONO;
	}

	public void setTELEFONO(String telefono) {
		TELEFONO = telefono;
	}

	public String getPC_DESC_LARGA_PLAN() {
		return PC_DESC_LARGA_PLAN;
	}

	public void setPC_DESC_LARGA_PLAN(String pc_desc_larga_plan) {
		PC_DESC_LARGA_PLAN = pc_desc_larga_plan;
	}

	public String getPC_DESC_CANAL() {
		return PC_DESC_CANAL;
	}

	public void setPC_DESC_CANAL(String pc_desc_canal) {
		PC_DESC_CANAL = pc_desc_canal;
	}

	public String getCANAL_TP() {
		return CANAL_TP;
	}

	public void setCANAL_TP(String canal_tp) {
		CANAL_TP = canal_tp;
	}

	public String getPC_DESC_TP_CANAL() {
		return PC_DESC_TP_CANAL;
	}

	public void setPC_DESC_TP_CANAL(String pc_desc_tp_canal) {
		PC_DESC_TP_CANAL = pc_desc_tp_canal;
	}

	public String getPC_NOM_PTOVENTAS() {
		return PC_NOM_PTOVENTAS;
	}

	public void setPC_NOM_PTOVENTAS(String pc_nom_ptoventas) {
		PC_NOM_PTOVENTAS = pc_nom_ptoventas;
	}
	
}
