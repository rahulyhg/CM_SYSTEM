/*
 * Creado el 21/11/2014
 *
 * Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package iusacell.comisiones.action;

import iusacell.comisiones.ayuda.UserBean;
import iusacell.comisiones.bo.ComisionesReportesBO;
import iusacell.comisiones.form.ComisionesReportesForm;
import iusacell.comisiones.vo.GenericoComboJsonVO;
import iusacell.comisiones.vo.PcTotalesSem;

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
public class ComisionesReportesAction extends ActionSupport{
	
	private static final long serialVersionUID = 1251703759394074901L;
	
	private ComisionesReportesBO comisionesReportesBO;
	
	private String semana;
	
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
		
		if(usuarioBean == null){
			return mapping.findForward("welcome"); 
		}
		
		comisionesReportesBO = (ComisionesReportesBO) getWebApplicationContext().getBean("comisionesReportesBO");
		
		String action = request.getParameter("go");
		
		ComisionesReportesForm comForm = (ComisionesReportesForm) form;
		
		System.out.println("accion="+action);
		
		fechas = Util.obtenerFechasInicioFin(null,null,null);
		
		if(action.equals("inicio")){
			return inicio(mapping, form, request, response, comForm);
		}else if(action.equals("anio")){
			return cargarAnio(mapping, form, request, response, comForm);
		}else if(action.equals("periodo")){
			return cargarPeriodo(mapping, form, request, response, comForm);
		}else if(action.equals("mes")){
			return cargarMes(mapping, form, request, response, comForm);
		}else if(action.equals("buscarExportar")){
			return buscarReporte(mapping, form, request, response, comForm);
		}else if(action.equals("exportar")){
			return generarReporte(mapping, form, request, response, comForm);
		}
		
		return mapping.findForward("inicio"); 
	}
	
	private ActionForward inicio(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response, ComisionesReportesForm comForm) {
		
		setSemana(fechas[7]);
		
		request.setAttribute("semana",semana);
		
		return mapping.findForward("inicio"); 
	
	}
	
	private ActionForward cargarAnio(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response, ComisionesReportesForm comForm) {
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

		return mapping.findForward("success");
	
	}
	
	private ActionForward cargarPeriodo(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response, ComisionesReportesForm comForm) {
		
		if(comForm.getAnio()== null || comForm.getAnio().equals("")){
			comForm.setAnio(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		}
		
		List<PcTotalesSem> lista = comisionesReportesBO.obtenerPeriodo(comForm.getAnio());
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
		
		return mapping.findForward("success"); 
	}
	
	private ActionForward cargarMes(ActionMapping mapping, ActionForm form, 
		HttpServletRequest request, HttpServletResponse response, ComisionesReportesForm comForm) {
		
		if(comForm.getAnio()== null || comForm.getAnio().equals("")){
			comForm.setAnio(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		}
		
		List<PcTotalesSem> lista = comisionesReportesBO.obtenerPeridoMes(comForm.getAnio());
		String elementoJSON = "{}";
		if(lista!=null && lista.size()>0 ){
			List<GenericoComboJsonVO> lstResp= new ArrayList<GenericoComboJsonVO>();
			GenericoComboJsonVO vo= null; 
			for(int i=0;i<lista.size();i++){
				PcTotalesSem sem = (PcTotalesSem)lista.get(i);
				vo= new GenericoComboJsonVO();
				vo.setValor(sem.getPcSem()+","+sem.getPcMes());
				vo.setDescripcion("Mes "+sem.getPcSem());
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
		return mapping.findForward("success"); 
	}
	
	@SuppressWarnings("unchecked")
	private ActionForward buscarReporte(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response, ComisionesReportesForm comForm){
		
//		Buscar Reporte
		response.setContentType("application/xls");
		response.setHeader("Cache-Control", "cache");
		response.setHeader("Content-Disposition", "attachment; filename=Reporte.xls");
		response.setHeader("Pragma", "cache");
		
		List lista = null;
		if(comForm.getMesSemana()==null || comForm.getMesSemana().equals("0")){
			int coma = comForm.getMesPeriodo().lastIndexOf(",");
			String mes  = comForm.getMesPeriodo().substring(coma+5);
			String periodo = comForm.getMesPeriodo().substring(coma+1);
			String[] dias = Util.obtenerFechasInicioFin(comForm.getAnio(),mes,null);
			lista = comisionesReportesBO.obtenerReporteMensual(Integer.valueOf(comForm.getTipoMes()), periodo, dias[2], dias[3]);
		}else{
			String semMes = comForm.getPeriodo();
			int coma = semMes.lastIndexOf(",");
			String mes = semMes.substring(coma+5);
			String semana = semMes.substring(0,coma);
			String[] dias = Util.obtenerFechasInicioFin(comForm.getAnio(),mes,semana);
			lista = comisionesReportesBO.obtenerReporteSemanal(Integer.valueOf(comForm.getTipoSemana()), dias[0], dias[1]);
		}
		
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
		
		return mapping.findForward("success"); 
	}
	
	@SuppressWarnings("unchecked")
	private ActionForward generarReporte(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response, ComisionesReportesForm comForm) {
		
//		Generar Reporte
		response.setContentType("application/xls");
		response.setHeader("Cache-Control", "cache");
		response.setHeader("Content-Disposition", "attachment; filename=Reporte.xls");
		response.setHeader("Pragma", "cache");
        OutputStream out = null;
        
        List lista = null;
		if(comForm.getMesSemana()==null || comForm.getMesSemana().equals("0")){
			int coma = comForm.getMesPeriodo().lastIndexOf(",");
			String mes  = comForm.getMesPeriodo().substring(coma+5);
			String periodo = comForm.getMesPeriodo().substring(coma+1);
			String[] dias = Util.obtenerFechasInicioFin(comForm.getAnio(),mes,null);
			lista = comisionesReportesBO.obtenerReporteMensual(Integer.valueOf(comForm.getTipoMes()), periodo, dias[2], dias[3]);
		}else{
			String semMes = comForm.getPeriodo();
			int coma = semMes.lastIndexOf(",");
			String mes = semMes.substring(coma+5);
			String semana = semMes.substring(0,coma);
			String[] dias = Util.obtenerFechasInicioFin(comForm.getAnio(),mes,semana);
			lista = comisionesReportesBO.obtenerReporteSemanal(Integer.valueOf(comForm.getTipoSemana()), dias[0], dias[1]);
		}
		BufferedOutputStream outputStream = null;
        try{
        	out = response.getOutputStream();
        	outputStream = new BufferedOutputStream(out);
        	comisionesReportesBO.generarReporte(outputStream,lista);
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
	
	public String[] getFechas() {
		return fechas;
	}
	public void setFechas(String[] fechas) {
		this.fechas = fechas;
	}

	public ComisionesReportesBO getComisionesReportesBO() {
		return comisionesReportesBO;
	}

	public void setComisionesReportesBO(ComisionesReportesBO comisionesReportesBO) {
		this.comisionesReportesBO = comisionesReportesBO;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public void setSemana(String semana) {
		this.semana = semana;
	}

	public String getSemana() {
		return semana;
	}
}