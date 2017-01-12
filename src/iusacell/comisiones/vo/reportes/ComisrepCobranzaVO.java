/*
 * Creado el 25/02/2015
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package iusacell.comisiones.vo.reportes;

/**
 * @author jarredondoi
 *
 * TODO Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
public class ComisrepCobranzaVO extends GeneralEntity{
	
	private String cdgRegion;
	private String cdgCsi;
	private String pcDescCanal;
	private String pcCveCanal;
	private Integer pcMonto;
	private Integer pcComision;
	private String pcDescCpto;
	private String pobkpnombre;
	private String pcDesDivision;
	private String edodenombre;
	private String pcOrigenEmp;
	private String fechaCreacion;
	private Integer idReporte;
	
	/**
	 * @return Devuelve cdgCsi.
	 */
	public String getCdgCsi() {
		return cdgCsi;
	}
	/**
	 * @param cdgCsi El cdgCsi a establecer.
	 */
	public void setCdgCsi(String cdgCsi) {
		this.cdgCsi = cdgCsi;
	}
	/**
	 * @return Devuelve cdgRegion.
	 */
	public String getCdgRegion() {
		return cdgRegion;
	}
	/**
	 * @param cdgRegion El cdgRegion a establecer.
	 */
	public void setCdgRegion(String cdgRegion) {
		this.cdgRegion = cdgRegion;
	}
	/**
	 * @return Devuelve edodenombre.
	 */
	public String getEdodenombre() {
		return edodenombre;
	}
	/**
	 * @param edodenombre El edodenombre a establecer.
	 */
	public void setEdodenombre(String edodenombre) {
		this.edodenombre = edodenombre;
	}
	/**
	 * @return Devuelve fechaCreacion.
	 */
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	/**
	 * @param fechaCreacion El fechaCreacion a establecer.
	 */
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	/**
	 * @return Devuelve idReporte.
	 */
	public Integer getIdReporte() {
		return idReporte;
	}
	/**
	 * @param idReporte El idReporte a establecer.
	 */
	public void setIdReporte(Integer idReporte) {
		this.idReporte = idReporte;
	}
	/**
	 * @return Devuelve pcComision.
	 */
	public Integer getPcComision() {
		return pcComision;
	}
	/**
	 * @param pcComision El pcComision a establecer.
	 */
	public void setPcComision(Integer pcComision) {
		this.pcComision = pcComision;
	}
	/**
	 * @return Devuelve pcCveCanal.
	 */
	public String getPcCveCanal() {
		return pcCveCanal;
	}
	/**
	 * @param pcCveCanal El pcCveCanal a establecer.
	 */
	public void setPcCveCanal(String pcCveCanal) {
		this.pcCveCanal = pcCveCanal;
	}
	/**
	 * @return Devuelve pcDescCanal.
	 */
	public String getPcDescCanal() {
		return pcDescCanal;
	}
	/**
	 * @param pcDescCanal El pcDescCanal a establecer.
	 */
	public void setPcDescCanal(String pcDescCanal) {
		this.pcDescCanal = pcDescCanal;
	}
	/**
	 * @return Devuelve pcDescCpto.
	 */
	public String getPcDescCpto() {
		return pcDescCpto;
	}
	/**
	 * @param pcDescCpto El pcDescCpto a establecer.
	 */
	public void setPcDescCpto(String pcDescCpto) {
		this.pcDescCpto = pcDescCpto;
	}
	/**
	 * @return Devuelve pcDesDivision.
	 */
	public String getPcDesDivision() {
		return pcDesDivision;
	}
	/**
	 * @param pcDesDivision El pcDesDivision a establecer.
	 */
	public void setPcDesDivision(String pcDesDivision) {
		this.pcDesDivision = pcDesDivision;
	}
	/**
	 * @return Devuelve pcMonto.
	 */
	public Integer getPcMonto() {
		return pcMonto;
	}
	/**
	 * @param pcMonto El pcMonto a establecer.
	 */
	public void setPcMonto(Integer pcMonto) {
		this.pcMonto = pcMonto;
	}
	/**
	 * @return Devuelve pcOrigenEmp.
	 */
	public String getPcOrigenEmp() {
		return pcOrigenEmp;
	}
	/**
	 * @param pcOrigenEmp El pcOrigenEmp a establecer.
	 */
	public void setPcOrigenEmp(String pcOrigenEmp) {
		this.pcOrigenEmp = pcOrigenEmp;
	}
	/**
	 * @return Devuelve pobkpnombre.
	 */
	public String getPobkpnombre() {
		return pobkpnombre;
	}
	/**
	 * @param pobkpnombre El pobkpnombre a establecer.
	 */
	public void setPobkpnombre(String pobkpnombre) {
		this.pobkpnombre = pobkpnombre;
	}
	/* (sin Javadoc)
	 * @see iusacell.comisiones.vo.carga.GeneralEntity#getCampos()
	 */
	public String[] getCampos() {
		String[] cam = {
			"cdgRegion",
			"cdgCsi",
			"pcDescCanal",
			"pcCveCanal",
			"pcMonto",
			"pcComision",
			"pcDescCpto",
			"pobkpnombre",
			"pcDesDivision",
			"edodenombre",
			"pcOrigenEmp"
		};
		return cam;
	}
	/* (sin Javadoc)
	 * @see iusacell.comisiones.vo.carga.GeneralEntity#getColumnas()
	 */
	public String getColumnas() {
		String col = "CDG_REGION, CDG_CSI, PC_DESC_CANAL, PC_CVE_CANAL, PC_MONTO, PC_COMISION, PC_DESC_CPTO, POBKPNOMBRE, PC_DES_DIVISION, EDODENOMBRE, PC_ORIGEN_EMP, TO_CHAR(FECHA_CREACION,'dd/MM/YYYY') AS FECHA_CREACION, ID_REPORTE";
		return col;
	}
	/* (sin Javadoc)
	 * @see iusacell.comisiones.vo.carga.GeneralEntity#getTabla()
	 */
	public String getTabla() {
		String tabla = "COMISREP_COBRANZA";
		return tabla;
	}
	/* (sin Javadoc)
	 * @see iusacell.comisiones.vo.carga.GeneralEntity#columas()
	 */
	public Integer columas() {
		// TODO Apéndice de método generado automáticamente
		return null;
	}
}
