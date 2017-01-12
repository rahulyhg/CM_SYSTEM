/*
 * Creado el 23/07/2015
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package iusacell.comisiones.vo;

/**
 * @author jarredondoi
 *
 * TODO Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
public class PcBitacoraProcesos {
	
	public String proceso;
	public String fechaProc;
	public String fechaIni;
	public String fechaFin;
	public String numRegs;
	public String descEstatus;
	
	

	public String getDescEstatus() {
		return descEstatus;
	}
	public void setDescEstatus(String pcDescEstatus) {
		this.descEstatus = pcDescEstatus;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String pcFechaFin) {
		this.fechaFin = pcFechaFin;
	}
	public String getFechaIni() {
		return fechaIni;
	}
	public void setFechaIni(String pcFechaIni) {
		this.fechaIni = pcFechaIni;
	}
	public String getFechaProc() {
		return fechaProc;
	}
	public void setFechaProc(String pcFechaProc) {
		this.fechaProc = pcFechaProc;
	}
	public String getNumRegs() {
		return numRegs;
	}
	public void setNumRegs(String pcNumRegs) {
		this.numRegs = pcNumRegs;
	}
	public String getProceso() {
		return proceso;
	}
	public void setProceso(String pcProceso) {
		this.proceso = pcProceso;
	}
}
