/*
 * Creado el 25/02/2015
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package iusacell.comisiones.bo;

import java.util.List;

import org.apache.struts.upload.FormFile;

import iusacell.comisiones.ayuda.UserBean;
import iusacell.comisiones.vo.carga.ComisrepCatReportesComis;

/**
 * @author jarredondoi
 *
 * TODO Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
public interface CargaArchivoBO {
	
	public String cargaArchivoTxt(FormFile file, String idTipoArchivo, int pag, int accion,int idArchivo, UserBean usuarioBean);
	public String cargaArchivoExcel(FormFile file, String idTipoArchivo, int pag, int accion, int idArchivo, UserBean usuarioBean);

	/**
	 * @param fecha
	 * @param idTipoArchivo
	 * @param idReporte
	 * @param pag
	 * @param accion
	 * @return
	 */
	public String buscarArchivo(String idTipoArchivo, int idReporte, int pag, int accion);

	/**
	 * @param idTipoArchivo
	 * @param fecha
	 * @return
	 */
	public String buscaIdArchivo(String idTipoArchivo);
	
	public ComisrepCatReportesComis getCatReporte(Integer idReportes);
	
	public List<ComisrepCatReportesComis> getTotCatReportes(String perfil, String numEmpleado, Boolean adminsitrador);
	
	/**
	 * @param idTipoArchivo
	 * @param idArchivo
	 * @param usuarioBean
	 * @return
	 */
	public String eliminarArchivo(String idTipoArchivo, int idArchivo, UserBean usuarioBean);
	/**
	 * @param idTipoArchivo
	 * @param idArchivo
	 * @return
	 */
	public String validarExtArchivo(String idTipoArchivo, int idArchivo);

}
