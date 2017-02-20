package iusacell.comisiones.vo.reportes.mensuales;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import iusacell.comisiones.vo.ValueObject;

public class MovimientosAdonsVO extends ValueObject implements Comparable<MovimientosAdonsVO>{

	/*private String[] campos = {"cveServ","descripcionServ","fecActServ","fecDesacServ","numContrato",
			"numTelefono","comision","comisionChb","concepto","cveCanal","cvePaquete","descCanal",
			"descLargaPlan","diasBaja","diasCumplidos","fechaVenta","mesBaja","mesPago","porcDesc",
			"porcDescAdi","tipoMovimiento","plazo","rentaServ"};*/
	
	private String[] campos = {"PC_CVE_CANAL","PC_DESC_CANAL","PC_TIPO_MOVIMIENTO","NUM_CONTRATO","NUM_TELEFONO",
			"PC_CVE_PAQUETE","PC_DESC_LARGA_PLAN","PLAZO","PC_FECHA_VENTA","FEC_ACT_SERV","FEC_DESAC_SERV","PC_DIAS_BAJA",
			"PC_DIAS_CUMPLIDOS","CVE_SERV","DESCRIPCION_SERV","RENTA_SERV","PC_PORC_DESC","PC_PORC_DESC_ADI","PC_COMISION",
			"PC_COMISION_CHB","PC_CONCEPTO","PC_MES_PAGO","PC_MES_BAJA"};
	
	private int[] longitudes = {5000,5000,5000,5000,5000,
			5000,5000,5000,5000,5000,5000,5000,
			5000,5000,5000,5000,5000,5000,5000,
			5000,5000,5000,5000};
	
	private String CVE_SERV;
	private String PC_DESC_CANAL;
	private String DESCRIPCION_SERV;
	private Date FEC_ACT_SERV;
	private Date FEC_DESAC_SERV;
	private String NUM_CONTRATO;
	private String NUM_TELEFONO;
	private String PC_COMISION;
	private String PC_COMISION_CHB;
	private String PC_CONCEPTO;
	private String PC_CVE_CANAL;
	private String PC_CVE_PAQUETE;
	private String PC_DESC_LARGA_PLAN;
	private String PC_DIAS_BAJA;
	private String PC_DIAS_CUMPLIDOS;
	private Date PC_FECHA_VENTA;
	private String PC_MES_BAJA;
	private String PC_MES_PAGO;
	private String PC_PORC_DESC;
	private String PC_PORC_DESC_ADI;
	private String PC_TIPO_MOVIMIENTO;
	private String PLAZO;
	private String RENTA_SERV;
	
	public MovimientosAdonsVO() {}
	
