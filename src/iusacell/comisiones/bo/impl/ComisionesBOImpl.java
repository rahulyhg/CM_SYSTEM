/*
 * Creado el 24/11/2014
 *
 * Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package iusacell.comisiones.bo.impl;

import java.io.BufferedOutputStream;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;

import iusacell.comisiones.bo.ComisionesBO;
import iusacell.comisiones.dao.ComisionesDAO;
import iusacell.comisiones.vo.PcTotalesSem;
import iusacell.comisiones.vo.TablaComisionesAgregarVO;
import iusacell.comisiones.vo.TablaComisionesExcelVO;
import iusacell.comisiones.vo.TablaComisionesVO;
import iusacell.comisiones.util.LineException;
import iusacell.comisiones.util.GeneraExcel;

/**
 * @author jarredondoi
 *
 * Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
public class ComisionesBOImpl implements ComisionesBO {
	
	private ComisionesDAO comisionesDAO;
	GeneraExcel generaExcel;
	
	protected static final Logger logger = Logger.getLogger(ComisionesBOImpl.class);

	/* (sin Javadoc)
	 * @see iusacell.comisiones.bo.ComisionesBO#obtenerPeriodo(java.lang.String)
	 */
	public List<PcTotalesSem> obtenerPeriodo(String anio) {
		List<PcTotalesSem> lista = null;
		try {
			lista = comisionesDAO.obtenerPerido(anio);
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("ComisionesBOImpl",e);
		}
		return lista;
	}

	/* (sin Javadoc)
	 * @see iusacell.comisiones.bo.ComisionesBO#obtenerConsolidadoTabla(java.lang.String, java.lang.String, java.lang.String)
	 */
	public List<TablaComisionesVO> obtenerConsolidadoTabla(String anio, String periodo, String mes) {
		List<TablaComisionesVO> lista = null;
		try {
			lista = comisionesDAO.obtenerTablaConsolidado(anio,periodo,mes);
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("ComisionesBOImpl",e);
		}
		return lista;
	}

	/* (sin Javadoc)
	 * @see iusacell.comisiones.bo.ComisionesBO#publicar(java.lang.String, java.lang.String, java.lang.String)
	 */
	public String publicar(String seleccionado, String anio, String periodo, String mes) {
		String res = "-1";
		try {
			res = comisionesDAO.publicar(seleccionado,anio,periodo,mes);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("ComisionesBOImpl",e);
		}
		return res;
	}

	/* (sin Javadoc)
	 * @see iusacell.comisiones.bo.ComisionesBO#obtenerTablaExcel(java.lang.String, java.lang.String, java.lang.String)
	 */
	public List<TablaComisionesExcelVO> obtenerTablaExcel(String anio, String periodo, String mes) {
		List<TablaComisionesExcelVO> lista = null;
		try {
			lista = comisionesDAO.obtenerTablaExcel(anio,periodo,mes);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("ComisionesBOImpl",e);
		}
		return lista;
	}

	/* (sin Javadoc)
	 * @see iusacell.comisiones.bo.ComisionesBO#generarReporte(java.io.BufferedOutputStream, java.util.List)
	 */
	public void generarReporte(BufferedOutputStream outputStream, List<TablaComisionesExcelVO> lista) {
		try{
			TablaComisionesExcelVO vo = new TablaComisionesExcelVO();
			generaExcel.init();
			generaExcel.setNameSheet("Interfactura");
			generaExcel.setup();
			HSSFCellStyle headerStyle = generaExcel.getStyle();
			HSSFFont headerFont = generaExcel.getFont();
			headerFont.setColor(HSSFColor.WHITE.index);
	        headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	        headerFont.setFontHeightInPoints((short) 10);
	        headerStyle.setFont(headerFont);
	        //headerStyle.setFillBackgroundColor(HSSFColor.BLUE.index);
	        headerStyle.setFillForegroundColor((short) 190);//190
	        headerStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
	        generaExcel.setHeaderStyle(headerStyle);
	        generaExcel.setColumWidth(vo.getWidth());
			generaExcel.reporteExcel(lista, vo);
			generaExcel.write(outputStream);
		}catch(Exception exc){
			logger.error(LineException.getException(exc),exc);
		}
	
	}

	/* (sin Javadoc)
	 * @see iusacell.comisiones.bo.ComisionesBO#validarInsertado(iusacell.comisiones.vo.TablaComisionesAgregarVO)
	 */
	public boolean validarInsertado(TablaComisionesAgregarVO tab, String mes, String periodo) {
		boolean existe = false;
		try {
			int ex = comisionesDAO.validarInsertado(tab, mes, periodo);
			if(ex > 0){
				existe = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("ComisionesBOImpl",e);
		}
		return existe;
	}

	/* (sin Javadoc)
	 * @see iusacell.comisiones.bo.ComisionesBO#agregarComisiones(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public String agregarComisiones(String contrato, String anio, String periodo, String mes, String fechaIni, String fechaFin) {
		String res = "-1";
		try {
			res = comisionesDAO.agregarComisiones(contrato, anio, periodo, mes, fechaIni, fechaFin);
			if(res != "-1"){
				res = comisionesDAO.borrarTablaComisiones(periodo, mes);
				res += comisionesDAO.borrarTablaTotales(periodo, mes);
				if(res != "-1"){
					res = comisionesDAO.recalcularCalculoTotales(fechaIni, fechaFin);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("ComisionesBOImpl",e);
		}
		return res;
	}

	/* (sin Javadoc)
	 * @see iusacell.comisiones.bo.ComisionesBO#obtenerSemanaActual()
	 */
	public Integer obtenerSemanaActual() {
		int semana = -1;
		try {
			semana = comisionesDAO.obtenerSemanaActual();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("ComisionesBOImpl",e);
		}
		return new Integer(semana);
	}
	
	/**
	 * @return Devuelve comisionesDAO.
	 */
	public ComisionesDAO getComisionesDAO() {
		return comisionesDAO;
	}
	/**
	 * @param comisionesDAO El comisionesDAO a establecer.
	 */
	public void setComisionesDAO(ComisionesDAO comisionesDAO) {
		this.comisionesDAO = comisionesDAO;
	}
	/**
	 * @return Devuelve generaExcel.
	 */
	public GeneraExcel getGeneraExcel() {
		return generaExcel;
	}
	/**
	 * @param generaExcel El generaExcel a establecer.
	 */
	public void setGeneraExcel(GeneraExcel generaExcel) {
		this.generaExcel = generaExcel;
	}

	/* (sin Javadoc)
	 * @see iusacell.comisiones.bo.ComisionesBO#eliminarContrato(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public boolean eliminarContrato(String anio, String periodo, String semana, String contrato) {

		//Obtener el tipo de contrato 
		int tipo = comisionesDAO.obtenerTipoContrato(contrato, anio, periodo, semana);
		
		if(tipo == 1){
			comisionesDAO.eliminarContratoTipo1(contrato, anio, periodo, semana);
		}else{
			comisionesDAO.eliminarContratoTipo2(contrato, anio, periodo, semana);
		}
		
		
		return true;
	}

	/* (sin Javadoc)
	 * @see iusacell.comisiones.bo.ComisionesBO#eliminarContratosDetalle(java.lang.String, java.lang.String, java.lang.String, java.lang.String[])
	 */
	public boolean eliminarContratosDetalle(String anio, String periodo, String semana, String[] contratos) {
		try {
			for (int i = 0; i < contratos.length; i++) {
				String contrato = contratos[i];
				eliminarContrato(anio,periodo,semana,contrato);
			}
			comisionesDAO.eliminarPcComisVentasSem(periodo,semana);
			comisionesDAO.eliminarpcTotalesSem(periodo,semana);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("ComisionesBOImpl",e);
		}
		return true;
	}

	/* (sin Javadoc)
	 * @see iusacell.comisiones.bo.ComisionesBO#reprocesarContratosDetalle(java.lang.String, java.lang.String, java.lang.String)
	 */
	public boolean reprocesarContratosDetalle(String[] fechas) {
		try {
			comisionesDAO.reprocesarContratos(fechas);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("ComisionesBOImpl",e);
		}
		return true;
	}
	
	/* (sin Javadoc)
	 * @see iusacell.comisiones.bo.ComisionesBO#obtenerAgregarTabla(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public List<TablaComisionesAgregarVO> obtenerValidarAgregarTablaDetalle(String contrato, String anio, String periodo, String semana,String[] fechas) {
		List<TablaComisionesAgregarVO> lista = null;
		try {
			lista = comisionesDAO.obtenerValidarAgregarTablaDetalle(contrato,fechas[5]);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("ComisionesBOImpl",e);
		}
		return lista;
	}
	
	/* (sin Javadoc)
	 * @see iusacell.comisiones.bo.ComisionesBO#obtenerAgregarTablaDetalle(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public List<TablaComisionesAgregarVO> obtenerAgregarTablaDetalle(String contrato, String anio, String periodo, String semana) {
		List<TablaComisionesAgregarVO> lista = null;
		try {
//			String[] fechas = obtenerFechasInicioFin();
			
			lista = comisionesDAO.obtenerAgregarTablaDetalle(contrato,periodo);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("ComisionesBOImpl",e);
		}
		return lista;
	}
	
	/* (sin Javadoc)
	 * @see iusacell.comisiones.bo.ComisionesBO#agregarContratoDetalle(java.lang.String, java.lang.String, java.lang.String, iusacell.comisiones.vo.TablaComisionesAgregarVO)
	 */
	public void agregarContratoDetalle(String anio, String periodo, String semana, TablaComisionesAgregarVO agregaVO,String[] fechas) {
		try {
			String fechaInicio = fechas[2];
			String fechaFin = fechas[3];
			String diaFin = fechas[4];
			String contrato = agregaVO.getContrato();
			//proceso para agregar 
			if(agregaVO.getTipoVenta().equals("17")){
				comisionesDAO.procesoCargaActivaciones(fechaInicio,fechaFin,contrato);
			}else{
				comisionesDAO.procesoCargaRenovaciones(fechaInicio,fechaFin,contrato);
			}
			//calcular las comisiones y activaciones
			String consulta = comisionesDAO.calcularcomisionesActivaciones( fechaInicio,  diaFin,  contrato);
			//Calcular interfactura
			comisionesDAO.procesoCalcularInterfactura(consulta);
			//Borrar tablas
			comisionesDAO.eliminarPcComisVentasSem(periodo,semana);
			comisionesDAO.eliminarpcTotalesSem(periodo,semana);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("ComisionesBOImpl",e);
		}
		
	}

}
