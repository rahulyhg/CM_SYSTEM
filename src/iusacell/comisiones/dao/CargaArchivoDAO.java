/*
 * Creado el 26/02/2015
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package iusacell.comisiones.dao;

import iusacell.comisiones.vo.ComisrepBitacoraVO;
import iusacell.comisiones.vo.carga.ComisrepCatReportesComis;

import java.util.List;

/**
 * @author jarredondoi
 *
 * TODO Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
public interface CargaArchivoDAO {
	
	public List<String[]> obtenerDatosTablaGen(Integer idReporte, Integer inicio, Integer fin, String campos, String tabla);
	public Integer countDatosTablaGen(Integer idReporte, String tabla);
	public List<String[]> obtenerIdArchivosGen(String tabla);
	public String obtenerIdArchivosSig(String tabla);
	public ComisrepCatReportesComis getCatReporte(Integer idReportes);
	public List<ComisrepCatReportesComis> getTotCatReportes(String perfil, String numEmpleado, Boolean administrador);
	public String[] insertarDato(String[] dat, ComisrepCatReportesComis cat);
	public String[] deleteArchivosAnteriores(ComisrepCatReportesComis cat);
	public String[] insertarBitacora(ComisrepBitacoraVO bitacora);
	public String[] validarArchivosAnteriores(ComisrepCatReportesComis cat);
}
