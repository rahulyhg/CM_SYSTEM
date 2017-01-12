/*
 * Created on 9/09/2009
 *
 */
package iusacell.comisiones.ayuda;

import java.io.Serializable;

/**
 * @author DP
 *
 */
public class BitacoraVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2596766836839786008L;
	private String ipUser;
	private String idusuario;
	private String modulo;
	private String tipoOperacion;
	private String fechaSistema;
	private String idLog;
	private String flag;
	
	private String plLogKey;
  	private String plFechaIni;
	private String plFechaFin;
	private String plRegsProc;
	private String plAplicacion;
	private String plModulo;
	private String plDesc;
	private String plSqlcode;
	private String plSqlerrm;
	private String plGrupo;
	
	
	/**
	 * @return Returns the fechaSistema.
	 */
	public String getFechaSistema() {
		return fechaSistema;
	}
	/**
	 * @param fechaSistema The fechaSistema to set.
	 */
	public void setFechaSistema(String fechaSistema) {
		this.fechaSistema = fechaSistema;
	}
	/**
	 * @return Returns the idLog.
	 */
	public String getIdLog() {
		return idLog;
	}
	/**
	 * @param idLog The idLog to set.
	 */
	public void setIdLog(String idLog) {
		this.idLog = idLog;
	}
	/**
	 * @return Returns the idusuario.
	 */
	public String getIdusuario() {
		return idusuario;
	}
	/**
	 * @param idusuario The idusuario to set.
	 */
	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}
	/**
	 * @return Returns the ipUser.
	 */
	public String getIpUser() {
		return ipUser;
	}
	/**
	 * @param ipUser The ipUser to set.
	 */
	public void setIpUser(String ipUser) {
		this.ipUser = ipUser;
	}
	/**
	 * @return Returns the modulo.
	 */
	public String getModulo() {
		return modulo;
	}
	/**
	 * @param modulo The modulo to set.
	 */
	public void setModulo(String modulo) {
		this.modulo = modulo;
	}
	/**
	 * @return Returns the tipoOperacion.
	 */
	public String getTipoOperacion() {
		return tipoOperacion;
	}
	/**
	 * @param tipoOperacion The tipoOperacion to set.
	 */
	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	/**
	 * @return Returns the flag.
	 */
	public String getFlag() {
		return flag;
	}
	/**
	 * @param flag The flag to set.
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	/**
	 * @return Returns the plAplicacion.
	 */
	public String getPlAplicacion() {
		return plAplicacion;
	}
	/**
	 * @param plAplicacion The plAplicacion to set.
	 */
	public void setPlAplicacion(String plAplicacion) {
		this.plAplicacion = plAplicacion;
	}
	/**
	 * @return Returns the plDesc.
	 */
	public String getPlDesc() {
		return plDesc;
	}
	/**
	 * @param plDesc The plDesc to set.
	 */
	public void setPlDesc(String plDesc) {
		this.plDesc = plDesc;
	}
	/**
	 * @return Returns the plFechaFin.
	 */
	public String getPlFechaFin() {
		return plFechaFin;
	}
	/**
	 * @param plFechaFin The plFechaFin to set.
	 */
	public void setPlFechaFin(String plFechaFin) {
		this.plFechaFin = plFechaFin;
	}
	/**
	 * @return Returns the plFechaIni.
	 */
	public String getPlFechaIni() {
		return plFechaIni;
	}
	/**
	 * @param plFechaIni The plFechaIni to set.
	 */
	public void setPlFechaIni(String plFechaIni) {
		this.plFechaIni = plFechaIni;
	}
	/**
	 * @return Returns the plGrupo.
	 */
	public String getPlGrupo() {
		return plGrupo;
	}
	/**
	 * @param plGrupo The plGrupo to set.
	 */
	public void setPlGrupo(String plGrupo) {
		this.plGrupo = plGrupo;
	}
	/**
	 * @return Returns the plLogKey.
	 */
	public String getPlLogKey() {
		return plLogKey;
	}
	/**
	 * @param plLogKey The plLogKey to set.
	 */
	public void setPlLogKey(String plLogKey) {
		this.plLogKey = plLogKey;
	}
	/**
	 * @return Returns the plModulo.
	 */
	public String getPlModulo() {
		return plModulo;
	}
	/**
	 * @param plModulo The plModulo to set.
	 */
	public void setPlModulo(String plModulo) {
		this.plModulo = plModulo;
	}
	/**
	 * @return Returns the plRegsProc.
	 */
	public String getPlRegsProc() {
		return plRegsProc;
	}
	/**
	 * @param plRegsProc The plRegsProc to set.
	 */
	public void setPlRegsProc(String plRegsProc) {
		this.plRegsProc = plRegsProc;
	}
	/**
	 * @return Returns the plSqlcode.
	 */
	public String getPlSqlcode() {
		return plSqlcode;
	}
	/**
	 * @param plSqlcode The plSqlcode to set.
	 */
	public void setPlSqlcode(String plSqlcode) {
		this.plSqlcode = plSqlcode;
	}
	/**
	 * @return Returns the plSqlerrm.
	 */
	public String getPlSqlerrm() {
		return plSqlerrm;
	}
	/**
	 * @param plSqlerrm The plSqlerrm to set.
	 */
	public void setPlSqlerrm(String plSqlerrm) {
		this.plSqlerrm = plSqlerrm;
	}
}
