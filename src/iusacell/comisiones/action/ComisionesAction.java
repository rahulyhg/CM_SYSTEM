/*
 * Creado el 21/11/2014
 *
 * Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package iusacell.comisiones.action;

import iusacell.comisiones.ayuda.UserBean;
import iusacell.comisiones.bo.ComisionesBO;
import iusacell.comisiones.form.ComisionesForm;
import iusacell.comisiones.vo.GenericoComboJsonVO;
import iusacell.comisiones.vo.PcTotalesSem;
import iusacell.comisiones.vo.TablaComisionesAgregarVO;
import iusacell.comisiones.vo.TablaComisionesExcelVO;
import iusacell.comisiones.vo.TablaComisionesVO;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.iusacell.comisiones.utilerias.Util;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

/**
 * @author jarredondoi
 *
 * Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
public class ComisionesAction extends ActionSupport{
	
	private static final long serialVersionUID = 1251703759394074901L;

	private ComisionesBO comisionesBO;
	
	/**
	 * formato yyyyMMdd
	 * 0 -> fecha inicio de la semana
	 * 1 -> fecha fin de semana 
	 * 2 -> fecha inicio del mes
	 * 3 -> fecha fin del mes
	 * 4 -> dia fin del mes
	 * 5 -> fecha fin de semana dd/MM/yyyy
	 * 6 -> semana
	 * @return
	 */
	private String[] fechas;
	
	/* (sin Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		UserBean usuarioBean = (UserBean) request.getSession().getAttribute("usuarioSession");
		
		comisionesBO = (ComisionesBO) getWebApplicationContext().getBean("comisionesBO");
		
		if(usuarioBean == null){
			return mapping.findForward("welcome"); 
		}
		
		String action = request.getParameter("go");
		
		System.out.println("accion="+action);
		
		ComisionesForm comForm = (ComisionesForm) form;
		
		if(comForm.getAms()!=null && !comForm.getAms().equals("")){
			String[] aMs = comForm.getAms().split(",");
			fechas = Util.obtenerFechasInicioFin(aMs[0],aMs[1],aMs[2]);
		}else{
			fechas = Util.obtenerFechasInicioFin(null,null,null);
		}
		
		if(action.equals("inicio")){
			return inicio(mapping, form, request, response, comForm);
		}else if(action.equals("anio")){
			return cargarAnio(mapping, form, request, response, comForm);
		}else if(action.equals("periodo")){
			return cargarPeriodo(mapping, form, request, response, comForm);
		}else if(action.equals("buscar")){
			return tabla(mapping, form, request, response, comForm);
		}else if(action.equals("buscarExportar")){
			return buscarReporte(mapping, form, request, response, comForm);
		}else if(action.equals("publicar")){
			return publicar(mapping, form, request, response, comForm);
		}else if(action.equals("exportar")){
			return generarReporte(mapping, form, request, response, comForm);
		}else if(action.equals("agregarComisiones")){
			return agregarComisiones(mapping, form, request, response, comForm);
		}else if(action.equals("mostrarDetalle")){
			return mostrarDetalle(mapping, form, request, response, comForm);
		}else if(action.equals("eliminarContratosDetalle")){
			return eliminarContratosDetalle(mapping, form, request, response, comForm);
		}else if(action.equals("reprocesarDetalle")){
			return reprocesarDetalle(mapping, form, request, response, comForm);
		}else if(action.equals("buscarAgregarDetalle")){
			return buscarAgregarDetalle(mapping, form, request, response, comForm);
		}else if(action.equals("agregarContratoDetalle")){
			return agregarContratoDetalle(mapping, form, request, response, comForm);
		}
		
		return mapping.findForward("inicio"); 
	}
	
	private ActionForward inicio(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, ComisionesForm comForm) {
		
		comForm.setSemana(fechas[7]);
		request.setAttribute("semana",fechas[7]);
		
		return mapping.findForward("inicio"); 
	
	}
	
	private ActionForward cargarAnio(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, ComisionesForm comForm) {
		
		
		//String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
		
		int anio = Calendar.getInstance().get(Calendar.YEAR); 
		List<GenericoComboJsonVO> lstResp= new ArrayList<GenericoComboJsonVO>();
		GenericoComboJsonVO vo = new GenericoComboJsonVO();
		vo.setValor(String.valueOf(anio+1));
		vo.setDescripcion(String.valueOf(anio+1));
		lstResp.add(vo);
		for(int i=0;i<4;i++){
			vo = new GenericoComboJsonVO();
			vo.setValor(String.valueOf(anio));
			vo.setDescripcion(String.valueOf(anio));
			lstResp.add(vo);
			anio--;
		}
		response.setContentType("text/json; charset=UTF-8");
		String elementoJSON = Util.obtenerObjetoJSON(lstResp);
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.write(elementoJSON);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			System.out.println("Error al escribir el JSON");
			e.printStackTrace();
		}

		return null;
	
	}
	
	private ActionForward cargarPeriodo(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, ComisionesForm comForm) {
		
		if(comForm.getAnio()== null || comForm.getAnio().equals("")){
			comForm.setAnio(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		}
		List<PcTotalesSem> lista = comisionesBO.obtenerPeriodo(comForm.getAnio());
		
		String elementoJSON = "{}";
		
		if(lista!=null && lista.size()>0 ){
			List<GenericoComboJsonVO> lstResp= new ArrayList<GenericoComboJsonVO>();
			GenericoComboJsonVO vo= null; 
			for(int i=0;i<lista.size();i++){
				PcTotalesSem sem = (PcTotalesSem)lista.get(i);
				vo= new GenericoComboJsonVO();
				vo.setValor(sem.getPcSem()+","+sem.getPcMes());
				vo.setDescripcion("Semana "+sem.getPcSem());
				lstResp.add(vo);	
			}
			elementoJSON = Util.obtenerObjetoJSON(lstResp);
		}
		
		response.setContentType("text/json; charset=UTF-8");
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.write(elementoJSON);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			System.out.println("Error al escribir el JSON");
			e.printStackTrace();
		}
		
		return null; 
	
	}
	
	private ActionForward tabla(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, ComisionesForm comForm) {
		
		
		String semMes = comForm.getPeriodo();
		int coma = semMes.lastIndexOf(",");
		String mes = semMes.substring(coma+1);
		String periodo = semMes.substring(0,coma);
		
		Integer semana = comisionesBO.obtenerSemanaActual();
		String sem = "";
		if(!Integer.valueOf(periodo).equals(new Integer(semana.intValue()-1))){
			sem = "-1";
		}
		
		List<TablaComisionesVO> lista = comisionesBO.obtenerConsolidadoTabla(comForm.getAnio(),periodo,mes);
		
		if(lista!=null && lista.size()>0 ){
			response.setContentType("text/json; charset=UTF-8");
			String elementoJSON = Util.obtenerObjetoJSONTabla(lista,sem);
			PrintWriter pw;
			try {
				pw = response.getWriter();
				pw.write(elementoJSON);
				pw.flush();
				pw.close();
			} catch (IOException e) {
				System.out.println("Error al escribir el JSON");
				e.printStackTrace();
			}
		}
		return null; 
	
	}
	
	private ActionForward publicar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, ComisionesForm comForm) {
		
		
		String semMes = comForm.getPeriodo();
		String select = request.getParameter("seleccionados");
		String[] seleccionados =  select.split(",");//stringToArray(select,",");
		int coma = semMes.lastIndexOf(",");
		String mes = semMes.substring(coma+1);
		String periodo = semMes.substring(0,coma);
		
		if(periodo.equals(fechas[7])){
			for (int i = 0; i < seleccionados.length; i++) {
				@SuppressWarnings("unused")
				String res = comisionesBO.publicar(seleccionados[i],comForm.getAnio(),periodo,mes);
			}
		}
		
		String clave = "1";
		String desc = "";
		
		List<TablaComisionesVO> lista = comisionesBO.obtenerConsolidadoTabla(comForm.getAnio(),periodo,mes);
		
		if(lista==null || lista.size()==0 ){
			clave = "-1";
		}
		
		String elementoJSON = "{\"tabla\":[{\"clave\":\""+clave+"\",\"mensaje\":\""+desc+"\"}]}";
		
		response.setContentType("text/json; charset=UTF-8");
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.write(elementoJSON);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			System.out.println("Error al escribir el JSON");
			e.printStackTrace();
		}
		
		return null; 
	
	}
	
	private ActionForward buscarReporte(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, ComisionesForm comForm){
		
//		Buscar Reporte
		response.setContentType("application/xls");
		response.setHeader("Cache-Control", "cache");
		response.setHeader("Content-Disposition", "attachment; filename=Reporte.xls");
		response.setHeader("Pragma", "cache");
//      OutputStream out = null;
        
		
		String semMes = comForm.getPeriodo();
		int coma = semMes.lastIndexOf(",");
		String mes = semMes.substring(coma+1);
		String periodo = semMes.substring(0,coma);
		
		
		List<TablaComisionesExcelVO> lista = comisionesBO.obtenerTablaExcel(comForm.getAnio(),periodo,mes);
		
		int tam = lista== null ? 0 : lista.size();
		
		String elementoJSON = "{\"tabla\":\""+tam+"\"}";
		
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.write(elementoJSON);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			System.out.println("Error al escribir el JSON");
			e.printStackTrace();
		}
		
		return null; 
	}
	
	private ActionForward generarReporte(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, ComisionesForm comForm) {
		
//		Generar Reporte
		response.setContentType("application/xls");
		response.setHeader("Cache-Control", "cache");
		response.setHeader("Content-Disposition", "attachment; filename=Reporte.xls");
		response.setHeader("Pragma", "cache");
        OutputStream out = null;
        
		
		String semMes = comForm.getPeriodo();
		int coma = semMes.lastIndexOf(",");
		String mes = semMes.substring(coma+1);
		String periodo = semMes.substring(0,coma);
		
		
		List<TablaComisionesExcelVO> lista = comisionesBO.obtenerTablaExcel(comForm.getAnio(),periodo,mes);
		BufferedOutputStream outputStream = null;
        try{
        	out = response.getOutputStream();
        	outputStream = new BufferedOutputStream(out);
        	comisionesBO.generarReporte(outputStream,lista);
        }catch(Exception exc){
        	System.out.println("ERROR GENERA EXCELL: "+exc.getMessage());
        }finally{
        	try {
        		if (outputStream != null) outputStream.flush();
                if (outputStream != null) outputStream.close();
      
                if (out != null ) out.close();
                if (outputStream != null ) outputStream.close();
			} catch (Exception e) {
				System.out.println("ERROR GENERA EXCELL:"+e.getMessage());
			}
        }
		
        return mapping.findForward("inicio"); 
	}
	
	private ActionForward agregarComisiones(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, ComisionesForm comForm) {
		
		
		String semMes = comForm.getPeriodo();
//		String con = request.getParameter("contrato");
		String fecha = request.getParameter("fecha");
		String fechaFin = request.getParameter("fechaFin");
		int coma = semMes.lastIndexOf(",");
		String mes = semMes.substring(coma+1);
		String periodo = semMes.substring(0,coma);
		
		if(periodo.equals(fechas[7])){
//			String[] contrato = con.split(",");//stringToArray(con,",");
			
			String select = request.getParameter("seleccionados");
			String[] contratos = select.split(",");//stringToArray(select,",");
			
			for (int i = 0; i < contratos.length; i++) {
				@SuppressWarnings("unused")
				String res = comisionesBO.agregarComisiones(contratos[i],comForm.getAnio(),periodo,mes,fecha,fechaFin);
			}
		}
		String clave = "1";
		String desc = "";
		
		String elementoJSON = "{\"tabla\":[{\"clave\":\""+clave+"\",\"mensaje\":\""+desc+"\"}]}";
		
		List<TablaComisionesVO> lista = comisionesBO.obtenerConsolidadoTabla(comForm.getAnio(),periodo,mes);
		
		if(lista!=null && lista.size()>0 ){
			response.setContentType("text/json; charset=UTF-8");
			PrintWriter pw;
			try {
				pw = response.getWriter();
				pw.write(elementoJSON);
				pw.flush();
				pw.close();
			} catch (IOException e) {
				System.out.println("Error al escribir el JSON");
				e.printStackTrace();
			}
		}
		
		
		return mapping.findForward("inicio"); 
	
	}
	
	/**
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	private ActionForward mostrarDetalle(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, ComisionesForm comForm) {
		
		
		String semMes = comForm.getPeriodo();
		int coma = semMes.lastIndexOf(",");
		String periodo = semMes.substring(coma+1);
		String semana = semMes.substring(0,coma);
		String estatus = "0";
		List<TablaComisionesExcelVO> lista = comisionesBO.obtenerTablaExcel(comForm.getAnio(),semana,periodo);
		List<TablaComisionesVO> listaPeriodo= comisionesBO.obtenerConsolidadoTabla(comForm.getAnio(),semana,periodo);
		for (TablaComisionesVO tab : listaPeriodo) {
			if(tab.getStatus().equals("3")){
				estatus = "1";
			}
		}
		request.setAttribute("publicado",estatus);
		request.setAttribute("anioD",comForm.getAnio());
		request.setAttribute("semana",fechas[7]);
		request.setAttribute("periodoD",semMes);
		
		request.setAttribute("mesD",periodo);
		request.setAttribute("semanaD",semana);
		request.setAttribute("listaDetalle",lista);
		return mapping.findForward("detalle"); 
	
	}
	/**
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	private ActionForward eliminarContratosDetalle(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, ComisionesForm comForm) {

		String anio = comForm.getAnioD();
		String semMes = comForm.getPeriodoD();
		String seleccionados = comForm.getSeleccionadosD();
		String[] contratos = seleccionados.split(",");
		int coma = semMes.lastIndexOf(",");
		String periodo = semMes.substring(coma+1);
		String semana = semMes.substring(0,coma);
		String estatus = "0";
		if(semana.equals(fechas[7])){
			comisionesBO.eliminarContratosDetalle(anio,periodo,semana,contratos);
		}
		
		List<TablaComisionesExcelVO> lista = comisionesBO.obtenerTablaExcel(anio,semana,periodo);
		List<TablaComisionesVO> listaPeriodo= comisionesBO.obtenerConsolidadoTabla(anio,semana,periodo);
		for (TablaComisionesVO tab : listaPeriodo) {
			if(tab.getStatus().equals("3")){
				estatus = "1";
			}
		}
		request.setAttribute("publicado",estatus);
		request.setAttribute("anioD",anio);
		request.setAttribute("semana",fechas[7]);
		request.setAttribute("periodoD",semMes);
		request.setAttribute("semanaD",semana);
		request.setAttribute("mesD",periodo);
		request.setAttribute("listaDetalle",lista);
		return mapping.findForward("detalle");  
	
	}
	
	/**
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	private ActionForward reprocesarDetalle(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, ComisionesForm comForm) {
		String anio = comForm.getAnioD();
		String semMes = comForm.getPeriodoD();
		int coma = semMes.lastIndexOf(",");
		String periodo = semMes.substring(coma+1);
		String semana = semMes.substring(0,coma);
		String estatus = "";
		if(semana.equals(fechas[7])){
			comisionesBO.reprocesarContratosDetalle(fechas);
		}
		List<TablaComisionesExcelVO> lista = comisionesBO.obtenerTablaExcel(anio,semana,periodo);
		List<TablaComisionesVO> listaPeriodo= comisionesBO.obtenerConsolidadoTabla(anio,semana,periodo);
		for (TablaComisionesVO tab : listaPeriodo) {
			if(tab.getStatus().equals("3")){
				estatus = "1";
			}
		}
		request.setAttribute("publicado",estatus);
		request.setAttribute("anioD",anio);
		request.setAttribute("semana",fechas[7]);
		request.setAttribute("periodoD",semMes);
		request.setAttribute("semanaD",semana);
		request.setAttribute("mesD",periodo);
		request.setAttribute("listaDetalle",lista);
		return mapping.findForward("detalle"); 
	
	}
	
	/**
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	private ActionForward buscarAgregarDetalle(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, ComisionesForm comForm) {
		String semMes = comForm.getPeriodo();
		int coma = semMes.lastIndexOf(",");
		String periodo = semMes.substring(coma+1);
		String semana = semMes.substring(0,coma);
		String status = "1";
		
		List<TablaComisionesAgregarVO> lista = comisionesBO.obtenerValidarAgregarTablaDetalle(comForm.getContrato(),comForm.getAnio(),periodo,semana,fechas);
		if(lista== null || lista.size() == 0){
			lista = comisionesBO.obtenerAgregarTablaDetalle(comForm.getContrato(),comForm.getAnio(),periodo,semana);
			if(lista== null || lista.size() == 0){
				status = "3";//No se encontro el contrato
			}
		}else{
			status = "2";//Se encuentra en validacion previa 
		}
		String elementoJSON = "{\"okCode\":\""+status+"\"}";
		if(lista!=null && lista.size()>0 ){
			response.setContentType("text/json; charset=UTF-8");
			elementoJSON = Util.obtenerObjetoJSONTablaAgregar(lista,status);
		}
		
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.write(elementoJSON);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			System.out.println("Error al escribir el JSON");
			e.printStackTrace();
		}
		
		return null; 
	
	}
	
	/**
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	private ActionForward agregarContratoDetalle(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, ComisionesForm comForm) {
		String anio = comForm.getAnioD();
		String semMes = comForm.getPeriodoD();
		int coma = semMes.lastIndexOf(",");
		String periodo = semMes.substring(coma+1);
		String semana = semMes.substring(0,coma);
		String estatus = "0";
		
		if(semana.equals(fechas[7])){
			List<TablaComisionesAgregarVO> listaAgregar = comisionesBO.obtenerValidarAgregarTablaDetalle(comForm.getContrato(),anio,periodo,semana,fechas);
			if(listaAgregar== null || listaAgregar.size() == 0){
				listaAgregar = comisionesBO.obtenerAgregarTablaDetalle(comForm.getContrato(),anio,periodo,semana);
				if(listaAgregar!= null && listaAgregar.size() > 0){
					TablaComisionesAgregarVO agregarVO = (TablaComisionesAgregarVO) listaAgregar.get(0);
					comisionesBO.agregarContratoDetalle(anio,periodo,semana,agregarVO,fechas);
				}else{
					estatus = "3";//No se encontro el contrato
				}
			}else{
				estatus = "2";//Se encuentra en validacion previa 
			}
		}
		List<TablaComisionesExcelVO> lista = comisionesBO.obtenerTablaExcel(anio,semana,periodo);
		List<TablaComisionesVO> listaPeriodo= comisionesBO.obtenerConsolidadoTabla(anio,semana,periodo);
		for (TablaComisionesVO tab : listaPeriodo) {
			if(tab.getStatus().equals("3")){
				estatus = "1";
			}
		}
		request.setAttribute("publicado",estatus);
		request.setAttribute("anioD",anio);
		request.setAttribute("semana",fechas[7]);
		request.setAttribute("periodoD",semMes);
		request.setAttribute("semanaD",semana);
		request.setAttribute("mesD",periodo);
		request.setAttribute("listaDetalle",lista);
		
		return mapping.findForward("detalle"); 
	
	}
	
//	public static String[] stringToArray(String a, String delimeter) {
//		String c[] = new String[0];
//		String b = a;
//		while (true) {
//			int i = b.indexOf(delimeter);
//			String d = b;
//			if (i >= 0) {
//				d = b.substring(0, i);
//			}
//			String e[] = new String[c.length + 1];
//			for (int k = 0; k < c.length; k++) {
//				e[k] = c[k];
//			}
//			e[e.length - 1] = d;
//			c = e;
//			b = b.substring(i + delimeter.length(), b.length());
//			if (b.length() <= 0 || i < 0) {
//				break;
//			}
//		}
//		return c;
//	}

	/**
	 * @return Devuelve comisionesBO.
	 */
	public ComisionesBO getComisionesBO() {
		return comisionesBO;
	}
	/**
	 * @param comisionesBO El comisionesBO a establecer.
	 */
	public void setComisionesBO(ComisionesBO comisionesBO) {
		this.comisionesBO = comisionesBO;
	}
	
	public String[] getFechas() {
		return fechas;
	}
	public void setFechas(String[] fechas) {
		this.fechas = fechas;
	}
}
