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

import iusacell.comisiones.bo.ComisionesReportesBO;
import iusacell.comisiones.dao.ComisionesReportesDAO;
import iusacell.comisiones.vo.PcTotalesSem;
import iusacell.comisiones.vo.ValueObject;
import iusacell.comisiones.util.GeneraExcel;
import iusacell.comisiones.util.GeneraExcelReportes;
import iusacell.comisiones.util.LineException;

/**
 * @author jarredondoi
 *
 * Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
public class ComisionesReportesBOImpl implements ComisionesReportesBO {
	
	private ComisionesReportesDAO comisionesReportesDAO;
	private GeneraExcel generaExcel;
	
	protected static final Logger logger = Logger.getLogger(ComisionesReportesBOImpl.class);

	/* (sin Javadoc)
	 * @see iusacell.comisiones.bo.ComisionesBO#obtenerPeriodo(java.lang.String)
	 */
	public List<PcTotalesSem> obtenerPeriodo(String anio) {
		List<PcTotalesSem> lista = null;
		try {
			lista = comisionesReportesDAO.obtenerPerido(anio);
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("ComisionesBOImpl",e);
		}
		return lista;
	}
	
	public List<PcTotalesSem> obtenerPeridoMes(String anio) {
		List<PcTotalesSem> lista = null;
		try {
			lista = comisionesReportesDAO.obtenerPeridoMes(anio);
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("ComisionesBOImpl",e);
		}
		return lista;
	}



	@SuppressWarnings("unchecked")
	public List obtenerReporteMensual(int consulta, String periodo, String primerDia, String ultimoDia) {
		List lista = null;
		try {
			lista = comisionesReportesDAO.obtenerReporteMensual(consulta, periodo, primerDia, ultimoDia);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("ComisionesBOImpl",e);
		}
		return lista;
	}



	@SuppressWarnings("unchecked")
	public List obtenerReporteSemanal(int consulta, String primerDia, String ultimoDia) {
		List lista = null;
		try {
			lista = comisionesReportesDAO.obtenerReporteSemanal(consulta, primerDia, ultimoDia);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("ComisionesBOImpl",e);
		}
		return lista;
	}

	
	
	@SuppressWarnings("unchecked")
	public void generarReporte(BufferedOutputStream outputStream, List lista) throws Exception {
		try{
			GeneraExcelReportes ge = new GeneraExcelReportes("Reporte");
			ge.setup();
			HSSFCellStyle headerStyle = ge.getStyle();
			HSSFFont headerFont = ge.getFont();
			headerFont.setColor(HSSFColor.WHITE.index);
	        headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	        headerFont.setFontHeightInPoints((short) 10);
	        headerStyle.setFont(headerFont);
	        //headerStyle.setFillBackgroundColor(HSSFColor.BLUE.index);
	        headerStyle.setFillForegroundColor((short) 190);//190
	        headerStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
	        ge.setHeaderStyle(headerStyle);
	        ge.setColumWidth(((ValueObject) lista.get(0)).getLongitudes());
			ge.reporteExcel(lista, (ValueObject) lista.get(0));
			ge.write(outputStream);
		}catch(Exception exc){
			logger.info(LineException.getException(exc));
			throw new Exception(exc.getMessage());
		}
	
	}

    public void setComisionesReportesDAO(
            ComisionesReportesDAO comisionesReportesDAO) {
        this.comisionesReportesDAO = comisionesReportesDAO;
    }

	public GeneraExcel getGeneraExcel() {
		return generaExcel;
	}

	public void setGeneraExcel(GeneraExcel generaExcel) {
		this.generaExcel = generaExcel;
	}

	public ComisionesReportesDAO getComisionesReportesDAO() {
		return comisionesReportesDAO;
	}

}
