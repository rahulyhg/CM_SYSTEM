/*
 * Creado el 24/11/2014
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package iusacell.comisiones.bo;

import iusacell.comisiones.vo.PcTotalesSem;

import java.io.BufferedOutputStream;
import java.util.List;

/**
 * @author jarredondoi
 *
 * TODO Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
public interface ComisionesReportesBO {
	
	/**
	 * @param anio
	 * @return
	 */
	public List<PcTotalesSem> obtenerPeriodo(String anio);
	
	public List<PcTotalesSem> obtenerPeridoMes(String anio);
	
	@SuppressWarnings("unchecked")
	public List obtenerReporteMensual(int consulta, String periodo, String primerDia, String ultimoDia);
	
	@SuppressWarnings("unchecked")
	public List obtenerReporteSemanal(int consulta, String primerDia, String ultimoDia);
	
	@SuppressWarnings("unchecked")
	public void generarReporte(BufferedOutputStream outputStream, List lista) throws Exception;

}
