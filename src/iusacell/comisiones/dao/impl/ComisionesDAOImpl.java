/*
 * Creado el 24/11/2014
 *
 * Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package iusacell.comisiones.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import iusacell.comisiones.dao.ComisionesDAO;
import iusacell.comisiones.vo.PcBitacoraProcesos;
import iusacell.comisiones.vo.PcTotalesSem;
import iusacell.comisiones.vo.PcValidacionComisiones;
import iusacell.comisiones.vo.PermisosVO;
import iusacell.comisiones.vo.TablaComisionesAgregarVO;
import iusacell.comisiones.vo.TablaComisionesExcelVO;
import iusacell.comisiones.vo.TablaComisionesVO;

/**
 * @author jarredondoi
 *
 * Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
public class ComisionesDAOImpl extends JdbcDaoSupport implements ComisionesDAO {
	
	protected static final Logger logger = Logger.getLogger(ComisionesDAOImpl.class); //Des COMISDIS // prod PRODCM  // des PC_TIPO_CANAL@CLIECONP // prod PC_TIPO_CANAL@CLIECONP // DES pc_canal@CLIECONP //PROD pc_canal@CLIECONP
	
	public static String CARGA_PERIODO = "SELECT PC_SEM, PC_MES FROM PRODCM.PC_TOTALES_SEM WHERE  SUBSTR(PC_MES,1,4) = ? GROUP BY PC_SEM, PC_MES ORDER BY PC_SEM";
	public static String CONSOLIDADO = "SELECT A.PC_CVE_CANAL, B.PC_DESC_TP_CANAL, C.PC_DESC_CANAL, SUM(CASE WHEN PC_CVE_CONCEPTO = 1  AND  PC_CVE_GPO = 1 THEN PC_NUM_MOVIM ELSE   0 END) AS CANTIDAD_ACTIVACIONES, SUM(CASE WHEN PC_CVE_CONCEPTO = 1  AND  PC_CVE_GPO = 1 THEN PC_TOT_MONTO ELSE   0 END)   AS MONTO_ACTIVACIONES, SUM(CASE WHEN PC_CVE_CONCEPTO = 2  AND  PC_CVE_GPO = 1 THEN PC_NUM_MOVIM  ELSE   0  END) CANTIDAD_RENOVACIONES,  SUM(CASE  WHEN PC_CVE_CONCEPTO = 2  AND  PC_CVE_GPO = 1 THEN PC_TOT_MONTO ELSE   0 END) MONTO_RENOVACIONES, SUM(CASE WHEN PC_CVE_CONCEPTO = 1  AND  PC_CVE_GPO = 1 THEN PC_NUM_MOVIM  WHEN PC_CVE_CONCEPTO = 2  AND  PC_CVE_GPO = 1 THEN PC_NUM_MOVIM ELSE   0 END) TOTAL_MOVIMINETOS, SUM(CASE WHEN PC_CVE_CONCEPTO = 15 AND  PC_CVE_GPO = 1 THEN PC_TOT_MONTO ELSE   0 END) MONTO_TOTAL,  COUNT(1) CANTIDAD, A.CVE_ESTADO_AUTORIZACION FROM PRODCM.PC_TOTALES_SEM A, PC_TIPO_CANAL@CLIECONP B, pc_canal@CLIECONP C WHERE   A.PC_CVE_CANAL = C.PC_CVE_CANAL AND B.PC_CVE_TP_CANAL =   C.PC_CVE_TP_CANAL AND A.PC_SEM = ? AND A.PC_MES = ? AND A.PC_CVE_CONCEPTO IN (1,2,15) AND A.PC_CVE_GPO = 1 GROUP BY  A.PC_CVE_CANAL, B.PC_DESC_TP_CANAL, C.PC_DESC_CANAL, A.CVE_ESTADO_AUTORIZACION ORDER BY 1,9";
	public static String PUBLICAR = "UPDATE  PRODCM.PC_TOTALES_SEM SET  CVE_ESTADO_AUTORIZACION = 3 WHERE  PC_CVE_CANAL = ? AND CVE_ESTADO_AUTORIZACION = 1 AND PC_SEM = ? AND SUBSTR(PC_MES,1,4) = ?";
	public static String EXCEL = "SELECT * FROM PRODCM.PC_COMIS_VENTAS_SEM WHERE PC_ACTIV_MES = ? AND PC_SEMANA_VENTA = ?  ORDER BY PC_CVE_CANAL";
	public static String EXCEL_L = "SELECT PC_CVE_CANAL CVE_CANAL,  PC_ACTIV_MES MES_ACTIV, PC_SEMANA_VENTA  SEMANA_VENTA, A.CVE_CONTRATO   CONTRATO, A.ESN  ESN, A.NUM_TELEFONO  TELEFONO, TO_CHAR(B.FEC_TRANSACCION, 'DD/MM/YYYY') FECHA_ACTIV, A.PLAZO_FOR  PLAZO,  PC_MONTO   COMISION, A.PC_RENTA  RENTA,  A.PC_PORC_DESC  DESC_MULTILINEA, A.PC_PORC_DESC_ADI  DESC_ADICIONAL FROM PRODCM.PARAM_ACT A, PRODCM.TRANSACCION_MTRO B , PRODCM.PC_PAQUETES_MAESTRO PM, PRODCM.PC_COMIS_VENTAS_SEM SEM WHERE A.CDG_CIA = B.CDG_CIA AND A.NUM_TRANSACCION  = B.NUM_TRANSACCION AND A.TIPO_TRANSACCION = B.TIPO_TRANSACCION AND A.CDG_REGION = B.CDG_REGION AND A.CDG_CSI = B.CDG_CSI  AND PM.PC_CVE_PAQUETE  = A.CDG_PLAN_USO AND A.NUM_TRANSACCION  = SEM.NUM_TRANSACCION AND A.TIPO_TRANSACCION = SEM.TIPO_TRANSACCION AND A.NUM_CONTRATO = SEM.NUM_CONTRATO AND A.CDG_REGION = SEM.CDG_REGION AND A.CDG_CSI  = SEM.CDG_CSI AND PC_ACTIV_MES = ? AND PC_SEMANA_VENTA = ? ";
//	public static String TABLA_AGREGAR = "SELECT BUD_INS, TO_CHAR(BUD_FCH_ACTIVACION, 'DD/MM/YYYY') BUD_FCH_ACTIVACION, BUD_TELEFONO, BUD_ESN,BUD_ESTATUS FROM DWH_BASE_UNICA_DE_MOVIMIENTOS@DWHIUSA WHERE BUD_FCH_ACTIVACION = ? AND BUD_INS IN ";
	public static String INSERTADO = "SELECT NUM_CONTRATO, PC_STATUS,PC_ACTIV_MES||0||PC_SEMANA_VENTA FECHA_MOVIMIENTO FROM PRODCM.PC_COMIS_VENTAS_SEM WHERE NUM_CONTRATO = ? AND PC_ACTIV_MES = ? AND PC_SEMANA_VENTA = ? ORDER BY PC_CVE_CANAL";
	public static String BORRAR_PC_COMIS = "DELETE PRODCM.PC_COMIS_VENTAS_SEM WHERE PC_ACTIV_MES = ? AND PC_SEMANA_VENTA = ? ";
	public static String BORRAR_PC_TOTAL = "DELETE PRODCM.PC_TOTALES_SEM WHERE PC_SEM = ? AND PC_MES = ? ";
	public static String INSERTAR_CONTRATO = " {call Comi_Proc_Carga_Posp_Bum_U(?,?,?)}";
	public static String SEMANA_ACTUAL = "SELECT TO_CHAR(sysdate,'iw') SEMANA FROM DUAL";
	
	public static String SELECT_PERMISOS = "SELECT CATPER.ID_PERFIL, CATMOD.ID_MODULO, CATMOD.MODULO_DESC, CATMOD.MUDULO, CATMOD.URL FROM PRODCM.CAT_USUARIO_SISTEM_COMISIONES CATUS INNER JOIN PRODCM.CAT_PERFIL_SISTEM_COMISIONES CATPER ON (CATUS.ID_PERFIL = CATPER.ID_PERFIL) LEFT JOIN PRODCM.CAT_MPL_SISTEM_COMISIONES CATSIS ON (CATSIS.ID_PERFIL = CATUS.ID_PERFIL) LEFT JOIN PRODCM.CAT_MODULOS_SISTEM_COMISIONES CATMOD ON (CATSIS.ID_MODULO = CATMOD.ID_MODULO) WHERE CATUS.NO_EMPLEADO = ?";
	
	public static String SELECT_BITACORA_PROCESOS = "select PC_PROCESO, PC_FECHA_PROC, to_char(PC_FECHA_INI,'dd/mm/yyyy') PC_FECHA_INI, to_char(PC_FECHA_FIN,'dd/mm/yyyy') PC_FECHA_FIN, PC_NUM_REGS, PC_DESC_ESTATUS from  PC_BITACORA_PROCESOS WHERE TO_CHAR(pc_fecha_ini,'dd/mm/yyyy') = ? and TO_CHAR(pc_fecha_fin,'dd/mm/yyyy') = ? ORDER BY PC_FECHA_INI desc";
	public static String SELECT_VALIDACION_COMISIONES = "select CONCEPTO, REGISTROS, MOVIMIENTOS, MONTO, to_char(FECHA_CONSULTA,'dd/mm/yyyy') FECHA_CONSULTA, DIA, MES, \"AÑO\" ANIO, PERIODO_EJECUCION from PC_VALIDACION_COMISIONES where DIA = to_char(to_date(?,'dd/mm/yyyy'),'dd') and MES = to_char(to_date(?,'dd/mm/yyyy'),'mm') and \"AÑO\" = to_char(to_date(?,'dd/mm/yyyy'),'yyyy')";
	
	/* (sin Javadoc)
	 * @see iusacell.comisiones.dao.ComisionesDAO#obtenerPerido(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List<PcTotalesSem> obtenerPerido(String anio) throws SQLException {
		List<PcTotalesSem> lista = new ArrayList<PcTotalesSem>();
		String sql = CARGA_PERIODO;
		Object[] param = {anio};
		try {
			List<Map<String,Object>> datos = getJdbcTemplate().queryForList(sql,param);
			for (Map<String, Object> map : datos) {
				PcTotalesSem sem = new PcTotalesSem();
				sem.setPcMes(String.valueOf(map.get("PC_MES")));
				sem.setPcSem(String.valueOf(map.get("PC_SEM")));
				lista.add(sem);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error:",e);
		}
			
		return lista;
	}
	
	/* (sin Javadoc)
	 * @see iusacell.comisiones.dao.ComisionesDAO#obtenerTablaConsolidado(java.lang.String, java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List<TablaComisionesVO> obtenerTablaConsolidado(String anio, String periodo, String mes) throws SQLException {
		List<TablaComisionesVO> lista = new ArrayList<TablaComisionesVO>();
		String sql = CONSOLIDADO;
		logger.info("Query  = "+sql);
		Object[] param = {periodo,mes};
		try {
			List<Map<String, Object>> datos = getJdbcTemplate().queryForList(sql,param);
			for (Map<String, Object> dato : datos) {
				TablaComisionesVO tab = new TablaComisionesVO();
				tab.setClaveDistribuidor(String.valueOf(dato.get("PC_CVE_CANAL")));
				tab.setDescDistribuidor(String.valueOf(dato.get("PC_DESC_CANAL")));
				tab.setActivacionesCantidad(String.valueOf(dato.get("CANTIDAD_ACTIVACIONES")));
				tab.setActivacionesMonto(String.valueOf(dato.get("MONTO_ACTIVACIONES")));
				tab.setRenovacionesCantidad(String.valueOf(dato.get("CANTIDAD_RENOVACIONES")));
				tab.setRenovacionesMonto(String.valueOf(dato.get("MONTO_RENOVACIONES")));
				tab.setTotalesCantidad(String.valueOf(dato.get("TOTAL_MOVIMINETOS")));
				tab.setTotalesMonto(String.valueOf(dato.get("MONTO_TOTAL")));
				tab.setStatus(String.valueOf(dato.get("CVE_ESTADO_AUTORIZACION")));
				lista.add(tab);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error:",e);
		}
		return lista;
	}
	
	/* (sin Javadoc)
	 * @see iusacell.comisiones.dao.ComisionesDAO#publicar(java.lang.String, java.lang.String, java.lang.String)
	 */
	public String publicar(String seleccionado, String anio, String periodo, String mes) {
		String res = "";
		String sql = PUBLICAR;
		logger.info("Query  = "+sql);
		Object[] param = {seleccionado,periodo,anio};
		try {
			res = String.valueOf(getJdbcTemplate().update(sql,param));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error:",e);
		}
		return res;
	}
	
	/* (sin Javadoc)
	 * @see iusacell.comisiones.dao.ComisionesDAO#obtenerTablaExcel(java.lang.String, java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List<TablaComisionesExcelVO> obtenerTablaExcel(String anio, String periodo, String mes) {
		List<TablaComisionesExcelVO> lista = new ArrayList<TablaComisionesExcelVO>();
		String sql = EXCEL_L;
		logger.info("Query  = "+sql);
		Object[] param = {mes,periodo};
		try {
			List<Map<String, Object>> datos = getJdbcTemplate().queryForList(sql,param);
			for (Map<String, Object> dato : datos) {
				TablaComisionesExcelVO tab = new TablaComisionesExcelVO();
				tab.setCveCanal(String.valueOf(dato.get("CVE_CANAL")));
				tab.setMesActiv(String.valueOf(dato.get("MES_ACTIV")));
				tab.setSemanaVenta(String.valueOf(dato.get("SEMANA_VENTA")));
				tab.setContrato(String.valueOf(dato.get("CONTRATO")));
				tab.setEsn(String.valueOf(dato.get("ESN")));
				tab.setTelefono(String.valueOf(dato.get("TELEFONO")));
				tab.setFechaActiv(String.valueOf(dato.get("FECHA_ACTIV")));
				tab.setPlazo(String.valueOf(dato.get("PLAZO")));
				tab.setComision(String.valueOf(dato.get("COMISION")));
				tab.setRenta(String.valueOf(dato.get("RENTA")));
				tab.setDescMultimedia(String.valueOf(dato.get("DESC_MULTILINEA")));
				tab.setDescAdicional(String.valueOf(dato.get("DESC_ADICIONAL")));
				lista.add(tab);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error:",e);
		}
		return lista;
	}
	
	
	
	/* (sin Javadoc)
	 * @see iusacell.comisiones.dao.ComisionesDAO#validarInsertado(iusacell.comisiones.vo.TablaComisionesAgregarVO)
	 */
	@SuppressWarnings("unchecked")
	public int validarInsertado(TablaComisionesAgregarVO tab,String mes, String periodo) {
		int num = 0;
		String sql = INSERTADO;
		logger.info("Query  = "+sql);
		Object[] param = {tab.getContrato(),mes,periodo};
		try {
			List<Map<String, Object>> datos = getJdbcTemplate().queryForList(sql,param);
			if(datos!=null && datos.size()>0){
				num = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error:",e);
		}
		return num;
	}

	
	/* (sin Javadoc)
	 * @see iusacell.comisiones.dao.ComisionesDAO#agregarComisiones(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public String agregarComisiones(String contrato, String anio, String periodo, String mes, String fecha, String fechaFin) {
		
		
		String res = "";
		final String sql = INSERTAR_CONTRATO;
		logger.info("Query = "+sql);
		final String[] param = {fecha,fechaFin,contrato};
		try {
			getJdbcTemplate().execute(new CallableStatementCreator(){

				public CallableStatement createCallableStatement(Connection conn) throws SQLException {
					CallableStatement cs = conn.prepareCall(sql);
					cs.setString(1,param[0]);
					cs.setString(2,param[1]);
					cs.setString(3,param[2]);
					return cs;
				}
				
			},new CallableStatementCallback(){

				public Object doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
					cs.execute();
					return null;
				}
				
			});
			
		} catch (Exception e) {
			res = "-1";
			e.printStackTrace();
			logger.error("Error:",e);
		}
		
		return res;
	}
	
//	private int obtenerUltimoDiaMes (int anio, int mes) {
//	    Calendar cal=Calendar.getInstance();
//	    cal.set(anio, mes-1, 1);
//	    return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
//	}
	
	/* (sin Javadoc)
	 * @see iusacell.comisiones.dao.ComisionesDAO#obtenerSemanaActual()
	 */
	@SuppressWarnings("unchecked")
	public int obtenerSemanaActual() {
		int semana = -1;
		String sql = SEMANA_ACTUAL;
		logger.info("Query  = "+sql);
		try {
			List<Map<String, Object>> datos = getJdbcTemplate().queryForList(sql);
			for (Map<String, Object> dato : datos) {
				semana = Integer.valueOf(String.valueOf(dato.get("SEMANA"))).intValue();
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error:",e);
		}
		return semana;
		
	}
	
	/**
	 * Metodo para cerrar una conexion abierta
	 * 
	 * @param results ResultSet abierto
	 * @param conn Conexion abierta
	 */
	protected void cerrarConexion(ResultSet results, Connection conn){
		if(results != null){
			try{
				results.close();
			}catch(Exception e){}
		}
		if(conn != null){
			try{
				conn.close();
			}catch(Exception e){}
		}
	}

	/* (sin Javadoc)
	 * @see iusacell.comisiones.dao.ComisionesDAO#borrarTablaComisiones(java.lang.String, java.lang.String)
	 */
	public String borrarTablaComisiones(String periodo, String mes) {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

	/* (sin Javadoc)
	 * @see iusacell.comisiones.dao.ComisionesDAO#borrarTablaTotales(java.lang.String, java.lang.String)
	 */
	public String borrarTablaTotales(String periodo, String mes) {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

	/* (sin Javadoc)
	 * @see iusacell.comisiones.dao.ComisionesDAO#recalcularCalculoTotales(java.lang.String, java.lang.String)
	 */
	public String recalcularCalculoTotales(String fechaIni, String fechaFin) {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

	/* (sin Javadoc)
	 * @see iusacell.comisiones.dao.ComisionesDAO#obtnerPermisos(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List<PermisosVO> obtnerPermisos(String numEmpleado) {
		List<PermisosVO> lista = new ArrayList<PermisosVO>();
		String sql = SELECT_PERMISOS;
		logger.info("Query  = "+sql);
		Object[] param = {numEmpleado};
		try {
			List<Map<String,Object>> datos = getJdbcTemplate().queryForList(sql,param);
			for (Map<String, Object> dato : datos) {
				PermisosVO per = new PermisosVO();
				per.setIdPerfil(Integer.valueOf(String.valueOf(dato.get("ID_PERFIL"))));
				per.setIdModulo(dato.get("ID_MODULO")==null ?null:Integer.valueOf(String.valueOf(dato.get("ID_MODULO"))));
				per.setModulo(String.valueOf(dato.get("MUDULO")));
				per.setDescModulo(String.valueOf(dato.get("MODULO_DESC")));
				per.setUrl(String.valueOf(dato.get("URL")));
				lista.add(per);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error:",e);
		}
		return lista;
	}
	
	/* (sin Javadoc)
	 * @see iusacell.comisiones.dao.ComisionesDAO#obtnerPermisos(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List<PcBitacoraProcesos> obtenerBitacoraProcesos(String fechaIni, String fechaFin) {
		List<PcBitacoraProcesos> lista = new ArrayList<PcBitacoraProcesos>();
		String sql = SELECT_BITACORA_PROCESOS;
		logger.info("Query  = "+sql);
		Object[] param = {fechaIni,fechaFin};
		try {
			List<Map<String, Object>> datos = getJdbcTemplate().queryForList(sql,param);
			for (Map<String, Object> dato : datos) {
				PcBitacoraProcesos bita = new PcBitacoraProcesos();
				bita.setProceso(String.valueOf(dato.get("PC_PROCESO")));
				bita.setFechaProc(String.valueOf(dato.get("PC_FECHA_PROC")));
				bita.setFechaIni(String.valueOf(dato.get("PC_FECHA_INI")));
				bita.setFechaFin(String.valueOf(dato.get("PC_FECHA_FIN")));
				bita.setNumRegs(String.valueOf(dato.get("PC_NUM_REGS")));
				bita.setDescEstatus(String.valueOf(dato.get("PC_DESC_ESTATUS")));
				lista.add(bita);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error:",e);
		}
		return lista;
	}
	
	/* (sin Javadoc)
	 * @see iusacell.comisiones.dao.ComisionesDAO#obtnerPermisos(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List<PcValidacionComisiones> obtenerValidacionComisiones(String fecha) {
		List<PcValidacionComisiones> lista = new ArrayList<PcValidacionComisiones>();
		String sql = SELECT_VALIDACION_COMISIONES;
		logger.info("Query  = "+sql);
		Object[] param = {fecha};
		try {
			List<Map<String, Object>> datos = getJdbcTemplate().queryForList(sql,param);
			for (Map<String, Object> dato : datos) {
				PcValidacionComisiones val = new PcValidacionComisiones();
				val.setConcepto(String.valueOf(dato.get("CONCEPTO")));
				val.setRegistros(String.valueOf(dato.get("REGISTROS")));
				val.setMovimientos(String.valueOf(dato.get("MOVIMIENTOS")));
				val.setMonto(String.valueOf(dato.get("MONTO")));
				val.setFechaConsulta(String.valueOf(dato.get("FECHA_CONSULTA")));
				val.setDia(String.valueOf(dato.get("DIA")));
				val.setMes(String.valueOf(dato.get("MES")));
				val.setAnio(String.valueOf(dato.get("ANIO")));
				val.setPeriodoEjecucion(String.valueOf(dato.get("PERIODO_EJECUCION")));
				lista.add(val);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error:",e);
		}
		return lista;
	}

	/* (sin Javadoc)
	 * @see iusacell.comisiones.dao.ComisionesDAO#obtenerTipoContrato(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public int obtenerTipoContrato(String contrato, String anio, String periodo, String semana) {
		int tipoContrato = -1;
		String sql = "SELECT NUM_CONTRATO,PC_TIPO_CALC FROM PRODCM.PC_COMIS_VENTAS_SEM " +
						"WHERE PC_ACTIV_MES = ? AND PC_SEMANA_VENTA = ? AND NUM_CONTRATO = ?";
		logger.info("Query  = "+sql);
		Object[] param= {periodo,semana,contrato};
		try {
			List<Map<String, Object>> datos = getJdbcTemplate().queryForList(sql,param);
			for (Map<String, Object> dato : datos) {
				tipoContrato = Integer.valueOf(String.valueOf(dato.get("PC_TIPO_CALC"))).intValue();
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error:",e);
		}
		return tipoContrato;
		
	}

	/* (sin Javadoc)
	 * @see iusacell.comisiones.dao.ComisionesDAO#eliminarContratoTipo1(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public String[] eliminarContratoTipo1(String contrato, String anio, String periodo, String semana) {
		String[] res = new String[2];
		try {
			String sql = "DELETE PRODCM.PC_COMIS_VENTAS WHERE pc_cve_contrato IN ? AND pc_activ_mes = ?";
			Object[] datos = {contrato,periodo};
			getJdbcTemplate().update(sql,datos);
			res[0] = "0";
			res[1] = "Eliminada Correctamente";
		} catch (DataAccessException e) {
			res[0] = "-1";
			res[1] = "Ocurrio un error: " + e.getCause().getMessage();
		}
		return res;
	}
	
	/* (sin Javadoc)
	 * @see iusacell.comisiones.dao.ComisionesDAO#eliminarContratoTipo1(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public String[] eliminarContratoTipo2(String contrato, String anio, String periodo, String semana) {
		String[] res = new String[2];
		try {
			String sql = "DELETE PRODCM.PC_COMIS_RENOVACIONES WHERE pc_cve_contrato IN ? AND pc_renova_mes = ?";
			Object[] datos = {contrato,periodo};
			getJdbcTemplate().update(sql,datos);
			res[0] = "0";
			res[1] = "Eliminada Correctamente";
		} catch (DataAccessException e) {
			res[0] = "-1";
			res[1] = "Ocurrio un error: " + e.getCause().getMessage();
		}
		return res;
	}

	/* (sin Javadoc)
	 * @see iusacell.comisiones.dao.ComisionesDAO#eliminarPcComisVentasSem(java.lang.String, java.lang.String)
	 */
	public String[] eliminarPcComisVentasSem(String periodo, String semana) {
		String[] res = new String[2];
		try {
			String sql = "DELETE PRODCM.PC_COMIS_VENTAS_SEM WHERE PC_ACTIV_MES = ? AND PC_SEMANA_VENTA = ?";
			Object[] datos = {periodo,semana};
			getJdbcTemplate().update(sql,datos);
			res[0] = "0";
			res[1] = "Eliminada Correctamente";
		} catch (DataAccessException e) {
			res[0] = "-1";
			res[1] = "Ocurrio un error: " + e.getCause().getMessage();
		}
		return res;
	}

	/* (sin Javadoc)
	 * @see iusacell.comisiones.dao.ComisionesDAO#eliminarpcTotalesSem(java.lang.String, java.lang.String)
	 */
	public String[] eliminarpcTotalesSem(String periodo, String semana) {
		String[] res = new String[2];
		try {
			String sql = "DELETE PRODCM.PC_TOTALES_SEM WHERE PC_MES = ? AND PC_SEM = ?";
			Object[] datos = {periodo,semana};
			getJdbcTemplate().update(sql,datos);
			res[0] = "0";
			res[1] = "Eliminada Correctamente";
		} catch (DataAccessException e) {
			res[0] = "-1";
			res[1] = "Ocurrio un error: " + e.getCause().getMessage();
		}
		return res;
	}

	/* (sin Javadoc)
	 * @see iusacell.comisiones.dao.ComisionesDAO#reprocesarContratos(java.lang.String[])
	 */
	public String reprocesarContratos(String[] fechas) {
		
		
		String res = "";
		final String sql = " {call PRODCM.PC_CALC_SEM_ACT_REN ( ?, ? )}";
		logger.info("Query = "+sql);
		final String[] param = {fechas[0],fechas[1]};
		try {
			getJdbcTemplate().execute(new CallableStatementCreator(){

				public CallableStatement createCallableStatement(Connection conn) throws SQLException {
					CallableStatement cs = conn.prepareCall(sql);
					cs.setString(1,param[0]);
					cs.setString(2,param[1]);
					return cs;
				}
				
			},new CallableStatementCallback(){

				public Object doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
					cs.execute();
					return null;
				}
				
			});
			
		} catch (Exception e) {
			res = "-1";
			e.printStackTrace();
			logger.error("Error:",e);
		}
		
		return res;
	}
	
	/* (sin Javadoc)
	 * @see iusacell.comisiones.dao.ComisionesDAO#obtenerAgregarTabla(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List<TablaComisionesAgregarVO> obtenerValidarAgregarTablaDetalle(String contrato, String fecha) {
		List<TablaComisionesAgregarVO> lista = new ArrayList<TablaComisionesAgregarVO>();
		try {
			String sql = "SELECT b.cdg_tipo_vta TIPO_VENTA, num_contrato  CONTRATO, trunc(b.FEC_TRANSACCION)  FECHA_ACTIV, b.CDG_VENDEDOR  CVE_CANAL FROM PRODCM.PARAM_ACT A, PRODCM.TRANSACCION_MTRO B  WHERE (b.FEC_TRANSACCION + 210) >= ? AND A.CDG_CIA = B.CDG_CIA AND A.NUM_TRANSACCION  = B.NUM_TRANSACCION AND A.TIPO_TRANSACCION = B.TIPO_TRANSACCION AND A.CDG_REGION = B.CDG_REGION AND A.CDG_CSI = B.CDG_CSI AND a.cve_contrato IN (?) ORDER BY trunc(b.FEC_TRANSACCION)";
			logger.info("Query  = "+sql);
			
			Object[] param = {fecha,contrato};

			try {
				List<Map<String, Object>> datos = getJdbcTemplate().queryForList(sql,param);
				for (Map<String, Object> dato : datos) {
					TablaComisionesAgregarVO tab = new TablaComisionesAgregarVO();
					tab.setContrato(String.valueOf(dato.get("CONTRATO")));
					tab.setFecha(String.valueOf(dato.get("FECHA_ACTIV")));
					tab.setTipoVenta(String.valueOf(dato.get("TIPO_VENTA")));
					tab.setClaveCanal(String.valueOf(dato.get("CVE_CANAL")));
					lista.add(tab);
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Error:",e);
			}
		} catch (Exception e) {
			logger.info("SQL Error en obtenerPerido "+ e);
		}
		return lista;
	}
	
	/* (sin Javadoc)
	 * @see iusacell.comisiones.dao.ComisionesDAO#obtenerAgregarTablaDetalle(java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List<TablaComisionesAgregarVO> obtenerAgregarTablaDetalle(String contrato, String periodo) {
		List<TablaComisionesAgregarVO> lista = new ArrayList<TablaComisionesAgregarVO>();
		try {
			String sql = "SELECT BUD_EVE_ID TIPO_EVENTO, BUD_INS CONTRATO, BUD_DIA_DIA_MOVIMIENTO FECHA_ACTIV, BUD_CVE_CANAL_SAEO CANAL FROM DWH_BASE_UNICA_DE_MOVIMIENTOS@ESISCOM_DWHIUSA WHERE bud_ins IN (?) AND bud_eve_id IN (17,22) AND bud_rae_id IN  (1000,9987, 9990, 9991, 9993, 9994, 9995, 9996, 9997) AND SUBSTR(BUD_DIA_DIA_MOVIMIENTO,1,6) = ?";
			logger.info("Query  = "+sql);
			
			Object[] param = {contrato,periodo};

			try {
				List<Map<String, Object>> datos = getJdbcTemplate().queryForList(sql,param);
				for (Map<String, Object> dato : datos) {
					TablaComisionesAgregarVO tab = new TablaComisionesAgregarVO();
					tab.setContrato(String.valueOf(dato.get("CONTRATO")));
					tab.setFecha(String.valueOf(dato.get("FECHA_ACTIV")));
					tab.setTipoVenta(String.valueOf(dato.get("TIPO_EVENTO")));
					tab.setClaveCanal(String.valueOf(dato.get("CANAL")));
					lista.add(tab);
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Error:",e);
			}
		} catch (Exception e) {
			logger.info("SQL Error en obtenerPerido "+ e);
		}
		return lista;
	}

	/* (sin Javadoc)
	 * @see iusacell.comisiones.dao.ComisionesDAO#procesoCargaActivaciones(java.lang.String, java.lang.String, java.lang.String)
	 */
	public String procesoCargaActivaciones(String fechaInicio, String fechaFin, String contrato) {
		
		
		String res = "";
		final String sql = " {call PRODCM.CARGA_POSP_BUM ( ?, ?, ? )}";
		logger.info("Query = "+sql);
		final String[] param = {fechaInicio,fechaFin,contrato};
		try {
			getJdbcTemplate().execute(new CallableStatementCreator(){

				public CallableStatement createCallableStatement(Connection conn) throws SQLException {
					CallableStatement cs = conn.prepareCall(sql);
					cs.setString(1,param[0]);
					cs.setString(2,param[1]);
					cs.setString(3,param[2]);
					return cs;
				}
				
			},new CallableStatementCallback(){

				public Object doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
					cs.execute();
					return null;
				}
				
			});
			
		} catch (Exception e) {
			res = "-1";
			e.printStackTrace();
			logger.error("Error:",e);
		}
		
		return res;
	}

	/* (sin Javadoc)
	 * @see iusacell.comisiones.dao.ComisionesDAO#procesoCargaRenovaciones(java.lang.String, java.lang.String, java.lang.String)
	 */
	public String procesoCargaRenovaciones(String fechaInicio, String fechaFin, String contrato) {
		
		
		String res = "";
		final String sql = " {call PRODCM.CARGA_PORTAL_VMBUM ( ?, ?, ? )}";
		logger.info("Query = "+sql);
		final String[] param = {fechaInicio,fechaFin,contrato};
		try {
			getJdbcTemplate().execute(new CallableStatementCreator(){

				public CallableStatement createCallableStatement(Connection conn) throws SQLException {
					CallableStatement cs = conn.prepareCall(sql);
					cs.setString(1,param[0]);
					cs.setString(2,param[1]);
					cs.setString(3,param[2]);
					return cs;
				}
				
			},new CallableStatementCallback(){

				public Object doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
					cs.execute();
					return null;
				}
				
			});
			
		} catch (Exception e) {
			res = "-1";
			e.printStackTrace();
			logger.error("Error:",e);
		}
		
		return res;
	}
	
	/* (sin Javadoc)
	 * @see iusacell.comisiones.dao.ComisionesDAO#procesoCargaRenovaciones(java.lang.String, java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public String calcularcomisionesActivaciones(String fechaInicio, String diaFin, String contrato) {
		String res = "";
		try {
			String sql = "SELECT 'pc_Calculo_Ventas_r_u_0907 ('||	t.NUM_TRANSACCION || ',''' || t.TIPO_TRANSACCION  || ''',''' || t.CDG_CSI	|| ''',''' || t.CDG_REGION || ''',''' || t.CDG_CIA || ''',' || esq.pc_cve_esquema ||','|| sd.cve_contrato ||', ''' || TO_CHAR(t.fec_transaccion,'yyyymm')||'01'','''|| TO_CHAR(t.fec_transaccion,'yyyymm')|| ? ||''''||')' PRO FROM PRODCM.TRANSACCION_MTRO t, PRODCM.PARAM_ACT sd,  PRODCM.PC_CANAL_ESQUEMA esq WHERE SD.TIPO_TRANSACCION = t.TIPO_TRANSACCION AND SD.NUM_TRANSACCION  = t.NUM_TRANSACCION AND SD.CDG_REGION = t.CDG_REGION AND SD.CDG_CSI = t.CDG_CSI AND SD.CDG_CIA = t.CDG_CIA AND mov_erroneos IS NULL AND esq.pc_cve_canal=t.cdg_vendedor  AND t.fec_transaccion>=TO_DATE(?||' 000000' ,'yyyymmdd hh24miss') AND sd.cve_contrato IN  (?)";
			logger.info("Query  = "+sql);
			
			Object[] param = {diaFin,fechaInicio,contrato};
			

			try {
				List<Map<String, Object>> datos = getJdbcTemplate().queryForList(sql,param);
				for (Map<String, Object> dato : datos) {
					res = String.valueOf(dato.get("PRO"));
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Error:",e);
			}
		} catch (Exception e) {
			logger.error("SQL Error en obtenerPerido ",e);
		}
		return res;
	}

	/* (sin Javadoc)
	 * @see iusacell.comisiones.dao.ComisionesDAO#procesoCalcularInterfactura(java.lang.String)
	 */
	public String procesoCalcularInterfactura(String consulta) {
		
		
		String res = "";
		final String sql = " {call PRODCM."+consulta+"}";
		logger.info("Query = "+sql);
		try {
			getJdbcTemplate().execute(new CallableStatementCreator(){

				public CallableStatement createCallableStatement(Connection conn) throws SQLException {
					CallableStatement cs = conn.prepareCall(sql);
					return cs;
				}
				
			},new CallableStatementCallback(){

				public Object doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
					cs.execute();
					return null;
				}
				
			});
			
		} catch (Exception e) {
			res = "-1";
			e.printStackTrace();
			logger.error("Error:",e);
		}
		
		return res;
	}

}
