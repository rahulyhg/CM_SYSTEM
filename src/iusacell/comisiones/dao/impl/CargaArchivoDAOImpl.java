/*
 * Creado el 26/02/2015
 *
 * Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package iusacell.comisiones.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import mx.com.iusacell.comisiones.utilerias.Util;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import iusacell.comisiones.dao.CargaArchivoDAO;
import iusacell.comisiones.vo.ComisrepBitacoraVO;
import iusacell.comisiones.vo.carga.ComisrepCatReportesComis;

/**
 * @author jarredondoi
 *
 * Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
public class CargaArchivoDAOImpl extends JdbcDaoSupport implements CargaArchivoDAO {
	
	protected static final Logger logger = Logger.getLogger(CargaArchivoDAOImpl.class);
	
	public static String SELECT_COM_ACT_BAJA_POS = "SELECT * FROM ( SELECT ROWNUM AS R, E.* FROM ( SELECT <Columnas> FROM SISTE.<Tabla> WHERE ID_REPORTE = ? ORDER BY VERSION) E) WHERE R >= ? AND R <= ? ";
	public static String COUNT_COM_ACT_BAJA_POS = "SELECT COUNT(*) FROM SISTE.<Tabla> WHERE ID_REPORTE = ?";
	public static String ID_ARCHIVOS_COM_ACT_BAJA_POS = "SELECT * FROM (SELECT ID_REPORTE, ID_REPORTE || ' - ' || TO_CHAR(\"VERSION\",'dd/MM/yyyy') AS PERIODO FROM SISTE.<Tabla> GROUP BY (ID_REPORTE,ID_REPORTE || ' - ' || TO_CHAR(\"VERSION\",'dd/MM/yyyy')) ORDER BY ID_REPORTE DESC) WHERE ROWNUM <= 10";
	public static String ID_ARCHIVOS_SIG = "SELECT DECODE(MAX(ID_REPORTE),NULL,1,MAX(ID_REPORTE)+1) AS AC FROM SISTE.<Tabla>";
	public static String SELECT_CAT_REP = "SELECT CAT.ID_REPORTE, CAT.REPORTE_DESCRIPCION, CAT.ID_CANAL, CAT.ID_PERIODICIDAD, CAT.COLUMNAS, CAT.NUM_COLUMNAS, CAT.COLUM_DATE FROM SISTE.COMISREP_CAT_REPORTES_COMIS CAT INNER JOIN SISTE.COMISREP_CAT_REPORTE_USUARIOS REP ON (CAT.ID_REPORTE = REP.ID_REPORTE) INNER JOIN SISTE.COMISREP_CAT_USUARIOS_COMIS US ON (REP.NO_EMPLEADO = US.NO_EMPLEADO) WHERE US.ID_PERFIL IN ({param}) AND US.NO_EMPLEADO = ? GROUP BY (CAT.ID_REPORTE, CAT.REPORTE_DESCRIPCION, CAT.ID_CANAL, CAT.ID_PERIODICIDAD, CAT.COLUMNAS, CAT.NUM_COLUMNAS, CAT.COLUM_DATE) order by CAT.REPORTE_DESCRIPCION";
	public static String SELECT_CAT_REP_ADMIN = "SELECT * FROM SISTE.COMISREP_CAT_REPORTES_COMIS ORDER BY REPORTE_DESCRIPCION";
	public static String SELECT_CAT_REP_BY_ID = "SELECT * FROM SISTE.COMISREP_CAT_REPORTES_COMIS WHERE ID_REPORTE = ? AND ROWNUM = 1";
	public static String INSERT = "INSERT INTO SISTE.<Tabla> (<Columnas>) VALUES (<insert>)";
	public static String DELETE = "DELETE FROM SISTE.<Tabla> WHERE ID_REPORTE = ?";
	public static String INSERT_BITA = "INSERT INTO SISTE.COMISREP_BITACORA(ID_BITACORA,FECHA,ID_REPORTE,NUM_FILAS,OBSERVACIONES,NUM_EMPLEADO,ESTATUS,ID_ARCHIVO)VALUES((SELECT DECODE(MAX(ID_BITACORA),NULL,1,MAX(ID_BITACORA)+1) FROM SISTE.COMISREP_BITACORA),SYSDATE,?,?,?,?,?,?)";
	public static String COUNT_ARCH_TODAY = "SELECT COUNT(*) AS AC FROM SISTE.<Tabla> WHERE TO_CHAR(VERSION,'dd/MM/yyyy') = TO_CHAR(SYSDATE,'dd/MM/yyyy')";
	
	/* (sin Javadoc)
	 * @see iusacell.comisiones.dao.CargaArchivoDAO#obtenerComisrepActivBajaPospago(java.lang.String, java.lang.Integer, java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	public List<String[]> obtenerDatosTablaGen(Integer idReporte, Integer inicio, Integer fin, String colum, String tabla) {

		List<String[]> lista = new ArrayList<String[]>();
		String sql = SELECT_COM_ACT_BAJA_POS;
		sql = sql.replaceAll("<Columnas>",colum).replaceAll("<Tabla>",tabla);
		Object[] param = {idReporte,inicio,fin};
		try {
			List<Map<String, Object>> datos = getJdbcTemplate().queryForList(sql,param);
			for (Map<String, Object> dato : datos) {
				Set<String> keys = dato.keySet();
				String[] resultados = new String [keys.size()-2];
				int i = 0;
				for (String key : keys) {
					if(!key.equals("VERSION") && !key.equals("ID_REPORTE")  ){
						String dat = String.valueOf(dato.get(key)).equals("null")?"":String.valueOf(dato.get(key));
						resultados[i] = dat;
						i++;
					}
				}
				lista.add(resultados);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return lista;
	}
	

	/* (sin Javadoc)
	 * @see iusacell.comisiones.dao.CargaArchivoDAO#countComisrepActivBajaPospago(java.lang.String)
	 */
	public Integer countDatosTablaGen(Integer idReporte, String tabla) {

		Integer datos = new Integer(0);
		String sql = COUNT_COM_ACT_BAJA_POS;
		sql = sql.replaceAll("<Tabla>",tabla);
		Object[] param = {idReporte};
		try {
			datos = (Integer) getJdbcTemplate().queryForObject(sql,param,Integer.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return datos;
	}

	/* (sin Javadoc)
	 * @see iusacell.comisiones.dao.CargaArchivoDAO#obtenerIdArchivosLista(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public List<String[]> obtenerIdArchivosGen(String tabla) {

		List<String[]> lista = new ArrayList<String[]>();
		String sql = ID_ARCHIVOS_COM_ACT_BAJA_POS;
		sql = sql.replaceAll("<Tabla>",tabla);
		try {
			List<Map<String, Object>> datos = getJdbcTemplate().queryForList(sql);
			for (Map<String, Object> dato : datos) {
				String label = String.valueOf(dato.get("ID_REPORTE"));
				String val = String.valueOf(dato.get("PERIODO"));
				String[] resultados = {label,val};
				lista.add(resultados);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return lista;
	}
	
	/* (sin Javadoc)
	 * @see iusacell.comisiones.dao.CargaArchivoDAO#obtenerIdArchivosSig(java.lang.String)
	 */
	public String obtenerIdArchivosSig(String tabla) {

		StringBuffer idA = new StringBuffer();
		String sql = ID_ARCHIVOS_SIG;
		sql = sql.replaceAll("<Tabla>",tabla);
		try {
			idA.append(getJdbcTemplate().queryForObject(sql,String.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return idA.toString();
	}


	/* (sin Javadoc)
	 * @see iusacell.comisiones.dao.CargaArchivoDAO#getCatReporte(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	public ComisrepCatReportesComis getCatReporte(Integer idReportes) {
		ComisrepCatReportesComis cat = null;
		String sql = SELECT_CAT_REP_BY_ID;
		Object[] param = {idReportes};
		try {
			List<Map<String, Object>> datos = getJdbcTemplate().queryForList(sql,param);
			for (Map<String, Object> dato : datos) {
				cat = new ComisrepCatReportesComis();
				cat.setIdReportes(Integer.valueOf(String.valueOf(dato.get("ID_REPORTE"))));
				cat.setReporteDescripcion(String.valueOf(dato.get("REPORTE_DESCRIPCION")));
				cat.setIdCanal(Integer.valueOf(String.valueOf(dato.get("ID_CANAL"))));
				cat.setPeriocidad(Integer.valueOf(String.valueOf(dato.get("ID_PERIODICIDAD"))));
				cat.setColumnas(String.valueOf(dato.get("COLUMNAS")));
				cat.setNumColumnas(Integer.valueOf(String.valueOf(dato.get("NUM_COLUMNAS"))));
				cat.setColumDate(String.valueOf(dato.get("COLUM_DATE")));
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return cat;
	}


	/* (sin Javadoc)
	 * @see iusacell.comisiones.dao.CargaArchivoDAO#getTotCatReportes()
	 */
	@SuppressWarnings("unchecked")
	public List<ComisrepCatReportesComis> getTotCatReportes(String perfil,String numEmpleado,Boolean administrador) {
		List<ComisrepCatReportesComis> lista = null;
		String sql = SELECT_CAT_REP_ADMIN;
		Object[] param = {};
		if(administrador == null || !administrador.booleanValue()){
			sql = SELECT_CAT_REP;
			String ins = "";
			String per[] = perfil.split(",");
			param = new Object[per.length+1];
			for (int i = 0; i < per.length; i++) {
				param[i] = per[i];
				ins += "?";
				if((i+1)<per.length){ins += ",";}
			}
			param[per.length] = numEmpleado;
			sql = sql.replaceAll("\\{param\\}",ins);
		}
		try {
			List<Map<String, Object>> datos = getJdbcTemplate().queryForList(sql,param);
			for (Map<String, Object> dato : datos) {
				ComisrepCatReportesComis cat = new ComisrepCatReportesComis();
				if(lista == null){lista = new ArrayList<ComisrepCatReportesComis>();}
				cat.setIdReportes(Integer.valueOf(String.valueOf(dato.get("ID_REPORTE"))));
				cat.setReporteDescripcion(String.valueOf(dato.get("REPORTE_DESCRIPCION")));
				cat.setIdCanal(Integer.valueOf(String.valueOf(dato.get("ID_CANAL"))));
				cat.setPeriocidad(Integer.valueOf(String.valueOf(dato.get("ID_PERIODICIDAD"))));
				cat.setColumnas(String.valueOf(dato.get("COLUMNAS")));
				cat.setNumColumnas(Integer.valueOf(String.valueOf(dato.get("NUM_COLUMNAS"))));
				cat.setColumDate(String.valueOf(dato.get("COLUM_DATE")));
				lista.add(cat);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}


	/* (sin Javadoc)
	 * @see iusacell.comisiones.dao.CargaArchivoDAO#insertarDato(java.lang.Object[])
	 */
	public String[] insertarDato(String[] dat, ComisrepCatReportesComis cat) {
		String[] res = new String[2];
		try {
			String sql = INSERT;
			sql = sql.replaceAll("<Columnas>",cat.getColumOrd())
					.replaceAll("<Tabla>",cat.getReporteDescripcion())
					.replaceAll("<insert>",cat.getNumInsert());
			Object[] datos = new Object[dat.length+1];
			for (int i = 0; i < dat.length; i++) {
				if(cat.getColumDateHas().contains(""+(i+1))){
					datos[i] = Util.stringToDate(dat[i],"dd/MM/yyyy");
				}else {
					datos[i] = dat[i].trim();
				}
			}
			datos[dat.length] = cat.getIdArchivo();
			getJdbcTemplate().update(sql,datos);
			res[0] = "0";
			res[1] = "Insertada Correctamente";
		} catch (DataAccessException e) {
			res[0] = "-1";
			res[1] = "Ocurrio un error: " + e.getCause().getMessage();
		}
		return res;
	}


	/* (sin Javadoc)
	 * @see iusacell.comisiones.dao.CargaArchivoDAO#deleteArchivosAnteriores(iusacell.comisiones.vo.carga.ComisrepCatReportesComis)
	 */
	public String[] deleteArchivosAnteriores(ComisrepCatReportesComis cat) {
		String[] res = new String[2];
		try {
			String sql = DELETE;
			sql = sql.replaceAll("<Tabla>",cat.getReporteDescripcion());
			Object[] obj = {cat.getIdArchivo()};
			int i = getJdbcTemplate().update(sql,obj);
			res[0] = ""+i;
			res[1] = "Eliminadas correctamente";
		} catch (DataAccessException e) {
			res[0] = "-1";
			res[1] = "Ocurrio un error: " + e.getCause().getMessage();
		}
		return res;
	}


	/* (sin Javadoc)
	 * @see iusacell.comisiones.dao.CargaArchivoDAO#insertarBitacora(iusacell.comisiones.vo.ComisrepBitacora)
	 */
	public String[] insertarBitacora(ComisrepBitacoraVO bitacora) {
		String[] res = new String[2];
		try {
			String sql = INSERT_BITA;
			Object[] obj = {bitacora.getIdReporte(),
							bitacora.getNumFilas(),
							bitacora.getObservaciones(),
							bitacora.getNumEmpleado(),
							bitacora.getStatus(),
							bitacora.getIdArchivo()};
			int i = getJdbcTemplate().update(sql,obj);
			res[0] = ""+i;
			res[1] = "Insertada correctamente";
		} catch (DataAccessException e) {
			res[0] = "-1";
			res[1] = "Ocurrio un error: " + e.getCause().getMessage();
		}
		return res;
	}


	/* (sin Javadoc)
	 * @see iusacell.comisiones.dao.CargaArchivoDAO#validarArchivosAnteriores(iusacell.comisiones.vo.carga.ComisrepCatReportesComis)
	 */
	public String[] validarArchivosAnteriores(ComisrepCatReportesComis cat) {
		String[] res = new String[2];
		Integer idA = new Integer(0);
		String sql = COUNT_ARCH_TODAY;
		sql = sql.replaceAll("<Tabla>",cat.getReporteDescripcion());
		try {
			idA = (Integer) getJdbcTemplate().queryForObject(sql,Integer.class);
			res[0] = ""+idA;
			res[1] = "Count ejecutado correctamente";
		} catch (Exception e) {
			res[0] = "-1";
			res[1] = "Ocurrio un error: " + e.getCause().getMessage();
		}
			
		return res;
	}


}
