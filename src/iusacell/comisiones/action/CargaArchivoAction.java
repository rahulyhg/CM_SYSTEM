/*
 * Creado el 24/02/2015
 *
 * Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package iusacell.comisiones.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import iusacell.comisiones.ayuda.UserBean;
import iusacell.comisiones.bo.CargaArchivoBO;
import iusacell.comisiones.form.CargaArchivoForm;
import iusacell.comisiones.vo.GenericoComboJsonVO;
import iusacell.comisiones.vo.carga.ComisrepCatReportesComis;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import mx.com.iusacell.comisiones.utilerias.Util;

/**
 * @author jarredondoi
 *
 * Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
public class CargaArchivoAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1726170337080345195L;
	
	CargaArchivoBO cargaArchivoBO;
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	/* (sin Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		UserBean usuarioBean = (UserBean) request.getSession().getAttribute("usuarioSession");
		
		if(usuarioBean == null){
			return mapping.findForward("welcome"); 
		}
		
		String action = request.getParameter("go");
		
		System.out.println("accion="+action);
		
		cargaArchivoBO = (CargaArchivoBO) getWebApplicationContext().getBean("cargaArchivoBO");
		
		if(action.equals("carga")){
			return carga(mapping, form, request, response);
		}else if(action.equals("consulta")){
			return consulta(mapping, form, request, response);
		}else if(action.equals("cargarTxt")||action.equals("cargarExcel")){
			return cargarArchivo(mapping, form, request, response,usuarioBean);
		}else if(action.equals("buscaArchivo")){
			return consultArchivo(mapping, form, request, response);
		}else if(action.equals("buscaIdArchivo")){
			return buscaIdArchivo(mapping, form, request, response);
		}else if(action.equals("buscarTiposArchivo")){
			return buscarTiposArchivo(mapping, form, request, response);
		}else if(action.equals("actualizarArchivo")){
			return actualizarArchivo(mapping, form, request, response);
		}else if(action.equals("eliminarArchivo")){
			return eliminarArchivo(mapping, form, request, response,usuarioBean);
		}else if(action.equals("validarCargado")){
			return validarCargado(mapping, form, request, response);
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
	private ActionForward consulta(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		return mapping.findForward("inicio");
	}

	/**
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	private ActionForward carga(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		return mapping.findForward("inicio");
	}
	
	/**
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	private ActionForward actualizarArchivo(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		CargaArchivoForm archivoForm = (CargaArchivoForm) form;
		request.setAttribute("idTipoArchivo",archivoForm.getIdTipoArchivo());
		request.setAttribute("idArchivo",String.valueOf(archivoForm.getIdArchivo()));
		request.setAttribute("descTipoArchivo",archivoForm.getDescTipoArchivo());
		request.setAttribute("descArchivo",archivoForm.getDescArchivo());
		return mapping.findForward("actualizar");
	}
	
	/**
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	private ActionForward buscarTiposArchivo(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		
		UserBean usuarioBean = (UserBean) request.getSession().getAttribute("usuarioSession");
		CargaArchivoForm archivoForm = (CargaArchivoForm) form;
		String numEmpleado = usuarioBean.getNumEmpleado();
		numEmpleado = numEmpleado.length()>6?numEmpleado.substring(2):numEmpleado;
		
		Boolean administrador = (Boolean) request.getSession().getAttribute("isAdministrador");
		
		List<ComisrepCatReportesComis> lista = cargaArchivoBO.getTotCatReportes(archivoForm.getPerfil(),numEmpleado,administrador);
		
		if(lista!=null && lista.size()>0 ){
			List<GenericoComboJsonVO> lstResp= new ArrayList<GenericoComboJsonVO>();
			GenericoComboJsonVO vo= null; 
			for (ComisrepCatReportesComis cat : lista) {
				vo= new GenericoComboJsonVO();
				vo.setValor(String.valueOf(cat.getIdReportes()));
				vo.setDescripcion(cat.getReporteDescripcion());
				lstResp.add(vo);
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
		}
		
		return null;
	}
	
	/**
	 * @param usuarioBean 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	private ActionForward cargarArchivo(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, UserBean usuarioBean) {
		
		String res = "";
		CargaArchivoForm archivoForm = (CargaArchivoForm) form;
		
		res+="<cveRespuesta>1</cveRespuesta>";
		if(archivoForm.getGo().equals("cargarTxt")){
			res += cargaArchivoBO.cargaArchivoTxt(archivoForm.getArchivo(),archivoForm.getIdTipoArchivo(),
					archivoForm.getPag(),archivoForm.getAccion(),archivoForm.getIdArchivo(),usuarioBean);
		}else{
			res += cargaArchivoBO.cargaArchivoExcel(archivoForm.getArchivo(),archivoForm.getIdTipoArchivo(),
					archivoForm.getPag(),archivoForm.getAccion(),archivoForm.getIdArchivo(),usuarioBean);
		}
		res += "";
		
		try {
			
			response.setContentType("text/xml");
	        response.setHeader("Cache-Control", "no-cache"); 
	        response.setCharacterEncoding("utf-8");
            PrintWriter writer = response.getWriter();
            writer.print("<xml>"+res+"</xml>");
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
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
	private ActionForward consultArchivo(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		CargaArchivoForm archivoForm = (CargaArchivoForm) form;
		String res = "";
		res+="<cveRespuesta>1</cveRespuesta>";
		res += cargaArchivoBO.buscarArchivo(archivoForm.getIdTipoArchivo(), archivoForm.getIdArchivo(),archivoForm.getPag(),archivoForm.getAccion());
		res += "";
		try {
			response.setContentType("text/xml");
	        response.setHeader("Cache-Control", "no-cache"); 
	        response.setCharacterEncoding("utf-8");
            PrintWriter writer = response.getWriter();
            writer.print("<xml>"+res+"</xml>");
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
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
	private ActionForward buscaIdArchivo(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		CargaArchivoForm archivoForm = (CargaArchivoForm) form;
		String res = "";
		res+="";
		res += cargaArchivoBO.buscaIdArchivo(archivoForm.getIdTipoArchivo());
		res += "";
		
		try {
			
			response.setContentType("text/xml");
	        response.setHeader("Cache-Control", "no-cache"); 
	        response.setCharacterEncoding("utf-8");
            PrintWriter writer = response.getWriter();
            writer.print("<xml>"+res+"</xml>");
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
		
		return null;
	}
	
	/**
	 * @param usuarioBean 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @param usuarioBean
	 * @return
	 */
	private ActionForward eliminarArchivo(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, UserBean usuarioBean) {
		CargaArchivoForm archivoForm = (CargaArchivoForm) form;
		String res = "";
		res+="";
		res += cargaArchivoBO.eliminarArchivo(archivoForm.getIdTipoArchivo(), archivoForm.getIdArchivo(),usuarioBean);
		res += "";
		
		try {
			
			response.setContentType("text/xml");
	        response.setHeader("Cache-Control", "no-cache"); 
	        response.setCharacterEncoding("utf-8");
            PrintWriter writer = response.getWriter();
            writer.print("<xml>"+res+"</xml>");
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
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
	private ActionForward validarCargado(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		CargaArchivoForm archivoForm = (CargaArchivoForm) form;
		String res = "";
		res+="";
		res += cargaArchivoBO.validarExtArchivo(archivoForm.getIdTipoArchivo(), archivoForm.getIdArchivo());
		res += "";
		
		try {
			
			response.setContentType("text/xml");
	        response.setHeader("Cache-Control", "no-cache"); 
	        response.setCharacterEncoding("utf-8");
            PrintWriter writer = response.getWriter();
            writer.print("<xml>"+res+"</xml>");
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
		
		return null;
	}

	public CargaArchivoBO getCargaArchivoBO() {
		return cargaArchivoBO;
	}

	public void setCargaArchivoBO(CargaArchivoBO cargaArchivoBO) {
		this.cargaArchivoBO = cargaArchivoBO;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

}
