/*
 * Creado el 25/02/2015
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package iusacell.comisiones.bo.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import mx.com.iusacell.comisiones.utilerias.Paginador;
import org.apache.log4j.Logger;
import org.apache.struts.upload.FormFile;

import iusacell.comisiones.ayuda.UserBean;
import iusacell.comisiones.bo.CargaArchivoBO;
import iusacell.comisiones.dao.CargaArchivoDAO;
import iusacell.comisiones.util.LeeExcel;
import iusacell.comisiones.vo.ComisrepBitacoraVO;
import iusacell.comisiones.vo.carga.ComisrepCatReportesComis;

/**
 * @author jarredondoi
 *
 * TODO Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
public class CargaArchivoBOImpl implements CargaArchivoBO {
	
	CargaArchivoDAO cargaArchivoDAO; 
	
	protected static final Logger logger = Logger.getLogger(CargaArchivoBOImpl.class);
	
	/* (sin Javadoc)
	 * @see iusacell.comisiones.bo.CargaArchivoBO#cargaArchivoExcel(org.apache.struts.upload.FormFile, java.lang.String, int, int)
	 */
	public String cargaArchivoExcel(FormFile file, String idTipoArchivo, int pag, int accion, int idArchivo, UserBean usuarioBean) {
//		Util.pasarGarbageCollector();
		StringBuffer res = new StringBuffer("<datos>"); 
		StringBuffer tabla = new StringBuffer();
		int tamReal = 0;
		Paginador paginador = new Paginador(pag,1,100);
		ComisrepCatReportesComis cat = getCatReporte(Integer.valueOf(idTipoArchivo));
		boolean nuevo = true;
		if(idArchivo == 0){//actualización o carga de nuevo archivo
			cat.setIdArchivo(cargaArchivoDAO.obtenerIdArchivosSig(cat.getReporteDescripcion())); //Carga uno nuevo
		}else{
			cat.setIdArchivo(String.valueOf(idArchivo)); //Actualizacion de carga de archivo
			nuevo = false;
		}
		int tamColCampos = cat.getNumColumnas().intValue()-2;
			try {
				LeeExcel leeExcel = new LeeExcel();
				InputStream is = file.getInputStream();
				leeExcel.setHoja(0);
				List<String> datos = leeExcel.cargaDatosString(is);
				if(datos != null && datos.size()>0){
					paginador = new Paginador(pag,datos.size(),100);
					tamReal = datos.size();
					if(paginador.getTamCampos()>0){
						int i = 1;
//						int contTabla = 0;
						for (String sCurrentLine : datos) {
							revisarDatosArchivo(i,sCurrentLine,cat,paginador,accion,res,tabla);
							i++;
						}
					}
				}
			} catch (Throwable e) {
				e.printStackTrace();
			}
			insertarBitacora(idTipoArchivo,paginador,accion,usuarioBean,cat,nuevo);
			res.append("</datos>");
			res.append("<tablaDatos>").append(tabla).append("</tablaDatos>");
			res.append("<columnas>").append(tamColCampos).append("</columnas>");
			res.append("<tam>").append(paginador.getContTabla()).append("</tam>");
			res.append("<pag>").append(paginador.getPaginas()).append("</pag>");
			res.append("<totalError>").append(paginador.getTotalError()).append("</totalError>");
			res.append("<tamReal>").append(tamReal).append("</tamReal>");
		
		return res.toString();
	}


	/* (sin Javadoc)
	 * @see iusacell.comisiones.bo.CargaArchivoBO#cargaArchivoTxt(org.apache.struts.upload.FormFile)
	 */
	public String cargaArchivoTxt(FormFile file, String idTipoArchivo,int pag, int accion, int idArchivo, UserBean usuarioBean) {
//		Util.pasarGarbageCollector();
		BufferedReader br = null;
		StringBuffer res = new StringBuffer("<datos>");
		StringBuffer tabla =new StringBuffer();
		int tamReal = getTamañoTxt(file);
		Paginador paginador = new Paginador(pag,tamReal,100);
		ComisrepCatReportesComis cat = getCatReporte(Integer.valueOf(idTipoArchivo));
		boolean nuevo = true;
		if(idArchivo == 0){//actualización o carga de nuevo archivo
			cat.setIdArchivo(cargaArchivoDAO.obtenerIdArchivosSig(cat.getReporteDescripcion())); //Carga uno nuevo
		}else{
			cat.setIdArchivo(String.valueOf(idArchivo)); //Actualizacion de carga de archivo
			nuevo = false;
		}
		int tamColCampos = cat.getNumColumnas().intValue()-2;
		if(paginador.getTamCampos()>0){
			try {
				String sCurrentLine;
				br = new BufferedReader(new InputStreamReader(file.getInputStream()));
				int i = 1;
//				int contTabla = 0;
				while (cat != null &&(sCurrentLine = br.readLine()) != null) {
					revisarDatosArchivo(i,sCurrentLine,cat,paginador,accion,res,tabla);
					i++;
				}
			} catch (Throwable e) {
				e.printStackTrace();
			} finally {
				try {
					if (br != null)br.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
		insertarBitacora(idTipoArchivo,paginador,accion,usuarioBean,cat,nuevo);
		res .append("</datos>");
		res.append("<tablaDatos>").append(tabla).append("</tablaDatos>");
		res.append("<columnas>").append(tamColCampos).append("</columnas>");
		res.append("<tam>").append(paginador.getContTabla()).append("</tam>");
		res.append("<pag>").append(paginador.getPaginas()).append("</pag>");
		res.append("<totalError>").append(paginador.getTotalError()).append("</totalError>");
		res.append("<tamReal>").append(tamReal).append("</tamReal>");
		
		return res.toString();
	}
	
	private void revisarDatosArchivo(int i, String sCurrentLine, ComisrepCatReportesComis cat, 
			Paginador paginador, int accion, StringBuffer res, StringBuffer tabla){
		
		String[] datosL = sCurrentLine.split("\\|");
		int tamColLista = datosL.length;
		int tamColCampos = cat.getNumColumnas().intValue()-2;
		if(tamColLista!=tamColCampos && accion == 0 && paginador.getTotalError() < 100){
			res.append(obtenerMensaje(i,sCurrentLine));
			paginador.incremTotalError();
		}else if (tamColLista==tamColCampos) {
			paginador.incremContTabla();
			if(accion == 11 && paginador.getContTabla() > 0){
				if(paginador.getContTabla()==1){cargaArchivoDAO.deleteArchivosAnteriores(cat);}
				String[] resul = cargaArchivoDAO.insertarDato(datosL,cat);
				if(paginador.getTotalError() < 1000 && resul != null && resul[0].equals("-1")){
					res.append("La fila <b>").append(i).append("</b> tubo el siguiente error: ");
					res.append(resul[1]).append("<br></br><br></br>");
					paginador.incremTotalError();
				}else if (resul[0].equals("-1")){
					paginador.incremTotalError();
				}
			}
			if(i>=paginador.getInicio() && i <= paginador.getFin() && accion != 11){
				sCurrentLine = i+"|"+sCurrentLine;
				datosL = sCurrentLine.split("\\|");
				tabla.append(obtenerTabla(datosL));
			}
		}
	}

	/**
	 * @param res
	 * @param i
	 * @param currentLine
	 */
	private StringBuffer obtenerMensaje(int i, String currentLine) {
		StringBuffer res = new StringBuffer();
		res.append("<b>La fila: ").append(i).append(" no contiene el mismo numero de columnas: </b><br></br>");
		res.append("[<![CDATA[").append(currentLine).append("]]>]<br></br><br></br>");
		return res;
	}

	/**
	 * @param tabla
	 * @param datos
	 */
	private StringBuffer obtenerTabla(String[] datos) {
		StringBuffer tabla = new StringBuffer();
		tabla.append("<tr>");
		for (int j = 0; j < datos.length; j++) {
			String dato = datos[j];
			tabla.append("<td><![CDATA[");
			tabla.append(dato);
			tabla.append("]]></td>");
		}
		tabla.append("</tr>");
		
		return tabla;
	}

	/**
	 * @param file
	 * @return
	 */
	private int getTamañoTxt(FormFile file) {
		int tam = 0;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(file.getInputStream()));
			@SuppressWarnings("unused")
			String sCurrentLine = "";
			while ((sCurrentLine = br.readLine()) != null) {
				tam++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return tam;
	}
	

	/**
	 * @param idTipoArchivo
	 * @param paginador
	 * @param accion
	 * @param usuarioBean
	 * @param cat
	 * @param nuevo
	 */
	private void insertarBitacora(String idTipoArchivo, Paginador paginador, int accion, UserBean usuarioBean, ComisrepCatReportesComis cat, boolean nuevo) {
		if(accion == 11){
			int insertados = paginador.getContTabla() - paginador.getTotalError();
			if(insertados > 0){
				ComisrepBitacoraVO bitacora = new ComisrepBitacoraVO();
				bitacora.setIdReporte(Integer.valueOf(idTipoArchivo));
				bitacora.setNumFilas(new Integer(insertados));
				bitacora.setObservaciones("Se insertaron "+insertados+" de "+paginador.getContTabla());
				bitacora.setNumEmpleado(usuarioBean.getNumEmpleado());
				bitacora.setStatus(nuevo?"Archivo Cargado":"Archivo Actualizado");
				bitacora.setIdArchivo(new Integer(cat.getIdArchivo()));
				cargaArchivoDAO.insertarBitacora(bitacora);
			}else{
				ComisrepBitacoraVO bitacora = new ComisrepBitacoraVO();
				bitacora.setIdReporte(Integer.valueOf(idTipoArchivo));
				bitacora.setNumFilas(new Integer(0));
				bitacora.setObservaciones("El archivo no contenia ninguna fila valida.");
				bitacora.setNumEmpleado(usuarioBean.getNumEmpleado());
				bitacora.setStatus(nuevo?"Archivo No Cargado":"Archivo No Actualizado");
				bitacora.setIdArchivo(new Integer(cat.getIdArchivo()));
				cargaArchivoDAO.insertarBitacora(bitacora);
			}
		}
		
	}
	
	
	/* (sin Javadoc)
	 * @see iusacell.comisiones.bo.CargaArchivoBO#buscarArchivo(java.lang.String, java.lang.String, int, int)
	 */
	public String buscarArchivo(String idTipoArchivo, int idReporte, int pag, int accion) {
//		BufferedReader br = null;
		StringBuffer res = new StringBuffer("<datos>"); 
		StringBuffer tabla = new StringBuffer();
		ComisrepCatReportesComis cat = getCatReporte(Integer.valueOf(idTipoArchivo));
		Integer tamComp = cargaArchivoDAO.countDatosTablaGen(new Integer(idReporte),cat.getReporteDescripcion());
		int tamColCampos = 0;
		Paginador paginador = new Paginador(pag,tamComp.intValue(),100);
		try {
			tamColCampos = cat.getNumColumnas().intValue()+1;
			List<String[]> lista = getClaseLista(idTipoArchivo,idReporte,paginador.getInicio(),paginador.getFin(),cat);
			for (String[] campos : lista) {
				tabla.append(obtenerTabla(campos));
			}
		} catch (Exception e) {
			logger.info("Error al traer los resultados");
		}
		
		res .append("</datos>");
		res.append("<tablaDatos>").append(tabla).append("</tablaDatos>");
		res.append("<columnas>").append(tamColCampos).append("</columnas>");
		res.append("<tam>").append(paginador.getContTabla()).append("</tam>");
		res.append("<pag>").append(paginador.getPaginas()).append("</pag>");
		res.append("<totalError>").append(paginador.getTotalError()).append("</totalError>");
		res.append("<tamReal>").append(paginador.getTamCampos()).append("</tamReal>");
		
		return res.toString();
	}
	
	/**
	 * @param idTipoArchivo
	 * @param idReporte
	 * @return
	 */
	private List<String[]> getClaseLista(String idTipoArchivo,int idReporte,int inicio, int fin, ComisrepCatReportesComis cat) {
		List<String[]> list = null;
		if(cat!= null){
			list = cargaArchivoDAO.obtenerDatosTablaGen(new Integer(idReporte),new Integer(inicio),new Integer(fin),
					cat.getColumOrd(),cat.getReporteDescripcion()); 
		}else{
			list = new ArrayList<String[]>();
		}
		return list;
	}
	
	/* (sin Javadoc)
	 * @see iusacell.comisiones.bo.CargaArchivoBO#buscaIdArchivo(java.lang.String, java.lang.String)
	 */
	public String buscaIdArchivo(String idTipoArchivo) {
		StringBuffer cons = new StringBuffer("<cveRespuesta>&&respuesta&&</cveRespuesta><datos>&&datos&&</datos>");
		StringBuffer datos = new StringBuffer(); 
		StringBuffer res = new StringBuffer();
		try {
			ComisrepCatReportesComis cat = getCatReporte(Integer.valueOf(idTipoArchivo));
			List<String[]> lista = getidArchivosLista(idTipoArchivo,cat);
			if(lista != null && lista.size() > 0){
				res.append("1");
				for (String[] campos : lista) {
					datos.append("<option value='"+campos[0]+"'>"+campos[1]+"</option>");
				}
			}else{
				res.append("0");
			}
		} catch (Exception e) {
			logger.info("Error al traer los resultados");
		}
		res = new StringBuffer(cons.toString().replaceAll("&&respuesta&&",res.toString()).replaceAll("&&datos&&",datos.toString()));
		
		return res.toString();
	
	}
	
	/**
	 * @param idTipoArchivo
	 * @return
	 */
	private List<String[]> getidArchivosLista(String idTipoArchivo, ComisrepCatReportesComis cat) {
		List<String[]> list = null;
		if(cat != null){
			list = cargaArchivoDAO.obtenerIdArchivosGen(cat.getReporteDescripcion()); 
		}else{
			list = new ArrayList<String[]>();
		}
		return list;
	}
	
	/* (sin Javadoc)
	 * @see iusacell.comisiones.bo.CargaArchivoBO#getCatReporte(java.lang.Integer)
	 */
	public ComisrepCatReportesComis getCatReporte(Integer idReportes) {
		ComisrepCatReportesComis rep = null;
		try {
			rep = cargaArchivoDAO.getCatReporte(idReportes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rep;
	}

	/* (sin Javadoc)
	 * @see iusacell.comisiones.bo.CargaArchivoBO#getTotCatReportes()
	 */
	public List<ComisrepCatReportesComis> getTotCatReportes(String perfil,String numEmpleado, Boolean adminsitrador) {
		List<ComisrepCatReportesComis> lista = null;
		try {
			try {
				lista = cargaArchivoDAO.getTotCatReportes(perfil,numEmpleado,adminsitrador);
				if(lista != null && lista.size()>0){
					for (ComisrepCatReportesComis element : lista) {
						element.setReporteDescripcion(element.getReporteDescripcion().substring(9));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	/* (sin Javadoc)
	 * @see iusacell.comisiones.bo.CargaArchivoBO#eliminarArchivo(java.lang.String, int, iusacell.comisiones.ayuda.UserBean)
	 */
	public String eliminarArchivo(String idTipoArchivo, int idArchivo, UserBean usuarioBean) {
		String res = "";
		res += "<cveRespuesta>-1</cveRespuesta>";
		res += "<Mensaje>Ocurrio un error al eliminar el archivo.</Mensaje>";
		ComisrepBitacoraVO bitacora = new ComisrepBitacoraVO();
		bitacora.setIdReporte(Integer.valueOf(idTipoArchivo));
		bitacora.setNumFilas(new Integer(0));
		bitacora.setIdArchivo(new Integer(idArchivo));
		bitacora.setObservaciones("Ocurrio un error al eliminar el archivo.");
		bitacora.setStatus("Archivo No Eliminado");
		try {
			ComisrepCatReportesComis cat = getCatReporte(Integer.valueOf(idTipoArchivo));
			cat.setIdArchivo(String.valueOf(idArchivo)); //Eliminacion de carga de archivo
			String ret[] = cargaArchivoDAO.deleteArchivosAnteriores(cat);
			if(!ret[0].equals("-1") && !ret[0].equals("0")){
				res = "<cveRespuesta>0</cveRespuesta>";
				res += "<Mensaje>Archivo eliminado correctamente.</Mensaje>";
				bitacora.setObservaciones("Se elimino correctamente el archivo seleccionado.");
				bitacora.setStatus("Archivo Eliminado");
			}
		} catch (Exception e) {}
		
		cargaArchivoDAO.insertarBitacora(bitacora);
		
		return res;
	}
	
	/* (sin Javadoc)
	 * @see iusacell.comisiones.bo.CargaArchivoBO#validarExtArchivo(java.lang.String, int)
	 */
	public String validarExtArchivo(String idTipoArchivo, int idArchivo) {
		String res = "";
		res += "<cveRespuesta>-1</cveRespuesta>";
		res += "<Mensaje>Ocurrio un error al consultar existentes.</Mensaje>";
		try {
			ComisrepCatReportesComis cat = getCatReporte(Integer.valueOf(idTipoArchivo));
			String ret[] = cargaArchivoDAO.validarArchivosAnteriores(cat);
			if(!ret[0].equals("-1") && !ret[0].equals("0")){
				res = "<cveRespuesta>0</cveRespuesta>";
				res += "<Mensaje>Ya existe un archivo Cargado.</Mensaje>";
			}
		} catch (Exception e) {}
		return res;
	}

	/**
	 * @return Devuelve cargaArchivoDAO.
	 */
	public CargaArchivoDAO getCargaArchivoDAO() {
		return cargaArchivoDAO;
	}
	/**
	 * @param cargaArchivoDAO El cargaArchivoDAO a establecer.
	 */
	public void setCargaArchivoDAO(CargaArchivoDAO cargaArchivoDAO) {
		this.cargaArchivoDAO = cargaArchivoDAO;
	}
	
}