	public MovimientosAdonsVO(Map<String, Object> dato) {
		this.setCVE_SERV(String.valueOf(dato.get("CVE_SERV")));
		this.setPC_DESC_CANAL(String.valueOf(dato.get("PC_DESC_CANAL")));
		this.setDESCRIPCION_SERV(String.valueOf(dato.get("DESCRIPCION_SERV")));
		this.setNUM_CONTRATO(String.valueOf(dato.get("NUM_CONTRATO")));
		this.setNUM_TELEFONO(String.valueOf(dato.get("NUM_TELEFONO")));
		this.PC_COMISION = String.valueOf(dato.get("PC_COMISION"));
		this.PC_COMISION_CHB = String.valueOf(dato.get("PC_COMISION_CHB"));
		this.PC_CONCEPTO = String.valueOf(dato.get("PC_CONCEPTO"));
		this.setPC_CVE_CANAL(String.valueOf(dato.get("PC_CVE_CANAL")));
		this.setPC_CVE_PAQUETE(String.valueOf(dato.get("PC_CVE_PAQUETE")));
		this.setPC_DESC_LARGA_PLAN(String.valueOf(dato.get("PC_DESC_LARGA_PLAN")));
		this.setPC_DIAS_BAJA(String.valueOf(dato.get("PC_DIAS_BAJA")));
		this.setPC_DIAS_CUMPLIDOS(String.valueOf(dato.get("PC_DIAS_CUMPLIDOS")));
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		Date date= null;
		try {
			String fechaAct = (String)dato.get("FEC_ACT_SERV");
			if(fechaAct!=null)
			{	
				date = dateformat.parse((String)dato.get("FEC_ACT_SERV"));
				this.FEC_ACT_SERV=date;
			}
			String fechaDesact = (String)dato.get("FEC_DESAC_SERV");
			if(fechaDesact!=null)
			{	
				date = dateformat.parse((String)dato.get("FEC_DESAC_SERV"));
				this.FEC_DESAC_SERV=date;
			}		
			String fechaVenta = (String)dato.get("PC_FECHA_VENTA");
			if(fechaVenta!=null)
			{	
				date = dateformat.parse((String)dato.get("PC_FECHA_VENTA"));
				this.setPC_FECHA_VENTA(date);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.setPC_MES_BAJA(String.valueOf(dato.get("PC_MES_BAJA")));
		this.PC_MES_PAGO = String.valueOf(dato.get("PC_MES_PAGO"));
		this.setPC_PORC_DESC(String.valueOf(dato.get("PC_PORC_DESC")));
		this.setPC_PORC_DESC_ADI(String.valueOf(dato.get("PC_PORC_DESC_ADI")));
		this.setPC_TIPO_MOVIMIENTO(String.valueOf(dato.get("PC_TIPO_MOVIMIENTO")));
		this.setPLAZO(String.valueOf(dato.get("PLAZO")));
		this.setRENTA_SERV(String.valueOf(dato.get("RENTA_SERV")));
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
	
	public void setPC_CVE_CANAL(String pC_CVE_CANAL) {
		PC_CVE_CANAL = pC_CVE_CANAL;
	}

	public String getPC_CVE_CANAL() {
		return PC_CVE_CANAL;
	}

	public void setPC_DESC_CANAL(String pC_DESC_CANAL) {
		PC_DESC_CANAL = pC_DESC_CANAL;
	}

	public String getPC_DESC_CANAL() {
		return PC_DESC_CANAL;
	}

	public void setPC_TIPO_MOVIMIENTO(String pC_TIPO_MOVIMIENTO) {
		PC_TIPO_MOVIMIENTO = pC_TIPO_MOVIMIENTO;
	}

	public String getPC_TIPO_MOVIMIENTO() {
		return PC_TIPO_MOVIMIENTO;
	}

	public void setNUM_CONTRATO(String nUM_CONTRATO) {
		NUM_CONTRATO = nUM_CONTRATO;
	}

	public String getNUM_CONTRATO() {
		return NUM_CONTRATO;
	}

	public void setNUM_TELEFONO(String nUM_TELEFONO) {
		NUM_TELEFONO = nUM_TELEFONO;
	}

	public String getNUM_TELEFONO() {
		return NUM_TELEFONO;
	}

	public void setPC_CVE_PAQUETE(String pC_CVE_PAQUETE) {
		PC_CVE_PAQUETE = pC_CVE_PAQUETE;
	}

	public String getPC_CVE_PAQUETE() {
		return PC_CVE_PAQUETE;
	}

	public void setPC_DESC_LARGA_PLAN(String pC_DESC_LARGA_PLAN) {
		PC_DESC_LARGA_PLAN = pC_DESC_LARGA_PLAN;
	}

	public String getPC_DESC_LARGA_PLAN() {
		return PC_DESC_LARGA_PLAN;
	}

	public void setPLAZO(String pLAZO) {
		PLAZO = pLAZO;
	}

	public String getPLAZO() {
		return PLAZO;
	}

	public void setPC_FECHA_VENTA(Date pC_FECHA_VENTA) {
		PC_FECHA_VENTA = pC_FECHA_VENTA;
	}

	public Date getPC_FECHA_VENTA() {
		return PC_FECHA_VENTA;
	}

	public void setFEC_ACT_SERV(Date fEC_ACT_SERV) {
		FEC_ACT_SERV = fEC_ACT_SERV;
	}

	public Date getFEC_ACT_SERV() {
		return FEC_ACT_SERV;
	}

	public void setFEC_DESAC_SERV(Date fEC_DESAC_SERV) {
		FEC_DESAC_SERV = fEC_DESAC_SERV;
	}

	public Date getFEC_DESAC_SERV() {
		return FEC_DESAC_SERV;
	}

	public void setPC_DIAS_BAJA(String pC_DIAS_BAJA) {
		PC_DIAS_BAJA = pC_DIAS_BAJA;
	}

	public String getPC_DIAS_BAJA() {
		return PC_DIAS_BAJA;
	}

	public void setPC_DIAS_CUMPLIDOS(String pC_DIAS_CUMPLIDOS) {
		PC_DIAS_CUMPLIDOS = pC_DIAS_CUMPLIDOS;
	}

	public String getPC_DIAS_CUMPLIDOS() {
		return PC_DIAS_CUMPLIDOS;
	}

	public void setCVE_SERV(String cVE_SERV) {
		CVE_SERV = cVE_SERV;
	}

	public String getCVE_SERV() {
		return CVE_SERV;
	}

	public void setDESCRIPCION_SERV(String dESCRIPCION_SERV) {
		DESCRIPCION_SERV = dESCRIPCION_SERV;
	}

	public String getDESCRIPCION_SERV() {
		return DESCRIPCION_SERV;
	}

	public void setRENTA_SERV(String rENTA_SERV) {
		RENTA_SERV = rENTA_SERV;
	}

	public String getRENTA_SERV() {
		return RENTA_SERV;
	}

	public void setPC_PORC_DESC(String pC_PORC_DESC) {
		PC_PORC_DESC = pC_PORC_DESC;
	}

	public String getPC_PORC_DESC() {
		return PC_PORC_DESC;
	}

	public void setPC_PORC_DESC_ADI(String pC_PORC_DESC_ADI) {
		PC_PORC_DESC_ADI = pC_PORC_DESC_ADI;
	}

	public String getPC_PORC_DESC_ADI() {
		return PC_PORC_DESC_ADI;
	}

	public void setPC_COMISION(String pC_COMISION) {
		PC_COMISION = pC_COMISION;
	}

	public String getPC_COMISION() {
		return PC_COMISION;
	}

	public void setPC_COMISION_CHB(String pC_COMISION_CHB) {
		PC_COMISION_CHB = pC_COMISION_CHB;
	}

	public String getPC_COMISION_CHB() {
		return PC_COMISION_CHB;
	}

	public void setPC_CONCEPTO(String pC_CONCEPTO) {
		PC_CONCEPTO = pC_CONCEPTO;
	}

	public String getPC_CONCEPTO() {
		return PC_CONCEPTO;
	}

	public void setPC_MES_PAGO(String pC_MES_PAGO) {
		PC_MES_PAGO = pC_MES_PAGO;
	}

	public String getPC_MES_PAGO() {
		return PC_MES_PAGO;
	}

	public void setPC_MES_BAJA(String pC_MES_BAJA) {
		PC_MES_BAJA = pC_MES_BAJA;
	}

	public String getPC_MES_BAJA() {
		return PC_MES_BAJA;
	}
	
	public int compareTo(MovimientosAdonsVO o) {
		return this.getFEC_ACT_SERV().compareTo(o.getFEC_ACT_SERV());
		
	}
	
	
}
