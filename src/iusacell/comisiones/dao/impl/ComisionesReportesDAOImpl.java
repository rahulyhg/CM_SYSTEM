/*
 * Creado el 24/11/2014
 *
 * Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package iusacell.comisiones.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import iusacell.comisiones.dao.ComisionesReportesDAO;
import iusacell.comisiones.util.ReportesMensuales;
import iusacell.comisiones.util.ReportesSemanales;
import iusacell.comisiones.vo.PcTotalesSem;
import iusacell.comisiones.vo.ValueObject;
import iusacell.comisiones.vo.reportes.mensuales.ActivacionesVO;
import iusacell.comisiones.vo.reportes.mensuales.AdonsVO;
import iusacell.comisiones.vo.reportes.mensuales.BajasAdministrativasVO;
import iusacell.comisiones.vo.reportes.mensuales.CaesArsaVO;
import iusacell.comisiones.vo.reportes.mensuales.ChargeBackPospagoVO;
import iusacell.comisiones.vo.reportes.mensuales.ChargeBackRenovPospagoVO;
import iusacell.comisiones.vo.reportes.mensuales.CobranzaVO;
import iusacell.comisiones.vo.reportes.mensuales.ComDiferidaActivacionesKyhVO;
import iusacell.comisiones.vo.reportes.mensuales.ComDiferidaRenovacionesKyhVO;
import iusacell.comisiones.vo.reportes.mensuales.DctosMultilineaTotalesVO;
import iusacell.comisiones.vo.reportes.mensuales.DescuentosAdicionalVO;
import iusacell.comisiones.vo.reportes.mensuales.DescuentosMultilineaVO;
import iusacell.comisiones.vo.reportes.mensuales.MovimientosAdonsVO;
import iusacell.comisiones.vo.reportes.mensuales.PrepagoEqCajon;
import iusacell.comisiones.vo.reportes.mensuales.PrepagoEqNuevo;
import iusacell.comisiones.vo.reportes.mensuales.RenovacionesVO;
import iusacell.comisiones.vo.reportes.mensuales.ReporteResidualesVO;
import iusacell.comisiones.vo.reportes.mensuales.dctosAdicionalTotalesVO;
import iusacell.comisiones.vo.reportes.semanales.BajaRenovacionesVO;
import iusacell.comisiones.vo.reportes.semanales.BajasActivacionesVO;
import iusacell.comisiones.vo.reportes.semanales.PrepagoVO;
import iusacell.comisiones.vo.reportes.semanales.ReportePortabilidadVO;

/**
 * @author jarredondoi
 *
 * Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
public class ComisionesReportesDAOImpl extends JdbcDaoSupport implements ComisionesReportesDAO {
	
	protected static final Logger logger = Logger.getLogger(ComisionesReportesDAOImpl.class); //Des COMISDIS // prod PRODCM  // des PC_TIPO_CANAL // prod PC_TIPO_CANAL@CLIECONP
	
	public static String CARGA_PERIODO_SEMANA = "SELECT PC_SEM, PC_MES FROM PRODCM.PC_TOTALES_SEM WHERE  SUBSTR(PC_MES,1,4) = ? GROUP BY PC_SEM, PC_MES ORDER BY PC_SEM";
	//public static String CARGA_PERIODO_MES = "SELECT PC_MES PERIODO, SUBSTR(PC_MES,5,6) MES, SUBSTR(PC_MES,1,4) ANIO FROM PRODCM.PC_TOTALES_SEM WHERE  SUBSTR(PC_MES,1,4) = ? GROUP BY PC_MES ORDER BY PC_MES";
	
	//TEST CON TABLA DE COBRANZA
	public static String CARGA_PERIODO_MES = "SELECT PC_COBRANZA_MES PERIODO, SUBSTR(PC_COBRANZA_MES,5,6) MES, SUBSTR(PC_COBRANZA_MES,1,4) ANIO FROM PRODCM.PC_COMIS_COBRANZA WHERE  SUBSTR(PC_COBRANZA_MES,1,4) = ? GROUP BY PC_COBRANZA_MES ORDER BY PC_COBRANZA_MES";
	//public static String CARGA_PERIODO_SEMANA = "SELECT PC_SEM, PC_MES FROM PRODCM.PC_TOTALES_SEM WHERE  SUBSTR(PC_MES,1,4) = ? GROUP BY PC_SEM, PC_MES ORDER BY PC_SEM";
	//For test purpoueses hard conde the month
	//public static String CARGA_PERIODO_SEMANA = "SELECT PC_SEM, PC_MES FROM PRODCM.PC_TOTALES_SEM WHERE  SUBSTR(PC_MES,1,4) = '2014' GROUP BY PC_SEM, PC_MES ORDER BY PC_SEM";
	//public static String CARGA_PERIODO_MES = "SELECT PC_MES PERIODO, SUBSTR(PC_MES,5,6) MES, SUBSTR(PC_MES,1,4) ANIO FROM PRODCM.PC_TOTALES_SEM WHERE  SUBSTR(PC_MES,1,4) = '2014' GROUP BY PC_MES ORDER BY PC_MES";
	
	/* (sin Javadoc)
	 * @see iusacell.comisiones.dao.ComisionesDAO#obtenerPerido(java.lang.String)
	 */
	public List<PcTotalesSem> obtenerPerido(String anio) throws SQLException {
		List<PcTotalesSem> lista = new ArrayList<PcTotalesSem>();
		String sql = CARGA_PERIODO_SEMANA;
		Object[] param = {anio};
		try {
			List<Map<String, Object>> datos = getJdbcTemplate().queryForList(sql,param);
			for (Map<String, Object> dato : datos) {
				PcTotalesSem sem = new PcTotalesSem();
				sem.setPcMes(String.valueOf(dato.get("PC_MES")));
				sem.setPcSem(String.valueOf(dato.get("PC_SEM")));
				lista.add(sem);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error:",e);
		}
			
		return lista;
	}
	
	/* (sin Javadoc)
	 * @see iusacell.comisiones.dao.ComisionesDAO#obtenerPerido(java.lang.String)
	 */
	public List<PcTotalesSem> obtenerPeridoMes(String anio) throws SQLException {
		List<PcTotalesSem> lista = new ArrayList<PcTotalesSem>();
		String sql = CARGA_PERIODO_MES;
		Object[] param = {anio};
		//Object[] param = {"2014"}; //para pruebas
		try {
			List<Map<String, Object>> datos = getJdbcTemplate().queryForList(sql,param);
			for (Map<String, Object> dato : datos) {
				PcTotalesSem sem = new PcTotalesSem();
				sem.setPcMes(String.valueOf(dato.get("PERIODO")));
				sem.setPcSem(String.valueOf(dato.get("MES")));
				lista.add(sem);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error:",e);
		}
			
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List obtenerReporteMensual(int consulta, String periodo, String primerDia, String ultimoDia){

		List <ValueObject> lista = new ArrayList<ValueObject>();
		String sql = null;
		//periodo="201611"; //para pruebas
		//periodo="200501"; //para pruebas
		System.out.println("periodo del reporte: "+periodo);
		Object[] param = {periodo};
		
		switch (consulta) {
		case 1: sql = ReportesMensuales.ACTIVACIONES; break;
		case 2: sql = ReportesMensuales.RENOVACIONES; param = new Object[2];param[0]=periodo;param[1]=periodo; break;
		case 3: sql = ReportesMensuales.CHARGE_BACK_POSPAGO; break;
		case 4: sql = ReportesMensuales.CHARGE_BACK_RENOV_POSPAGO; break;
		//case 5: sql = ReportesMensuales.COM_DIFERIDA_ACTIVACIONES_KYH; break;
		//case 6: sql = ReportesMensuales.COM_DIFERIDA_RENOVACIONES_KYH; break;
		case 7: sql = ReportesMensuales.DESCUENTOS_MULTILINEA; param = new Object[3];param[0]=periodo;param[1]=primerDia;param[2]=ultimoDia; break;
		case 8: sql = ReportesMensuales.DESCUENTOS_ADICIONAL; param = new Object[3];param[0]=primerDia;param[1]=ultimoDia;param[2]=periodo; break;
		case 9: sql = ReportesMensuales.DCTOS_MULTILINEA_TOTALES; param = new Object[2];param[0]=primerDia;param[1]=ultimoDia; break;
		case 10: sql = ReportesMensuales.DCTOS_ADICIONAL_TOTALES; param = new Object[2];param[0]=primerDia;param[1]=ultimoDia; break;
		case 11: sql = ReportesMensuales.PREPAGO_EQ_NUEVO; break;
		case 12: sql = ReportesMensuales.PREPAGO_EQ_CAJON; break;
		case 13: sql = ReportesMensuales.COBRANZA; break;
		case 14: sql = ReportesMensuales.CAES_ARSA; param = new Object[2];param[0]=primerDia;param[1]=ultimoDia; break;
		case 15: sql = ReportesMensuales.ADONS; break;
		case 16: sql = ReportesMensuales.MOVIMIENTOS_ADONS; param = new Object[0]; break;
		case 17: sql = ReportesMensuales.BAJAS_ADMINISTRATIVAS; break;
		case 18: sql = ReportesMensuales.REPORTE_RESIDUALES; break;
		}
		
		try {
			List<Map<String, Object>> datos = getJdbcTemplate().queryForList(sql,param);
			for (Map<String, Object> dato : datos) {
				switch (consulta) {
				case 1: lista.add(new ActivacionesVO(dato)); break;
				case 2: lista.add(new RenovacionesVO(dato)); break;
				case 3: lista.add(new ChargeBackPospagoVO(dato)); break;
				case 4: lista.add(new ChargeBackRenovPospagoVO(dato)); break;
				case 5: lista.add(new ComDiferidaActivacionesKyhVO(dato)); break;
				case 6: lista.add(new ComDiferidaRenovacionesKyhVO(dato)); break;
				case 7: lista.add(new DescuentosMultilineaVO(dato)); break;
				case 8: lista.add(new DescuentosAdicionalVO(dato)); break;
				case 9: lista.add(new DctosMultilineaTotalesVO(dato)); break;
				case 10: lista.add(new dctosAdicionalTotalesVO(dato)); break;
				case 11: lista.add(new PrepagoEqNuevo(dato)); break;
				case 12: lista.add(new PrepagoEqCajon(dato)); break;
				case 13: lista.add(new CobranzaVO(dato)); break;
				case 14: lista.add(new CaesArsaVO(dato)); break;
				case 15: lista.add(new AdonsVO(dato)); break;
				case 16: lista.add(new MovimientosAdonsVO(dato)); break;  
				case 17: lista.add(new BajasAdministrativasVO(dato)); break;
				case 18: lista.add(new ReporteResidualesVO(dato)); break;
				}
			}
			
			switch(consulta){
				case 16: Collections.sort((ArrayList)lista);  //Sort MovimientosAddons by activation date
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error:",e);
		}
			
		return lista;
	
	}
	
	@SuppressWarnings("unchecked")
	public List obtenerReporteSemanal(int consulta, String primerDia, String ultimoDia){

		List lista = new ArrayList();
		String sql = null;
		Object[] param = {primerDia,ultimoDia};
		
		switch (consulta) {
		case 1: sql = ReportesSemanales.ACTIVACIONES; break;
		case 2: sql = ReportesSemanales.RENOVACIONES; break;
		case 3: sql = ReportesSemanales.BAJAS_ACTIVACIONES; break;
		case 4: sql = ReportesSemanales.BAJAS_RENOVACIONES; break;
		case 5: sql = ReportesSemanales.COBRANZA; break;
		case 6: sql = ReportesSemanales.PREPAGO; break;
		case 7: sql = ReportesSemanales.REPORTE_PORTABILIDAD; break;
		}
		
		try {
			List<Map<String, Object>> datos = getJdbcTemplate().queryForList(sql,param);
			for (Map<String, Object> dato : datos) {
				switch (consulta) {
				case 1: lista.add(new iusacell.comisiones.vo.reportes.semanales.ActivacionesVO(dato)); break;
				case 2: lista.add(new iusacell.comisiones.vo.reportes.semanales.RenovacionesVO(dato)); break;
				case 3: lista.add(new BajasActivacionesVO(dato)); break;
				case 4: lista.add(new BajaRenovacionesVO(dato)); break;
				case 5: lista.add(new iusacell.comisiones.vo.reportes.semanales.CobranzaVO(dato)); break;
				case 6: lista.add(new PrepagoVO(dato)); break;
				case 7: lista.add(new ReportePortabilidadVO(dato)); break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error:",e);
		}
			
		return lista;
	
	}
}
