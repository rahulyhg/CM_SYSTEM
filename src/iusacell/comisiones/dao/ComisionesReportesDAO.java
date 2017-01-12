/*
 * Creado el 24/11/2014
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package iusacell.comisiones.dao;

import iusacell.comisiones.vo.PcTotalesSem;
import java.sql.SQLException;
import java.util.List;

/**
 * @author jarredondoi
 *
 * Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
public interface ComisionesReportesDAO {
	
	/**
	 * @param anio
	 * @return
	 * @throws SQLException
	 */
	public List<PcTotalesSem> obtenerPerido(String anio) throws SQLException;
	
	/**
	 * @param anio
	 * @return
	 * @throws SQLException
	 */
	public List<PcTotalesSem> obtenerPeridoMes(String anio) throws SQLException;
	
	@SuppressWarnings("unchecked")
	public List obtenerReporteMensual(int consulta, String periodo, String primerDia, String ultimoDia);
	
	@SuppressWarnings("unchecked")
	public List obtenerReporteSemanal(int consulta, String primerDia, String ultimoDia);
	
}
