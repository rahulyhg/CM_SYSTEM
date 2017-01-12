/*
 * Created on 2/09/2009
 *
 */
package iusacell.comisiones.ayuda;

import java.io.Serializable;

/**
 * @author hb
 *
 */
public class DatosEmpleadoVo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 516090124905870595L;
	private String idUsuario;
	private String nombre;
	private String posicion;
	private String desc_posicion;
	private String fec_alta;
	private String funcion;
	private String desc_funcion;
	private String id_empleado_jefe;
	private String nombre_jefe;
	private String posicion_jefe;
	private String desc_posicion_jefe;
	private String cve_ubicacion;
	private String desc_ubicacion;
	private String horario;
	private String jefe;
	private String flag_incidencia;
	private String nuevo_ingreso;
	private String apoyo;
	private String cve_horario;
	private String cve_zona;
	private String desc_zona;
	private String Ajuste_Hora;
	private String estado;
	
	private String idSystem;
	private String idTienda;	
	private String userBitacora;	
	private String tipoIngreso;	
	private String userAdmonImg;
	private String userAdmonGral;
	private String flagActivo;
	
	
	
	/**
	 * @return Returns the ajuste_Hora.
	 */
	public String getAjuste_Hora() {
		return Ajuste_Hora;
	}
	/**
	 * @param ajuste_Hora The ajuste_Hora to set.
	 */
	public void setAjuste_Hora(String ajuste_Hora) {
		Ajuste_Hora = ajuste_Hora;
	}
	
	
	/**
	 * @return Returns the desc_zona.
	 */
	public String getDesc_zona() {
		return desc_zona;
	}
	/**
	 * @param desc_zona The desc_zona to set.
	 */
	public void setDesc_zona(String desc_zona) {
		this.desc_zona = desc_zona;
	}
	/**
	 * @return Returns the flagActivo.
	 */
	public String getFlagActivo() {
		return flagActivo;
	}
	/**
	 * @param flagActivo The flagActivo to set.
	 */
	public void setFlagActivo(String flagActivo) {
		this.flagActivo = flagActivo;
	}
	/**
	 * @return Returns the tipoIngreso.
	 */
	public String getTipoIngreso() {
		return tipoIngreso;
	}
	/**
	 * @param tipoIngreso The tipoIngreso to set.
	 */
	public void setTipoIngreso(String tipoIngreso) {
		this.tipoIngreso = tipoIngreso;
	}
	/**
	 * @return Returns the userBitacora.
	 */
	public String getUserBitacora() {
		return userBitacora;
	}
	/**
	 * @param userBitacora The userBitacora to set.
	 */
	public void setUserBitacora(String userBitacora) {
		this.userBitacora = userBitacora;
	}
	/**
	 * @return Returns the flag_incidencia.
	 */
	public String getFlag_incidencia() {
		return flag_incidencia;
	}
	/**
	 * @param flag_incidencia The flag_incidencia to set.
	 */
	public void setFlag_incidencia(String flag_incidencia) {
		this.flag_incidencia = flag_incidencia;
	}
	/**
	 * @return Returns the desc_funcion.
	 */
	public String getDesc_funcion() {
		return desc_funcion;
	}
	/**
	 * @param desc_funcion The desc_funcion to set.
	 */
	public void setDesc_funcion(String desc_funcion) {
		this.desc_funcion = desc_funcion;
	}
	/**
	 * @return Returns the desc_posicion.
	 */
	public String getDesc_posicion() {
		if(desc_posicion==null)
			desc_posicion = "";
		return desc_posicion;
	}
	/**
	 * @param desc_posicion The desc_posicion to set.
	 */
	public void setDesc_posicion(String desc_posicion) {
		this.desc_posicion = desc_posicion;
	}
	/**
	 * @return Returns the desc_posicion_jefe.
	 */
	public String getDesc_posicion_jefe() {
		return desc_posicion_jefe;
	}
	/**
	 * @param desc_posicion_jefe The desc_posicion_jefe to set.
	 */
	public void setDesc_posicion_jefe(String desc_posicion_jefe) {
		this.desc_posicion_jefe = desc_posicion_jefe;
	}
	/**
	 * @return Returns the cveUbicacion.
	 */
	public String getCve_ubicacion() {
		return cve_ubicacion;
	}
	/**
	 * @param cve_ubicacion The cve_ubicacion to set.
	 */
	public void setCve_ubicacion(String cve_ubicacion) {
		this.cve_ubicacion = cve_ubicacion;
	}
	/**
	 * @return Returns the descUbicacion.
	 */
	public String getDesc_ubicacion() {
		return desc_ubicacion;
	}
	/**
	 * @param desc_ubicacion The desc_ubicacion to set.
	 */
	public void setDesc_ubicacion(String desc_ubicacion) {
		this.desc_ubicacion = desc_ubicacion;
	}
	/**
	 * @return Returns the fec_alta.
	 */
	public String getFec_alta() {
		return fec_alta;
	}
	/**
	 * @param fec_alta The fec_alta to set.
	 */
	public void setFec_alta(String fec_alta) {
		this.fec_alta = fec_alta;
	}
	/**
	 * @return Returns the funcion.
	 */
	public String getFuncion() {
		return funcion;
	}
	/**
	 * @param funcion The funcion to set.
	 */
	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}
	/**
	 * @return Returns the horario.
	 */
	public String getHorario() {
		return horario;
	}
	/**
	 * @param horario The horario to set.
	 */
	public void setHorario(String horario) {
		this.horario = horario;
	}
	/**
	 * @return Returns the id_empleado_jefe.
	 */
	public String getId_empleado_jefe() {
		return id_empleado_jefe;
	}
	/**
	 * @param id_empleado_jefe The id_empleado_jefe to set.
	 */
	public void setId_empleado_jefe(String id_empleado_jefe) {
		this.id_empleado_jefe = id_empleado_jefe;
	}
	/**
	 * @return Returns the idUsuario.
	 */
	public String getIdUsuario() {
		return idUsuario;
	}
	/**
	 * @param idUsuario The idUsuario to set.
	 */
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	/**
	 * @return Returns the jefe.
	 */
	public String getJefe() {
		return jefe;
	}
	/**
	 * @param jefe The jefe to set.
	 */
	public void setJefe(String jefe) {
		this.jefe = jefe;
	}
	/**
	 * @return Returns the nombre.
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre The nombre to set.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return Returns the nombre_jefe.
	 */
	public String getNombre_jefe() {
		return nombre_jefe;
	}
	/**
	 * @param nombre_jefe The nombre_jefe to set.
	 */
	public void setNombre_jefe(String nombre_jefe) {
		this.nombre_jefe = nombre_jefe;
	}
	/**
	 * @return Returns the posicion.
	 */
	public String getPosicion() {
		return posicion;
	}
	/**
	 * @param posicion The posicion to set.
	 */
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	/**
	 * @return Returns the posicion_jefe.
	 */
	public String getPosicion_jefe() {
		return posicion_jefe;
	}
	/**
	 * @param posicion_jefe The posicion_jefe to set.
	 */
	public void setPosicion_jefe(String posicion_jefe) {
		this.posicion_jefe = posicion_jefe;
	}
	/**
	 * @return Returns the nuevo_ingreso.
	 */
	public String getNuevo_ingreso() {
		return nuevo_ingreso;
	}
	/**
	 * @param nuevo_ingreso The nuevo_ingreso to set.
	 */
	public void setNuevo_ingreso(String nuevo_ingreso) {
		this.nuevo_ingreso = nuevo_ingreso;
	}
	/**
	 * @return Returns the idSystem.
	 */
	public String getIdSystem() {
		return idSystem;
	}
	/**
	 * @param idSystem The idSystem to set.
	 */
	public void setIdSystem(String idSystem) {
		this.idSystem = idSystem;
	}
	/**
	 * @return Returns the idTienda.
	 */
	public String getIdTienda() {
		return idTienda;
	}
	/**
	 * @param idTienda The idTienda to set.
	 */
	public void setIdTienda(String idTienda) {
		this.idTienda = idTienda;
	}
	/**
	 * @return Returns the apoyo.
	 */
	public String getApoyo() {
		return apoyo;
	}
	/**
	 * @param apoyo The apoyo to set.
	 */
	public void setApoyo(String apoyo) {
		this.apoyo = apoyo;
	}
	/**
	 * @return Returns the cve_horario.
	 */
	public String getCve_horario() {
		return cve_horario;
	}
	/**
	 * @param cve_horario The cve_horario to set.
	 */
	public void setCve_horario(String cve_horario) {
		this.cve_horario = cve_horario;
	}
	/**
	 * @return Returns the cve_zona.
	 */
	public String getCve_zona() {
		return cve_zona;
	}
	/**
	 * @param cve_zona The cve_zona to set.
	 */
	public void setCve_zona(String cve_zona) {
		this.cve_zona = cve_zona;
	}
	/**
	 * @return Returns the userAdmonImg.
	 */
	public String getUserAdmonImg() {
		return userAdmonImg;
	}
	/**
	 * @param userAdmonImg The userAdmonImg to set.
	 */
	public void setUserAdmonImg(String userAdmonImg) {
		this.userAdmonImg = userAdmonImg;
	}
	
	/**
	 * @return Returns the userAdmonGral.
	 */
	public String getUserAdmonGral() {
		return userAdmonGral;
	}
	/**
	 * @param userAdmonGral The userAdmonGral to set.
	 */
	public void setUserAdmonGral(String userAdmonGral) {
		this.userAdmonGral = userAdmonGral;
	}
	
	/**
	 * @return Returns the estado.
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado The estado to set.
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
