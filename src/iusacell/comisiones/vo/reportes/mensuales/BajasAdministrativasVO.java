package iusacell.comisiones.vo.reportes.mensuales;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import iusacell.comisiones.vo.ValueObject;

public class BajasAdministrativasVO extends ValueObject{
	
	private String[] campos = {"BB_CVE_CONTRATO","BB_CUENTA","BB_FEC_BAJA","BB_FEC_ACT","BB_CVE_PLAN","BB_CVE_CANAL","BB_CVE_USUARIO",
			"BB_ESN","BB_MDN","BB_RAZON_MOVIMIENTO","BB_MOV_ERRONEOS"};
	
	private int[] longitudes = {5000,5000,5000,5000,5000,5000,5000,
			5000,5000,5000,5000};
	
	private String BB_CVE_CONTRATO;
	private String BB_CUENTA;
	private Date BB_FEC_BAJA;
	private Date BB_FEC_ACT;
	private String BB_CVE_PLAN;
	private String BB_CVE_CANAL;
	private String BB_CVE_USUARIO;
	private String BB_ESN;
	private String BB_MDN;
	private String BB_RAZON_MOVIMIENTO;
	private String BB_MOV_ERRONEOS;
	
	public BajasAdministrativasVO() {}
	
	public BajasAdministrativasVO(Map<String, Object> dato) {
		this.BB_CVE_CONTRATO = String.valueOf(dato.get("BB_CVE_CONTRATO"));
		this.BB_CUENTA = String.valueOf(dato.get("BB_CUENTA"));
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		
		Date fechaBaja = (Date)dato.get("BB_FEC_BAJA");
		if(fechaBaja!=null)
		{	
			dateformat.format(fechaBaja);
			this.BB_FEC_BAJA=fechaBaja;
		}
		Date fechaAct = (Date)dato.get("BB_FEC_ACT");
		if(fechaAct!=null)
		{	
			dateformat.format(fechaAct);
			this.BB_FEC_ACT=fechaAct;
		}
		
		this.BB_CVE_PLAN = String.valueOf(dato.get("BB_CVE_PLAN"));
		this.BB_CVE_CANAL = String.valueOf(dato.get("BB_CVE_CANAL"));
		this.BB_CVE_USUARIO = String.valueOf(dato.get("BB_CVE_USUARIO"));
		this.BB_ESN = String.valueOf(dato.get("BB_ESN"));
		this.BB_MDN = String.valueOf(dato.get("BB_MDN"));
		this.BB_RAZON_MOVIMIENTO = String.valueOf(dato.get("BB_RAZON_MOVIMIENTO"));
		this.BB_MOV_ERRONEOS = String.valueOf(dato.get("BB_MOV_ERRONEOS"));
		
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

	public String getBB_CVE_CONTRATO() {
		return BB_CVE_CONTRATO;
	}

	public void setBB_CVE_CONTRATO(String bb_cve_contrato) {
		BB_CVE_CONTRATO = bb_cve_contrato;
	}

	public String getBB_CUENTA() {
		return BB_CUENTA;
	}

	public void setBB_CUENTA(String bb_cuenta) {
		BB_CUENTA = bb_cuenta;
	}

	public Date getBB_FEC_BAJA() {
		return BB_FEC_BAJA;
	}

	public void setBB_FEC_BAJA(Date bb_fec_baja) {
		BB_FEC_BAJA = bb_fec_baja;
	}

	public Date getBB_FEC_ACT() {
		return BB_FEC_ACT;
	}

	public void setBB_FEC_ACT(Date bb_fec_act) {
		BB_FEC_ACT = bb_fec_act;
	}

	public String getBB_CVE_PLAN() {
		return BB_CVE_PLAN;
	}

	public void setBB_CVE_PLAN(String bb_cve_plan) {
		BB_CVE_PLAN = bb_cve_plan;
	}

	public String getBB_CVE_CANAL() {
		return BB_CVE_CANAL;
	}

	public void setBB_CVE_CANAL(String bb_cve_canal) {
		BB_CVE_CANAL = bb_cve_canal;
	}

	public String getBB_CVE_USUARIO() {
		return BB_CVE_USUARIO;
	}

	public void setBB_CVE_USUARIO(String bb_cve_usuario) {
		BB_CVE_USUARIO = bb_cve_usuario;
	}

	public String getBB_ESN() {
		return BB_ESN;
	}

	public void setBB_ESN(String bb_esn) {
		BB_ESN = bb_esn;
	}

	public String getBB_MDN() {
		return BB_MDN;
	}

	public void setBB_MDN(String bb_mdn) {
		BB_MDN = bb_mdn;
	}

	public String getBB_RAZON_MOVIMIENTO() {
		return BB_RAZON_MOVIMIENTO;
	}

	public void setBB_RAZON_MOVIMIENTO(String bb_razon_movimiento) {
		BB_RAZON_MOVIMIENTO = bb_razon_movimiento;
	}

	public String getBB_MOV_ERRONEOS() {
		return BB_MOV_ERRONEOS;
	}

	public void setBB_MOV_ERRONEOS(String bb_mov_erroneos) {
		BB_MOV_ERRONEOS = bb_mov_erroneos;
	}
	
	
	

}
