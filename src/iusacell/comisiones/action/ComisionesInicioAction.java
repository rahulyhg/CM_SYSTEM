/*
 * Creado el 24/02/2015
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package iusacell.comisiones.action;

import iusacell.comisiones.ayuda.UserBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

/**
 * @author jarredondoi
 *
 * TODO Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
public class ComisionesInicioAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6557374264712490273L;
	
	/* (sin Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		UserBean usuarioBean = (UserBean) request.getSession().getAttribute("usuarioSession");
		
		if(usuarioBean == null){
			return mapping.findForward("welcome"); 
		}
		// TODO Apéndice de método generado automáticamente
		return mapping.findForward("inicio");
	}
}
