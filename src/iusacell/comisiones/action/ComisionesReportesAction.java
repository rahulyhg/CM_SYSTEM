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
		for(int i=0;i<10;i++){
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
		
		/*This code charge the running period for weeks from a query loaded
		 * from the database not used anymore 
		 */
		/*List<PcTotalesSem> lista = comisionesReportesBO.obtenerPeriodo(comForm.getAnio());
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
				elementoJSON = Util.obtenerObjetoJSON(lstResp);
				response.setContentType("text/json; charset=UTF-8");
			}
			
		}*/
		
		
		/*This code charge the running period for weeks 
		 *  according to the year using the java.util.Calendar and load the 
		 *  info in a JSON object
		 */
		List<GenericoComboJsonVO> lstResp= new ArrayList<GenericoComboJsonVO>();
		String elementoJSON = "{}";
		GenericoComboJsonVO vo= null; 
		
		
		int selectedYear = new Integer(comForm.getAnio());
		int runningYear = Calendar.getInstance().get(Calendar.YEAR);
		Calendar calendar = Calendar.getInstance();
        
		//Current year
		if(selectedYear == runningYear)
		{	
			
			int runningWeek = calendar.get(Calendar.WEEK_OF_YEAR);
			for(int week=1; week<runningWeek;week++){
				vo= new GenericoComboJsonVO();
				calendar.set(Calendar.WEEK_OF_YEAR, week);
				int month = calendar.get(Calendar.MONTH)+1;
				vo.setValor(week+","+selectedYear+month);
				vo.setDescripcion("Semana "+week);
				lstResp.add(vo);
			}
		}
		//Past years
		else
		{
			final int STARTING_WEEK = 1;
			
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, selectedYear);
			cal.set(Calendar.MONTH, Calendar.DECEMBER);
			cal.set(Calendar.DAY_OF_MONTH, 31);
            int ordinalDay = cal.get(Calendar.DAY_OF_YEAR);
			int weekDay = cal.get(Calendar.DAY_OF_WEEK) - 1; // Sunday = 0
			int numberOfWeeks = (ordinalDay - weekDay + 10) / 7;
			final int TOTAL_WEEKS_IN_A_YEAR =numberOfWeeks ;
			
			calendar.set(Calendar.YEAR,selectedYear);
			
			for(int week=STARTING_WEEK; week<=TOTAL_WEEKS_IN_A_YEAR;week++){
				vo= new GenericoComboJsonVO();
				calendar.set(Calendar.WEEK_OF_YEAR,week);
				int month = calendar.get(Calendar.MONTH)+1;
				vo.setValor(week+","+selectedYear+month);
				vo.setDescripcion("Semana "+week);
				lstResp.add(vo);
			}
			
		}
					
		elementoJSON = Util.obtenerObjetoJSON(lstResp);
		
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
		
		/*This code charge the running period for months from a query loaded
		 * from the database not used anymore 
		 */
		//List<PcTotalesSem> lista = comisionesReportesBO.obtenerPeridoMes(comForm.getAnio());
		/*if(lista!=null && lista.size()>0 ){
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
		}*/
		
		
		/*This code charge the months
		 *  according to the year using the java.util.Calendar and load the 
		 *  info in a JSON object
		 */
		int selectedYear = new Integer(comForm.getAnio());
		int runningYear = Calendar.getInstance().get(Calendar.YEAR);
		Calendar calendar = Calendar.getInstance();
		
		List<GenericoComboJsonVO> lstResp= new ArrayList<GenericoComboJsonVO>();
		String elementoJSON = "{}";
		GenericoComboJsonVO vo= null; 

		if(selectedYear == runningYear)
		{	
			
			int runningMonth = calendar.get(Calendar.MONTH);
			for(int month=0; month<runningMonth;month++){
				vo= new GenericoComboJsonVO();
				calendar.set(Calendar.MONTH, month);
				int monthToLoad = calendar.get(Calendar.MONTH)+1;
				if(monthToLoad<10)
				{	
					vo.setValor(selectedYear+","+selectedYear+"0"+monthToLoad);
					vo.setDescripcion("Mes "+"0"+monthToLoad);
				}
				else
				{	
					vo.setValor(selectedYear+","+selectedYear+monthToLoad);
					vo.setDescripcion("Mes "+monthToLoad);
				}	
				lstResp.add(vo);
			}
		}
		else
		{
			final int STARTING_MONTH = 0;
			
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, selectedYear);
			cal.set(Calendar.MONTH, Calendar.DECEMBER);
						
			final int TOTAL_MONTHS =12;
			
			calendar.set(Calendar.YEAR,selectedYear);
			
			for(int month=STARTING_MONTH; month<TOTAL_MONTHS;month++){
				vo= new GenericoComboJsonVO();
				calendar.set(Calendar.MONTH,month);
				int monthToLoad = calendar.get(Calendar.MONTH)+1;
				if(monthToLoad<10)
				{	
					vo.setValor(selectedYear+","+selectedYear+"0"+monthToLoad);
					vo.setDescripcion("Mes "+"0"+monthToLoad);
				}
				else
				{	
					vo.setValor(selectedYear+","+selectedYear+monthToLoad);
					vo.setDescripcion("Mes "+monthToLoad);
				}	
				
				lstResp.add(vo);
			}
			
		}
		elementoJSON = Util.obtenerObjetoJSON(lstResp);
		
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