/*
 * Creado el 24/11/2014
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package iusacell.comisiones.dao;

import iusacell.comisiones.vo.PcTotalesSem;
import iusacell.comisiones.vo.PermisosVO;
import iusacell.comisiones.vo.TablaComisionesAgregarVO;
import iusacell.comisiones.vo.TablaComisionesExcelVO;
import iusacell.comisiones.vo.TablaComisionesVO;

import java.sql.SQLException;
import java.util.List;

/**
 * @author jarredondoi
 *
 * TODO Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
public interface ComisionesDAO {
	
	/**
	 * @param anio
	 * @return
	 * @throws SQLException
	 */
	public List<PcTotalesSem> obtenerPerido(String anio) throws SQLException;

	/**
	 * @param anio
	 * @return
	 */
	public List<TablaComisionesVO> obtenerTablaConsolidado(String anio, String periodo, String mes) throws SQLException;

	/**
	 * @param seleccionado
	 * @param periodo
	 * @param mes
	 * @return
	 */
	public String publicar(String seleccionado, String anio, String periodo, String mes);

	/**
	 * @param anio
	 * @param periodo
	 * @param mes
	 * @return
	 */
	public List<TablaComisionesExcelVO> obtenerTablaExcel(String anio, String periodo, String mes);

	/**
	 * @param contrato
	 * @param fecha
	 * @return
	 */
	public List<TablaComisionesAgregarVO> obtenerValidarAgregarTablaDetalle(String contrato, String fecha);

	/**
	 * @param tab
	 * @param periodo
	 * @param mes
	 * @return
	 */
	public int validarInsertado(TablaComisionesAgregarVO tab, String mes, String periodo);

	/**
	 * @param contrato
	 * @param anio
	 * @param periodo
	 * @param mes
	 * @param fecha
	 * @param fechaFin
	 * @return
	 */
	public String agregarComisiones(String contrato, String anio, String periodo, String mes, String fecha, String fechaFin);

	/**
	 * @param periodo
	 * @param mes
	 * @return
	 */
	public String borrarTablaComisiones(String periodo, String mes);

	/**
	 * @param periodo
	 * @param mes
	 * @return
	 */
	public String borrarTablaTotales(String periodo, String mes);

	/**
	 * @param fechaIni
	 * @param fechaFin
	 * @return
	 */
	public String recalcularCalculoTotales(String fechaIni, String fechaFin);

	/**
	 * @return
	 */
	public int obtenerSemanaActual();
	
	/**
	 * 
	 * @param numEmpleado
	 * @return
	 */
	public List<PermisosVO> obtnerPermisos(String numEmpleado);

	/**
	 * @param contrato
	 * @param anio
	 * @param periodo
	 * @param mes
	 * @return
	 */
	public int obtenerTipoContrato(String contrato, String anio, String periodo, String mes);

	/**
	 * @param contrato
	 * @param anio
	 * @param periodo
	 * @param semana
	 */
	public String[] eliminarContratoTipo1(String contrato, String anio, String periodo, String semana);

	/**
	 * @param contrato
	 * @param anio
	 * @param periodo
	 * @param semana
	 */
	public String[] eliminarContratoTipo2(String contrato, String anio, String periodo, String semana);

	/**
	 * @param periodo
	 * @param semana
	 */
	public String[] eliminarPcComisVentasSem(String periodo, String semana);

	/**
	 * @param periodo
	 * @param semana
	 */
	public String[] eliminarpcTotalesSem(String periodo, String semana);

	/**
	 * @param fechas
	 */
	public String reprocesarContratos(String[] fechas);

	/**
	 * @param contrato
	 * @param periodo
	 * @return
	 */
	public List<TablaComisionesAgregarVO> obtenerAgregarTablaDetalle(String contrato, String periodo);

	/**
	 * @param fechaInicio
	 * @param fechaFin
	 * @param contrato
	 */
	public String procesoCargaActivaciones(String fechaInicio, String fechaFin, String contrato);

	/**
	 * @param fechaInicio
	 * @param fechaFin
	 * @param contrato
	 */
	public String procesoCargaRenovaciones(String fechaInicio, String fechaFin, String contrato);
	
	/**
	 * 
	 * @param fechaInicio
	 * @param diaFin
	 * @param contrato
	 * @return
	 */
	public String calcularcomisionesActivaciones(String fechaInicio, String diaFin, String contrato);

	/**
	 * @param consulta
	 */
	public String procesoCalcularInterfactura(String consulta);

	
}
