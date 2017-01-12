/*
 * Creado el 24/11/2014
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package iusacell.comisiones.bo;

import iusacell.comisiones.vo.PcTotalesSem;
import iusacell.comisiones.vo.TablaComisionesAgregarVO;
import iusacell.comisiones.vo.TablaComisionesExcelVO;
import iusacell.comisiones.vo.TablaComisionesVO;

import java.io.BufferedOutputStream;
import java.util.List;

/**
 * @author jarredondoi
 *
 * TODO Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
public interface ComisionesBO {
	
	/**
	 * @param anio
	 * @return
	 */
	public List<PcTotalesSem> obtenerPeriodo(String anio);

	/**
	 * @param anio
	 * @param periodo
	 * @param mes
	 * @return
	 */
	public List<TablaComisionesVO> obtenerConsolidadoTabla(String anio, String periodo, String mes);

	/**
	 * @param string
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
	 * @param outputStream
	 * @param lista
	 */
	public void generarReporte(BufferedOutputStream outputStream, List<TablaComisionesExcelVO> lista);

	/**
	 * @param contrato
	 * @param fecha
	 * @param anio
	 * @param periodo
	 * @return
	 */
	public List<TablaComisionesAgregarVO> obtenerValidarAgregarTablaDetalle(String contrato, String anio, String periodo, String semana, String[] fechas);

	/**
	 * @param tab
	 * @param periodo
	 * @param mes
	 * @return
	 */
	public boolean validarInsertado(TablaComisionesAgregarVO tab, String mes, String periodo);

	/**
	 * @param string
	 * @param anio
	 * @param periodo
	 * @param mes
	 * @param fecha
	 * @return
	 */
	public String agregarComisiones(String contrato, String anio, String periodo, String mes, String fechaini, String fechaFin);
	
	/**
	 * @return
	 */
	public Integer obtenerSemanaActual();

	/**
	 * Metodo para eliminar los contratos 
	 * @param anio
	 * @param periodo
	 * @param mes
	 * @param contrato
	 */
	public boolean eliminarContrato(String anio, String periodo, String mes, String contrato);

	/**
	 * @param anio
	 * @param periodo
	 * @param semana
	 * @param contratos
	 */
	public boolean eliminarContratosDetalle(String anio, String periodo, String semana, String[] contratos);

	/**
	 * @param anio
	 * @param periodo
	 * @param semana
	 */
	public boolean reprocesarContratosDetalle(String[] fechas);

	/**
	 * @param contrato
	 * @param anio
	 * @param periodo
	 * @param semana
	 * @return
	 */
	public List<TablaComisionesAgregarVO> obtenerAgregarTablaDetalle(String contrato, String anio, String periodo, String semana);

	/**
	 * @param anio
	 * @param periodo
	 * @param semana
	 * @param agregarVO
	 */
	public void agregarContratoDetalle(String anio, String periodo, String semana, TablaComisionesAgregarVO agregarVO,String[] fechas);

}
