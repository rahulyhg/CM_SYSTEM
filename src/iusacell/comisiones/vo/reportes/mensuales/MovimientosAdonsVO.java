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
	
	private String[] campos = {"cveCanal","descripcionCanal","tipoMovimiento","numContrato","numTelefono",
			"cvePaquete","descLargaPlan","plazo","fechaVenta","fecActServ","fecDesacServ","diasBaja",
			"diasCumplidos","cveServ","descripcionServ","rentaServ","porcDesc","porcDescAdi","comision",
			"comisionChb","concepto","mesPago","mesBaja"};
	
	private int[] longitudes = {5000,5000,5000,5000,5000,
			5000,5000,5000,5000,5000,5000,5000,
			5000,5000,5000,5000,5000,5000,5000,
			5000,5000,5000,5000};
	
	private String cveServ;
	private String descripcionCanal;
	private String descripcionServ;
	public String getDescripcionServ() {
		return descripcionServ;
	}

	public void setDescripcionServ(String descripcionServ) {
		this.descripcionServ = descripcionServ;
	}
	private Date fecActServ;
	private Date fecDesacServ;
	private String numContrato;
	private String numTelefono;
	private String comision;
	private String comisionChb;
	private String concepto;
	private String cveCanal;
	private String cvePaquete;
	private String descCanal;
	private String descLargaPlan;
	private String diasBaja;
	private String diasCumplidos;
	private Date fechaVenta;
	private String mesBaja;
	private String mesPago;
	private String porcDesc;
	private String porcDescAdi;
	private String tipoMovimiento;
	private String plazo;
	private String rentaServ;
	
	public MovimientosAdonsVO() {}
	
	public MovimientosAdonsVO(Map<String, Object> dato) {
		this.cveServ = String.valueOf(dato.get("CVE_SERV"));
		this.descripcionCanal = String.valueOf(dato.get("PC_DESC_CANAL"));
		this.descripcionServ = String.valueOf(dato.get("DESCRIPCION_SERV"));
		this.numContrato = String.valueOf(dato.get("NUM_CONTRATO"));
		this.numTelefono = String.valueOf(dato.get("NUM_TELEFONO"));
		this.comision = String.valueOf(dato.get("PC_COMISION"));
		this.comisionChb = String.valueOf(dato.get("PC_COMISION_CHB"));
		this.concepto = String.valueOf(dato.get("PC_CONCEPTO"));
		this.cveCanal = String.valueOf(dato.get("PC_CVE_CANAL"));
		this.cvePaquete = String.valueOf(dato.get("PC_CVE_PAQUETE"));
		this.descCanal = String.valueOf(dato.get("PC_DESC_CANAL"));
		this.descLargaPlan = String.valueOf(dato.get("PC_DESC_LARGA_PLAN"));
		this.diasBaja = String.valueOf(dato.get("PC_DIAS_BAJA"));
		this.diasCumplidos = String.valueOf(dato.get("PC_DIAS_CUMPLIDOS"));
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		Date date= null;
		try {
			date = dateformat.parse((String)dato.get("FEC_ACT_SERV"));
			this.fecActServ = date;
			
			date = dateformat.parse((String)dato.get("FEC_ACT_SERV"));
			this.fecDesacServ = date;
			
			date = dateformat.parse((String)dato.get("PC_FECHA_VENTA"));
			this.fechaVenta = date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.mesBaja = String.valueOf(dato.get("PC_MES_BAJA"));
		this.mesPago = String.valueOf(dato.get("PC_MES_PAGO"));
		this.porcDesc = String.valueOf(dato.get("PC_PORC_DESC"));
		this.porcDescAdi = String.valueOf(dato.get("PC_PORC_DESC_ADI"));
		this.tipoMovimiento = String.valueOf(dato.get("PC_TIPO_MOVIMIENTO"));
		this.plazo = String.valueOf(dato.get("PLAZO"));
		this.rentaServ = String.valueOf(dato.get("RENTA_SERV"));
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
	public String getCveServ() {
		return cveServ;
	}
	public void setCveServ(String cveServ) {
		this.cveServ = cveServ;
	}
	public String getDescripcionCanal() {
		return descripcionCanal;
	}
	public void setDescripcionCanal(String descripcionCanal) {
		this.descripcionCanal= descripcionCanal;
	}
	public Date getFecActServ() {
		return fecActServ;
	}
	public void setFecActServ(Date fecActServ) {
		this.fecActServ = fecActServ;
	}
	public Date getFecDesacServ() {
		return fecDesacServ;
	}
	public void setFecDesacServ(Date fecDesacServ) {
		this.fecDesacServ = fecDesacServ;
	}
	public String getNumContrato() {
		return numContrato;
	}
	public void setNumContrato(String numContrato) {
		this.numContrato = numContrato;
	}
	public String getNumTelefono() {
		return numTelefono;
	}
	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}
	public String getComision() {
		return comision;
	}
	public void setComision(String comision) {
		this.comision = comision;
	}
	public String getComisionChb() {
		return comisionChb;
	}
	public void setComisionChb(String comisionChb) {
		this.comisionChb = comisionChb;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public String getCveCanal() {
		return cveCanal;
	}
	public void setCveCanal(String cveCanal) {
		this.cveCanal = cveCanal;
	}
	public String getCvePaquete() {
		return cvePaquete;
	}
	public void setCvePaquete(String cvePaquete) {
		this.cvePaquete = cvePaquete;
	}
	public String getDescCanal() {
		return descCanal;
	}
	public void setDescCanal(String descCanal) {
		this.descCanal = descCanal;
	}
	public String getDescLargaPlan() {
		return descLargaPlan;
	}
	public void setDescLargaPlan(String descLargaPlan) {
		this.descLargaPlan = descLargaPlan;
	}
	public String getDiasBaja() {
		return diasBaja;
	}
	public void setDiasBaja(String diasBaja) {
		this.diasBaja = diasBaja;
	}
	public String getDiasCumplidos() {
		return diasCumplidos;
	}
	public void setDiasCumplidos(String diasCumplidos) {
		this.diasCumplidos = diasCumplidos;
	}
	public Date getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	public String getMesBaja() {
		return mesBaja;
	}
	public void setMesBaja(String mesBaja) {
		this.mesBaja = mesBaja;
	}
	public String getMesPago() {
		return mesPago;
	}
	public void setMesPago(String mesPago) {
		this.mesPago = mesPago;
	}
	public String getPorcDesc() {
		return porcDesc;
	}
	public void setPorcDesc(String porcDesc) {
		this.porcDesc = porcDesc;
	}
	public String getPorcDescAdi() {
		return porcDescAdi;
	}
	public void setPorcDescAdi(String porcDescAdi) {
		this.porcDescAdi = porcDescAdi;
	}
	public String getTipoMovimiento() {
		return tipoMovimiento;
	}
	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
	public String getPlazo() {
		return plazo;
	}
	public void setPlazo(String plazo) {
		this.plazo = plazo;
	}
	public String getRentaServ() {
		return rentaServ;
	}
	public void setRentaServ(String rentaServ) {
		this.rentaServ = rentaServ;
	}

	public int compareTo(MovimientosAdonsVO o) {
		return this.fecActServ.compareTo(o.fecActServ);
		
	}
	
	
	
}
